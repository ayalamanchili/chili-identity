package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_entity_readxml_0 implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$

    public _jet_entity_readxml_0() {
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
    private static final TagInfo _td_c_when_35_7 = new TagInfo("c:when", //$NON-NLS-1$
            35, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_43_7 = new TagInfo("c:when", //$NON-NLS-1$
            43, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_51_7 = new TagInfo("c:when", //$NON-NLS-1$
            51, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_59_7 = new TagInfo("c:when", //$NON-NLS-1$
            59, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_67_7 = new TagInfo("c:when", //$NON-NLS-1$
            67, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_75_8 = new TagInfo("c:otherwise", //$NON-NLS-1$
            75, 8,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_84_2 = new TagInfo("c:if", //$NON-NLS-1$
            84, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_85_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            85, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_86_6 = new TagInfo("c:choose", //$NON-NLS-1$
            86, 6,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_87_7 = new TagInfo("c:when", //$NON-NLS-1$
            87, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_92_7 = new TagInfo("c:when", //$NON-NLS-1$
            92, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_100_7 = new TagInfo("c:when", //$NON-NLS-1$
            100, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_108_7 = new TagInfo("c:when", //$NON-NLS-1$
            108, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_116_7 = new TagInfo("c:when", //$NON-NLS-1$
            116, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_124_7 = new TagInfo("c:when", //$NON-NLS-1$
            124, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_132_8 = new TagInfo("c:otherwise", //$NON-NLS-1$
            132, 8,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_141_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            141, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_142_6 = new TagInfo("c:choose", //$NON-NLS-1$
            142, 6,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_143_7 = new TagInfo("c:when", //$NON-NLS-1$
            143, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_148_7 = new TagInfo("c:when", //$NON-NLS-1$
            148, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_156_7 = new TagInfo("c:when", //$NON-NLS-1$
            156, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_164_7 = new TagInfo("c:when", //$NON-NLS-1$
            164, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_172_7 = new TagInfo("c:when", //$NON-NLS-1$
            172, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_180_7 = new TagInfo("c:when", //$NON-NLS-1$
            180, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_188_8 = new TagInfo("c:otherwise", //$NON-NLS-1$
            188, 8,
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
                        out.write("\t\t\t\t\t\t\t<info.yalamanchili.android.views.StringField android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 31, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 31, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\" android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t\tandroid:layout_height=\"wrap_content\" ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 32, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\">");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t</info.yalamanchili.android.views.StringField>\t\t\t\t\t ");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_30_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_30_7_saved_out;
                    _jettag_c_when_30_7.doEnd();
                    RuntimeTagElement _jettag_c_when_35_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_35_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_35_7.setRuntimeParent(_jettag_c_choose_29_6);
                    _jettag_c_when_35_7.setTagInfo(_td_c_when_35_7);
                    _jettag_c_when_35_7.doStart(context, out);
                    JET2Writer _jettag_c_when_35_7_saved_out = out;
                    while (_jettag_c_when_35_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.NumericField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 37, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 37, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t         ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 40, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_35_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_35_7_saved_out;
                    _jettag_c_when_35_7.doEnd();
                    RuntimeTagElement _jettag_c_when_43_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_43_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_43_7.setRuntimeParent(_jettag_c_choose_29_6);
                    _jettag_c_when_43_7.setTagInfo(_td_c_when_43_7);
                    _jettag_c_when_43_7.doStart(context, out);
                    JET2Writer _jettag_c_when_43_7_saved_out = out;
                    while (_jettag_c_when_43_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.NumericField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 45, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 45, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t         ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 48, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_43_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_43_7_saved_out;
                    _jettag_c_when_43_7.doEnd();
                    RuntimeTagElement _jettag_c_when_51_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_51_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_51_7.setRuntimeParent(_jettag_c_choose_29_6);
                    _jettag_c_when_51_7.setTagInfo(_td_c_when_51_7);
                    _jettag_c_when_51_7.doStart(context, out);
                    JET2Writer _jettag_c_when_51_7_saved_out = out;
                    while (_jettag_c_when_51_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.DecimalField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 53, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 53, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 56, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_51_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_51_7_saved_out;
                    _jettag_c_when_51_7.doEnd();
                    RuntimeTagElement _jettag_c_when_59_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_59_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_59_7.setRuntimeParent(_jettag_c_choose_29_6);
                    _jettag_c_when_59_7.setTagInfo(_td_c_when_59_7);
                    _jettag_c_when_59_7.doStart(context, out);
                    JET2Writer _jettag_c_when_59_7_saved_out = out;
                    while (_jettag_c_when_59_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.BooleanField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 61, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 61, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 64, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_59_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_59_7_saved_out;
                    _jettag_c_when_59_7.doEnd();
                    RuntimeTagElement _jettag_c_when_67_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_67_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_67_7.setRuntimeParent(_jettag_c_choose_29_6);
                    _jettag_c_when_67_7.setTagInfo(_td_c_when_67_7);
                    _jettag_c_when_67_7.doStart(context, out);
                    JET2Writer _jettag_c_when_67_7_saved_out = out;
                    while (_jettag_c_when_67_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.StringField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 69, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 69, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 72, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_67_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_67_7_saved_out;
                    _jettag_c_when_67_7.doEnd();
                    RuntimeTagElement _jettag_c_otherwise_75_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_75_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_otherwise_75_8.setRuntimeParent(_jettag_c_choose_29_6);
                    _jettag_c_otherwise_75_8.setTagInfo(_td_c_otherwise_75_8);
                    _jettag_c_otherwise_75_8.doStart(context, out);
                    JET2Writer _jettag_c_otherwise_75_8_saved_out = out;
                    while (_jettag_c_otherwise_75_8.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t\t\t\t<info.yalamanchili.android.views.StringField android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 76, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 76, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\" android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t\tandroid:layout_height=\"wrap_content\" ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 77, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\">");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t</info.yalamanchili.android.views.StringField>");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_otherwise_75_8.handleBodyContent(out);
                    }
                    out = _jettag_c_otherwise_75_8_saved_out;
                    _jettag_c_otherwise_75_8.doEnd();
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
        RuntimeTagElement _jettag_c_if_84_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_84_2); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_84_2.setRuntimeParent(null);
        _jettag_c_if_84_2.setTagInfo(_td_c_if_84_2);
        _jettag_c_if_84_2.doStart(context, out);
        while (_jettag_c_if_84_2.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_85_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_85_5); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_85_5.setRuntimeParent(_jettag_c_if_84_2);
            _jettag_c_iterate_85_5.setTagInfo(_td_c_iterate_85_5);
            _jettag_c_iterate_85_5.doStart(context, out);
            while (_jettag_c_iterate_85_5.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_86_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_86_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_86_6.setRuntimeParent(_jettag_c_iterate_85_5);
                _jettag_c_choose_86_6.setTagInfo(_td_c_choose_86_6);
                _jettag_c_choose_86_6.doStart(context, out);
                JET2Writer _jettag_c_choose_86_6_saved_out = out;
                while (_jettag_c_choose_86_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_when_87_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_87_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_87_7.setRuntimeParent(_jettag_c_choose_86_6);
                    _jettag_c_when_87_7.setTagInfo(_td_c_when_87_7);
                    _jettag_c_when_87_7.doStart(context, out);
                    JET2Writer _jettag_c_when_87_7_saved_out = out;
                    while (_jettag_c_when_87_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t\t\t\t<info.yalamanchili.android.views.StringField android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 88, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 88, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\" android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t\tandroid:layout_height=\"wrap_content\" ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 89, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\">");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t</info.yalamanchili.android.views.StringField>\t\t\t\t\t ");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_87_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_87_7_saved_out;
                    _jettag_c_when_87_7.doEnd();
                    RuntimeTagElement _jettag_c_when_92_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_92_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_92_7.setRuntimeParent(_jettag_c_choose_86_6);
                    _jettag_c_when_92_7.setTagInfo(_td_c_when_92_7);
                    _jettag_c_when_92_7.doStart(context, out);
                    JET2Writer _jettag_c_when_92_7_saved_out = out;
                    while (_jettag_c_when_92_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.NumericField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 94, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 94, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t         ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 97, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_92_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_92_7_saved_out;
                    _jettag_c_when_92_7.doEnd();
                    RuntimeTagElement _jettag_c_when_100_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_100_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_100_7.setRuntimeParent(_jettag_c_choose_86_6);
                    _jettag_c_when_100_7.setTagInfo(_td_c_when_100_7);
                    _jettag_c_when_100_7.doStart(context, out);
                    JET2Writer _jettag_c_when_100_7_saved_out = out;
                    while (_jettag_c_when_100_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.NumericField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 102, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 102, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t         ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 105, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_100_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_100_7_saved_out;
                    _jettag_c_when_100_7.doEnd();
                    RuntimeTagElement _jettag_c_when_108_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_108_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_108_7.setRuntimeParent(_jettag_c_choose_86_6);
                    _jettag_c_when_108_7.setTagInfo(_td_c_when_108_7);
                    _jettag_c_when_108_7.doStart(context, out);
                    JET2Writer _jettag_c_when_108_7_saved_out = out;
                    while (_jettag_c_when_108_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.DecimalField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 110, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 110, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 113, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_108_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_108_7_saved_out;
                    _jettag_c_when_108_7.doEnd();
                    RuntimeTagElement _jettag_c_when_116_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_116_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_116_7.setRuntimeParent(_jettag_c_choose_86_6);
                    _jettag_c_when_116_7.setTagInfo(_td_c_when_116_7);
                    _jettag_c_when_116_7.doStart(context, out);
                    JET2Writer _jettag_c_when_116_7_saved_out = out;
                    while (_jettag_c_when_116_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.BooleanField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 118, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 118, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 121, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_116_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_116_7_saved_out;
                    _jettag_c_when_116_7.doEnd();
                    RuntimeTagElement _jettag_c_when_124_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_124_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_124_7.setRuntimeParent(_jettag_c_choose_86_6);
                    _jettag_c_when_124_7.setTagInfo(_td_c_when_124_7);
                    _jettag_c_when_124_7.doStart(context, out);
                    JET2Writer _jettag_c_when_124_7_saved_out = out;
                    while (_jettag_c_when_124_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.StringField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 126, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 126, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 129, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_124_7.handleBodyContent(out);
                    }
                    out = _jettag_c_when_124_7_saved_out;
                    _jettag_c_when_124_7.doEnd();
                    RuntimeTagElement _jettag_c_otherwise_132_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_132_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_otherwise_132_8.setRuntimeParent(_jettag_c_choose_86_6);
                    _jettag_c_otherwise_132_8.setTagInfo(_td_c_otherwise_132_8);
                    _jettag_c_otherwise_132_8.doStart(context, out);
                    JET2Writer _jettag_c_otherwise_132_8_saved_out = out;
                    while (_jettag_c_otherwise_132_8.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t\t\t\t<info.yalamanchili.android.views.StringField android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 133, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 133, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\" android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t\tandroid:layout_height=\"wrap_content\" ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 134, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(":readOnly=\"true\">");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t</info.yalamanchili.android.views.StringField>");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_otherwise_132_8.handleBodyContent(out);
                    }
                    out = _jettag_c_otherwise_132_8_saved_out;
                    _jettag_c_otherwise_132_8.doEnd();
                    _jettag_c_choose_86_6.handleBodyContent(out);
                }
                out = _jettag_c_choose_86_6_saved_out;
                _jettag_c_choose_86_6.doEnd();
                _jettag_c_iterate_85_5.handleBodyContent(out);
            }
            _jettag_c_iterate_85_5.doEnd();
            _jettag_c_if_84_2.handleBodyContent(out);
        }
        _jettag_c_if_84_2.doEnd();
        // process parent class level 0 attributes
        RuntimeTagElement _jettag_c_iterate_141_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_141_4); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_141_4.setRuntimeParent(null);
        _jettag_c_iterate_141_4.setTagInfo(_td_c_iterate_141_4);
        _jettag_c_iterate_141_4.doStart(context, out);
        while (_jettag_c_iterate_141_4.okToProcessBody()) {
            RuntimeTagElement _jettag_c_choose_142_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_142_6); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_choose_142_6.setRuntimeParent(_jettag_c_iterate_141_4);
            _jettag_c_choose_142_6.setTagInfo(_td_c_choose_142_6);
            _jettag_c_choose_142_6.doStart(context, out);
            JET2Writer _jettag_c_choose_142_6_saved_out = out;
            while (_jettag_c_choose_142_6.okToProcessBody()) {
                out = out.newNestedContentWriter();
                RuntimeTagElement _jettag_c_when_143_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_143_7); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_143_7.setRuntimeParent(_jettag_c_choose_142_6);
                _jettag_c_when_143_7.setTagInfo(_td_c_when_143_7);
                _jettag_c_when_143_7.doStart(context, out);
                JET2Writer _jettag_c_when_143_7_saved_out = out;
                while (_jettag_c_when_143_7.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t\t\t\t\t<info.yalamanchili.android.views.StringField android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 144, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_read_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 144, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\" android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t\t\t\tandroid:layout_height=\"wrap_content\" ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 145, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(":readOnly=\"true\">");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t\t\t</info.yalamanchili.android.views.StringField>\t\t\t\t\t ");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_143_7.handleBodyContent(out);
                }
                out = _jettag_c_when_143_7_saved_out;
                _jettag_c_when_143_7.doEnd();
                RuntimeTagElement _jettag_c_when_148_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_148_7); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_148_7.setRuntimeParent(_jettag_c_choose_142_6);
                _jettag_c_when_148_7.setTagInfo(_td_c_when_148_7);
                _jettag_c_when_148_7.doStart(context, out);
                JET2Writer _jettag_c_when_148_7_saved_out = out;
                while (_jettag_c_when_148_7.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t\t        <info.yalamanchili.android.views.NumericField");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 150, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_read_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 150, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t         ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 153, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_148_7.handleBodyContent(out);
                }
                out = _jettag_c_when_148_7_saved_out;
                _jettag_c_when_148_7.doEnd();
                RuntimeTagElement _jettag_c_when_156_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_156_7); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_156_7.setRuntimeParent(_jettag_c_choose_142_6);
                _jettag_c_when_156_7.setTagInfo(_td_c_when_156_7);
                _jettag_c_when_156_7.doStart(context, out);
                JET2Writer _jettag_c_when_156_7_saved_out = out;
                while (_jettag_c_when_156_7.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t\t        <info.yalamanchili.android.views.NumericField");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 158, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_read_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 158, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t         ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 161, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_156_7.handleBodyContent(out);
                }
                out = _jettag_c_when_156_7_saved_out;
                _jettag_c_when_156_7.doEnd();
                RuntimeTagElement _jettag_c_when_164_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_164_7); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_164_7.setRuntimeParent(_jettag_c_choose_142_6);
                _jettag_c_when_164_7.setTagInfo(_td_c_when_164_7);
                _jettag_c_when_164_7.doStart(context, out);
                JET2Writer _jettag_c_when_164_7_saved_out = out;
                while (_jettag_c_when_164_7.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t\t        <info.yalamanchili.android.views.DecimalField");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 166, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_read_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 166, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 169, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_164_7.handleBodyContent(out);
                }
                out = _jettag_c_when_164_7_saved_out;
                _jettag_c_when_164_7.doEnd();
                RuntimeTagElement _jettag_c_when_172_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_172_7); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_172_7.setRuntimeParent(_jettag_c_choose_142_6);
                _jettag_c_when_172_7.setTagInfo(_td_c_when_172_7);
                _jettag_c_when_172_7.doStart(context, out);
                JET2Writer _jettag_c_when_172_7_saved_out = out;
                while (_jettag_c_when_172_7.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t\t        <info.yalamanchili.android.views.BooleanField");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 174, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_read_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 174, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 177, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_172_7.handleBodyContent(out);
                }
                out = _jettag_c_when_172_7_saved_out;
                _jettag_c_when_172_7.doEnd();
                RuntimeTagElement _jettag_c_when_180_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_180_7); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_180_7.setRuntimeParent(_jettag_c_choose_142_6);
                _jettag_c_when_180_7.setTagInfo(_td_c_when_180_7);
                _jettag_c_when_180_7.doStart(context, out);
                JET2Writer _jettag_c_when_180_7_saved_out = out;
                while (_jettag_c_when_180_7.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t\t        <info.yalamanchili.android.views.StringField");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 182, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_read_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 182, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 185, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(":readOnly=\"true\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_180_7.handleBodyContent(out);
                }
                out = _jettag_c_when_180_7_saved_out;
                _jettag_c_when_180_7.doEnd();
                RuntimeTagElement _jettag_c_otherwise_188_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_188_8); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_otherwise_188_8.setRuntimeParent(_jettag_c_choose_142_6);
                _jettag_c_otherwise_188_8.setTagInfo(_td_c_otherwise_188_8);
                _jettag_c_otherwise_188_8.doStart(context, out);
                JET2Writer _jettag_c_otherwise_188_8_saved_out = out;
                while (_jettag_c_otherwise_188_8.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t\t\t\t\t<info.yalamanchili.android.views.StringField android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 189, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_read_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 189, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\" android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t\t\t\tandroid:layout_height=\"wrap_content\" ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 190, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(":readOnly=\"true\">");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t\t\t</info.yalamanchili.android.views.StringField>");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_otherwise_188_8.handleBodyContent(out);
                }
                out = _jettag_c_otherwise_188_8_saved_out;
                _jettag_c_otherwise_188_8.doEnd();
                _jettag_c_choose_142_6.handleBodyContent(out);
            }
            out = _jettag_c_choose_142_6_saved_out;
            _jettag_c_choose_142_6.doEnd();
            _jettag_c_iterate_141_4.handleBodyContent(out);
        }
        _jettag_c_iterate_141_4.doEnd();
        out.write("</LinearLayout>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</ScrollView>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</LinearLayout>");  //$NON-NLS-1$        
    }
}
