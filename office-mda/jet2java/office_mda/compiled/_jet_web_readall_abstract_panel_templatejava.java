package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_web_readall_abstract_panel_templatejava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_web_readall_abstract_panel_templatejava() {
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
    private static final TagInfo _td_f_message_19_1 = new TagInfo("f:message", //$NON-NLS-1$
            19, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_21_1 = new TagInfo("f:message", //$NON-NLS-1$
            21, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_23_1 = new TagInfo("f:message", //$NON-NLS-1$
            23, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_27_1 = new TagInfo("f:message", //$NON-NLS-1$
            27, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_31_1 = new TagInfo("f:message", //$NON-NLS-1$
            31, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_37_1 = new TagInfo("f:message", //$NON-NLS-1$
            37, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_45_1 = new TagInfo("c:if", //$NON-NLS-1$
            45, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_46_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            46, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_51_1 = new TagInfo("c:if", //$NON-NLS-1$
            51, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_52_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            52, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_57_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            57, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_61_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            61, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_62_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            62, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_63_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            63, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_64_7 = new TagInfo("c:setVariable", //$NON-NLS-1$
            64, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_66_9 = new TagInfo("c:if", //$NON-NLS-1$
            66, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_68_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            68, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_69_15 = new TagInfo("c:setVariable", //$NON-NLS-1$
            69, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_71_17 = new TagInfo("c:if", //$NON-NLS-1$
            71, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_73_18 = new TagInfo("c:iterate", //$NON-NLS-1$
            73, 18,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_74_19 = new TagInfo("c:if", //$NON-NLS-1$
            74, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_77_19 = new TagInfo("c:if", //$NON-NLS-1$
            77, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_78_21 = new TagInfo("c:if", //$NON-NLS-1$
            78, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_80_21 = new TagInfo("c:if", //$NON-NLS-1$
            80, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'false'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_84_21 = new TagInfo("c:if", //$NON-NLS-1$
            84, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_85_21 = new TagInfo("c:if", //$NON-NLS-1$
            85, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_100_1 = new TagInfo("f:message", //$NON-NLS-1$
            100, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_109_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            109, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_110_5 = new TagInfo("c:choose", //$NON-NLS-1$
            110, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_111_6 = new TagInfo("c:when", //$NON-NLS-1$
            111, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_114_6 = new TagInfo("c:otherwise", //$NON-NLS-1$
            114, 6,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_120_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            120, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_121_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            121, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_122_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            122, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_123_7 = new TagInfo("c:setVariable", //$NON-NLS-1$
            123, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_125_9 = new TagInfo("c:if", //$NON-NLS-1$
            125, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_127_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            127, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_128_15 = new TagInfo("c:setVariable", //$NON-NLS-1$
            128, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_130_17 = new TagInfo("c:if", //$NON-NLS-1$
            130, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_132_18 = new TagInfo("c:iterate", //$NON-NLS-1$
            132, 18,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_133_19 = new TagInfo("c:if", //$NON-NLS-1$
            133, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_136_19 = new TagInfo("c:if", //$NON-NLS-1$
            136, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_137_21 = new TagInfo("c:if", //$NON-NLS-1$
            137, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_139_21 = new TagInfo("c:if", //$NON-NLS-1$
            139, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'false'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_143_21 = new TagInfo("c:if", //$NON-NLS-1$
            143, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_144_21 = new TagInfo("c:if", //$NON-NLS-1$
            144, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_163_1 = new TagInfo("f:message", //$NON-NLS-1$
            163, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_192_1 = new TagInfo("f:message", //$NON-NLS-1$
            192, 1,
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
                out.write(NL);         
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.beans.TableObj;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.callback.ALAsyncCallback;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.ReadAllComposite;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.utils.Utils;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import java.util.List;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import com.google.gwt.user.client.ui.DockPanel;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_19_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_19_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_19_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_19_1.setTagInfo(_td_f_message_19_1);
                _jettag_f_message_19_1.doStart(context, out);
                JET2Writer _jettag_f_message_19_1_saved_out = out;
                while (_jettag_f_message_19_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_19_1.handleBodyContent(out);
                }
                out = _jettag_f_message_19_1_saved_out;
                _jettag_f_message_19_1.doEnd();
                out.write(NL);         
                out.write("public class ReadAll");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 20, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("sPanel extends ReadAllComposite<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 20, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> {");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_21_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_21_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_21_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_21_1.setTagInfo(_td_f_message_21_1);
                _jettag_f_message_21_1.doStart(context, out);
                JET2Writer _jettag_f_message_21_1_saved_out = out;
                while (_jettag_f_message_21_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_21_1.handleBodyContent(out);
                }
                out = _jettag_f_message_21_1_saved_out;
                _jettag_f_message_21_1.doEnd();
                out.write(NL);         
                out.write("\tprivate  ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 22, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("TableType tableType;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_23_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_23_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_23_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_23_1.setTagInfo(_td_f_message_23_1);
                _jettag_f_message_23_1.doStart(context, out);
                JET2Writer _jettag_f_message_23_1_saved_out = out;
                while (_jettag_f_message_23_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_23_1.handleBodyContent(out);
                }
                out = _jettag_f_message_23_1_saved_out;
                _jettag_f_message_23_1.doEnd();
                out.write(NL);         
                out.write("\tpublic enum ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 24, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("TableType {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tREADALL, READALL_SEARCH");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_27_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_27_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_27_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_27_1.setTagInfo(_td_f_message_27_1);
                _jettag_f_message_27_1.doStart(context, out);
                JET2Writer _jettag_f_message_27_1_saved_out = out;
                while (_jettag_f_message_27_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_27_1.handleBodyContent(out);
                }
                out = _jettag_f_message_27_1_saved_out;
                _jettag_f_message_27_1.doEnd();
                out.write(NL);         
                out.write("\tpublic ReadAll");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 28, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("sPanel(List<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 28, 43)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> entities) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinitTable(new ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 29, 17)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("(), entities, ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 29, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.constants);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_31_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_31_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_31_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_31_1.setTagInfo(_td_f_message_31_1);
                _jettag_f_message_31_1.doStart(context, out);
                JET2Writer _jettag_f_message_31_1_saved_out = out;
                while (_jettag_f_message_31_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_31_1.handleBodyContent(out);
                }
                out = _jettag_f_message_31_1_saved_out;
                _jettag_f_message_31_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic ReadAll");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 32, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("sPanel(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 32, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("TableType tableType) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tthis.tableType = tableType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinitTable(new ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 34, 17)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("(),");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 35, 5)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.constants);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_37_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_37_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_37_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_37_1.setTagInfo(_td_f_message_37_1);
                _jettag_f_message_37_1.doStart(context, out);
                JET2Writer _jettag_f_message_37_1_saved_out = out;
                while (_jettag_f_message_37_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_37_1.handleBodyContent(out);
                }
                out = _jettag_f_message_37_1_saved_out;
                _jettag_f_message_37_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void createTableHeader() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\ttable.setText(0, 0, getKeyValue(\"Table_Action\"));\t");  //$NON-NLS-1$        
                out.write(NL);         
        
        		int x = 1;
        		
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_45_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_45_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_45_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_45_1.setTagInfo(_td_c_if_45_1);
                _jettag_c_if_45_1.doStart(context, out);
                while (_jettag_c_if_45_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_46_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_46_1); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_46_1.setRuntimeParent(_jettag_c_if_45_1);
                    _jettag_c_iterate_46_1.setTagInfo(_td_c_iterate_46_1);
                    _jettag_c_iterate_46_1.doStart(context, out);
                    while (_jettag_c_iterate_46_1.okToProcessBody()) {
                        out.write("\t\t\ttable.setText(0, ");  //$NON-NLS-1$        
                        out.write( x++ );
                        out.write(", getClassValue(\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 47, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"));");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_iterate_46_1.handleBodyContent(out);
                    }
                    _jettag_c_iterate_46_1.doEnd();
                    _jettag_c_if_45_1.handleBodyContent(out);
                }
                _jettag_c_if_45_1.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_51_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_51_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_51_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_51_1.setTagInfo(_td_c_if_51_1);
                _jettag_c_if_51_1.doStart(context, out);
                while (_jettag_c_if_51_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_52_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_52_1); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_52_1.setRuntimeParent(_jettag_c_if_51_1);
                    _jettag_c_iterate_52_1.setTagInfo(_td_c_iterate_52_1);
                    _jettag_c_iterate_52_1.doStart(context, out);
                    while (_jettag_c_iterate_52_1.okToProcessBody()) {
                        out.write("\t\t\ttable.setText(0, ");  //$NON-NLS-1$        
                        out.write( x++ );
                        out.write(", getClassValue(\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 53, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"));");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_iterate_52_1.handleBodyContent(out);
                    }
                    _jettag_c_iterate_52_1.doEnd();
                    _jettag_c_if_51_1.handleBodyContent(out);
                }
                _jettag_c_if_51_1.doEnd();
                // process base class attributes
                RuntimeTagElement _jettag_c_iterate_57_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_57_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_57_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_57_1.setTagInfo(_td_c_iterate_57_1);
                _jettag_c_iterate_57_1.doStart(context, out);
                while (_jettag_c_iterate_57_1.okToProcessBody()) {
                    out.write("\t\t\ttable.setText(0, ");  //$NON-NLS-1$        
                    out.write( x++ );
                    out.write(", getClassValue(\"");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 58, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"));");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_iterate_57_1.handleBodyContent(out);
                }
                _jettag_c_iterate_57_1.doEnd();
                // process dropdowns one to one and many to one unidirectional
                RuntimeTagElement _jettag_c_iterate_61_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_61_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_61_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_61_4.setTagInfo(_td_c_iterate_61_4);
                _jettag_c_iterate_61_4.doStart(context, out);
                while (_jettag_c_iterate_61_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_62_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_62_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_62_5.setRuntimeParent(_jettag_c_iterate_61_4);
                    _jettag_c_iterate_62_5.setTagInfo(_td_c_iterate_62_5);
                    _jettag_c_iterate_62_5.doStart(context, out);
                    while (_jettag_c_iterate_62_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_63_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_63_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_63_6.setRuntimeParent(_jettag_c_iterate_62_5);
                        _jettag_c_iterate_63_6.setTagInfo(_td_c_iterate_63_6);
                        _jettag_c_iterate_63_6.doStart(context, out);
                        while (_jettag_c_iterate_63_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_64_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_64_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_64_7.setRuntimeParent(_jettag_c_iterate_63_6);
                            _jettag_c_setVariable_64_7.setTagInfo(_td_c_setVariable_64_7);
                            _jettag_c_setVariable_64_7.doStart(context, out);
                            _jettag_c_setVariable_64_7.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_66_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_66_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_66_9.setRuntimeParent(_jettag_c_iterate_63_6);
                            _jettag_c_if_66_9.setTagInfo(_td_c_if_66_9);
                            _jettag_c_if_66_9.doStart(context, out);
                            while (_jettag_c_if_66_9.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_68_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_68_15); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_68_15.setRuntimeParent(_jettag_c_if_66_9);
                                _jettag_c_iterate_68_15.setTagInfo(_td_c_iterate_68_15);
                                _jettag_c_iterate_68_15.doStart(context, out);
                                while (_jettag_c_iterate_68_15.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_69_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_69_15); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_69_15.setRuntimeParent(_jettag_c_iterate_68_15);
                                    _jettag_c_setVariable_69_15.setTagInfo(_td_c_setVariable_69_15);
                                    _jettag_c_setVariable_69_15.doStart(context, out);
                                    _jettag_c_setVariable_69_15.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_71_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_71_17); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_71_17.setRuntimeParent(_jettag_c_iterate_68_15);
                                    _jettag_c_if_71_17.setTagInfo(_td_c_if_71_17);
                                    _jettag_c_if_71_17.doStart(context, out);
                                    while (_jettag_c_if_71_17.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_73_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_73_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_73_18.setRuntimeParent(_jettag_c_if_71_17);
                                        _jettag_c_iterate_73_18.setTagInfo(_td_c_iterate_73_18);
                                        _jettag_c_iterate_73_18.doStart(context, out);
                                        while (_jettag_c_iterate_73_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_74_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_74_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_74_19.setRuntimeParent(_jettag_c_iterate_73_18);
                                            _jettag_c_if_74_19.setTagInfo(_td_c_if_74_19);
                                            _jettag_c_if_74_19.doStart(context, out);
                                            while (_jettag_c_if_74_19.okToProcessBody()) {
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                RuntimeTagElement _jettag_c_if_77_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_77_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_77_19.setRuntimeParent(_jettag_c_if_74_19);
                                                _jettag_c_if_77_19.setTagInfo(_td_c_if_77_19);
                                                _jettag_c_if_77_19.doStart(context, out);
                                                while (_jettag_c_if_77_19.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_78_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_78_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_78_21.setRuntimeParent(_jettag_c_if_77_19);
                                                    _jettag_c_if_78_21.setTagInfo(_td_c_if_78_21);
                                                    _jettag_c_if_78_21.doStart(context, out);
                                                    while (_jettag_c_if_78_21.okToProcessBody()) {
                                                        //check for Many to one unidirectional
                                                        RuntimeTagElement _jettag_c_if_80_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_80_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_80_21.setRuntimeParent(_jettag_c_if_78_21);
                                                        _jettag_c_if_80_21.setTagInfo(_td_c_if_80_21);
                                                        _jettag_c_if_80_21.doStart(context, out);
                                                        while (_jettag_c_if_80_21.okToProcessBody()) {
                                                            out.write("\t\t\t  \t\t\t\t\t    \t\t\t\t\t\t\t\ttable.setText(0, ");  //$NON-NLS-1$        
                                                            out.write( x++ );
                                                            out.write(", \"");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 81, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("\");");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_80_21.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_80_21.doEnd();
                                                        //check for one to one 
                                                        RuntimeTagElement _jettag_c_if_84_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_84_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_84_21.setRuntimeParent(_jettag_c_if_78_21);
                                                        _jettag_c_if_84_21.setTagInfo(_td_c_if_84_21);
                                                        _jettag_c_if_84_21.doStart(context, out);
                                                        while (_jettag_c_if_84_21.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_85_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_85_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_85_21.setRuntimeParent(_jettag_c_if_84_21);
                                                            _jettag_c_if_85_21.setTagInfo(_td_c_if_85_21);
                                                            _jettag_c_if_85_21.doStart(context, out);
                                                            while (_jettag_c_if_85_21.okToProcessBody()) {
                                                                out.write("\t\t\t  \t\t\t\t\t    \t\t\t\t\t\t\ttable.setText(0, ");  //$NON-NLS-1$        
                                                                out.write( x++ );
                                                                out.write(", \"");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 86, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("\");");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_85_21.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_85_21.doEnd();
                                                            _jettag_c_if_84_21.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_84_21.doEnd();
                                                        _jettag_c_if_78_21.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_78_21.doEnd();
                                                    _jettag_c_if_77_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_77_19.doEnd();
                                                _jettag_c_if_74_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_74_19.doEnd();
                                            _jettag_c_iterate_73_18.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_73_18.doEnd();
                                        _jettag_c_if_71_17.handleBodyContent(out);
                                    }
                                    _jettag_c_if_71_17.doEnd();
                                    _jettag_c_iterate_68_15.handleBodyContent(out);
                                }
                                _jettag_c_iterate_68_15.doEnd();
                                _jettag_c_if_66_9.handleBodyContent(out);
                            }
                            _jettag_c_if_66_9.doEnd();
                            _jettag_c_iterate_63_6.handleBodyContent(out);
                        }
                        _jettag_c_iterate_63_6.doEnd();
                        _jettag_c_iterate_62_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_62_5.doEnd();
                    _jettag_c_iterate_61_4.handleBodyContent(out);
                }
                _jettag_c_iterate_61_4.doEnd();
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_100_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_100_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_100_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_100_1.setTagInfo(_td_f_message_100_1);
                _jettag_f_message_100_1.doStart(context, out);
                JET2Writer _jettag_f_message_100_1_saved_out = out;
                while (_jettag_f_message_100_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_100_1.handleBodyContent(out);
                }
                out = _jettag_f_message_100_1_saved_out;
                _jettag_f_message_100_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void fillData(List<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 102, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> entities) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tint i = 1;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tfor (");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 104, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity : entities) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tcreateViewIcon(i, entity.getId());");  //$NON-NLS-1$        
                out.write(NL);         
        
        			int y = 1;
        			
                RuntimeTagElement _jettag_c_iterate_109_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_109_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_109_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_109_1.setTagInfo(_td_c_iterate_109_1);
                _jettag_c_iterate_109_1.doStart(context, out);
                while (_jettag_c_iterate_109_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_110_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_110_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_110_5.setRuntimeParent(_jettag_c_iterate_109_1);
                    _jettag_c_choose_110_5.setTagInfo(_td_c_choose_110_5);
                    _jettag_c_choose_110_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_110_5_saved_out = out;
                    while (_jettag_c_choose_110_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_when_111_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_111_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_111_6.setRuntimeParent(_jettag_c_choose_110_5);
                        _jettag_c_when_111_6.setTagInfo(_td_c_when_111_6);
                        _jettag_c_when_111_6.doStart(context, out);
                        JET2Writer _jettag_c_when_111_6_saved_out = out;
                        while (_jettag_c_when_111_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t  \t\ttable.setText(i, ");  //$NON-NLS-1$        
                            out.write( y++ );
                            out.write(", Utils.getShortDate(entity.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 112, 66)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("())); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_111_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_111_6_saved_out;
                        _jettag_c_when_111_6.doEnd();
                        RuntimeTagElement _jettag_c_otherwise_114_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_114_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_114_6.setRuntimeParent(_jettag_c_choose_110_5);
                        _jettag_c_otherwise_114_6.setTagInfo(_td_c_otherwise_114_6);
                        _jettag_c_otherwise_114_6.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_114_6_saved_out = out;
                        while (_jettag_c_otherwise_114_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t\ttable.setText(i, ");  //$NON-NLS-1$        
                            out.write( y++ );
                            out.write(", Utils.entityToString(entity.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 115, 66)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()));");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_otherwise_114_6.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_114_6_saved_out;
                        _jettag_c_otherwise_114_6.doEnd();
                        _jettag_c_choose_110_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_110_5_saved_out;
                    _jettag_c_choose_110_5.doEnd();
                    _jettag_c_iterate_109_1.handleBodyContent(out);
                }
                _jettag_c_iterate_109_1.doEnd();
                // process dropdowns one to one and many to one unidirectional
                RuntimeTagElement _jettag_c_iterate_120_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_120_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_120_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_120_4.setTagInfo(_td_c_iterate_120_4);
                _jettag_c_iterate_120_4.doStart(context, out);
                while (_jettag_c_iterate_120_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_121_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_121_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_121_5.setRuntimeParent(_jettag_c_iterate_120_4);
                    _jettag_c_iterate_121_5.setTagInfo(_td_c_iterate_121_5);
                    _jettag_c_iterate_121_5.doStart(context, out);
                    while (_jettag_c_iterate_121_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_122_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_122_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_122_6.setRuntimeParent(_jettag_c_iterate_121_5);
                        _jettag_c_iterate_122_6.setTagInfo(_td_c_iterate_122_6);
                        _jettag_c_iterate_122_6.doStart(context, out);
                        while (_jettag_c_iterate_122_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_123_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_123_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_123_7.setRuntimeParent(_jettag_c_iterate_122_6);
                            _jettag_c_setVariable_123_7.setTagInfo(_td_c_setVariable_123_7);
                            _jettag_c_setVariable_123_7.doStart(context, out);
                            _jettag_c_setVariable_123_7.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_125_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_125_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_125_9.setRuntimeParent(_jettag_c_iterate_122_6);
                            _jettag_c_if_125_9.setTagInfo(_td_c_if_125_9);
                            _jettag_c_if_125_9.doStart(context, out);
                            while (_jettag_c_if_125_9.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_127_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_127_15); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_127_15.setRuntimeParent(_jettag_c_if_125_9);
                                _jettag_c_iterate_127_15.setTagInfo(_td_c_iterate_127_15);
                                _jettag_c_iterate_127_15.doStart(context, out);
                                while (_jettag_c_iterate_127_15.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_128_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_128_15); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_128_15.setRuntimeParent(_jettag_c_iterate_127_15);
                                    _jettag_c_setVariable_128_15.setTagInfo(_td_c_setVariable_128_15);
                                    _jettag_c_setVariable_128_15.doStart(context, out);
                                    _jettag_c_setVariable_128_15.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_130_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_130_17); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_130_17.setRuntimeParent(_jettag_c_iterate_127_15);
                                    _jettag_c_if_130_17.setTagInfo(_td_c_if_130_17);
                                    _jettag_c_if_130_17.doStart(context, out);
                                    while (_jettag_c_if_130_17.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_132_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_132_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_132_18.setRuntimeParent(_jettag_c_if_130_17);
                                        _jettag_c_iterate_132_18.setTagInfo(_td_c_iterate_132_18);
                                        _jettag_c_iterate_132_18.doStart(context, out);
                                        while (_jettag_c_iterate_132_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_133_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_133_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_133_19.setRuntimeParent(_jettag_c_iterate_132_18);
                                            _jettag_c_if_133_19.setTagInfo(_td_c_if_133_19);
                                            _jettag_c_if_133_19.doStart(context, out);
                                            while (_jettag_c_if_133_19.okToProcessBody()) {
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                RuntimeTagElement _jettag_c_if_136_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_136_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_136_19.setRuntimeParent(_jettag_c_if_133_19);
                                                _jettag_c_if_136_19.setTagInfo(_td_c_if_136_19);
                                                _jettag_c_if_136_19.doStart(context, out);
                                                while (_jettag_c_if_136_19.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_137_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_137_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_137_21.setRuntimeParent(_jettag_c_if_136_19);
                                                    _jettag_c_if_137_21.setTagInfo(_td_c_if_137_21);
                                                    _jettag_c_if_137_21.doStart(context, out);
                                                    while (_jettag_c_if_137_21.okToProcessBody()) {
                                                        //check for Many to one unidirectional
                                                        RuntimeTagElement _jettag_c_if_139_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_139_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_139_21.setRuntimeParent(_jettag_c_if_137_21);
                                                        _jettag_c_if_139_21.setTagInfo(_td_c_if_139_21);
                                                        _jettag_c_if_139_21.doStart(context, out);
                                                        while (_jettag_c_if_139_21.okToProcessBody()) {
                                                            out.write("\t\t\t  \t\t\t\t\t    \t\t\t\t\t\t\t\ttable.setText(i, ");  //$NON-NLS-1$        
                                                            out.write( y++ );
                                                            out.write(", Utils.entityToString(entity.get");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 140, 83)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("()));");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_139_21.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_139_21.doEnd();
                                                        //check for one to one 
                                                        RuntimeTagElement _jettag_c_if_143_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_143_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_143_21.setRuntimeParent(_jettag_c_if_137_21);
                                                        _jettag_c_if_143_21.setTagInfo(_td_c_if_143_21);
                                                        _jettag_c_if_143_21.doStart(context, out);
                                                        while (_jettag_c_if_143_21.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_144_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_144_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_144_21.setRuntimeParent(_jettag_c_if_143_21);
                                                            _jettag_c_if_144_21.setTagInfo(_td_c_if_144_21);
                                                            _jettag_c_if_144_21.doStart(context, out);
                                                            while (_jettag_c_if_144_21.okToProcessBody()) {
                                                                out.write("\t\t\t  \t\t\t\t\t    \t\t\t\t\t\t\ttable.setText(i, ");  //$NON-NLS-1$        
                                                                out.write( y++ );
                                                                out.write(", Utils.entityToString(entity.get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 145, 82)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("()));");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_144_21.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_144_21.doEnd();
                                                            _jettag_c_if_143_21.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_143_21.doEnd();
                                                        _jettag_c_if_137_21.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_137_21.doEnd();
                                                    _jettag_c_if_136_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_136_19.doEnd();
                                                _jettag_c_if_133_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_133_19.doEnd();
                                            _jettag_c_iterate_132_18.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_132_18.doEnd();
                                        _jettag_c_if_130_17.handleBodyContent(out);
                                    }
                                    _jettag_c_if_130_17.doEnd();
                                    _jettag_c_iterate_127_15.handleBodyContent(out);
                                }
                                _jettag_c_iterate_127_15.doEnd();
                                _jettag_c_if_125_9.handleBodyContent(out);
                            }
                            _jettag_c_if_125_9.doEnd();
                            _jettag_c_iterate_122_6.handleBodyContent(out);
                        }
                        _jettag_c_iterate_122_6.doEnd();
                        _jettag_c_iterate_121_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_121_5.doEnd();
                    _jettag_c_iterate_120_4.handleBodyContent(out);
                }
                _jettag_c_iterate_120_4.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\ti++;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_163_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_163_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_163_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_163_1.setTagInfo(_td_f_message_163_1);
                _jettag_f_message_163_1.doStart(context, out);
                JET2Writer _jettag_f_message_163_1_saved_out = out;
                while (_jettag_f_message_163_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_163_1.handleBodyContent(out);
                }
                out = _jettag_f_message_163_1_saved_out;
                _jettag_f_message_163_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void preFetchTable(int start) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tif (");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 166, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("TableType.READALL.equals(tableType)) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$packageName}", 167, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 167, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 167, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Service.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 167, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceAsync.instance().getTableObj(start, new ALAsyncCallback<TableObj<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 167, 158)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(">>() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t\t\t\t\t\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\tpublic void onResponse(TableObj<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 170, 39)); //$NON-NLS-1$ //$NON-NLS-2$
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
                out.write(context.embeddedExpressionAsString("${$class/@name}", 177, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("TableType.READALL_SEARCH.equals(tableType)) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$packageName}", 178, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 178, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 178, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Service.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 178, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceAsync.instance().getEntities(");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 179, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("SearchPanelGeneric.instance().getEntity(),");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\tnew ALAsyncCallback<List<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 180, 31)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(">>() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t\t\t\t\t\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\tpublic void onResponse(List<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 183, 35)); //$NON-NLS-1$ //$NON-NLS-2$
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
                RuntimeTagElement _jettag_f_message_192_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_192_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_192_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_192_1.setTagInfo(_td_f_message_192_1);
                _jettag_f_message_192_1.doStart(context, out);
                JET2Writer _jettag_f_message_192_1_saved_out = out;
                while (_jettag_f_message_192_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_192_1.handleBodyContent(out);
                }
                out = _jettag_f_message_192_1_saved_out;
                _jettag_f_message_192_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void viewClicked(int row, int col) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 195, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().getEntityPanel().clear();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 196, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().getEntityPanel().add(");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tnew Read");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 197, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely(getEntityId(row)));");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
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
        out.write(NL);         
    }
}
