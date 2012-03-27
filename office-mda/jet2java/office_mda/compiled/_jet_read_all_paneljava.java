package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_read_all_paneljava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_read_all_paneljava() {
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
    private static final TagInfo _td_c_if_9_1 = new TagInfo("c:if", //$NON-NLS-1$
            9, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isDependent = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_18_1 = new TagInfo("f:message", //$NON-NLS-1$
            18, 1,
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
    private static final TagInfo _td_c_if_23_1 = new TagInfo("c:if", //$NON-NLS-1$
            23, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isDependent = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_24_1 = new TagInfo("f:message", //$NON-NLS-1$
            24, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_28_1 = new TagInfo("f:message", //$NON-NLS-1$
            28, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_34_1 = new TagInfo("f:message", //$NON-NLS-1$
            34, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_41_1 = new TagInfo("f:message", //$NON-NLS-1$
            41, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_49_1 = new TagInfo("c:if", //$NON-NLS-1$
            49, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_50_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            50, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_55_1 = new TagInfo("c:if", //$NON-NLS-1$
            55, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_56_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            56, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_61_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            61, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_65_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            65, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_66_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            66, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_67_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            67, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_68_7 = new TagInfo("c:setVariable", //$NON-NLS-1$
            68, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_70_9 = new TagInfo("c:if", //$NON-NLS-1$
            70, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_72_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            72, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_73_15 = new TagInfo("c:setVariable", //$NON-NLS-1$
            73, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_75_17 = new TagInfo("c:if", //$NON-NLS-1$
            75, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_77_18 = new TagInfo("c:iterate", //$NON-NLS-1$
            77, 18,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_78_19 = new TagInfo("c:if", //$NON-NLS-1$
            78, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_81_19 = new TagInfo("c:if", //$NON-NLS-1$
            81, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_82_21 = new TagInfo("c:if", //$NON-NLS-1$
            82, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_84_21 = new TagInfo("c:if", //$NON-NLS-1$
            84, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'false'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_88_21 = new TagInfo("c:if", //$NON-NLS-1$
            88, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_89_21 = new TagInfo("c:if", //$NON-NLS-1$
            89, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_104_1 = new TagInfo("f:message", //$NON-NLS-1$
            104, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_114_4 = new TagInfo("c:if", //$NON-NLS-1$
            114, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_115_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            115, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_116_8 = new TagInfo("c:choose", //$NON-NLS-1$
            116, 8,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_117_9 = new TagInfo("c:when", //$NON-NLS-1$
            117, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_120_9 = new TagInfo("c:when", //$NON-NLS-1$
            120, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_124_9 = new TagInfo("c:when", //$NON-NLS-1$
            124, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_127_9 = new TagInfo("c:when", //$NON-NLS-1$
            127, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_130_9 = new TagInfo("c:otherwise", //$NON-NLS-1$
            130, 9,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_137_4 = new TagInfo("c:if", //$NON-NLS-1$
            137, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_138_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            138, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_139_14 = new TagInfo("c:choose", //$NON-NLS-1$
            139, 14,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_140_9 = new TagInfo("c:when", //$NON-NLS-1$
            140, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_143_9 = new TagInfo("c:when", //$NON-NLS-1$
            143, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_147_9 = new TagInfo("c:when", //$NON-NLS-1$
            147, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_150_9 = new TagInfo("c:when", //$NON-NLS-1$
            150, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_153_9 = new TagInfo("c:otherwise", //$NON-NLS-1$
            153, 9,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_160_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            160, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_161_8 = new TagInfo("c:choose", //$NON-NLS-1$
            161, 8,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_162_9 = new TagInfo("c:when", //$NON-NLS-1$
            162, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_165_9 = new TagInfo("c:when", //$NON-NLS-1$
            165, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_169_9 = new TagInfo("c:when", //$NON-NLS-1$
            169, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_172_9 = new TagInfo("c:when", //$NON-NLS-1$
            172, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_175_9 = new TagInfo("c:otherwise", //$NON-NLS-1$
            175, 9,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_181_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            181, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_182_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            182, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_183_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            183, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_184_7 = new TagInfo("c:setVariable", //$NON-NLS-1$
            184, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_186_9 = new TagInfo("c:if", //$NON-NLS-1$
            186, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_188_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            188, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_189_15 = new TagInfo("c:setVariable", //$NON-NLS-1$
            189, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_191_17 = new TagInfo("c:if", //$NON-NLS-1$
            191, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_193_18 = new TagInfo("c:iterate", //$NON-NLS-1$
            193, 18,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_194_19 = new TagInfo("c:if", //$NON-NLS-1$
            194, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_197_19 = new TagInfo("c:if", //$NON-NLS-1$
            197, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_198_21 = new TagInfo("c:if", //$NON-NLS-1$
            198, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_200_21 = new TagInfo("c:if", //$NON-NLS-1$
            200, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'false'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_204_21 = new TagInfo("c:if", //$NON-NLS-1$
            204, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_205_21 = new TagInfo("c:if", //$NON-NLS-1$
            205, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_223_1 = new TagInfo("f:message", //$NON-NLS-1$
            223, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_229_1 = new TagInfo("f:message", //$NON-NLS-1$
            229, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_240_1 = new TagInfo("c:if", //$NON-NLS-1$
            240, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isDependent = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_241_1 = new TagInfo("f:message", //$NON-NLS-1$
            241, 1,
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
                out.write("package ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$packageName}", 5, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 5, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$webPackage}", 7, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 7, 22)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome;");  //$NON-NLS-1$        
                out.write(NL);         
                // add these only for composites
                RuntimeTagElement _jettag_c_if_9_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_9_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_9_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_9_1.setTagInfo(_td_c_if_9_1);
                _jettag_c_if_9_1.doStart(context, out);
                while (_jettag_c_if_9_1.okToProcessBody()) {
                    out.write("import info.yalamanchili.gwt.composite.TreePanelCompositey;");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_9_1.handleBodyContent(out);
                }
                _jettag_c_if_9_1.doEnd();
                out.write("import info.yalamanchili.gwt.composite.ReadAllCompositey;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.utils.Utils;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.fields.*;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.web.bindery.requestfactory.shared.Receiver;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.List;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_18_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_18_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_18_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_18_1.setTagInfo(_td_f_message_18_1);
                _jettag_f_message_18_1.doStart(context, out);
                JET2Writer _jettag_f_message_18_1_saved_out = out;
                while (_jettag_f_message_18_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_18_1.handleBodyContent(out);
                }
                out = _jettag_f_message_18_1_saved_out;
                _jettag_f_message_18_1.doEnd();
                out.write(NL);         
                out.write("public class ReadAll");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 19, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("sPanely extends ReadAllCompositey<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 19, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Proxy> {");  //$NON-NLS-1$        
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
                out.write(NL);         
                out.write("\tpublic static ReadAll");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 21, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("sPanely instance;");  //$NON-NLS-1$        
                out.write(NL);         
                // add these only for composites
                RuntimeTagElement _jettag_c_if_23_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_23_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_23_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_23_1.setTagInfo(_td_c_if_23_1);
                _jettag_c_if_23_1.doStart(context, out);
                while (_jettag_c_if_23_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_f_message_24_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_24_1); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_f_message_24_1.setRuntimeParent(_jettag_c_if_23_1);
                    _jettag_f_message_24_1.setTagInfo(_td_f_message_24_1);
                    _jettag_f_message_24_1.doStart(context, out);
                    JET2Writer _jettag_f_message_24_1_saved_out = out;
                    while (_jettag_f_message_24_1.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("generated.comment");  //$NON-NLS-1$        
                        _jettag_f_message_24_1.handleBodyContent(out);
                    }
                    out = _jettag_f_message_24_1_saved_out;
                    _jettag_f_message_24_1.doEnd();
                    out.write("\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\tpublic TreePanelCompositey parentTree;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\tpublic String parentTreeClass;");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_23_1.handleBodyContent(out);
                }
                _jettag_c_if_23_1.doEnd();
                RuntimeTagElement _jettag_f_message_28_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_28_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_28_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_28_1.setTagInfo(_td_f_message_28_1);
                _jettag_f_message_28_1.doStart(context, out);
                JET2Writer _jettag_f_message_28_1_saved_out = out;
                while (_jettag_f_message_28_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_28_1.handleBodyContent(out);
                }
                out = _jettag_f_message_28_1_saved_out;
                _jettag_f_message_28_1.doEnd();
                out.write(NL);         
                out.write("\tpublic ReadAll");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 29, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("sPanely(List<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 29, 44)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Proxy> proxys) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinstance=this;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinitTable(\"");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 31, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("\", proxys, ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 31, 40)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.constants);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_34_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_34_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_34_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_34_1.setTagInfo(_td_f_message_34_1);
                _jettag_f_message_34_1.doStart(context, out);
                JET2Writer _jettag_f_message_34_1_saved_out = out;
                while (_jettag_f_message_34_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_34_1.handleBodyContent(out);
                }
                out = _jettag_f_message_34_1_saved_out;
                _jettag_f_message_34_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic ReadAll");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 35, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("sPanely(ReadAllTableType tableType) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinstance=this;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tthis.tableType = tableType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinitTable(\"");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 38, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("\",");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 39, 5)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.constants);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_41_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_41_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_41_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_41_1.setTagInfo(_td_f_message_41_1);
                _jettag_f_message_41_1.doStart(context, out);
                JET2Writer _jettag_f_message_41_1_saved_out = out;
                while (_jettag_f_message_41_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_41_1.handleBodyContent(out);
                }
                out = _jettag_f_message_41_1_saved_out;
                _jettag_f_message_41_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void createTableHeader() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\ttable.setText(0, 0, getKeyValue(\"Table_Action\"));\t");  //$NON-NLS-1$        
                out.write(NL);         
        
        		int x = 1;
        		
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_49_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_49_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_49_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_49_1.setTagInfo(_td_c_if_49_1);
                _jettag_c_if_49_1.doStart(context, out);
                while (_jettag_c_if_49_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_50_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_50_1); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_50_1.setRuntimeParent(_jettag_c_if_49_1);
                    _jettag_c_iterate_50_1.setTagInfo(_td_c_iterate_50_1);
                    _jettag_c_iterate_50_1.doStart(context, out);
                    while (_jettag_c_iterate_50_1.okToProcessBody()) {
                        out.write("\t\t\ttable.setText(0, ");  //$NON-NLS-1$        
                        out.write( x++ );
                        out.write(", getClassValue(\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 51, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"));");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_iterate_50_1.handleBodyContent(out);
                    }
                    _jettag_c_iterate_50_1.doEnd();
                    _jettag_c_if_49_1.handleBodyContent(out);
                }
                _jettag_c_if_49_1.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_55_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_55_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_55_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_55_1.setTagInfo(_td_c_if_55_1);
                _jettag_c_if_55_1.doStart(context, out);
                while (_jettag_c_if_55_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_56_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_56_1); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_56_1.setRuntimeParent(_jettag_c_if_55_1);
                    _jettag_c_iterate_56_1.setTagInfo(_td_c_iterate_56_1);
                    _jettag_c_iterate_56_1.doStart(context, out);
                    while (_jettag_c_iterate_56_1.okToProcessBody()) {
                        out.write("\t\t\ttable.setText(0, ");  //$NON-NLS-1$        
                        out.write( x++ );
                        out.write(", getClassValue(\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 57, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"));");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_iterate_56_1.handleBodyContent(out);
                    }
                    _jettag_c_iterate_56_1.doEnd();
                    _jettag_c_if_55_1.handleBodyContent(out);
                }
                _jettag_c_if_55_1.doEnd();
                // process base class attributes
                RuntimeTagElement _jettag_c_iterate_61_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_61_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_61_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_61_1.setTagInfo(_td_c_iterate_61_1);
                _jettag_c_iterate_61_1.doStart(context, out);
                while (_jettag_c_iterate_61_1.okToProcessBody()) {
                    out.write("\t\t\ttable.setText(0, ");  //$NON-NLS-1$        
                    out.write( x++ );
                    out.write(", getClassValue(\"");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 62, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"));");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_iterate_61_1.handleBodyContent(out);
                }
                _jettag_c_iterate_61_1.doEnd();
                // process dropdowns one to one and many to one unidirectional
                RuntimeTagElement _jettag_c_iterate_65_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_65_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_65_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_65_4.setTagInfo(_td_c_iterate_65_4);
                _jettag_c_iterate_65_4.doStart(context, out);
                while (_jettag_c_iterate_65_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_66_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_66_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_66_5.setRuntimeParent(_jettag_c_iterate_65_4);
                    _jettag_c_iterate_66_5.setTagInfo(_td_c_iterate_66_5);
                    _jettag_c_iterate_66_5.doStart(context, out);
                    while (_jettag_c_iterate_66_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_67_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_67_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_67_6.setRuntimeParent(_jettag_c_iterate_66_5);
                        _jettag_c_iterate_67_6.setTagInfo(_td_c_iterate_67_6);
                        _jettag_c_iterate_67_6.doStart(context, out);
                        while (_jettag_c_iterate_67_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_68_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_68_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_68_7.setRuntimeParent(_jettag_c_iterate_67_6);
                            _jettag_c_setVariable_68_7.setTagInfo(_td_c_setVariable_68_7);
                            _jettag_c_setVariable_68_7.doStart(context, out);
                            _jettag_c_setVariable_68_7.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_70_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_70_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_70_9.setRuntimeParent(_jettag_c_iterate_67_6);
                            _jettag_c_if_70_9.setTagInfo(_td_c_if_70_9);
                            _jettag_c_if_70_9.doStart(context, out);
                            while (_jettag_c_if_70_9.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_72_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_72_15); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_72_15.setRuntimeParent(_jettag_c_if_70_9);
                                _jettag_c_iterate_72_15.setTagInfo(_td_c_iterate_72_15);
                                _jettag_c_iterate_72_15.doStart(context, out);
                                while (_jettag_c_iterate_72_15.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_73_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_73_15); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_73_15.setRuntimeParent(_jettag_c_iterate_72_15);
                                    _jettag_c_setVariable_73_15.setTagInfo(_td_c_setVariable_73_15);
                                    _jettag_c_setVariable_73_15.doStart(context, out);
                                    _jettag_c_setVariable_73_15.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_75_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_75_17); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_75_17.setRuntimeParent(_jettag_c_iterate_72_15);
                                    _jettag_c_if_75_17.setTagInfo(_td_c_if_75_17);
                                    _jettag_c_if_75_17.doStart(context, out);
                                    while (_jettag_c_if_75_17.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_77_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_77_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_77_18.setRuntimeParent(_jettag_c_if_75_17);
                                        _jettag_c_iterate_77_18.setTagInfo(_td_c_iterate_77_18);
                                        _jettag_c_iterate_77_18.doStart(context, out);
                                        while (_jettag_c_iterate_77_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_78_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_78_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_78_19.setRuntimeParent(_jettag_c_iterate_77_18);
                                            _jettag_c_if_78_19.setTagInfo(_td_c_if_78_19);
                                            _jettag_c_if_78_19.doStart(context, out);
                                            while (_jettag_c_if_78_19.okToProcessBody()) {
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                RuntimeTagElement _jettag_c_if_81_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_81_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_81_19.setRuntimeParent(_jettag_c_if_78_19);
                                                _jettag_c_if_81_19.setTagInfo(_td_c_if_81_19);
                                                _jettag_c_if_81_19.doStart(context, out);
                                                while (_jettag_c_if_81_19.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_82_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_82_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_82_21.setRuntimeParent(_jettag_c_if_81_19);
                                                    _jettag_c_if_82_21.setTagInfo(_td_c_if_82_21);
                                                    _jettag_c_if_82_21.doStart(context, out);
                                                    while (_jettag_c_if_82_21.okToProcessBody()) {
                                                        //check for Many to one unidirectional
                                                        RuntimeTagElement _jettag_c_if_84_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_84_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_84_21.setRuntimeParent(_jettag_c_if_82_21);
                                                        _jettag_c_if_84_21.setTagInfo(_td_c_if_84_21);
                                                        _jettag_c_if_84_21.doStart(context, out);
                                                        while (_jettag_c_if_84_21.okToProcessBody()) {
                                                            out.write("\t\t\t  \t\t\t\t\t    \t\t\t\t\t\t\t\ttable.setText(0, ");  //$NON-NLS-1$        
                                                            out.write( x++ );
                                                            out.write(", \"");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 85, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("\");");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_84_21.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_84_21.doEnd();
                                                        //check for one to one 
                                                        RuntimeTagElement _jettag_c_if_88_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_88_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_88_21.setRuntimeParent(_jettag_c_if_82_21);
                                                        _jettag_c_if_88_21.setTagInfo(_td_c_if_88_21);
                                                        _jettag_c_if_88_21.doStart(context, out);
                                                        while (_jettag_c_if_88_21.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_89_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_89_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_89_21.setRuntimeParent(_jettag_c_if_88_21);
                                                            _jettag_c_if_89_21.setTagInfo(_td_c_if_89_21);
                                                            _jettag_c_if_89_21.doStart(context, out);
                                                            while (_jettag_c_if_89_21.okToProcessBody()) {
                                                                out.write("\t\t\t  \t\t\t\t\t    \t\t\t\t\t\t\ttable.setText(0, ");  //$NON-NLS-1$        
                                                                out.write( x++ );
                                                                out.write(", \"");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 90, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("\");");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_89_21.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_89_21.doEnd();
                                                            _jettag_c_if_88_21.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_88_21.doEnd();
                                                        _jettag_c_if_82_21.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_82_21.doEnd();
                                                    _jettag_c_if_81_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_81_19.doEnd();
                                                _jettag_c_if_78_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_78_19.doEnd();
                                            _jettag_c_iterate_77_18.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_77_18.doEnd();
                                        _jettag_c_if_75_17.handleBodyContent(out);
                                    }
                                    _jettag_c_if_75_17.doEnd();
                                    _jettag_c_iterate_72_15.handleBodyContent(out);
                                }
                                _jettag_c_iterate_72_15.doEnd();
                                _jettag_c_if_70_9.handleBodyContent(out);
                            }
                            _jettag_c_if_70_9.doEnd();
                            _jettag_c_iterate_67_6.handleBodyContent(out);
                        }
                        _jettag_c_iterate_67_6.doEnd();
                        _jettag_c_iterate_66_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_66_5.doEnd();
                    _jettag_c_iterate_65_4.handleBodyContent(out);
                }
                _jettag_c_iterate_65_4.doEnd();
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_104_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_104_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_104_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_104_1.setTagInfo(_td_f_message_104_1);
                _jettag_f_message_104_1.doStart(context, out);
                JET2Writer _jettag_f_message_104_1_saved_out = out;
                while (_jettag_f_message_104_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_104_1.handleBodyContent(out);
                }
                out = _jettag_f_message_104_1_saved_out;
                _jettag_f_message_104_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void fillData(List<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 106, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Proxy> proxys) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tint i = 1;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tfor (");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 108, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Proxy entity : proxys) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tcreateViewIcon(i, entity.getId());");  //$NON-NLS-1$        
                out.write(NL);         
        
        			int y = 1;
        			
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_114_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_114_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_114_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_114_4.setTagInfo(_td_c_if_114_4);
                _jettag_c_if_114_4.doStart(context, out);
                while (_jettag_c_if_114_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_115_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_115_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_115_4.setRuntimeParent(_jettag_c_if_114_4);
                    _jettag_c_iterate_115_4.setTagInfo(_td_c_iterate_115_4);
                    _jettag_c_iterate_115_4.doStart(context, out);
                    while (_jettag_c_iterate_115_4.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_116_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_116_8); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_116_8.setRuntimeParent(_jettag_c_iterate_115_4);
                        _jettag_c_choose_116_8.setTagInfo(_td_c_choose_116_8);
                        _jettag_c_choose_116_8.doStart(context, out);
                        JET2Writer _jettag_c_choose_116_8_saved_out = out;
                        while (_jettag_c_choose_116_8.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_when_117_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_117_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_117_9.setRuntimeParent(_jettag_c_choose_116_8);
                            _jettag_c_when_117_9.setTagInfo(_td_c_when_117_9);
                            _jettag_c_when_117_9.doStart(context, out);
                            JET2Writer _jettag_c_when_117_9_saved_out = out;
                            while (_jettag_c_when_117_9.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("\t\t\t\t\t\t  \t\ttable.setText(i, ");  //$NON-NLS-1$        
                                out.write( y++ );
                                out.write(", Utils.getShortDate(entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 118, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("())); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_117_9.handleBodyContent(out);
                            }
                            out = _jettag_c_when_117_9_saved_out;
                            _jettag_c_when_117_9.doEnd();
                            RuntimeTagElement _jettag_c_when_120_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_120_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_120_9.setRuntimeParent(_jettag_c_choose_116_8);
                            _jettag_c_when_120_9.setTagInfo(_td_c_when_120_9);
                            _jettag_c_when_120_9.doStart(context, out);
                            JET2Writer _jettag_c_when_120_9_saved_out = out;
                            while (_jettag_c_when_120_9.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("\t\t\t\t\t\t  \t\ttable.setWidget(i, ");  //$NON-NLS-1$        
                                out.write( y++ );
                                out.write(", new ImageField(\"\",\"\",\"\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 121, 73)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("Welcome.constants");  //$NON-NLS-1$        
                                out.write(NL);         
                                out.write("\t\t\t\t\t\t\t\t.imagesTargetDirectory() + entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 122, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(),100,100)); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_120_9.handleBodyContent(out);
                            }
                            out = _jettag_c_when_120_9_saved_out;
                            _jettag_c_when_120_9.doEnd();
                            RuntimeTagElement _jettag_c_when_124_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_124_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_124_9.setRuntimeParent(_jettag_c_choose_116_8);
                            _jettag_c_when_124_9.setTagInfo(_td_c_when_124_9);
                            _jettag_c_when_124_9.doStart(context, out);
                            JET2Writer _jettag_c_when_124_9_saved_out = out;
                            while (_jettag_c_when_124_9.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("\t\t\t\t\t\t \t\ttable.setText(i, ");  //$NON-NLS-1$        
                                out.write( y++ );
                                out.write(", CurrencyField.format(entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 125, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()));");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_124_9.handleBodyContent(out);
                            }
                            out = _jettag_c_when_124_9_saved_out;
                            _jettag_c_when_124_9.doEnd();
                            RuntimeTagElement _jettag_c_when_127_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_127_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_127_9.setRuntimeParent(_jettag_c_choose_116_8);
                            _jettag_c_when_127_9.setTagInfo(_td_c_when_127_9);
                            _jettag_c_when_127_9.doStart(context, out);
                            JET2Writer _jettag_c_when_127_9_saved_out = out;
                            while (_jettag_c_when_127_9.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("\t\t\t\t\t\t  \t\ttable.setHTML(i, ");  //$NON-NLS-1$        
                                out.write( y++ );
                                out.write(", Utils.entityToString(entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 128, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("())); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_127_9.handleBodyContent(out);
                            }
                            out = _jettag_c_when_127_9_saved_out;
                            _jettag_c_when_127_9.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_130_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_130_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_130_9.setRuntimeParent(_jettag_c_choose_116_8);
                            _jettag_c_otherwise_130_9.setTagInfo(_td_c_otherwise_130_9);
                            _jettag_c_otherwise_130_9.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_130_9_saved_out = out;
                            while (_jettag_c_otherwise_130_9.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("\t\t\t\t\t\t\t\ttable.setText(i, ");  //$NON-NLS-1$        
                                out.write( y++ );
                                out.write(", Utils.entityToString(entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 131, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()));");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_otherwise_130_9.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_130_9_saved_out;
                            _jettag_c_otherwise_130_9.doEnd();
                            _jettag_c_choose_116_8.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_116_8_saved_out;
                        _jettag_c_choose_116_8.doEnd();
                        _jettag_c_iterate_115_4.handleBodyContent(out);
                    }
                    _jettag_c_iterate_115_4.doEnd();
                    _jettag_c_if_114_4.handleBodyContent(out);
                }
                _jettag_c_if_114_4.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_137_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_137_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_137_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_137_4.setTagInfo(_td_c_if_137_4);
                _jettag_c_if_137_4.doStart(context, out);
                while (_jettag_c_if_137_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_138_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_138_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_138_4.setRuntimeParent(_jettag_c_if_137_4);
                    _jettag_c_iterate_138_4.setTagInfo(_td_c_iterate_138_4);
                    _jettag_c_iterate_138_4.doStart(context, out);
                    while (_jettag_c_iterate_138_4.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_139_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_139_14); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_139_14.setRuntimeParent(_jettag_c_iterate_138_4);
                        _jettag_c_choose_139_14.setTagInfo(_td_c_choose_139_14);
                        _jettag_c_choose_139_14.doStart(context, out);
                        JET2Writer _jettag_c_choose_139_14_saved_out = out;
                        while (_jettag_c_choose_139_14.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_when_140_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_140_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_140_9.setRuntimeParent(_jettag_c_choose_139_14);
                            _jettag_c_when_140_9.setTagInfo(_td_c_when_140_9);
                            _jettag_c_when_140_9.doStart(context, out);
                            JET2Writer _jettag_c_when_140_9_saved_out = out;
                            while (_jettag_c_when_140_9.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("\t\t\t\t\t\t  \t\ttable.setText(i, ");  //$NON-NLS-1$        
                                out.write( y++ );
                                out.write(", Utils.getShortDate(entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 141, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("())); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_140_9.handleBodyContent(out);
                            }
                            out = _jettag_c_when_140_9_saved_out;
                            _jettag_c_when_140_9.doEnd();
                            RuntimeTagElement _jettag_c_when_143_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_143_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_143_9.setRuntimeParent(_jettag_c_choose_139_14);
                            _jettag_c_when_143_9.setTagInfo(_td_c_when_143_9);
                            _jettag_c_when_143_9.doStart(context, out);
                            JET2Writer _jettag_c_when_143_9_saved_out = out;
                            while (_jettag_c_when_143_9.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("\t\t\t\t\t\t  \t\ttable.setWidget(i, ");  //$NON-NLS-1$        
                                out.write( y++ );
                                out.write(", new ImageField(\"\",\"\",\"\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 144, 73)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("Welcome.constants");  //$NON-NLS-1$        
                                out.write(NL);         
                                out.write("\t\t\t\t\t\t\t\t.imagesTargetDirectory() + entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 145, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(),100,100)); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_143_9.handleBodyContent(out);
                            }
                            out = _jettag_c_when_143_9_saved_out;
                            _jettag_c_when_143_9.doEnd();
                            RuntimeTagElement _jettag_c_when_147_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_147_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_147_9.setRuntimeParent(_jettag_c_choose_139_14);
                            _jettag_c_when_147_9.setTagInfo(_td_c_when_147_9);
                            _jettag_c_when_147_9.doStart(context, out);
                            JET2Writer _jettag_c_when_147_9_saved_out = out;
                            while (_jettag_c_when_147_9.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("\t\t\t\t\t\t \t\ttable.setText(i, ");  //$NON-NLS-1$        
                                out.write( y++ );
                                out.write(", CurrencyField.format(entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 148, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()));");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_147_9.handleBodyContent(out);
                            }
                            out = _jettag_c_when_147_9_saved_out;
                            _jettag_c_when_147_9.doEnd();
                            RuntimeTagElement _jettag_c_when_150_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_150_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_150_9.setRuntimeParent(_jettag_c_choose_139_14);
                            _jettag_c_when_150_9.setTagInfo(_td_c_when_150_9);
                            _jettag_c_when_150_9.doStart(context, out);
                            JET2Writer _jettag_c_when_150_9_saved_out = out;
                            while (_jettag_c_when_150_9.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("\t\t\t\t\t\t  \t\ttable.setHTML(i, ");  //$NON-NLS-1$        
                                out.write( y++ );
                                out.write(", Utils.entityToString(entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 151, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("())); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_150_9.handleBodyContent(out);
                            }
                            out = _jettag_c_when_150_9_saved_out;
                            _jettag_c_when_150_9.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_153_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_153_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_153_9.setRuntimeParent(_jettag_c_choose_139_14);
                            _jettag_c_otherwise_153_9.setTagInfo(_td_c_otherwise_153_9);
                            _jettag_c_otherwise_153_9.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_153_9_saved_out = out;
                            while (_jettag_c_otherwise_153_9.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("\t\t\t\t\t\t\t\ttable.setText(i, ");  //$NON-NLS-1$        
                                out.write( y++ );
                                out.write(", Utils.entityToString(entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 154, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()));");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_otherwise_153_9.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_153_9_saved_out;
                            _jettag_c_otherwise_153_9.doEnd();
                            _jettag_c_choose_139_14.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_139_14_saved_out;
                        _jettag_c_choose_139_14.doEnd();
                        _jettag_c_iterate_138_4.handleBodyContent(out);
                    }
                    _jettag_c_iterate_138_4.doEnd();
                    _jettag_c_if_137_4.handleBodyContent(out);
                }
                _jettag_c_if_137_4.doEnd();
                // process base class attributes
                RuntimeTagElement _jettag_c_iterate_160_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_160_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_160_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_160_4.setTagInfo(_td_c_iterate_160_4);
                _jettag_c_iterate_160_4.doStart(context, out);
                while (_jettag_c_iterate_160_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_161_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_161_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_161_8.setRuntimeParent(_jettag_c_iterate_160_4);
                    _jettag_c_choose_161_8.setTagInfo(_td_c_choose_161_8);
                    _jettag_c_choose_161_8.doStart(context, out);
                    JET2Writer _jettag_c_choose_161_8_saved_out = out;
                    while (_jettag_c_choose_161_8.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_when_162_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_162_9); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_162_9.setRuntimeParent(_jettag_c_choose_161_8);
                        _jettag_c_when_162_9.setTagInfo(_td_c_when_162_9);
                        _jettag_c_when_162_9.doStart(context, out);
                        JET2Writer _jettag_c_when_162_9_saved_out = out;
                        while (_jettag_c_when_162_9.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t\t\t  \t\ttable.setText(i, ");  //$NON-NLS-1$        
                            out.write( y++ );
                            out.write(", Utils.getShortDate(entity.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 163, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("())); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_162_9.handleBodyContent(out);
                        }
                        out = _jettag_c_when_162_9_saved_out;
                        _jettag_c_when_162_9.doEnd();
                        RuntimeTagElement _jettag_c_when_165_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_165_9); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_165_9.setRuntimeParent(_jettag_c_choose_161_8);
                        _jettag_c_when_165_9.setTagInfo(_td_c_when_165_9);
                        _jettag_c_when_165_9.doStart(context, out);
                        JET2Writer _jettag_c_when_165_9_saved_out = out;
                        while (_jettag_c_when_165_9.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t\t\t  \t\ttable.setWidget(i, ");  //$NON-NLS-1$        
                            out.write( y++ );
                            out.write(", new ImageField(\"\",\"\",\"\", true, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 166, 73)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("Welcome.constants");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t.imagesTargetDirectory() + entity.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 167, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(),100,100)); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_165_9.handleBodyContent(out);
                        }
                        out = _jettag_c_when_165_9_saved_out;
                        _jettag_c_when_165_9.doEnd();
                        RuntimeTagElement _jettag_c_when_169_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_169_9); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_169_9.setRuntimeParent(_jettag_c_choose_161_8);
                        _jettag_c_when_169_9.setTagInfo(_td_c_when_169_9);
                        _jettag_c_when_169_9.doStart(context, out);
                        JET2Writer _jettag_c_when_169_9_saved_out = out;
                        while (_jettag_c_when_169_9.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t\t\t \t\ttable.setText(i, ");  //$NON-NLS-1$        
                            out.write( y++ );
                            out.write(", CurrencyField.format(entity.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 170, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()));");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_169_9.handleBodyContent(out);
                        }
                        out = _jettag_c_when_169_9_saved_out;
                        _jettag_c_when_169_9.doEnd();
                        RuntimeTagElement _jettag_c_when_172_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_172_9); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_172_9.setRuntimeParent(_jettag_c_choose_161_8);
                        _jettag_c_when_172_9.setTagInfo(_td_c_when_172_9);
                        _jettag_c_when_172_9.doStart(context, out);
                        JET2Writer _jettag_c_when_172_9_saved_out = out;
                        while (_jettag_c_when_172_9.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t\t\t  \t\ttable.setHTML(i, ");  //$NON-NLS-1$        
                            out.write( y++ );
                            out.write(", Utils.entityToString(entity.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 173, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("())); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_172_9.handleBodyContent(out);
                        }
                        out = _jettag_c_when_172_9_saved_out;
                        _jettag_c_when_172_9.doEnd();
                        RuntimeTagElement _jettag_c_otherwise_175_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_175_9); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_175_9.setRuntimeParent(_jettag_c_choose_161_8);
                        _jettag_c_otherwise_175_9.setTagInfo(_td_c_otherwise_175_9);
                        _jettag_c_otherwise_175_9.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_175_9_saved_out = out;
                        while (_jettag_c_otherwise_175_9.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t\t\t\t\ttable.setText(i, ");  //$NON-NLS-1$        
                            out.write( y++ );
                            out.write(", Utils.entityToString(entity.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 176, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()));");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_otherwise_175_9.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_175_9_saved_out;
                        _jettag_c_otherwise_175_9.doEnd();
                        _jettag_c_choose_161_8.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_161_8_saved_out;
                    _jettag_c_choose_161_8.doEnd();
                    _jettag_c_iterate_160_4.handleBodyContent(out);
                }
                _jettag_c_iterate_160_4.doEnd();
                // process dropdowns one to one and many to one unidirectional
                RuntimeTagElement _jettag_c_iterate_181_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_181_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_181_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_181_4.setTagInfo(_td_c_iterate_181_4);
                _jettag_c_iterate_181_4.doStart(context, out);
                while (_jettag_c_iterate_181_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_182_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_182_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_182_5.setRuntimeParent(_jettag_c_iterate_181_4);
                    _jettag_c_iterate_182_5.setTagInfo(_td_c_iterate_182_5);
                    _jettag_c_iterate_182_5.doStart(context, out);
                    while (_jettag_c_iterate_182_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_183_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_183_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_183_6.setRuntimeParent(_jettag_c_iterate_182_5);
                        _jettag_c_iterate_183_6.setTagInfo(_td_c_iterate_183_6);
                        _jettag_c_iterate_183_6.doStart(context, out);
                        while (_jettag_c_iterate_183_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_184_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_184_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_184_7.setRuntimeParent(_jettag_c_iterate_183_6);
                            _jettag_c_setVariable_184_7.setTagInfo(_td_c_setVariable_184_7);
                            _jettag_c_setVariable_184_7.doStart(context, out);
                            _jettag_c_setVariable_184_7.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_186_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_186_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_186_9.setRuntimeParent(_jettag_c_iterate_183_6);
                            _jettag_c_if_186_9.setTagInfo(_td_c_if_186_9);
                            _jettag_c_if_186_9.doStart(context, out);
                            while (_jettag_c_if_186_9.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_188_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_188_15); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_188_15.setRuntimeParent(_jettag_c_if_186_9);
                                _jettag_c_iterate_188_15.setTagInfo(_td_c_iterate_188_15);
                                _jettag_c_iterate_188_15.doStart(context, out);
                                while (_jettag_c_iterate_188_15.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_189_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_189_15); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_189_15.setRuntimeParent(_jettag_c_iterate_188_15);
                                    _jettag_c_setVariable_189_15.setTagInfo(_td_c_setVariable_189_15);
                                    _jettag_c_setVariable_189_15.doStart(context, out);
                                    _jettag_c_setVariable_189_15.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_191_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_191_17); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_191_17.setRuntimeParent(_jettag_c_iterate_188_15);
                                    _jettag_c_if_191_17.setTagInfo(_td_c_if_191_17);
                                    _jettag_c_if_191_17.doStart(context, out);
                                    while (_jettag_c_if_191_17.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_193_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_193_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_193_18.setRuntimeParent(_jettag_c_if_191_17);
                                        _jettag_c_iterate_193_18.setTagInfo(_td_c_iterate_193_18);
                                        _jettag_c_iterate_193_18.doStart(context, out);
                                        while (_jettag_c_iterate_193_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_194_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_194_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_194_19.setRuntimeParent(_jettag_c_iterate_193_18);
                                            _jettag_c_if_194_19.setTagInfo(_td_c_if_194_19);
                                            _jettag_c_if_194_19.doStart(context, out);
                                            while (_jettag_c_if_194_19.okToProcessBody()) {
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                RuntimeTagElement _jettag_c_if_197_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_197_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_197_19.setRuntimeParent(_jettag_c_if_194_19);
                                                _jettag_c_if_197_19.setTagInfo(_td_c_if_197_19);
                                                _jettag_c_if_197_19.doStart(context, out);
                                                while (_jettag_c_if_197_19.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_198_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_198_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_198_21.setRuntimeParent(_jettag_c_if_197_19);
                                                    _jettag_c_if_198_21.setTagInfo(_td_c_if_198_21);
                                                    _jettag_c_if_198_21.doStart(context, out);
                                                    while (_jettag_c_if_198_21.okToProcessBody()) {
                                                        //check for Many to one unidirectional
                                                        RuntimeTagElement _jettag_c_if_200_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_200_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_200_21.setRuntimeParent(_jettag_c_if_198_21);
                                                        _jettag_c_if_200_21.setTagInfo(_td_c_if_200_21);
                                                        _jettag_c_if_200_21.doStart(context, out);
                                                        while (_jettag_c_if_200_21.okToProcessBody()) {
                                                            out.write("\t\t\t  \t\t\t\t\t    \t\t\t\t\t\t\t\ttable.setText(i, ");  //$NON-NLS-1$        
                                                            out.write( y++ );
                                                            out.write(", Utils.entityToString(entity.get");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 201, 83)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("()));");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_200_21.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_200_21.doEnd();
                                                        //check for one to one 
                                                        RuntimeTagElement _jettag_c_if_204_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_204_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_204_21.setRuntimeParent(_jettag_c_if_198_21);
                                                        _jettag_c_if_204_21.setTagInfo(_td_c_if_204_21);
                                                        _jettag_c_if_204_21.doStart(context, out);
                                                        while (_jettag_c_if_204_21.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_205_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_205_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_205_21.setRuntimeParent(_jettag_c_if_204_21);
                                                            _jettag_c_if_205_21.setTagInfo(_td_c_if_205_21);
                                                            _jettag_c_if_205_21.doStart(context, out);
                                                            while (_jettag_c_if_205_21.okToProcessBody()) {
                                                                out.write("\t\t\t  \t\t\t\t\t    \t\t\t\t\t\t\ttable.setText(i, ");  //$NON-NLS-1$        
                                                                out.write( y++ );
                                                                out.write(", Utils.entityToString(entity.get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 206, 82)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("()));");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_205_21.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_205_21.doEnd();
                                                            _jettag_c_if_204_21.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_204_21.doEnd();
                                                        _jettag_c_if_198_21.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_198_21.doEnd();
                                                    _jettag_c_if_197_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_197_19.doEnd();
                                                _jettag_c_if_194_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_194_19.doEnd();
                                            _jettag_c_iterate_193_18.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_193_18.doEnd();
                                        _jettag_c_if_191_17.handleBodyContent(out);
                                    }
                                    _jettag_c_if_191_17.doEnd();
                                    _jettag_c_iterate_188_15.handleBodyContent(out);
                                }
                                _jettag_c_iterate_188_15.doEnd();
                                _jettag_c_if_186_9.handleBodyContent(out);
                            }
                            _jettag_c_if_186_9.doEnd();
                            _jettag_c_iterate_183_6.handleBodyContent(out);
                        }
                        _jettag_c_iterate_183_6.doEnd();
                        _jettag_c_iterate_182_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_182_5.doEnd();
                    _jettag_c_iterate_181_4.handleBodyContent(out);
                }
                _jettag_c_iterate_181_4.doEnd();
                out.write("\t\t\ti++;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_223_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_223_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_223_1.setRuntimeParent(_jettag_f_bundle_3_1);
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
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 225, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Request getRequest() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 226, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().requestFactory");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 227, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Request();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_229_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_229_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_229_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_229_1.setTagInfo(_td_f_message_229_1);
                _jettag_f_message_229_1.doStart(context, out);
                JET2Writer _jettag_f_message_229_1_saved_out = out;
                while (_jettag_f_message_229_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_229_1.handleBodyContent(out);
                }
                out = _jettag_f_message_229_1_saved_out;
                _jettag_f_message_229_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void viewClicked(int row, int col) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 232, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().getEntityPanel().clear();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 233, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().getEntityPanel().add(");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tnew Read");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 234, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely(getProxyId(row)));");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 235, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().getSidePanelTop().clear();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 236, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().getSidePanelTop()");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t.add(new Tree");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 237, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely());");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_c_if_240_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_240_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_240_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_240_1.setTagInfo(_td_c_if_240_1);
                _jettag_c_if_240_1.doStart(context, out);
                while (_jettag_c_if_240_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_f_message_241_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_241_1); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_f_message_241_1.setRuntimeParent(_jettag_c_if_240_1);
                    _jettag_f_message_241_1.setTagInfo(_td_f_message_241_1);
                    _jettag_f_message_241_1.doStart(context, out);
                    JET2Writer _jettag_f_message_241_1_saved_out = out;
                    while (_jettag_f_message_241_1.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("generated.comment");  //$NON-NLS-1$        
                        _jettag_f_message_241_1.handleBodyContent(out);
                    }
                    out = _jettag_f_message_241_1_saved_out;
                    _jettag_f_message_241_1.doEnd();
                    out.write("\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\tpublic void refresh() {");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\tparentTree.treeNodeSelected(Utils.getClassSimpleName(parentTreeClass));");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t}");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_240_1.handleBodyContent(out);
                }
                _jettag_c_if_240_1.doEnd();
                out.write("}");  //$NON-NLS-1$        
                out.write(NL);         
                _jettag_f_bundle_3_1.handleBodyContent(out);
            }
            _jettag_f_bundle_3_1.doEnd();
            _jettag_java_format_2_1.handleBodyContent(out);
        }
        out = _jettag_java_format_2_1_saved_out;
        _jettag_java_format_2_1.doEnd();
        out.write(NL);         
    }
}
