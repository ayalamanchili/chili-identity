package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_entity_interfaceh implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$

    public _jet_entity_interfaceh() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_c_iterate_3_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            3, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_4_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            4, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_5_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            5, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_6_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            6, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_8_6 = new TagInfo("c:if", //$NON-NLS-1$
            8, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_10_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            10, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_11_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            11, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_13_14 = new TagInfo("c:if", //$NON-NLS-1$
            13, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_15_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            15, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_16_16 = new TagInfo("c:if", //$NON-NLS-1$
            16, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_18_13 = new TagInfo("c:if", //$NON-NLS-1$
            18, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_21_16 = new TagInfo("c:if", //$NON-NLS-1$
            21, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_22_18 = new TagInfo("c:if", //$NON-NLS-1$
            22, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_replaceStrings_23_8 = new TagInfo("c:replaceStrings", //$NON-NLS-1$
            23, 8,
            new String[] {
                "replace", //$NON-NLS-1$
                "with", //$NON-NLS-1$
            },
            new String[] {
                ".", //$NON-NLS-1$
                "_", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_27_17 = new TagInfo("c:if", //$NON-NLS-1$
            27, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_28_18 = new TagInfo("c:if", //$NON-NLS-1$
            28, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_42_1 = new TagInfo("c:if", //$NON-NLS-1$
            42, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@parent1 = $class/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_replaceStrings_42_59 = new TagInfo("c:replaceStrings", //$NON-NLS-1$
            42, 59,
            new String[] {
                "replace", //$NON-NLS-1$
                "with", //$NON-NLS-1$
            },
            new String[] {
                ".", //$NON-NLS-1$
                "_", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_replaceStrings_43_12 = new TagInfo("c:replaceStrings", //$NON-NLS-1$
            43, 12,
            new String[] {
                "replace", //$NON-NLS-1$
                "with", //$NON-NLS-1$
            },
            new String[] {
                ".", //$NON-NLS-1$
                "_", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_43_137 = new TagInfo("c:if", //$NON-NLS-1$
            43, 137,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@parentClass1Name = $class/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_43_208 = new TagInfo("c:if", //$NON-NLS-1$
            43, 208,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@parentClass1Name = $class/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_replaceStrings_43_267 = new TagInfo("c:replaceStrings", //$NON-NLS-1$
            43, 267,
            new String[] {
                "replace", //$NON-NLS-1$
                "with", //$NON-NLS-1$
            },
            new String[] {
                ".", //$NON-NLS-1$
                "_", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_44_1 = new TagInfo("c:if", //$NON-NLS-1$
            44, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@parentClass1Name = $class/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_48_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            48, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_49_3 = new TagInfo("c:choose", //$NON-NLS-1$
            49, 3,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_50_4 = new TagInfo("c:when", //$NON-NLS-1$
            50, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_53_4 = new TagInfo("c:when", //$NON-NLS-1$
            53, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_56_4 = new TagInfo("c:when", //$NON-NLS-1$
            56, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_59_4 = new TagInfo("c:when", //$NON-NLS-1$
            59, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_62_4 = new TagInfo("c:when", //$NON-NLS-1$
            62, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_65_4 = new TagInfo("c:when", //$NON-NLS-1$
            65, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_68_3 = new TagInfo("c:otherwise", //$NON-NLS-1$
            68, 3,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_69_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            69, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_70_6 = new TagInfo("c:if", //$NON-NLS-1$
            70, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_78_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            78, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_79_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            79, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_80_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            80, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_81_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            81, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_83_6 = new TagInfo("c:if", //$NON-NLS-1$
            83, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_85_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            85, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_86_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            86, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_88_14 = new TagInfo("c:if", //$NON-NLS-1$
            88, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_90_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            90, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_91_16 = new TagInfo("c:if", //$NON-NLS-1$
            91, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_93_13 = new TagInfo("c:if", //$NON-NLS-1$
            93, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_96_16 = new TagInfo("c:if", //$NON-NLS-1$
            96, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_97_18 = new TagInfo("c:if", //$NON-NLS-1$
            97, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_replaceStrings_98_3 = new TagInfo("c:replaceStrings", //$NON-NLS-1$
            98, 3,
            new String[] {
                "replace", //$NON-NLS-1$
                "with", //$NON-NLS-1$
            },
            new String[] {
                ".", //$NON-NLS-1$
                "_", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_102_17 = new TagInfo("c:if", //$NON-NLS-1$
            102, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_103_18 = new TagInfo("c:if", //$NON-NLS-1$
            103, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_118_1 = new TagInfo("c:if", //$NON-NLS-1$
            118, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@parentClass1Name = $class/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_122_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            122, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_123_3 = new TagInfo("c:choose", //$NON-NLS-1$
            123, 3,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_124_4 = new TagInfo("c:when", //$NON-NLS-1$
            124, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_127_4 = new TagInfo("c:when", //$NON-NLS-1$
            127, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_130_4 = new TagInfo("c:when", //$NON-NLS-1$
            130, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_133_4 = new TagInfo("c:when", //$NON-NLS-1$
            133, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_136_4 = new TagInfo("c:when", //$NON-NLS-1$
            136, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_139_4 = new TagInfo("c:when", //$NON-NLS-1$
            139, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_142_3 = new TagInfo("c:otherwise", //$NON-NLS-1$
            142, 3,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_143_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            143, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_144_6 = new TagInfo("c:if", //$NON-NLS-1$
            144, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_152_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            152, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_153_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            153, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_154_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            154, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_155_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            155, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_157_6 = new TagInfo("c:if", //$NON-NLS-1$
            157, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_159_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            159, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_160_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            160, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_162_14 = new TagInfo("c:if", //$NON-NLS-1$
            162, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_164_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            164, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_165_16 = new TagInfo("c:if", //$NON-NLS-1$
            165, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_167_13 = new TagInfo("c:if", //$NON-NLS-1$
            167, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_170_16 = new TagInfo("c:if", //$NON-NLS-1$
            170, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_171_18 = new TagInfo("c:if", //$NON-NLS-1$
            171, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_replaceStrings_172_32 = new TagInfo("c:replaceStrings", //$NON-NLS-1$
            172, 32,
            new String[] {
                "replace", //$NON-NLS-1$
                "with", //$NON-NLS-1$
            },
            new String[] {
                ".", //$NON-NLS-1$
                "_", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_176_17 = new TagInfo("c:if", //$NON-NLS-1$
            176, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_177_18 = new TagInfo("c:if", //$NON-NLS-1$
            177, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("#import <Foundation/Foundation.h>");  //$NON-NLS-1$        
        out.write(NL);         
        // collections and user defined Datatypes 
        RuntimeTagElement _jettag_c_iterate_3_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_3_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_3_1.setRuntimeParent(null);
        _jettag_c_iterate_3_1.setTagInfo(_td_c_iterate_3_1);
        _jettag_c_iterate_3_1.doStart(context, out);
        while (_jettag_c_iterate_3_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_4_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_4_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_4_2.setRuntimeParent(_jettag_c_iterate_3_1);
            _jettag_c_iterate_4_2.setTagInfo(_td_c_iterate_4_2);
            _jettag_c_iterate_4_2.doStart(context, out);
            while (_jettag_c_iterate_4_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_5_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_5_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_5_3.setRuntimeParent(_jettag_c_iterate_4_2);
                _jettag_c_iterate_5_3.setTagInfo(_td_c_iterate_5_3);
                _jettag_c_iterate_5_3.doStart(context, out);
                while (_jettag_c_iterate_5_3.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_6_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_6_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_6_4.setRuntimeParent(_jettag_c_iterate_5_3);
                    _jettag_c_setVariable_6_4.setTagInfo(_td_c_setVariable_6_4);
                    _jettag_c_setVariable_6_4.doStart(context, out);
                    _jettag_c_setVariable_6_4.doEnd();
                    // check is the association is corresponding to the class  
                    RuntimeTagElement _jettag_c_if_8_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_8_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_8_6.setRuntimeParent(_jettag_c_iterate_5_3);
                    _jettag_c_if_8_6.setTagInfo(_td_c_if_8_6);
                    _jettag_c_if_8_6.doStart(context, out);
                    while (_jettag_c_if_8_6.okToProcessBody()) {
                        // iterate over the iterations ends  
                        RuntimeTagElement _jettag_c_iterate_10_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_10_12); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_10_12.setRuntimeParent(_jettag_c_if_8_6);
                        _jettag_c_iterate_10_12.setTagInfo(_td_c_iterate_10_12);
                        _jettag_c_iterate_10_12.doStart(context, out);
                        while (_jettag_c_iterate_10_12.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_11_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_11_12); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_11_12.setRuntimeParent(_jettag_c_iterate_10_12);
                            _jettag_c_setVariable_11_12.setTagInfo(_td_c_setVariable_11_12);
                            _jettag_c_setVariable_11_12.doStart(context, out);
                            _jettag_c_setVariable_11_12.doEnd();
                            // get the end secondary end with other class  
                            RuntimeTagElement _jettag_c_if_13_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_13_14); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_13_14.setRuntimeParent(_jettag_c_iterate_10_12);
                            _jettag_c_if_13_14.setTagInfo(_td_c_if_13_14);
                            _jettag_c_if_13_14.doStart(context, out);
                            while (_jettag_c_if_13_14.okToProcessBody()) {
                                // iterate throught all the classes to get the other class on the association
                                RuntimeTagElement _jettag_c_iterate_15_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_15_15); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_15_15.setRuntimeParent(_jettag_c_if_13_14);
                                _jettag_c_iterate_15_15.setTagInfo(_td_c_iterate_15_15);
                                _jettag_c_iterate_15_15.doStart(context, out);
                                while (_jettag_c_iterate_15_15.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_16_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_16_16); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_16_16.setRuntimeParent(_jettag_c_iterate_15_15);
                                    _jettag_c_if_16_16.setTagInfo(_td_c_if_16_16);
                                    _jettag_c_if_16_16.doStart(context, out);
                                    while (_jettag_c_if_16_16.okToProcessBody()) {
                                        // check to see the association is navigable in the first case
                                        RuntimeTagElement _jettag_c_if_18_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_18_13); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_18_13.setRuntimeParent(_jettag_c_if_16_16);
                                        _jettag_c_if_18_13.setTagInfo(_td_c_if_18_13);
                                        _jettag_c_if_18_13.doStart(context, out);
                                        while (_jettag_c_if_18_13.okToProcessBody()) {
                                            // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                            // check if the multiplicityis one to one
                                            RuntimeTagElement _jettag_c_if_21_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_21_16); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_21_16.setRuntimeParent(_jettag_c_if_18_13);
                                            _jettag_c_if_21_16.setTagInfo(_td_c_if_21_16);
                                            _jettag_c_if_21_16.doStart(context, out);
                                            while (_jettag_c_if_21_16.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_22_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_22_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_22_18.setRuntimeParent(_jettag_c_if_21_16);
                                                _jettag_c_if_22_18.setTagInfo(_td_c_if_22_18);
                                                _jettag_c_if_22_18.doStart(context, out);
                                                while (_jettag_c_if_22_18.okToProcessBody()) {
                                                    out.write("@class ");  //$NON-NLS-1$        
                                                    RuntimeTagElement _jettag_c_replaceStrings_23_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "replaceStrings", "c:replaceStrings", _td_c_replaceStrings_23_8); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_replaceStrings_23_8.setRuntimeParent(_jettag_c_if_22_18);
                                                    _jettag_c_replaceStrings_23_8.setTagInfo(_td_c_replaceStrings_23_8);
                                                    _jettag_c_replaceStrings_23_8.doStart(context, out);
                                                    JET2Writer _jettag_c_replaceStrings_23_8_saved_out = out;
                                                    while (_jettag_c_replaceStrings_23_8.okToProcessBody()) {
                                                        out = out.newNestedContentWriter();
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 23, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_replaceStrings_23_8.handleBodyContent(out);
                                                    }
                                                    out = _jettag_c_replaceStrings_23_8_saved_out;
                                                    _jettag_c_replaceStrings_23_8.doEnd();
                                                    out.write("_entity_");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 23, 85)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write("_");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 23, 115)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(";");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    _jettag_c_if_22_18.handleBodyContent(out);
                                                }
                                                _jettag_c_if_22_18.doEnd();
                                                _jettag_c_if_21_16.handleBodyContent(out);
                                            }
                                            _jettag_c_if_21_16.doEnd();
                                            // check if the multiplicityis one to many
                                            RuntimeTagElement _jettag_c_if_27_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_27_17); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_27_17.setRuntimeParent(_jettag_c_if_18_13);
                                            _jettag_c_if_27_17.setTagInfo(_td_c_if_27_17);
                                            _jettag_c_if_27_17.doStart(context, out);
                                            while (_jettag_c_if_27_17.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_28_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_28_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_28_18.setRuntimeParent(_jettag_c_if_27_17);
                                                _jettag_c_if_28_18.setTagInfo(_td_c_if_28_18);
                                                _jettag_c_if_28_18.doStart(context, out);
                                                while (_jettag_c_if_28_18.okToProcessBody()) {
                                                    out.write("// TODO many relations  \t\t\t\t\t    \t\t\t\t\t\t");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    out.write(" //protected \tList<");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 30, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(">  ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 30, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write("s;");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    _jettag_c_if_28_18.handleBodyContent(out);
                                                }
                                                _jettag_c_if_28_18.doEnd();
                                                _jettag_c_if_27_17.handleBodyContent(out);
                                            }
                                            _jettag_c_if_27_17.doEnd();
                                            _jettag_c_if_18_13.handleBodyContent(out);
                                        }
                                        _jettag_c_if_18_13.doEnd();
                                        _jettag_c_if_16_16.handleBodyContent(out);
                                    }
                                    _jettag_c_if_16_16.doEnd();
                                    _jettag_c_iterate_15_15.handleBodyContent(out);
                                }
                                _jettag_c_iterate_15_15.doEnd();
                                _jettag_c_if_13_14.handleBodyContent(out);
                            }
                            _jettag_c_if_13_14.doEnd();
                            _jettag_c_iterate_10_12.handleBodyContent(out);
                        }
                        _jettag_c_iterate_10_12.doEnd();
                        _jettag_c_if_8_6.handleBodyContent(out);
                    }
                    _jettag_c_if_8_6.doEnd();
                    _jettag_c_iterate_5_3.handleBodyContent(out);
                }
                _jettag_c_iterate_5_3.doEnd();
                _jettag_c_iterate_4_2.handleBodyContent(out);
            }
            _jettag_c_iterate_4_2.doEnd();
            _jettag_c_iterate_3_1.handleBodyContent(out);
        }
        _jettag_c_iterate_3_1.doEnd();
        RuntimeTagElement _jettag_c_if_42_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_42_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_42_1.setRuntimeParent(null);
        _jettag_c_if_42_1.setTagInfo(_td_c_if_42_1);
        _jettag_c_if_42_1.doStart(context, out);
        while (_jettag_c_if_42_1.okToProcessBody()) {
            out.write(" #import\"");  //$NON-NLS-1$        
            RuntimeTagElement _jettag_c_replaceStrings_42_59 = context.getTagFactory().createRuntimeTag(_jetns_c, "replaceStrings", "c:replaceStrings", _td_c_replaceStrings_42_59); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_replaceStrings_42_59.setRuntimeParent(_jettag_c_if_42_1);
            _jettag_c_replaceStrings_42_59.setTagInfo(_td_c_replaceStrings_42_59);
            _jettag_c_replaceStrings_42_59.doStart(context, out);
            JET2Writer _jettag_c_replaceStrings_42_59_saved_out = out;
            while (_jettag_c_replaceStrings_42_59.okToProcessBody()) {
                out = out.newNestedContentWriter();
                out.write(context.embeddedExpressionAsString("${$groupID}", 42, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_replaceStrings_42_59.handleBodyContent(out);
            }
            out = _jettag_c_replaceStrings_42_59_saved_out;
            _jettag_c_replaceStrings_42_59.doEnd();
            out.write("_entity_");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 42, 136)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@parentClass1Name}", 42, 166)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".h\"; ");  //$NON-NLS-1$        
            _jettag_c_if_42_1.handleBodyContent(out);
        }
        _jettag_c_if_42_1.doEnd();
        out.write(NL);         
        out.write("@interface ");  //$NON-NLS-1$        
        RuntimeTagElement _jettag_c_replaceStrings_43_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "replaceStrings", "c:replaceStrings", _td_c_replaceStrings_43_12); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_replaceStrings_43_12.setRuntimeParent(null);
        _jettag_c_replaceStrings_43_12.setTagInfo(_td_c_replaceStrings_43_12);
        _jettag_c_replaceStrings_43_12.doStart(context, out);
        JET2Writer _jettag_c_replaceStrings_43_12_saved_out = out;
        while (_jettag_c_replaceStrings_43_12.okToProcessBody()) {
            out = out.newNestedContentWriter();
            out.write(context.embeddedExpressionAsString("${$groupID}", 43, 51)); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_replaceStrings_43_12.handleBodyContent(out);
        }
        out = _jettag_c_replaceStrings_43_12_saved_out;
        _jettag_c_replaceStrings_43_12.doEnd();
        out.write("_entity_");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 43, 89)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("_");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 43, 119)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(" : ");  //$NON-NLS-1$        
        RuntimeTagElement _jettag_c_if_43_137 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_43_137); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_43_137.setRuntimeParent(null);
        _jettag_c_if_43_137.setTagInfo(_td_c_if_43_137);
        _jettag_c_if_43_137.doStart(context, out);
        while (_jettag_c_if_43_137.okToProcessBody()) {
            out.write(" NSObject ");  //$NON-NLS-1$        
            _jettag_c_if_43_137.handleBodyContent(out);
        }
        _jettag_c_if_43_137.doEnd();
        out.write(" ");  //$NON-NLS-1$        
        RuntimeTagElement _jettag_c_if_43_208 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_43_208); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_43_208.setRuntimeParent(null);
        _jettag_c_if_43_208.setTagInfo(_td_c_if_43_208);
        _jettag_c_if_43_208.doStart(context, out);
        while (_jettag_c_if_43_208.okToProcessBody()) {
            out.write(" ");  //$NON-NLS-1$        
            RuntimeTagElement _jettag_c_replaceStrings_43_267 = context.getTagFactory().createRuntimeTag(_jetns_c, "replaceStrings", "c:replaceStrings", _td_c_replaceStrings_43_267); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_replaceStrings_43_267.setRuntimeParent(_jettag_c_if_43_208);
            _jettag_c_replaceStrings_43_267.setTagInfo(_td_c_replaceStrings_43_267);
            _jettag_c_replaceStrings_43_267.doStart(context, out);
            JET2Writer _jettag_c_replaceStrings_43_267_saved_out = out;
            while (_jettag_c_replaceStrings_43_267.okToProcessBody()) {
                out = out.newNestedContentWriter();
                out.write(context.embeddedExpressionAsString("${$groupID}", 43, 306)); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_replaceStrings_43_267.handleBodyContent(out);
            }
            out = _jettag_c_replaceStrings_43_267_saved_out;
            _jettag_c_replaceStrings_43_267.doEnd();
            out.write("_entity_");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 43, 344)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@parentClass1Name}", 43, 374)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" ");  //$NON-NLS-1$        
            _jettag_c_if_43_208.handleBodyContent(out);
        }
        _jettag_c_if_43_208.doEnd();
        out.write("{");  //$NON-NLS-1$        
        out.write(NL);         
        RuntimeTagElement _jettag_c_if_44_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_44_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_44_1.setRuntimeParent(null);
        _jettag_c_if_44_1.setTagInfo(_td_c_if_44_1);
        _jettag_c_if_44_1.doStart(context, out);
        while (_jettag_c_if_44_1.okToProcessBody()) {
            out.write("\tNSNumber *entityID; ");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_c_if_44_1.handleBodyContent(out);
        }
        _jettag_c_if_44_1.doEnd();
        // processes the premitive Datatypes and enums
        RuntimeTagElement _jettag_c_iterate_48_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_48_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_48_1.setRuntimeParent(null);
        _jettag_c_iterate_48_1.setTagInfo(_td_c_iterate_48_1);
        _jettag_c_iterate_48_1.doStart(context, out);
        while (_jettag_c_iterate_48_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_choose_49_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_49_3); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_choose_49_3.setRuntimeParent(_jettag_c_iterate_48_1);
            _jettag_c_choose_49_3.setTagInfo(_td_c_choose_49_3);
            _jettag_c_choose_49_3.doStart(context, out);
            JET2Writer _jettag_c_choose_49_3_saved_out = out;
            while (_jettag_c_choose_49_3.okToProcessBody()) {
                out = out.newNestedContentWriter();
                RuntimeTagElement _jettag_c_when_50_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_50_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_50_4.setRuntimeParent(_jettag_c_choose_49_3);
                _jettag_c_when_50_4.setTagInfo(_td_c_when_50_4);
                _jettag_c_when_50_4.doStart(context, out);
                JET2Writer _jettag_c_when_50_4_saved_out = out;
                while (_jettag_c_when_50_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t  NSString *");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 51, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(";");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_50_4.handleBodyContent(out);
                }
                out = _jettag_c_when_50_4_saved_out;
                _jettag_c_when_50_4.doEnd();
                RuntimeTagElement _jettag_c_when_53_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_53_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_53_4.setRuntimeParent(_jettag_c_choose_49_3);
                _jettag_c_when_53_4.setTagInfo(_td_c_when_53_4);
                _jettag_c_when_53_4.doStart(context, out);
                JET2Writer _jettag_c_when_53_4_saved_out = out;
                while (_jettag_c_when_53_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t   NSNumber *");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 54, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(";");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_53_4.handleBodyContent(out);
                }
                out = _jettag_c_when_53_4_saved_out;
                _jettag_c_when_53_4.doEnd();
                RuntimeTagElement _jettag_c_when_56_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_56_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_56_4.setRuntimeParent(_jettag_c_choose_49_3);
                _jettag_c_when_56_4.setTagInfo(_td_c_when_56_4);
                _jettag_c_when_56_4.doStart(context, out);
                JET2Writer _jettag_c_when_56_4_saved_out = out;
                while (_jettag_c_when_56_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t   NSDate *");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 57, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(";");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_56_4.handleBodyContent(out);
                }
                out = _jettag_c_when_56_4_saved_out;
                _jettag_c_when_56_4.doEnd();
                RuntimeTagElement _jettag_c_when_59_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_59_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_59_4.setRuntimeParent(_jettag_c_choose_49_3);
                _jettag_c_when_59_4.setTagInfo(_td_c_when_59_4);
                _jettag_c_when_59_4.doStart(context, out);
                JET2Writer _jettag_c_when_59_4_saved_out = out;
                while (_jettag_c_when_59_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t   Boolean ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 60, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(";");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_59_4.handleBodyContent(out);
                }
                out = _jettag_c_when_59_4_saved_out;
                _jettag_c_when_59_4.doEnd();
                RuntimeTagElement _jettag_c_when_62_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_62_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_62_4.setRuntimeParent(_jettag_c_choose_49_3);
                _jettag_c_when_62_4.setTagInfo(_td_c_when_62_4);
                _jettag_c_when_62_4.doStart(context, out);
                JET2Writer _jettag_c_when_62_4_saved_out = out;
                while (_jettag_c_when_62_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t   NSNumber *");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 63, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(";");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_62_4.handleBodyContent(out);
                }
                out = _jettag_c_when_62_4_saved_out;
                _jettag_c_when_62_4.doEnd();
                RuntimeTagElement _jettag_c_when_65_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_65_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_65_4.setRuntimeParent(_jettag_c_choose_49_3);
                _jettag_c_when_65_4.setTagInfo(_td_c_when_65_4);
                _jettag_c_when_65_4.doStart(context, out);
                JET2Writer _jettag_c_when_65_4_saved_out = out;
                while (_jettag_c_when_65_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t   NSDouble *");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 66, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(";");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_65_4.handleBodyContent(out);
                }
                out = _jettag_c_when_65_4_saved_out;
                _jettag_c_when_65_4.doEnd();
                RuntimeTagElement _jettag_c_otherwise_68_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_68_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_otherwise_68_3.setRuntimeParent(_jettag_c_choose_49_3);
                _jettag_c_otherwise_68_3.setTagInfo(_td_c_otherwise_68_3);
                _jettag_c_otherwise_68_3.doStart(context, out);
                JET2Writer _jettag_c_otherwise_68_3_saved_out = out;
                while (_jettag_c_otherwise_68_3.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_iterate_69_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_69_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_69_4.setRuntimeParent(_jettag_c_otherwise_68_3);
                    _jettag_c_iterate_69_4.setTagInfo(_td_c_iterate_69_4);
                    _jettag_c_iterate_69_4.doStart(context, out);
                    while (_jettag_c_iterate_69_4.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_if_70_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_70_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_70_6.setRuntimeParent(_jettag_c_iterate_69_4);
                        _jettag_c_if_70_6.setTagInfo(_td_c_if_70_6);
                        _jettag_c_if_70_6.doStart(context, out);
                        while (_jettag_c_if_70_6.okToProcessBody()) {
                            // add  enums support
                            _jettag_c_if_70_6.handleBodyContent(out);
                        }
                        _jettag_c_if_70_6.doEnd();
                        _jettag_c_iterate_69_4.handleBodyContent(out);
                    }
                    _jettag_c_iterate_69_4.doEnd();
                    _jettag_c_otherwise_68_3.handleBodyContent(out);
                }
                out = _jettag_c_otherwise_68_3_saved_out;
                _jettag_c_otherwise_68_3.doEnd();
                _jettag_c_choose_49_3.handleBodyContent(out);
            }
            out = _jettag_c_choose_49_3_saved_out;
            _jettag_c_choose_49_3.doEnd();
            _jettag_c_iterate_48_1.handleBodyContent(out);
        }
        _jettag_c_iterate_48_1.doEnd();
        // collections and user defined Datatypes 
        RuntimeTagElement _jettag_c_iterate_78_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_78_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_78_1.setRuntimeParent(null);
        _jettag_c_iterate_78_1.setTagInfo(_td_c_iterate_78_1);
        _jettag_c_iterate_78_1.doStart(context, out);
        while (_jettag_c_iterate_78_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_79_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_79_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_79_2.setRuntimeParent(_jettag_c_iterate_78_1);
            _jettag_c_iterate_79_2.setTagInfo(_td_c_iterate_79_2);
            _jettag_c_iterate_79_2.doStart(context, out);
            while (_jettag_c_iterate_79_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_80_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_80_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_80_3.setRuntimeParent(_jettag_c_iterate_79_2);
                _jettag_c_iterate_80_3.setTagInfo(_td_c_iterate_80_3);
                _jettag_c_iterate_80_3.doStart(context, out);
                while (_jettag_c_iterate_80_3.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_81_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_81_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_81_4.setRuntimeParent(_jettag_c_iterate_80_3);
                    _jettag_c_setVariable_81_4.setTagInfo(_td_c_setVariable_81_4);
                    _jettag_c_setVariable_81_4.doStart(context, out);
                    _jettag_c_setVariable_81_4.doEnd();
                    // check is the association is corresponding to the class  
                    RuntimeTagElement _jettag_c_if_83_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_83_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_83_6.setRuntimeParent(_jettag_c_iterate_80_3);
                    _jettag_c_if_83_6.setTagInfo(_td_c_if_83_6);
                    _jettag_c_if_83_6.doStart(context, out);
                    while (_jettag_c_if_83_6.okToProcessBody()) {
                        // iterate over the iterations ends  
                        RuntimeTagElement _jettag_c_iterate_85_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_85_12); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_85_12.setRuntimeParent(_jettag_c_if_83_6);
                        _jettag_c_iterate_85_12.setTagInfo(_td_c_iterate_85_12);
                        _jettag_c_iterate_85_12.doStart(context, out);
                        while (_jettag_c_iterate_85_12.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_86_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_86_12); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_86_12.setRuntimeParent(_jettag_c_iterate_85_12);
                            _jettag_c_setVariable_86_12.setTagInfo(_td_c_setVariable_86_12);
                            _jettag_c_setVariable_86_12.doStart(context, out);
                            _jettag_c_setVariable_86_12.doEnd();
                            // get the end secondary end with other class  
                            RuntimeTagElement _jettag_c_if_88_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_88_14); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_88_14.setRuntimeParent(_jettag_c_iterate_85_12);
                            _jettag_c_if_88_14.setTagInfo(_td_c_if_88_14);
                            _jettag_c_if_88_14.doStart(context, out);
                            while (_jettag_c_if_88_14.okToProcessBody()) {
                                // iterate throught all the classes to get the other class on the association
                                RuntimeTagElement _jettag_c_iterate_90_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_90_15); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_90_15.setRuntimeParent(_jettag_c_if_88_14);
                                _jettag_c_iterate_90_15.setTagInfo(_td_c_iterate_90_15);
                                _jettag_c_iterate_90_15.doStart(context, out);
                                while (_jettag_c_iterate_90_15.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_91_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_91_16); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_91_16.setRuntimeParent(_jettag_c_iterate_90_15);
                                    _jettag_c_if_91_16.setTagInfo(_td_c_if_91_16);
                                    _jettag_c_if_91_16.doStart(context, out);
                                    while (_jettag_c_if_91_16.okToProcessBody()) {
                                        // check to see the association is navigable in the first case
                                        RuntimeTagElement _jettag_c_if_93_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_93_13); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_93_13.setRuntimeParent(_jettag_c_if_91_16);
                                        _jettag_c_if_93_13.setTagInfo(_td_c_if_93_13);
                                        _jettag_c_if_93_13.doStart(context, out);
                                        while (_jettag_c_if_93_13.okToProcessBody()) {
                                            // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                            // check if the multiplicityis one to one
                                            RuntimeTagElement _jettag_c_if_96_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_96_16); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_96_16.setRuntimeParent(_jettag_c_if_93_13);
                                            _jettag_c_if_96_16.setTagInfo(_td_c_if_96_16);
                                            _jettag_c_if_96_16.doStart(context, out);
                                            while (_jettag_c_if_96_16.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_97_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_97_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_97_18.setRuntimeParent(_jettag_c_if_96_16);
                                                _jettag_c_if_97_18.setTagInfo(_td_c_if_97_18);
                                                _jettag_c_if_97_18.doStart(context, out);
                                                while (_jettag_c_if_97_18.okToProcessBody()) {
                                                    out.write("\t\t");  //$NON-NLS-1$        
                                                    RuntimeTagElement _jettag_c_replaceStrings_98_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "replaceStrings", "c:replaceStrings", _td_c_replaceStrings_98_3); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_replaceStrings_98_3.setRuntimeParent(_jettag_c_if_97_18);
                                                    _jettag_c_replaceStrings_98_3.setTagInfo(_td_c_replaceStrings_98_3);
                                                    _jettag_c_replaceStrings_98_3.doStart(context, out);
                                                    JET2Writer _jettag_c_replaceStrings_98_3_saved_out = out;
                                                    while (_jettag_c_replaceStrings_98_3.okToProcessBody()) {
                                                        out = out.newNestedContentWriter();
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 98, 42)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_replaceStrings_98_3.handleBodyContent(out);
                                                    }
                                                    out = _jettag_c_replaceStrings_98_3_saved_out;
                                                    _jettag_c_replaceStrings_98_3.doEnd();
                                                    out.write("_entity_");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 98, 80)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write("_");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 98, 110)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write("  *");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 98, 129)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(";");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    _jettag_c_if_97_18.handleBodyContent(out);
                                                }
                                                _jettag_c_if_97_18.doEnd();
                                                _jettag_c_if_96_16.handleBodyContent(out);
                                            }
                                            _jettag_c_if_96_16.doEnd();
                                            // check if the multiplicityis one to many
                                            RuntimeTagElement _jettag_c_if_102_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_102_17); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_102_17.setRuntimeParent(_jettag_c_if_93_13);
                                            _jettag_c_if_102_17.setTagInfo(_td_c_if_102_17);
                                            _jettag_c_if_102_17.doStart(context, out);
                                            while (_jettag_c_if_102_17.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_103_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_103_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_103_18.setRuntimeParent(_jettag_c_if_102_17);
                                                _jettag_c_if_103_18.setTagInfo(_td_c_if_103_18);
                                                _jettag_c_if_103_18.doStart(context, out);
                                                while (_jettag_c_if_103_18.okToProcessBody()) {
                                                    out.write("// TODO many relations  \t\t\t\t\t    \t\t\t\t\t\t");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    out.write(" //protected \tList<");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 105, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(">  ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 105, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write("s;");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    _jettag_c_if_103_18.handleBodyContent(out);
                                                }
                                                _jettag_c_if_103_18.doEnd();
                                                _jettag_c_if_102_17.handleBodyContent(out);
                                            }
                                            _jettag_c_if_102_17.doEnd();
                                            _jettag_c_if_93_13.handleBodyContent(out);
                                        }
                                        _jettag_c_if_93_13.doEnd();
                                        _jettag_c_if_91_16.handleBodyContent(out);
                                    }
                                    _jettag_c_if_91_16.doEnd();
                                    _jettag_c_iterate_90_15.handleBodyContent(out);
                                }
                                _jettag_c_iterate_90_15.doEnd();
                                _jettag_c_if_88_14.handleBodyContent(out);
                            }
                            _jettag_c_if_88_14.doEnd();
                            _jettag_c_iterate_85_12.handleBodyContent(out);
                        }
                        _jettag_c_iterate_85_12.doEnd();
                        _jettag_c_if_83_6.handleBodyContent(out);
                    }
                    _jettag_c_if_83_6.doEnd();
                    _jettag_c_iterate_80_3.handleBodyContent(out);
                }
                _jettag_c_iterate_80_3.doEnd();
                _jettag_c_iterate_79_2.handleBodyContent(out);
            }
            _jettag_c_iterate_79_2.doEnd();
            _jettag_c_iterate_78_1.handleBodyContent(out);
        }
        _jettag_c_iterate_78_1.doEnd();
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        RuntimeTagElement _jettag_c_if_118_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_118_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_118_1.setRuntimeParent(null);
        _jettag_c_if_118_1.setTagInfo(_td_c_if_118_1);
        _jettag_c_if_118_1.doStart(context, out);
        while (_jettag_c_if_118_1.okToProcessBody()) {
            out.write("\t@property (nonatomic,retain) NSNumber *entityID; ");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_c_if_118_1.handleBodyContent(out);
        }
        _jettag_c_if_118_1.doEnd();
        // processes the premitive Datatypes and enums
        RuntimeTagElement _jettag_c_iterate_122_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_122_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_122_1.setRuntimeParent(null);
        _jettag_c_iterate_122_1.setTagInfo(_td_c_iterate_122_1);
        _jettag_c_iterate_122_1.doStart(context, out);
        while (_jettag_c_iterate_122_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_choose_123_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_123_3); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_choose_123_3.setRuntimeParent(_jettag_c_iterate_122_1);
            _jettag_c_choose_123_3.setTagInfo(_td_c_choose_123_3);
            _jettag_c_choose_123_3.doStart(context, out);
            JET2Writer _jettag_c_choose_123_3_saved_out = out;
            while (_jettag_c_choose_123_3.okToProcessBody()) {
                out = out.newNestedContentWriter();
                RuntimeTagElement _jettag_c_when_124_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_124_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_124_4.setRuntimeParent(_jettag_c_choose_123_3);
                _jettag_c_when_124_4.setTagInfo(_td_c_when_124_4);
                _jettag_c_when_124_4.doStart(context, out);
                JET2Writer _jettag_c_when_124_4_saved_out = out;
                while (_jettag_c_when_124_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t  @property (nonatomic,retain) NSString *");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 125, 43)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(";");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_124_4.handleBodyContent(out);
                }
                out = _jettag_c_when_124_4_saved_out;
                _jettag_c_when_124_4.doEnd();
                RuntimeTagElement _jettag_c_when_127_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_127_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_127_4.setRuntimeParent(_jettag_c_choose_123_3);
                _jettag_c_when_127_4.setTagInfo(_td_c_when_127_4);
                _jettag_c_when_127_4.doStart(context, out);
                JET2Writer _jettag_c_when_127_4_saved_out = out;
                while (_jettag_c_when_127_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t  @property (nonatomic,retain) NSNumber *");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 128, 43)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(";");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_127_4.handleBodyContent(out);
                }
                out = _jettag_c_when_127_4_saved_out;
                _jettag_c_when_127_4.doEnd();
                RuntimeTagElement _jettag_c_when_130_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_130_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_130_4.setRuntimeParent(_jettag_c_choose_123_3);
                _jettag_c_when_130_4.setTagInfo(_td_c_when_130_4);
                _jettag_c_when_130_4.doStart(context, out);
                JET2Writer _jettag_c_when_130_4_saved_out = out;
                while (_jettag_c_when_130_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t  @property (nonatomic,retain)  NSDate *");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 131, 42)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(";");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_130_4.handleBodyContent(out);
                }
                out = _jettag_c_when_130_4_saved_out;
                _jettag_c_when_130_4.doEnd();
                RuntimeTagElement _jettag_c_when_133_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_133_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_133_4.setRuntimeParent(_jettag_c_choose_123_3);
                _jettag_c_when_133_4.setTagInfo(_td_c_when_133_4);
                _jettag_c_when_133_4.doStart(context, out);
                JET2Writer _jettag_c_when_133_4_saved_out = out;
                while (_jettag_c_when_133_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t  @property Boolean ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 134, 22)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(";");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_133_4.handleBodyContent(out);
                }
                out = _jettag_c_when_133_4_saved_out;
                _jettag_c_when_133_4.doEnd();
                RuntimeTagElement _jettag_c_when_136_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_136_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_136_4.setRuntimeParent(_jettag_c_choose_123_3);
                _jettag_c_when_136_4.setTagInfo(_td_c_when_136_4);
                _jettag_c_when_136_4.doStart(context, out);
                JET2Writer _jettag_c_when_136_4_saved_out = out;
                while (_jettag_c_when_136_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t   @property (nonatomic,retain) NSNumber *");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 137, 44)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(";");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_136_4.handleBodyContent(out);
                }
                out = _jettag_c_when_136_4_saved_out;
                _jettag_c_when_136_4.doEnd();
                RuntimeTagElement _jettag_c_when_139_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_139_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_139_4.setRuntimeParent(_jettag_c_choose_123_3);
                _jettag_c_when_139_4.setTagInfo(_td_c_when_139_4);
                _jettag_c_when_139_4.doStart(context, out);
                JET2Writer _jettag_c_when_139_4_saved_out = out;
                while (_jettag_c_when_139_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t  @property (nonatomic,retain) NSDouble *");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 140, 43)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(";");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_139_4.handleBodyContent(out);
                }
                out = _jettag_c_when_139_4_saved_out;
                _jettag_c_when_139_4.doEnd();
                RuntimeTagElement _jettag_c_otherwise_142_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_142_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_otherwise_142_3.setRuntimeParent(_jettag_c_choose_123_3);
                _jettag_c_otherwise_142_3.setTagInfo(_td_c_otherwise_142_3);
                _jettag_c_otherwise_142_3.doStart(context, out);
                JET2Writer _jettag_c_otherwise_142_3_saved_out = out;
                while (_jettag_c_otherwise_142_3.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_iterate_143_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_143_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_143_4.setRuntimeParent(_jettag_c_otherwise_142_3);
                    _jettag_c_iterate_143_4.setTagInfo(_td_c_iterate_143_4);
                    _jettag_c_iterate_143_4.doStart(context, out);
                    while (_jettag_c_iterate_143_4.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_if_144_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_144_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_144_6.setRuntimeParent(_jettag_c_iterate_143_4);
                        _jettag_c_if_144_6.setTagInfo(_td_c_if_144_6);
                        _jettag_c_if_144_6.doStart(context, out);
                        while (_jettag_c_if_144_6.okToProcessBody()) {
                            // add  enums support
                            _jettag_c_if_144_6.handleBodyContent(out);
                        }
                        _jettag_c_if_144_6.doEnd();
                        _jettag_c_iterate_143_4.handleBodyContent(out);
                    }
                    _jettag_c_iterate_143_4.doEnd();
                    _jettag_c_otherwise_142_3.handleBodyContent(out);
                }
                out = _jettag_c_otherwise_142_3_saved_out;
                _jettag_c_otherwise_142_3.doEnd();
                _jettag_c_choose_123_3.handleBodyContent(out);
            }
            out = _jettag_c_choose_123_3_saved_out;
            _jettag_c_choose_123_3.doEnd();
            _jettag_c_iterate_122_1.handleBodyContent(out);
        }
        _jettag_c_iterate_122_1.doEnd();
        // collections and user defined Datatypes 
        RuntimeTagElement _jettag_c_iterate_152_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_152_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_152_1.setRuntimeParent(null);
        _jettag_c_iterate_152_1.setTagInfo(_td_c_iterate_152_1);
        _jettag_c_iterate_152_1.doStart(context, out);
        while (_jettag_c_iterate_152_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_153_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_153_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_153_2.setRuntimeParent(_jettag_c_iterate_152_1);
            _jettag_c_iterate_153_2.setTagInfo(_td_c_iterate_153_2);
            _jettag_c_iterate_153_2.doStart(context, out);
            while (_jettag_c_iterate_153_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_154_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_154_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_154_3.setRuntimeParent(_jettag_c_iterate_153_2);
                _jettag_c_iterate_154_3.setTagInfo(_td_c_iterate_154_3);
                _jettag_c_iterate_154_3.doStart(context, out);
                while (_jettag_c_iterate_154_3.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_155_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_155_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_155_4.setRuntimeParent(_jettag_c_iterate_154_3);
                    _jettag_c_setVariable_155_4.setTagInfo(_td_c_setVariable_155_4);
                    _jettag_c_setVariable_155_4.doStart(context, out);
                    _jettag_c_setVariable_155_4.doEnd();
                    // check is the association is corresponding to the class  
                    RuntimeTagElement _jettag_c_if_157_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_157_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_157_6.setRuntimeParent(_jettag_c_iterate_154_3);
                    _jettag_c_if_157_6.setTagInfo(_td_c_if_157_6);
                    _jettag_c_if_157_6.doStart(context, out);
                    while (_jettag_c_if_157_6.okToProcessBody()) {
                        // iterate over the iterations ends  
                        RuntimeTagElement _jettag_c_iterate_159_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_159_12); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_159_12.setRuntimeParent(_jettag_c_if_157_6);
                        _jettag_c_iterate_159_12.setTagInfo(_td_c_iterate_159_12);
                        _jettag_c_iterate_159_12.doStart(context, out);
                        while (_jettag_c_iterate_159_12.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_160_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_160_12); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_160_12.setRuntimeParent(_jettag_c_iterate_159_12);
                            _jettag_c_setVariable_160_12.setTagInfo(_td_c_setVariable_160_12);
                            _jettag_c_setVariable_160_12.doStart(context, out);
                            _jettag_c_setVariable_160_12.doEnd();
                            // get the end secondary end with other class  
                            RuntimeTagElement _jettag_c_if_162_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_162_14); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_162_14.setRuntimeParent(_jettag_c_iterate_159_12);
                            _jettag_c_if_162_14.setTagInfo(_td_c_if_162_14);
                            _jettag_c_if_162_14.doStart(context, out);
                            while (_jettag_c_if_162_14.okToProcessBody()) {
                                // iterate throught all the classes to get the other class on the association
                                RuntimeTagElement _jettag_c_iterate_164_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_164_15); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_164_15.setRuntimeParent(_jettag_c_if_162_14);
                                _jettag_c_iterate_164_15.setTagInfo(_td_c_iterate_164_15);
                                _jettag_c_iterate_164_15.doStart(context, out);
                                while (_jettag_c_iterate_164_15.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_165_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_165_16); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_165_16.setRuntimeParent(_jettag_c_iterate_164_15);
                                    _jettag_c_if_165_16.setTagInfo(_td_c_if_165_16);
                                    _jettag_c_if_165_16.doStart(context, out);
                                    while (_jettag_c_if_165_16.okToProcessBody()) {
                                        // check to see the association is navigable in the first case
                                        RuntimeTagElement _jettag_c_if_167_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_167_13); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_167_13.setRuntimeParent(_jettag_c_if_165_16);
                                        _jettag_c_if_167_13.setTagInfo(_td_c_if_167_13);
                                        _jettag_c_if_167_13.doStart(context, out);
                                        while (_jettag_c_if_167_13.okToProcessBody()) {
                                            // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                            // check if the multiplicityis one to one
                                            RuntimeTagElement _jettag_c_if_170_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_170_16); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_170_16.setRuntimeParent(_jettag_c_if_167_13);
                                            _jettag_c_if_170_16.setTagInfo(_td_c_if_170_16);
                                            _jettag_c_if_170_16.doStart(context, out);
                                            while (_jettag_c_if_170_16.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_171_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_171_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_171_18.setRuntimeParent(_jettag_c_if_170_16);
                                                _jettag_c_if_171_18.setTagInfo(_td_c_if_171_18);
                                                _jettag_c_if_171_18.doStart(context, out);
                                                while (_jettag_c_if_171_18.okToProcessBody()) {
                                                    out.write("\t\t@property (nonatomic,retain) ");  //$NON-NLS-1$        
                                                    RuntimeTagElement _jettag_c_replaceStrings_172_32 = context.getTagFactory().createRuntimeTag(_jetns_c, "replaceStrings", "c:replaceStrings", _td_c_replaceStrings_172_32); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_replaceStrings_172_32.setRuntimeParent(_jettag_c_if_171_18);
                                                    _jettag_c_replaceStrings_172_32.setTagInfo(_td_c_replaceStrings_172_32);
                                                    _jettag_c_replaceStrings_172_32.doStart(context, out);
                                                    JET2Writer _jettag_c_replaceStrings_172_32_saved_out = out;
                                                    while (_jettag_c_replaceStrings_172_32.okToProcessBody()) {
                                                        out = out.newNestedContentWriter();
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 172, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_replaceStrings_172_32.handleBodyContent(out);
                                                    }
                                                    out = _jettag_c_replaceStrings_172_32_saved_out;
                                                    _jettag_c_replaceStrings_172_32.doEnd();
                                                    out.write("_entity_");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 172, 109)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write("_");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 172, 139)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write("  *");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 172, 158)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(";");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    _jettag_c_if_171_18.handleBodyContent(out);
                                                }
                                                _jettag_c_if_171_18.doEnd();
                                                _jettag_c_if_170_16.handleBodyContent(out);
                                            }
                                            _jettag_c_if_170_16.doEnd();
                                            // check if the multiplicityis one to many
                                            RuntimeTagElement _jettag_c_if_176_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_176_17); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_176_17.setRuntimeParent(_jettag_c_if_167_13);
                                            _jettag_c_if_176_17.setTagInfo(_td_c_if_176_17);
                                            _jettag_c_if_176_17.doStart(context, out);
                                            while (_jettag_c_if_176_17.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_177_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_177_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_177_18.setRuntimeParent(_jettag_c_if_176_17);
                                                _jettag_c_if_177_18.setTagInfo(_td_c_if_177_18);
                                                _jettag_c_if_177_18.doStart(context, out);
                                                while (_jettag_c_if_177_18.okToProcessBody()) {
                                                    out.write("// TODO many relations  \t\t\t\t\t    \t\t\t\t\t\t");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    out.write(" //protected \tList<");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 179, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(">  ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 179, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write("s;");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    _jettag_c_if_177_18.handleBodyContent(out);
                                                }
                                                _jettag_c_if_177_18.doEnd();
                                                _jettag_c_if_176_17.handleBodyContent(out);
                                            }
                                            _jettag_c_if_176_17.doEnd();
                                            _jettag_c_if_167_13.handleBodyContent(out);
                                        }
                                        _jettag_c_if_167_13.doEnd();
                                        _jettag_c_if_165_16.handleBodyContent(out);
                                    }
                                    _jettag_c_if_165_16.doEnd();
                                    _jettag_c_iterate_164_15.handleBodyContent(out);
                                }
                                _jettag_c_iterate_164_15.doEnd();
                                _jettag_c_if_162_14.handleBodyContent(out);
                            }
                            _jettag_c_if_162_14.doEnd();
                            _jettag_c_iterate_159_12.handleBodyContent(out);
                        }
                        _jettag_c_iterate_159_12.doEnd();
                        _jettag_c_if_157_6.handleBodyContent(out);
                    }
                    _jettag_c_if_157_6.doEnd();
                    _jettag_c_iterate_154_3.handleBodyContent(out);
                }
                _jettag_c_iterate_154_3.doEnd();
                _jettag_c_iterate_153_2.handleBodyContent(out);
            }
            _jettag_c_iterate_153_2.doEnd();
            _jettag_c_iterate_152_1.handleBodyContent(out);
        }
        _jettag_c_iterate_152_1.doEnd();
        out.write("@end");  //$NON-NLS-1$        
    }
}
