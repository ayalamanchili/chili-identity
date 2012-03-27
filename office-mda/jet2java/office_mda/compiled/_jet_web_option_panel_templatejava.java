package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_web_option_panel_templatejava implements JET2Template {
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_web_option_panel_templatejava() {
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
    private static final TagInfo _td_f_message_15_1 = new TagInfo("f:message", //$NON-NLS-1$
            15, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_17_1 = new TagInfo("f:message", //$NON-NLS-1$
            17, 1,
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
    private static final TagInfo _td_f_message_25_1 = new TagInfo("f:message", //$NON-NLS-1$
            25, 1,
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
    private static final TagInfo _td_f_message_37_1 = new TagInfo("f:message", //$NON-NLS-1$
            37, 1,
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
    private static final TagInfo _td_f_message_48_1 = new TagInfo("f:message", //$NON-NLS-1$
            48, 1,
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
    private static final TagInfo _td_f_message_62_1 = new TagInfo("f:message", //$NON-NLS-1$
            62, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_68_1 = new TagInfo("f:message", //$NON-NLS-1$
            68, 1,
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
                out.write("import info.yalamanchili.gwt.widgets.ResponseStatusWidget;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.callback.ALAsyncCallback;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.OptionsComposite;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.utils.Alignment;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.CreateCompositey.CreateCompositeType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_15_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_15_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_15_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_15_1.setTagInfo(_td_f_message_15_1);
                _jettag_f_message_15_1.doStart(context, out);
                JET2Writer _jettag_f_message_15_1_saved_out = out;
                while (_jettag_f_message_15_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_15_1.handleBodyContent(out);
                }
                out = _jettag_f_message_15_1_saved_out;
                _jettag_f_message_15_1.doEnd();
                out.write(NL);         
                out.write("public class ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 16, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("OptionsPanel extends OptionsComposite {");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_17_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_17_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_17_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_17_1.setTagInfo(_td_f_message_17_1);
                _jettag_f_message_17_1.doStart(context, out);
                JET2Writer _jettag_f_message_17_1_saved_out = out;
                while (_jettag_f_message_17_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_17_1.handleBodyContent(out);
                }
                out = _jettag_f_message_17_1_saved_out;
                _jettag_f_message_17_1.doEnd();
                out.write(NL);         
                out.write("\tpublic ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 18, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("OptionsPanel(OptionsCompositeType type) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tsuper(type);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
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
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 22, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("OptionsPanel(Alignment alignment,OptionsCompositeType type) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tsuper(alignment,type);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_25_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_25_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_25_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_25_1.setTagInfo(_td_f_message_25_1);
                _jettag_f_message_25_1.doStart(context, out);
                JET2Writer _jettag_f_message_25_1_saved_out = out;
                while (_jettag_f_message_25_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_25_1.handleBodyContent(out);
                }
                out = _jettag_f_message_25_1_saved_out;
                _jettag_f_message_25_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void deleteLinkClicked() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("//TODO delete");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
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
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void updateLinkClicked() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 33, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().getEntityPanel().clear();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 34, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().getEntityPanel().add(");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tnew Update");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 35, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely());");  //$NON-NLS-1$        
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
                out.write("\tprotected void addListeners() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t// TODO Auto-generated method stub");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
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
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void addWidgets() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_48_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_48_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_48_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_48_1.setTagInfo(_td_f_message_48_1);
                _jettag_f_message_48_1.doStart(context, out);
                JET2Writer _jettag_f_message_48_1_saved_out = out;
                while (_jettag_f_message_48_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_48_1.handleBodyContent(out);
                }
                out = _jettag_f_message_48_1_saved_out;
                _jettag_f_message_48_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void configure() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tpanel.setSpacing(5);");  //$NON-NLS-1$        
                out.write(NL);         
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
                out.write("\tpublic void createLinkClicked() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 57, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().getEntityPanel().clear();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 58, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().getEntityPanel().add(");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tnew Create");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 59, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely(CreateCompositeType.CREATE));");  //$NON-NLS-1$        
                out.write(NL);         
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
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void addLinkClicked() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 65, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().getEntityPanel().add(");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tnew Create");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 66, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely(CreateCompositeType.ADD));");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_68_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_68_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_68_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_68_1.setTagInfo(_td_f_message_68_1);
                _jettag_f_message_68_1.doStart(context, out);
                JET2Writer _jettag_f_message_68_1_saved_out = out;
                while (_jettag_f_message_68_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_68_1.handleBodyContent(out);
                }
                out = _jettag_f_message_68_1_saved_out;
                _jettag_f_message_68_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic  void addAllLinkClicked(){");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t//use selectcomposite with multiselect box");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
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
