package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_create_entityjava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_create_entityjava() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_java_format_1_1 = new TagInfo("java:format", //$NON-NLS-1$
            1, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_26_2 = new TagInfo("c:if", //$NON-NLS-1$
            26, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_27_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            27, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_28_5 = new TagInfo("c:choose", //$NON-NLS-1$
            28, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_29_6 = new TagInfo("c:when", //$NON-NLS-1$
            29, 6,
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
    private static final TagInfo _td_c_when_35_6 = new TagInfo("c:when", //$NON-NLS-1$
            35, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_38_6 = new TagInfo("c:when", //$NON-NLS-1$
            38, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_41_6 = new TagInfo("c:when", //$NON-NLS-1$
            41, 6,
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
    private static final TagInfo _td_c_when_47_6 = new TagInfo("c:when", //$NON-NLS-1$
            47, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_54_2 = new TagInfo("c:if", //$NON-NLS-1$
            54, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_55_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            55, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_56_5 = new TagInfo("c:choose", //$NON-NLS-1$
            56, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_57_6 = new TagInfo("c:when", //$NON-NLS-1$
            57, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_60_6 = new TagInfo("c:when", //$NON-NLS-1$
            60, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_63_6 = new TagInfo("c:when", //$NON-NLS-1$
            63, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_66_6 = new TagInfo("c:when", //$NON-NLS-1$
            66, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_69_6 = new TagInfo("c:when", //$NON-NLS-1$
            69, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_72_6 = new TagInfo("c:when", //$NON-NLS-1$
            72, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_75_6 = new TagInfo("c:when", //$NON-NLS-1$
            75, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_82_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            82, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_83_5 = new TagInfo("c:choose", //$NON-NLS-1$
            83, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_84_6 = new TagInfo("c:when", //$NON-NLS-1$
            84, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_87_6 = new TagInfo("c:when", //$NON-NLS-1$
            87, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_90_6 = new TagInfo("c:when", //$NON-NLS-1$
            90, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_93_6 = new TagInfo("c:when", //$NON-NLS-1$
            93, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_96_6 = new TagInfo("c:when", //$NON-NLS-1$
            96, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_99_6 = new TagInfo("c:when", //$NON-NLS-1$
            99, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_102_6 = new TagInfo("c:when", //$NON-NLS-1$
            102, 6,
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
            out.write("import info.yalamanchili.android.crud.AbstractCreateActivity;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import info.yalamanchili.android.views.Field;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("import org.json.JSONObject;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("import ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 9, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".R;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("public class Create");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 11, 20)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" extends AbstractCreateActivity {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected int contentViewId() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn R.layout.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 15, 19)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_create;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected int createButtonId() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn R.id.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 20, 15)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_create;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected void assignFields() {");  //$NON-NLS-1$        
            out.write(NL);         
            // process parent class level 2 attributes
            RuntimeTagElement _jettag_c_if_26_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_26_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_26_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_26_2.setTagInfo(_td_c_if_26_2);
            _jettag_c_if_26_2.doStart(context, out);
            while (_jettag_c_if_26_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_27_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_27_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_27_5.setRuntimeParent(_jettag_c_if_26_2);
                _jettag_c_iterate_27_5.setTagInfo(_td_c_iterate_27_5);
                _jettag_c_iterate_27_5.doStart(context, out);
                while (_jettag_c_iterate_27_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_28_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_28_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_28_5.setRuntimeParent(_jettag_c_iterate_27_5);
                    _jettag_c_choose_28_5.setTagInfo(_td_c_choose_28_5);
                    _jettag_c_choose_28_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_28_5_saved_out = out;
                    while (_jettag_c_choose_28_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_when_29_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_29_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_29_6.setRuntimeParent(_jettag_c_choose_28_5);
                        _jettag_c_when_29_6.setTagInfo(_td_c_when_29_6);
                        _jettag_c_when_29_6.doStart(context, out);
                        JET2Writer _jettag_c_when_29_6_saved_out = out;
                        while (_jettag_c_when_29_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 30, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 30, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 30, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 30, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.STRING_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_29_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_29_6_saved_out;
                        _jettag_c_when_29_6.doEnd();
                        RuntimeTagElement _jettag_c_when_32_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_32_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_32_6.setRuntimeParent(_jettag_c_choose_28_5);
                        _jettag_c_when_32_6.setTagInfo(_td_c_when_32_6);
                        _jettag_c_when_32_6.doStart(context, out);
                        JET2Writer _jettag_c_when_32_6_saved_out = out;
                        while (_jettag_c_when_32_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 33, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 33, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 33, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 33, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.NUMERIC_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_32_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_32_6_saved_out;
                        _jettag_c_when_32_6.doEnd();
                        RuntimeTagElement _jettag_c_when_35_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_35_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_35_6.setRuntimeParent(_jettag_c_choose_28_5);
                        _jettag_c_when_35_6.setTagInfo(_td_c_when_35_6);
                        _jettag_c_when_35_6.doStart(context, out);
                        JET2Writer _jettag_c_when_35_6_saved_out = out;
                        while (_jettag_c_when_35_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 36, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 36, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 36, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 36, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.DATE_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_35_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_35_6_saved_out;
                        _jettag_c_when_35_6.doEnd();
                        RuntimeTagElement _jettag_c_when_38_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_38_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_38_6.setRuntimeParent(_jettag_c_choose_28_5);
                        _jettag_c_when_38_6.setTagInfo(_td_c_when_38_6);
                        _jettag_c_when_38_6.doStart(context, out);
                        JET2Writer _jettag_c_when_38_6_saved_out = out;
                        while (_jettag_c_when_38_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 39, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 39, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 39, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 39, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.BOOLEAN_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_38_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_38_6_saved_out;
                        _jettag_c_when_38_6.doEnd();
                        RuntimeTagElement _jettag_c_when_41_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_41_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_41_6.setRuntimeParent(_jettag_c_choose_28_5);
                        _jettag_c_when_41_6.setTagInfo(_td_c_when_41_6);
                        _jettag_c_when_41_6.doStart(context, out);
                        JET2Writer _jettag_c_when_41_6_saved_out = out;
                        while (_jettag_c_when_41_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 42, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 42, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 42, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 42, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.NUMERIC_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_41_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_41_6_saved_out;
                        _jettag_c_when_41_6.doEnd();
                        RuntimeTagElement _jettag_c_when_44_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_44_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_44_6.setRuntimeParent(_jettag_c_choose_28_5);
                        _jettag_c_when_44_6.setTagInfo(_td_c_when_44_6);
                        _jettag_c_when_44_6.doStart(context, out);
                        JET2Writer _jettag_c_when_44_6_saved_out = out;
                        while (_jettag_c_when_44_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 45, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 45, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 45, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 45, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.DECIMAL_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_44_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_44_6_saved_out;
                        _jettag_c_when_44_6.doEnd();
                        RuntimeTagElement _jettag_c_when_47_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_47_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_47_6.setRuntimeParent(_jettag_c_choose_28_5);
                        _jettag_c_when_47_6.setTagInfo(_td_c_when_47_6);
                        _jettag_c_when_47_6.doStart(context, out);
                        JET2Writer _jettag_c_when_47_6_saved_out = out;
                        while (_jettag_c_when_47_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 48, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 48, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 48, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 48, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.CURRENCY_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_47_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_47_6_saved_out;
                        _jettag_c_when_47_6.doEnd();
                        _jettag_c_choose_28_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_28_5_saved_out;
                    _jettag_c_choose_28_5.doEnd();
                    _jettag_c_iterate_27_5.handleBodyContent(out);
                }
                _jettag_c_iterate_27_5.doEnd();
                _jettag_c_if_26_2.handleBodyContent(out);
            }
            _jettag_c_if_26_2.doEnd();
            // process parent class level 1 attributes
            RuntimeTagElement _jettag_c_if_54_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_54_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_54_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_54_2.setTagInfo(_td_c_if_54_2);
            _jettag_c_if_54_2.doStart(context, out);
            while (_jettag_c_if_54_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_55_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_55_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_55_5.setRuntimeParent(_jettag_c_if_54_2);
                _jettag_c_iterate_55_5.setTagInfo(_td_c_iterate_55_5);
                _jettag_c_iterate_55_5.doStart(context, out);
                while (_jettag_c_iterate_55_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_56_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_56_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_56_5.setRuntimeParent(_jettag_c_iterate_55_5);
                    _jettag_c_choose_56_5.setTagInfo(_td_c_choose_56_5);
                    _jettag_c_choose_56_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_56_5_saved_out = out;
                    while (_jettag_c_choose_56_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_when_57_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_57_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_57_6.setRuntimeParent(_jettag_c_choose_56_5);
                        _jettag_c_when_57_6.setTagInfo(_td_c_when_57_6);
                        _jettag_c_when_57_6.doStart(context, out);
                        JET2Writer _jettag_c_when_57_6_saved_out = out;
                        while (_jettag_c_when_57_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 58, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 58, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 58, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 58, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.STRING_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_57_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_57_6_saved_out;
                        _jettag_c_when_57_6.doEnd();
                        RuntimeTagElement _jettag_c_when_60_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_60_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_60_6.setRuntimeParent(_jettag_c_choose_56_5);
                        _jettag_c_when_60_6.setTagInfo(_td_c_when_60_6);
                        _jettag_c_when_60_6.doStart(context, out);
                        JET2Writer _jettag_c_when_60_6_saved_out = out;
                        while (_jettag_c_when_60_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 61, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 61, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 61, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 61, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.NUMERIC_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_60_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_60_6_saved_out;
                        _jettag_c_when_60_6.doEnd();
                        RuntimeTagElement _jettag_c_when_63_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_63_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_63_6.setRuntimeParent(_jettag_c_choose_56_5);
                        _jettag_c_when_63_6.setTagInfo(_td_c_when_63_6);
                        _jettag_c_when_63_6.doStart(context, out);
                        JET2Writer _jettag_c_when_63_6_saved_out = out;
                        while (_jettag_c_when_63_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 64, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 64, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 64, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 64, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.DATE_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_63_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_63_6_saved_out;
                        _jettag_c_when_63_6.doEnd();
                        RuntimeTagElement _jettag_c_when_66_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_66_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_66_6.setRuntimeParent(_jettag_c_choose_56_5);
                        _jettag_c_when_66_6.setTagInfo(_td_c_when_66_6);
                        _jettag_c_when_66_6.doStart(context, out);
                        JET2Writer _jettag_c_when_66_6_saved_out = out;
                        while (_jettag_c_when_66_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 67, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 67, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 67, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 67, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.BOOLEAN_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_66_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_66_6_saved_out;
                        _jettag_c_when_66_6.doEnd();
                        RuntimeTagElement _jettag_c_when_69_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_69_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_69_6.setRuntimeParent(_jettag_c_choose_56_5);
                        _jettag_c_when_69_6.setTagInfo(_td_c_when_69_6);
                        _jettag_c_when_69_6.doStart(context, out);
                        JET2Writer _jettag_c_when_69_6_saved_out = out;
                        while (_jettag_c_when_69_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 70, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 70, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 70, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 70, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.NUMERIC_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_69_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_69_6_saved_out;
                        _jettag_c_when_69_6.doEnd();
                        RuntimeTagElement _jettag_c_when_72_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_72_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_72_6.setRuntimeParent(_jettag_c_choose_56_5);
                        _jettag_c_when_72_6.setTagInfo(_td_c_when_72_6);
                        _jettag_c_when_72_6.doStart(context, out);
                        JET2Writer _jettag_c_when_72_6_saved_out = out;
                        while (_jettag_c_when_72_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 73, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 73, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 73, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 73, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.DECIMAL_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_72_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_72_6_saved_out;
                        _jettag_c_when_72_6.doEnd();
                        RuntimeTagElement _jettag_c_when_75_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_75_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_75_6.setRuntimeParent(_jettag_c_choose_56_5);
                        _jettag_c_when_75_6.setTagInfo(_td_c_when_75_6);
                        _jettag_c_when_75_6.doStart(context, out);
                        JET2Writer _jettag_c_when_75_6_saved_out = out;
                        while (_jettag_c_when_75_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 76, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 76, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 76, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 76, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.CURRENCY_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_75_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_75_6_saved_out;
                        _jettag_c_when_75_6.doEnd();
                        _jettag_c_choose_56_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_56_5_saved_out;
                    _jettag_c_choose_56_5.doEnd();
                    _jettag_c_iterate_55_5.handleBodyContent(out);
                }
                _jettag_c_iterate_55_5.doEnd();
                _jettag_c_if_54_2.handleBodyContent(out);
            }
            _jettag_c_if_54_2.doEnd();
            // process parent class level 0 attributes
            RuntimeTagElement _jettag_c_iterate_82_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_82_5); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_82_5.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_iterate_82_5.setTagInfo(_td_c_iterate_82_5);
            _jettag_c_iterate_82_5.doStart(context, out);
            while (_jettag_c_iterate_82_5.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_83_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_83_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_83_5.setRuntimeParent(_jettag_c_iterate_82_5);
                _jettag_c_choose_83_5.setTagInfo(_td_c_choose_83_5);
                _jettag_c_choose_83_5.doStart(context, out);
                JET2Writer _jettag_c_choose_83_5_saved_out = out;
                while (_jettag_c_choose_83_5.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_when_84_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_84_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_84_6.setRuntimeParent(_jettag_c_choose_83_5);
                    _jettag_c_when_84_6.setTagInfo(_td_c_when_84_6);
                    _jettag_c_when_84_6.doStart(context, out);
                    JET2Writer _jettag_c_when_84_6_saved_out = out;
                    while (_jettag_c_when_84_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 85, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 85, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(", \"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 85, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\",\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 85, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\", Field.STRING_FIELD);");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_84_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_84_6_saved_out;
                    _jettag_c_when_84_6.doEnd();
                    RuntimeTagElement _jettag_c_when_87_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_87_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_87_6.setRuntimeParent(_jettag_c_choose_83_5);
                    _jettag_c_when_87_6.setTagInfo(_td_c_when_87_6);
                    _jettag_c_when_87_6.doStart(context, out);
                    JET2Writer _jettag_c_when_87_6_saved_out = out;
                    while (_jettag_c_when_87_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 88, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 88, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(", \"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 88, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\",\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 88, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\", Field.NUMERIC_FIELD);");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_87_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_87_6_saved_out;
                    _jettag_c_when_87_6.doEnd();
                    RuntimeTagElement _jettag_c_when_90_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_90_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_90_6.setRuntimeParent(_jettag_c_choose_83_5);
                    _jettag_c_when_90_6.setTagInfo(_td_c_when_90_6);
                    _jettag_c_when_90_6.doStart(context, out);
                    JET2Writer _jettag_c_when_90_6_saved_out = out;
                    while (_jettag_c_when_90_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 91, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 91, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(", \"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 91, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\",\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 91, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\", Field.DATE_FIELD);");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_90_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_90_6_saved_out;
                    _jettag_c_when_90_6.doEnd();
                    RuntimeTagElement _jettag_c_when_93_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_93_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_93_6.setRuntimeParent(_jettag_c_choose_83_5);
                    _jettag_c_when_93_6.setTagInfo(_td_c_when_93_6);
                    _jettag_c_when_93_6.doStart(context, out);
                    JET2Writer _jettag_c_when_93_6_saved_out = out;
                    while (_jettag_c_when_93_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 94, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 94, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(", \"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 94, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\",\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 94, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\", Field.BOOLEAN_FIELD);");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_93_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_93_6_saved_out;
                    _jettag_c_when_93_6.doEnd();
                    RuntimeTagElement _jettag_c_when_96_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_96_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_96_6.setRuntimeParent(_jettag_c_choose_83_5);
                    _jettag_c_when_96_6.setTagInfo(_td_c_when_96_6);
                    _jettag_c_when_96_6.doStart(context, out);
                    JET2Writer _jettag_c_when_96_6_saved_out = out;
                    while (_jettag_c_when_96_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 97, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 97, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(", \"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 97, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\",\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 97, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\", Field.NUMERIC_FIELD);");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_96_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_96_6_saved_out;
                    _jettag_c_when_96_6.doEnd();
                    RuntimeTagElement _jettag_c_when_99_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_99_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_99_6.setRuntimeParent(_jettag_c_choose_83_5);
                    _jettag_c_when_99_6.setTagInfo(_td_c_when_99_6);
                    _jettag_c_when_99_6.doStart(context, out);
                    JET2Writer _jettag_c_when_99_6_saved_out = out;
                    while (_jettag_c_when_99_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 100, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 100, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(", \"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 100, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\",\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 100, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\", Field.DECIMAL_FIELD);");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_99_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_99_6_saved_out;
                    _jettag_c_when_99_6.doEnd();
                    RuntimeTagElement _jettag_c_when_102_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_102_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_102_6.setRuntimeParent(_jettag_c_choose_83_5);
                    _jettag_c_when_102_6.setTagInfo(_td_c_when_102_6);
                    _jettag_c_when_102_6.doStart(context, out);
                    JET2Writer _jettag_c_when_102_6_saved_out = out;
                    while (_jettag_c_when_102_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 103, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 103, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(", \"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 103, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\",\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 103, 120)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\", Field.CURRENCY_FIELD);");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_102_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_102_6_saved_out;
                    _jettag_c_when_102_6.doEnd();
                    _jettag_c_choose_83_5.handleBodyContent(out);
                }
                out = _jettag_c_choose_83_5_saved_out;
                _jettag_c_choose_83_5.doEnd();
                _jettag_c_iterate_82_5.handleBodyContent(out);
            }
            _jettag_c_iterate_82_5.doEnd();
            out.write("\t}\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected int appTitleBarId() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn R.layout.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 111, 19)); //$NON-NLS-1$ //$NON-NLS-2$
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
            out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 116, 15)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_title_text;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected String titleText() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn \"Create ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 121, 18)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" Activity\";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected void preCreate() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tentity = new JSONObject();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected String createURL() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 131, 10)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Welcome.baseURL + \"");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 131, 55)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("/create\";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected String entityName() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn \"");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 136, 11)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("\";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("}");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_java_format_1_1.handleBodyContent(out);
        }
        out = _jettag_java_format_1_1_saved_out;
        _jettag_java_format_1_1.doEnd();
    }
}
