package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_load_profiles implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$

    public _jet_load_profiles() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_c_load_2_1 = new TagInfo("c:load", //$NON-NLS-1$
            2, 1,
            new String[] {
                "url", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "templates/profiles/YalamanchiliMDAProfile.xml", //$NON-NLS-1$
                "myprofile", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_5_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            5, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$myprofile/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_7_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            7, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Stereotype", //$NON-NLS-1$
                "stereotype", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_8_2 = new TagInfo("c:if", //$NON-NLS-1$
            8, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@name = 'Digits'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_9_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            9, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$stereotype/@xmi.id)", //$NON-NLS-1$
                "DigitsID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_11_2 = new TagInfo("c:if", //$NON-NLS-1$
            11, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@name = 'Future'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_12_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            12, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$stereotype/@xmi.id)", //$NON-NLS-1$
                "FutureID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_14_2 = new TagInfo("c:if", //$NON-NLS-1$
            14, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@name = 'Size'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_15_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            15, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$stereotype/@xmi.id)", //$NON-NLS-1$
                "SizeID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_17_2 = new TagInfo("c:if", //$NON-NLS-1$
            17, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@name = 'Max'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_18_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            18, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$stereotype/@xmi.id)", //$NON-NLS-1$
                "MaxID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_20_2 = new TagInfo("c:if", //$NON-NLS-1$
            20, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@name = 'Min'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_21_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            21, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$stereotype/@xmi.id)", //$NON-NLS-1$
                "MinID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_23_2 = new TagInfo("c:if", //$NON-NLS-1$
            23, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@name = 'DecimalMin'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_24_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            24, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$stereotype/@xmi.id)", //$NON-NLS-1$
                "DecimalMinID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_26_2 = new TagInfo("c:if", //$NON-NLS-1$
            26, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@name = 'DecimalMax'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_27_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            27, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$stereotype/@xmi.id)", //$NON-NLS-1$
                "DecimalMaxID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_29_2 = new TagInfo("c:if", //$NON-NLS-1$
            29, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@name = 'NotNull'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_30_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            30, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$stereotype/@xmi.id)", //$NON-NLS-1$
                "NotNullID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_32_2 = new TagInfo("c:if", //$NON-NLS-1$
            32, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@name = 'NotEmpty'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_33_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            33, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$stereotype/@xmi.id)", //$NON-NLS-1$
                "NotEmptyID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_35_2 = new TagInfo("c:if", //$NON-NLS-1$
            35, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@name = 'Past'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_36_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            36, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$stereotype/@xmi.id)", //$NON-NLS-1$
                "PastID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_38_2 = new TagInfo("c:if", //$NON-NLS-1$
            38, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@name = 'JAXB'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_39_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            39, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$stereotype/@xmi.id)", //$NON-NLS-1$
                "JAXBID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_41_2 = new TagInfo("c:if", //$NON-NLS-1$
            41, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@name = 'JPA'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_42_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            42, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$stereotype/@xmi.id)", //$NON-NLS-1$
                "JPAID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_46_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            46, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/TagDefinition", //$NON-NLS-1$
                "tagdefinition", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_47_2 = new TagInfo("c:if", //$NON-NLS-1$
            47, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$tagdefinition/@name = 'max'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_48_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            48, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$tagdefinition/@xmi.id)", //$NON-NLS-1$
                "maxID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_50_2 = new TagInfo("c:if", //$NON-NLS-1$
            50, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$tagdefinition/@name = 'min'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_51_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            51, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$tagdefinition/@xmi.id)", //$NON-NLS-1$
                "minID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_53_2 = new TagInfo("c:if", //$NON-NLS-1$
            53, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$tagdefinition/@name = 'value'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_54_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            54, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$tagdefinition/@xmi.id)", //$NON-NLS-1$
                "valueID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_56_2 = new TagInfo("c:if", //$NON-NLS-1$
            56, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$tagdefinition/@name = 'integer'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_57_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            57, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$tagdefinition/@xmi.id)", //$NON-NLS-1$
                "integerID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_59_2 = new TagInfo("c:if", //$NON-NLS-1$
            59, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$tagdefinition/@name = 'fraction'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_60_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            60, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$tagdefinition/@xmi.id)", //$NON-NLS-1$
                "fractionID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_64_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            64, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/DataType", //$NON-NLS-1$
                "datatype", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_65_2 = new TagInfo("c:if", //$NON-NLS-1$
            65, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$datatype/@name = 'String'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_66_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            66, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$datatype/@xmi.id)", //$NON-NLS-1$
                "StringID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_68_2 = new TagInfo("c:if", //$NON-NLS-1$
            68, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$datatype/@name = 'Integer'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_69_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            69, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$datatype/@xmi.id)", //$NON-NLS-1$
                "IntegerID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_71_2 = new TagInfo("c:if", //$NON-NLS-1$
            71, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$datatype/@name = 'Long'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_72_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            72, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$datatype/@xmi.id)", //$NON-NLS-1$
                "LongID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_74_2 = new TagInfo("c:if", //$NON-NLS-1$
            74, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$datatype/@name = 'Date'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_75_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            75, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$datatype/@xmi.id)", //$NON-NLS-1$
                "DateID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_77_2 = new TagInfo("c:if", //$NON-NLS-1$
            77, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$datatype/@name = 'Boolean'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_78_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            78, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$datatype/@xmi.id)", //$NON-NLS-1$
                "BooleanID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_80_2 = new TagInfo("c:if", //$NON-NLS-1$
            80, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$datatype/@name = 'Float'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_81_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            81, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$datatype/@xmi.id)", //$NON-NLS-1$
                "FloatID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_83_2 = new TagInfo("c:if", //$NON-NLS-1$
            83, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$datatype/@name = 'Currency'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_84_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            84, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$datatype/@xmi.id)", //$NON-NLS-1$
                "CurrencyID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_86_2 = new TagInfo("c:if", //$NON-NLS-1$
            86, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$datatype/@name = 'Image'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_87_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            87, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$datatype/@xmi.id)", //$NON-NLS-1$
                "ImageID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_89_2 = new TagInfo("c:if", //$NON-NLS-1$
            89, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$datatype/@name = 'RichText'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_90_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            90, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($yalamanchiliMDANameSpace,$datatype/@xmi.id)", //$NON-NLS-1$
                "RichTextID", //$NON-NLS-1$
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        // load the yalamanchiliMDA profile
        RuntimeTagElement _jettag_c_load_2_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "load", "c:load", _td_c_load_2_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_load_2_1.setRuntimeParent(null);
        _jettag_c_load_2_1.setTagInfo(_td_c_load_2_1);
        _jettag_c_load_2_1.doStart(context, out);
        _jettag_c_load_2_1.doEnd();
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        //Iterate through the yalamanchiliMDA model and get the datatypes,stereotypes and tagged values 
        RuntimeTagElement _jettag_c_iterate_5_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_5_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_5_1.setRuntimeParent(null);
        _jettag_c_iterate_5_1.setTagInfo(_td_c_iterate_5_1);
        _jettag_c_iterate_5_1.doStart(context, out);
        while (_jettag_c_iterate_5_1.okToProcessBody()) {
            // check all packages for stereotypes 
            RuntimeTagElement _jettag_c_iterate_7_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_7_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_7_1.setRuntimeParent(_jettag_c_iterate_5_1);
            _jettag_c_iterate_7_1.setTagInfo(_td_c_iterate_7_1);
            _jettag_c_iterate_7_1.doStart(context, out);
            while (_jettag_c_iterate_7_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_if_8_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_8_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_8_2.setRuntimeParent(_jettag_c_iterate_7_1);
                _jettag_c_if_8_2.setTagInfo(_td_c_if_8_2);
                _jettag_c_if_8_2.doStart(context, out);
                while (_jettag_c_if_8_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_9_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_9_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_9_3.setRuntimeParent(_jettag_c_if_8_2);
                    _jettag_c_setVariable_9_3.setTagInfo(_td_c_setVariable_9_3);
                    _jettag_c_setVariable_9_3.doStart(context, out);
                    _jettag_c_setVariable_9_3.doEnd();
                    _jettag_c_if_8_2.handleBodyContent(out);
                }
                _jettag_c_if_8_2.doEnd();
                RuntimeTagElement _jettag_c_if_11_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_11_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_11_2.setRuntimeParent(_jettag_c_iterate_7_1);
                _jettag_c_if_11_2.setTagInfo(_td_c_if_11_2);
                _jettag_c_if_11_2.doStart(context, out);
                while (_jettag_c_if_11_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_12_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_12_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_12_3.setRuntimeParent(_jettag_c_if_11_2);
                    _jettag_c_setVariable_12_3.setTagInfo(_td_c_setVariable_12_3);
                    _jettag_c_setVariable_12_3.doStart(context, out);
                    _jettag_c_setVariable_12_3.doEnd();
                    _jettag_c_if_11_2.handleBodyContent(out);
                }
                _jettag_c_if_11_2.doEnd();
                RuntimeTagElement _jettag_c_if_14_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_14_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_14_2.setRuntimeParent(_jettag_c_iterate_7_1);
                _jettag_c_if_14_2.setTagInfo(_td_c_if_14_2);
                _jettag_c_if_14_2.doStart(context, out);
                while (_jettag_c_if_14_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_15_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_15_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_15_3.setRuntimeParent(_jettag_c_if_14_2);
                    _jettag_c_setVariable_15_3.setTagInfo(_td_c_setVariable_15_3);
                    _jettag_c_setVariable_15_3.doStart(context, out);
                    _jettag_c_setVariable_15_3.doEnd();
                    _jettag_c_if_14_2.handleBodyContent(out);
                }
                _jettag_c_if_14_2.doEnd();
                RuntimeTagElement _jettag_c_if_17_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_17_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_17_2.setRuntimeParent(_jettag_c_iterate_7_1);
                _jettag_c_if_17_2.setTagInfo(_td_c_if_17_2);
                _jettag_c_if_17_2.doStart(context, out);
                while (_jettag_c_if_17_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_18_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_18_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_18_3.setRuntimeParent(_jettag_c_if_17_2);
                    _jettag_c_setVariable_18_3.setTagInfo(_td_c_setVariable_18_3);
                    _jettag_c_setVariable_18_3.doStart(context, out);
                    _jettag_c_setVariable_18_3.doEnd();
                    _jettag_c_if_17_2.handleBodyContent(out);
                }
                _jettag_c_if_17_2.doEnd();
                RuntimeTagElement _jettag_c_if_20_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_20_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_20_2.setRuntimeParent(_jettag_c_iterate_7_1);
                _jettag_c_if_20_2.setTagInfo(_td_c_if_20_2);
                _jettag_c_if_20_2.doStart(context, out);
                while (_jettag_c_if_20_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_21_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_21_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_21_3.setRuntimeParent(_jettag_c_if_20_2);
                    _jettag_c_setVariable_21_3.setTagInfo(_td_c_setVariable_21_3);
                    _jettag_c_setVariable_21_3.doStart(context, out);
                    _jettag_c_setVariable_21_3.doEnd();
                    _jettag_c_if_20_2.handleBodyContent(out);
                }
                _jettag_c_if_20_2.doEnd();
                RuntimeTagElement _jettag_c_if_23_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_23_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_23_2.setRuntimeParent(_jettag_c_iterate_7_1);
                _jettag_c_if_23_2.setTagInfo(_td_c_if_23_2);
                _jettag_c_if_23_2.doStart(context, out);
                while (_jettag_c_if_23_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_24_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_24_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_24_3.setRuntimeParent(_jettag_c_if_23_2);
                    _jettag_c_setVariable_24_3.setTagInfo(_td_c_setVariable_24_3);
                    _jettag_c_setVariable_24_3.doStart(context, out);
                    _jettag_c_setVariable_24_3.doEnd();
                    _jettag_c_if_23_2.handleBodyContent(out);
                }
                _jettag_c_if_23_2.doEnd();
                RuntimeTagElement _jettag_c_if_26_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_26_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_26_2.setRuntimeParent(_jettag_c_iterate_7_1);
                _jettag_c_if_26_2.setTagInfo(_td_c_if_26_2);
                _jettag_c_if_26_2.doStart(context, out);
                while (_jettag_c_if_26_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_27_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_27_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_27_3.setRuntimeParent(_jettag_c_if_26_2);
                    _jettag_c_setVariable_27_3.setTagInfo(_td_c_setVariable_27_3);
                    _jettag_c_setVariable_27_3.doStart(context, out);
                    _jettag_c_setVariable_27_3.doEnd();
                    _jettag_c_if_26_2.handleBodyContent(out);
                }
                _jettag_c_if_26_2.doEnd();
                RuntimeTagElement _jettag_c_if_29_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_29_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_29_2.setRuntimeParent(_jettag_c_iterate_7_1);
                _jettag_c_if_29_2.setTagInfo(_td_c_if_29_2);
                _jettag_c_if_29_2.doStart(context, out);
                while (_jettag_c_if_29_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_30_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_30_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_30_3.setRuntimeParent(_jettag_c_if_29_2);
                    _jettag_c_setVariable_30_3.setTagInfo(_td_c_setVariable_30_3);
                    _jettag_c_setVariable_30_3.doStart(context, out);
                    _jettag_c_setVariable_30_3.doEnd();
                    _jettag_c_if_29_2.handleBodyContent(out);
                }
                _jettag_c_if_29_2.doEnd();
                RuntimeTagElement _jettag_c_if_32_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_32_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_32_2.setRuntimeParent(_jettag_c_iterate_7_1);
                _jettag_c_if_32_2.setTagInfo(_td_c_if_32_2);
                _jettag_c_if_32_2.doStart(context, out);
                while (_jettag_c_if_32_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_33_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_33_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_33_3.setRuntimeParent(_jettag_c_if_32_2);
                    _jettag_c_setVariable_33_3.setTagInfo(_td_c_setVariable_33_3);
                    _jettag_c_setVariable_33_3.doStart(context, out);
                    _jettag_c_setVariable_33_3.doEnd();
                    _jettag_c_if_32_2.handleBodyContent(out);
                }
                _jettag_c_if_32_2.doEnd();
                RuntimeTagElement _jettag_c_if_35_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_35_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_35_2.setRuntimeParent(_jettag_c_iterate_7_1);
                _jettag_c_if_35_2.setTagInfo(_td_c_if_35_2);
                _jettag_c_if_35_2.doStart(context, out);
                while (_jettag_c_if_35_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_36_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_36_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_36_3.setRuntimeParent(_jettag_c_if_35_2);
                    _jettag_c_setVariable_36_3.setTagInfo(_td_c_setVariable_36_3);
                    _jettag_c_setVariable_36_3.doStart(context, out);
                    _jettag_c_setVariable_36_3.doEnd();
                    _jettag_c_if_35_2.handleBodyContent(out);
                }
                _jettag_c_if_35_2.doEnd();
                RuntimeTagElement _jettag_c_if_38_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_38_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_38_2.setRuntimeParent(_jettag_c_iterate_7_1);
                _jettag_c_if_38_2.setTagInfo(_td_c_if_38_2);
                _jettag_c_if_38_2.doStart(context, out);
                while (_jettag_c_if_38_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_39_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_39_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_39_3.setRuntimeParent(_jettag_c_if_38_2);
                    _jettag_c_setVariable_39_3.setTagInfo(_td_c_setVariable_39_3);
                    _jettag_c_setVariable_39_3.doStart(context, out);
                    _jettag_c_setVariable_39_3.doEnd();
                    _jettag_c_if_38_2.handleBodyContent(out);
                }
                _jettag_c_if_38_2.doEnd();
                RuntimeTagElement _jettag_c_if_41_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_41_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_41_2.setRuntimeParent(_jettag_c_iterate_7_1);
                _jettag_c_if_41_2.setTagInfo(_td_c_if_41_2);
                _jettag_c_if_41_2.doStart(context, out);
                while (_jettag_c_if_41_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_42_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_42_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_42_3.setRuntimeParent(_jettag_c_if_41_2);
                    _jettag_c_setVariable_42_3.setTagInfo(_td_c_setVariable_42_3);
                    _jettag_c_setVariable_42_3.doStart(context, out);
                    _jettag_c_setVariable_42_3.doEnd();
                    _jettag_c_if_41_2.handleBodyContent(out);
                }
                _jettag_c_if_41_2.doEnd();
                _jettag_c_iterate_7_1.handleBodyContent(out);
            }
            _jettag_c_iterate_7_1.doEnd();
            // check all packages for tagged Values 
            RuntimeTagElement _jettag_c_iterate_46_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_46_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_46_1.setRuntimeParent(_jettag_c_iterate_5_1);
            _jettag_c_iterate_46_1.setTagInfo(_td_c_iterate_46_1);
            _jettag_c_iterate_46_1.doStart(context, out);
            while (_jettag_c_iterate_46_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_if_47_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_47_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_47_2.setRuntimeParent(_jettag_c_iterate_46_1);
                _jettag_c_if_47_2.setTagInfo(_td_c_if_47_2);
                _jettag_c_if_47_2.doStart(context, out);
                while (_jettag_c_if_47_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_48_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_48_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_48_3.setRuntimeParent(_jettag_c_if_47_2);
                    _jettag_c_setVariable_48_3.setTagInfo(_td_c_setVariable_48_3);
                    _jettag_c_setVariable_48_3.doStart(context, out);
                    _jettag_c_setVariable_48_3.doEnd();
                    _jettag_c_if_47_2.handleBodyContent(out);
                }
                _jettag_c_if_47_2.doEnd();
                RuntimeTagElement _jettag_c_if_50_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_50_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_50_2.setRuntimeParent(_jettag_c_iterate_46_1);
                _jettag_c_if_50_2.setTagInfo(_td_c_if_50_2);
                _jettag_c_if_50_2.doStart(context, out);
                while (_jettag_c_if_50_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_51_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_51_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_51_3.setRuntimeParent(_jettag_c_if_50_2);
                    _jettag_c_setVariable_51_3.setTagInfo(_td_c_setVariable_51_3);
                    _jettag_c_setVariable_51_3.doStart(context, out);
                    _jettag_c_setVariable_51_3.doEnd();
                    _jettag_c_if_50_2.handleBodyContent(out);
                }
                _jettag_c_if_50_2.doEnd();
                RuntimeTagElement _jettag_c_if_53_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_53_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_53_2.setRuntimeParent(_jettag_c_iterate_46_1);
                _jettag_c_if_53_2.setTagInfo(_td_c_if_53_2);
                _jettag_c_if_53_2.doStart(context, out);
                while (_jettag_c_if_53_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_54_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_54_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_54_3.setRuntimeParent(_jettag_c_if_53_2);
                    _jettag_c_setVariable_54_3.setTagInfo(_td_c_setVariable_54_3);
                    _jettag_c_setVariable_54_3.doStart(context, out);
                    _jettag_c_setVariable_54_3.doEnd();
                    _jettag_c_if_53_2.handleBodyContent(out);
                }
                _jettag_c_if_53_2.doEnd();
                RuntimeTagElement _jettag_c_if_56_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_56_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_56_2.setRuntimeParent(_jettag_c_iterate_46_1);
                _jettag_c_if_56_2.setTagInfo(_td_c_if_56_2);
                _jettag_c_if_56_2.doStart(context, out);
                while (_jettag_c_if_56_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_57_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_57_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_57_3.setRuntimeParent(_jettag_c_if_56_2);
                    _jettag_c_setVariable_57_3.setTagInfo(_td_c_setVariable_57_3);
                    _jettag_c_setVariable_57_3.doStart(context, out);
                    _jettag_c_setVariable_57_3.doEnd();
                    _jettag_c_if_56_2.handleBodyContent(out);
                }
                _jettag_c_if_56_2.doEnd();
                RuntimeTagElement _jettag_c_if_59_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_59_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_59_2.setRuntimeParent(_jettag_c_iterate_46_1);
                _jettag_c_if_59_2.setTagInfo(_td_c_if_59_2);
                _jettag_c_if_59_2.doStart(context, out);
                while (_jettag_c_if_59_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_60_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_60_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_60_3.setRuntimeParent(_jettag_c_if_59_2);
                    _jettag_c_setVariable_60_3.setTagInfo(_td_c_setVariable_60_3);
                    _jettag_c_setVariable_60_3.doStart(context, out);
                    _jettag_c_setVariable_60_3.doEnd();
                    _jettag_c_if_59_2.handleBodyContent(out);
                }
                _jettag_c_if_59_2.doEnd();
                _jettag_c_iterate_46_1.handleBodyContent(out);
            }
            _jettag_c_iterate_46_1.doEnd();
            // check all packages for DataTypes  
            RuntimeTagElement _jettag_c_iterate_64_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_64_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_64_1.setRuntimeParent(_jettag_c_iterate_5_1);
            _jettag_c_iterate_64_1.setTagInfo(_td_c_iterate_64_1);
            _jettag_c_iterate_64_1.doStart(context, out);
            while (_jettag_c_iterate_64_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_if_65_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_65_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_65_2.setRuntimeParent(_jettag_c_iterate_64_1);
                _jettag_c_if_65_2.setTagInfo(_td_c_if_65_2);
                _jettag_c_if_65_2.doStart(context, out);
                while (_jettag_c_if_65_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_66_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_66_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_66_3.setRuntimeParent(_jettag_c_if_65_2);
                    _jettag_c_setVariable_66_3.setTagInfo(_td_c_setVariable_66_3);
                    _jettag_c_setVariable_66_3.doStart(context, out);
                    _jettag_c_setVariable_66_3.doEnd();
                    _jettag_c_if_65_2.handleBodyContent(out);
                }
                _jettag_c_if_65_2.doEnd();
                RuntimeTagElement _jettag_c_if_68_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_68_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_68_2.setRuntimeParent(_jettag_c_iterate_64_1);
                _jettag_c_if_68_2.setTagInfo(_td_c_if_68_2);
                _jettag_c_if_68_2.doStart(context, out);
                while (_jettag_c_if_68_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_69_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_69_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_69_3.setRuntimeParent(_jettag_c_if_68_2);
                    _jettag_c_setVariable_69_3.setTagInfo(_td_c_setVariable_69_3);
                    _jettag_c_setVariable_69_3.doStart(context, out);
                    _jettag_c_setVariable_69_3.doEnd();
                    _jettag_c_if_68_2.handleBodyContent(out);
                }
                _jettag_c_if_68_2.doEnd();
                RuntimeTagElement _jettag_c_if_71_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_71_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_71_2.setRuntimeParent(_jettag_c_iterate_64_1);
                _jettag_c_if_71_2.setTagInfo(_td_c_if_71_2);
                _jettag_c_if_71_2.doStart(context, out);
                while (_jettag_c_if_71_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_72_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_72_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_72_3.setRuntimeParent(_jettag_c_if_71_2);
                    _jettag_c_setVariable_72_3.setTagInfo(_td_c_setVariable_72_3);
                    _jettag_c_setVariable_72_3.doStart(context, out);
                    _jettag_c_setVariable_72_3.doEnd();
                    _jettag_c_if_71_2.handleBodyContent(out);
                }
                _jettag_c_if_71_2.doEnd();
                RuntimeTagElement _jettag_c_if_74_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_74_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_74_2.setRuntimeParent(_jettag_c_iterate_64_1);
                _jettag_c_if_74_2.setTagInfo(_td_c_if_74_2);
                _jettag_c_if_74_2.doStart(context, out);
                while (_jettag_c_if_74_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_75_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_75_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_75_3.setRuntimeParent(_jettag_c_if_74_2);
                    _jettag_c_setVariable_75_3.setTagInfo(_td_c_setVariable_75_3);
                    _jettag_c_setVariable_75_3.doStart(context, out);
                    _jettag_c_setVariable_75_3.doEnd();
                    _jettag_c_if_74_2.handleBodyContent(out);
                }
                _jettag_c_if_74_2.doEnd();
                RuntimeTagElement _jettag_c_if_77_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_77_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_77_2.setRuntimeParent(_jettag_c_iterate_64_1);
                _jettag_c_if_77_2.setTagInfo(_td_c_if_77_2);
                _jettag_c_if_77_2.doStart(context, out);
                while (_jettag_c_if_77_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_78_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_78_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_78_3.setRuntimeParent(_jettag_c_if_77_2);
                    _jettag_c_setVariable_78_3.setTagInfo(_td_c_setVariable_78_3);
                    _jettag_c_setVariable_78_3.doStart(context, out);
                    _jettag_c_setVariable_78_3.doEnd();
                    _jettag_c_if_77_2.handleBodyContent(out);
                }
                _jettag_c_if_77_2.doEnd();
                RuntimeTagElement _jettag_c_if_80_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_80_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_80_2.setRuntimeParent(_jettag_c_iterate_64_1);
                _jettag_c_if_80_2.setTagInfo(_td_c_if_80_2);
                _jettag_c_if_80_2.doStart(context, out);
                while (_jettag_c_if_80_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_81_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_81_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_81_3.setRuntimeParent(_jettag_c_if_80_2);
                    _jettag_c_setVariable_81_3.setTagInfo(_td_c_setVariable_81_3);
                    _jettag_c_setVariable_81_3.doStart(context, out);
                    _jettag_c_setVariable_81_3.doEnd();
                    _jettag_c_if_80_2.handleBodyContent(out);
                }
                _jettag_c_if_80_2.doEnd();
                RuntimeTagElement _jettag_c_if_83_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_83_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_83_2.setRuntimeParent(_jettag_c_iterate_64_1);
                _jettag_c_if_83_2.setTagInfo(_td_c_if_83_2);
                _jettag_c_if_83_2.doStart(context, out);
                while (_jettag_c_if_83_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_84_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_84_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_84_3.setRuntimeParent(_jettag_c_if_83_2);
                    _jettag_c_setVariable_84_3.setTagInfo(_td_c_setVariable_84_3);
                    _jettag_c_setVariable_84_3.doStart(context, out);
                    _jettag_c_setVariable_84_3.doEnd();
                    _jettag_c_if_83_2.handleBodyContent(out);
                }
                _jettag_c_if_83_2.doEnd();
                RuntimeTagElement _jettag_c_if_86_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_86_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_86_2.setRuntimeParent(_jettag_c_iterate_64_1);
                _jettag_c_if_86_2.setTagInfo(_td_c_if_86_2);
                _jettag_c_if_86_2.doStart(context, out);
                while (_jettag_c_if_86_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_87_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_87_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_87_3.setRuntimeParent(_jettag_c_if_86_2);
                    _jettag_c_setVariable_87_3.setTagInfo(_td_c_setVariable_87_3);
                    _jettag_c_setVariable_87_3.doStart(context, out);
                    _jettag_c_setVariable_87_3.doEnd();
                    _jettag_c_if_86_2.handleBodyContent(out);
                }
                _jettag_c_if_86_2.doEnd();
                RuntimeTagElement _jettag_c_if_89_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_89_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_89_2.setRuntimeParent(_jettag_c_iterate_64_1);
                _jettag_c_if_89_2.setTagInfo(_td_c_if_89_2);
                _jettag_c_if_89_2.doStart(context, out);
                while (_jettag_c_if_89_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_90_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_90_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_90_3.setRuntimeParent(_jettag_c_if_89_2);
                    _jettag_c_setVariable_90_3.setTagInfo(_td_c_setVariable_90_3);
                    _jettag_c_setVariable_90_3.doStart(context, out);
                    _jettag_c_setVariable_90_3.doEnd();
                    _jettag_c_if_89_2.handleBodyContent(out);
                }
                _jettag_c_if_89_2.doEnd();
                _jettag_c_iterate_64_1.handleBodyContent(out);
            }
            _jettag_c_iterate_64_1.doEnd();
            _jettag_c_iterate_5_1.handleBodyContent(out);
        }
        _jettag_c_iterate_5_1.doEnd();
    }
}
