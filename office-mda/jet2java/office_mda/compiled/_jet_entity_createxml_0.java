package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_entity_createxml_0 implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$

    public _jet_entity_createxml_0() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_c_if_15_2 = new TagInfo("c:if", //$NON-NLS-1$
            15, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_16_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            16, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_17_5 = new TagInfo("c:choose", //$NON-NLS-1$
            17, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_18_6 = new TagInfo("c:when", //$NON-NLS-1$
            18, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_25_6 = new TagInfo("c:when", //$NON-NLS-1$
            25, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_32_6 = new TagInfo("c:when", //$NON-NLS-1$
            32, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_39_6 = new TagInfo("c:when", //$NON-NLS-1$
            39, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_46_6 = new TagInfo("c:when", //$NON-NLS-1$
            46, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_53_6 = new TagInfo("c:when", //$NON-NLS-1$
            53, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_60_6 = new TagInfo("c:when", //$NON-NLS-1$
            60, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_67_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            67, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_73_2 = new TagInfo("c:if", //$NON-NLS-1$
            73, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_74_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            74, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_75_5 = new TagInfo("c:choose", //$NON-NLS-1$
            75, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_76_6 = new TagInfo("c:when", //$NON-NLS-1$
            76, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_83_6 = new TagInfo("c:when", //$NON-NLS-1$
            83, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_90_6 = new TagInfo("c:when", //$NON-NLS-1$
            90, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_97_6 = new TagInfo("c:when", //$NON-NLS-1$
            97, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_104_6 = new TagInfo("c:when", //$NON-NLS-1$
            104, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_111_6 = new TagInfo("c:when", //$NON-NLS-1$
            111, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_118_6 = new TagInfo("c:when", //$NON-NLS-1$
            118, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_125_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            125, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_131_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            131, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_132_5 = new TagInfo("c:choose", //$NON-NLS-1$
            132, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_133_6 = new TagInfo("c:when", //$NON-NLS-1$
            133, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_140_6 = new TagInfo("c:when", //$NON-NLS-1$
            140, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_147_6 = new TagInfo("c:when", //$NON-NLS-1$
            147, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_154_6 = new TagInfo("c:when", //$NON-NLS-1$
            154, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_161_6 = new TagInfo("c:when", //$NON-NLS-1$
            161, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_168_6 = new TagInfo("c:when", //$NON-NLS-1$
            168, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_175_6 = new TagInfo("c:when", //$NON-NLS-1$
            175, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_182_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            182, 7,
            new String[] {
            },
            new String[] {
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<ScrollView");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    android:id=\"@+id/widget54\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    android:layout_width=\"fill_parent\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    android:layout_height=\"fill_parent\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    xmlns:android=\"http://schemas.android.com/apk/res/android\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    xmlns:");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 8, 11)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("=\"http://schemas.android.com/apk/res/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 8, 75)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("\"");  //$NON-NLS-1$        
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
        RuntimeTagElement _jettag_c_if_15_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_15_2); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_15_2.setRuntimeParent(null);
        _jettag_c_if_15_2.setTagInfo(_td_c_if_15_2);
        _jettag_c_if_15_2.doStart(context, out);
        while (_jettag_c_if_15_2.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_16_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_16_5); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_16_5.setRuntimeParent(_jettag_c_if_15_2);
            _jettag_c_iterate_16_5.setTagInfo(_td_c_iterate_16_5);
            _jettag_c_iterate_16_5.doStart(context, out);
            while (_jettag_c_iterate_16_5.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_17_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_17_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_17_5.setRuntimeParent(_jettag_c_iterate_16_5);
                _jettag_c_choose_17_5.setTagInfo(_td_c_choose_17_5);
                _jettag_c_choose_17_5.doStart(context, out);
                JET2Writer _jettag_c_choose_17_5_saved_out = out;
                while (_jettag_c_choose_17_5.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_when_18_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_18_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_18_6.setRuntimeParent(_jettag_c_choose_17_5);
                    _jettag_c_when_18_6.setTagInfo(_td_c_when_18_6);
                    _jettag_c_when_18_6.doStart(context, out);
                    JET2Writer _jettag_c_when_18_6_saved_out = out;
                    while (_jettag_c_when_18_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t        <info.yalamanchili.android.views.DateField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 20, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 20, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_18_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_18_6_saved_out;
                    _jettag_c_when_18_6.doEnd();
                    RuntimeTagElement _jettag_c_when_25_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_25_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_25_6.setRuntimeParent(_jettag_c_choose_17_5);
                    _jettag_c_when_25_6.setTagInfo(_td_c_when_25_6);
                    _jettag_c_when_25_6.doStart(context, out);
                    JET2Writer _jettag_c_when_25_6_saved_out = out;
                    while (_jettag_c_when_25_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t        <info.yalamanchili.android.views.StringField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 27, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 27, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_25_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_25_6_saved_out;
                    _jettag_c_when_25_6.doEnd();
                    RuntimeTagElement _jettag_c_when_32_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_32_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_32_6.setRuntimeParent(_jettag_c_choose_17_5);
                    _jettag_c_when_32_6.setTagInfo(_td_c_when_32_6);
                    _jettag_c_when_32_6.doStart(context, out);
                    JET2Writer _jettag_c_when_32_6_saved_out = out;
                    while (_jettag_c_when_32_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t        <info.yalamanchili.android.views.NumericField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 34, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 34, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_32_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_32_6_saved_out;
                    _jettag_c_when_32_6.doEnd();
                    RuntimeTagElement _jettag_c_when_39_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_39_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_39_6.setRuntimeParent(_jettag_c_choose_17_5);
                    _jettag_c_when_39_6.setTagInfo(_td_c_when_39_6);
                    _jettag_c_when_39_6.doStart(context, out);
                    JET2Writer _jettag_c_when_39_6_saved_out = out;
                    while (_jettag_c_when_39_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t        <info.yalamanchili.android.views.NumericField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 41, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 41, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_39_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_39_6_saved_out;
                    _jettag_c_when_39_6.doEnd();
                    RuntimeTagElement _jettag_c_when_46_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_46_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_46_6.setRuntimeParent(_jettag_c_choose_17_5);
                    _jettag_c_when_46_6.setTagInfo(_td_c_when_46_6);
                    _jettag_c_when_46_6.doStart(context, out);
                    JET2Writer _jettag_c_when_46_6_saved_out = out;
                    while (_jettag_c_when_46_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t        <info.yalamanchili.android.views.DecimalField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 48, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 48, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        />");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_46_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_46_6_saved_out;
                    _jettag_c_when_46_6.doEnd();
                    RuntimeTagElement _jettag_c_when_53_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_53_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_53_6.setRuntimeParent(_jettag_c_choose_17_5);
                    _jettag_c_when_53_6.setTagInfo(_td_c_when_53_6);
                    _jettag_c_when_53_6.doStart(context, out);
                    JET2Writer _jettag_c_when_53_6_saved_out = out;
                    while (_jettag_c_when_53_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t        <info.yalamanchili.android.views.CurrencyField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 55, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 55, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_53_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_53_6_saved_out;
                    _jettag_c_when_53_6.doEnd();
                    RuntimeTagElement _jettag_c_when_60_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_60_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_60_6.setRuntimeParent(_jettag_c_choose_17_5);
                    _jettag_c_when_60_6.setTagInfo(_td_c_when_60_6);
                    _jettag_c_when_60_6.doStart(context, out);
                    JET2Writer _jettag_c_when_60_6_saved_out = out;
                    while (_jettag_c_when_60_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t        <info.yalamanchili.android.views.BooleanField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 62, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 62, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_60_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_60_6_saved_out;
                    _jettag_c_when_60_6.doEnd();
                    RuntimeTagElement _jettag_c_otherwise_67_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_67_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_otherwise_67_7.setRuntimeParent(_jettag_c_choose_17_5);
                    _jettag_c_otherwise_67_7.setTagInfo(_td_c_otherwise_67_7);
                    _jettag_c_otherwise_67_7.doStart(context, out);
                    JET2Writer _jettag_c_otherwise_67_7_saved_out = out;
                    while (_jettag_c_otherwise_67_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_otherwise_67_7.handleBodyContent(out);
                    }
                    out = _jettag_c_otherwise_67_7_saved_out;
                    _jettag_c_otherwise_67_7.doEnd();
                    _jettag_c_choose_17_5.handleBodyContent(out);
                }
                out = _jettag_c_choose_17_5_saved_out;
                _jettag_c_choose_17_5.doEnd();
                _jettag_c_iterate_16_5.handleBodyContent(out);
            }
            _jettag_c_iterate_16_5.doEnd();
            _jettag_c_if_15_2.handleBodyContent(out);
        }
        _jettag_c_if_15_2.doEnd();
        // process parent class level 1 attributes
        RuntimeTagElement _jettag_c_if_73_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_73_2); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_73_2.setRuntimeParent(null);
        _jettag_c_if_73_2.setTagInfo(_td_c_if_73_2);
        _jettag_c_if_73_2.doStart(context, out);
        while (_jettag_c_if_73_2.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_74_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_74_5); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_74_5.setRuntimeParent(_jettag_c_if_73_2);
            _jettag_c_iterate_74_5.setTagInfo(_td_c_iterate_74_5);
            _jettag_c_iterate_74_5.doStart(context, out);
            while (_jettag_c_iterate_74_5.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_75_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_75_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_75_5.setRuntimeParent(_jettag_c_iterate_74_5);
                _jettag_c_choose_75_5.setTagInfo(_td_c_choose_75_5);
                _jettag_c_choose_75_5.doStart(context, out);
                JET2Writer _jettag_c_choose_75_5_saved_out = out;
                while (_jettag_c_choose_75_5.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_when_76_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_76_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_76_6.setRuntimeParent(_jettag_c_choose_75_5);
                    _jettag_c_when_76_6.setTagInfo(_td_c_when_76_6);
                    _jettag_c_when_76_6.doStart(context, out);
                    JET2Writer _jettag_c_when_76_6_saved_out = out;
                    while (_jettag_c_when_76_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t        <info.yalamanchili.android.views.DateField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 78, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 78, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_76_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_76_6_saved_out;
                    _jettag_c_when_76_6.doEnd();
                    RuntimeTagElement _jettag_c_when_83_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_83_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_83_6.setRuntimeParent(_jettag_c_choose_75_5);
                    _jettag_c_when_83_6.setTagInfo(_td_c_when_83_6);
                    _jettag_c_when_83_6.doStart(context, out);
                    JET2Writer _jettag_c_when_83_6_saved_out = out;
                    while (_jettag_c_when_83_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t        <info.yalamanchili.android.views.StringField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 85, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 85, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_83_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_83_6_saved_out;
                    _jettag_c_when_83_6.doEnd();
                    RuntimeTagElement _jettag_c_when_90_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_90_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_90_6.setRuntimeParent(_jettag_c_choose_75_5);
                    _jettag_c_when_90_6.setTagInfo(_td_c_when_90_6);
                    _jettag_c_when_90_6.doStart(context, out);
                    JET2Writer _jettag_c_when_90_6_saved_out = out;
                    while (_jettag_c_when_90_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t        <info.yalamanchili.android.views.NumericField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 92, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 92, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_90_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_90_6_saved_out;
                    _jettag_c_when_90_6.doEnd();
                    RuntimeTagElement _jettag_c_when_97_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_97_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_97_6.setRuntimeParent(_jettag_c_choose_75_5);
                    _jettag_c_when_97_6.setTagInfo(_td_c_when_97_6);
                    _jettag_c_when_97_6.doStart(context, out);
                    JET2Writer _jettag_c_when_97_6_saved_out = out;
                    while (_jettag_c_when_97_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t        <info.yalamanchili.android.views.NumericField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 99, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 99, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_97_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_97_6_saved_out;
                    _jettag_c_when_97_6.doEnd();
                    RuntimeTagElement _jettag_c_when_104_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_104_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_104_6.setRuntimeParent(_jettag_c_choose_75_5);
                    _jettag_c_when_104_6.setTagInfo(_td_c_when_104_6);
                    _jettag_c_when_104_6.doStart(context, out);
                    JET2Writer _jettag_c_when_104_6_saved_out = out;
                    while (_jettag_c_when_104_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t        <info.yalamanchili.android.views.DecimalField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 106, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 106, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_104_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_104_6_saved_out;
                    _jettag_c_when_104_6.doEnd();
                    RuntimeTagElement _jettag_c_when_111_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_111_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_111_6.setRuntimeParent(_jettag_c_choose_75_5);
                    _jettag_c_when_111_6.setTagInfo(_td_c_when_111_6);
                    _jettag_c_when_111_6.doStart(context, out);
                    JET2Writer _jettag_c_when_111_6_saved_out = out;
                    while (_jettag_c_when_111_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t        <info.yalamanchili.android.views.CurrencyField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 113, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 113, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_111_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_111_6_saved_out;
                    _jettag_c_when_111_6.doEnd();
                    RuntimeTagElement _jettag_c_when_118_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_118_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_118_6.setRuntimeParent(_jettag_c_choose_75_5);
                    _jettag_c_when_118_6.setTagInfo(_td_c_when_118_6);
                    _jettag_c_when_118_6.doStart(context, out);
                    JET2Writer _jettag_c_when_118_6_saved_out = out;
                    while (_jettag_c_when_118_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t        <info.yalamanchili.android.views.BooleanField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 120, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 120, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_118_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_118_6_saved_out;
                    _jettag_c_when_118_6.doEnd();
                    RuntimeTagElement _jettag_c_otherwise_125_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_125_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_otherwise_125_7.setRuntimeParent(_jettag_c_choose_75_5);
                    _jettag_c_otherwise_125_7.setTagInfo(_td_c_otherwise_125_7);
                    _jettag_c_otherwise_125_7.doStart(context, out);
                    JET2Writer _jettag_c_otherwise_125_7_saved_out = out;
                    while (_jettag_c_otherwise_125_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_otherwise_125_7.handleBodyContent(out);
                    }
                    out = _jettag_c_otherwise_125_7_saved_out;
                    _jettag_c_otherwise_125_7.doEnd();
                    _jettag_c_choose_75_5.handleBodyContent(out);
                }
                out = _jettag_c_choose_75_5_saved_out;
                _jettag_c_choose_75_5.doEnd();
                _jettag_c_iterate_74_5.handleBodyContent(out);
            }
            _jettag_c_iterate_74_5.doEnd();
            _jettag_c_if_73_2.handleBodyContent(out);
        }
        _jettag_c_if_73_2.doEnd();
        // process parent class level 0 attributes
        RuntimeTagElement _jettag_c_iterate_131_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_131_4); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_131_4.setRuntimeParent(null);
        _jettag_c_iterate_131_4.setTagInfo(_td_c_iterate_131_4);
        _jettag_c_iterate_131_4.doStart(context, out);
        while (_jettag_c_iterate_131_4.okToProcessBody()) {
            RuntimeTagElement _jettag_c_choose_132_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_132_5); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_choose_132_5.setRuntimeParent(_jettag_c_iterate_131_4);
            _jettag_c_choose_132_5.setTagInfo(_td_c_choose_132_5);
            _jettag_c_choose_132_5.doStart(context, out);
            JET2Writer _jettag_c_choose_132_5_saved_out = out;
            while (_jettag_c_choose_132_5.okToProcessBody()) {
                out = out.newNestedContentWriter();
                RuntimeTagElement _jettag_c_when_133_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_133_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_133_6.setRuntimeParent(_jettag_c_choose_132_5);
                _jettag_c_when_133_6.setTagInfo(_td_c_when_133_6);
                _jettag_c_when_133_6.doStart(context, out);
                JET2Writer _jettag_c_when_133_6_saved_out = out;
                while (_jettag_c_when_133_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t        <info.yalamanchili.android.views.DateField");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 135, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_create_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 135, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_133_6.handleBodyContent(out);
                }
                out = _jettag_c_when_133_6_saved_out;
                _jettag_c_when_133_6.doEnd();
                RuntimeTagElement _jettag_c_when_140_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_140_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_140_6.setRuntimeParent(_jettag_c_choose_132_5);
                _jettag_c_when_140_6.setTagInfo(_td_c_when_140_6);
                _jettag_c_when_140_6.doStart(context, out);
                JET2Writer _jettag_c_when_140_6_saved_out = out;
                while (_jettag_c_when_140_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t        <info.yalamanchili.android.views.StringField");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 142, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_create_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 142, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_140_6.handleBodyContent(out);
                }
                out = _jettag_c_when_140_6_saved_out;
                _jettag_c_when_140_6.doEnd();
                RuntimeTagElement _jettag_c_when_147_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_147_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_147_6.setRuntimeParent(_jettag_c_choose_132_5);
                _jettag_c_when_147_6.setTagInfo(_td_c_when_147_6);
                _jettag_c_when_147_6.doStart(context, out);
                JET2Writer _jettag_c_when_147_6_saved_out = out;
                while (_jettag_c_when_147_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t        <info.yalamanchili.android.views.NumericField");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 149, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_create_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 149, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_147_6.handleBodyContent(out);
                }
                out = _jettag_c_when_147_6_saved_out;
                _jettag_c_when_147_6.doEnd();
                RuntimeTagElement _jettag_c_when_154_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_154_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_154_6.setRuntimeParent(_jettag_c_choose_132_5);
                _jettag_c_when_154_6.setTagInfo(_td_c_when_154_6);
                _jettag_c_when_154_6.doStart(context, out);
                JET2Writer _jettag_c_when_154_6_saved_out = out;
                while (_jettag_c_when_154_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t        <info.yalamanchili.android.views.NumericField");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 156, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_create_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 156, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_154_6.handleBodyContent(out);
                }
                out = _jettag_c_when_154_6_saved_out;
                _jettag_c_when_154_6.doEnd();
                RuntimeTagElement _jettag_c_when_161_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_161_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_161_6.setRuntimeParent(_jettag_c_choose_132_5);
                _jettag_c_when_161_6.setTagInfo(_td_c_when_161_6);
                _jettag_c_when_161_6.doStart(context, out);
                JET2Writer _jettag_c_when_161_6_saved_out = out;
                while (_jettag_c_when_161_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t        <info.yalamanchili.android.views.DecimalField");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 163, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_create_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 163, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_161_6.handleBodyContent(out);
                }
                out = _jettag_c_when_161_6_saved_out;
                _jettag_c_when_161_6.doEnd();
                RuntimeTagElement _jettag_c_when_168_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_168_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_168_6.setRuntimeParent(_jettag_c_choose_132_5);
                _jettag_c_when_168_6.setTagInfo(_td_c_when_168_6);
                _jettag_c_when_168_6.doStart(context, out);
                JET2Writer _jettag_c_when_168_6_saved_out = out;
                while (_jettag_c_when_168_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t        <info.yalamanchili.android.views.CurrencyField");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 170, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_create_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 170, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_168_6.handleBodyContent(out);
                }
                out = _jettag_c_when_168_6_saved_out;
                _jettag_c_when_168_6.doEnd();
                RuntimeTagElement _jettag_c_when_175_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_175_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_175_6.setRuntimeParent(_jettag_c_choose_132_5);
                _jettag_c_when_175_6.setTagInfo(_td_c_when_175_6);
                _jettag_c_when_175_6.doStart(context, out);
                JET2Writer _jettag_c_when_175_6_saved_out = out;
                while (_jettag_c_when_175_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t        <info.yalamanchili.android.views.BooleanField");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 177, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_create_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 177, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_175_6.handleBodyContent(out);
                }
                out = _jettag_c_when_175_6_saved_out;
                _jettag_c_when_175_6.doEnd();
                RuntimeTagElement _jettag_c_otherwise_182_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_182_7); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_otherwise_182_7.setRuntimeParent(_jettag_c_choose_132_5);
                _jettag_c_otherwise_182_7.setTagInfo(_td_c_otherwise_182_7);
                _jettag_c_otherwise_182_7.doStart(context, out);
                JET2Writer _jettag_c_otherwise_182_7_saved_out = out;
                while (_jettag_c_otherwise_182_7.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    _jettag_c_otherwise_182_7.handleBodyContent(out);
                }
                out = _jettag_c_otherwise_182_7_saved_out;
                _jettag_c_otherwise_182_7.doEnd();
                _jettag_c_choose_132_5.handleBodyContent(out);
            }
            out = _jettag_c_choose_132_5_saved_out;
            _jettag_c_choose_132_5.doEnd();
            _jettag_c_iterate_131_4.handleBodyContent(out);
        }
        _jettag_c_iterate_131_4.doEnd();
        out.write("\t\t        <Button android:id =\"@+id/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 186, 37)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("_create\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t android:text=\"Save\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t android:layout_height=\"wrap_content\"/>\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</LinearLayout>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</ScrollView>");  //$NON-NLS-1$        
    }
}
