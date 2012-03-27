package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_read_alljava_0 implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_read_alljava_0() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_java_format_1_1 = new TagInfo("java:format", //$NON-NLS-1$
            1, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_4_1 = new TagInfo("c:if", //$NON-NLS-1$
            4, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isDependent = 'false'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_18_1 = new TagInfo("c:if", //$NON-NLS-1$
            18, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isDependent = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_20_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            20, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_21_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            21, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_22_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            22, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_23_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            23, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_25_6 = new TagInfo("c:if", //$NON-NLS-1$
            25, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_28_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            28, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_29_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            29, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_31_14 = new TagInfo("c:if", //$NON-NLS-1$
            31, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_33_14 = new TagInfo("c:if", //$NON-NLS-1$
            33, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_35_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            35, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_36_16 = new TagInfo("c:if", //$NON-NLS-1$
            36, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_38_11 = new TagInfo("c:if", //$NON-NLS-1$
            38, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class2/@parent1 = $class2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_39_11 = new TagInfo("c:if", //$NON-NLS-1$
            39, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class2/@hasChildren = $class2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_43_11 = new TagInfo("c:if", //$NON-NLS-1$
            43, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@hasChildren = $class2/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_48_12 = new TagInfo("c:if", //$NON-NLS-1$
            48, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@parent1 = $class2/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_49_12 = new TagInfo("c:if", //$NON-NLS-1$
            49, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class2/@hasChildren = $class2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_99_1 = new TagInfo("c:if", //$NON-NLS-1$
            99, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isDependent = 'false'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_133_1 = new TagInfo("c:if", //$NON-NLS-1$
            133, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isDependent = 'false'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_180_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            180, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_181_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            181, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_182_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            182, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_183_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            183, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_185_6 = new TagInfo("c:if", //$NON-NLS-1$
            185, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_188_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            188, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_189_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            189, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_191_14 = new TagInfo("c:if", //$NON-NLS-1$
            191, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_193_14 = new TagInfo("c:if", //$NON-NLS-1$
            193, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_195_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            195, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_196_16 = new TagInfo("c:if", //$NON-NLS-1$
            196, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_198_11 = new TagInfo("c:if", //$NON-NLS-1$
            198, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class2/@parent1 = $class2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_199_11 = new TagInfo("c:if", //$NON-NLS-1$
            199, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class2/@hasChildren = $class2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_209_11 = new TagInfo("c:if", //$NON-NLS-1$
            209, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@hasChildren = $class2/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_220_12 = new TagInfo("c:if", //$NON-NLS-1$
            220, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@parent1 = $class2/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_221_12 = new TagInfo("c:if", //$NON-NLS-1$
            221, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class2/@hasChildren = $class2/@name)", //$NON-NLS-1$
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
            out.write(".android.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$package/@name}", 2, 29)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 2, 47)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 3, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".android.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 3, 28)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Main;");  //$NON-NLS-1$        
            out.write(NL);         
            RuntimeTagElement _jettag_c_if_4_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_4_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_4_1.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_4_1.setTagInfo(_td_c_if_4_1);
            _jettag_c_if_4_1.doStart(context, out);
            while (_jettag_c_if_4_1.okToProcessBody()) {
                out.write("import android.view.ContextMenu;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import android.widget.AdapterView.AdapterContextMenuInfo;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import android.view.ContextMenu.ContextMenuInfo;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import android.view.MenuInflater;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import android.view.MenuItem;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import android.view.Menu;");  //$NON-NLS-1$        
                out.write(NL);         
                _jettag_c_if_4_1.handleBodyContent(out);
            }
            _jettag_c_if_4_1.doEnd();
            out.write("import info.yalamanchili.android.http.HttpHelper;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 13, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".android.R;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import info.yalamanchili.android.widgets.ReadAllPageBar;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.util.Log;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("import ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 17, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".entity.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 17, 27)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 17, 57)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(";");  //$NON-NLS-1$        
            out.write(NL);         
            RuntimeTagElement _jettag_c_if_18_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_18_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_18_1.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_18_1.setTagInfo(_td_c_if_18_1);
            _jettag_c_if_18_1.doStart(context, out);
            while (_jettag_c_if_18_1.okToProcessBody()) {
                // process compsition associations
                RuntimeTagElement _jettag_c_iterate_20_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_20_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_20_2.setRuntimeParent(_jettag_c_if_18_1);
                _jettag_c_iterate_20_2.setTagInfo(_td_c_iterate_20_2);
                _jettag_c_iterate_20_2.doStart(context, out);
                while (_jettag_c_iterate_20_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_21_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_21_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_21_2.setRuntimeParent(_jettag_c_iterate_20_2);
                    _jettag_c_iterate_21_2.setTagInfo(_td_c_iterate_21_2);
                    _jettag_c_iterate_21_2.doStart(context, out);
                    while (_jettag_c_iterate_21_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_22_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_22_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_22_3.setRuntimeParent(_jettag_c_iterate_21_2);
                        _jettag_c_iterate_22_3.setTagInfo(_td_c_iterate_22_3);
                        _jettag_c_iterate_22_3.doStart(context, out);
                        while (_jettag_c_iterate_22_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_23_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_23_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_23_4.setRuntimeParent(_jettag_c_iterate_22_3);
                            _jettag_c_setVariable_23_4.setTagInfo(_td_c_setVariable_23_4);
                            _jettag_c_setVariable_23_4.doStart(context, out);
                            _jettag_c_setVariable_23_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_25_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_25_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_25_6.setRuntimeParent(_jettag_c_iterate_22_3);
                            _jettag_c_if_25_6.setTagInfo(_td_c_if_25_6);
                            _jettag_c_if_25_6.doStart(context, out);
                            while (_jettag_c_if_25_6.okToProcessBody()) {
                                // process only compositions
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_28_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_28_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_28_12.setRuntimeParent(_jettag_c_if_25_6);
                                _jettag_c_iterate_28_12.setTagInfo(_td_c_iterate_28_12);
                                _jettag_c_iterate_28_12.doStart(context, out);
                                while (_jettag_c_iterate_28_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_29_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_29_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_29_12.setRuntimeParent(_jettag_c_iterate_28_12);
                                    _jettag_c_setVariable_29_12.setTagInfo(_td_c_setVariable_29_12);
                                    _jettag_c_setVariable_29_12.doStart(context, out);
                                    _jettag_c_setVariable_29_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_31_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_31_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_31_14.setRuntimeParent(_jettag_c_iterate_28_12);
                                    _jettag_c_if_31_14.setTagInfo(_td_c_if_31_14);
                                    _jettag_c_if_31_14.doStart(context, out);
                                    while (_jettag_c_if_31_14.okToProcessBody()) {
                                        // check if this is a comp
                                        RuntimeTagElement _jettag_c_if_33_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_33_14); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_33_14.setRuntimeParent(_jettag_c_if_31_14);
                                        _jettag_c_if_33_14.setTagInfo(_td_c_if_33_14);
                                        _jettag_c_if_33_14.doStart(context, out);
                                        while (_jettag_c_if_33_14.okToProcessBody()) {
                                            // iterate throught all the classes to get the other class on the association
                                            RuntimeTagElement _jettag_c_iterate_35_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_35_15); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_iterate_35_15.setRuntimeParent(_jettag_c_if_33_14);
                                            _jettag_c_iterate_35_15.setTagInfo(_td_c_iterate_35_15);
                                            _jettag_c_iterate_35_15.doStart(context, out);
                                            while (_jettag_c_iterate_35_15.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_36_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_36_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_36_16.setRuntimeParent(_jettag_c_iterate_35_15);
                                                _jettag_c_if_36_16.setTagInfo(_td_c_if_36_16);
                                                _jettag_c_if_36_16.doStart(context, out);
                                                while (_jettag_c_if_36_16.okToProcessBody()) {
                                                    // check to see if class2 is parent and child
                                                    RuntimeTagElement _jettag_c_if_38_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_38_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_38_11.setRuntimeParent(_jettag_c_if_36_16);
                                                    _jettag_c_if_38_11.setTagInfo(_td_c_if_38_11);
                                                    _jettag_c_if_38_11.doStart(context, out);
                                                    while (_jettag_c_if_38_11.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_39_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_39_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_39_11.setRuntimeParent(_jettag_c_if_38_11);
                                                        _jettag_c_if_39_11.setTagInfo(_td_c_if_39_11);
                                                        _jettag_c_if_39_11.doStart(context, out);
                                                        while (_jettag_c_if_39_11.okToProcessBody()) {
                                                            out.write("\t\t\t\t\t\t\t\t\t\timport\t");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$groupID}", 40, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".entity.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$package/@name}", 40, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 40, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(";");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_39_11.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_39_11.doEnd();
                                                        // has parent and no children
                                                        RuntimeTagElement _jettag_c_if_43_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_43_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_43_11.setRuntimeParent(_jettag_c_if_38_11);
                                                        _jettag_c_if_43_11.setTagInfo(_td_c_if_43_11);
                                                        _jettag_c_if_43_11.doStart(context, out);
                                                        while (_jettag_c_if_43_11.okToProcessBody()) {
                                                            out.write("\t\t\t\t\t\t\t\t\t\timport\t");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$groupID}", 44, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".entity.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$package/@name}", 44, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 44, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(";");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_43_11.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_43_11.doEnd();
                                                        _jettag_c_if_38_11.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_38_11.doEnd();
                                                    // no parent and has children
                                                    RuntimeTagElement _jettag_c_if_48_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_48_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_48_12.setRuntimeParent(_jettag_c_if_36_16);
                                                    _jettag_c_if_48_12.setTagInfo(_td_c_if_48_12);
                                                    _jettag_c_if_48_12.doStart(context, out);
                                                    while (_jettag_c_if_48_12.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_49_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_49_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_49_12.setRuntimeParent(_jettag_c_if_48_12);
                                                        _jettag_c_if_49_12.setTagInfo(_td_c_if_49_12);
                                                        _jettag_c_if_49_12.doStart(context, out);
                                                        while (_jettag_c_if_49_12.okToProcessBody()) {
                                                            out.write("\t\t\t\t\t\t\t\t\t\timport\t");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$groupID}", 50, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".entity.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$package/@name}", 50, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 50, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(";");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_49_12.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_49_12.doEnd();
                                                        _jettag_c_if_48_12.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_48_12.doEnd();
                                                    _jettag_c_if_36_16.handleBodyContent(out);
                                                }
                                                _jettag_c_if_36_16.doEnd();
                                                _jettag_c_iterate_35_15.handleBodyContent(out);
                                            }
                                            _jettag_c_iterate_35_15.doEnd();
                                            _jettag_c_if_33_14.handleBodyContent(out);
                                        }
                                        _jettag_c_if_33_14.doEnd();
                                        _jettag_c_if_31_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_31_14.doEnd();
                                    _jettag_c_iterate_28_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_28_12.doEnd();
                                _jettag_c_if_25_6.handleBodyContent(out);
                            }
                            _jettag_c_if_25_6.doEnd();
                            _jettag_c_iterate_22_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_22_3.doEnd();
                        _jettag_c_iterate_21_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_21_2.doEnd();
                    _jettag_c_iterate_20_2.handleBodyContent(out);
                }
                _jettag_c_iterate_20_2.doEnd();
                _jettag_c_if_18_1.handleBodyContent(out);
            }
            _jettag_c_if_18_1.doEnd();
            out.write("import java.util.ArrayList;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import java.util.List;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import info.yalamanchili.android.http.AsyncHttpGet;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("import android.widget.Button;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.app.Activity;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.content.Intent;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.os.Bundle;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.View;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.ListView;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.TextView;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.Window;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.AdapterView;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.AdapterView.OnItemClickListener;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.View.OnClickListener;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("public class ReadAll");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 79, 21)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("s extends Activity implements OnItemClickListener,OnClickListener{");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprivate Integer pageOffSet = 0;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprivate ArrayList<");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 81, 20)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("> ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 81, 37)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("s = new ArrayList<");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 81, 82)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(">();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprivate ListView ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 82, 19)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("ListView;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprivate Button create;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprivate Button nextPage;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprivate Button previousPage;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprivate ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 86, 10)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Adapter ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 86, 33)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Adapter;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void onCreate(Bundle savedInstanceState) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tsuper.onCreate(savedInstanceState);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\trequestWindowFeature(Window.FEATURE_CUSTOM_TITLE);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tsetContentView(R.layout.entity_readall);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tcustomizeTitle();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tgetControls();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tsetListeners();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tint resID = R.layout.readall_list;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 97, 3)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Adapter = new ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 97, 44)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Adapter(ReadAll");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 97, 74)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("s.this, resID, ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 97, 104)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("s);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 98, 3)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("ListView.setAdapter(");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 98, 50)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Adapter);");  //$NON-NLS-1$        
            out.write(NL);         
            RuntimeTagElement _jettag_c_if_99_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_99_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_99_1.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_99_1.setTagInfo(_td_c_if_99_1);
            _jettag_c_if_99_1.doStart(context, out);
            while (_jettag_c_if_99_1.okToProcessBody()) {
                out.write("\t\tregisterForContextMenu(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 100, 26)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ListView);");  //$NON-NLS-1$        
                out.write(NL);         
                _jettag_c_if_99_1.handleBodyContent(out);
            }
            _jettag_c_if_99_1.doEnd();
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void customizeTitle(){");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tgetWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 105, 67)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_title_bar);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t     TextView mytitletext = (TextView) findViewById(R.id.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 106, 59)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_title_text);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t     mytitletext.setText(\"Read All ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 107, 37)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("s Panel\");\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void getControls() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tReadAllPageBar pageBar=\t(ReadAllPageBar)findViewById(R.id.read_all_page_bar);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tcreate=pageBar.getCreateButton();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tnextPage=pageBar.getNextPageButton();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tpreviousPage=pageBar.getPreviousPageButton();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 115, 3)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("ListView = (ListView) findViewById(R.id.readall_listview);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void setListeners() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tcreate.setOnClickListener(this);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tnextPage.setOnClickListener(this);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tpreviousPage.setOnClickListener(this);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 122, 3)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("ListView.setOnItemClickListener(this);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\tpublic void onItemClick(AdapterView<?> parent, View arg1, int position,");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tlong id) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 127, 3)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 127, 19)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" = (");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 127, 50)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(") parent.getItemAtPosition(position);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tIntent intent = new Intent(this, Read");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 128, 40)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".class);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tintent.putExtra(\"id\", ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 129, 25)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".getId());");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tstartActivity(intent);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            RuntimeTagElement _jettag_c_if_133_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_133_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_133_1.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_133_1.setTagInfo(_td_c_if_133_1);
            _jettag_c_if_133_1.doStart(context, out);
            while (_jettag_c_if_133_1.okToProcessBody()) {
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic boolean onCreateOptionsMenu(Menu menu) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tMenuInflater inflater = getMenuInflater();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinflater.inflate(R.menu.read_all_search_menu, menu);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn true;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic boolean onOptionsItemSelected(MenuItem item) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tswitch (item.getItemId()) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tcase R.id.search:");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tIntent intent = new Intent(this, Search");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 145, 43)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".class);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tstartActivity(intent);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tbreak;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn true;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void onCreateContextMenu(ContextMenu menu, View v,");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tContextMenuInfo menuInfo) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tsuper.onCreateContextMenu(menu, v, menuInfo);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tMenuInflater inflater = getMenuInflater();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinflater.inflate(R.menu.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 157, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("_menu, menu);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic boolean onContextItemSelected(MenuItem item) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tAdapterContextMenuInfo info = (AdapterContextMenuInfo) item");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t.getMenuInfo();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tLog.d(\"aaaaaaaaaaaaaaaaaaaaaa\", \"in contes sel\");");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn true;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                _jettag_c_if_133_1.handleBodyContent(out);
            }
            _jettag_c_if_133_1.doEnd();
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic String getReadALLURL(Integer pageOffSet, Integer pageSize) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\treturn ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 171, 9)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Main.baseURL + \"");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 171, 51)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("/readall/\" + pageOffSet.toString()");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t+ \"/\" + getString(R.string.page_size);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void onClick(View arg0) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("Object parent = getIntent().getSerializableExtra(\"parent\");\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tif (arg0.getId() == create.getId()) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tif(parent!=null){");  //$NON-NLS-1$        
            out.write(NL);         
            // process compsition associations
            RuntimeTagElement _jettag_c_iterate_180_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_180_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_180_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_iterate_180_2.setTagInfo(_td_c_iterate_180_2);
            _jettag_c_iterate_180_2.doStart(context, out);
            while (_jettag_c_iterate_180_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_181_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_181_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_181_2.setRuntimeParent(_jettag_c_iterate_180_2);
                _jettag_c_iterate_181_2.setTagInfo(_td_c_iterate_181_2);
                _jettag_c_iterate_181_2.doStart(context, out);
                while (_jettag_c_iterate_181_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_182_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_182_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_182_3.setRuntimeParent(_jettag_c_iterate_181_2);
                    _jettag_c_iterate_182_3.setTagInfo(_td_c_iterate_182_3);
                    _jettag_c_iterate_182_3.doStart(context, out);
                    while (_jettag_c_iterate_182_3.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_setVariable_183_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_183_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_183_4.setRuntimeParent(_jettag_c_iterate_182_3);
                        _jettag_c_setVariable_183_4.setTagInfo(_td_c_setVariable_183_4);
                        _jettag_c_setVariable_183_4.doStart(context, out);
                        _jettag_c_setVariable_183_4.doEnd();
                        // check is the association is corresponding to the class  
                        RuntimeTagElement _jettag_c_if_185_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_185_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_185_6.setRuntimeParent(_jettag_c_iterate_182_3);
                        _jettag_c_if_185_6.setTagInfo(_td_c_if_185_6);
                        _jettag_c_if_185_6.doStart(context, out);
                        while (_jettag_c_if_185_6.okToProcessBody()) {
                            // process only compositions
                            // iterate over the iterations ends  
                            RuntimeTagElement _jettag_c_iterate_188_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_188_12); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_188_12.setRuntimeParent(_jettag_c_if_185_6);
                            _jettag_c_iterate_188_12.setTagInfo(_td_c_iterate_188_12);
                            _jettag_c_iterate_188_12.doStart(context, out);
                            while (_jettag_c_iterate_188_12.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_189_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_189_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_189_12.setRuntimeParent(_jettag_c_iterate_188_12);
                                _jettag_c_setVariable_189_12.setTagInfo(_td_c_setVariable_189_12);
                                _jettag_c_setVariable_189_12.doStart(context, out);
                                _jettag_c_setVariable_189_12.doEnd();
                                // get the end secondary end with other class  
                                RuntimeTagElement _jettag_c_if_191_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_191_14); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_191_14.setRuntimeParent(_jettag_c_iterate_188_12);
                                _jettag_c_if_191_14.setTagInfo(_td_c_if_191_14);
                                _jettag_c_if_191_14.doStart(context, out);
                                while (_jettag_c_if_191_14.okToProcessBody()) {
                                    // check if this is a comp
                                    RuntimeTagElement _jettag_c_if_193_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_193_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_193_14.setRuntimeParent(_jettag_c_if_191_14);
                                    _jettag_c_if_193_14.setTagInfo(_td_c_if_193_14);
                                    _jettag_c_if_193_14.doStart(context, out);
                                    while (_jettag_c_if_193_14.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_195_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_195_15); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_195_15.setRuntimeParent(_jettag_c_if_193_14);
                                        _jettag_c_iterate_195_15.setTagInfo(_td_c_iterate_195_15);
                                        _jettag_c_iterate_195_15.doStart(context, out);
                                        while (_jettag_c_iterate_195_15.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_196_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_196_16); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_196_16.setRuntimeParent(_jettag_c_iterate_195_15);
                                            _jettag_c_if_196_16.setTagInfo(_td_c_if_196_16);
                                            _jettag_c_if_196_16.doStart(context, out);
                                            while (_jettag_c_if_196_16.okToProcessBody()) {
                                                // check to see if class2 is parent and child
                                                RuntimeTagElement _jettag_c_if_198_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_198_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_198_11.setRuntimeParent(_jettag_c_if_196_16);
                                                _jettag_c_if_198_11.setTagInfo(_td_c_if_198_11);
                                                _jettag_c_if_198_11.doStart(context, out);
                                                while (_jettag_c_if_198_11.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_199_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_199_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_199_11.setRuntimeParent(_jettag_c_if_198_11);
                                                    _jettag_c_if_199_11.setTagInfo(_td_c_if_199_11);
                                                    _jettag_c_if_199_11.doStart(context, out);
                                                    while (_jettag_c_if_199_11.okToProcessBody()) {
                                                        out.write("\t\t\t\t\t\t\t\t\t\tif (arg0.getId() == create.getId()) {");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t\tIntent addIntent = new Intent(this, Create");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class/@name}", 201, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".class);");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class/@name}", 202, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(" ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 202, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(" = new ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class/@name}", 202, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("();");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 203, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".set");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 203, 44)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("((");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 203, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(") parent);");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t\taddIntent.putExtra(\"entity\", ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 204, 42)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(");");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t\tstartActivity(addIntent);");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_199_11.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_199_11.doEnd();
                                                    // has parent and no children
                                                    RuntimeTagElement _jettag_c_if_209_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_209_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_209_11.setRuntimeParent(_jettag_c_if_198_11);
                                                    _jettag_c_if_209_11.setTagInfo(_td_c_if_209_11);
                                                    _jettag_c_if_209_11.doStart(context, out);
                                                    while (_jettag_c_if_209_11.okToProcessBody()) {
                                                        out.write("\t\t\t\t\t\t\t\t\t\tif (arg0.getId() == create.getId()) {");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t\tIntent addIntent = new Intent(this, Create");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class/@name}", 211, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".class);");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class/@name}", 212, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(" ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 212, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(" = new ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class/@name}", 212, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("();");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 213, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".set");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 213, 44)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("((");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 213, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(") parent);");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t\taddIntent.putExtra(\"entity\", ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 214, 42)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(");");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t\tstartActivity(addIntent);");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_209_11.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_209_11.doEnd();
                                                    _jettag_c_if_198_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_198_11.doEnd();
                                                // no parent and has children
                                                RuntimeTagElement _jettag_c_if_220_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_220_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_220_12.setRuntimeParent(_jettag_c_if_196_16);
                                                _jettag_c_if_220_12.setTagInfo(_td_c_if_220_12);
                                                _jettag_c_if_220_12.doStart(context, out);
                                                while (_jettag_c_if_220_12.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_221_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_221_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_221_12.setRuntimeParent(_jettag_c_if_220_12);
                                                    _jettag_c_if_221_12.setTagInfo(_td_c_if_221_12);
                                                    _jettag_c_if_221_12.doStart(context, out);
                                                    while (_jettag_c_if_221_12.okToProcessBody()) {
                                                        out.write("\t\t\t\t\t\t\t\t\t\tif (arg0.getId() == create.getId()) {");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t\tIntent addIntent = new Intent(this, Create");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class/@name}", 223, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".class);");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class/@name}", 224, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(" ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 224, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(" = new ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class/@name}", 224, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("();");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 225, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".set");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 225, 44)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("((");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 225, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(") parent);");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t\taddIntent.putExtra(\"entity\", ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 226, 42)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(");");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t\tstartActivity(addIntent);");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_221_12.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_221_12.doEnd();
                                                    _jettag_c_if_220_12.handleBodyContent(out);
                                                }
                                                _jettag_c_if_220_12.doEnd();
                                                _jettag_c_if_196_16.handleBodyContent(out);
                                            }
                                            _jettag_c_if_196_16.doEnd();
                                            _jettag_c_iterate_195_15.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_195_15.doEnd();
                                        _jettag_c_if_193_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_193_14.doEnd();
                                    _jettag_c_if_191_14.handleBodyContent(out);
                                }
                                _jettag_c_if_191_14.doEnd();
                                _jettag_c_iterate_188_12.handleBodyContent(out);
                            }
                            _jettag_c_iterate_188_12.doEnd();
                            _jettag_c_if_185_6.handleBodyContent(out);
                        }
                        _jettag_c_if_185_6.doEnd();
                        _jettag_c_iterate_182_3.handleBodyContent(out);
                    }
                    _jettag_c_iterate_182_3.doEnd();
                    _jettag_c_iterate_181_2.handleBodyContent(out);
                }
                _jettag_c_iterate_181_2.doEnd();
                _jettag_c_iterate_180_2.handleBodyContent(out);
            }
            _jettag_c_iterate_180_2.doEnd();
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\telse{");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tIntent createIntent = new Intent(this, Create");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 242, 48)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".class);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tstartActivity(createIntent);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tif (arg0.getId() == nextPage.getId()) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tloadNextPage();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tif (arg0.getId() == previousPage.getId()) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tloadPreviousPage();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected void loadNextPage() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tpageOffSet = pageOffSet + new Integer(getString(R.string.page_size));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tloadPage(pageOffSet, new Integer(getString(R.string.page_size)));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\tprotected void loadPreviousPage() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tif (pageOffSet >= new Integer(getString(R.string.page_size))) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tpageOffSet = pageOffSet");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t- new Integer(getString(R.string.page_size));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tloadPage(pageOffSet, new Integer(getString(R.string.page_size)));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected void loadPage(int pageOffSet, int pageSize) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 269, 3)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Adapter.clear();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tString intent = getIntent().getStringExtra(\"intent\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tif (\"SEARCH\".equals(intent)) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tnew AsyncHttpGet(this) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\tprotected void onResponse(String result) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\tObject obj = HttpHelper.xstream.fromXML(result);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\tif (obj instanceof List<?>) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t\tfor (");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 277, 12)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" entity : (List<");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 277, 43)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(">) HttpHelper.xstream");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t\t\t\t.fromXML(result)) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t\t\t");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 279, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Adapter.add(entity);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t}.execute(getSearchURL());");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t} ");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tString parentResource=getIntent().getStringExtra(\"resource\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tif(parentResource!=null){");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tnew AsyncHttpGet(this) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\tprotected void onResponse(String result) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\tObject obj = HttpHelper.xstream.fromXML(result);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\tif (obj instanceof List<?>) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t\tfor (");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 293, 12)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" entity : (List<");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 293, 43)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(">) HttpHelper.xstream");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t\t\t\t.fromXML(result)) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t\t\t");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 295, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Adapter.add(entity);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t}.execute(parentResource);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\treturn;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tnew AsyncHttpGet(this) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tprotected void onResponse(String result) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\tObject obj = HttpHelper.xstream.fromXML(result);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\tif (obj instanceof List<?>) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\tfor (");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 307, 11)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" entity : (List<");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 307, 42)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(">) HttpHelper.xstream");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t\t\t.fromXML(result)) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t\t");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 309, 7)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Adapter.add(entity);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}.execute(getReadALLURL(pageOffSet, pageSize));\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\tprotected String getSearchURL() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tString searchText = getIntent().getStringExtra(\"searchText\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 318, 10)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Main.baseURL + \"");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 318, 52)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("/search/\" + searchText;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void onStart() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tsuper.onStart();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tLog.d(\"info.yalamacnhili.android\",\"in start\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tmain();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void main() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tloadPage(0, new Integer(getString(R.string.page_size)));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("}");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_java_format_1_1.handleBodyContent(out);
        }
        out = _jettag_java_format_1_1_saved_out;
        _jettag_java_format_1_1.doEnd();
    }
}
