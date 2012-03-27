package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_read_entity_controllerh implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$

    public _jet_read_entity_controllerh() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_c_replaceStrings_2_10 = new TagInfo("c:replaceStrings", //$NON-NLS-1$
            2, 10,
            new String[] {
                "replace", //$NON-NLS-1$
                "with", //$NON-NLS-1$
            },
            new String[] {
                ".", //$NON-NLS-1$
                "_", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_replaceStrings_6_2 = new TagInfo("c:replaceStrings", //$NON-NLS-1$
            6, 2,
            new String[] {
                "replace", //$NON-NLS-1$
                "with", //$NON-NLS-1$
            },
            new String[] {
                ".", //$NON-NLS-1$
                "_", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_12_2 = new TagInfo("c:if", //$NON-NLS-1$
            12, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_13_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            13, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_14_5 = new TagInfo("c:choose", //$NON-NLS-1$
            14, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_15_6 = new TagInfo("c:when", //$NON-NLS-1$
            15, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_17_6 = new TagInfo("c:when", //$NON-NLS-1$
            17, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_19_6 = new TagInfo("c:when", //$NON-NLS-1$
            19, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_21_6 = new TagInfo("c:when", //$NON-NLS-1$
            21, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_23_6 = new TagInfo("c:when", //$NON-NLS-1$
            23, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_25_6 = new TagInfo("c:when", //$NON-NLS-1$
            25, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_31_2 = new TagInfo("c:if", //$NON-NLS-1$
            31, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_32_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            32, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_33_5 = new TagInfo("c:choose", //$NON-NLS-1$
            33, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_34_6 = new TagInfo("c:when", //$NON-NLS-1$
            34, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_36_6 = new TagInfo("c:when", //$NON-NLS-1$
            36, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_38_6 = new TagInfo("c:when", //$NON-NLS-1$
            38, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_40_6 = new TagInfo("c:when", //$NON-NLS-1$
            40, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_42_6 = new TagInfo("c:when", //$NON-NLS-1$
            42, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_44_6 = new TagInfo("c:when", //$NON-NLS-1$
            44, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_50_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            50, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_51_5 = new TagInfo("c:choose", //$NON-NLS-1$
            51, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_52_6 = new TagInfo("c:when", //$NON-NLS-1$
            52, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_54_6 = new TagInfo("c:when", //$NON-NLS-1$
            54, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_56_6 = new TagInfo("c:when", //$NON-NLS-1$
            56, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_58_6 = new TagInfo("c:when", //$NON-NLS-1$
            58, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_60_6 = new TagInfo("c:when", //$NON-NLS-1$
            60, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_62_6 = new TagInfo("c:when", //$NON-NLS-1$
            62, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_replaceStrings_67_30 = new TagInfo("c:replaceStrings", //$NON-NLS-1$
            67, 30,
            new String[] {
                "replace", //$NON-NLS-1$
                "with", //$NON-NLS-1$
            },
            new String[] {
                ".", //$NON-NLS-1$
                "_", //$NON-NLS-1$
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("#import <UIKit/UIKit.h>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("#import \"");  //$NON-NLS-1$        
        RuntimeTagElement _jettag_c_replaceStrings_2_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "replaceStrings", "c:replaceStrings", _td_c_replaceStrings_2_10); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_replaceStrings_2_10.setRuntimeParent(null);
        _jettag_c_replaceStrings_2_10.setTagInfo(_td_c_replaceStrings_2_10);
        _jettag_c_replaceStrings_2_10.doStart(context, out);
        JET2Writer _jettag_c_replaceStrings_2_10_saved_out = out;
        while (_jettag_c_replaceStrings_2_10.okToProcessBody()) {
            out = out.newNestedContentWriter();
            out.write(context.embeddedExpressionAsString("${$groupID}", 2, 49)); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_replaceStrings_2_10.handleBodyContent(out);
        }
        out = _jettag_c_replaceStrings_2_10_saved_out;
        _jettag_c_replaceStrings_2_10.doEnd();
        out.write("_entity_");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 2, 87)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("_");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 2, 117)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".h\";");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("#import \"HttpUtils.h\";");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("@interface Read");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 5, 16)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("ViewController : UIViewController<UIActionSheetDelegate> {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        RuntimeTagElement _jettag_c_replaceStrings_6_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "replaceStrings", "c:replaceStrings", _td_c_replaceStrings_6_2); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_replaceStrings_6_2.setRuntimeParent(null);
        _jettag_c_replaceStrings_6_2.setTagInfo(_td_c_replaceStrings_6_2);
        _jettag_c_replaceStrings_6_2.doStart(context, out);
        JET2Writer _jettag_c_replaceStrings_6_2_saved_out = out;
        while (_jettag_c_replaceStrings_6_2.okToProcessBody()) {
            out = out.newNestedContentWriter();
            out.write(context.embeddedExpressionAsString("${$groupID}", 6, 41)); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_replaceStrings_6_2.handleBodyContent(out);
        }
        out = _jettag_c_replaceStrings_6_2_saved_out;
        _jettag_c_replaceStrings_6_2.doEnd();
        out.write("_entity_");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 6, 79)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("_");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 6, 109)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(" *");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 6, 126)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(";");  //$NON-NLS-1$        
        // processes the premitive Datatypes and enums
        out.write(NL);         
        out.write("\tUIView *read");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 7, 14)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("View;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tUIView *optionsBarView;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tUIButton *optionsButton;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tUIActionSheet *menu;");  //$NON-NLS-1$        
        out.write(NL);         
        // process parent class level 2 attributes
        RuntimeTagElement _jettag_c_if_12_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_12_2); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_12_2.setRuntimeParent(null);
        _jettag_c_if_12_2.setTagInfo(_td_c_if_12_2);
        _jettag_c_if_12_2.doStart(context, out);
        while (_jettag_c_if_12_2.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_13_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_13_3); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_13_3.setRuntimeParent(_jettag_c_if_12_2);
            _jettag_c_iterate_13_3.setTagInfo(_td_c_iterate_13_3);
            _jettag_c_iterate_13_3.doStart(context, out);
            while (_jettag_c_iterate_13_3.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_14_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_14_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_14_5.setRuntimeParent(_jettag_c_iterate_13_3);
                _jettag_c_choose_14_5.setTagInfo(_td_c_choose_14_5);
                _jettag_c_choose_14_5.doStart(context, out);
                JET2Writer _jettag_c_choose_14_5_saved_out = out;
                while (_jettag_c_choose_14_5.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_15_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_15_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_15_6.setRuntimeParent(_jettag_c_choose_14_5);
                    _jettag_c_when_15_6.setTagInfo(_td_c_when_15_6);
                    _jettag_c_when_15_6.doStart(context, out);
                    JET2Writer _jettag_c_when_15_6_saved_out = out;
                    while (_jettag_c_when_15_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" UITextField *");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 15, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF;");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_15_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_15_6_saved_out;
                    _jettag_c_when_15_6.doEnd();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_17_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_17_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_17_6.setRuntimeParent(_jettag_c_choose_14_5);
                    _jettag_c_when_17_6.setTagInfo(_td_c_when_17_6);
                    _jettag_c_when_17_6.doStart(context, out);
                    JET2Writer _jettag_c_when_17_6_saved_out = out;
                    while (_jettag_c_when_17_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" UITextField *");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 17, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF;");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_17_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_17_6_saved_out;
                    _jettag_c_when_17_6.doEnd();
                    RuntimeTagElement _jettag_c_when_19_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_19_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_19_6.setRuntimeParent(_jettag_c_choose_14_5);
                    _jettag_c_when_19_6.setTagInfo(_td_c_when_19_6);
                    _jettag_c_when_19_6.doStart(context, out);
                    JET2Writer _jettag_c_when_19_6_saved_out = out;
                    while (_jettag_c_when_19_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_19_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_19_6_saved_out;
                    _jettag_c_when_19_6.doEnd();
                    RuntimeTagElement _jettag_c_when_21_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_21_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_21_6.setRuntimeParent(_jettag_c_choose_14_5);
                    _jettag_c_when_21_6.setTagInfo(_td_c_when_21_6);
                    _jettag_c_when_21_6.doStart(context, out);
                    JET2Writer _jettag_c_when_21_6_saved_out = out;
                    while (_jettag_c_when_21_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_21_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_21_6_saved_out;
                    _jettag_c_when_21_6.doEnd();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_23_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_23_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_23_6.setRuntimeParent(_jettag_c_choose_14_5);
                    _jettag_c_when_23_6.setTagInfo(_td_c_when_23_6);
                    _jettag_c_when_23_6.doStart(context, out);
                    JET2Writer _jettag_c_when_23_6_saved_out = out;
                    while (_jettag_c_when_23_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("UITextField *");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 23, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF;");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_23_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_23_6_saved_out;
                    _jettag_c_when_23_6.doEnd();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_25_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_25_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_25_6.setRuntimeParent(_jettag_c_choose_14_5);
                    _jettag_c_when_25_6.setTagInfo(_td_c_when_25_6);
                    _jettag_c_when_25_6.doStart(context, out);
                    JET2Writer _jettag_c_when_25_6_saved_out = out;
                    while (_jettag_c_when_25_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("  UITextField *");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 25, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF;");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_25_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_25_6_saved_out;
                    _jettag_c_when_25_6.doEnd();
                    _jettag_c_choose_14_5.handleBodyContent(out);
                }
                out = _jettag_c_choose_14_5_saved_out;
                _jettag_c_choose_14_5.doEnd();
                _jettag_c_iterate_13_3.handleBodyContent(out);
            }
            _jettag_c_iterate_13_3.doEnd();
            _jettag_c_if_12_2.handleBodyContent(out);
        }
        _jettag_c_if_12_2.doEnd();
        // process parent class level 1 attributes
        RuntimeTagElement _jettag_c_if_31_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_31_2); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_31_2.setRuntimeParent(null);
        _jettag_c_if_31_2.setTagInfo(_td_c_if_31_2);
        _jettag_c_if_31_2.doStart(context, out);
        while (_jettag_c_if_31_2.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_32_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_32_3); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_32_3.setRuntimeParent(_jettag_c_if_31_2);
            _jettag_c_iterate_32_3.setTagInfo(_td_c_iterate_32_3);
            _jettag_c_iterate_32_3.doStart(context, out);
            while (_jettag_c_iterate_32_3.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_33_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_33_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_33_5.setRuntimeParent(_jettag_c_iterate_32_3);
                _jettag_c_choose_33_5.setTagInfo(_td_c_choose_33_5);
                _jettag_c_choose_33_5.doStart(context, out);
                JET2Writer _jettag_c_choose_33_5_saved_out = out;
                while (_jettag_c_choose_33_5.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_34_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_34_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_34_6.setRuntimeParent(_jettag_c_choose_33_5);
                    _jettag_c_when_34_6.setTagInfo(_td_c_when_34_6);
                    _jettag_c_when_34_6.doStart(context, out);
                    JET2Writer _jettag_c_when_34_6_saved_out = out;
                    while (_jettag_c_when_34_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" UITextField *");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 34, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF;");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_34_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_34_6_saved_out;
                    _jettag_c_when_34_6.doEnd();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_36_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_36_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_36_6.setRuntimeParent(_jettag_c_choose_33_5);
                    _jettag_c_when_36_6.setTagInfo(_td_c_when_36_6);
                    _jettag_c_when_36_6.doStart(context, out);
                    JET2Writer _jettag_c_when_36_6_saved_out = out;
                    while (_jettag_c_when_36_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" UITextField *");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 36, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF;");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_36_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_36_6_saved_out;
                    _jettag_c_when_36_6.doEnd();
                    RuntimeTagElement _jettag_c_when_38_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_38_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_38_6.setRuntimeParent(_jettag_c_choose_33_5);
                    _jettag_c_when_38_6.setTagInfo(_td_c_when_38_6);
                    _jettag_c_when_38_6.doStart(context, out);
                    JET2Writer _jettag_c_when_38_6_saved_out = out;
                    while (_jettag_c_when_38_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_38_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_38_6_saved_out;
                    _jettag_c_when_38_6.doEnd();
                    RuntimeTagElement _jettag_c_when_40_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_40_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_40_6.setRuntimeParent(_jettag_c_choose_33_5);
                    _jettag_c_when_40_6.setTagInfo(_td_c_when_40_6);
                    _jettag_c_when_40_6.doStart(context, out);
                    JET2Writer _jettag_c_when_40_6_saved_out = out;
                    while (_jettag_c_when_40_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_40_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_40_6_saved_out;
                    _jettag_c_when_40_6.doEnd();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_42_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_42_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_42_6.setRuntimeParent(_jettag_c_choose_33_5);
                    _jettag_c_when_42_6.setTagInfo(_td_c_when_42_6);
                    _jettag_c_when_42_6.doStart(context, out);
                    JET2Writer _jettag_c_when_42_6_saved_out = out;
                    while (_jettag_c_when_42_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("UITextField *");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 42, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF;");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_42_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_42_6_saved_out;
                    _jettag_c_when_42_6.doEnd();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_44_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_44_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_44_6.setRuntimeParent(_jettag_c_choose_33_5);
                    _jettag_c_when_44_6.setTagInfo(_td_c_when_44_6);
                    _jettag_c_when_44_6.doStart(context, out);
                    JET2Writer _jettag_c_when_44_6_saved_out = out;
                    while (_jettag_c_when_44_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("  UITextField *");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 44, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF;");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_44_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_44_6_saved_out;
                    _jettag_c_when_44_6.doEnd();
                    _jettag_c_choose_33_5.handleBodyContent(out);
                }
                out = _jettag_c_choose_33_5_saved_out;
                _jettag_c_choose_33_5.doEnd();
                _jettag_c_iterate_32_3.handleBodyContent(out);
            }
            _jettag_c_iterate_32_3.doEnd();
            _jettag_c_if_31_2.handleBodyContent(out);
        }
        _jettag_c_if_31_2.doEnd();
        // process parent class level 0 attributes
        RuntimeTagElement _jettag_c_iterate_50_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_50_2); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_50_2.setRuntimeParent(null);
        _jettag_c_iterate_50_2.setTagInfo(_td_c_iterate_50_2);
        _jettag_c_iterate_50_2.doStart(context, out);
        while (_jettag_c_iterate_50_2.okToProcessBody()) {
            RuntimeTagElement _jettag_c_choose_51_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_51_5); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_choose_51_5.setRuntimeParent(_jettag_c_iterate_50_2);
            _jettag_c_choose_51_5.setTagInfo(_td_c_choose_51_5);
            _jettag_c_choose_51_5.doStart(context, out);
            JET2Writer _jettag_c_choose_51_5_saved_out = out;
            while (_jettag_c_choose_51_5.okToProcessBody()) {
                out = out.newNestedContentWriter();
                out.write("\t\t\t\t ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_c_when_52_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_52_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_52_6.setRuntimeParent(_jettag_c_choose_51_5);
                _jettag_c_when_52_6.setTagInfo(_td_c_when_52_6);
                _jettag_c_when_52_6.doStart(context, out);
                JET2Writer _jettag_c_when_52_6_saved_out = out;
                while (_jettag_c_when_52_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write(" UITextField *");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 52, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF;");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_52_6.handleBodyContent(out);
                }
                out = _jettag_c_when_52_6_saved_out;
                _jettag_c_when_52_6.doEnd();
                out.write("\t\t\t\t ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_c_when_54_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_54_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_54_6.setRuntimeParent(_jettag_c_choose_51_5);
                _jettag_c_when_54_6.setTagInfo(_td_c_when_54_6);
                _jettag_c_when_54_6.doStart(context, out);
                JET2Writer _jettag_c_when_54_6_saved_out = out;
                while (_jettag_c_when_54_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write(" UITextField *");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 54, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF;");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_54_6.handleBodyContent(out);
                }
                out = _jettag_c_when_54_6_saved_out;
                _jettag_c_when_54_6.doEnd();
                RuntimeTagElement _jettag_c_when_56_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_56_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_56_6.setRuntimeParent(_jettag_c_choose_51_5);
                _jettag_c_when_56_6.setTagInfo(_td_c_when_56_6);
                _jettag_c_when_56_6.doStart(context, out);
                JET2Writer _jettag_c_when_56_6_saved_out = out;
                while (_jettag_c_when_56_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    _jettag_c_when_56_6.handleBodyContent(out);
                }
                out = _jettag_c_when_56_6_saved_out;
                _jettag_c_when_56_6.doEnd();
                RuntimeTagElement _jettag_c_when_58_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_58_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_58_6.setRuntimeParent(_jettag_c_choose_51_5);
                _jettag_c_when_58_6.setTagInfo(_td_c_when_58_6);
                _jettag_c_when_58_6.doStart(context, out);
                JET2Writer _jettag_c_when_58_6_saved_out = out;
                while (_jettag_c_when_58_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    _jettag_c_when_58_6.handleBodyContent(out);
                }
                out = _jettag_c_when_58_6_saved_out;
                _jettag_c_when_58_6.doEnd();
                out.write("\t\t\t\t ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_c_when_60_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_60_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_60_6.setRuntimeParent(_jettag_c_choose_51_5);
                _jettag_c_when_60_6.setTagInfo(_td_c_when_60_6);
                _jettag_c_when_60_6.doStart(context, out);
                JET2Writer _jettag_c_when_60_6_saved_out = out;
                while (_jettag_c_when_60_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("UITextField *");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 60, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF;");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_60_6.handleBodyContent(out);
                }
                out = _jettag_c_when_60_6_saved_out;
                _jettag_c_when_60_6.doEnd();
                out.write("\t\t\t\t ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_c_when_62_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_62_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_62_6.setRuntimeParent(_jettag_c_choose_51_5);
                _jettag_c_when_62_6.setTagInfo(_td_c_when_62_6);
                _jettag_c_when_62_6.doStart(context, out);
                JET2Writer _jettag_c_when_62_6_saved_out = out;
                while (_jettag_c_when_62_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("  UITextField *");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 62, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF;");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_62_6.handleBodyContent(out);
                }
                out = _jettag_c_when_62_6_saved_out;
                _jettag_c_when_62_6.doEnd();
                _jettag_c_choose_51_5.handleBodyContent(out);
            }
            out = _jettag_c_choose_51_5_saved_out;
            _jettag_c_choose_51_5.doEnd();
            _jettag_c_iterate_50_2.handleBodyContent(out);
        }
        _jettag_c_iterate_50_2.doEnd();
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("@property (nonatomic,retain)\t");  //$NON-NLS-1$        
        RuntimeTagElement _jettag_c_replaceStrings_67_30 = context.getTagFactory().createRuntimeTag(_jetns_c, "replaceStrings", "c:replaceStrings", _td_c_replaceStrings_67_30); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_replaceStrings_67_30.setRuntimeParent(null);
        _jettag_c_replaceStrings_67_30.setTagInfo(_td_c_replaceStrings_67_30);
        _jettag_c_replaceStrings_67_30.doStart(context, out);
        JET2Writer _jettag_c_replaceStrings_67_30_saved_out = out;
        while (_jettag_c_replaceStrings_67_30.okToProcessBody()) {
            out = out.newNestedContentWriter();
            out.write(context.embeddedExpressionAsString("${$groupID}", 67, 69)); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_replaceStrings_67_30.handleBodyContent(out);
        }
        out = _jettag_c_replaceStrings_67_30_saved_out;
        _jettag_c_replaceStrings_67_30.doEnd();
        out.write("_entity_");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 67, 107)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("_");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 67, 137)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(" *");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 67, 154)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(";");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (void) configureOptionsView;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (void) optionsClicked: (id) sender;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (NSString*) getReadURLWithID: (int) key;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("@end");  //$NON-NLS-1$        
        out.write(NL);         
    }
}
