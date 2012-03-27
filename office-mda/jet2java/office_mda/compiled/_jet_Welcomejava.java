package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_Welcomejava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_Welcomejava() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_java_format_1_1 = new TagInfo("java:format", //$NON-NLS-1$
            1, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_15_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            15, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_17_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            17, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_19_8 = new TagInfo("c:setVariable", //$NON-NLS-1$
            19, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "isComposite", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_20_8 = new TagInfo("c:setVariable", //$NON-NLS-1$
            20, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_21_8 = new TagInfo("c:setVariable", //$NON-NLS-1$
            21, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "isParent", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_22_8 = new TagInfo("c:if", //$NON-NLS-1$
            22, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isAbstract = 'false'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_24_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            24, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_25_7 = new TagInfo("c:iterate", //$NON-NLS-1$
            25, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_26_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            26, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_27_9 = new TagInfo("c:setVariable", //$NON-NLS-1$
            27, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_29_11 = new TagInfo("c:if", //$NON-NLS-1$
            29, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_33_17 = new TagInfo("c:iterate", //$NON-NLS-1$
            33, 17,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_34_17 = new TagInfo("c:setVariable", //$NON-NLS-1$
            34, 17,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_35_17 = new TagInfo("c:if", //$NON-NLS-1$
            35, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_37_17 = new TagInfo("c:if", //$NON-NLS-1$
            37, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_39_17 = new TagInfo("c:setVariable", //$NON-NLS-1$
            39, 17,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@name", //$NON-NLS-1$
                "isComposite", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_49_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            49, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Generalization", //$NON-NLS-1$
                "generalization", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_50_6 = new TagInfo("c:if", //$NON-NLS-1$
            50, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$generalization/Generalization.parent/Class/@xmi.idref = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_52_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            52, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@name", //$NON-NLS-1$
                "isParent", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_56_8 = new TagInfo("c:if", //$NON-NLS-1$
            56, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$isComposite = $class/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_57_8 = new TagInfo("c:if", //$NON-NLS-1$
            57, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$isParent = $class/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_91_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            91, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_93_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            93, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_95_8 = new TagInfo("c:setVariable", //$NON-NLS-1$
            95, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "isComposite", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_96_8 = new TagInfo("c:setVariable", //$NON-NLS-1$
            96, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_97_8 = new TagInfo("c:setVariable", //$NON-NLS-1$
            97, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "isParent", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_98_8 = new TagInfo("c:if", //$NON-NLS-1$
            98, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isAbstract = 'false'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_100_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            100, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_101_7 = new TagInfo("c:iterate", //$NON-NLS-1$
            101, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_102_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            102, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_103_9 = new TagInfo("c:setVariable", //$NON-NLS-1$
            103, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_105_11 = new TagInfo("c:if", //$NON-NLS-1$
            105, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_109_17 = new TagInfo("c:iterate", //$NON-NLS-1$
            109, 17,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_110_17 = new TagInfo("c:setVariable", //$NON-NLS-1$
            110, 17,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_111_17 = new TagInfo("c:if", //$NON-NLS-1$
            111, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_113_17 = new TagInfo("c:if", //$NON-NLS-1$
            113, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_115_17 = new TagInfo("c:setVariable", //$NON-NLS-1$
            115, 17,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@name", //$NON-NLS-1$
                "isComposite", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_125_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            125, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Generalization", //$NON-NLS-1$
                "generalization", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_126_6 = new TagInfo("c:if", //$NON-NLS-1$
            126, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$generalization/Generalization.parent/Class/@xmi.idref = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_128_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            128, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@name", //$NON-NLS-1$
                "isParent", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_132_8 = new TagInfo("c:if", //$NON-NLS-1$
            132, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$isComposite = $class/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_133_8 = new TagInfo("c:if", //$NON-NLS-1$
            133, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$isParent = $class/@xmi.id", //$NON-NLS-1$
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
            out.write(".android;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("import java.util.ArrayList;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import java.util.HashMap;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import java.util.Map;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("import android.app.ListActivity;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.content.Intent;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.os.Bundle;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.View;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.ListView;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.SimpleAdapter;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 14, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".R;");  //$NON-NLS-1$        
            out.write(NL);         
            RuntimeTagElement _jettag_c_iterate_15_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_15_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_15_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_iterate_15_2.setTagInfo(_td_c_iterate_15_2);
            _jettag_c_iterate_15_2.doStart(context, out);
            while (_jettag_c_iterate_15_2.okToProcessBody()) {
                // iterate through class and add only non composite children and non parent
                RuntimeTagElement _jettag_c_iterate_17_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_17_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_17_5.setRuntimeParent(_jettag_c_iterate_15_2);
                _jettag_c_iterate_17_5.setTagInfo(_td_c_iterate_17_5);
                _jettag_c_iterate_17_5.doStart(context, out);
                while (_jettag_c_iterate_17_5.okToProcessBody()) {
                    // Flag varibles
                    RuntimeTagElement _jettag_c_setVariable_19_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_19_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_19_8.setRuntimeParent(_jettag_c_iterate_17_5);
                    _jettag_c_setVariable_19_8.setTagInfo(_td_c_setVariable_19_8);
                    _jettag_c_setVariable_19_8.doStart(context, out);
                    _jettag_c_setVariable_19_8.doEnd();
                    RuntimeTagElement _jettag_c_setVariable_20_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_20_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_20_8.setRuntimeParent(_jettag_c_iterate_17_5);
                    _jettag_c_setVariable_20_8.setTagInfo(_td_c_setVariable_20_8);
                    _jettag_c_setVariable_20_8.doStart(context, out);
                    _jettag_c_setVariable_20_8.doEnd();
                    RuntimeTagElement _jettag_c_setVariable_21_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_21_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_21_8.setRuntimeParent(_jettag_c_iterate_17_5);
                    _jettag_c_setVariable_21_8.setTagInfo(_td_c_setVariable_21_8);
                    _jettag_c_setVariable_21_8.doStart(context, out);
                    _jettag_c_setVariable_21_8.doEnd();
                    RuntimeTagElement _jettag_c_if_22_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_22_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_22_8.setRuntimeParent(_jettag_c_iterate_17_5);
                    _jettag_c_if_22_8.setTagInfo(_td_c_if_22_8);
                    _jettag_c_if_22_8.doStart(context, out);
                    while (_jettag_c_if_22_8.okToProcessBody()) {
                        // process all associations to eliminate composite children
                        RuntimeTagElement _jettag_c_iterate_24_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_24_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_24_6.setRuntimeParent(_jettag_c_if_22_8);
                        _jettag_c_iterate_24_6.setTagInfo(_td_c_iterate_24_6);
                        _jettag_c_iterate_24_6.doStart(context, out);
                        while (_jettag_c_iterate_24_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_25_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_25_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_25_7.setRuntimeParent(_jettag_c_iterate_24_6);
                            _jettag_c_iterate_25_7.setTagInfo(_td_c_iterate_25_7);
                            _jettag_c_iterate_25_7.doStart(context, out);
                            while (_jettag_c_iterate_25_7.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_iterate_26_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_26_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_26_8.setRuntimeParent(_jettag_c_iterate_25_7);
                                _jettag_c_iterate_26_8.setTagInfo(_td_c_iterate_26_8);
                                _jettag_c_iterate_26_8.doStart(context, out);
                                while (_jettag_c_iterate_26_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_27_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_27_9); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_27_9.setRuntimeParent(_jettag_c_iterate_26_8);
                                    _jettag_c_setVariable_27_9.setTagInfo(_td_c_setVariable_27_9);
                                    _jettag_c_setVariable_27_9.doStart(context, out);
                                    _jettag_c_setVariable_27_9.doEnd();
                                    // check is the association is corresponding to the class  
                                    RuntimeTagElement _jettag_c_if_29_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_29_11); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_29_11.setRuntimeParent(_jettag_c_iterate_26_8);
                                    _jettag_c_if_29_11.setTagInfo(_td_c_if_29_11);
                                    _jettag_c_if_29_11.doStart(context, out);
                                    while (_jettag_c_if_29_11.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        out.write("\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        // iterate over the iterations ends  
                                        RuntimeTagElement _jettag_c_iterate_33_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_33_17); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_33_17.setRuntimeParent(_jettag_c_if_29_11);
                                        _jettag_c_iterate_33_17.setTagInfo(_td_c_iterate_33_17);
                                        _jettag_c_iterate_33_17.doStart(context, out);
                                        while (_jettag_c_iterate_33_17.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_setVariable_34_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_34_17); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_34_17.setRuntimeParent(_jettag_c_iterate_33_17);
                                            _jettag_c_setVariable_34_17.setTagInfo(_td_c_setVariable_34_17);
                                            _jettag_c_setVariable_34_17.doStart(context, out);
                                            _jettag_c_setVariable_34_17.doEnd();
                                            RuntimeTagElement _jettag_c_if_35_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_35_17); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_35_17.setRuntimeParent(_jettag_c_iterate_33_17);
                                            _jettag_c_if_35_17.setTagInfo(_td_c_if_35_17);
                                            _jettag_c_if_35_17.doStart(context, out);
                                            while (_jettag_c_if_35_17.okToProcessBody()) {
                                                // process only non compositions
                                                RuntimeTagElement _jettag_c_if_37_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_37_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_37_17.setRuntimeParent(_jettag_c_if_35_17);
                                                _jettag_c_if_37_17.setTagInfo(_td_c_if_37_17);
                                                _jettag_c_if_37_17.doStart(context, out);
                                                while (_jettag_c_if_37_17.okToProcessBody()) {
                                                    // update flag variable
                                                    RuntimeTagElement _jettag_c_setVariable_39_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_39_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_setVariable_39_17.setRuntimeParent(_jettag_c_if_37_17);
                                                    _jettag_c_setVariable_39_17.setTagInfo(_td_c_setVariable_39_17);
                                                    _jettag_c_setVariable_39_17.doStart(context, out);
                                                    _jettag_c_setVariable_39_17.doEnd();
                                                    _jettag_c_if_37_17.handleBodyContent(out);
                                                }
                                                _jettag_c_if_37_17.doEnd();
                                                _jettag_c_if_35_17.handleBodyContent(out);
                                            }
                                            _jettag_c_if_35_17.doEnd();
                                            _jettag_c_iterate_33_17.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_33_17.doEnd();
                                        _jettag_c_if_29_11.handleBodyContent(out);
                                    }
                                    _jettag_c_if_29_11.doEnd();
                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_iterate_26_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_26_8.doEnd();
                                _jettag_c_iterate_25_7.handleBodyContent(out);
                            }
                            _jettag_c_iterate_25_7.doEnd();
                            _jettag_c_iterate_24_6.handleBodyContent(out);
                        }
                        _jettag_c_iterate_24_6.doEnd();
                        // process all generizations to eliminate all parent classes
                        RuntimeTagElement _jettag_c_iterate_49_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_49_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_49_5.setRuntimeParent(_jettag_c_if_22_8);
                        _jettag_c_iterate_49_5.setTagInfo(_td_c_iterate_49_5);
                        _jettag_c_iterate_49_5.doStart(context, out);
                        while (_jettag_c_iterate_49_5.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_if_50_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_50_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_50_6.setRuntimeParent(_jettag_c_iterate_49_5);
                            _jettag_c_if_50_6.setTagInfo(_td_c_if_50_6);
                            _jettag_c_if_50_6.doStart(context, out);
                            while (_jettag_c_if_50_6.okToProcessBody()) {
                                // update flag variable
                                RuntimeTagElement _jettag_c_setVariable_52_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_52_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_52_6.setRuntimeParent(_jettag_c_if_50_6);
                                _jettag_c_setVariable_52_6.setTagInfo(_td_c_setVariable_52_6);
                                _jettag_c_setVariable_52_6.doStart(context, out);
                                _jettag_c_setVariable_52_6.doEnd();
                                _jettag_c_if_50_6.handleBodyContent(out);
                            }
                            _jettag_c_if_50_6.doEnd();
                            _jettag_c_iterate_49_5.handleBodyContent(out);
                        }
                        _jettag_c_iterate_49_5.doEnd();
                        // check for flag varibles and add menu item class
                        RuntimeTagElement _jettag_c_if_56_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_56_8); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_56_8.setRuntimeParent(_jettag_c_if_22_8);
                        _jettag_c_if_56_8.setTagInfo(_td_c_if_56_8);
                        _jettag_c_if_56_8.doStart(context, out);
                        while (_jettag_c_if_56_8.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_if_57_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_57_8); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_57_8.setRuntimeParent(_jettag_c_if_56_8);
                            _jettag_c_if_57_8.setTagInfo(_td_c_if_57_8);
                            _jettag_c_if_57_8.doStart(context, out);
                            while (_jettag_c_if_57_8.okToProcessBody()) {
                                out.write("    \t\timport ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$groupID}", 58, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".android.");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$package/@name}", 58, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 58, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".ReadAll");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$class/@name}", 58, 87)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("s;");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_if_57_8.handleBodyContent(out);
                            }
                            _jettag_c_if_57_8.doEnd();
                            _jettag_c_if_56_8.handleBodyContent(out);
                        }
                        _jettag_c_if_56_8.doEnd();
                        _jettag_c_if_22_8.handleBodyContent(out);
                    }
                    _jettag_c_if_22_8.doEnd();
                    _jettag_c_iterate_17_5.handleBodyContent(out);
                }
                _jettag_c_iterate_17_5.doEnd();
                _jettag_c_iterate_15_2.handleBodyContent(out);
            }
            _jettag_c_iterate_15_2.doEnd();
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("public class ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 65, 14)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Welcome extends ListActivity {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\tpublic static String baseURL = \"http://10.0.2.2:8080/");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 67, 55)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("-webapp/seam/resource/restv1/crud/\";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic static String manageURL = \"http://10.0.2.2:8080/");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 68, 57)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("-webapp/seam/resource/restv1/manage/\";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprivate SimpleAdapter notes;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("    @Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("    public void onCreate(Bundle savedInstanceState) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("        super.onCreate(savedInstanceState);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("      \tnotes = new SimpleAdapter(this, getData(), R.layout.list_item,");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\tnew String[] { \"text\" }, new int[] { R.id.list_item_view });");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tsetListAdapter(notes);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("        ");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected void onListItemClick(ListView l, View v, int position, long id) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tMap map = (Map) l.getItemAtPosition(position);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tIntent intent = (Intent) map.get(\"intent\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tstartActivity(intent);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write(NL);         
            out.write("\tprotected ArrayList<HashMap<String, Object>> getData() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t");  //$NON-NLS-1$        
            out.write(NL);         
            RuntimeTagElement _jettag_c_iterate_91_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_91_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_91_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_iterate_91_2.setTagInfo(_td_c_iterate_91_2);
            _jettag_c_iterate_91_2.doStart(context, out);
            while (_jettag_c_iterate_91_2.okToProcessBody()) {
                // iterate through class and add only non composite children and non parent
                RuntimeTagElement _jettag_c_iterate_93_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_93_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_93_5.setRuntimeParent(_jettag_c_iterate_91_2);
                _jettag_c_iterate_93_5.setTagInfo(_td_c_iterate_93_5);
                _jettag_c_iterate_93_5.doStart(context, out);
                while (_jettag_c_iterate_93_5.okToProcessBody()) {
                    // Flag varibles
                    RuntimeTagElement _jettag_c_setVariable_95_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_95_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_95_8.setRuntimeParent(_jettag_c_iterate_93_5);
                    _jettag_c_setVariable_95_8.setTagInfo(_td_c_setVariable_95_8);
                    _jettag_c_setVariable_95_8.doStart(context, out);
                    _jettag_c_setVariable_95_8.doEnd();
                    RuntimeTagElement _jettag_c_setVariable_96_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_96_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_96_8.setRuntimeParent(_jettag_c_iterate_93_5);
                    _jettag_c_setVariable_96_8.setTagInfo(_td_c_setVariable_96_8);
                    _jettag_c_setVariable_96_8.doStart(context, out);
                    _jettag_c_setVariable_96_8.doEnd();
                    RuntimeTagElement _jettag_c_setVariable_97_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_97_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_97_8.setRuntimeParent(_jettag_c_iterate_93_5);
                    _jettag_c_setVariable_97_8.setTagInfo(_td_c_setVariable_97_8);
                    _jettag_c_setVariable_97_8.doStart(context, out);
                    _jettag_c_setVariable_97_8.doEnd();
                    RuntimeTagElement _jettag_c_if_98_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_98_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_98_8.setRuntimeParent(_jettag_c_iterate_93_5);
                    _jettag_c_if_98_8.setTagInfo(_td_c_if_98_8);
                    _jettag_c_if_98_8.doStart(context, out);
                    while (_jettag_c_if_98_8.okToProcessBody()) {
                        // process all associations to eliminate composite children
                        RuntimeTagElement _jettag_c_iterate_100_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_100_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_100_6.setRuntimeParent(_jettag_c_if_98_8);
                        _jettag_c_iterate_100_6.setTagInfo(_td_c_iterate_100_6);
                        _jettag_c_iterate_100_6.doStart(context, out);
                        while (_jettag_c_iterate_100_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_101_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_101_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_101_7.setRuntimeParent(_jettag_c_iterate_100_6);
                            _jettag_c_iterate_101_7.setTagInfo(_td_c_iterate_101_7);
                            _jettag_c_iterate_101_7.doStart(context, out);
                            while (_jettag_c_iterate_101_7.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_iterate_102_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_102_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_102_8.setRuntimeParent(_jettag_c_iterate_101_7);
                                _jettag_c_iterate_102_8.setTagInfo(_td_c_iterate_102_8);
                                _jettag_c_iterate_102_8.doStart(context, out);
                                while (_jettag_c_iterate_102_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_103_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_103_9); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_103_9.setRuntimeParent(_jettag_c_iterate_102_8);
                                    _jettag_c_setVariable_103_9.setTagInfo(_td_c_setVariable_103_9);
                                    _jettag_c_setVariable_103_9.doStart(context, out);
                                    _jettag_c_setVariable_103_9.doEnd();
                                    // check is the association is corresponding to the class  
                                    RuntimeTagElement _jettag_c_if_105_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_105_11); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_105_11.setRuntimeParent(_jettag_c_iterate_102_8);
                                    _jettag_c_if_105_11.setTagInfo(_td_c_if_105_11);
                                    _jettag_c_if_105_11.doStart(context, out);
                                    while (_jettag_c_if_105_11.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        out.write("\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        // iterate over the iterations ends  
                                        RuntimeTagElement _jettag_c_iterate_109_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_109_17); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_109_17.setRuntimeParent(_jettag_c_if_105_11);
                                        _jettag_c_iterate_109_17.setTagInfo(_td_c_iterate_109_17);
                                        _jettag_c_iterate_109_17.doStart(context, out);
                                        while (_jettag_c_iterate_109_17.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_setVariable_110_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_110_17); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_110_17.setRuntimeParent(_jettag_c_iterate_109_17);
                                            _jettag_c_setVariable_110_17.setTagInfo(_td_c_setVariable_110_17);
                                            _jettag_c_setVariable_110_17.doStart(context, out);
                                            _jettag_c_setVariable_110_17.doEnd();
                                            RuntimeTagElement _jettag_c_if_111_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_111_17); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_111_17.setRuntimeParent(_jettag_c_iterate_109_17);
                                            _jettag_c_if_111_17.setTagInfo(_td_c_if_111_17);
                                            _jettag_c_if_111_17.doStart(context, out);
                                            while (_jettag_c_if_111_17.okToProcessBody()) {
                                                // process only non compositions
                                                RuntimeTagElement _jettag_c_if_113_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_113_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_113_17.setRuntimeParent(_jettag_c_if_111_17);
                                                _jettag_c_if_113_17.setTagInfo(_td_c_if_113_17);
                                                _jettag_c_if_113_17.doStart(context, out);
                                                while (_jettag_c_if_113_17.okToProcessBody()) {
                                                    // update flag variable
                                                    RuntimeTagElement _jettag_c_setVariable_115_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_115_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_setVariable_115_17.setRuntimeParent(_jettag_c_if_113_17);
                                                    _jettag_c_setVariable_115_17.setTagInfo(_td_c_setVariable_115_17);
                                                    _jettag_c_setVariable_115_17.doStart(context, out);
                                                    _jettag_c_setVariable_115_17.doEnd();
                                                    _jettag_c_if_113_17.handleBodyContent(out);
                                                }
                                                _jettag_c_if_113_17.doEnd();
                                                _jettag_c_if_111_17.handleBodyContent(out);
                                            }
                                            _jettag_c_if_111_17.doEnd();
                                            _jettag_c_iterate_109_17.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_109_17.doEnd();
                                        _jettag_c_if_105_11.handleBodyContent(out);
                                    }
                                    _jettag_c_if_105_11.doEnd();
                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_iterate_102_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_102_8.doEnd();
                                _jettag_c_iterate_101_7.handleBodyContent(out);
                            }
                            _jettag_c_iterate_101_7.doEnd();
                            _jettag_c_iterate_100_6.handleBodyContent(out);
                        }
                        _jettag_c_iterate_100_6.doEnd();
                        // process all generizations to eliminate all parent classes
                        RuntimeTagElement _jettag_c_iterate_125_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_125_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_125_5.setRuntimeParent(_jettag_c_if_98_8);
                        _jettag_c_iterate_125_5.setTagInfo(_td_c_iterate_125_5);
                        _jettag_c_iterate_125_5.doStart(context, out);
                        while (_jettag_c_iterate_125_5.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_if_126_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_126_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_126_6.setRuntimeParent(_jettag_c_iterate_125_5);
                            _jettag_c_if_126_6.setTagInfo(_td_c_if_126_6);
                            _jettag_c_if_126_6.doStart(context, out);
                            while (_jettag_c_if_126_6.okToProcessBody()) {
                                // update flag variable
                                RuntimeTagElement _jettag_c_setVariable_128_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_128_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_128_6.setRuntimeParent(_jettag_c_if_126_6);
                                _jettag_c_setVariable_128_6.setTagInfo(_td_c_setVariable_128_6);
                                _jettag_c_setVariable_128_6.doStart(context, out);
                                _jettag_c_setVariable_128_6.doEnd();
                                _jettag_c_if_126_6.handleBodyContent(out);
                            }
                            _jettag_c_if_126_6.doEnd();
                            _jettag_c_iterate_125_5.handleBodyContent(out);
                        }
                        _jettag_c_iterate_125_5.doEnd();
                        // check for flag varibles and add menu item class
                        RuntimeTagElement _jettag_c_if_132_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_132_8); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_132_8.setRuntimeParent(_jettag_c_if_98_8);
                        _jettag_c_if_132_8.setTagInfo(_td_c_if_132_8);
                        _jettag_c_if_132_8.doStart(context, out);
                        while (_jettag_c_if_132_8.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_if_133_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_133_8); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_133_8.setRuntimeParent(_jettag_c_if_132_8);
                            _jettag_c_if_133_8.setTagInfo(_td_c_if_133_8);
                            _jettag_c_if_133_8.doStart(context, out);
                            while (_jettag_c_if_133_8.okToProcessBody()) {
                                out.write("    \t\t \tHashMap<String, Object> ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 134, 33)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("Maintainence = new HashMap<String, Object>();");  //$NON-NLS-1$        
                                out.write(NL);         
                                out.write("\t\t\t\t");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 135, 5)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("Maintainence.put(\"text\", \"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$class/@name}", 135, 58)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(" Maintainence\");");  //$NON-NLS-1$        
                                out.write(NL);         
                                out.write("\t\t\t\tIntent ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 136, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("Intent = new Intent(this, ReadAll");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$class/@name}", 136, 72)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("s.class);");  //$NON-NLS-1$        
                                out.write(NL);         
                                out.write("\t\t\t\t");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 137, 5)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("Maintainence.put(\"intent\", ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 137, 59)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("Intent);");  //$NON-NLS-1$        
                                out.write(NL);         
                                out.write("\t\t\t\tlist.add(");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 138, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("Maintainence);");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_if_133_8.handleBodyContent(out);
                            }
                            _jettag_c_if_133_8.doEnd();
                            _jettag_c_if_132_8.handleBodyContent(out);
                        }
                        _jettag_c_if_132_8.doEnd();
                        out.write("\t\t\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_if_98_8.handleBodyContent(out);
                    }
                    _jettag_c_if_98_8.doEnd();
                    _jettag_c_iterate_93_5.handleBodyContent(out);
                }
                _jettag_c_iterate_93_5.doEnd();
                _jettag_c_iterate_91_2.handleBodyContent(out);
            }
            _jettag_c_iterate_91_2.doEnd();
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn list;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t} ");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t      ");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("}");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_java_format_1_1.handleBodyContent(out);
        }
        out = _jettag_java_format_1_1_saved_out;
        _jettag_java_format_1_1.doEnd();
    }
}
