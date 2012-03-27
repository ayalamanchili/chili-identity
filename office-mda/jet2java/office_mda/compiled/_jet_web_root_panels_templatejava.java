package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_web_root_panels_templatejava implements JET2Template {
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_web_root_panels_templatejava() {
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
    private static final TagInfo _td_f_message_10_1 = new TagInfo("f:message", //$NON-NLS-1$
            10, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_12_1 = new TagInfo("f:message", //$NON-NLS-1$
            12, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_14_1 = new TagInfo("f:message", //$NON-NLS-1$
            14, 1,
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
    private static final TagInfo _td_f_message_31_1 = new TagInfo("f:message", //$NON-NLS-1$
            31, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_35_1 = new TagInfo("f:message", //$NON-NLS-1$
            35, 1,
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
    private static final TagInfo _td_f_message_43_1 = new TagInfo("f:message", //$NON-NLS-1$
            43, 1,
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
    private static final TagInfo _td_f_message_51_1 = new TagInfo("f:message", //$NON-NLS-1$
            51, 1,
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
    private static final TagInfo _td_f_message_59_1 = new TagInfo("f:message", //$NON-NLS-1$
            59, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_63_1 = new TagInfo("f:message", //$NON-NLS-1$
            63, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_67_1 = new TagInfo("f:message", //$NON-NLS-1$
            67, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_71_1 = new TagInfo("f:message", //$NON-NLS-1$
            71, 1,
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
                out.write("import com.google.gwt.user.client.ui.FlowPanel;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.ui.HorizontalPanel;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.ui.ScrollPanel;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_10_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_10_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_10_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_10_1.setTagInfo(_td_f_message_10_1);
                _jettag_f_message_10_1.doStart(context, out);
                JET2Writer _jettag_f_message_10_1_saved_out = out;
                while (_jettag_f_message_10_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_10_1.handleBodyContent(out);
                }
                out = _jettag_f_message_10_1_saved_out;
                _jettag_f_message_10_1.doEnd();
                out.write(NL);         
                out.write("public class RootPanels {");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_12_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_12_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_12_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_12_1.setTagInfo(_td_f_message_12_1);
                _jettag_f_message_12_1.doStart(context, out);
                JET2Writer _jettag_f_message_12_1_saved_out = out;
                while (_jettag_f_message_12_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_12_1.handleBodyContent(out);
                }
                out = _jettag_f_message_12_1_saved_out;
                _jettag_f_message_12_1.doEnd();
                out.write(NL);         
                out.write("\tprotected FlowPanel sidePanel = new FlowPanel();");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_14_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_14_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_14_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_14_1.setTagInfo(_td_f_message_14_1);
                _jettag_f_message_14_1.doStart(context, out);
                JET2Writer _jettag_f_message_14_1_saved_out = out;
                while (_jettag_f_message_14_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_14_1.handleBodyContent(out);
                }
                out = _jettag_f_message_14_1_saved_out;
                _jettag_f_message_14_1.doEnd();
                out.write(NL);         
                out.write("\tprotected FlowPanel sidePanelTop = new FlowPanel();");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_16_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_16_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_16_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_16_1.setTagInfo(_td_f_message_16_1);
                _jettag_f_message_16_1.doStart(context, out);
                JET2Writer _jettag_f_message_16_1_saved_out = out;
                while (_jettag_f_message_16_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_16_1.handleBodyContent(out);
                }
                out = _jettag_f_message_16_1_saved_out;
                _jettag_f_message_16_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected FlowPanel sidePanelBottom = new FlowPanel();");  //$NON-NLS-1$        
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
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected FlowPanel statusPanel = new FlowPanel();");  //$NON-NLS-1$        
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
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected HorizontalPanel menuBar = new HorizontalPanel();");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_22_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_22_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_22_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_22_1.setTagInfo(_td_f_message_22_1);
                _jettag_f_message_22_1.doStart(context, out);
                JET2Writer _jettag_f_message_22_1_saved_out = out;
                while (_jettag_f_message_22_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_22_1.handleBodyContent(out);
                }
                out = _jettag_f_message_22_1_saved_out;
                _jettag_f_message_22_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected FlowPanel entityPanel = new FlowPanel();");  //$NON-NLS-1$        
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
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t//this is a holder to fix issue with not able to add more than one widget to scroll panel");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_26_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_26_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_26_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_26_1.setTagInfo(_td_f_message_26_1);
                _jettag_f_message_26_1.doStart(context, out);
                JET2Writer _jettag_f_message_26_1_saved_out = out;
                while (_jettag_f_message_26_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_26_1.handleBodyContent(out);
                }
                out = _jettag_f_message_26_1_saved_out;
                _jettag_f_message_26_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected ScrollPanel entityPanelHolder = new ScrollPanel();");  //$NON-NLS-1$        
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
                out.write("\tpublic RootPanels() {");  //$NON-NLS-1$        
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
                out.write(NL);         
                out.write("\tpublic FlowPanel getSidePanel() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn sidePanel;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_35_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_35_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_35_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_35_1.setTagInfo(_td_f_message_35_1);
                _jettag_f_message_35_1.doStart(context, out);
                JET2Writer _jettag_f_message_35_1_saved_out = out;
                while (_jettag_f_message_35_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_35_1.handleBodyContent(out);
                }
                out = _jettag_f_message_35_1_saved_out;
                _jettag_f_message_35_1.doEnd();
                out.write(NL);         
                out.write("\tpublic void setSidePanel(FlowPanel sidePanel) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tthis.sidePanel = sidePanel;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
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
                out.write("\tpublic FlowPanel getSidePanelTop() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn sidePanelTop;");  //$NON-NLS-1$        
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
                out.write("\tpublic void setSidePanelTop(FlowPanel sidePanelTop) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tthis.sidePanelTop = sidePanelTop;");  //$NON-NLS-1$        
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
                out.write(NL);         
                out.write("\tpublic FlowPanel getSidePanelBottom() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn sidePanelBottom;");  //$NON-NLS-1$        
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
                out.write("\tpublic void setSidePanelBottom(FlowPanel sidePanelBottom) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tthis.sidePanelBottom = sidePanelBottom;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
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
                out.write(NL);         
                out.write("\tpublic FlowPanel getStatusPanel() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn statusPanel;");  //$NON-NLS-1$        
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
                out.write("\tpublic void setStatusPanel(FlowPanel statusPanel) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tthis.statusPanel = statusPanel;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_63_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_63_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_63_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_63_1.setTagInfo(_td_f_message_63_1);
                _jettag_f_message_63_1.doStart(context, out);
                JET2Writer _jettag_f_message_63_1_saved_out = out;
                while (_jettag_f_message_63_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_63_1.handleBodyContent(out);
                }
                out = _jettag_f_message_63_1_saved_out;
                _jettag_f_message_63_1.doEnd();
                out.write(NL);         
                out.write("\tpublic HorizontalPanel getMenuBar() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn menuBar;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_67_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_67_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_67_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_67_1.setTagInfo(_td_f_message_67_1);
                _jettag_f_message_67_1.doStart(context, out);
                JET2Writer _jettag_f_message_67_1_saved_out = out;
                while (_jettag_f_message_67_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_67_1.handleBodyContent(out);
                }
                out = _jettag_f_message_67_1_saved_out;
                _jettag_f_message_67_1.doEnd();
                out.write(NL);         
                out.write("\tpublic void setMenuBar(HorizontalPanel menuBar) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tthis.menuBar = menuBar;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_71_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_71_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_71_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_71_1.setTagInfo(_td_f_message_71_1);
                _jettag_f_message_71_1.doStart(context, out);
                JET2Writer _jettag_f_message_71_1_saved_out = out;
                while (_jettag_f_message_71_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_71_1.handleBodyContent(out);
                }
                out = _jettag_f_message_71_1_saved_out;
                _jettag_f_message_71_1.doEnd();
                out.write(NL);         
                out.write("\tpublic FlowPanel getEntityPanel() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn entityPanel;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
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
                out.write(NL);         
                out.write("\tpublic void setEntityPanel(FlowPanel entityPanel) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tthis.entityPanel = entityPanel;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("}");  //$NON-NLS-1$        
                out.write(NL);         
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
