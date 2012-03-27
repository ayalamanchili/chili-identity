package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_update_entityjava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_update_entityjava() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_java_format_1_1 = new TagInfo("java:format", //$NON-NLS-1$
            1, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_24_2 = new TagInfo("c:if", //$NON-NLS-1$
            24, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_25_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            25, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_26_5 = new TagInfo("c:choose", //$NON-NLS-1$
            26, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_27_6 = new TagInfo("c:when", //$NON-NLS-1$
            27, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_30_6 = new TagInfo("c:when", //$NON-NLS-1$
            30, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_33_6 = new TagInfo("c:when", //$NON-NLS-1$
            33, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_36_6 = new TagInfo("c:when", //$NON-NLS-1$
            36, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_39_6 = new TagInfo("c:when", //$NON-NLS-1$
            39, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_42_6 = new TagInfo("c:when", //$NON-NLS-1$
            42, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_45_6 = new TagInfo("c:when", //$NON-NLS-1$
            45, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_52_2 = new TagInfo("c:if", //$NON-NLS-1$
            52, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_53_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            53, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_54_5 = new TagInfo("c:choose", //$NON-NLS-1$
            54, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_55_6 = new TagInfo("c:when", //$NON-NLS-1$
            55, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_58_6 = new TagInfo("c:when", //$NON-NLS-1$
            58, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_61_6 = new TagInfo("c:when", //$NON-NLS-1$
            61, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_64_6 = new TagInfo("c:when", //$NON-NLS-1$
            64, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_67_6 = new TagInfo("c:when", //$NON-NLS-1$
            67, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_70_6 = new TagInfo("c:when", //$NON-NLS-1$
            70, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_73_6 = new TagInfo("c:when", //$NON-NLS-1$
            73, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_80_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            80, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_81_5 = new TagInfo("c:choose", //$NON-NLS-1$
            81, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_82_6 = new TagInfo("c:when", //$NON-NLS-1$
            82, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_85_6 = new TagInfo("c:when", //$NON-NLS-1$
            85, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_88_6 = new TagInfo("c:when", //$NON-NLS-1$
            88, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_91_6 = new TagInfo("c:when", //$NON-NLS-1$
            91, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_94_6 = new TagInfo("c:when", //$NON-NLS-1$
            94, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_97_6 = new TagInfo("c:when", //$NON-NLS-1$
            97, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_100_6 = new TagInfo("c:when", //$NON-NLS-1$
            100, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        RuntimeTagElement _jettag_java_format_1_1 = context.getTagFactory().createRuntimeTag(_jetns_java, "format", "java:format", _td_java_format_1_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_java_format_1_1.setRuntimeParent(null);
        _jettag_java_format_1_1.setTagInfo(_td_java_format_1_1);
        _jettag_java_format_1_1.doStart(context, out);
        JET2Writer _jettag_java_format_1_1_saved_out = out;
        while (_jettag_java_format_1_1.okToProcessBody()) {
            out = out.newNestedContentWriter();
            out.write(NL);         
            out.write("package ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 2, 9)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".android.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$package/@name}", 2, 29)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 2, 47)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 3, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".android.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 3, 28)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Welcome;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 4, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".R;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import info.yalamanchili.android.crud.AbstractUpdateActivity;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import info.yalamanchili.android.views.Field;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write(NL);         
            out.write("public class Update");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 9, 20)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" extends AbstractUpdateActivity {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected int contentViewId() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn R.layout.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 13, 19)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_create;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected int updateButtonId() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn R.id.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 18, 15)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_create;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected void assignFields() {");  //$NON-NLS-1$        
            out.write(NL);         
            // process parent class level 2 attributes
            RuntimeTagElement _jettag_c_if_24_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_24_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_24_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_24_2.setTagInfo(_td_c_if_24_2);
            _jettag_c_if_24_2.doStart(context, out);
            while (_jettag_c_if_24_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_25_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_25_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_25_5.setRuntimeParent(_jettag_c_if_24_2);
                _jettag_c_iterate_25_5.setTagInfo(_td_c_iterate_25_5);
                _jettag_c_iterate_25_5.doStart(context, out);
                while (_jettag_c_iterate_25_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_26_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_26_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_26_5.setRuntimeParent(_jettag_c_iterate_25_5);
                    _jettag_c_choose_26_5.setTagInfo(_td_c_choose_26_5);
                    _jettag_c_choose_26_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_26_5_saved_out = out;
                    while (_jettag_c_choose_26_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_when_27_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_27_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_27_6.setRuntimeParent(_jettag_c_choose_26_5);
                        _jettag_c_when_27_6.setTagInfo(_td_c_when_27_6);
                        _jettag_c_when_27_6.doStart(context, out);
                        JET2Writer _jettag_c_when_27_6_saved_out = out;
                        while (_jettag_c_when_27_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 28, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 28, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 28, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 28, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.STRING_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_27_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_27_6_saved_out;
                        _jettag_c_when_27_6.doEnd();
                        RuntimeTagElement _jettag_c_when_30_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_30_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_30_6.setRuntimeParent(_jettag_c_choose_26_5);
                        _jettag_c_when_30_6.setTagInfo(_td_c_when_30_6);
                        _jettag_c_when_30_6.doStart(context, out);
                        JET2Writer _jettag_c_when_30_6_saved_out = out;
                        while (_jettag_c_when_30_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 31, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 31, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 31, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 31, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.NUMERIC_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_30_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_30_6_saved_out;
                        _jettag_c_when_30_6.doEnd();
                        RuntimeTagElement _jettag_c_when_33_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_33_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_33_6.setRuntimeParent(_jettag_c_choose_26_5);
                        _jettag_c_when_33_6.setTagInfo(_td_c_when_33_6);
                        _jettag_c_when_33_6.doStart(context, out);
                        JET2Writer _jettag_c_when_33_6_saved_out = out;
                        while (_jettag_c_when_33_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 34, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 34, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 34, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 34, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.DATE_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_33_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_33_6_saved_out;
                        _jettag_c_when_33_6.doEnd();
                        RuntimeTagElement _jettag_c_when_36_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_36_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_36_6.setRuntimeParent(_jettag_c_choose_26_5);
                        _jettag_c_when_36_6.setTagInfo(_td_c_when_36_6);
                        _jettag_c_when_36_6.doStart(context, out);
                        JET2Writer _jettag_c_when_36_6_saved_out = out;
                        while (_jettag_c_when_36_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 37, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 37, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 37, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 37, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.BOOLEAN_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_36_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_36_6_saved_out;
                        _jettag_c_when_36_6.doEnd();
                        RuntimeTagElement _jettag_c_when_39_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_39_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_39_6.setRuntimeParent(_jettag_c_choose_26_5);
                        _jettag_c_when_39_6.setTagInfo(_td_c_when_39_6);
                        _jettag_c_when_39_6.doStart(context, out);
                        JET2Writer _jettag_c_when_39_6_saved_out = out;
                        while (_jettag_c_when_39_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 40, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 40, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 40, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 40, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.NUMERIC_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_39_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_39_6_saved_out;
                        _jettag_c_when_39_6.doEnd();
                        RuntimeTagElement _jettag_c_when_42_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_42_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_42_6.setRuntimeParent(_jettag_c_choose_26_5);
                        _jettag_c_when_42_6.setTagInfo(_td_c_when_42_6);
                        _jettag_c_when_42_6.doStart(context, out);
                        JET2Writer _jettag_c_when_42_6_saved_out = out;
                        while (_jettag_c_when_42_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 43, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 43, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 43, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 43, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.DECIMAL_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_42_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_42_6_saved_out;
                        _jettag_c_when_42_6.doEnd();
                        RuntimeTagElement _jettag_c_when_45_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_45_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_45_6.setRuntimeParent(_jettag_c_choose_26_5);
                        _jettag_c_when_45_6.setTagInfo(_td_c_when_45_6);
                        _jettag_c_when_45_6.doStart(context, out);
                        JET2Writer _jettag_c_when_45_6_saved_out = out;
                        while (_jettag_c_when_45_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 46, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 46, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 46, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 46, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.CURRENCY_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_45_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_45_6_saved_out;
                        _jettag_c_when_45_6.doEnd();
                        _jettag_c_choose_26_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_26_5_saved_out;
                    _jettag_c_choose_26_5.doEnd();
                    _jettag_c_iterate_25_5.handleBodyContent(out);
                }
                _jettag_c_iterate_25_5.doEnd();
                _jettag_c_if_24_2.handleBodyContent(out);
            }
            _jettag_c_if_24_2.doEnd();
            // process parent class level 1 attributes
            RuntimeTagElement _jettag_c_if_52_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_52_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_52_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_52_2.setTagInfo(_td_c_if_52_2);
            _jettag_c_if_52_2.doStart(context, out);
            while (_jettag_c_if_52_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_53_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_53_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_53_5.setRuntimeParent(_jettag_c_if_52_2);
                _jettag_c_iterate_53_5.setTagInfo(_td_c_iterate_53_5);
                _jettag_c_iterate_53_5.doStart(context, out);
                while (_jettag_c_iterate_53_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_54_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_54_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_54_5.setRuntimeParent(_jettag_c_iterate_53_5);
                    _jettag_c_choose_54_5.setTagInfo(_td_c_choose_54_5);
                    _jettag_c_choose_54_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_54_5_saved_out = out;
                    while (_jettag_c_choose_54_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_when_55_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_55_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_55_6.setRuntimeParent(_jettag_c_choose_54_5);
                        _jettag_c_when_55_6.setTagInfo(_td_c_when_55_6);
                        _jettag_c_when_55_6.doStart(context, out);
                        JET2Writer _jettag_c_when_55_6_saved_out = out;
                        while (_jettag_c_when_55_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 56, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 56, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 56, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 56, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.STRING_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_55_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_55_6_saved_out;
                        _jettag_c_when_55_6.doEnd();
                        RuntimeTagElement _jettag_c_when_58_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_58_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_58_6.setRuntimeParent(_jettag_c_choose_54_5);
                        _jettag_c_when_58_6.setTagInfo(_td_c_when_58_6);
                        _jettag_c_when_58_6.doStart(context, out);
                        JET2Writer _jettag_c_when_58_6_saved_out = out;
                        while (_jettag_c_when_58_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 59, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 59, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 59, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 59, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.NUMERIC_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_58_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_58_6_saved_out;
                        _jettag_c_when_58_6.doEnd();
                        RuntimeTagElement _jettag_c_when_61_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_61_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_61_6.setRuntimeParent(_jettag_c_choose_54_5);
                        _jettag_c_when_61_6.setTagInfo(_td_c_when_61_6);
                        _jettag_c_when_61_6.doStart(context, out);
                        JET2Writer _jettag_c_when_61_6_saved_out = out;
                        while (_jettag_c_when_61_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 62, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 62, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 62, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 62, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.DATE_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_61_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_61_6_saved_out;
                        _jettag_c_when_61_6.doEnd();
                        RuntimeTagElement _jettag_c_when_64_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_64_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_64_6.setRuntimeParent(_jettag_c_choose_54_5);
                        _jettag_c_when_64_6.setTagInfo(_td_c_when_64_6);
                        _jettag_c_when_64_6.doStart(context, out);
                        JET2Writer _jettag_c_when_64_6_saved_out = out;
                        while (_jettag_c_when_64_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 65, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 65, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 65, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 65, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.BOOLEAN_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_64_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_64_6_saved_out;
                        _jettag_c_when_64_6.doEnd();
                        RuntimeTagElement _jettag_c_when_67_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_67_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_67_6.setRuntimeParent(_jettag_c_choose_54_5);
                        _jettag_c_when_67_6.setTagInfo(_td_c_when_67_6);
                        _jettag_c_when_67_6.doStart(context, out);
                        JET2Writer _jettag_c_when_67_6_saved_out = out;
                        while (_jettag_c_when_67_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 68, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 68, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 68, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 68, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.NUMERIC_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_67_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_67_6_saved_out;
                        _jettag_c_when_67_6.doEnd();
                        RuntimeTagElement _jettag_c_when_70_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_70_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_70_6.setRuntimeParent(_jettag_c_choose_54_5);
                        _jettag_c_when_70_6.setTagInfo(_td_c_when_70_6);
                        _jettag_c_when_70_6.doStart(context, out);
                        JET2Writer _jettag_c_when_70_6_saved_out = out;
                        while (_jettag_c_when_70_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 71, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 71, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 71, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 71, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.DECIMAL_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_70_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_70_6_saved_out;
                        _jettag_c_when_70_6.doEnd();
                        RuntimeTagElement _jettag_c_when_73_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_73_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_73_6.setRuntimeParent(_jettag_c_choose_54_5);
                        _jettag_c_when_73_6.setTagInfo(_td_c_when_73_6);
                        _jettag_c_when_73_6.doStart(context, out);
                        JET2Writer _jettag_c_when_73_6_saved_out = out;
                        while (_jettag_c_when_73_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 74, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 74, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 74, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 74, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.CURRENCY_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_73_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_73_6_saved_out;
                        _jettag_c_when_73_6.doEnd();
                        _jettag_c_choose_54_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_54_5_saved_out;
                    _jettag_c_choose_54_5.doEnd();
                    _jettag_c_iterate_53_5.handleBodyContent(out);
                }
                _jettag_c_iterate_53_5.doEnd();
                _jettag_c_if_52_2.handleBodyContent(out);
            }
            _jettag_c_if_52_2.doEnd();
            // process parent class level 0 attributes
            RuntimeTagElement _jettag_c_iterate_80_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_80_5); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_80_5.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_iterate_80_5.setTagInfo(_td_c_iterate_80_5);
            _jettag_c_iterate_80_5.doStart(context, out);
            while (_jettag_c_iterate_80_5.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_81_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_81_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_81_5.setRuntimeParent(_jettag_c_iterate_80_5);
                _jettag_c_choose_81_5.setTagInfo(_td_c_choose_81_5);
                _jettag_c_choose_81_5.doStart(context, out);
                JET2Writer _jettag_c_choose_81_5_saved_out = out;
                while (_jettag_c_choose_81_5.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_when_82_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_82_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_82_6.setRuntimeParent(_jettag_c_choose_81_5);
                    _jettag_c_when_82_6.setTagInfo(_td_c_when_82_6);
                    _jettag_c_when_82_6.doStart(context, out);
                    JET2Writer _jettag_c_when_82_6_saved_out = out;
                    while (_jettag_c_when_82_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 83, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 83, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(", \"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 83, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\",\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 83, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\", Field.STRING_FIELD);");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_82_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_82_6_saved_out;
                    _jettag_c_when_82_6.doEnd();
                    RuntimeTagElement _jettag_c_when_85_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_85_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_85_6.setRuntimeParent(_jettag_c_choose_81_5);
                    _jettag_c_when_85_6.setTagInfo(_td_c_when_85_6);
                    _jettag_c_when_85_6.doStart(context, out);
                    JET2Writer _jettag_c_when_85_6_saved_out = out;
                    while (_jettag_c_when_85_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 86, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 86, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(", \"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 86, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\",\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 86, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\", Field.NUMERIC_FIELD);");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_85_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_85_6_saved_out;
                    _jettag_c_when_85_6.doEnd();
                    RuntimeTagElement _jettag_c_when_88_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_88_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_88_6.setRuntimeParent(_jettag_c_choose_81_5);
                    _jettag_c_when_88_6.setTagInfo(_td_c_when_88_6);
                    _jettag_c_when_88_6.doStart(context, out);
                    JET2Writer _jettag_c_when_88_6_saved_out = out;
                    while (_jettag_c_when_88_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 89, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 89, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(", \"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 89, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\",\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 89, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\", Field.DATE_FIELD);");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_88_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_88_6_saved_out;
                    _jettag_c_when_88_6.doEnd();
                    RuntimeTagElement _jettag_c_when_91_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_91_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_91_6.setRuntimeParent(_jettag_c_choose_81_5);
                    _jettag_c_when_91_6.setTagInfo(_td_c_when_91_6);
                    _jettag_c_when_91_6.doStart(context, out);
                    JET2Writer _jettag_c_when_91_6_saved_out = out;
                    while (_jettag_c_when_91_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 92, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 92, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(", \"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 92, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\",\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 92, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\", Field.BOOLEAN_FIELD);");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_91_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_91_6_saved_out;
                    _jettag_c_when_91_6.doEnd();
                    RuntimeTagElement _jettag_c_when_94_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_94_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_94_6.setRuntimeParent(_jettag_c_choose_81_5);
                    _jettag_c_when_94_6.setTagInfo(_td_c_when_94_6);
                    _jettag_c_when_94_6.doStart(context, out);
                    JET2Writer _jettag_c_when_94_6_saved_out = out;
                    while (_jettag_c_when_94_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 95, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 95, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(", \"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 95, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\",\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 95, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\", Field.NUMERIC_FIELD);");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_94_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_94_6_saved_out;
                    _jettag_c_when_94_6.doEnd();
                    RuntimeTagElement _jettag_c_when_97_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_97_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_97_6.setRuntimeParent(_jettag_c_choose_81_5);
                    _jettag_c_when_97_6.setTagInfo(_td_c_when_97_6);
                    _jettag_c_when_97_6.doStart(context, out);
                    JET2Writer _jettag_c_when_97_6_saved_out = out;
                    while (_jettag_c_when_97_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 98, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 98, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(", \"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 98, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\",\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 98, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\", Field.DECIMAL_FIELD);");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_97_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_97_6_saved_out;
                    _jettag_c_when_97_6.doEnd();
                    RuntimeTagElement _jettag_c_when_100_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_100_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_100_6.setRuntimeParent(_jettag_c_choose_81_5);
                    _jettag_c_when_100_6.setTagInfo(_td_c_when_100_6);
                    _jettag_c_when_100_6.doStart(context, out);
                    JET2Writer _jettag_c_when_100_6_saved_out = out;
                    while (_jettag_c_when_100_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 101, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 101, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(", \"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 101, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\",\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 101, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\", Field.CURRENCY_FIELD);");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_100_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_100_6_saved_out;
                    _jettag_c_when_100_6.doEnd();
                    _jettag_c_choose_81_5.handleBodyContent(out);
                }
                out = _jettag_c_choose_81_5_saved_out;
                _jettag_c_choose_81_5.doEnd();
                _jettag_c_iterate_80_5.handleBodyContent(out);
            }
            _jettag_c_iterate_80_5.doEnd();
            out.write("\t}\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected int appTitleBarId() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn R.layout.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 109, 19)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_title_bar;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected int appTitleBArTextViewId() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn R.id.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 114, 15)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_title_text;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected String titleText() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn \"Update ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 119, 18)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" Activity\";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected void preUpdate() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected String updateURL() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 129, 10)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Welcome.baseURL + \"");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 129, 55)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("/update\";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected String entityName() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn \"");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 134, 11)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("\";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            _jettag_java_format_1_1.handleBodyContent(out);
        }
        out = _jettag_java_format_1_1_saved_out;
        _jettag_java_format_1_1.doEnd();
    }
}
