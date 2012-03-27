package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_test_entity_webdriver_classjava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_test_entity_webdriver_classjava() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_java_format_1_1 = new TagInfo("java:format", //$NON-NLS-1$
            1, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_50_2 = new TagInfo("c:if", //$NON-NLS-1$
            50, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_51_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            51, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_52_5 = new TagInfo("c:choose", //$NON-NLS-1$
            52, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_53_6 = new TagInfo("c:when", //$NON-NLS-1$
            53, 6,
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
    private static final TagInfo _td_c_when_66_6 = new TagInfo("c:when", //$NON-NLS-1$
            66, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_69_6 = new TagInfo("c:when", //$NON-NLS-1$
            69, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_76_2 = new TagInfo("c:if", //$NON-NLS-1$
            76, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_77_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            77, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_78_5 = new TagInfo("c:choose", //$NON-NLS-1$
            78, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_79_6 = new TagInfo("c:when", //$NON-NLS-1$
            79, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_84_6 = new TagInfo("c:when", //$NON-NLS-1$
            84, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_87_6 = new TagInfo("c:when", //$NON-NLS-1$
            87, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_90_6 = new TagInfo("c:when", //$NON-NLS-1$
            90, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_92_6 = new TagInfo("c:when", //$NON-NLS-1$
            92, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_95_6 = new TagInfo("c:when", //$NON-NLS-1$
            95, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_102_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            102, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_103_5 = new TagInfo("c:choose", //$NON-NLS-1$
            103, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_104_6 = new TagInfo("c:when", //$NON-NLS-1$
            104, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_109_6 = new TagInfo("c:when", //$NON-NLS-1$
            109, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_112_6 = new TagInfo("c:when", //$NON-NLS-1$
            112, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_115_6 = new TagInfo("c:when", //$NON-NLS-1$
            115, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_117_6 = new TagInfo("c:when", //$NON-NLS-1$
            117, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_120_6 = new TagInfo("c:when", //$NON-NLS-1$
            120, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_151_2 = new TagInfo("c:if", //$NON-NLS-1$
            151, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_152_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            152, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_153_5 = new TagInfo("c:choose", //$NON-NLS-1$
            153, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_154_6 = new TagInfo("c:when", //$NON-NLS-1$
            154, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_160_6 = new TagInfo("c:when", //$NON-NLS-1$
            160, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_163_6 = new TagInfo("c:when", //$NON-NLS-1$
            163, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_166_6 = new TagInfo("c:when", //$NON-NLS-1$
            166, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_168_6 = new TagInfo("c:when", //$NON-NLS-1$
            168, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_171_6 = new TagInfo("c:when", //$NON-NLS-1$
            171, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_178_2 = new TagInfo("c:if", //$NON-NLS-1$
            178, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_179_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            179, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_180_5 = new TagInfo("c:choose", //$NON-NLS-1$
            180, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_181_6 = new TagInfo("c:when", //$NON-NLS-1$
            181, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_187_6 = new TagInfo("c:when", //$NON-NLS-1$
            187, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_190_6 = new TagInfo("c:when", //$NON-NLS-1$
            190, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_193_6 = new TagInfo("c:when", //$NON-NLS-1$
            193, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_195_6 = new TagInfo("c:when", //$NON-NLS-1$
            195, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_198_6 = new TagInfo("c:when", //$NON-NLS-1$
            198, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_205_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            205, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_206_5 = new TagInfo("c:choose", //$NON-NLS-1$
            206, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_207_6 = new TagInfo("c:when", //$NON-NLS-1$
            207, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_213_6 = new TagInfo("c:when", //$NON-NLS-1$
            213, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_216_6 = new TagInfo("c:when", //$NON-NLS-1$
            216, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_219_6 = new TagInfo("c:when", //$NON-NLS-1$
            219, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_221_6 = new TagInfo("c:when", //$NON-NLS-1$
            221, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_224_6 = new TagInfo("c:when", //$NON-NLS-1$
            224, 6,
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
            out.write("import java.util.List;");  //$NON-NLS-1$        
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
            out.write("import org.openqa.selenium.By;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import org.openqa.selenium.WebDriver;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import org.openqa.selenium.WebDriverBackedSelenium;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import org.openqa.selenium.firefox.FirefoxDriver;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import com.thoughtworks.selenium.Selenium;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import org.openqa.selenium.WebElement;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import info.yalamanchili.qa.WebDriverTest;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("public class ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 21, 14)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Test extends WebDriverTest<");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 21, 56)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(">{");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected static ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 22, 19)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" entity= new ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 22, 47)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected static Long numberOfRecords;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Test");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void testReadAllWidgetRender() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tdriver.findElement(By.xpath(\"//td[contains(text(), '");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${upper-case($package/@name)}", 27, 55)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("')]\"))");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t.click();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tdriver.findElement(By.xpath(\"//td[contains(text(), '");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 29, 55)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("')]\")).click();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\twaitforAjaxResponce();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tassertTrue(driver.getPageSource().contains(\"Total Results\"));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tassertTrue(driver.getPageSource().contains(\"Action\"));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tWebElement totalResultsE = driver.findElement(By");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t.xpath(\"//div[contains(text(), 'Total Results')]\"));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tString totalResultsString = totalResultsE.getText();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tnumberOfRecords = new Long(totalResultsString.substring(totalResultsE");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t.getText().indexOf(\":\") + 1));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Test");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void testCreateWidget() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tdriver.findElement(By.xpath(\"//td[contains(text(), '");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${upper-case($package/@name)}", 42, 55)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("')]\"))");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t.click();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tdriver.findElement(By.xpath(\"//td[contains(text(), '");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 44, 55)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("')]\")).click();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\twaitforAjaxResponce();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tdriver.findElement(By.xpath(\"//div[contains(text(), 'Create ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 46, 63)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("')]\"))");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t.click();");  //$NON-NLS-1$        
            out.write(NL);         
            // type in test data in the fields 
            // process parent class level 2 attributes
            RuntimeTagElement _jettag_c_if_50_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_50_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_50_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_50_2.setTagInfo(_td_c_if_50_2);
            _jettag_c_if_50_2.doStart(context, out);
            while (_jettag_c_if_50_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_51_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_51_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_51_5.setRuntimeParent(_jettag_c_if_50_2);
                _jettag_c_iterate_51_5.setTagInfo(_td_c_iterate_51_5);
                _jettag_c_iterate_51_5.doStart(context, out);
                while (_jettag_c_iterate_51_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_52_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_52_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_52_5.setRuntimeParent(_jettag_c_iterate_51_5);
                    _jettag_c_choose_52_5.setTagInfo(_td_c_choose_52_5);
                    _jettag_c_choose_52_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_52_5_saved_out = out;
                    while (_jettag_c_choose_52_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_when_53_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_53_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_53_6.setRuntimeParent(_jettag_c_choose_52_5);
                        _jettag_c_when_53_6.setTagInfo(_td_c_when_53_6);
                        _jettag_c_when_53_6.doStart(context, out);
                        JET2Writer _jettag_c_when_53_6_saved_out = out;
                        while (_jettag_c_when_53_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t driver.findElement(By.xpath(\"//input[@title='");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 54, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("']\")).sendKeys(");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\"test WD ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 55, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\");");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\tentity.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 56, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(\"test WD ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 56, 60)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\");");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_53_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_53_6_saved_out;
                        _jettag_c_when_53_6.doEnd();
                        RuntimeTagElement _jettag_c_when_58_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_58_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_58_6.setRuntimeParent(_jettag_c_choose_52_5);
                        _jettag_c_when_58_6.setTagInfo(_td_c_when_58_6);
                        _jettag_c_when_58_6.doStart(context, out);
                        JET2Writer _jettag_c_when_58_6_saved_out = out;
                        while (_jettag_c_when_58_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_58_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_58_6_saved_out;
                        _jettag_c_when_58_6.doEnd();
                        RuntimeTagElement _jettag_c_when_61_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_61_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_61_6.setRuntimeParent(_jettag_c_choose_52_5);
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
                        _jettag_c_when_64_6.setRuntimeParent(_jettag_c_choose_52_5);
                        _jettag_c_when_64_6.setTagInfo(_td_c_when_64_6);
                        _jettag_c_when_64_6.doStart(context, out);
                        JET2Writer _jettag_c_when_64_6_saved_out = out;
                        while (_jettag_c_when_64_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_when_64_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_64_6_saved_out;
                        _jettag_c_when_64_6.doEnd();
                        RuntimeTagElement _jettag_c_when_66_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_66_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_66_6.setRuntimeParent(_jettag_c_choose_52_5);
                        _jettag_c_when_66_6.setTagInfo(_td_c_when_66_6);
                        _jettag_c_when_66_6.doStart(context, out);
                        JET2Writer _jettag_c_when_66_6_saved_out = out;
                        while (_jettag_c_when_66_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_66_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_66_6_saved_out;
                        _jettag_c_when_66_6.doEnd();
                        RuntimeTagElement _jettag_c_when_69_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_69_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_69_6.setRuntimeParent(_jettag_c_choose_52_5);
                        _jettag_c_when_69_6.setTagInfo(_td_c_when_69_6);
                        _jettag_c_when_69_6.doStart(context, out);
                        JET2Writer _jettag_c_when_69_6_saved_out = out;
                        while (_jettag_c_when_69_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_69_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_69_6_saved_out;
                        _jettag_c_when_69_6.doEnd();
                        _jettag_c_choose_52_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_52_5_saved_out;
                    _jettag_c_choose_52_5.doEnd();
                    _jettag_c_iterate_51_5.handleBodyContent(out);
                }
                _jettag_c_iterate_51_5.doEnd();
                _jettag_c_if_50_2.handleBodyContent(out);
            }
            _jettag_c_if_50_2.doEnd();
            // process parent class level 1 attributes
            RuntimeTagElement _jettag_c_if_76_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_76_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_76_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_76_2.setTagInfo(_td_c_if_76_2);
            _jettag_c_if_76_2.doStart(context, out);
            while (_jettag_c_if_76_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_77_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_77_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_77_5.setRuntimeParent(_jettag_c_if_76_2);
                _jettag_c_iterate_77_5.setTagInfo(_td_c_iterate_77_5);
                _jettag_c_iterate_77_5.doStart(context, out);
                while (_jettag_c_iterate_77_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_78_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_78_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_78_5.setRuntimeParent(_jettag_c_iterate_77_5);
                    _jettag_c_choose_78_5.setTagInfo(_td_c_choose_78_5);
                    _jettag_c_choose_78_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_78_5_saved_out = out;
                    while (_jettag_c_choose_78_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_when_79_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_79_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_79_6.setRuntimeParent(_jettag_c_choose_78_5);
                        _jettag_c_when_79_6.setTagInfo(_td_c_when_79_6);
                        _jettag_c_when_79_6.doStart(context, out);
                        JET2Writer _jettag_c_when_79_6_saved_out = out;
                        while (_jettag_c_when_79_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\tdriver.findElement(By.xpath(\"//input[@title='");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 80, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("']\")).sendKeys(");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\"test WD ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 81, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\");");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\tentity.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 82, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(\"test WD ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 82, 60)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\");");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_79_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_79_6_saved_out;
                        _jettag_c_when_79_6.doEnd();
                        RuntimeTagElement _jettag_c_when_84_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_84_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_84_6.setRuntimeParent(_jettag_c_choose_78_5);
                        _jettag_c_when_84_6.setTagInfo(_td_c_when_84_6);
                        _jettag_c_when_84_6.doStart(context, out);
                        JET2Writer _jettag_c_when_84_6_saved_out = out;
                        while (_jettag_c_when_84_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_84_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_84_6_saved_out;
                        _jettag_c_when_84_6.doEnd();
                        RuntimeTagElement _jettag_c_when_87_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_87_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_87_6.setRuntimeParent(_jettag_c_choose_78_5);
                        _jettag_c_when_87_6.setTagInfo(_td_c_when_87_6);
                        _jettag_c_when_87_6.doStart(context, out);
                        JET2Writer _jettag_c_when_87_6_saved_out = out;
                        while (_jettag_c_when_87_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_87_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_87_6_saved_out;
                        _jettag_c_when_87_6.doEnd();
                        RuntimeTagElement _jettag_c_when_90_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_90_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_90_6.setRuntimeParent(_jettag_c_choose_78_5);
                        _jettag_c_when_90_6.setTagInfo(_td_c_when_90_6);
                        _jettag_c_when_90_6.doStart(context, out);
                        JET2Writer _jettag_c_when_90_6_saved_out = out;
                        while (_jettag_c_when_90_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_when_90_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_90_6_saved_out;
                        _jettag_c_when_90_6.doEnd();
                        RuntimeTagElement _jettag_c_when_92_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_92_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_92_6.setRuntimeParent(_jettag_c_choose_78_5);
                        _jettag_c_when_92_6.setTagInfo(_td_c_when_92_6);
                        _jettag_c_when_92_6.doStart(context, out);
                        JET2Writer _jettag_c_when_92_6_saved_out = out;
                        while (_jettag_c_when_92_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_92_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_92_6_saved_out;
                        _jettag_c_when_92_6.doEnd();
                        RuntimeTagElement _jettag_c_when_95_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_95_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_95_6.setRuntimeParent(_jettag_c_choose_78_5);
                        _jettag_c_when_95_6.setTagInfo(_td_c_when_95_6);
                        _jettag_c_when_95_6.doStart(context, out);
                        JET2Writer _jettag_c_when_95_6_saved_out = out;
                        while (_jettag_c_when_95_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_95_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_95_6_saved_out;
                        _jettag_c_when_95_6.doEnd();
                        _jettag_c_choose_78_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_78_5_saved_out;
                    _jettag_c_choose_78_5.doEnd();
                    _jettag_c_iterate_77_5.handleBodyContent(out);
                }
                _jettag_c_iterate_77_5.doEnd();
                _jettag_c_if_76_2.handleBodyContent(out);
            }
            _jettag_c_if_76_2.doEnd();
            // process parent class level 0 attributes
            RuntimeTagElement _jettag_c_iterate_102_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_102_5); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_102_5.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_iterate_102_5.setTagInfo(_td_c_iterate_102_5);
            _jettag_c_iterate_102_5.doStart(context, out);
            while (_jettag_c_iterate_102_5.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_103_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_103_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_103_5.setRuntimeParent(_jettag_c_iterate_102_5);
                _jettag_c_choose_103_5.setTagInfo(_td_c_choose_103_5);
                _jettag_c_choose_103_5.doStart(context, out);
                JET2Writer _jettag_c_choose_103_5_saved_out = out;
                while (_jettag_c_choose_103_5.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_when_104_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_104_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_104_6.setRuntimeParent(_jettag_c_choose_103_5);
                    _jettag_c_when_104_6.setTagInfo(_td_c_when_104_6);
                    _jettag_c_when_104_6.doStart(context, out);
                    JET2Writer _jettag_c_when_104_6_saved_out = out;
                    while (_jettag_c_when_104_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t driver.findElement(By.xpath(\"//input[@title='");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 105, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("']\")).sendKeys(");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\"test WD ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 106, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\");");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\tentity.set");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 107, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("(\"test WD ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 107, 60)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\");");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_104_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_104_6_saved_out;
                    _jettag_c_when_104_6.doEnd();
                    RuntimeTagElement _jettag_c_when_109_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_109_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_109_6.setRuntimeParent(_jettag_c_choose_103_5);
                    _jettag_c_when_109_6.setTagInfo(_td_c_when_109_6);
                    _jettag_c_when_109_6.doStart(context, out);
                    JET2Writer _jettag_c_when_109_6_saved_out = out;
                    while (_jettag_c_when_109_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_109_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_109_6_saved_out;
                    _jettag_c_when_109_6.doEnd();
                    RuntimeTagElement _jettag_c_when_112_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_112_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_112_6.setRuntimeParent(_jettag_c_choose_103_5);
                    _jettag_c_when_112_6.setTagInfo(_td_c_when_112_6);
                    _jettag_c_when_112_6.doStart(context, out);
                    JET2Writer _jettag_c_when_112_6_saved_out = out;
                    while (_jettag_c_when_112_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_112_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_112_6_saved_out;
                    _jettag_c_when_112_6.doEnd();
                    RuntimeTagElement _jettag_c_when_115_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_115_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_115_6.setRuntimeParent(_jettag_c_choose_103_5);
                    _jettag_c_when_115_6.setTagInfo(_td_c_when_115_6);
                    _jettag_c_when_115_6.doStart(context, out);
                    JET2Writer _jettag_c_when_115_6_saved_out = out;
                    while (_jettag_c_when_115_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_115_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_115_6_saved_out;
                    _jettag_c_when_115_6.doEnd();
                    RuntimeTagElement _jettag_c_when_117_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_117_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_117_6.setRuntimeParent(_jettag_c_choose_103_5);
                    _jettag_c_when_117_6.setTagInfo(_td_c_when_117_6);
                    _jettag_c_when_117_6.doStart(context, out);
                    JET2Writer _jettag_c_when_117_6_saved_out = out;
                    while (_jettag_c_when_117_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_117_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_117_6_saved_out;
                    _jettag_c_when_117_6.doEnd();
                    RuntimeTagElement _jettag_c_when_120_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_120_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_120_6.setRuntimeParent(_jettag_c_choose_103_5);
                    _jettag_c_when_120_6.setTagInfo(_td_c_when_120_6);
                    _jettag_c_when_120_6.doStart(context, out);
                    JET2Writer _jettag_c_when_120_6_saved_out = out;
                    while (_jettag_c_when_120_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_120_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_120_6_saved_out;
                    _jettag_c_when_120_6.doEnd();
                    _jettag_c_choose_103_5.handleBodyContent(out);
                }
                out = _jettag_c_choose_103_5_saved_out;
                _jettag_c_choose_103_5.doEnd();
                _jettag_c_iterate_102_5.handleBodyContent(out);
            }
            _jettag_c_iterate_102_5.doEnd();
            out.write("\t\tdriver.findElement(By.xpath(\"//button[contains(text(), 'create')]\"))");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t.click();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\twaitforAjaxResponce();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tassertTrue(driver.getPageSource().contains(\"created\"));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Test");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void testReadAllWidget() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tboolean flag = false;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tdriver.findElement(By.xpath(\"//td[contains(text(), '");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${upper-case($package/@name)}", 134, 55)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("')]\"))");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t.click();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tdriver.findElement(By.xpath(\"//td[contains(text(), '");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 136, 55)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("')]\")).click();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\twaitforAjaxResponce();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tassertTrue(driver.getPageSource().contains(\"Total Results\"));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tassertTrue(driver.getPageSource().contains(\"Action\"));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tWebElement totalResultsE = driver.findElement(By");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t.xpath(\"//div[contains(text(), 'Total Results')]\"));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tString totalResultsString = totalResultsE.getText();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tLong results = new Long(totalResultsString.substring(totalResultsE");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t.getText().indexOf(\":\") + 1));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tassertTrue(results == numberOfRecords + 1);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tList<WebElement> elements = driver.findElements(By.xpath(\"//option\"));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tfor (WebElement page : elements) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tpage.setSelected();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\twaitforAjaxResponce();");  //$NON-NLS-1$        
            out.write(NL);         
            // process parent class level 2 attributes
            RuntimeTagElement _jettag_c_if_151_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_151_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_151_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_151_2.setTagInfo(_td_c_if_151_2);
            _jettag_c_if_151_2.doStart(context, out);
            while (_jettag_c_if_151_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_152_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_152_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_152_5.setRuntimeParent(_jettag_c_if_151_2);
                _jettag_c_iterate_152_5.setTagInfo(_td_c_iterate_152_5);
                _jettag_c_iterate_152_5.doStart(context, out);
                while (_jettag_c_iterate_152_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_153_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_153_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_153_5.setRuntimeParent(_jettag_c_iterate_152_5);
                    _jettag_c_choose_153_5.setTagInfo(_td_c_choose_153_5);
                    _jettag_c_choose_153_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_153_5_saved_out = out;
                    while (_jettag_c_choose_153_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_when_154_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_154_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_154_6.setRuntimeParent(_jettag_c_choose_153_5);
                        _jettag_c_when_154_6.setTagInfo(_td_c_when_154_6);
                        _jettag_c_when_154_6.doStart(context, out);
                        JET2Writer _jettag_c_when_154_6_saved_out = out;
                        while (_jettag_c_when_154_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t\tif (driver.getPageSource().contains(entity.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 155, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("())) {");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\tflag = true;");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\tbreak;");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t}");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_154_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_154_6_saved_out;
                        _jettag_c_when_154_6.doEnd();
                        RuntimeTagElement _jettag_c_when_160_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_160_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_160_6.setRuntimeParent(_jettag_c_choose_153_5);
                        _jettag_c_when_160_6.setTagInfo(_td_c_when_160_6);
                        _jettag_c_when_160_6.doStart(context, out);
                        JET2Writer _jettag_c_when_160_6_saved_out = out;
                        while (_jettag_c_when_160_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_160_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_160_6_saved_out;
                        _jettag_c_when_160_6.doEnd();
                        RuntimeTagElement _jettag_c_when_163_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_163_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_163_6.setRuntimeParent(_jettag_c_choose_153_5);
                        _jettag_c_when_163_6.setTagInfo(_td_c_when_163_6);
                        _jettag_c_when_163_6.doStart(context, out);
                        JET2Writer _jettag_c_when_163_6_saved_out = out;
                        while (_jettag_c_when_163_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_163_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_163_6_saved_out;
                        _jettag_c_when_163_6.doEnd();
                        RuntimeTagElement _jettag_c_when_166_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_166_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_166_6.setRuntimeParent(_jettag_c_choose_153_5);
                        _jettag_c_when_166_6.setTagInfo(_td_c_when_166_6);
                        _jettag_c_when_166_6.doStart(context, out);
                        JET2Writer _jettag_c_when_166_6_saved_out = out;
                        while (_jettag_c_when_166_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_when_166_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_166_6_saved_out;
                        _jettag_c_when_166_6.doEnd();
                        RuntimeTagElement _jettag_c_when_168_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_168_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_168_6.setRuntimeParent(_jettag_c_choose_153_5);
                        _jettag_c_when_168_6.setTagInfo(_td_c_when_168_6);
                        _jettag_c_when_168_6.doStart(context, out);
                        JET2Writer _jettag_c_when_168_6_saved_out = out;
                        while (_jettag_c_when_168_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_168_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_168_6_saved_out;
                        _jettag_c_when_168_6.doEnd();
                        RuntimeTagElement _jettag_c_when_171_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_171_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_171_6.setRuntimeParent(_jettag_c_choose_153_5);
                        _jettag_c_when_171_6.setTagInfo(_td_c_when_171_6);
                        _jettag_c_when_171_6.doStart(context, out);
                        JET2Writer _jettag_c_when_171_6_saved_out = out;
                        while (_jettag_c_when_171_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_171_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_171_6_saved_out;
                        _jettag_c_when_171_6.doEnd();
                        _jettag_c_choose_153_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_153_5_saved_out;
                    _jettag_c_choose_153_5.doEnd();
                    _jettag_c_iterate_152_5.handleBodyContent(out);
                }
                _jettag_c_iterate_152_5.doEnd();
                _jettag_c_if_151_2.handleBodyContent(out);
            }
            _jettag_c_if_151_2.doEnd();
            // process parent class level 1 attributes
            RuntimeTagElement _jettag_c_if_178_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_178_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_178_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_178_2.setTagInfo(_td_c_if_178_2);
            _jettag_c_if_178_2.doStart(context, out);
            while (_jettag_c_if_178_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_179_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_179_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_179_5.setRuntimeParent(_jettag_c_if_178_2);
                _jettag_c_iterate_179_5.setTagInfo(_td_c_iterate_179_5);
                _jettag_c_iterate_179_5.doStart(context, out);
                while (_jettag_c_iterate_179_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_180_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_180_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_180_5.setRuntimeParent(_jettag_c_iterate_179_5);
                    _jettag_c_choose_180_5.setTagInfo(_td_c_choose_180_5);
                    _jettag_c_choose_180_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_180_5_saved_out = out;
                    while (_jettag_c_choose_180_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_when_181_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_181_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_181_6.setRuntimeParent(_jettag_c_choose_180_5);
                        _jettag_c_when_181_6.setTagInfo(_td_c_when_181_6);
                        _jettag_c_when_181_6.doStart(context, out);
                        JET2Writer _jettag_c_when_181_6_saved_out = out;
                        while (_jettag_c_when_181_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t\tif (driver.getPageSource().contains(entity.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 182, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("())) {");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\tflag = true;");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\tbreak;");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t}");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_181_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_181_6_saved_out;
                        _jettag_c_when_181_6.doEnd();
                        RuntimeTagElement _jettag_c_when_187_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_187_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_187_6.setRuntimeParent(_jettag_c_choose_180_5);
                        _jettag_c_when_187_6.setTagInfo(_td_c_when_187_6);
                        _jettag_c_when_187_6.doStart(context, out);
                        JET2Writer _jettag_c_when_187_6_saved_out = out;
                        while (_jettag_c_when_187_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_187_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_187_6_saved_out;
                        _jettag_c_when_187_6.doEnd();
                        RuntimeTagElement _jettag_c_when_190_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_190_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_190_6.setRuntimeParent(_jettag_c_choose_180_5);
                        _jettag_c_when_190_6.setTagInfo(_td_c_when_190_6);
                        _jettag_c_when_190_6.doStart(context, out);
                        JET2Writer _jettag_c_when_190_6_saved_out = out;
                        while (_jettag_c_when_190_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_190_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_190_6_saved_out;
                        _jettag_c_when_190_6.doEnd();
                        RuntimeTagElement _jettag_c_when_193_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_193_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_193_6.setRuntimeParent(_jettag_c_choose_180_5);
                        _jettag_c_when_193_6.setTagInfo(_td_c_when_193_6);
                        _jettag_c_when_193_6.doStart(context, out);
                        JET2Writer _jettag_c_when_193_6_saved_out = out;
                        while (_jettag_c_when_193_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_when_193_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_193_6_saved_out;
                        _jettag_c_when_193_6.doEnd();
                        RuntimeTagElement _jettag_c_when_195_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_195_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_195_6.setRuntimeParent(_jettag_c_choose_180_5);
                        _jettag_c_when_195_6.setTagInfo(_td_c_when_195_6);
                        _jettag_c_when_195_6.doStart(context, out);
                        JET2Writer _jettag_c_when_195_6_saved_out = out;
                        while (_jettag_c_when_195_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_195_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_195_6_saved_out;
                        _jettag_c_when_195_6.doEnd();
                        RuntimeTagElement _jettag_c_when_198_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_198_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_198_6.setRuntimeParent(_jettag_c_choose_180_5);
                        _jettag_c_when_198_6.setTagInfo(_td_c_when_198_6);
                        _jettag_c_when_198_6.doStart(context, out);
                        JET2Writer _jettag_c_when_198_6_saved_out = out;
                        while (_jettag_c_when_198_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_198_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_198_6_saved_out;
                        _jettag_c_when_198_6.doEnd();
                        _jettag_c_choose_180_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_180_5_saved_out;
                    _jettag_c_choose_180_5.doEnd();
                    _jettag_c_iterate_179_5.handleBodyContent(out);
                }
                _jettag_c_iterate_179_5.doEnd();
                _jettag_c_if_178_2.handleBodyContent(out);
            }
            _jettag_c_if_178_2.doEnd();
            // process parent class level 0 attributes
            RuntimeTagElement _jettag_c_iterate_205_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_205_5); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_205_5.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_iterate_205_5.setTagInfo(_td_c_iterate_205_5);
            _jettag_c_iterate_205_5.doStart(context, out);
            while (_jettag_c_iterate_205_5.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_206_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_206_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_206_5.setRuntimeParent(_jettag_c_iterate_205_5);
                _jettag_c_choose_206_5.setTagInfo(_td_c_choose_206_5);
                _jettag_c_choose_206_5.doStart(context, out);
                JET2Writer _jettag_c_choose_206_5_saved_out = out;
                while (_jettag_c_choose_206_5.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_when_207_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_207_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_207_6.setRuntimeParent(_jettag_c_choose_206_5);
                    _jettag_c_when_207_6.setTagInfo(_td_c_when_207_6);
                    _jettag_c_when_207_6.doStart(context, out);
                    JET2Writer _jettag_c_when_207_6_saved_out = out;
                    while (_jettag_c_when_207_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t\tif (driver.getPageSource().contains(entity.get");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 208, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("())) {");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\tflag = true;");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\tbreak;");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t}");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_207_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_207_6_saved_out;
                    _jettag_c_when_207_6.doEnd();
                    RuntimeTagElement _jettag_c_when_213_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_213_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_213_6.setRuntimeParent(_jettag_c_choose_206_5);
                    _jettag_c_when_213_6.setTagInfo(_td_c_when_213_6);
                    _jettag_c_when_213_6.doStart(context, out);
                    JET2Writer _jettag_c_when_213_6_saved_out = out;
                    while (_jettag_c_when_213_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_213_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_213_6_saved_out;
                    _jettag_c_when_213_6.doEnd();
                    RuntimeTagElement _jettag_c_when_216_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_216_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_216_6.setRuntimeParent(_jettag_c_choose_206_5);
                    _jettag_c_when_216_6.setTagInfo(_td_c_when_216_6);
                    _jettag_c_when_216_6.doStart(context, out);
                    JET2Writer _jettag_c_when_216_6_saved_out = out;
                    while (_jettag_c_when_216_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_216_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_216_6_saved_out;
                    _jettag_c_when_216_6.doEnd();
                    RuntimeTagElement _jettag_c_when_219_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_219_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_219_6.setRuntimeParent(_jettag_c_choose_206_5);
                    _jettag_c_when_219_6.setTagInfo(_td_c_when_219_6);
                    _jettag_c_when_219_6.doStart(context, out);
                    JET2Writer _jettag_c_when_219_6_saved_out = out;
                    while (_jettag_c_when_219_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_219_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_219_6_saved_out;
                    _jettag_c_when_219_6.doEnd();
                    RuntimeTagElement _jettag_c_when_221_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_221_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_221_6.setRuntimeParent(_jettag_c_choose_206_5);
                    _jettag_c_when_221_6.setTagInfo(_td_c_when_221_6);
                    _jettag_c_when_221_6.doStart(context, out);
                    JET2Writer _jettag_c_when_221_6_saved_out = out;
                    while (_jettag_c_when_221_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_221_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_221_6_saved_out;
                    _jettag_c_when_221_6.doEnd();
                    RuntimeTagElement _jettag_c_when_224_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_224_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_224_6.setRuntimeParent(_jettag_c_choose_206_5);
                    _jettag_c_when_224_6.setTagInfo(_td_c_when_224_6);
                    _jettag_c_when_224_6.doStart(context, out);
                    JET2Writer _jettag_c_when_224_6_saved_out = out;
                    while (_jettag_c_when_224_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_224_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_224_6_saved_out;
                    _jettag_c_when_224_6.doEnd();
                    _jettag_c_choose_206_5.handleBodyContent(out);
                }
                out = _jettag_c_choose_206_5_saved_out;
                _jettag_c_choose_206_5.doEnd();
                _jettag_c_iterate_205_5.handleBodyContent(out);
            }
            _jettag_c_iterate_205_5.doEnd();
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tassertTrue(flag);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("}");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_java_format_1_1.handleBodyContent(out);
        }
        out = _jettag_java_format_1_1_saved_out;
        _jettag_java_format_1_1.doEnd();
    }
}
