package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_entity_readxml implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$

    public _jet_entity_readxml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_c_if_27_2 = new TagInfo("c:if", //$NON-NLS-1$
            27, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_28_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            28, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_29_6 = new TagInfo("c:choose", //$NON-NLS-1$
            29, 6,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_30_7 = new TagInfo("c:when", //$NON-NLS-1$
            30, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_38_7 = new TagInfo("c:when", //$NON-NLS-1$
            38, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_46_7 = new TagInfo("c:when", //$NON-NLS-1$
            46, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_54_7 = new TagInfo("c:when", //$NON-NLS-1$
            54, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_62_7 = new TagInfo("c:when", //$NON-NLS-1$
            62, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_70_7 = new TagInfo("c:when", //$NON-NLS-1$
            70, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_78_7 = new TagInfo("c:when", //$NON-NLS-1$
            78, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_86_8 = new TagInfo("c:otherwise", //$NON-NLS-1$
            86, 8,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_92_2 = new TagInfo("c:if", //$NON-NLS-1$
            92, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_93_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            93, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_94_6 = new TagInfo("c:choose", //$NON-NLS-1$
            94, 6,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_95_7 = new TagInfo("c:when", //$NON-NLS-1$
            95, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_103_7 = new TagInfo("c:when", //$NON-NLS-1$
            103, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_111_7 = new TagInfo("c:when", //$NON-NLS-1$
            111, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_119_7 = new TagInfo("c:when", //$NON-NLS-1$
            119, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_127_7 = new TagInfo("c:when", //$NON-NLS-1$
            127, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_135_7 = new TagInfo("c:when", //$NON-NLS-1$
            135, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_143_7 = new TagInfo("c:when", //$NON-NLS-1$
            143, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_151_8 = new TagInfo("c:otherwise", //$NON-NLS-1$
            151, 8,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_157_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            157, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_158_6 = new TagInfo("c:choose", //$NON-NLS-1$
            158, 6,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_159_7 = new TagInfo("c:when", //$NON-NLS-1$
            159, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_167_7 = new TagInfo("c:when", //$NON-NLS-1$
            167, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_175_7 = new TagInfo("c:when", //$NON-NLS-1$
            175, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_183_7 = new TagInfo("c:when", //$NON-NLS-1$
            183, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_191_7 = new TagInfo("c:when", //$NON-NLS-1$
            191, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_199_7 = new TagInfo("c:when", //$NON-NLS-1$
            199, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_207_7 = new TagInfo("c:when", //$NON-NLS-1$
            207, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_215_8 = new TagInfo("c:otherwise", //$NON-NLS-1$
            215, 8,
            new String[] {
            },
            new String[] {
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\txmlns:");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 3, 8)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("=\"http://schemas.android.com/apk/res/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 3, 72)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tandroid:layout_height=\"fill_parent\" android:layout_width=\"fill_parent\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tandroid:orientation=\"vertical\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\tandroid:layout_height=\"wrap_content\" android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\tandroid:orientation=\"horizontal\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<Button android:id=\"@+id/read_done\" android:text=\"Done\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\tandroid:layout_width=\"wrap_content\" android:layout_height=\"wrap_content\" />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<Button android:id=\"@+id/read_update\" android:text=\"Update\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\tandroid:layout_width=\"wrap_content\" android:layout_height=\"wrap_content\" />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<Button android:id=\"@+id/read_delete\" android:text=\"Delete\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\tandroid:layout_width=\"wrap_content\" android:layout_height=\"wrap_content\" />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</LinearLayout>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<ScrollView");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    android:id=\"@+id/widget54\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    android:layout_width=\"fill_parent\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    android:layout_height=\"fill_parent\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    xmlns:android=\"http://schemas.android.com/apk/res/android\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    >");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tandroid:layout_height=\"fill_parent\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tandroid:layout_width=\"fill_parent\" ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tandroid:orientation=\"vertical\">");  //$NON-NLS-1$        
        out.write(NL);         
        // process parent class level 2 attributes
        RuntimeTagElement _jettag_c_if_27_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_27_2); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_27_2.setRuntimeParent(null);
        _jettag_c_if_27_2.setTagInfo(_td_c_if_27_2);
        _jettag_c_if_27_2.doStart(context, out);
        while (_jettag_c_if_27_2.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_28_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_28_5); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_28_5.setRuntimeParent(_jettag_c_if_27_2);
            _jettag_c_iterate_28_5.setTagInfo(_td_c_iterate_28_5);
            _jettag_c_iterate_28_5.doStart(context, out);
            while (_jettag_c_iterate_28_5.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_29_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_29_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_29_6.setRuntimeParent(_jettag_c_iterate_28_5);
                _jettag_c_choose_29_6.setTagInfo(_td_c_choose_29_6);
                _jettag_c_choose_29_6.doStart(context, out);
                JET2Writer _jettag_c_choose_29_6_saved_out = out;
                while (_jettag_c_choose_29_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_when_30_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_30_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_30_7.setRuntimeParent(_jettag_c_choose_29_6);
                    _jettag_c_when_30_7.setTagInfo(_td_c_when_30_7);
                    _jettag_c_when_30_7.doStart(context, out);
                    JET2Writer _jettag_c_when_30_7_saved_out = out;
                    while (_jettag_c_when_30_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.DateField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 32, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 32, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t         ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 35, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_30_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_30_7_saved_out;
                    _jettag_c_when_30_7.doEnd();
                    RuntimeTagElement _jettag_c_when_38_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_38_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_38_7.setRuntimeParent(_jettag_c_choose_29_6);
                    _jettag_c_when_38_7.setTagInfo(_td_c_when_38_7);
                    _jettag_c_when_38_7.doStart(context, out);
                    JET2Writer _jettag_c_when_38_7_saved_out = out;
                    while (_jettag_c_when_38_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.NumericField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 40, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 40, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t         ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 43, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_38_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_38_7_saved_out;
                    _jettag_c_when_38_7.doEnd();
                    RuntimeTagElement _jettag_c_when_46_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_46_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_46_7.setRuntimeParent(_jettag_c_choose_29_6);
                    _jettag_c_when_46_7.setTagInfo(_td_c_when_46_7);
                    _jettag_c_when_46_7.doStart(context, out);
                    JET2Writer _jettag_c_when_46_7_saved_out = out;
                    while (_jettag_c_when_46_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.NumericField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 48, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 48, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t         ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 51, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_46_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_46_7_saved_out;
                    _jettag_c_when_46_7.doEnd();
                    RuntimeTagElement _jettag_c_when_54_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_54_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_54_7.setRuntimeParent(_jettag_c_choose_29_6);
                    _jettag_c_when_54_7.setTagInfo(_td_c_when_54_7);
                    _jettag_c_when_54_7.doStart(context, out);
                    JET2Writer _jettag_c_when_54_7_saved_out = out;
                    while (_jettag_c_when_54_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.DecimalField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 56, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 56, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 59, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_54_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_54_7_saved_out;
                    _jettag_c_when_54_7.doEnd();
                    RuntimeTagElement _jettag_c_when_62_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_62_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_62_7.setRuntimeParent(_jettag_c_choose_29_6);
                    _jettag_c_when_62_7.setTagInfo(_td_c_when_62_7);
                    _jettag_c_when_62_7.doStart(context, out);
                    JET2Writer _jettag_c_when_62_7_saved_out = out;
                    while (_jettag_c_when_62_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.BooleanField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 64, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 64, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 67, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_62_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_62_7_saved_out;
                    _jettag_c_when_62_7.doEnd();
                    RuntimeTagElement _jettag_c_when_70_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_70_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_70_7.setRuntimeParent(_jettag_c_choose_29_6);
                    _jettag_c_when_70_7.setTagInfo(_td_c_when_70_7);
                    _jettag_c_when_70_7.doStart(context, out);
                    JET2Writer _jettag_c_when_70_7_saved_out = out;
                    while (_jettag_c_when_70_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.StringField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 72, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 72, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 75, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_70_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_70_7_saved_out;
                    _jettag_c_when_70_7.doEnd();
                    RuntimeTagElement _jettag_c_when_78_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_78_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_78_7.setRuntimeParent(_jettag_c_choose_29_6);
                    _jettag_c_when_78_7.setTagInfo(_td_c_when_78_7);
                    _jettag_c_when_78_7.doStart(context, out);
                    JET2Writer _jettag_c_when_78_7_saved_out = out;
                    while (_jettag_c_when_78_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.CurrencyField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 80, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 80, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 83, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_78_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_78_7_saved_out;
                    _jettag_c_when_78_7.doEnd();
                    RuntimeTagElement _jettag_c_otherwise_86_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_86_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_otherwise_86_8.setRuntimeParent(_jettag_c_choose_29_6);
                    _jettag_c_otherwise_86_8.setTagInfo(_td_c_otherwise_86_8);
                    _jettag_c_otherwise_86_8.doStart(context, out);
                    JET2Writer _jettag_c_otherwise_86_8_saved_out = out;
                    while (_jettag_c_otherwise_86_8.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_otherwise_86_8.handleBodyContent(out);
                    }
                    out = _jettag_c_otherwise_86_8_saved_out;
                    _jettag_c_otherwise_86_8.doEnd();
                    _jettag_c_choose_29_6.handleBodyContent(out);
                }
                out = _jettag_c_choose_29_6_saved_out;
                _jettag_c_choose_29_6.doEnd();
                _jettag_c_iterate_28_5.handleBodyContent(out);
            }
            _jettag_c_iterate_28_5.doEnd();
            _jettag_c_if_27_2.handleBodyContent(out);
        }
        _jettag_c_if_27_2.doEnd();
        // process parent class level 1 attributes
        RuntimeTagElement _jettag_c_if_92_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_92_2); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_92_2.setRuntimeParent(null);
        _jettag_c_if_92_2.setTagInfo(_td_c_if_92_2);
        _jettag_c_if_92_2.doStart(context, out);
        while (_jettag_c_if_92_2.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_93_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_93_5); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_93_5.setRuntimeParent(_jettag_c_if_92_2);
            _jettag_c_iterate_93_5.setTagInfo(_td_c_iterate_93_5);
            _jettag_c_iterate_93_5.doStart(context, out);
            while (_jettag_c_iterate_93_5.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_94_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_94_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_94_6.setRuntimeParent(_jettag_c_iterate_93_5);
                _jettag_c_choose_94_6.setTagInfo(_td_c_choose_94_6);
                _jettag_c_choose_94_6.doStart(context, out);
                JET2Writer _jettag_c_choose_94_6_saved_out = out;
                while (_jettag_c_choose_94_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_when_95_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_95_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_95_7.setRuntimeParent(_jettag_c_choose_94_6);
                    _jettag_c_when_95_7.setTagInfo(_td_c_when_95_7);
                    _jettag_c_when_95_7.doStart(context, out);
                    JET2Writer _jettag_c_when_95_7_saved_out = out;
                    while (_jettag_c_when_95_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.DateField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 97, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 97, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t         ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 100, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_95_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_95_7_saved_out;
                    _jettag_c_when_95_7.doEnd();
                    RuntimeTagElement _jettag_c_when_103_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_103_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_103_7.setRuntimeParent(_jettag_c_choose_94_6);
                    _jettag_c_when_103_7.setTagInfo(_td_c_when_103_7);
                    _jettag_c_when_103_7.doStart(context, out);
                    JET2Writer _jettag_c_when_103_7_saved_out = out;
                    while (_jettag_c_when_103_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.NumericField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 105, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 105, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t         ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 108, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_103_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_103_7_saved_out;
                    _jettag_c_when_103_7.doEnd();
                    RuntimeTagElement _jettag_c_when_111_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_111_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_111_7.setRuntimeParent(_jettag_c_choose_94_6);
                    _jettag_c_when_111_7.setTagInfo(_td_c_when_111_7);
                    _jettag_c_when_111_7.doStart(context, out);
                    JET2Writer _jettag_c_when_111_7_saved_out = out;
                    while (_jettag_c_when_111_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.NumericField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 113, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 113, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t         ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 116, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_111_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_111_7_saved_out;
                    _jettag_c_when_111_7.doEnd();
                    RuntimeTagElement _jettag_c_when_119_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_119_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_119_7.setRuntimeParent(_jettag_c_choose_94_6);
                    _jettag_c_when_119_7.setTagInfo(_td_c_when_119_7);
                    _jettag_c_when_119_7.doStart(context, out);
                    JET2Writer _jettag_c_when_119_7_saved_out = out;
                    while (_jettag_c_when_119_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.DecimalField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 121, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 121, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 124, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_119_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_119_7_saved_out;
                    _jettag_c_when_119_7.doEnd();
                    RuntimeTagElement _jettag_c_when_127_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_127_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_127_7.setRuntimeParent(_jettag_c_choose_94_6);
                    _jettag_c_when_127_7.setTagInfo(_td_c_when_127_7);
                    _jettag_c_when_127_7.doStart(context, out);
                    JET2Writer _jettag_c_when_127_7_saved_out = out;
                    while (_jettag_c_when_127_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.BooleanField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 129, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 129, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 132, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_127_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_127_7_saved_out;
                    _jettag_c_when_127_7.doEnd();
                    RuntimeTagElement _jettag_c_when_135_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_135_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_135_7.setRuntimeParent(_jettag_c_choose_94_6);
                    _jettag_c_when_135_7.setTagInfo(_td_c_when_135_7);
                    _jettag_c_when_135_7.doStart(context, out);
                    JET2Writer _jettag_c_when_135_7_saved_out = out;
                    while (_jettag_c_when_135_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.StringField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 137, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 137, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 140, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_135_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_135_7_saved_out;
                    _jettag_c_when_135_7.doEnd();
                    RuntimeTagElement _jettag_c_when_143_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_143_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_143_7.setRuntimeParent(_jettag_c_choose_94_6);
                    _jettag_c_when_143_7.setTagInfo(_td_c_when_143_7);
                    _jettag_c_when_143_7.doStart(context, out);
                    JET2Writer _jettag_c_when_143_7_saved_out = out;
                    while (_jettag_c_when_143_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.CurrencyField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 145, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 145, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 148, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_143_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_143_7_saved_out;
                    _jettag_c_when_143_7.doEnd();
                    RuntimeTagElement _jettag_c_otherwise_151_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_151_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_otherwise_151_8.setRuntimeParent(_jettag_c_choose_94_6);
                    _jettag_c_otherwise_151_8.setTagInfo(_td_c_otherwise_151_8);
                    _jettag_c_otherwise_151_8.doStart(context, out);
                    JET2Writer _jettag_c_otherwise_151_8_saved_out = out;
                    while (_jettag_c_otherwise_151_8.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_otherwise_151_8.handleBodyContent(out);
                    }
                    out = _jettag_c_otherwise_151_8_saved_out;
                    _jettag_c_otherwise_151_8.doEnd();
                    _jettag_c_choose_94_6.handleBodyContent(out);
                }
                out = _jettag_c_choose_94_6_saved_out;
                _jettag_c_choose_94_6.doEnd();
                _jettag_c_iterate_93_5.handleBodyContent(out);
            }
            _jettag_c_iterate_93_5.doEnd();
            _jettag_c_if_92_2.handleBodyContent(out);
        }
        _jettag_c_if_92_2.doEnd();
        // process parent class level 0 attributes
        RuntimeTagElement _jettag_c_iterate_157_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_157_4); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_157_4.setRuntimeParent(null);
        _jettag_c_iterate_157_4.setTagInfo(_td_c_iterate_157_4);
        _jettag_c_iterate_157_4.doStart(context, out);
        while (_jettag_c_iterate_157_4.okToProcessBody()) {
            RuntimeTagElement _jettag_c_choose_158_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_158_6); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_choose_158_6.setRuntimeParent(_jettag_c_iterate_157_4);
            _jettag_c_choose_158_6.setTagInfo(_td_c_choose_158_6);
            _jettag_c_choose_158_6.doStart(context, out);
            JET2Writer _jettag_c_choose_158_6_saved_out = out;
            while (_jettag_c_choose_158_6.okToProcessBody()) {
                out = out.newNestedContentWriter();
                RuntimeTagElement _jettag_c_when_159_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_159_7); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_159_7.setRuntimeParent(_jettag_c_choose_158_6);
                _jettag_c_when_159_7.setTagInfo(_td_c_when_159_7);
                _jettag_c_when_159_7.doStart(context, out);
                JET2Writer _jettag_c_when_159_7_saved_out = out;
                while (_jettag_c_when_159_7.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t\t        <info.yalamanchili.android.views.DateField");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 161, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_read_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 161, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t         ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 164, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_159_7.handleBodyContent(out);
                }
                out = _jettag_c_when_159_7_saved_out;
                _jettag_c_when_159_7.doEnd();
                RuntimeTagElement _jettag_c_when_167_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_167_7); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_167_7.setRuntimeParent(_jettag_c_choose_158_6);
                _jettag_c_when_167_7.setTagInfo(_td_c_when_167_7);
                _jettag_c_when_167_7.doStart(context, out);
                JET2Writer _jettag_c_when_167_7_saved_out = out;
                while (_jettag_c_when_167_7.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t\t        <info.yalamanchili.android.views.NumericField");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 169, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_read_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 169, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t         ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 172, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_167_7.handleBodyContent(out);
                }
                out = _jettag_c_when_167_7_saved_out;
                _jettag_c_when_167_7.doEnd();
                RuntimeTagElement _jettag_c_when_175_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_175_7); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_175_7.setRuntimeParent(_jettag_c_choose_158_6);
                _jettag_c_when_175_7.setTagInfo(_td_c_when_175_7);
                _jettag_c_when_175_7.doStart(context, out);
                JET2Writer _jettag_c_when_175_7_saved_out = out;
                while (_jettag_c_when_175_7.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t\t        <info.yalamanchili.android.views.NumericField");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 177, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_read_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 177, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t         ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 180, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_175_7.handleBodyContent(out);
                }
                out = _jettag_c_when_175_7_saved_out;
                _jettag_c_when_175_7.doEnd();
                RuntimeTagElement _jettag_c_when_183_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_183_7); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_183_7.setRuntimeParent(_jettag_c_choose_158_6);
                _jettag_c_when_183_7.setTagInfo(_td_c_when_183_7);
                _jettag_c_when_183_7.doStart(context, out);
                JET2Writer _jettag_c_when_183_7_saved_out = out;
                while (_jettag_c_when_183_7.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t\t        <info.yalamanchili.android.views.DecimalField");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 185, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_read_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 185, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 188, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_183_7.handleBodyContent(out);
                }
                out = _jettag_c_when_183_7_saved_out;
                _jettag_c_when_183_7.doEnd();
                RuntimeTagElement _jettag_c_when_191_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_191_7); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_191_7.setRuntimeParent(_jettag_c_choose_158_6);
                _jettag_c_when_191_7.setTagInfo(_td_c_when_191_7);
                _jettag_c_when_191_7.doStart(context, out);
                JET2Writer _jettag_c_when_191_7_saved_out = out;
                while (_jettag_c_when_191_7.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t\t        <info.yalamanchili.android.views.BooleanField");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 193, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_read_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 193, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 196, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_191_7.handleBodyContent(out);
                }
                out = _jettag_c_when_191_7_saved_out;
                _jettag_c_when_191_7.doEnd();
                RuntimeTagElement _jettag_c_when_199_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_199_7); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_199_7.setRuntimeParent(_jettag_c_choose_158_6);
                _jettag_c_when_199_7.setTagInfo(_td_c_when_199_7);
                _jettag_c_when_199_7.doStart(context, out);
                JET2Writer _jettag_c_when_199_7_saved_out = out;
                while (_jettag_c_when_199_7.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t\t        <info.yalamanchili.android.views.StringField");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 201, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_read_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 201, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 204, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_199_7.handleBodyContent(out);
                }
                out = _jettag_c_when_199_7_saved_out;
                _jettag_c_when_199_7.doEnd();
                RuntimeTagElement _jettag_c_when_207_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_207_7); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_207_7.setRuntimeParent(_jettag_c_choose_158_6);
                _jettag_c_when_207_7.setTagInfo(_td_c_when_207_7);
                _jettag_c_when_207_7.doStart(context, out);
                JET2Writer _jettag_c_when_207_7_saved_out = out;
                while (_jettag_c_when_207_7.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t\t        <info.yalamanchili.android.views.CurrencyField");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 209, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_read_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 209, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 212, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_207_7.handleBodyContent(out);
                }
                out = _jettag_c_when_207_7_saved_out;
                _jettag_c_when_207_7.doEnd();
                RuntimeTagElement _jettag_c_otherwise_215_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_215_8); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_otherwise_215_8.setRuntimeParent(_jettag_c_choose_158_6);
                _jettag_c_otherwise_215_8.setTagInfo(_td_c_otherwise_215_8);
                _jettag_c_otherwise_215_8.doStart(context, out);
                JET2Writer _jettag_c_otherwise_215_8_saved_out = out;
                while (_jettag_c_otherwise_215_8.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    _jettag_c_otherwise_215_8.handleBodyContent(out);
                }
                out = _jettag_c_otherwise_215_8_saved_out;
                _jettag_c_otherwise_215_8.doEnd();
                _jettag_c_choose_158_6.handleBodyContent(out);
            }
            out = _jettag_c_choose_158_6_saved_out;
            _jettag_c_choose_158_6.doEnd();
            _jettag_c_iterate_157_4.handleBodyContent(out);
        }
        _jettag_c_iterate_157_4.doEnd();
        out.write("</LinearLayout>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</ScrollView>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</LinearLayout>");  //$NON-NLS-1$        
    }
}
