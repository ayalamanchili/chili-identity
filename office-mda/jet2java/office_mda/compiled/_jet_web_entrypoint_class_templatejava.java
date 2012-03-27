package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_web_entrypoint_class_templatejava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_web_entrypoint_class_templatejava() {
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
    private static final TagInfo _td_c_iterate_7_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            7, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_8_8 = new TagInfo("c:setVariable", //$NON-NLS-1$
            8, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($webPackage,$package/@name)", //$NON-NLS-1$
                "packageName", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_9_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            9, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_10_8 = new TagInfo("c:if", //$NON-NLS-1$
            10, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isAbstract = 'false'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_41_1 = new TagInfo("f:message", //$NON-NLS-1$
            41, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_43_1 = new TagInfo("f:message", //$NON-NLS-1$
            43, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_45_1 = new TagInfo("f:message", //$NON-NLS-1$
            45, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_47_1 = new TagInfo("f:message", //$NON-NLS-1$
            47, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_49_1 = new TagInfo("f:message", //$NON-NLS-1$
            49, 1,
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
    private static final TagInfo _td_f_message_53_1 = new TagInfo("f:message", //$NON-NLS-1$
            53, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_55_1 = new TagInfo("f:message", //$NON-NLS-1$
            55, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_62_1 = new TagInfo("f:message", //$NON-NLS-1$
            62, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_64_1 = new TagInfo("f:message", //$NON-NLS-1$
            64, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_66_1 = new TagInfo("f:message", //$NON-NLS-1$
            66, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_69_1 = new TagInfo("f:message", //$NON-NLS-1$
            69, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_75_1 = new TagInfo("f:message", //$NON-NLS-1$
            75, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_99_1 = new TagInfo("f:message", //$NON-NLS-1$
            99, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_102_1 = new TagInfo("f:message", //$NON-NLS-1$
            102, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_112_1 = new TagInfo("f:message", //$NON-NLS-1$
            112, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_117_1 = new TagInfo("f:message", //$NON-NLS-1$
            117, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_121_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            121, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_124_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            124, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_125_6 = new TagInfo("c:if", //$NON-NLS-1$
            125, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isDependent = 'false'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_131_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            131, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_145_1 = new TagInfo("f:message", //$NON-NLS-1$
            145, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_149_1 = new TagInfo("f:message", //$NON-NLS-1$
            149, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_153_1 = new TagInfo("f:message", //$NON-NLS-1$
            153, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_157_1 = new TagInfo("f:message", //$NON-NLS-1$
            157, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_161_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            161, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_163_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            163, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_164_6 = new TagInfo("c:if", //$NON-NLS-1$
            164, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isDependent = 'false'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_165_1 = new TagInfo("f:message", //$NON-NLS-1$
            165, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_180_1 = new TagInfo("f:message", //$NON-NLS-1$
            180, 1,
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
                out.write(context.embeddedExpressionAsString("${$groupID}", 5, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".client;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_c_iterate_7_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_7_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_7_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_7_1.setTagInfo(_td_c_iterate_7_1);
                _jettag_c_iterate_7_1.doStart(context, out);
                while (_jettag_c_iterate_7_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_8_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_8_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_8_8.setRuntimeParent(_jettag_c_iterate_7_1);
                    _jettag_c_setVariable_8_8.setTagInfo(_td_c_setVariable_8_8);
                    _jettag_c_setVariable_8_8.doStart(context, out);
                    _jettag_c_setVariable_8_8.doEnd();
                    RuntimeTagElement _jettag_c_iterate_9_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_9_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_9_8.setRuntimeParent(_jettag_c_iterate_7_1);
                    _jettag_c_iterate_9_8.setTagInfo(_td_c_iterate_9_8);
                    _jettag_c_iterate_9_8.doStart(context, out);
                    while (_jettag_c_iterate_9_8.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_if_10_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_10_8); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_10_8.setRuntimeParent(_jettag_c_iterate_9_8);
                        _jettag_c_if_10_8.setTagInfo(_td_c_if_10_8);
                        _jettag_c_if_10_8.doStart(context, out);
                        while (_jettag_c_if_10_8.okToProcessBody()) {
                            out.write("    \t\t\timport ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$groupID}", 11, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".client.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$package/@name}", 11, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 11, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".ReadAll");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$class/@name}", 11, 87)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("sPanely;");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("    \t\t\timport ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$groupID}", 12, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".client.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$package/@name}", 12, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 12, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$class/@name}", 12, 80)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("SideBar;");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_if_10_8.handleBodyContent(out);
                        }
                        _jettag_c_if_10_8.doEnd();
                        _jettag_c_iterate_9_8.handleBodyContent(out);
                    }
                    _jettag_c_iterate_9_8.doEnd();
                    _jettag_c_iterate_7_1.handleBodyContent(out);
                }
                _jettag_c_iterate_7_1.doEnd();
                out.write("import info.yalamanchili.gwt.composite.ReadAllCompositey.ReadAllTableType;\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.exception.GWTUncaughtExceptionHandler;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.security.gwt.SecurityWelcome;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.security.gwt.SecurityWelcome.CMD_TYPE;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.security.gwt.YRole;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.security.gwt.YUser;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.security.gwt.user.UserSideBar;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.callback.ALAsyncCallback;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.core.client.EntryPoint;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.core.client.GWT;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.ui.RootLayoutPanel;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.ui.MenuBar;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.Command;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$webPackage}", 29, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("internalization.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 29, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Constants;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$webPackage}", 30, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("internalization.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 30, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Messages;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.ui.Widget;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.ui.DockLayoutPanel;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.dom.client.Style.Unit;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.ui.FlowPanel;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.security.gwt.AdminService.AdminServiceAsync;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.web.bindery.event.shared.SimpleEventBus;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import java.util.logging.Logger;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.HashSet;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.Set;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_41_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_41_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_41_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_41_1.setTagInfo(_td_f_message_41_1);
                _jettag_f_message_41_1.doStart(context, out);
                JET2Writer _jettag_f_message_41_1_saved_out = out;
                while (_jettag_f_message_41_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_41_1.handleBodyContent(out);
                }
                out = _jettag_f_message_41_1_saved_out;
                _jettag_f_message_41_1.doEnd();
                out.write(NL);         
                out.write("public class ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 42, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome implements EntryPoint {");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_43_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_43_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_43_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_43_1.setTagInfo(_td_f_message_43_1);
                _jettag_f_message_43_1.doStart(context, out);
                JET2Writer _jettag_f_message_43_1_saved_out = out;
                while (_jettag_f_message_43_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_43_1.handleBodyContent(out);
                }
                out = _jettag_f_message_43_1_saved_out;
                _jettag_f_message_43_1.doEnd();
                out.write(NL);         
                out.write("\tprivate static Logger logger = Logger.getLogger(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 44, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.class.getName());");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_45_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_45_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_45_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_45_1.setTagInfo(_td_f_message_45_1);
                _jettag_f_message_45_1.doStart(context, out);
                JET2Writer _jettag_f_message_45_1_saved_out = out;
                while (_jettag_f_message_45_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_45_1.handleBodyContent(out);
                }
                out = _jettag_f_message_45_1_saved_out;
                _jettag_f_message_45_1.doEnd();
                out.write(NL);         
                out.write("\tprivate static ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 46, 17)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome instance;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_47_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_47_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_47_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_47_1.setTagInfo(_td_f_message_47_1);
                _jettag_f_message_47_1.doStart(context, out);
                JET2Writer _jettag_f_message_47_1_saved_out = out;
                while (_jettag_f_message_47_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_47_1.handleBodyContent(out);
                }
                out = _jettag_f_message_47_1_saved_out;
                _jettag_f_message_47_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic DockLayoutPanel mainPanel = new DockLayoutPanel(Unit.EM);");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_49_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_49_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_49_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_49_1.setTagInfo(_td_f_message_49_1);
                _jettag_f_message_49_1.doStart(context, out);
                JET2Writer _jettag_f_message_49_1_saved_out = out;
                while (_jettag_f_message_49_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_49_1.handleBodyContent(out);
                }
                out = _jettag_f_message_49_1_saved_out;
                _jettag_f_message_49_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic String user;");  //$NON-NLS-1$        
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
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic Set<String> roles = new HashSet<String>();");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_53_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_53_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_53_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_53_1.setTagInfo(_td_f_message_53_1);
                _jettag_f_message_53_1.doStart(context, out);
                JET2Writer _jettag_f_message_53_1_saved_out = out;
                while (_jettag_f_message_53_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_53_1.handleBodyContent(out);
                }
                out = _jettag_f_message_53_1_saved_out;
                _jettag_f_message_53_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic boolean isLoggedIn = false;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_55_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_55_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_55_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_55_1.setTagInfo(_td_f_message_55_1);
                _jettag_f_message_55_1.doStart(context, out);
                JET2Writer _jettag_f_message_55_1_saved_out = out;
                while (_jettag_f_message_55_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_55_1.handleBodyContent(out);
                }
                out = _jettag_f_message_55_1_saved_out;
                _jettag_f_message_55_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic static ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 56, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome instance(){");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tif (instance == null) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\treturn new ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 58, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn instance;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_62_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_62_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_62_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_62_1.setTagInfo(_td_f_message_62_1);
                _jettag_f_message_62_1.doStart(context, out);
                JET2Writer _jettag_f_message_62_1_saved_out = out;
                while (_jettag_f_message_62_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_62_1.handleBodyContent(out);
                }
                out = _jettag_f_message_62_1_saved_out;
                _jettag_f_message_62_1.doEnd();
                out.write(NL);         
                out.write("\tpublic static ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 63, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Constants constants = (");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 63, 65)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Constants) GWT.create(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 63, 113)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Constants.class);");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_64_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_64_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_64_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_64_1.setTagInfo(_td_f_message_64_1);
                _jettag_f_message_64_1.doStart(context, out);
                JET2Writer _jettag_f_message_64_1_saved_out = out;
                while (_jettag_f_message_64_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_64_1.handleBodyContent(out);
                }
                out = _jettag_f_message_64_1_saved_out;
                _jettag_f_message_64_1.doEnd();
                out.write(NL);         
                out.write("\tpublic static ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 65, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Messages messages = (");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 65, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Messages) GWT.create(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 65, 110)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Messages.class);");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_66_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_66_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_66_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_66_1.setTagInfo(_td_f_message_66_1);
                _jettag_f_message_66_1.doStart(context, out);
                JET2Writer _jettag_f_message_66_1_saved_out = out;
                while (_jettag_f_message_66_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_66_1.handleBodyContent(out);
                }
                out = _jettag_f_message_66_1_saved_out;
                _jettag_f_message_66_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic static ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 67, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("RequestFactory requestFactory = GWT.create( ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 67, 86)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("RequestFactory.class);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_69_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_69_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_69_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_69_1.setTagInfo(_td_f_message_69_1);
                _jettag_f_message_69_1.doStart(context, out);
                JET2Writer _jettag_f_message_69_1_saved_out = out;
                while (_jettag_f_message_69_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_69_1.handleBodyContent(out);
                }
                out = _jettag_f_message_69_1_saved_out;
                _jettag_f_message_69_1.doEnd();
                out.write("\t\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void onModuleLoad() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tGWT.setUncaughtExceptionHandler(new GWTUncaughtExceptionHandler());");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tinstance=this;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tinit();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_75_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_75_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_75_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_75_1.setTagInfo(_td_f_message_75_1);
                _jettag_f_message_75_1.doStart(context, out);
                JET2Writer _jettag_f_message_75_1_saved_out = out;
                while (_jettag_f_message_75_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_75_1.handleBodyContent(out);
                }
                out = _jettag_f_message_75_1_saved_out;
                _jettag_f_message_75_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void init() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tAdminServiceAsync.instance().getUser(new ALAsyncCallback<YUser>() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tpublic void onResponse(YUser user) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tif (user != null) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\tlogger.info(\"initUser on response\" + user.getUsername());");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\tisLoggedIn = true;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 83, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().user = user.getUsername();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\tfor (YRole role : user.getRoles()) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\tlogger.info(\"role:\" + role.getRolename());");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\troles.add(role.getRolename().toUpperCase());");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tRootLayout rootLayout = new RootLayout();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tconfigure();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\taddListeners();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tRootLayoutPanel.get().add(rootLayout);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\trequestFactory.initialize(new SimpleEventBus());");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t\t});");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_99_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_99_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_99_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_99_1.setTagInfo(_td_f_message_99_1);
                _jettag_f_message_99_1.doStart(context, out);
                JET2Writer _jettag_f_message_99_1_saved_out = out;
                while (_jettag_f_message_99_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_99_1.handleBodyContent(out);
                }
                out = _jettag_f_message_99_1_saved_out;
                _jettag_f_message_99_1.doEnd();
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tprotected void addListeners() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_102_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_102_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_102_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_102_1.setTagInfo(_td_f_message_102_1);
                _jettag_f_message_102_1.doStart(context, out);
                JET2Writer _jettag_f_message_102_1_saved_out = out;
                while (_jettag_f_message_102_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_102_1.handleBodyContent(out);
                }
                out = _jettag_f_message_102_1_saved_out;
                _jettag_f_message_102_1.doEnd();
                out.write(NL);         
                out.write("\tprotected void configure() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tconfigureEntityPanel();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tconfigureStatusPanel();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tconfigureSideBarTop();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tconfigureSideBarBottom();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tconfigureSideBar();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tconfigureMenuBar();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_112_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_112_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_112_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_112_1.setTagInfo(_td_f_message_112_1);
                _jettag_f_message_112_1.doStart(context, out);
                JET2Writer _jettag_f_message_112_1_saved_out = out;
                while (_jettag_f_message_112_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_112_1.handleBodyContent(out);
                }
                out = _jettag_f_message_112_1_saved_out;
                _jettag_f_message_112_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void configureEntityPanel() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_117_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_117_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_117_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_117_1.setTagInfo(_td_f_message_117_1);
                _jettag_f_message_117_1.doStart(context, out);
                JET2Writer _jettag_f_message_117_1_saved_out = out;
                while (_jettag_f_message_117_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_117_1.handleBodyContent(out);
                }
                out = _jettag_f_message_117_1_saved_out;
                _jettag_f_message_117_1.doEnd();
                out.write(NL);         
                out.write("\tprotected void configureMenuBar() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tMenuBar menu = new MenuBar();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_c_iterate_121_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_121_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_121_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_121_2.setTagInfo(_td_c_iterate_121_2);
                _jettag_c_iterate_121_2.doStart(context, out);
                while (_jettag_c_iterate_121_2.okToProcessBody()) {
                    out.write("    MenuBar ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 122, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("Bar = new MenuBar(true);");  //$NON-NLS-1$        
                    out.write(NL);         
                    // iterate through class and add only non composite children and non parent
                    RuntimeTagElement _jettag_c_iterate_124_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_124_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_124_5.setRuntimeParent(_jettag_c_iterate_121_2);
                    _jettag_c_iterate_124_5.setTagInfo(_td_c_iterate_124_5);
                    _jettag_c_iterate_124_5.doStart(context, out);
                    while (_jettag_c_iterate_124_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_if_125_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_125_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_125_6.setRuntimeParent(_jettag_c_iterate_124_5);
                        _jettag_c_if_125_6.setTagInfo(_td_c_if_125_6);
                        _jettag_c_if_125_6.doStart(context, out);
                        while (_jettag_c_if_125_6.okToProcessBody()) {
                            out.write("    \t\t \t");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 126, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("Bar.addItem(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$class/@name}", 126, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 126, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("Cmd);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_if_125_6.handleBodyContent(out);
                        }
                        _jettag_c_if_125_6.doEnd();
                        _jettag_c_iterate_124_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_124_5.doEnd();
                    _jettag_c_iterate_121_2.handleBodyContent(out);
                }
                _jettag_c_iterate_121_2.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_c_iterate_131_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_131_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_131_3.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_131_3.setTagInfo(_td_c_iterate_131_3);
                _jettag_c_iterate_131_3.doStart(context, out);
                while (_jettag_c_iterate_131_3.okToProcessBody()) {
                    out.write("\t\tmenu.addItem(\"");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${upper-case($package/@name)}", 132, 17)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\", ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 132, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("Bar);");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_iterate_131_3.handleBodyContent(out);
                }
                _jettag_c_iterate_131_3.doEnd();
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tif (roles.contains(\"ADMIN\")) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tMenuBar adminBar = new MenuBar(true);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tadminBar.addItem(\"Users\", userCmd);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tadminBar.addItem(\"Roles\", roleCmd);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t// TODO check admin role");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tmenu.addItem(\"ADMIN\", adminBar);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tRootLayout.instance().menuBar.add(menu);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_145_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_145_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_145_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_145_1.setTagInfo(_td_f_message_145_1);
                _jettag_f_message_145_1.doStart(context, out);
                JET2Writer _jettag_f_message_145_1_saved_out = out;
                while (_jettag_f_message_145_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_145_1.handleBodyContent(out);
                }
                out = _jettag_f_message_145_1_saved_out;
                _jettag_f_message_145_1.doEnd();
                out.write(NL);         
                out.write("\tprotected void configureStatusPanel() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tRootLayout.instance().statusPanel.add(new StatusPanel());");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_149_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_149_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_149_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_149_1.setTagInfo(_td_f_message_149_1);
                _jettag_f_message_149_1.doStart(context, out);
                JET2Writer _jettag_f_message_149_1_saved_out = out;
                while (_jettag_f_message_149_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_149_1.handleBodyContent(out);
                }
                out = _jettag_f_message_149_1_saved_out;
                _jettag_f_message_149_1.doEnd();
                out.write(NL);         
                out.write("\tprotected void configureSideBar() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_153_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_153_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_153_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_153_1.setTagInfo(_td_f_message_153_1);
                _jettag_f_message_153_1.doStart(context, out);
                JET2Writer _jettag_f_message_153_1_saved_out = out;
                while (_jettag_f_message_153_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_153_1.handleBodyContent(out);
                }
                out = _jettag_f_message_153_1_saved_out;
                _jettag_f_message_153_1.doEnd();
                out.write(NL);         
                out.write("\tprotected void configureSideBarTop() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_157_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_157_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_157_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_157_1.setTagInfo(_td_f_message_157_1);
                _jettag_f_message_157_1.doStart(context, out);
                JET2Writer _jettag_f_message_157_1_saved_out = out;
                while (_jettag_f_message_157_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_157_1.handleBodyContent(out);
                }
                out = _jettag_f_message_157_1_saved_out;
                _jettag_f_message_157_1.doEnd();
                out.write(NL);         
                out.write("\tprotected void configureSideBarBottom() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_c_iterate_161_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_161_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_161_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_161_2.setTagInfo(_td_c_iterate_161_2);
                _jettag_c_iterate_161_2.doStart(context, out);
                while (_jettag_c_iterate_161_2.okToProcessBody()) {
                    // iterate through class and add only non composite children and non parent
                    RuntimeTagElement _jettag_c_iterate_163_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_163_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_163_5.setRuntimeParent(_jettag_c_iterate_161_2);
                    _jettag_c_iterate_163_5.setTagInfo(_td_c_iterate_163_5);
                    _jettag_c_iterate_163_5.doStart(context, out);
                    while (_jettag_c_iterate_163_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_if_164_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_164_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_164_6.setRuntimeParent(_jettag_c_iterate_163_5);
                        _jettag_c_if_164_6.setTagInfo(_td_c_if_164_6);
                        _jettag_c_if_164_6.doStart(context, out);
                        while (_jettag_c_if_164_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_f_message_165_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_165_1); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_f_message_165_1.setRuntimeParent(_jettag_c_if_164_6);
                            _jettag_f_message_165_1.setTagInfo(_td_f_message_165_1);
                            _jettag_f_message_165_1.doStart(context, out);
                            JET2Writer _jettag_f_message_165_1_saved_out = out;
                            while (_jettag_f_message_165_1.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("generated.comment");  //$NON-NLS-1$        
                                _jettag_f_message_165_1.handleBodyContent(out);
                            }
                            out = _jettag_f_message_165_1_saved_out;
                            _jettag_f_message_165_1.doEnd();
                            out.write("\t\t\t \t");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("    \t\t\tCommand ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 166, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("Cmd= new Command() {");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write(NL);         
                            out.write("\t\t\t\t@Override");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\tpublic void execute() {");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\tgetEntityPanel().clear();");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\tgetEntityPanel().add(new ReadAll");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$class/@name}", 171, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("sPanely(ReadAllTableType.READALL));");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\tgetSidePanelTop().clear();");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\tgetSidePanelTop().add(new ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$class/@name}", 173, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("SideBar());");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t}");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write(NL);         
                            out.write("\t\t\t};");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_if_164_6.handleBodyContent(out);
                        }
                        _jettag_c_if_164_6.doEnd();
                        _jettag_c_iterate_163_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_163_5.doEnd();
                    _jettag_c_iterate_161_2.handleBodyContent(out);
                }
                _jettag_c_iterate_161_2.doEnd();
                RuntimeTagElement _jettag_f_message_180_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_180_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_180_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_180_1.setTagInfo(_td_f_message_180_1);
                _jettag_f_message_180_1.doStart(context, out);
                JET2Writer _jettag_f_message_180_1_saved_out = out;
                while (_jettag_f_message_180_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_180_1.handleBodyContent(out);
                }
                out = _jettag_f_message_180_1_saved_out;
                _jettag_f_message_180_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t//USERS ADMIN\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tCommand userCmd = new Command() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tpublic void execute() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tnew SecurityWelcome(CMD_TYPE.USER,getEntityPanel(), getSidePanelTop(),");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\tgetSidePanelBottom());");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t};");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
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
                out.write("\t// ROLES ADMIN");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tCommand roleCmd = new Command() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tpublic void execute() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tnew SecurityWelcome(CMD_TYPE.ROLE, getEntityPanel(),");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\tgetSidePanelTop(), getSidePanelBottom());");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t};");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("// TODO remove");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic FlowPanel getEntityPanel() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn RootLayout.instance().entityPanel;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t// TODO remove");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic FlowPanel getSidePanelTop() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn RootLayout.instance().sidePanelTop;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t// TODO remove");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic FlowPanel getSidePanelBottom() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn RootLayout.instance().sidePanelBottom;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}\t");  //$NON-NLS-1$        
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
    }
}
