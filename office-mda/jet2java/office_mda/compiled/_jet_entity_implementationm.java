package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_entity_implementationm implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$

    public _jet_entity_implementationm() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_c_replaceStrings_1_10 = new TagInfo("c:replaceStrings", //$NON-NLS-1$
            1, 10,
            new String[] {
                "replace", //$NON-NLS-1$
                "with", //$NON-NLS-1$
            },
            new String[] {
                ".", //$NON-NLS-1$
                "_", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_replaceStrings_4_17 = new TagInfo("c:replaceStrings", //$NON-NLS-1$
            4, 17,
            new String[] {
                "replace", //$NON-NLS-1$
                "with", //$NON-NLS-1$
            },
            new String[] {
                ".", //$NON-NLS-1$
                "_", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_5_1 = new TagInfo("c:if", //$NON-NLS-1$
            5, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@parentClass1Name = $class/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_9_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            9, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_10_3 = new TagInfo("c:choose", //$NON-NLS-1$
            10, 3,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_11_4 = new TagInfo("c:when", //$NON-NLS-1$
            11, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_14_4 = new TagInfo("c:when", //$NON-NLS-1$
            14, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_17_4 = new TagInfo("c:when", //$NON-NLS-1$
            17, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_20_4 = new TagInfo("c:when", //$NON-NLS-1$
            20, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_23_4 = new TagInfo("c:when", //$NON-NLS-1$
            23, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_26_4 = new TagInfo("c:when", //$NON-NLS-1$
            26, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_29_3 = new TagInfo("c:otherwise", //$NON-NLS-1$
            29, 3,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_30_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            30, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_31_6 = new TagInfo("c:if", //$NON-NLS-1$
            31, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_39_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            39, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_40_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            40, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_41_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            41, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_42_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            42, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_44_6 = new TagInfo("c:if", //$NON-NLS-1$
            44, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_46_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            46, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_47_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            47, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_49_14 = new TagInfo("c:if", //$NON-NLS-1$
            49, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_51_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            51, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_52_16 = new TagInfo("c:if", //$NON-NLS-1$
            52, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_54_13 = new TagInfo("c:if", //$NON-NLS-1$
            54, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_57_16 = new TagInfo("c:if", //$NON-NLS-1$
            57, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_58_18 = new TagInfo("c:if", //$NON-NLS-1$
            58, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_63_17 = new TagInfo("c:if", //$NON-NLS-1$
            63, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_64_18 = new TagInfo("c:if", //$NON-NLS-1$
            64, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_81_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            81, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_82_4 = new TagInfo("c:choose", //$NON-NLS-1$
            82, 4,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_83_5 = new TagInfo("c:when", //$NON-NLS-1$
            83, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_89_5 = new TagInfo("c:when", //$NON-NLS-1$
            89, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_92_5 = new TagInfo("c:when", //$NON-NLS-1$
            92, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_95_5 = new TagInfo("c:when", //$NON-NLS-1$
            95, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_98_5 = new TagInfo("c:when", //$NON-NLS-1$
            98, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_101_5 = new TagInfo("c:when", //$NON-NLS-1$
            101, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_104_4 = new TagInfo("c:otherwise", //$NON-NLS-1$
            104, 4,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_105_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            105, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_106_7 = new TagInfo("c:if", //$NON-NLS-1$
            106, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_119_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            119, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_120_3 = new TagInfo("c:choose", //$NON-NLS-1$
            120, 3,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_121_4 = new TagInfo("c:when", //$NON-NLS-1$
            121, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_125_4 = new TagInfo("c:when", //$NON-NLS-1$
            125, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_129_4 = new TagInfo("c:when", //$NON-NLS-1$
            129, 4,
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
    private static final TagInfo _td_c_when_135_4 = new TagInfo("c:when", //$NON-NLS-1$
            135, 4,
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
    private static final TagInfo _td_c_otherwise_143_3 = new TagInfo("c:otherwise", //$NON-NLS-1$
            143, 3,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_144_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            144, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_145_6 = new TagInfo("c:if", //$NON-NLS-1$
            145, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("#import \"");  //$NON-NLS-1$        
        RuntimeTagElement _jettag_c_replaceStrings_1_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "replaceStrings", "c:replaceStrings", _td_c_replaceStrings_1_10); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_replaceStrings_1_10.setRuntimeParent(null);
        _jettag_c_replaceStrings_1_10.setTagInfo(_td_c_replaceStrings_1_10);
        _jettag_c_replaceStrings_1_10.doStart(context, out);
        JET2Writer _jettag_c_replaceStrings_1_10_saved_out = out;
        while (_jettag_c_replaceStrings_1_10.okToProcessBody()) {
            out = out.newNestedContentWriter();
            out.write(context.embeddedExpressionAsString("${$groupID}", 1, 49)); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_replaceStrings_1_10.handleBodyContent(out);
        }
        out = _jettag_c_replaceStrings_1_10_saved_out;
        _jettag_c_replaceStrings_1_10.doEnd();
        out.write("_entity_");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 1, 87)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("_");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 1, 117)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".h\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write(NL);         
        out.write("@implementation ");  //$NON-NLS-1$        
        RuntimeTagElement _jettag_c_replaceStrings_4_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "replaceStrings", "c:replaceStrings", _td_c_replaceStrings_4_17); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_replaceStrings_4_17.setRuntimeParent(null);
        _jettag_c_replaceStrings_4_17.setTagInfo(_td_c_replaceStrings_4_17);
        _jettag_c_replaceStrings_4_17.doStart(context, out);
        JET2Writer _jettag_c_replaceStrings_4_17_saved_out = out;
        while (_jettag_c_replaceStrings_4_17.okToProcessBody()) {
            out = out.newNestedContentWriter();
            out.write(context.embeddedExpressionAsString("${$groupID}", 4, 56)); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_replaceStrings_4_17.handleBodyContent(out);
        }
        out = _jettag_c_replaceStrings_4_17_saved_out;
        _jettag_c_replaceStrings_4_17.doEnd();
        out.write("_entity_");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 4, 94)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("_");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 4, 124)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(NL);         
        RuntimeTagElement _jettag_c_if_5_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_5_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_5_1.setRuntimeParent(null);
        _jettag_c_if_5_1.setTagInfo(_td_c_if_5_1);
        _jettag_c_if_5_1.doStart(context, out);
        while (_jettag_c_if_5_1.okToProcessBody()) {
            out.write("\t@synthesize entityID; ");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_c_if_5_1.handleBodyContent(out);
        }
        _jettag_c_if_5_1.doEnd();
        // processes the premitive Datatypes and enums
        RuntimeTagElement _jettag_c_iterate_9_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_9_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_9_1.setRuntimeParent(null);
        _jettag_c_iterate_9_1.setTagInfo(_td_c_iterate_9_1);
        _jettag_c_iterate_9_1.doStart(context, out);
        while (_jettag_c_iterate_9_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_choose_10_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_10_3); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_choose_10_3.setRuntimeParent(_jettag_c_iterate_9_1);
            _jettag_c_choose_10_3.setTagInfo(_td_c_choose_10_3);
            _jettag_c_choose_10_3.doStart(context, out);
            JET2Writer _jettag_c_choose_10_3_saved_out = out;
            while (_jettag_c_choose_10_3.okToProcessBody()) {
                out = out.newNestedContentWriter();
                RuntimeTagElement _jettag_c_when_11_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_11_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_11_4.setRuntimeParent(_jettag_c_choose_10_3);
                _jettag_c_when_11_4.setTagInfo(_td_c_when_11_4);
                _jettag_c_when_11_4.doStart(context, out);
                JET2Writer _jettag_c_when_11_4_saved_out = out;
                while (_jettag_c_when_11_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t  @synthesize ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 12, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(";");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_11_4.handleBodyContent(out);
                }
                out = _jettag_c_when_11_4_saved_out;
                _jettag_c_when_11_4.doEnd();
                RuntimeTagElement _jettag_c_when_14_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_14_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_14_4.setRuntimeParent(_jettag_c_choose_10_3);
                _jettag_c_when_14_4.setTagInfo(_td_c_when_14_4);
                _jettag_c_when_14_4.doStart(context, out);
                JET2Writer _jettag_c_when_14_4_saved_out = out;
                while (_jettag_c_when_14_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t  @synthesize ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 15, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(";");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_14_4.handleBodyContent(out);
                }
                out = _jettag_c_when_14_4_saved_out;
                _jettag_c_when_14_4.doEnd();
                RuntimeTagElement _jettag_c_when_17_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_17_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_17_4.setRuntimeParent(_jettag_c_choose_10_3);
                _jettag_c_when_17_4.setTagInfo(_td_c_when_17_4);
                _jettag_c_when_17_4.doStart(context, out);
                JET2Writer _jettag_c_when_17_4_saved_out = out;
                while (_jettag_c_when_17_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t  @synthesize ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 18, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(";");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_17_4.handleBodyContent(out);
                }
                out = _jettag_c_when_17_4_saved_out;
                _jettag_c_when_17_4.doEnd();
                RuntimeTagElement _jettag_c_when_20_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_20_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_20_4.setRuntimeParent(_jettag_c_choose_10_3);
                _jettag_c_when_20_4.setTagInfo(_td_c_when_20_4);
                _jettag_c_when_20_4.doStart(context, out);
                JET2Writer _jettag_c_when_20_4_saved_out = out;
                while (_jettag_c_when_20_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t  @synthesize ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 21, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(";");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_20_4.handleBodyContent(out);
                }
                out = _jettag_c_when_20_4_saved_out;
                _jettag_c_when_20_4.doEnd();
                RuntimeTagElement _jettag_c_when_23_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_23_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_23_4.setRuntimeParent(_jettag_c_choose_10_3);
                _jettag_c_when_23_4.setTagInfo(_td_c_when_23_4);
                _jettag_c_when_23_4.doStart(context, out);
                JET2Writer _jettag_c_when_23_4_saved_out = out;
                while (_jettag_c_when_23_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t  @synthesize ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 24, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(";");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_23_4.handleBodyContent(out);
                }
                out = _jettag_c_when_23_4_saved_out;
                _jettag_c_when_23_4.doEnd();
                RuntimeTagElement _jettag_c_when_26_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_26_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_26_4.setRuntimeParent(_jettag_c_choose_10_3);
                _jettag_c_when_26_4.setTagInfo(_td_c_when_26_4);
                _jettag_c_when_26_4.doStart(context, out);
                JET2Writer _jettag_c_when_26_4_saved_out = out;
                while (_jettag_c_when_26_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t  @synthesize ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 27, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(";");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_26_4.handleBodyContent(out);
                }
                out = _jettag_c_when_26_4_saved_out;
                _jettag_c_when_26_4.doEnd();
                RuntimeTagElement _jettag_c_otherwise_29_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_29_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_otherwise_29_3.setRuntimeParent(_jettag_c_choose_10_3);
                _jettag_c_otherwise_29_3.setTagInfo(_td_c_otherwise_29_3);
                _jettag_c_otherwise_29_3.doStart(context, out);
                JET2Writer _jettag_c_otherwise_29_3_saved_out = out;
                while (_jettag_c_otherwise_29_3.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_iterate_30_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_30_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_30_4.setRuntimeParent(_jettag_c_otherwise_29_3);
                    _jettag_c_iterate_30_4.setTagInfo(_td_c_iterate_30_4);
                    _jettag_c_iterate_30_4.doStart(context, out);
                    while (_jettag_c_iterate_30_4.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_if_31_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_31_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_31_6.setRuntimeParent(_jettag_c_iterate_30_4);
                        _jettag_c_if_31_6.setTagInfo(_td_c_if_31_6);
                        _jettag_c_if_31_6.doStart(context, out);
                        while (_jettag_c_if_31_6.okToProcessBody()) {
                            // add  enums support
                            _jettag_c_if_31_6.handleBodyContent(out);
                        }
                        _jettag_c_if_31_6.doEnd();
                        _jettag_c_iterate_30_4.handleBodyContent(out);
                    }
                    _jettag_c_iterate_30_4.doEnd();
                    _jettag_c_otherwise_29_3.handleBodyContent(out);
                }
                out = _jettag_c_otherwise_29_3_saved_out;
                _jettag_c_otherwise_29_3.doEnd();
                _jettag_c_choose_10_3.handleBodyContent(out);
            }
            out = _jettag_c_choose_10_3_saved_out;
            _jettag_c_choose_10_3.doEnd();
            _jettag_c_iterate_9_1.handleBodyContent(out);
        }
        _jettag_c_iterate_9_1.doEnd();
        // collections and user defined Datatypes 
        RuntimeTagElement _jettag_c_iterate_39_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_39_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_39_1.setRuntimeParent(null);
        _jettag_c_iterate_39_1.setTagInfo(_td_c_iterate_39_1);
        _jettag_c_iterate_39_1.doStart(context, out);
        while (_jettag_c_iterate_39_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_40_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_40_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_40_2.setRuntimeParent(_jettag_c_iterate_39_1);
            _jettag_c_iterate_40_2.setTagInfo(_td_c_iterate_40_2);
            _jettag_c_iterate_40_2.doStart(context, out);
            while (_jettag_c_iterate_40_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_41_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_41_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_41_3.setRuntimeParent(_jettag_c_iterate_40_2);
                _jettag_c_iterate_41_3.setTagInfo(_td_c_iterate_41_3);
                _jettag_c_iterate_41_3.doStart(context, out);
                while (_jettag_c_iterate_41_3.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_42_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_42_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_42_4.setRuntimeParent(_jettag_c_iterate_41_3);
                    _jettag_c_setVariable_42_4.setTagInfo(_td_c_setVariable_42_4);
                    _jettag_c_setVariable_42_4.doStart(context, out);
                    _jettag_c_setVariable_42_4.doEnd();
                    // check is the association is corresponding to the class  
                    RuntimeTagElement _jettag_c_if_44_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_44_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_44_6.setRuntimeParent(_jettag_c_iterate_41_3);
                    _jettag_c_if_44_6.setTagInfo(_td_c_if_44_6);
                    _jettag_c_if_44_6.doStart(context, out);
                    while (_jettag_c_if_44_6.okToProcessBody()) {
                        // iterate over the iterations ends  
                        RuntimeTagElement _jettag_c_iterate_46_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_46_12); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_46_12.setRuntimeParent(_jettag_c_if_44_6);
                        _jettag_c_iterate_46_12.setTagInfo(_td_c_iterate_46_12);
                        _jettag_c_iterate_46_12.doStart(context, out);
                        while (_jettag_c_iterate_46_12.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_47_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_47_12); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_47_12.setRuntimeParent(_jettag_c_iterate_46_12);
                            _jettag_c_setVariable_47_12.setTagInfo(_td_c_setVariable_47_12);
                            _jettag_c_setVariable_47_12.doStart(context, out);
                            _jettag_c_setVariable_47_12.doEnd();
                            // get the end secondary end with other class  
                            RuntimeTagElement _jettag_c_if_49_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_49_14); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_49_14.setRuntimeParent(_jettag_c_iterate_46_12);
                            _jettag_c_if_49_14.setTagInfo(_td_c_if_49_14);
                            _jettag_c_if_49_14.doStart(context, out);
                            while (_jettag_c_if_49_14.okToProcessBody()) {
                                // iterate throught all the classes to get the other class on the association
                                RuntimeTagElement _jettag_c_iterate_51_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_51_15); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_51_15.setRuntimeParent(_jettag_c_if_49_14);
                                _jettag_c_iterate_51_15.setTagInfo(_td_c_iterate_51_15);
                                _jettag_c_iterate_51_15.doStart(context, out);
                                while (_jettag_c_iterate_51_15.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_52_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_52_16); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_52_16.setRuntimeParent(_jettag_c_iterate_51_15);
                                    _jettag_c_if_52_16.setTagInfo(_td_c_if_52_16);
                                    _jettag_c_if_52_16.doStart(context, out);
                                    while (_jettag_c_if_52_16.okToProcessBody()) {
                                        // check to see the association is navigable in the first case
                                        RuntimeTagElement _jettag_c_if_54_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_54_13); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_54_13.setRuntimeParent(_jettag_c_if_52_16);
                                        _jettag_c_if_54_13.setTagInfo(_td_c_if_54_13);
                                        _jettag_c_if_54_13.doStart(context, out);
                                        while (_jettag_c_if_54_13.okToProcessBody()) {
                                            // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                            // check if the multiplicityis one to one
                                            RuntimeTagElement _jettag_c_if_57_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_57_16); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_57_16.setRuntimeParent(_jettag_c_if_54_13);
                                            _jettag_c_if_57_16.setTagInfo(_td_c_if_57_16);
                                            _jettag_c_if_57_16.doStart(context, out);
                                            while (_jettag_c_if_57_16.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_58_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_58_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_58_18.setRuntimeParent(_jettag_c_if_57_16);
                                                _jettag_c_if_58_18.setTagInfo(_td_c_if_58_18);
                                                _jettag_c_if_58_18.doStart(context, out);
                                                while (_jettag_c_if_58_18.okToProcessBody()) {
                                                    out.write("\t@synthesize  ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 59, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(";");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    _jettag_c_if_58_18.handleBodyContent(out);
                                                }
                                                _jettag_c_if_58_18.doEnd();
                                                _jettag_c_if_57_16.handleBodyContent(out);
                                            }
                                            _jettag_c_if_57_16.doEnd();
                                            // check if the multiplicityis one to many
                                            RuntimeTagElement _jettag_c_if_63_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_63_17); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_63_17.setRuntimeParent(_jettag_c_if_54_13);
                                            _jettag_c_if_63_17.setTagInfo(_td_c_if_63_17);
                                            _jettag_c_if_63_17.doStart(context, out);
                                            while (_jettag_c_if_63_17.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_64_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_64_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_64_18.setRuntimeParent(_jettag_c_if_63_17);
                                                _jettag_c_if_64_18.setTagInfo(_td_c_if_64_18);
                                                _jettag_c_if_64_18.doStart(context, out);
                                                while (_jettag_c_if_64_18.okToProcessBody()) {
                                                    out.write("// TODO many relations  \t\t\t\t\t    \t\t\t\t\t\t");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    out.write(" //protected \tList<");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 66, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(">  ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 66, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write("s;");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    _jettag_c_if_64_18.handleBodyContent(out);
                                                }
                                                _jettag_c_if_64_18.doEnd();
                                                _jettag_c_if_63_17.handleBodyContent(out);
                                            }
                                            _jettag_c_if_63_17.doEnd();
                                            _jettag_c_if_54_13.handleBodyContent(out);
                                        }
                                        _jettag_c_if_54_13.doEnd();
                                        _jettag_c_if_52_16.handleBodyContent(out);
                                    }
                                    _jettag_c_if_52_16.doEnd();
                                    _jettag_c_iterate_51_15.handleBodyContent(out);
                                }
                                _jettag_c_iterate_51_15.doEnd();
                                _jettag_c_if_49_14.handleBodyContent(out);
                            }
                            _jettag_c_if_49_14.doEnd();
                            _jettag_c_iterate_46_12.handleBodyContent(out);
                        }
                        _jettag_c_iterate_46_12.doEnd();
                        _jettag_c_if_44_6.handleBodyContent(out);
                    }
                    _jettag_c_if_44_6.doEnd();
                    _jettag_c_iterate_41_3.handleBodyContent(out);
                }
                _jettag_c_iterate_41_3.doEnd();
                _jettag_c_iterate_40_2.handleBodyContent(out);
            }
            _jettag_c_iterate_40_2.doEnd();
            _jettag_c_iterate_39_1.handleBodyContent(out);
        }
        _jettag_c_iterate_39_1.doEnd();
        out.write("- (NSString*) description{");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tNSString *localDescription=@\"\";");  //$NON-NLS-1$        
        out.write(NL);         
        // processes the premitive Datatypes and enums
        RuntimeTagElement _jettag_c_iterate_81_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_81_2); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_81_2.setRuntimeParent(null);
        _jettag_c_iterate_81_2.setTagInfo(_td_c_iterate_81_2);
        _jettag_c_iterate_81_2.doStart(context, out);
        while (_jettag_c_iterate_81_2.okToProcessBody()) {
            RuntimeTagElement _jettag_c_choose_82_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_82_4); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_choose_82_4.setRuntimeParent(_jettag_c_iterate_81_2);
            _jettag_c_choose_82_4.setTagInfo(_td_c_choose_82_4);
            _jettag_c_choose_82_4.doStart(context, out);
            JET2Writer _jettag_c_choose_82_4_saved_out = out;
            while (_jettag_c_choose_82_4.okToProcessBody()) {
                out = out.newNestedContentWriter();
                RuntimeTagElement _jettag_c_when_83_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_83_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_83_5.setRuntimeParent(_jettag_c_choose_82_4);
                _jettag_c_when_83_5.setTagInfo(_td_c_when_83_5);
                _jettag_c_when_83_5.doStart(context, out);
                JET2Writer _jettag_c_when_83_5_saved_out = out;
                while (_jettag_c_when_83_5.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t  if (");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 84, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("!=nil){");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t  localDescription= [localDescription stringByAppendingString:");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 85, 65)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t  localDescription= [localDescription stringByAppendingString:@\":\"];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t  }");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_83_5.handleBodyContent(out);
                }
                out = _jettag_c_when_83_5_saved_out;
                _jettag_c_when_83_5.doEnd();
                RuntimeTagElement _jettag_c_when_89_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_89_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_89_5.setRuntimeParent(_jettag_c_choose_82_4);
                _jettag_c_when_89_5.setTagInfo(_td_c_when_89_5);
                _jettag_c_when_89_5.doStart(context, out);
                JET2Writer _jettag_c_when_89_5_saved_out = out;
                while (_jettag_c_when_89_5.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t ");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_89_5.handleBodyContent(out);
                }
                out = _jettag_c_when_89_5_saved_out;
                _jettag_c_when_89_5.doEnd();
                RuntimeTagElement _jettag_c_when_92_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_92_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_92_5.setRuntimeParent(_jettag_c_choose_82_4);
                _jettag_c_when_92_5.setTagInfo(_td_c_when_92_5);
                _jettag_c_when_92_5.doStart(context, out);
                JET2Writer _jettag_c_when_92_5_saved_out = out;
                while (_jettag_c_when_92_5.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t ");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_92_5.handleBodyContent(out);
                }
                out = _jettag_c_when_92_5_saved_out;
                _jettag_c_when_92_5.doEnd();
                RuntimeTagElement _jettag_c_when_95_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_95_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_95_5.setRuntimeParent(_jettag_c_choose_82_4);
                _jettag_c_when_95_5.setTagInfo(_td_c_when_95_5);
                _jettag_c_when_95_5.doStart(context, out);
                JET2Writer _jettag_c_when_95_5_saved_out = out;
                while (_jettag_c_when_95_5.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t ");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_95_5.handleBodyContent(out);
                }
                out = _jettag_c_when_95_5_saved_out;
                _jettag_c_when_95_5.doEnd();
                RuntimeTagElement _jettag_c_when_98_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_98_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_98_5.setRuntimeParent(_jettag_c_choose_82_4);
                _jettag_c_when_98_5.setTagInfo(_td_c_when_98_5);
                _jettag_c_when_98_5.doStart(context, out);
                JET2Writer _jettag_c_when_98_5_saved_out = out;
                while (_jettag_c_when_98_5.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t ");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_98_5.handleBodyContent(out);
                }
                out = _jettag_c_when_98_5_saved_out;
                _jettag_c_when_98_5.doEnd();
                RuntimeTagElement _jettag_c_when_101_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_101_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_101_5.setRuntimeParent(_jettag_c_choose_82_4);
                _jettag_c_when_101_5.setTagInfo(_td_c_when_101_5);
                _jettag_c_when_101_5.doStart(context, out);
                JET2Writer _jettag_c_when_101_5_saved_out = out;
                while (_jettag_c_when_101_5.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t ");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_101_5.handleBodyContent(out);
                }
                out = _jettag_c_when_101_5_saved_out;
                _jettag_c_when_101_5.doEnd();
                RuntimeTagElement _jettag_c_otherwise_104_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_104_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_otherwise_104_4.setRuntimeParent(_jettag_c_choose_82_4);
                _jettag_c_otherwise_104_4.setTagInfo(_td_c_otherwise_104_4);
                _jettag_c_otherwise_104_4.doStart(context, out);
                JET2Writer _jettag_c_otherwise_104_4_saved_out = out;
                while (_jettag_c_otherwise_104_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_iterate_105_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_105_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_105_5.setRuntimeParent(_jettag_c_otherwise_104_4);
                    _jettag_c_iterate_105_5.setTagInfo(_td_c_iterate_105_5);
                    _jettag_c_iterate_105_5.doStart(context, out);
                    while (_jettag_c_iterate_105_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_if_106_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_106_7); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_106_7.setRuntimeParent(_jettag_c_iterate_105_5);
                        _jettag_c_if_106_7.setTagInfo(_td_c_if_106_7);
                        _jettag_c_if_106_7.doStart(context, out);
                        while (_jettag_c_if_106_7.okToProcessBody()) {
                            // add  enums support
                            _jettag_c_if_106_7.handleBodyContent(out);
                        }
                        _jettag_c_if_106_7.doEnd();
                        _jettag_c_iterate_105_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_105_5.doEnd();
                    _jettag_c_otherwise_104_4.handleBodyContent(out);
                }
                out = _jettag_c_otherwise_104_4_saved_out;
                _jettag_c_otherwise_104_4.doEnd();
                _jettag_c_choose_82_4.handleBodyContent(out);
            }
            out = _jettag_c_choose_82_4_saved_out;
            _jettag_c_choose_82_4.doEnd();
            _jettag_c_iterate_81_2.handleBodyContent(out);
        }
        _jettag_c_iterate_81_2.doEnd();
        out.write("\treturn localDescription;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (void)dealloc");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("{");  //$NON-NLS-1$        
        out.write(NL);         
        // processes the premitive Datatypes and enums
        RuntimeTagElement _jettag_c_iterate_119_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_119_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_119_1.setRuntimeParent(null);
        _jettag_c_iterate_119_1.setTagInfo(_td_c_iterate_119_1);
        _jettag_c_iterate_119_1.doStart(context, out);
        while (_jettag_c_iterate_119_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_choose_120_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_120_3); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_choose_120_3.setRuntimeParent(_jettag_c_iterate_119_1);
            _jettag_c_choose_120_3.setTagInfo(_td_c_choose_120_3);
            _jettag_c_choose_120_3.doStart(context, out);
            JET2Writer _jettag_c_choose_120_3_saved_out = out;
            while (_jettag_c_choose_120_3.okToProcessBody()) {
                out = out.newNestedContentWriter();
                RuntimeTagElement _jettag_c_when_121_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_121_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_121_4.setRuntimeParent(_jettag_c_choose_120_3);
                _jettag_c_when_121_4.setTagInfo(_td_c_when_121_4);
                _jettag_c_when_121_4.doStart(context, out);
                JET2Writer _jettag_c_when_121_4_saved_out = out;
                while (_jettag_c_when_121_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t  [");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 122, 5)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(" release];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t  ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 123, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("=nil;");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_121_4.handleBodyContent(out);
                }
                out = _jettag_c_when_121_4_saved_out;
                _jettag_c_when_121_4.doEnd();
                RuntimeTagElement _jettag_c_when_125_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_125_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_125_4.setRuntimeParent(_jettag_c_choose_120_3);
                _jettag_c_when_125_4.setTagInfo(_td_c_when_125_4);
                _jettag_c_when_125_4.doStart(context, out);
                JET2Writer _jettag_c_when_125_4_saved_out = out;
                while (_jettag_c_when_125_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t  [");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 126, 5)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(" release];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t  ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 127, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("=nil;");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_125_4.handleBodyContent(out);
                }
                out = _jettag_c_when_125_4_saved_out;
                _jettag_c_when_125_4.doEnd();
                RuntimeTagElement _jettag_c_when_129_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_129_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_129_4.setRuntimeParent(_jettag_c_choose_120_3);
                _jettag_c_when_129_4.setTagInfo(_td_c_when_129_4);
                _jettag_c_when_129_4.doStart(context, out);
                JET2Writer _jettag_c_when_129_4_saved_out = out;
                while (_jettag_c_when_129_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t  [");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 130, 5)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(" release];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t  ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 131, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("=nil;");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_129_4.handleBodyContent(out);
                }
                out = _jettag_c_when_129_4_saved_out;
                _jettag_c_when_129_4.doEnd();
                RuntimeTagElement _jettag_c_when_133_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_133_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_133_4.setRuntimeParent(_jettag_c_choose_120_3);
                _jettag_c_when_133_4.setTagInfo(_td_c_when_133_4);
                _jettag_c_when_133_4.doStart(context, out);
                JET2Writer _jettag_c_when_133_4_saved_out = out;
                while (_jettag_c_when_133_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    _jettag_c_when_133_4.handleBodyContent(out);
                }
                out = _jettag_c_when_133_4_saved_out;
                _jettag_c_when_133_4.doEnd();
                RuntimeTagElement _jettag_c_when_135_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_135_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_135_4.setRuntimeParent(_jettag_c_choose_120_3);
                _jettag_c_when_135_4.setTagInfo(_td_c_when_135_4);
                _jettag_c_when_135_4.doStart(context, out);
                JET2Writer _jettag_c_when_135_4_saved_out = out;
                while (_jettag_c_when_135_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t  [");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 136, 5)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(" release];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t  ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 137, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("=nil;");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_135_4.handleBodyContent(out);
                }
                out = _jettag_c_when_135_4_saved_out;
                _jettag_c_when_135_4.doEnd();
                RuntimeTagElement _jettag_c_when_139_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_139_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_139_4.setRuntimeParent(_jettag_c_choose_120_3);
                _jettag_c_when_139_4.setTagInfo(_td_c_when_139_4);
                _jettag_c_when_139_4.doStart(context, out);
                JET2Writer _jettag_c_when_139_4_saved_out = out;
                while (_jettag_c_when_139_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t  [");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 140, 5)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(" release];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t  ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 141, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("=nil;");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_139_4.handleBodyContent(out);
                }
                out = _jettag_c_when_139_4_saved_out;
                _jettag_c_when_139_4.doEnd();
                RuntimeTagElement _jettag_c_otherwise_143_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_143_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_otherwise_143_3.setRuntimeParent(_jettag_c_choose_120_3);
                _jettag_c_otherwise_143_3.setTagInfo(_td_c_otherwise_143_3);
                _jettag_c_otherwise_143_3.doStart(context, out);
                JET2Writer _jettag_c_otherwise_143_3_saved_out = out;
                while (_jettag_c_otherwise_143_3.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_iterate_144_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_144_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_144_4.setRuntimeParent(_jettag_c_otherwise_143_3);
                    _jettag_c_iterate_144_4.setTagInfo(_td_c_iterate_144_4);
                    _jettag_c_iterate_144_4.doStart(context, out);
                    while (_jettag_c_iterate_144_4.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_if_145_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_145_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_145_6.setRuntimeParent(_jettag_c_iterate_144_4);
                        _jettag_c_if_145_6.setTagInfo(_td_c_if_145_6);
                        _jettag_c_if_145_6.doStart(context, out);
                        while (_jettag_c_if_145_6.okToProcessBody()) {
                            // add  enums support
                            _jettag_c_if_145_6.handleBodyContent(out);
                        }
                        _jettag_c_if_145_6.doEnd();
                        _jettag_c_iterate_144_4.handleBodyContent(out);
                    }
                    _jettag_c_iterate_144_4.doEnd();
                    _jettag_c_otherwise_143_3.handleBodyContent(out);
                }
                out = _jettag_c_otherwise_143_3_saved_out;
                _jettag_c_otherwise_143_3.doEnd();
                _jettag_c_choose_120_3.handleBodyContent(out);
            }
            out = _jettag_c_choose_120_3_saved_out;
            _jettag_c_choose_120_3.doEnd();
            _jettag_c_iterate_119_1.handleBodyContent(out);
        }
        _jettag_c_iterate_119_1.doEnd();
        out.write(NL);         
        out.write("   [super dealloc];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("@end");  //$NON-NLS-1$        
        out.write(NL);         
    }
}
