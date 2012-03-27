package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_required_fields implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$

    public _jet_required_fields() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_c_iterate_1_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            1, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_2_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            2, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_3_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            3, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_4_6 = new TagInfo("c:set", //$NON-NLS-1$
            4, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$attribute", //$NON-NLS-1$
                "isRequired", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_5_7 = new TagInfo("c:iterate", //$NON-NLS-1$
            5, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/ModelElement.stereotype", //$NON-NLS-1$
                "stereoType", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_7_4 = new TagInfo("c:if", //$NON-NLS-1$
            7, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereoType/Stereotype/@href = $NotEmptyID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_8_5 = new TagInfo("c:set", //$NON-NLS-1$
            8, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$attribute", //$NON-NLS-1$
                "isRequired", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_10_4 = new TagInfo("c:if", //$NON-NLS-1$
            10, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereoType/Stereotype/@href = $NotNullID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_11_5 = new TagInfo("c:set", //$NON-NLS-1$
            11, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$attribute", //$NON-NLS-1$
                "isRequired", //$NON-NLS-1$
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        RuntimeTagElement _jettag_c_iterate_1_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_1_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_1_1.setRuntimeParent(null);
        _jettag_c_iterate_1_1.setTagInfo(_td_c_iterate_1_1);
        _jettag_c_iterate_1_1.doStart(context, out);
        while (_jettag_c_iterate_1_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_2_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_2_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_2_2.setRuntimeParent(_jettag_c_iterate_1_1);
            _jettag_c_iterate_2_2.setTagInfo(_td_c_iterate_2_2);
            _jettag_c_iterate_2_2.doStart(context, out);
            while (_jettag_c_iterate_2_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_3_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_3_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_3_3.setRuntimeParent(_jettag_c_iterate_2_2);
                _jettag_c_iterate_3_3.setTagInfo(_td_c_iterate_3_3);
                _jettag_c_iterate_3_3.doStart(context, out);
                while (_jettag_c_iterate_3_3.okToProcessBody()) {
                    out.write("    \t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_set_4_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_4_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_set_4_6.setRuntimeParent(_jettag_c_iterate_3_3);
                    _jettag_c_set_4_6.setTagInfo(_td_c_set_4_6);
                    _jettag_c_set_4_6.doStart(context, out);
                    JET2Writer _jettag_c_set_4_6_saved_out = out;
                    while (_jettag_c_set_4_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("false");  //$NON-NLS-1$        
                        _jettag_c_set_4_6.handleBodyContent(out);
                    }
                    out = _jettag_c_set_4_6_saved_out;
                    _jettag_c_set_4_6.doEnd();
                    out.write(NL);         
                    RuntimeTagElement _jettag_c_iterate_5_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_5_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_5_7.setRuntimeParent(_jettag_c_iterate_3_3);
                    _jettag_c_iterate_5_7.setTagInfo(_td_c_iterate_5_7);
                    _jettag_c_iterate_5_7.doStart(context, out);
                    while (_jettag_c_iterate_5_7.okToProcessBody()) {
                        //check for notnull and not empty 
                        RuntimeTagElement _jettag_c_if_7_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_7_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_7_4.setRuntimeParent(_jettag_c_iterate_5_7);
                        _jettag_c_if_7_4.setTagInfo(_td_c_if_7_4);
                        _jettag_c_if_7_4.doStart(context, out);
                        while (_jettag_c_if_7_4.okToProcessBody()) {
                            out.write("\t\t\t\t");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_set_8_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_8_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_set_8_5.setRuntimeParent(_jettag_c_if_7_4);
                            _jettag_c_set_8_5.setTagInfo(_td_c_set_8_5);
                            _jettag_c_set_8_5.doStart(context, out);
                            JET2Writer _jettag_c_set_8_5_saved_out = out;
                            while (_jettag_c_set_8_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("true");  //$NON-NLS-1$        
                                _jettag_c_set_8_5.handleBodyContent(out);
                            }
                            out = _jettag_c_set_8_5_saved_out;
                            _jettag_c_set_8_5.doEnd();
                            out.write("\t\t");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_if_7_4.handleBodyContent(out);
                        }
                        _jettag_c_if_7_4.doEnd();
                        RuntimeTagElement _jettag_c_if_10_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_10_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_10_4.setRuntimeParent(_jettag_c_iterate_5_7);
                        _jettag_c_if_10_4.setTagInfo(_td_c_if_10_4);
                        _jettag_c_if_10_4.doStart(context, out);
                        while (_jettag_c_if_10_4.okToProcessBody()) {
                            out.write("\t\t\t\t");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_set_11_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_11_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_set_11_5.setRuntimeParent(_jettag_c_if_10_4);
                            _jettag_c_set_11_5.setTagInfo(_td_c_set_11_5);
                            _jettag_c_set_11_5.doStart(context, out);
                            JET2Writer _jettag_c_set_11_5_saved_out = out;
                            while (_jettag_c_set_11_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("true");  //$NON-NLS-1$        
                                _jettag_c_set_11_5.handleBodyContent(out);
                            }
                            out = _jettag_c_set_11_5_saved_out;
                            _jettag_c_set_11_5.doEnd();
                            out.write("\t\t");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_if_10_4.handleBodyContent(out);
                        }
                        _jettag_c_if_10_4.doEnd();
                        _jettag_c_iterate_5_7.handleBodyContent(out);
                    }
                    _jettag_c_iterate_5_7.doEnd();
                    _jettag_c_iterate_3_3.handleBodyContent(out);
                }
                _jettag_c_iterate_3_3.doEnd();
                _jettag_c_iterate_2_2.handleBodyContent(out);
            }
            _jettag_c_iterate_2_2.doEnd();
            _jettag_c_iterate_1_1.handleBodyContent(out);
        }
        _jettag_c_iterate_1_1.doEnd();
    }
}
