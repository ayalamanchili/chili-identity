package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_web_side_panel_templatejava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_web_side_panel_templatejava() {
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
    private static final TagInfo _td_c_if_6_1 = new TagInfo("c:if", //$NON-NLS-1$
            6, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$enableHibernateSearch = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_26_1 = new TagInfo("f:message", //$NON-NLS-1$
            26, 1,
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
    private static final TagInfo _td_f_message_30_1 = new TagInfo("f:message", //$NON-NLS-1$
            30, 1,
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
    private static final TagInfo _td_c_if_36_1 = new TagInfo("c:if", //$NON-NLS-1$
            36, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$enableHibernateSearch = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_37_1 = new TagInfo("f:message", //$NON-NLS-1$
            37, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_40_1 = new TagInfo("f:message", //$NON-NLS-1$
            40, 1,
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
    private static final TagInfo _td_f_message_54_1 = new TagInfo("f:message", //$NON-NLS-1$
            54, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_59_1 = new TagInfo("f:message", //$NON-NLS-1$
            59, 1,
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
    private static final TagInfo _td_f_message_70_1 = new TagInfo("f:message", //$NON-NLS-1$
            70, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_76_1 = new TagInfo("c:if", //$NON-NLS-1$
            76, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$enableHibernateSearch = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_93_1 = new TagInfo("f:message", //$NON-NLS-1$
            93, 1,
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
    private static final TagInfo _td_f_message_103_1 = new TagInfo("f:message", //$NON-NLS-1$
            103, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_108_1 = new TagInfo("f:message", //$NON-NLS-1$
            108, 1,
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
                RuntimeTagElement _jettag_c_if_6_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_6_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_6_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_6_1.setTagInfo(_td_c_if_6_1);
                _jettag_c_if_6_1.doStart(context, out);
                while (_jettag_c_if_6_1.okToProcessBody()) {
                    out.write("import info.yalamanchili.gwt.widgets.FindWidget;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("import ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$groupID}", 8, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".entity.");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 8, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 8, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(";");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("import info.yalamanchili.gwt.callback.ALAsyncCallback;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("import java.util.List;");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_6_1.handleBodyContent(out);
                }
                _jettag_c_if_6_1.doEnd();
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$webPackage}", 13, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 13, 22)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$webPackage}", 14, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Roles;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.ReadAllCompositey.ReadAllTableType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.SideBarComposite;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.widgets.ClickableLink;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import com.google.gwt.event.dom.client.ClickEvent;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.event.logical.shared.CloseEvent;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.event.logical.shared.OpenEvent;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.ui.DisclosurePanel;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.ui.LazyPanel;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.ui.Widget;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.CreateCompositey.CreateCompositeType;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_26_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_26_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_26_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_26_1.setTagInfo(_td_f_message_26_1);
                _jettag_f_message_26_1.doStart(context, out);
                JET2Writer _jettag_f_message_26_1_saved_out = out;
                while (_jettag_f_message_26_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_26_1.handleBodyContent(out);
                }
                out = _jettag_f_message_26_1_saved_out;
                _jettag_f_message_26_1.doEnd();
                out.write(NL);         
                out.write("public class ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 27, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("SideBar extends SideBarComposite {");  //$NON-NLS-1$        
                out.write(NL);         
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
                out.write("\tprivate static ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 29, 17)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("SideBar ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 29, 40)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("SideBar;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_30_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_30_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_30_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_30_1.setTagInfo(_td_f_message_30_1);
                _jettag_f_message_30_1.doStart(context, out);
                JET2Writer _jettag_f_message_30_1_saved_out = out;
                while (_jettag_f_message_30_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_30_1.handleBodyContent(out);
                }
                out = _jettag_f_message_30_1_saved_out;
                _jettag_f_message_30_1.doEnd();
                out.write(NL);         
                out.write("\tpublic static ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 31, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("SideBar instance() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 32, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("SideBar;");  //$NON-NLS-1$        
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
                out.write(NL);         
                out.write("\tClickableLink createLink = new ClickableLink(\"Create ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 35, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("\");");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_c_if_36_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_36_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_36_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_36_1.setTagInfo(_td_c_if_36_1);
                _jettag_c_if_36_1.doStart(context, out);
                while (_jettag_c_if_36_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_f_message_37_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_37_1); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_f_message_37_1.setRuntimeParent(_jettag_c_if_36_1);
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
                    out.write("\tFindWidget findWidget = new FindWidget(this);");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_36_1.handleBodyContent(out);
                }
                _jettag_c_if_36_1.doEnd();
                RuntimeTagElement _jettag_f_message_40_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_40_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_40_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_40_1.setTagInfo(_td_f_message_40_1);
                _jettag_f_message_40_1.doStart(context, out);
                JET2Writer _jettag_f_message_40_1_saved_out = out;
                while (_jettag_f_message_40_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_40_1.handleBodyContent(out);
                }
                out = _jettag_f_message_40_1_saved_out;
                _jettag_f_message_40_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprivate static class ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 41, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("LazySearchPanel extends LazyPanel {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tprotected Widget createWidget() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\treturn new ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 44, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("SearchPanelGeneric();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
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
                out.write("\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 48, 2)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("LazySearchPanel ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 48, 33)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("LazySearchPanel = new ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 48, 82)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("LazySearchPanel();");  //$NON-NLS-1$        
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
                out.write("\tpublic ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 50, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("SideBar() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 51, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("SideBar = this;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinitSideBarComposite();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_54_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_54_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_54_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_54_1.setTagInfo(_td_f_message_54_1);
                _jettag_f_message_54_1.doStart(context, out);
                JET2Writer _jettag_f_message_54_1_saved_out = out;
                while (_jettag_f_message_54_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_54_1.handleBodyContent(out);
                }
                out = _jettag_f_message_54_1_saved_out;
                _jettag_f_message_54_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void addListeners() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tcreateLink.addClickHandler(this);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_59_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_59_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_59_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_59_1.setTagInfo(_td_f_message_59_1);
                _jettag_f_message_59_1.doStart(context, out);
                JET2Writer _jettag_f_message_59_1_saved_out = out;
                while (_jettag_f_message_59_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_59_1.handleBodyContent(out);
                }
                out = _jettag_f_message_59_1_saved_out;
                _jettag_f_message_59_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void configure() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tpanel.addStyleName(\"");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 62, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("SidePanel\");");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
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
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void addWidgets() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tpanel.add(createLink);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tpanel.add(findWidget);\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_70_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_70_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_70_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_70_1.setTagInfo(_td_f_message_70_1);
                _jettag_f_message_70_1.doStart(context, out);
                JET2Writer _jettag_f_message_70_1_saved_out = out;
                while (_jettag_f_message_70_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_70_1.handleBodyContent(out);
                }
                out = _jettag_f_message_70_1_saved_out;
                _jettag_f_message_70_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void onClick(ClickEvent event) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tif (event.getSource() == createLink) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tcreateLinkClicked();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_c_if_76_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_76_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_76_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_76_1.setTagInfo(_td_c_if_76_1);
                _jettag_c_if_76_1.doStart(context, out);
                while (_jettag_c_if_76_1.okToProcessBody()) {
                    out.write("\t\tif (event.getSource() == findWidget.getFindButton()) {");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$packageName}", 78, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 78, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 78, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("Service.");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 78, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("ServiceAsync.instance().search(findWidget.getSearchText(),");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t\t\tnew ALAsyncCallback<List<");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 79, 33)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(">>() {");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t\t\t\t@Override");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t\t\t\tpublic void onResponse(List<");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 81, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("> arg0) {");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t\t\t\t//");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 82, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("Welcome.instance().getEntityPanel().clear();");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t\t\t\t\t//");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 83, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("Welcome.instance().getEntityPanel()");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t\t\t\t\t\t//\t.add((new ReadAll");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 84, 31)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("sPanel(arg0)));");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write(NL);         
                    out.write("\t\t\t\t\t\t\t});");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t}\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_76_1.handleBodyContent(out);
                }
                _jettag_c_if_76_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_93_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_93_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_93_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_93_1.setTagInfo(_td_f_message_93_1);
                _jettag_f_message_93_1.doStart(context, out);
                JET2Writer _jettag_f_message_93_1_saved_out = out;
                while (_jettag_f_message_93_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_93_1.handleBodyContent(out);
                }
                out = _jettag_f_message_93_1_saved_out;
                _jettag_f_message_93_1.doEnd();
                out.write(NL);         
                out.write("\tprotected void createLinkClicked() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 95, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().getEntityPanel().clear();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 96, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().getEntityPanel().add(");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tnew Create");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 97, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely(CreateCompositeType.CREATE));");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
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
                out.write(NL);         
                out.write("\tprotected void reload");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 100, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_103_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_103_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_103_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_103_1.setTagInfo(_td_f_message_103_1);
                _jettag_f_message_103_1.doStart(context, out);
                JET2Writer _jettag_f_message_103_1_saved_out = out;
                while (_jettag_f_message_103_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_103_1.handleBodyContent(out);
                }
                out = _jettag_f_message_103_1_saved_out;
                _jettag_f_message_103_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void onSearchClose(CloseEvent<DisclosurePanel> arg0) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tsearchPanel.remove(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 106, 22)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("LazySearchPanel);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_108_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_108_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_108_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_108_1.setTagInfo(_td_f_message_108_1);
                _jettag_f_message_108_1.doStart(context, out);
                JET2Writer _jettag_f_message_108_1_saved_out = out;
                while (_jettag_f_message_108_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_108_1.handleBodyContent(out);
                }
                out = _jettag_f_message_108_1_saved_out;
                _jettag_f_message_108_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void onSearchOpen(OpenEvent<DisclosurePanel> arg0) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tsearchPanel.add(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 111, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("LazySearchPanel);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 112, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("LazySearchPanel.setVisible(true);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
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
