package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_root_layoutjava implements JET2Template {
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_root_layoutjava() {
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
    private static final TagInfo _td_f_message_16_1 = new TagInfo("f:message", //$NON-NLS-1$
            16, 1,
            new String[] {
            },
            new String[] {
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
    private static final TagInfo _td_f_message_24_1 = new TagInfo("f:message", //$NON-NLS-1$
            24, 1,
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
    private static final TagInfo _td_f_message_30_1 = new TagInfo("f:message", //$NON-NLS-1$
            30, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_33_1 = new TagInfo("f:message", //$NON-NLS-1$
            33, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_36_1 = new TagInfo("f:message", //$NON-NLS-1$
            36, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_39_1 = new TagInfo("f:message", //$NON-NLS-1$
            39, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_42_1 = new TagInfo("f:message", //$NON-NLS-1$
            42, 1,
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
    private static final TagInfo _td_f_message_48_1 = new TagInfo("f:message", //$NON-NLS-1$
            48, 1,
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
    private static final TagInfo _td_f_message_54_1 = new TagInfo("f:message", //$NON-NLS-1$
            54, 1,
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
                out.write(context.embeddedExpressionAsString("${$groupID}", 5, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".client;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import com.google.gwt.core.client.GWT;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.uibinder.client.UiBinder;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.uibinder.client.UiField;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.ui.Composite;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.ui.FlowPanel;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.ui.HorizontalPanel;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.ui.ScrollPanel;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.ui.Widget;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("/** this class holds the App rootlayout structure*/");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_16_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_16_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_16_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_16_1.setTagInfo(_td_f_message_16_1);
                _jettag_f_message_16_1.doStart(context, out);
                JET2Writer _jettag_f_message_16_1_saved_out = out;
                while (_jettag_f_message_16_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_16_1.handleBodyContent(out);
                }
                out = _jettag_f_message_16_1_saved_out;
                _jettag_f_message_16_1.doEnd();
                out.write(NL);         
                out.write("public class RootLayout extends Composite {");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_18_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_18_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_18_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_18_1.setTagInfo(_td_f_message_18_1);
                _jettag_f_message_18_1.doStart(context, out);
                JET2Writer _jettag_f_message_18_1_saved_out = out;
                while (_jettag_f_message_18_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_18_1.handleBodyContent(out);
                }
                out = _jettag_f_message_18_1_saved_out;
                _jettag_f_message_18_1.doEnd();
                out.write(NL);         
                out.write("\tprivate static RootLayout instance;");  //$NON-NLS-1$        
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
                out.write("\tpublic static RootLayout instance() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn instance;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
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
                out.write("\tinterface RootLayoutUiBinder extends UiBinder<Widget, RootLayout> {");  //$NON-NLS-1$        
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
                out.write("\tprivate static RootLayoutUiBinder rootLayoutUIBinder = GWT");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t.create(RootLayoutUiBinder.class);");  //$NON-NLS-1$        
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
                out.write("\t\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@UiField");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic FlowPanel statusPanel;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_33_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_33_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_33_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_33_1.setTagInfo(_td_f_message_33_1);
                _jettag_f_message_33_1.doStart(context, out);
                JET2Writer _jettag_f_message_33_1_saved_out = out;
                while (_jettag_f_message_33_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_33_1.handleBodyContent(out);
                }
                out = _jettag_f_message_33_1_saved_out;
                _jettag_f_message_33_1.doEnd();
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@UiField");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic StatusPanel ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 35, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("StatusPanel;\t");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_36_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_36_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_36_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_36_1.setTagInfo(_td_f_message_36_1);
                _jettag_f_message_36_1.doStart(context, out);
                JET2Writer _jettag_f_message_36_1_saved_out = out;
                while (_jettag_f_message_36_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_36_1.handleBodyContent(out);
                }
                out = _jettag_f_message_36_1_saved_out;
                _jettag_f_message_36_1.doEnd();
                out.write(NL);         
                out.write("\t@UiField");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic HorizontalPanel menuBar;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_39_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_39_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_39_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_39_1.setTagInfo(_td_f_message_39_1);
                _jettag_f_message_39_1.doStart(context, out);
                JET2Writer _jettag_f_message_39_1_saved_out = out;
                while (_jettag_f_message_39_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_39_1.handleBodyContent(out);
                }
                out = _jettag_f_message_39_1_saved_out;
                _jettag_f_message_39_1.doEnd();
                out.write(NL);         
                out.write("\t@UiField");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic FlowPanel sidePanel;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_42_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_42_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_42_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_42_1.setTagInfo(_td_f_message_42_1);
                _jettag_f_message_42_1.doStart(context, out);
                JET2Writer _jettag_f_message_42_1_saved_out = out;
                while (_jettag_f_message_42_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_42_1.handleBodyContent(out);
                }
                out = _jettag_f_message_42_1_saved_out;
                _jettag_f_message_42_1.doEnd();
                out.write(NL);         
                out.write("\t@UiField");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic FlowPanel sidePanelTop;");  //$NON-NLS-1$        
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
                out.write("\t@UiField");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic FlowPanel sidePanelBottom;");  //$NON-NLS-1$        
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
                out.write("\t@UiField");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic ScrollPanel entityPanelHolder;");  //$NON-NLS-1$        
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
                out.write("\t@UiField");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic FlowPanel entityPanel;");  //$NON-NLS-1$        
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
                out.write("\tpublic RootLayout() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinitWidget(rootLayoutUIBinder.createAndBindUi(this));");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinstance = this;");  //$NON-NLS-1$        
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
    }
}
