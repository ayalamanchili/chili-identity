package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_entity_createxml implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$

    public _jet_entity_createxml() {
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
    private static final TagInfo _td_c_when_27_6 = new TagInfo("c:when", //$NON-NLS-1$
            27, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_34_6 = new TagInfo("c:when", //$NON-NLS-1$
            34, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_41_6 = new TagInfo("c:when", //$NON-NLS-1$
            41, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_48_6 = new TagInfo("c:when", //$NON-NLS-1$
            48, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_55_6 = new TagInfo("c:when", //$NON-NLS-1$
            55, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_62_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            62, 7,
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
    private static final TagInfo _td_c_when_85_6 = new TagInfo("c:when", //$NON-NLS-1$
            85, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_92_6 = new TagInfo("c:when", //$NON-NLS-1$
            92, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_99_6 = new TagInfo("c:when", //$NON-NLS-1$
            99, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_106_6 = new TagInfo("c:when", //$NON-NLS-1$
            106, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_113_6 = new TagInfo("c:when", //$NON-NLS-1$
            113, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_120_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            120, 7,
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
    private static final TagInfo _td_c_when_142_6 = new TagInfo("c:when", //$NON-NLS-1$
            142, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_149_6 = new TagInfo("c:when", //$NON-NLS-1$
            149, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_156_6 = new TagInfo("c:when", //$NON-NLS-1$
            156, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_163_6 = new TagInfo("c:when", //$NON-NLS-1$
            163, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_170_6 = new TagInfo("c:when", //$NON-NLS-1$
            170, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_177_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            177, 7,
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
                        out.write("\t\t\t\t\t <TextView android:text=\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 19, 31)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\" android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\tandroid:layout_height=\"wrap_content\">");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t</TextView>");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        <Button android:id =\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 22, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 22, 73)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t android:text=\"date\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t android:layout_height=\"wrap_content\"/>");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_18_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_18_6_saved_out;
                    _jettag_c_when_18_6.doEnd();
                    RuntimeTagElement _jettag_c_when_27_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_27_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_27_6.setRuntimeParent(_jettag_c_choose_17_5);
                    _jettag_c_when_27_6.setTagInfo(_td_c_when_27_6);
                    _jettag_c_when_27_6.doStart(context, out);
                    JET2Writer _jettag_c_when_27_6_saved_out = out;
                    while (_jettag_c_when_27_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t        <info.yalamanchili.android.views.StringField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 29, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 29, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_27_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_27_6_saved_out;
                    _jettag_c_when_27_6.doEnd();
                    RuntimeTagElement _jettag_c_when_34_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_34_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_34_6.setRuntimeParent(_jettag_c_choose_17_5);
                    _jettag_c_when_34_6.setTagInfo(_td_c_when_34_6);
                    _jettag_c_when_34_6.doStart(context, out);
                    JET2Writer _jettag_c_when_34_6_saved_out = out;
                    while (_jettag_c_when_34_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t        <info.yalamanchili.android.views.NumericField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 36, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 36, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_34_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_34_6_saved_out;
                    _jettag_c_when_34_6.doEnd();
                    RuntimeTagElement _jettag_c_when_41_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_41_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_41_6.setRuntimeParent(_jettag_c_choose_17_5);
                    _jettag_c_when_41_6.setTagInfo(_td_c_when_41_6);
                    _jettag_c_when_41_6.doStart(context, out);
                    JET2Writer _jettag_c_when_41_6_saved_out = out;
                    while (_jettag_c_when_41_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t        <info.yalamanchili.android.views.NumericField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 43, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 43, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_41_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_41_6_saved_out;
                    _jettag_c_when_41_6.doEnd();
                    RuntimeTagElement _jettag_c_when_48_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_48_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_48_6.setRuntimeParent(_jettag_c_choose_17_5);
                    _jettag_c_when_48_6.setTagInfo(_td_c_when_48_6);
                    _jettag_c_when_48_6.doStart(context, out);
                    JET2Writer _jettag_c_when_48_6_saved_out = out;
                    while (_jettag_c_when_48_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t        <info.yalamanchili.android.views.DecimalField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 50, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 50, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_48_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_48_6_saved_out;
                    _jettag_c_when_48_6.doEnd();
                    RuntimeTagElement _jettag_c_when_55_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_55_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_55_6.setRuntimeParent(_jettag_c_choose_17_5);
                    _jettag_c_when_55_6.setTagInfo(_td_c_when_55_6);
                    _jettag_c_when_55_6.doStart(context, out);
                    JET2Writer _jettag_c_when_55_6_saved_out = out;
                    while (_jettag_c_when_55_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t        <info.yalamanchili.android.views.BooleanField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 57, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 57, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_55_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_55_6_saved_out;
                    _jettag_c_when_55_6.doEnd();
                    RuntimeTagElement _jettag_c_otherwise_62_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_62_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_otherwise_62_7.setRuntimeParent(_jettag_c_choose_17_5);
                    _jettag_c_otherwise_62_7.setTagInfo(_td_c_otherwise_62_7);
                    _jettag_c_otherwise_62_7.doStart(context, out);
                    JET2Writer _jettag_c_otherwise_62_7_saved_out = out;
                    while (_jettag_c_otherwise_62_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.StringField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 64, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 64, 65)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_otherwise_62_7.handleBodyContent(out);
                    }
                    out = _jettag_c_otherwise_62_7_saved_out;
                    _jettag_c_otherwise_62_7.doEnd();
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
                        out.write("\t\t\t\t\t <TextView android:text=\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 77, 31)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\" android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\tandroid:layout_height=\"wrap_content\">");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t</TextView>");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        <Button android:id =\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 80, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 80, 73)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t android:text=\"date\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t android:layout_height=\"wrap_content\"/>");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_76_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_76_6_saved_out;
                    _jettag_c_when_76_6.doEnd();
                    RuntimeTagElement _jettag_c_when_85_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_85_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_85_6.setRuntimeParent(_jettag_c_choose_75_5);
                    _jettag_c_when_85_6.setTagInfo(_td_c_when_85_6);
                    _jettag_c_when_85_6.doStart(context, out);
                    JET2Writer _jettag_c_when_85_6_saved_out = out;
                    while (_jettag_c_when_85_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t        <info.yalamanchili.android.views.StringField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 87, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 87, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_85_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_85_6_saved_out;
                    _jettag_c_when_85_6.doEnd();
                    RuntimeTagElement _jettag_c_when_92_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_92_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_92_6.setRuntimeParent(_jettag_c_choose_75_5);
                    _jettag_c_when_92_6.setTagInfo(_td_c_when_92_6);
                    _jettag_c_when_92_6.doStart(context, out);
                    JET2Writer _jettag_c_when_92_6_saved_out = out;
                    while (_jettag_c_when_92_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t        <info.yalamanchili.android.views.NumericField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 94, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 94, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_92_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_92_6_saved_out;
                    _jettag_c_when_92_6.doEnd();
                    RuntimeTagElement _jettag_c_when_99_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_99_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_99_6.setRuntimeParent(_jettag_c_choose_75_5);
                    _jettag_c_when_99_6.setTagInfo(_td_c_when_99_6);
                    _jettag_c_when_99_6.doStart(context, out);
                    JET2Writer _jettag_c_when_99_6_saved_out = out;
                    while (_jettag_c_when_99_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t        <info.yalamanchili.android.views.NumericField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 101, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 101, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_99_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_99_6_saved_out;
                    _jettag_c_when_99_6.doEnd();
                    RuntimeTagElement _jettag_c_when_106_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_106_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_106_6.setRuntimeParent(_jettag_c_choose_75_5);
                    _jettag_c_when_106_6.setTagInfo(_td_c_when_106_6);
                    _jettag_c_when_106_6.doStart(context, out);
                    JET2Writer _jettag_c_when_106_6_saved_out = out;
                    while (_jettag_c_when_106_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t        <info.yalamanchili.android.views.DecimalField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 108, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 108, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_106_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_106_6_saved_out;
                    _jettag_c_when_106_6.doEnd();
                    RuntimeTagElement _jettag_c_when_113_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_113_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_113_6.setRuntimeParent(_jettag_c_choose_75_5);
                    _jettag_c_when_113_6.setTagInfo(_td_c_when_113_6);
                    _jettag_c_when_113_6.doStart(context, out);
                    JET2Writer _jettag_c_when_113_6_saved_out = out;
                    while (_jettag_c_when_113_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t        <info.yalamanchili.android.views.BooleanField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 115, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 115, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_113_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_113_6_saved_out;
                    _jettag_c_when_113_6.doEnd();
                    RuntimeTagElement _jettag_c_otherwise_120_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_120_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_otherwise_120_7.setRuntimeParent(_jettag_c_choose_75_5);
                    _jettag_c_otherwise_120_7.setTagInfo(_td_c_otherwise_120_7);
                    _jettag_c_otherwise_120_7.doStart(context, out);
                    JET2Writer _jettag_c_otherwise_120_7_saved_out = out;
                    while (_jettag_c_otherwise_120_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t        <info.yalamanchili.android.views.StringField");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 122, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 122, 65)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_otherwise_120_7.handleBodyContent(out);
                    }
                    out = _jettag_c_otherwise_120_7_saved_out;
                    _jettag_c_otherwise_120_7.doEnd();
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
                    out.write("\t\t\t\t\t <TextView android:text=\"");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 134, 31)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\" android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t\tandroid:layout_height=\"wrap_content\">");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t</TextView>");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        <Button android:id =\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 137, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_create_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 137, 73)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t android:text=\"date\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t android:layout_height=\"wrap_content\"/>");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_133_6.handleBodyContent(out);
                }
                out = _jettag_c_when_133_6_saved_out;
                _jettag_c_when_133_6.doEnd();
                RuntimeTagElement _jettag_c_when_142_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_142_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_142_6.setRuntimeParent(_jettag_c_choose_132_5);
                _jettag_c_when_142_6.setTagInfo(_td_c_when_142_6);
                _jettag_c_when_142_6.doStart(context, out);
                JET2Writer _jettag_c_when_142_6_saved_out = out;
                while (_jettag_c_when_142_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t        <info.yalamanchili.android.views.StringField");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 144, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_create_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 144, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_142_6.handleBodyContent(out);
                }
                out = _jettag_c_when_142_6_saved_out;
                _jettag_c_when_142_6.doEnd();
                RuntimeTagElement _jettag_c_when_149_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_149_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_149_6.setRuntimeParent(_jettag_c_choose_132_5);
                _jettag_c_when_149_6.setTagInfo(_td_c_when_149_6);
                _jettag_c_when_149_6.doStart(context, out);
                JET2Writer _jettag_c_when_149_6_saved_out = out;
                while (_jettag_c_when_149_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t        <info.yalamanchili.android.views.NumericField");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 151, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_create_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 151, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_149_6.handleBodyContent(out);
                }
                out = _jettag_c_when_149_6_saved_out;
                _jettag_c_when_149_6.doEnd();
                RuntimeTagElement _jettag_c_when_156_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_156_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_156_6.setRuntimeParent(_jettag_c_choose_132_5);
                _jettag_c_when_156_6.setTagInfo(_td_c_when_156_6);
                _jettag_c_when_156_6.doStart(context, out);
                JET2Writer _jettag_c_when_156_6_saved_out = out;
                while (_jettag_c_when_156_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t        <info.yalamanchili.android.views.NumericField");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 158, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_create_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 158, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_156_6.handleBodyContent(out);
                }
                out = _jettag_c_when_156_6_saved_out;
                _jettag_c_when_156_6.doEnd();
                RuntimeTagElement _jettag_c_when_163_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_163_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_163_6.setRuntimeParent(_jettag_c_choose_132_5);
                _jettag_c_when_163_6.setTagInfo(_td_c_when_163_6);
                _jettag_c_when_163_6.doStart(context, out);
                JET2Writer _jettag_c_when_163_6_saved_out = out;
                while (_jettag_c_when_163_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t        <info.yalamanchili.android.views.DecimalField");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 165, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_create_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 165, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_163_6.handleBodyContent(out);
                }
                out = _jettag_c_when_163_6_saved_out;
                _jettag_c_when_163_6.doEnd();
                RuntimeTagElement _jettag_c_when_170_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_170_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_170_6.setRuntimeParent(_jettag_c_choose_132_5);
                _jettag_c_when_170_6.setTagInfo(_td_c_when_170_6);
                _jettag_c_when_170_6.doStart(context, out);
                JET2Writer _jettag_c_when_170_6_saved_out = out;
                while (_jettag_c_when_170_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t        <info.yalamanchili.android.views.BooleanField");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 172, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_create_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 172, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t        />\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_170_6.handleBodyContent(out);
                }
                out = _jettag_c_when_170_6_saved_out;
                _jettag_c_when_170_6.doEnd();
                RuntimeTagElement _jettag_c_otherwise_177_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_177_7); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_otherwise_177_7.setRuntimeParent(_jettag_c_choose_132_5);
                _jettag_c_otherwise_177_7.setTagInfo(_td_c_otherwise_177_7);
                _jettag_c_otherwise_177_7.doStart(context, out);
                JET2Writer _jettag_c_otherwise_177_7_saved_out = out;
                while (_jettag_c_otherwise_177_7.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t\t        <info.yalamanchili.android.views.StringField");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:id=\"@+id/");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 179, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_create_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 179, 65)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t        />\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_otherwise_177_7.handleBodyContent(out);
                }
                out = _jettag_c_otherwise_177_7_saved_out;
                _jettag_c_otherwise_177_7.doEnd();
                out.write("\t\t \t\t");  //$NON-NLS-1$        
                _jettag_c_choose_132_5.handleBodyContent(out);
            }
            out = _jettag_c_choose_132_5_saved_out;
            _jettag_c_choose_132_5.doEnd();
            out.write("\t\t\t");  //$NON-NLS-1$        
            _jettag_c_iterate_131_4.handleBodyContent(out);
        }
        _jettag_c_iterate_131_4.doEnd();
        out.write(NL);         
        out.write("\t\t        <Button android:id =\"@+id/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 185, 37)); //$NON-NLS-1$ //$NON-NLS-2$
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
