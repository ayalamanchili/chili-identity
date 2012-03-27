package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_test_entity_selenium_classjava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_test_entity_selenium_classjava() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_java_format_1_1 = new TagInfo("java:format", //$NON-NLS-1$
            1, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_47_2 = new TagInfo("c:if", //$NON-NLS-1$
            47, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_48_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            48, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_49_5 = new TagInfo("c:choose", //$NON-NLS-1$
            49, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_50_6 = new TagInfo("c:when", //$NON-NLS-1$
            50, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_53_6 = new TagInfo("c:when", //$NON-NLS-1$
            53, 6,
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
    private static final TagInfo _td_c_when_59_6 = new TagInfo("c:when", //$NON-NLS-1$
            59, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_61_6 = new TagInfo("c:when", //$NON-NLS-1$
            61, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_64_6 = new TagInfo("c:when", //$NON-NLS-1$
            64, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_71_2 = new TagInfo("c:if", //$NON-NLS-1$
            71, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_72_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            72, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_73_5 = new TagInfo("c:choose", //$NON-NLS-1$
            73, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_74_6 = new TagInfo("c:when", //$NON-NLS-1$
            74, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_77_6 = new TagInfo("c:when", //$NON-NLS-1$
            77, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_80_6 = new TagInfo("c:when", //$NON-NLS-1$
            80, 6,
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
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_85_6 = new TagInfo("c:when", //$NON-NLS-1$
            85, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_88_6 = new TagInfo("c:when", //$NON-NLS-1$
            88, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_95_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            95, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_96_5 = new TagInfo("c:choose", //$NON-NLS-1$
            96, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_97_6 = new TagInfo("c:when", //$NON-NLS-1$
            97, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_100_6 = new TagInfo("c:when", //$NON-NLS-1$
            100, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_103_6 = new TagInfo("c:when", //$NON-NLS-1$
            103, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_106_6 = new TagInfo("c:when", //$NON-NLS-1$
            106, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_108_6 = new TagInfo("c:when", //$NON-NLS-1$
            108, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_111_6 = new TagInfo("c:when", //$NON-NLS-1$
            111, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
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
            out.write(".test.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$package/@name}", 2, 26)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("import static org.junit.Assert.assertTrue;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 5, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".entity.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 5, 27)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 5, 57)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import java.util.Properties;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("import info.yalamanchili.commons.PropertyFileLoader;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import org.junit.AfterClass;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import org.junit.BeforeClass;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import org.junit.Test;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import org.junit.Ignore;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("import com.thoughtworks.selenium.DefaultSelenium;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("public class ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 16, 14)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Test {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected static DefaultSelenium selenium;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected static String SELINIUM_HOST;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected static Integer SELINIUM_PORT;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected static String BROWSER;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected static String APP_BASE_URL;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected static String APP_ROOT_PAGE;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\tprotected static ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 24, 19)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 24, 35)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t\t/*");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t * connects to local selinium server with the specified port *make sure");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t * u start the server*");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t */");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@BeforeClass");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic static void init() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tloadProperties();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tinitSelinium();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 34, 3)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" = new ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 34, 37)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t// selenium.captureEntirePageScreenshot(\"C:/Documents and Settings/ayalama001c/Desktop/selenium.png\",");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t// \"\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Test");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void testCreateWidget() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tselenium.click(\"//td[contains(text(), '");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${upper-case($package/@name)}", 40, 42)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("')]\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tselenium.click(\"//td[contains(text(), '");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 41, 42)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("')]\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\twaitforAjaxResponce();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tselenium.click(\"//div[contains(text(), 'Create ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 43, 50)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("')]\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\twaitforAjaxResponce();");  //$NON-NLS-1$        
            out.write(NL);         
            // type in test data in the fields 
            // process parent class level 2 attributes
            RuntimeTagElement _jettag_c_if_47_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_47_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_47_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_47_2.setTagInfo(_td_c_if_47_2);
            _jettag_c_if_47_2.doStart(context, out);
            while (_jettag_c_if_47_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_48_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_48_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_48_5.setRuntimeParent(_jettag_c_if_47_2);
                _jettag_c_iterate_48_5.setTagInfo(_td_c_iterate_48_5);
                _jettag_c_iterate_48_5.doStart(context, out);
                while (_jettag_c_iterate_48_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_49_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_49_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_49_5.setRuntimeParent(_jettag_c_iterate_48_5);
                    _jettag_c_choose_49_5.setTagInfo(_td_c_choose_49_5);
                    _jettag_c_choose_49_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_49_5_saved_out = out;
                    while (_jettag_c_choose_49_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_when_50_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_50_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_50_6.setRuntimeParent(_jettag_c_choose_49_5);
                        _jettag_c_when_50_6.setTagInfo(_td_c_when_50_6);
                        _jettag_c_when_50_6.doStart(context, out);
                        JET2Writer _jettag_c_when_50_6_saved_out = out;
                        while (_jettag_c_when_50_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t selenium.type(\"//input[@title='");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 51, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("']\", \"test ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 51, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\");");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_50_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_50_6_saved_out;
                        _jettag_c_when_50_6.doEnd();
                        RuntimeTagElement _jettag_c_when_53_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_53_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_53_6.setRuntimeParent(_jettag_c_choose_49_5);
                        _jettag_c_when_53_6.setTagInfo(_td_c_when_53_6);
                        _jettag_c_when_53_6.doStart(context, out);
                        JET2Writer _jettag_c_when_53_6_saved_out = out;
                        while (_jettag_c_when_53_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_53_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_53_6_saved_out;
                        _jettag_c_when_53_6.doEnd();
                        RuntimeTagElement _jettag_c_when_56_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_56_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_56_6.setRuntimeParent(_jettag_c_choose_49_5);
                        _jettag_c_when_56_6.setTagInfo(_td_c_when_56_6);
                        _jettag_c_when_56_6.doStart(context, out);
                        JET2Writer _jettag_c_when_56_6_saved_out = out;
                        while (_jettag_c_when_56_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_56_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_56_6_saved_out;
                        _jettag_c_when_56_6.doEnd();
                        RuntimeTagElement _jettag_c_when_59_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_59_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_59_6.setRuntimeParent(_jettag_c_choose_49_5);
                        _jettag_c_when_59_6.setTagInfo(_td_c_when_59_6);
                        _jettag_c_when_59_6.doStart(context, out);
                        JET2Writer _jettag_c_when_59_6_saved_out = out;
                        while (_jettag_c_when_59_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_when_59_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_59_6_saved_out;
                        _jettag_c_when_59_6.doEnd();
                        RuntimeTagElement _jettag_c_when_61_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_61_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_61_6.setRuntimeParent(_jettag_c_choose_49_5);
                        _jettag_c_when_61_6.setTagInfo(_td_c_when_61_6);
                        _jettag_c_when_61_6.doStart(context, out);
                        JET2Writer _jettag_c_when_61_6_saved_out = out;
                        while (_jettag_c_when_61_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_61_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_61_6_saved_out;
                        _jettag_c_when_61_6.doEnd();
                        RuntimeTagElement _jettag_c_when_64_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_64_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_64_6.setRuntimeParent(_jettag_c_choose_49_5);
                        _jettag_c_when_64_6.setTagInfo(_td_c_when_64_6);
                        _jettag_c_when_64_6.doStart(context, out);
                        JET2Writer _jettag_c_when_64_6_saved_out = out;
                        while (_jettag_c_when_64_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_64_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_64_6_saved_out;
                        _jettag_c_when_64_6.doEnd();
                        _jettag_c_choose_49_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_49_5_saved_out;
                    _jettag_c_choose_49_5.doEnd();
                    _jettag_c_iterate_48_5.handleBodyContent(out);
                }
                _jettag_c_iterate_48_5.doEnd();
                _jettag_c_if_47_2.handleBodyContent(out);
            }
            _jettag_c_if_47_2.doEnd();
            // process parent class level 1 attributes
            RuntimeTagElement _jettag_c_if_71_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_71_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_71_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_71_2.setTagInfo(_td_c_if_71_2);
            _jettag_c_if_71_2.doStart(context, out);
            while (_jettag_c_if_71_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_72_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_72_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_72_5.setRuntimeParent(_jettag_c_if_71_2);
                _jettag_c_iterate_72_5.setTagInfo(_td_c_iterate_72_5);
                _jettag_c_iterate_72_5.doStart(context, out);
                while (_jettag_c_iterate_72_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_73_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_73_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_73_5.setRuntimeParent(_jettag_c_iterate_72_5);
                    _jettag_c_choose_73_5.setTagInfo(_td_c_choose_73_5);
                    _jettag_c_choose_73_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_73_5_saved_out = out;
                    while (_jettag_c_choose_73_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_when_74_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_74_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_74_6.setRuntimeParent(_jettag_c_choose_73_5);
                        _jettag_c_when_74_6.setTagInfo(_td_c_when_74_6);
                        _jettag_c_when_74_6.doStart(context, out);
                        JET2Writer _jettag_c_when_74_6_saved_out = out;
                        while (_jettag_c_when_74_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t selenium.type(\"//input[@title='");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 75, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("']\", \"test ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 75, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\");");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_74_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_74_6_saved_out;
                        _jettag_c_when_74_6.doEnd();
                        RuntimeTagElement _jettag_c_when_77_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_77_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_77_6.setRuntimeParent(_jettag_c_choose_73_5);
                        _jettag_c_when_77_6.setTagInfo(_td_c_when_77_6);
                        _jettag_c_when_77_6.doStart(context, out);
                        JET2Writer _jettag_c_when_77_6_saved_out = out;
                        while (_jettag_c_when_77_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_77_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_77_6_saved_out;
                        _jettag_c_when_77_6.doEnd();
                        RuntimeTagElement _jettag_c_when_80_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_80_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_80_6.setRuntimeParent(_jettag_c_choose_73_5);
                        _jettag_c_when_80_6.setTagInfo(_td_c_when_80_6);
                        _jettag_c_when_80_6.doStart(context, out);
                        JET2Writer _jettag_c_when_80_6_saved_out = out;
                        while (_jettag_c_when_80_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_80_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_80_6_saved_out;
                        _jettag_c_when_80_6.doEnd();
                        RuntimeTagElement _jettag_c_when_83_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_83_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_83_6.setRuntimeParent(_jettag_c_choose_73_5);
                        _jettag_c_when_83_6.setTagInfo(_td_c_when_83_6);
                        _jettag_c_when_83_6.doStart(context, out);
                        JET2Writer _jettag_c_when_83_6_saved_out = out;
                        while (_jettag_c_when_83_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_when_83_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_83_6_saved_out;
                        _jettag_c_when_83_6.doEnd();
                        RuntimeTagElement _jettag_c_when_85_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_85_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_85_6.setRuntimeParent(_jettag_c_choose_73_5);
                        _jettag_c_when_85_6.setTagInfo(_td_c_when_85_6);
                        _jettag_c_when_85_6.doStart(context, out);
                        JET2Writer _jettag_c_when_85_6_saved_out = out;
                        while (_jettag_c_when_85_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_85_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_85_6_saved_out;
                        _jettag_c_when_85_6.doEnd();
                        RuntimeTagElement _jettag_c_when_88_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_88_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_88_6.setRuntimeParent(_jettag_c_choose_73_5);
                        _jettag_c_when_88_6.setTagInfo(_td_c_when_88_6);
                        _jettag_c_when_88_6.doStart(context, out);
                        JET2Writer _jettag_c_when_88_6_saved_out = out;
                        while (_jettag_c_when_88_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_88_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_88_6_saved_out;
                        _jettag_c_when_88_6.doEnd();
                        _jettag_c_choose_73_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_73_5_saved_out;
                    _jettag_c_choose_73_5.doEnd();
                    _jettag_c_iterate_72_5.handleBodyContent(out);
                }
                _jettag_c_iterate_72_5.doEnd();
                _jettag_c_if_71_2.handleBodyContent(out);
            }
            _jettag_c_if_71_2.doEnd();
            // process parent class level 0 attributes
            RuntimeTagElement _jettag_c_iterate_95_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_95_5); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_95_5.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_iterate_95_5.setTagInfo(_td_c_iterate_95_5);
            _jettag_c_iterate_95_5.doStart(context, out);
            while (_jettag_c_iterate_95_5.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_96_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_96_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_96_5.setRuntimeParent(_jettag_c_iterate_95_5);
                _jettag_c_choose_96_5.setTagInfo(_td_c_choose_96_5);
                _jettag_c_choose_96_5.doStart(context, out);
                JET2Writer _jettag_c_choose_96_5_saved_out = out;
                while (_jettag_c_choose_96_5.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_when_97_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_97_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_97_6.setRuntimeParent(_jettag_c_choose_96_5);
                    _jettag_c_when_97_6.setTagInfo(_td_c_when_97_6);
                    _jettag_c_when_97_6.doStart(context, out);
                    JET2Writer _jettag_c_when_97_6_saved_out = out;
                    while (_jettag_c_when_97_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t selenium.type(\"//input[@title='");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 98, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("']\", \"test ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 98, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\");");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_97_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_97_6_saved_out;
                    _jettag_c_when_97_6.doEnd();
                    RuntimeTagElement _jettag_c_when_100_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_100_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_100_6.setRuntimeParent(_jettag_c_choose_96_5);
                    _jettag_c_when_100_6.setTagInfo(_td_c_when_100_6);
                    _jettag_c_when_100_6.doStart(context, out);
                    JET2Writer _jettag_c_when_100_6_saved_out = out;
                    while (_jettag_c_when_100_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_100_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_100_6_saved_out;
                    _jettag_c_when_100_6.doEnd();
                    RuntimeTagElement _jettag_c_when_103_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_103_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_103_6.setRuntimeParent(_jettag_c_choose_96_5);
                    _jettag_c_when_103_6.setTagInfo(_td_c_when_103_6);
                    _jettag_c_when_103_6.doStart(context, out);
                    JET2Writer _jettag_c_when_103_6_saved_out = out;
                    while (_jettag_c_when_103_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_103_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_103_6_saved_out;
                    _jettag_c_when_103_6.doEnd();
                    RuntimeTagElement _jettag_c_when_106_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_106_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_106_6.setRuntimeParent(_jettag_c_choose_96_5);
                    _jettag_c_when_106_6.setTagInfo(_td_c_when_106_6);
                    _jettag_c_when_106_6.doStart(context, out);
                    JET2Writer _jettag_c_when_106_6_saved_out = out;
                    while (_jettag_c_when_106_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_106_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_106_6_saved_out;
                    _jettag_c_when_106_6.doEnd();
                    RuntimeTagElement _jettag_c_when_108_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_108_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_108_6.setRuntimeParent(_jettag_c_choose_96_5);
                    _jettag_c_when_108_6.setTagInfo(_td_c_when_108_6);
                    _jettag_c_when_108_6.doStart(context, out);
                    JET2Writer _jettag_c_when_108_6_saved_out = out;
                    while (_jettag_c_when_108_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_108_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_108_6_saved_out;
                    _jettag_c_when_108_6.doEnd();
                    RuntimeTagElement _jettag_c_when_111_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_111_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_111_6.setRuntimeParent(_jettag_c_choose_96_5);
                    _jettag_c_when_111_6.setTagInfo(_td_c_when_111_6);
                    _jettag_c_when_111_6.doStart(context, out);
                    JET2Writer _jettag_c_when_111_6_saved_out = out;
                    while (_jettag_c_when_111_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_111_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_111_6_saved_out;
                    _jettag_c_when_111_6.doEnd();
                    _jettag_c_choose_96_5.handleBodyContent(out);
                }
                out = _jettag_c_choose_96_5_saved_out;
                _jettag_c_choose_96_5.doEnd();
                _jettag_c_iterate_95_5.handleBodyContent(out);
            }
            _jettag_c_iterate_95_5.doEnd();
            out.write("\t\tselenium.click(\"//button[contains(text(), 'create')]\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\twaitforAjaxResponce();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tassertTrue(selenium.isTextPresent(\"created\"));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Test");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Ignore");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void testReadAllWidget() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tselenium.click(\"//td[contains(text(), '");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${upper-case($packageName)}", 124, 42)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("')]\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tselenium.click(\"//td[contains(text(), '");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 125, 42)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("')]\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\twaitforAjaxResponce();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tNumber pages = selenium.getXpathCount(\"//option\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tfor (Integer i = 1; i <= pages.intValue(); i++) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tif (selenium.isElementPresent(\"//option[contains(text(),\"");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t+ i.toString() + \")]\")) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\tselenium.select(\"//select\", \"label=\" + i.toString() + \"\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\twaitforAjaxResponce();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write(NL);         
            out.write("\tpublic void waitFor(int seconds) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t\ttry {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tThread.sleep(seconds * 1000);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t} catch (InterruptedException e) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t// TODO Auto-generated catch block");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\te.printStackTrace();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\tpublic void waitforAjaxResponce() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tfor (int second = 0;; second++) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tif (second >= 60)");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\tbreak;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\ttry {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\tif (!selenium.isTextPresent(\"Loading...\"))");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\treturn;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t} catch (Exception e) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t\t\t// Pause for 1 second.");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\ttry {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\tThread.sleep(1000);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t} catch (InterruptedException e) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t// TODO Auto-generated catch block");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\te.printStackTrace();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@AfterClass");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic static void destroy() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tselenium.stop();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected static void loadProperties() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tProperties properties = PropertyFileLoader");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t.loadProperties(\"env.properties\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tSELINIUM_HOST = properties.getProperty(\"selinium-host\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tSELINIUM_PORT = new Integer(properties.getProperty(\"selinium-port\"));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tBROWSER = properties.getProperty(\"browser\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tAPP_BASE_URL = properties.getProperty(\"app-base-url\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tAPP_ROOT_PAGE = properties.getProperty(\"app-root-page\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\tprotected static void initSelinium() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tselenium = new DefaultSelenium(SELINIUM_HOST, SELINIUM_PORT, BROWSER,");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\tAPP_BASE_URL);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tselenium.start();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tselenium.open(APP_ROOT_PAGE);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tselenium.waitForPageToLoad(\"50000\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("}");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_java_format_1_1.handleBodyContent(out);
        }
        out = _jettag_java_format_1_1_saved_out;
        _jettag_java_format_1_1.doEnd();
    }
}
