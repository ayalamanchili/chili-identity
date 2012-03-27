package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_web_readall_panel_templatejava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_web_readall_panel_templatejava() {
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
    private static final TagInfo _td_c_if_10_1 = new TagInfo("c:if", //$NON-NLS-1$
            10, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isDependent = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_22_1 = new TagInfo("f:message", //$NON-NLS-1$
            22, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_24_1 = new TagInfo("f:message", //$NON-NLS-1$
            24, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_27_1 = new TagInfo("c:if", //$NON-NLS-1$
            27, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isDependent = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_28_1 = new TagInfo("f:message", //$NON-NLS-1$
            28, 1,
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
    private static final TagInfo _td_f_message_34_1 = new TagInfo("f:message", //$NON-NLS-1$
            34, 1,
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
    private static final TagInfo _td_f_message_51_1 = new TagInfo("f:message", //$NON-NLS-1$
            51, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_59_1 = new TagInfo("c:if", //$NON-NLS-1$
            59, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_60_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            60, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_65_1 = new TagInfo("c:if", //$NON-NLS-1$
            65, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_66_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            66, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_71_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            71, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_75_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            75, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_76_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            76, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_77_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            77, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_78_7 = new TagInfo("c:setVariable", //$NON-NLS-1$
            78, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_80_9 = new TagInfo("c:if", //$NON-NLS-1$
            80, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_82_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            82, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_83_15 = new TagInfo("c:setVariable", //$NON-NLS-1$
            83, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_85_17 = new TagInfo("c:if", //$NON-NLS-1$
            85, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_87_18 = new TagInfo("c:iterate", //$NON-NLS-1$
            87, 18,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_88_19 = new TagInfo("c:if", //$NON-NLS-1$
            88, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_91_19 = new TagInfo("c:if", //$NON-NLS-1$
            91, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_92_21 = new TagInfo("c:if", //$NON-NLS-1$
            92, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_94_21 = new TagInfo("c:if", //$NON-NLS-1$
            94, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'false'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_98_21 = new TagInfo("c:if", //$NON-NLS-1$
            98, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_99_21 = new TagInfo("c:if", //$NON-NLS-1$
            99, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_114_1 = new TagInfo("f:message", //$NON-NLS-1$
            114, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_124_4 = new TagInfo("c:if", //$NON-NLS-1$
            124, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_125_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            125, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_126_8 = new TagInfo("c:choose", //$NON-NLS-1$
            126, 8,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_127_9 = new TagInfo("c:when", //$NON-NLS-1$
            127, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_130_9 = new TagInfo("c:when", //$NON-NLS-1$
            130, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_134_9 = new TagInfo("c:when", //$NON-NLS-1$
            134, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_137_9 = new TagInfo("c:when", //$NON-NLS-1$
            137, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_140_9 = new TagInfo("c:otherwise", //$NON-NLS-1$
            140, 9,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_147_4 = new TagInfo("c:if", //$NON-NLS-1$
            147, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_148_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            148, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_149_14 = new TagInfo("c:choose", //$NON-NLS-1$
            149, 14,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_150_9 = new TagInfo("c:when", //$NON-NLS-1$
            150, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_153_9 = new TagInfo("c:when", //$NON-NLS-1$
            153, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_157_9 = new TagInfo("c:when", //$NON-NLS-1$
            157, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_160_9 = new TagInfo("c:when", //$NON-NLS-1$
            160, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_163_9 = new TagInfo("c:otherwise", //$NON-NLS-1$
            163, 9,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_170_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            170, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_171_8 = new TagInfo("c:choose", //$NON-NLS-1$
            171, 8,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_172_9 = new TagInfo("c:when", //$NON-NLS-1$
            172, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_175_9 = new TagInfo("c:when", //$NON-NLS-1$
            175, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_179_9 = new TagInfo("c:when", //$NON-NLS-1$
            179, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_182_9 = new TagInfo("c:when", //$NON-NLS-1$
            182, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_185_9 = new TagInfo("c:otherwise", //$NON-NLS-1$
            185, 9,
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
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_192_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            192, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_193_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            193, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_194_7 = new TagInfo("c:setVariable", //$NON-NLS-1$
            194, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_196_9 = new TagInfo("c:if", //$NON-NLS-1$
            196, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_198_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            198, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_199_15 = new TagInfo("c:setVariable", //$NON-NLS-1$
            199, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_201_17 = new TagInfo("c:if", //$NON-NLS-1$
            201, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_203_18 = new TagInfo("c:iterate", //$NON-NLS-1$
            203, 18,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_204_19 = new TagInfo("c:if", //$NON-NLS-1$
            204, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_207_19 = new TagInfo("c:if", //$NON-NLS-1$
            207, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_208_21 = new TagInfo("c:if", //$NON-NLS-1$
            208, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_210_21 = new TagInfo("c:if", //$NON-NLS-1$
            210, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'false'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_214_21 = new TagInfo("c:if", //$NON-NLS-1$
            214, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_215_21 = new TagInfo("c:if", //$NON-NLS-1$
            215, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_233_1 = new TagInfo("f:message", //$NON-NLS-1$
            233, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_262_1 = new TagInfo("f:message", //$NON-NLS-1$
            262, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_273_1 = new TagInfo("c:if", //$NON-NLS-1$
            273, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isDependent = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_274_1 = new TagInfo("f:message", //$NON-NLS-1$
            274, 1,
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
                // add these only for composites
                RuntimeTagElement _jettag_c_if_10_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_10_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_10_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_10_1.setTagInfo(_td_c_if_10_1);
                _jettag_c_if_10_1.doStart(context, out);
                while (_jettag_c_if_10_1.okToProcessBody()) {
                    out.write("import info.yalamanchili.gwt.composite.TreePanelComposite;");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_10_1.handleBodyContent(out);
                }
                _jettag_c_if_10_1.doEnd();
                out.write("import info.yalamanchili.gwt.beans.TableObj;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.callback.ALAsyncCallback;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.ReadAllComposite;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.utils.Utils;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.fields.*;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import java.util.List;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import com.google.gwt.user.client.ui.DockPanel;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_22_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_22_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_22_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_22_1.setTagInfo(_td_f_message_22_1);
                _jettag_f_message_22_1.doStart(context, out);
                JET2Writer _jettag_f_message_22_1_saved_out = out;
                while (_jettag_f_message_22_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_22_1.handleBodyContent(out);
                }
                out = _jettag_f_message_22_1_saved_out;
                _jettag_f_message_22_1.doEnd();
                out.write(NL);         
                out.write("public class ReadAll");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 23, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("sPanel extends ReadAllComposite<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 23, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> {");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_24_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_24_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_24_1.setRuntimeParent(_jettag_f_bundle_3_1);
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
                out.write(NL);         
                out.write("\tpublic static ReadAll");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 25, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("sPanel instance;");  //$NON-NLS-1$        
                out.write(NL);         
                // add these only for composites
                RuntimeTagElement _jettag_c_if_27_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_27_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_27_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_27_1.setTagInfo(_td_c_if_27_1);
                _jettag_c_if_27_1.doStart(context, out);
                while (_jettag_c_if_27_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_f_message_28_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_28_1); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_f_message_28_1.setRuntimeParent(_jettag_c_if_27_1);
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
                    out.write("\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\tpublic TreePanelComposite parentTree;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\tpublic String parentTreeClass;");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_27_1.handleBodyContent(out);
                }
                _jettag_c_if_27_1.doEnd();
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
                out.write("\tprivate  ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 33, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("TableType tableType;");  //$NON-NLS-1$        
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
                out.write(NL);         
                out.write("\tpublic enum ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 35, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("TableType {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tREADALL, READALL_SEARCH");  //$NON-NLS-1$        
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
                out.write("\tpublic ReadAll");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 39, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("sPanel(List<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 39, 43)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> entities) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinstance=this;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinitTable(new ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 41, 17)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("(), entities, ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 41, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.constants);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
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
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic ReadAll");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 45, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("sPanel(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 45, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("TableType tableType) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinstance=this;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tthis.tableType = tableType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinitTable(new ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 48, 17)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("(),");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 49, 5)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.constants);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_51_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_51_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_51_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_51_1.setTagInfo(_td_f_message_51_1);
                _jettag_f_message_51_1.doStart(context, out);
                JET2Writer _jettag_f_message_51_1_saved_out = out;
                while (_jettag_f_message_51_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_51_1.handleBodyContent(out);
                }
                out = _jettag_f_message_51_1_saved_out;
                _jettag_f_message_51_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void createTableHeader() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\ttable.setText(0, 0, getKeyValue(\"Table_Action\"));\t");  //$NON-NLS-1$        
                out.write(NL);         
        
        		int x = 1;
        		
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_59_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_59_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_59_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_59_1.setTagInfo(_td_c_if_59_1);
                _jettag_c_if_59_1.doStart(context, out);
                while (_jettag_c_if_59_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_60_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_60_1); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_60_1.setRuntimeParent(_jettag_c_if_59_1);
                    _jettag_c_iterate_60_1.setTagInfo(_td_c_iterate_60_1);
                    _jettag_c_iterate_60_1.doStart(context, out);
                    while (_jettag_c_iterate_60_1.okToProcessBody()) {
                        out.write("\t\t\ttable.setText(0, ");  //$NON-NLS-1$        
                        out.write( x++ );
                        out.write(", getClassValue(\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 61, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"));");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_iterate_60_1.handleBodyContent(out);
                    }
                    _jettag_c_iterate_60_1.doEnd();
                    _jettag_c_if_59_1.handleBodyContent(out);
                }
                _jettag_c_if_59_1.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_65_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_65_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_65_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_65_1.setTagInfo(_td_c_if_65_1);
                _jettag_c_if_65_1.doStart(context, out);
                while (_jettag_c_if_65_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_66_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_66_1); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_66_1.setRuntimeParent(_jettag_c_if_65_1);
                    _jettag_c_iterate_66_1.setTagInfo(_td_c_iterate_66_1);
                    _jettag_c_iterate_66_1.doStart(context, out);
                    while (_jettag_c_iterate_66_1.okToProcessBody()) {
                        out.write("\t\t\ttable.setText(0, ");  //$NON-NLS-1$        
                        out.write( x++ );
                        out.write(", getClassValue(\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 67, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"));");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_iterate_66_1.handleBodyContent(out);
                    }
                    _jettag_c_iterate_66_1.doEnd();
                    _jettag_c_if_65_1.handleBodyContent(out);
                }
                _jettag_c_if_65_1.doEnd();
                // process base class attributes
                RuntimeTagElement _jettag_c_iterate_71_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_71_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_71_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_71_1.setTagInfo(_td_c_iterate_71_1);
                _jettag_c_iterate_71_1.doStart(context, out);
                while (_jettag_c_iterate_71_1.okToProcessBody()) {
                    out.write("\t\t\ttable.setText(0, ");  //$NON-NLS-1$        
                    out.write( x++ );
                    out.write(", getClassValue(\"");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 72, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"));");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_iterate_71_1.handleBodyContent(out);
                }
                _jettag_c_iterate_71_1.doEnd();
                // process dropdowns one to one and many to one unidirectional
                RuntimeTagElement _jettag_c_iterate_75_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_75_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_75_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_75_4.setTagInfo(_td_c_iterate_75_4);
                _jettag_c_iterate_75_4.doStart(context, out);
                while (_jettag_c_iterate_75_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_76_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_76_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_76_5.setRuntimeParent(_jettag_c_iterate_75_4);
                    _jettag_c_iterate_76_5.setTagInfo(_td_c_iterate_76_5);
                    _jettag_c_iterate_76_5.doStart(context, out);
                    while (_jettag_c_iterate_76_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_77_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_77_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_77_6.setRuntimeParent(_jettag_c_iterate_76_5);
                        _jettag_c_iterate_77_6.setTagInfo(_td_c_iterate_77_6);
                        _jettag_c_iterate_77_6.doStart(context, out);
                        while (_jettag_c_iterate_77_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_78_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_78_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_78_7.setRuntimeParent(_jettag_c_iterate_77_6);
                            _jettag_c_setVariable_78_7.setTagInfo(_td_c_setVariable_78_7);
                            _jettag_c_setVariable_78_7.doStart(context, out);
                            _jettag_c_setVariable_78_7.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_80_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_80_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_80_9.setRuntimeParent(_jettag_c_iterate_77_6);
                            _jettag_c_if_80_9.setTagInfo(_td_c_if_80_9);
                            _jettag_c_if_80_9.doStart(context, out);
                            while (_jettag_c_if_80_9.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_82_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_82_15); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_82_15.setRuntimeParent(_jettag_c_if_80_9);
                                _jettag_c_iterate_82_15.setTagInfo(_td_c_iterate_82_15);
                                _jettag_c_iterate_82_15.doStart(context, out);
                                while (_jettag_c_iterate_82_15.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_83_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_83_15); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_83_15.setRuntimeParent(_jettag_c_iterate_82_15);
                                    _jettag_c_setVariable_83_15.setTagInfo(_td_c_setVariable_83_15);
                                    _jettag_c_setVariable_83_15.doStart(context, out);
                                    _jettag_c_setVariable_83_15.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_85_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_85_17); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_85_17.setRuntimeParent(_jettag_c_iterate_82_15);
                                    _jettag_c_if_85_17.setTagInfo(_td_c_if_85_17);
                                    _jettag_c_if_85_17.doStart(context, out);
                                    while (_jettag_c_if_85_17.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_87_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_87_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_87_18.setRuntimeParent(_jettag_c_if_85_17);
                                        _jettag_c_iterate_87_18.setTagInfo(_td_c_iterate_87_18);
                                        _jettag_c_iterate_87_18.doStart(context, out);
                                        while (_jettag_c_iterate_87_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_88_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_88_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_88_19.setRuntimeParent(_jettag_c_iterate_87_18);
                                            _jettag_c_if_88_19.setTagInfo(_td_c_if_88_19);
                                            _jettag_c_if_88_19.doStart(context, out);
                                            while (_jettag_c_if_88_19.okToProcessBody()) {
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                RuntimeTagElement _jettag_c_if_91_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_91_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_91_19.setRuntimeParent(_jettag_c_if_88_19);
                                                _jettag_c_if_91_19.setTagInfo(_td_c_if_91_19);
                                                _jettag_c_if_91_19.doStart(context, out);
                                                while (_jettag_c_if_91_19.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_92_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_92_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_92_21.setRuntimeParent(_jettag_c_if_91_19);
                                                    _jettag_c_if_92_21.setTagInfo(_td_c_if_92_21);
                                                    _jettag_c_if_92_21.doStart(context, out);
                                                    while (_jettag_c_if_92_21.okToProcessBody()) {
                                                        //check for Many to one unidirectional
                                                        RuntimeTagElement _jettag_c_if_94_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_94_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_94_21.setRuntimeParent(_jettag_c_if_92_21);
                                                        _jettag_c_if_94_21.setTagInfo(_td_c_if_94_21);
                                                        _jettag_c_if_94_21.doStart(context, out);
                                                        while (_jettag_c_if_94_21.okToProcessBody()) {
                                                            out.write("\t\t\t  \t\t\t\t\t    \t\t\t\t\t\t\t\ttable.setText(0, ");  //$NON-NLS-1$        
                                                            out.write( x++ );
                                                            out.write(", \"");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 95, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("\");");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_94_21.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_94_21.doEnd();
                                                        //check for one to one 
                                                        RuntimeTagElement _jettag_c_if_98_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_98_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_98_21.setRuntimeParent(_jettag_c_if_92_21);
                                                        _jettag_c_if_98_21.setTagInfo(_td_c_if_98_21);
                                                        _jettag_c_if_98_21.doStart(context, out);
                                                        while (_jettag_c_if_98_21.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_99_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_99_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_99_21.setRuntimeParent(_jettag_c_if_98_21);
                                                            _jettag_c_if_99_21.setTagInfo(_td_c_if_99_21);
                                                            _jettag_c_if_99_21.doStart(context, out);
                                                            while (_jettag_c_if_99_21.okToProcessBody()) {
                                                                out.write("\t\t\t  \t\t\t\t\t    \t\t\t\t\t\t\ttable.setText(0, ");  //$NON-NLS-1$        
                                                                out.write( x++ );
                                                                out.write(", \"");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 100, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("\");");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_99_21.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_99_21.doEnd();
                                                            _jettag_c_if_98_21.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_98_21.doEnd();
                                                        _jettag_c_if_92_21.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_92_21.doEnd();
                                                    _jettag_c_if_91_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_91_19.doEnd();
                                                _jettag_c_if_88_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_88_19.doEnd();
                                            _jettag_c_iterate_87_18.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_87_18.doEnd();
                                        _jettag_c_if_85_17.handleBodyContent(out);
                                    }
                                    _jettag_c_if_85_17.doEnd();
                                    _jettag_c_iterate_82_15.handleBodyContent(out);
                                }
                                _jettag_c_iterate_82_15.doEnd();
                                _jettag_c_if_80_9.handleBodyContent(out);
                            }
                            _jettag_c_if_80_9.doEnd();
                            _jettag_c_iterate_77_6.handleBodyContent(out);
                        }
                        _jettag_c_iterate_77_6.doEnd();
                        _jettag_c_iterate_76_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_76_5.doEnd();
                    _jettag_c_iterate_75_4.handleBodyContent(out);
                }
                _jettag_c_iterate_75_4.doEnd();
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_114_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_114_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_114_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_114_1.setTagInfo(_td_f_message_114_1);
                _jettag_f_message_114_1.doStart(context, out);
                JET2Writer _jettag_f_message_114_1_saved_out = out;
                while (_jettag_f_message_114_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_114_1.handleBodyContent(out);
                }
                out = _jettag_f_message_114_1_saved_out;
                _jettag_f_message_114_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void fillData(List<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 116, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> entities) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tint i = 1;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tfor (");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 118, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity : entities) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tcreateViewIcon(i, entity.getId());");  //$NON-NLS-1$        
                out.write(NL);         
        
        			int y = 1;
        			
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_124_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_124_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_124_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_124_4.setTagInfo(_td_c_if_124_4);
                _jettag_c_if_124_4.doStart(context, out);
                while (_jettag_c_if_124_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_125_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_125_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_125_4.setRuntimeParent(_jettag_c_if_124_4);
                    _jettag_c_iterate_125_4.setTagInfo(_td_c_iterate_125_4);
                    _jettag_c_iterate_125_4.doStart(context, out);
                    while (_jettag_c_iterate_125_4.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_126_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_126_8); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_126_8.setRuntimeParent(_jettag_c_iterate_125_4);
                        _jettag_c_choose_126_8.setTagInfo(_td_c_choose_126_8);
                        _jettag_c_choose_126_8.doStart(context, out);
                        JET2Writer _jettag_c_choose_126_8_saved_out = out;
                        while (_jettag_c_choose_126_8.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_when_127_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_127_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_127_9.setRuntimeParent(_jettag_c_choose_126_8);
                            _jettag_c_when_127_9.setTagInfo(_td_c_when_127_9);
                            _jettag_c_when_127_9.doStart(context, out);
                            JET2Writer _jettag_c_when_127_9_saved_out = out;
                            while (_jettag_c_when_127_9.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("\t\t\t\t\t\t  \t\ttable.setText(i, ");  //$NON-NLS-1$        
                                out.write( y++ );
                                out.write(", Utils.getShortDate(entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 128, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("())); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_127_9.handleBodyContent(out);
                            }
                            out = _jettag_c_when_127_9_saved_out;
                            _jettag_c_when_127_9.doEnd();
                            RuntimeTagElement _jettag_c_when_130_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_130_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_130_9.setRuntimeParent(_jettag_c_choose_126_8);
                            _jettag_c_when_130_9.setTagInfo(_td_c_when_130_9);
                            _jettag_c_when_130_9.doStart(context, out);
                            JET2Writer _jettag_c_when_130_9_saved_out = out;
                            while (_jettag_c_when_130_9.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("\t\t\t\t\t\t  \t\ttable.setWidget(i, ");  //$NON-NLS-1$        
                                out.write( y++ );
                                out.write(", new ImageField(\"\",\"\",\"\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 131, 73)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("Welcome.constants");  //$NON-NLS-1$        
                                out.write(NL);         
                                out.write("\t\t\t\t\t\t\t\t.imagesTargetDirectory() + entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 132, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(),100,100)); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_130_9.handleBodyContent(out);
                            }
                            out = _jettag_c_when_130_9_saved_out;
                            _jettag_c_when_130_9.doEnd();
                            RuntimeTagElement _jettag_c_when_134_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_134_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_134_9.setRuntimeParent(_jettag_c_choose_126_8);
                            _jettag_c_when_134_9.setTagInfo(_td_c_when_134_9);
                            _jettag_c_when_134_9.doStart(context, out);
                            JET2Writer _jettag_c_when_134_9_saved_out = out;
                            while (_jettag_c_when_134_9.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("\t\t\t\t\t\t \t\ttable.setText(i, ");  //$NON-NLS-1$        
                                out.write( y++ );
                                out.write(", CurrencyField.format(entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 135, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()));");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_134_9.handleBodyContent(out);
                            }
                            out = _jettag_c_when_134_9_saved_out;
                            _jettag_c_when_134_9.doEnd();
                            RuntimeTagElement _jettag_c_when_137_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_137_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_137_9.setRuntimeParent(_jettag_c_choose_126_8);
                            _jettag_c_when_137_9.setTagInfo(_td_c_when_137_9);
                            _jettag_c_when_137_9.doStart(context, out);
                            JET2Writer _jettag_c_when_137_9_saved_out = out;
                            while (_jettag_c_when_137_9.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("\t\t\t\t\t\t  \t\ttable.setHTML(i, ");  //$NON-NLS-1$        
                                out.write( y++ );
                                out.write(", Utils.entityToString(entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 138, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("())); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_137_9.handleBodyContent(out);
                            }
                            out = _jettag_c_when_137_9_saved_out;
                            _jettag_c_when_137_9.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_140_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_140_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_140_9.setRuntimeParent(_jettag_c_choose_126_8);
                            _jettag_c_otherwise_140_9.setTagInfo(_td_c_otherwise_140_9);
                            _jettag_c_otherwise_140_9.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_140_9_saved_out = out;
                            while (_jettag_c_otherwise_140_9.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("\t\t\t\t\t\t\t\ttable.setText(i, ");  //$NON-NLS-1$        
                                out.write( y++ );
                                out.write(", Utils.entityToString(entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 141, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()));");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_otherwise_140_9.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_140_9_saved_out;
                            _jettag_c_otherwise_140_9.doEnd();
                            _jettag_c_choose_126_8.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_126_8_saved_out;
                        _jettag_c_choose_126_8.doEnd();
                        _jettag_c_iterate_125_4.handleBodyContent(out);
                    }
                    _jettag_c_iterate_125_4.doEnd();
                    _jettag_c_if_124_4.handleBodyContent(out);
                }
                _jettag_c_if_124_4.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_147_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_147_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_147_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_147_4.setTagInfo(_td_c_if_147_4);
                _jettag_c_if_147_4.doStart(context, out);
                while (_jettag_c_if_147_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_148_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_148_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_148_4.setRuntimeParent(_jettag_c_if_147_4);
                    _jettag_c_iterate_148_4.setTagInfo(_td_c_iterate_148_4);
                    _jettag_c_iterate_148_4.doStart(context, out);
                    while (_jettag_c_iterate_148_4.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_149_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_149_14); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_149_14.setRuntimeParent(_jettag_c_iterate_148_4);
                        _jettag_c_choose_149_14.setTagInfo(_td_c_choose_149_14);
                        _jettag_c_choose_149_14.doStart(context, out);
                        JET2Writer _jettag_c_choose_149_14_saved_out = out;
                        while (_jettag_c_choose_149_14.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_when_150_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_150_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_150_9.setRuntimeParent(_jettag_c_choose_149_14);
                            _jettag_c_when_150_9.setTagInfo(_td_c_when_150_9);
                            _jettag_c_when_150_9.doStart(context, out);
                            JET2Writer _jettag_c_when_150_9_saved_out = out;
                            while (_jettag_c_when_150_9.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("\t\t\t\t\t\t  \t\ttable.setText(i, ");  //$NON-NLS-1$        
                                out.write( y++ );
                                out.write(", Utils.getShortDate(entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 151, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("())); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_150_9.handleBodyContent(out);
                            }
                            out = _jettag_c_when_150_9_saved_out;
                            _jettag_c_when_150_9.doEnd();
                            RuntimeTagElement _jettag_c_when_153_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_153_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_153_9.setRuntimeParent(_jettag_c_choose_149_14);
                            _jettag_c_when_153_9.setTagInfo(_td_c_when_153_9);
                            _jettag_c_when_153_9.doStart(context, out);
                            JET2Writer _jettag_c_when_153_9_saved_out = out;
                            while (_jettag_c_when_153_9.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("\t\t\t\t\t\t  \t\ttable.setWidget(i, ");  //$NON-NLS-1$        
                                out.write( y++ );
                                out.write(", new ImageField(\"\",\"\",\"\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 154, 73)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("Welcome.constants");  //$NON-NLS-1$        
                                out.write(NL);         
                                out.write("\t\t\t\t\t\t\t\t.imagesTargetDirectory() + entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 155, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(),100,100)); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_153_9.handleBodyContent(out);
                            }
                            out = _jettag_c_when_153_9_saved_out;
                            _jettag_c_when_153_9.doEnd();
                            RuntimeTagElement _jettag_c_when_157_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_157_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_157_9.setRuntimeParent(_jettag_c_choose_149_14);
                            _jettag_c_when_157_9.setTagInfo(_td_c_when_157_9);
                            _jettag_c_when_157_9.doStart(context, out);
                            JET2Writer _jettag_c_when_157_9_saved_out = out;
                            while (_jettag_c_when_157_9.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("\t\t\t\t\t\t \t\ttable.setText(i, ");  //$NON-NLS-1$        
                                out.write( y++ );
                                out.write(", CurrencyField.format(entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 158, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()));");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_157_9.handleBodyContent(out);
                            }
                            out = _jettag_c_when_157_9_saved_out;
                            _jettag_c_when_157_9.doEnd();
                            RuntimeTagElement _jettag_c_when_160_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_160_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_160_9.setRuntimeParent(_jettag_c_choose_149_14);
                            _jettag_c_when_160_9.setTagInfo(_td_c_when_160_9);
                            _jettag_c_when_160_9.doStart(context, out);
                            JET2Writer _jettag_c_when_160_9_saved_out = out;
                            while (_jettag_c_when_160_9.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("\t\t\t\t\t\t  \t\ttable.setHTML(i, ");  //$NON-NLS-1$        
                                out.write( y++ );
                                out.write(", Utils.entityToString(entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 161, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("())); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_160_9.handleBodyContent(out);
                            }
                            out = _jettag_c_when_160_9_saved_out;
                            _jettag_c_when_160_9.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_163_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_163_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_163_9.setRuntimeParent(_jettag_c_choose_149_14);
                            _jettag_c_otherwise_163_9.setTagInfo(_td_c_otherwise_163_9);
                            _jettag_c_otherwise_163_9.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_163_9_saved_out = out;
                            while (_jettag_c_otherwise_163_9.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("\t\t\t\t\t\t\t\ttable.setText(i, ");  //$NON-NLS-1$        
                                out.write( y++ );
                                out.write(", Utils.entityToString(entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 164, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()));");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_otherwise_163_9.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_163_9_saved_out;
                            _jettag_c_otherwise_163_9.doEnd();
                            _jettag_c_choose_149_14.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_149_14_saved_out;
                        _jettag_c_choose_149_14.doEnd();
                        _jettag_c_iterate_148_4.handleBodyContent(out);
                    }
                    _jettag_c_iterate_148_4.doEnd();
                    _jettag_c_if_147_4.handleBodyContent(out);
                }
                _jettag_c_if_147_4.doEnd();
                // process base class attributes
                RuntimeTagElement _jettag_c_iterate_170_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_170_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_170_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_170_4.setTagInfo(_td_c_iterate_170_4);
                _jettag_c_iterate_170_4.doStart(context, out);
                while (_jettag_c_iterate_170_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_171_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_171_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_171_8.setRuntimeParent(_jettag_c_iterate_170_4);
                    _jettag_c_choose_171_8.setTagInfo(_td_c_choose_171_8);
                    _jettag_c_choose_171_8.doStart(context, out);
                    JET2Writer _jettag_c_choose_171_8_saved_out = out;
                    while (_jettag_c_choose_171_8.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_when_172_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_172_9); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_172_9.setRuntimeParent(_jettag_c_choose_171_8);
                        _jettag_c_when_172_9.setTagInfo(_td_c_when_172_9);
                        _jettag_c_when_172_9.doStart(context, out);
                        JET2Writer _jettag_c_when_172_9_saved_out = out;
                        while (_jettag_c_when_172_9.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t\t\t  \t\ttable.setText(i, ");  //$NON-NLS-1$        
                            out.write( y++ );
                            out.write(", Utils.getShortDate(entity.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 173, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("())); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_172_9.handleBodyContent(out);
                        }
                        out = _jettag_c_when_172_9_saved_out;
                        _jettag_c_when_172_9.doEnd();
                        RuntimeTagElement _jettag_c_when_175_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_175_9); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_175_9.setRuntimeParent(_jettag_c_choose_171_8);
                        _jettag_c_when_175_9.setTagInfo(_td_c_when_175_9);
                        _jettag_c_when_175_9.doStart(context, out);
                        JET2Writer _jettag_c_when_175_9_saved_out = out;
                        while (_jettag_c_when_175_9.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t\t\t  \t\ttable.setWidget(i, ");  //$NON-NLS-1$        
                            out.write( y++ );
                            out.write(", new ImageField(\"\",\"\",\"\", true, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 176, 73)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("Welcome.constants");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t.imagesTargetDirectory() + entity.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 177, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(),100,100)); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_175_9.handleBodyContent(out);
                        }
                        out = _jettag_c_when_175_9_saved_out;
                        _jettag_c_when_175_9.doEnd();
                        RuntimeTagElement _jettag_c_when_179_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_179_9); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_179_9.setRuntimeParent(_jettag_c_choose_171_8);
                        _jettag_c_when_179_9.setTagInfo(_td_c_when_179_9);
                        _jettag_c_when_179_9.doStart(context, out);
                        JET2Writer _jettag_c_when_179_9_saved_out = out;
                        while (_jettag_c_when_179_9.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t\t\t \t\ttable.setText(i, ");  //$NON-NLS-1$        
                            out.write( y++ );
                            out.write(", CurrencyField.format(entity.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 180, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()));");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_179_9.handleBodyContent(out);
                        }
                        out = _jettag_c_when_179_9_saved_out;
                        _jettag_c_when_179_9.doEnd();
                        RuntimeTagElement _jettag_c_when_182_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_182_9); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_182_9.setRuntimeParent(_jettag_c_choose_171_8);
                        _jettag_c_when_182_9.setTagInfo(_td_c_when_182_9);
                        _jettag_c_when_182_9.doStart(context, out);
                        JET2Writer _jettag_c_when_182_9_saved_out = out;
                        while (_jettag_c_when_182_9.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t\t\t  \t\ttable.setHTML(i, ");  //$NON-NLS-1$        
                            out.write( y++ );
                            out.write(", Utils.entityToString(entity.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 183, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("())); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_182_9.handleBodyContent(out);
                        }
                        out = _jettag_c_when_182_9_saved_out;
                        _jettag_c_when_182_9.doEnd();
                        RuntimeTagElement _jettag_c_otherwise_185_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_185_9); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_185_9.setRuntimeParent(_jettag_c_choose_171_8);
                        _jettag_c_otherwise_185_9.setTagInfo(_td_c_otherwise_185_9);
                        _jettag_c_otherwise_185_9.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_185_9_saved_out = out;
                        while (_jettag_c_otherwise_185_9.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t\t\t\t\ttable.setText(i, ");  //$NON-NLS-1$        
                            out.write( y++ );
                            out.write(", Utils.entityToString(entity.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 186, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()));");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_otherwise_185_9.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_185_9_saved_out;
                        _jettag_c_otherwise_185_9.doEnd();
                        _jettag_c_choose_171_8.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_171_8_saved_out;
                    _jettag_c_choose_171_8.doEnd();
                    _jettag_c_iterate_170_4.handleBodyContent(out);
                }
                _jettag_c_iterate_170_4.doEnd();
                // process dropdowns one to one and many to one unidirectional
                RuntimeTagElement _jettag_c_iterate_191_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_191_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_191_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_191_4.setTagInfo(_td_c_iterate_191_4);
                _jettag_c_iterate_191_4.doStart(context, out);
                while (_jettag_c_iterate_191_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_192_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_192_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_192_5.setRuntimeParent(_jettag_c_iterate_191_4);
                    _jettag_c_iterate_192_5.setTagInfo(_td_c_iterate_192_5);
                    _jettag_c_iterate_192_5.doStart(context, out);
                    while (_jettag_c_iterate_192_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_193_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_193_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_193_6.setRuntimeParent(_jettag_c_iterate_192_5);
                        _jettag_c_iterate_193_6.setTagInfo(_td_c_iterate_193_6);
                        _jettag_c_iterate_193_6.doStart(context, out);
                        while (_jettag_c_iterate_193_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_194_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_194_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_194_7.setRuntimeParent(_jettag_c_iterate_193_6);
                            _jettag_c_setVariable_194_7.setTagInfo(_td_c_setVariable_194_7);
                            _jettag_c_setVariable_194_7.doStart(context, out);
                            _jettag_c_setVariable_194_7.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_196_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_196_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_196_9.setRuntimeParent(_jettag_c_iterate_193_6);
                            _jettag_c_if_196_9.setTagInfo(_td_c_if_196_9);
                            _jettag_c_if_196_9.doStart(context, out);
                            while (_jettag_c_if_196_9.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_198_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_198_15); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_198_15.setRuntimeParent(_jettag_c_if_196_9);
                                _jettag_c_iterate_198_15.setTagInfo(_td_c_iterate_198_15);
                                _jettag_c_iterate_198_15.doStart(context, out);
                                while (_jettag_c_iterate_198_15.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_199_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_199_15); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_199_15.setRuntimeParent(_jettag_c_iterate_198_15);
                                    _jettag_c_setVariable_199_15.setTagInfo(_td_c_setVariable_199_15);
                                    _jettag_c_setVariable_199_15.doStart(context, out);
                                    _jettag_c_setVariable_199_15.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_201_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_201_17); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_201_17.setRuntimeParent(_jettag_c_iterate_198_15);
                                    _jettag_c_if_201_17.setTagInfo(_td_c_if_201_17);
                                    _jettag_c_if_201_17.doStart(context, out);
                                    while (_jettag_c_if_201_17.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_203_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_203_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_203_18.setRuntimeParent(_jettag_c_if_201_17);
                                        _jettag_c_iterate_203_18.setTagInfo(_td_c_iterate_203_18);
                                        _jettag_c_iterate_203_18.doStart(context, out);
                                        while (_jettag_c_iterate_203_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_204_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_204_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_204_19.setRuntimeParent(_jettag_c_iterate_203_18);
                                            _jettag_c_if_204_19.setTagInfo(_td_c_if_204_19);
                                            _jettag_c_if_204_19.doStart(context, out);
                                            while (_jettag_c_if_204_19.okToProcessBody()) {
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                RuntimeTagElement _jettag_c_if_207_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_207_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_207_19.setRuntimeParent(_jettag_c_if_204_19);
                                                _jettag_c_if_207_19.setTagInfo(_td_c_if_207_19);
                                                _jettag_c_if_207_19.doStart(context, out);
                                                while (_jettag_c_if_207_19.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_208_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_208_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_208_21.setRuntimeParent(_jettag_c_if_207_19);
                                                    _jettag_c_if_208_21.setTagInfo(_td_c_if_208_21);
                                                    _jettag_c_if_208_21.doStart(context, out);
                                                    while (_jettag_c_if_208_21.okToProcessBody()) {
                                                        //check for Many to one unidirectional
                                                        RuntimeTagElement _jettag_c_if_210_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_210_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_210_21.setRuntimeParent(_jettag_c_if_208_21);
                                                        _jettag_c_if_210_21.setTagInfo(_td_c_if_210_21);
                                                        _jettag_c_if_210_21.doStart(context, out);
                                                        while (_jettag_c_if_210_21.okToProcessBody()) {
                                                            out.write("\t\t\t  \t\t\t\t\t    \t\t\t\t\t\t\t\ttable.setText(i, ");  //$NON-NLS-1$        
                                                            out.write( y++ );
                                                            out.write(", Utils.entityToString(entity.get");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 211, 83)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("()));");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_210_21.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_210_21.doEnd();
                                                        //check for one to one 
                                                        RuntimeTagElement _jettag_c_if_214_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_214_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_214_21.setRuntimeParent(_jettag_c_if_208_21);
                                                        _jettag_c_if_214_21.setTagInfo(_td_c_if_214_21);
                                                        _jettag_c_if_214_21.doStart(context, out);
                                                        while (_jettag_c_if_214_21.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_215_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_215_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_215_21.setRuntimeParent(_jettag_c_if_214_21);
                                                            _jettag_c_if_215_21.setTagInfo(_td_c_if_215_21);
                                                            _jettag_c_if_215_21.doStart(context, out);
                                                            while (_jettag_c_if_215_21.okToProcessBody()) {
                                                                out.write("\t\t\t  \t\t\t\t\t    \t\t\t\t\t\t\ttable.setText(i, ");  //$NON-NLS-1$        
                                                                out.write( y++ );
                                                                out.write(", Utils.entityToString(entity.get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 216, 82)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("()));");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_215_21.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_215_21.doEnd();
                                                            _jettag_c_if_214_21.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_214_21.doEnd();
                                                        _jettag_c_if_208_21.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_208_21.doEnd();
                                                    _jettag_c_if_207_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_207_19.doEnd();
                                                _jettag_c_if_204_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_204_19.doEnd();
                                            _jettag_c_iterate_203_18.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_203_18.doEnd();
                                        _jettag_c_if_201_17.handleBodyContent(out);
                                    }
                                    _jettag_c_if_201_17.doEnd();
                                    _jettag_c_iterate_198_15.handleBodyContent(out);
                                }
                                _jettag_c_iterate_198_15.doEnd();
                                _jettag_c_if_196_9.handleBodyContent(out);
                            }
                            _jettag_c_if_196_9.doEnd();
                            _jettag_c_iterate_193_6.handleBodyContent(out);
                        }
                        _jettag_c_iterate_193_6.doEnd();
                        _jettag_c_iterate_192_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_192_5.doEnd();
                    _jettag_c_iterate_191_4.handleBodyContent(out);
                }
                _jettag_c_iterate_191_4.doEnd();
                out.write("\t\t\ti++;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_233_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_233_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_233_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_233_1.setTagInfo(_td_f_message_233_1);
                _jettag_f_message_233_1.doStart(context, out);
                JET2Writer _jettag_f_message_233_1_saved_out = out;
                while (_jettag_f_message_233_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_233_1.handleBodyContent(out);
                }
                out = _jettag_f_message_233_1_saved_out;
                _jettag_f_message_233_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void preFetchTable(int start) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tif (");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 236, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("TableType.READALL.equals(tableType)) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$packageName}", 237, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 237, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 237, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Service.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 237, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceAsync.instance().getTableObj(start, new ALAsyncCallback<TableObj<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 237, 158)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(">>() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t\t\t\t\t\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\tpublic void onResponse(TableObj<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 240, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> tableObj) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\t\tpostFetchTable(tableObj);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t\t\t\t\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t\t\t\t\t});");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tif (");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 247, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("TableType.READALL_SEARCH.equals(tableType)) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$packageName}", 248, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 248, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 248, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Service.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 248, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceAsync.instance().getEntities(");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 249, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("SearchPanelGeneric.instance().getEntity(),");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\tnew ALAsyncCallback<List<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 250, 31)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(">>() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t\t\t\t\t\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\tpublic void onResponse(List<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 253, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> arg0) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\t\tpostFetchTable(arg0);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t\t\t\t\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t\t\t\t\t});");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_262_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_262_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_262_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_262_1.setTagInfo(_td_f_message_262_1);
                _jettag_f_message_262_1.doStart(context, out);
                JET2Writer _jettag_f_message_262_1_saved_out = out;
                while (_jettag_f_message_262_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_262_1.handleBodyContent(out);
                }
                out = _jettag_f_message_262_1_saved_out;
                _jettag_f_message_262_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void viewClicked(int row, int col) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 265, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().getEntityPanel().clear();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 266, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().getEntityPanel().add(");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tnew Read");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 267, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely(getEntityId(row)));");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 268, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().getSidePanelTop().clear();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 269, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().getSidePanelTop()");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t.add(new Tree");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 270, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel());");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_c_if_273_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_273_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_273_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_273_1.setTagInfo(_td_c_if_273_1);
                _jettag_c_if_273_1.doStart(context, out);
                while (_jettag_c_if_273_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_f_message_274_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_274_1); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_f_message_274_1.setRuntimeParent(_jettag_c_if_273_1);
                    _jettag_f_message_274_1.setTagInfo(_td_f_message_274_1);
                    _jettag_f_message_274_1.doStart(context, out);
                    JET2Writer _jettag_f_message_274_1_saved_out = out;
                    while (_jettag_f_message_274_1.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("generated.comment");  //$NON-NLS-1$        
                        _jettag_f_message_274_1.handleBodyContent(out);
                    }
                    out = _jettag_f_message_274_1_saved_out;
                    _jettag_f_message_274_1.doEnd();
                    out.write("\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\tpublic void refresh() {");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\tparentTree.treeNodeSelected(Utils.getClassSimpleName(parentTreeClass));");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t}");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_273_1.handleBodyContent(out);
                }
                _jettag_c_if_273_1.doEnd();
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
