package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_entity_menuxml_0 implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$

    public _jet_entity_menuxml_0() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_c_setVariable_1_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            1, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_4_1 = new TagInfo("c:if", //$NON-NLS-1$
            4, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_5_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            5, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_7_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            7, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_8_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            8, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_9_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            9, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_10_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            10, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_12_13 = new TagInfo("c:if", //$NON-NLS-1$
            12, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_14_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            14, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_16_18 = new TagInfo("c:if", //$NON-NLS-1$
            16, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_17_18 = new TagInfo("c:if", //$NON-NLS-1$
            17, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'none')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_18_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            18, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_20_21 = new TagInfo("c:if", //$NON-NLS-1$
            20, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_22_19 = new TagInfo("c:if", //$NON-NLS-1$
            22, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_24_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            24, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_25_23 = new TagInfo("c:if", //$NON-NLS-1$
            25, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_42_1 = new TagInfo("c:if", //$NON-NLS-1$
            42, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_43_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            43, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_45_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            45, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_46_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            46, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_47_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            47, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_48_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            48, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_50_13 = new TagInfo("c:if", //$NON-NLS-1$
            50, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_52_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            52, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_54_18 = new TagInfo("c:if", //$NON-NLS-1$
            54, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_55_18 = new TagInfo("c:if", //$NON-NLS-1$
            55, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'none')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_56_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            56, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_58_21 = new TagInfo("c:if", //$NON-NLS-1$
            58, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_60_19 = new TagInfo("c:if", //$NON-NLS-1$
            60, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_62_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            62, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_63_23 = new TagInfo("c:if", //$NON-NLS-1$
            63, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_80_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            80, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_82_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            82, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_83_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            83, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_84_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            84, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_85_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            85, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_87_6 = new TagInfo("c:if", //$NON-NLS-1$
            87, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_89_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            89, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_91_12 = new TagInfo("c:if", //$NON-NLS-1$
            91, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_92_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            92, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_94_14 = new TagInfo("c:if", //$NON-NLS-1$
            94, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_96_14 = new TagInfo("c:if", //$NON-NLS-1$
            96, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_98_9 = new TagInfo("c:if", //$NON-NLS-1$
            98, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_99_11 = new TagInfo("c:if", //$NON-NLS-1$
            99, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_101_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            101, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_102_16 = new TagInfo("c:if", //$NON-NLS-1$
            102, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        RuntimeTagElement _jettag_c_setVariable_1_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_1_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_1_1.setRuntimeParent(null);
        _jettag_c_setVariable_1_1.setTagInfo(_td_c_setVariable_1_1);
        _jettag_c_setVariable_1_1.doStart(context, out);
        _jettag_c_setVariable_1_1.doEnd();
        out.write("<menu xmlns:android=\"http://schemas.android.com/apk/res/android\">");  //$NON-NLS-1$        
        out.write(NL);         
        //process level 1 generizations 
        RuntimeTagElement _jettag_c_if_4_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_4_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_4_1.setRuntimeParent(null);
        _jettag_c_if_4_1.setTagInfo(_td_c_if_4_1);
        _jettag_c_if_4_1.doStart(context, out);
        while (_jettag_c_if_4_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_setVariable_5_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_5_6); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_setVariable_5_6.setRuntimeParent(_jettag_c_if_4_1);
            _jettag_c_setVariable_5_6.setTagInfo(_td_c_setVariable_5_6);
            _jettag_c_setVariable_5_6.doStart(context, out);
            _jettag_c_setVariable_5_6.doEnd();
            // process the assocations for level 1 class 
            RuntimeTagElement _jettag_c_iterate_7_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_7_8); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_7_8.setRuntimeParent(_jettag_c_if_4_1);
            _jettag_c_iterate_7_8.setTagInfo(_td_c_iterate_7_8);
            _jettag_c_iterate_7_8.doStart(context, out);
            while (_jettag_c_iterate_7_8.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_8_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_8_9); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_8_9.setRuntimeParent(_jettag_c_iterate_7_8);
                _jettag_c_iterate_8_9.setTagInfo(_td_c_iterate_8_9);
                _jettag_c_iterate_8_9.doStart(context, out);
                while (_jettag_c_iterate_8_9.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_9_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_9_10); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_9_10.setRuntimeParent(_jettag_c_iterate_8_9);
                    _jettag_c_iterate_9_10.setTagInfo(_td_c_iterate_9_10);
                    _jettag_c_iterate_9_10.doStart(context, out);
                    while (_jettag_c_iterate_9_10.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_setVariable_10_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_10_11); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_10_11.setRuntimeParent(_jettag_c_iterate_9_10);
                        _jettag_c_setVariable_10_11.setTagInfo(_td_c_setVariable_10_11);
                        _jettag_c_setVariable_10_11.doStart(context, out);
                        _jettag_c_setVariable_10_11.doEnd();
                        // check is the association is corresponding to the class  
                        RuntimeTagElement _jettag_c_if_12_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_12_13); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_12_13.setRuntimeParent(_jettag_c_iterate_9_10);
                        _jettag_c_if_12_13.setTagInfo(_td_c_if_12_13);
                        _jettag_c_if_12_13.doStart(context, out);
                        while (_jettag_c_if_12_13.okToProcessBody()) {
                            // iterate over the iterations ends  
                            RuntimeTagElement _jettag_c_iterate_14_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_14_19); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_14_19.setRuntimeParent(_jettag_c_if_12_13);
                            _jettag_c_iterate_14_19.setTagInfo(_td_c_iterate_14_19);
                            _jettag_c_iterate_14_19.doStart(context, out);
                            while (_jettag_c_iterate_14_19.okToProcessBody()) {
                                // process only non composits or non aggregations and 
                                RuntimeTagElement _jettag_c_if_16_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_16_18); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_16_18.setRuntimeParent(_jettag_c_iterate_14_19);
                                _jettag_c_if_16_18.setTagInfo(_td_c_if_16_18);
                                _jettag_c_if_16_18.doStart(context, out);
                                while (_jettag_c_if_16_18.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_17_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_17_18); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_17_18.setRuntimeParent(_jettag_c_if_16_18);
                                    _jettag_c_if_17_18.setTagInfo(_td_c_if_17_18);
                                    _jettag_c_if_17_18.doStart(context, out);
                                    while (_jettag_c_if_17_18.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_18_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_18_19); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_18_19.setRuntimeParent(_jettag_c_if_17_18);
                                        _jettag_c_setVariable_18_19.setTagInfo(_td_c_setVariable_18_19);
                                        _jettag_c_setVariable_18_19.doStart(context, out);
                                        _jettag_c_setVariable_18_19.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_20_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_20_21); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_20_21.setRuntimeParent(_jettag_c_if_17_18);
                                        _jettag_c_if_20_21.setTagInfo(_td_c_if_20_21);
                                        _jettag_c_if_20_21.doStart(context, out);
                                        while (_jettag_c_if_20_21.okToProcessBody()) {
                                            // check to see if this is a navigable relation
                                            RuntimeTagElement _jettag_c_if_22_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_22_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_22_19.setRuntimeParent(_jettag_c_if_20_21);
                                            _jettag_c_if_22_19.setTagInfo(_td_c_if_22_19);
                                            _jettag_c_if_22_19.doStart(context, out);
                                            while (_jettag_c_if_22_19.okToProcessBody()) {
                                                // iterate throught all the classes to get the other class on the association
                                                RuntimeTagElement _jettag_c_iterate_24_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_24_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_iterate_24_22.setRuntimeParent(_jettag_c_if_22_19);
                                                _jettag_c_iterate_24_22.setTagInfo(_td_c_iterate_24_22);
                                                _jettag_c_iterate_24_22.doStart(context, out);
                                                while (_jettag_c_iterate_24_22.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_25_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_25_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_25_23.setRuntimeParent(_jettag_c_iterate_24_22);
                                                    _jettag_c_if_25_23.setTagInfo(_td_c_if_25_23);
                                                    _jettag_c_if_25_23.doStart(context, out);
                                                    while (_jettag_c_if_25_23.okToProcessBody()) {
                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <item android:id=\"@+id/");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 26, 44)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("_");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 26, 72)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("s_menu\"");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          android:title=\"");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 27, 42)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("s\" />");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_25_23.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_25_23.doEnd();
                                                    _jettag_c_iterate_24_22.handleBodyContent(out);
                                                }
                                                _jettag_c_iterate_24_22.doEnd();
                                                _jettag_c_if_22_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_22_19.doEnd();
                                            _jettag_c_if_20_21.handleBodyContent(out);
                                        }
                                        _jettag_c_if_20_21.doEnd();
                                        _jettag_c_if_17_18.handleBodyContent(out);
                                    }
                                    _jettag_c_if_17_18.doEnd();
                                    _jettag_c_if_16_18.handleBodyContent(out);
                                }
                                _jettag_c_if_16_18.doEnd();
                                _jettag_c_iterate_14_19.handleBodyContent(out);
                            }
                            _jettag_c_iterate_14_19.doEnd();
                            out.write("\t\t\t\t\t\t\t  \t\t\t\t\t \t\t\t\t\t\t \t \t\t\t\t \t  ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_if_12_13.handleBodyContent(out);
                        }
                        _jettag_c_if_12_13.doEnd();
                        _jettag_c_iterate_9_10.handleBodyContent(out);
                    }
                    _jettag_c_iterate_9_10.doEnd();
                    _jettag_c_iterate_8_9.handleBodyContent(out);
                }
                _jettag_c_iterate_8_9.doEnd();
                _jettag_c_iterate_7_8.handleBodyContent(out);
            }
            _jettag_c_iterate_7_8.doEnd();
            _jettag_c_if_4_1.handleBodyContent(out);
        }
        _jettag_c_if_4_1.doEnd();
        //process level 2 generizations 
        RuntimeTagElement _jettag_c_if_42_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_42_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_42_1.setRuntimeParent(null);
        _jettag_c_if_42_1.setTagInfo(_td_c_if_42_1);
        _jettag_c_if_42_1.doStart(context, out);
        while (_jettag_c_if_42_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_setVariable_43_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_43_6); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_setVariable_43_6.setRuntimeParent(_jettag_c_if_42_1);
            _jettag_c_setVariable_43_6.setTagInfo(_td_c_setVariable_43_6);
            _jettag_c_setVariable_43_6.doStart(context, out);
            _jettag_c_setVariable_43_6.doEnd();
            // process the assocations for level 1 class 
            RuntimeTagElement _jettag_c_iterate_45_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_45_8); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_45_8.setRuntimeParent(_jettag_c_if_42_1);
            _jettag_c_iterate_45_8.setTagInfo(_td_c_iterate_45_8);
            _jettag_c_iterate_45_8.doStart(context, out);
            while (_jettag_c_iterate_45_8.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_46_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_46_9); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_46_9.setRuntimeParent(_jettag_c_iterate_45_8);
                _jettag_c_iterate_46_9.setTagInfo(_td_c_iterate_46_9);
                _jettag_c_iterate_46_9.doStart(context, out);
                while (_jettag_c_iterate_46_9.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_47_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_47_10); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_47_10.setRuntimeParent(_jettag_c_iterate_46_9);
                    _jettag_c_iterate_47_10.setTagInfo(_td_c_iterate_47_10);
                    _jettag_c_iterate_47_10.doStart(context, out);
                    while (_jettag_c_iterate_47_10.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_setVariable_48_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_48_11); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_48_11.setRuntimeParent(_jettag_c_iterate_47_10);
                        _jettag_c_setVariable_48_11.setTagInfo(_td_c_setVariable_48_11);
                        _jettag_c_setVariable_48_11.doStart(context, out);
                        _jettag_c_setVariable_48_11.doEnd();
                        // check is the association is corresponding to the class  
                        RuntimeTagElement _jettag_c_if_50_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_50_13); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_50_13.setRuntimeParent(_jettag_c_iterate_47_10);
                        _jettag_c_if_50_13.setTagInfo(_td_c_if_50_13);
                        _jettag_c_if_50_13.doStart(context, out);
                        while (_jettag_c_if_50_13.okToProcessBody()) {
                            // iterate over the iterations ends  
                            RuntimeTagElement _jettag_c_iterate_52_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_52_19); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_52_19.setRuntimeParent(_jettag_c_if_50_13);
                            _jettag_c_iterate_52_19.setTagInfo(_td_c_iterate_52_19);
                            _jettag_c_iterate_52_19.doStart(context, out);
                            while (_jettag_c_iterate_52_19.okToProcessBody()) {
                                // process only non composits or non aggregations and 
                                RuntimeTagElement _jettag_c_if_54_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_54_18); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_54_18.setRuntimeParent(_jettag_c_iterate_52_19);
                                _jettag_c_if_54_18.setTagInfo(_td_c_if_54_18);
                                _jettag_c_if_54_18.doStart(context, out);
                                while (_jettag_c_if_54_18.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_55_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_55_18); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_55_18.setRuntimeParent(_jettag_c_if_54_18);
                                    _jettag_c_if_55_18.setTagInfo(_td_c_if_55_18);
                                    _jettag_c_if_55_18.doStart(context, out);
                                    while (_jettag_c_if_55_18.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_56_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_56_19); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_56_19.setRuntimeParent(_jettag_c_if_55_18);
                                        _jettag_c_setVariable_56_19.setTagInfo(_td_c_setVariable_56_19);
                                        _jettag_c_setVariable_56_19.doStart(context, out);
                                        _jettag_c_setVariable_56_19.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_58_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_58_21); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_58_21.setRuntimeParent(_jettag_c_if_55_18);
                                        _jettag_c_if_58_21.setTagInfo(_td_c_if_58_21);
                                        _jettag_c_if_58_21.doStart(context, out);
                                        while (_jettag_c_if_58_21.okToProcessBody()) {
                                            // check to see if this is a navigable relation
                                            RuntimeTagElement _jettag_c_if_60_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_60_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_60_19.setRuntimeParent(_jettag_c_if_58_21);
                                            _jettag_c_if_60_19.setTagInfo(_td_c_if_60_19);
                                            _jettag_c_if_60_19.doStart(context, out);
                                            while (_jettag_c_if_60_19.okToProcessBody()) {
                                                // iterate throught all the classes to get the other class on the association
                                                RuntimeTagElement _jettag_c_iterate_62_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_62_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_iterate_62_22.setRuntimeParent(_jettag_c_if_60_19);
                                                _jettag_c_iterate_62_22.setTagInfo(_td_c_iterate_62_22);
                                                _jettag_c_iterate_62_22.doStart(context, out);
                                                while (_jettag_c_iterate_62_22.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_63_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_63_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_63_23.setRuntimeParent(_jettag_c_iterate_62_22);
                                                    _jettag_c_if_63_23.setTagInfo(_td_c_if_63_23);
                                                    _jettag_c_if_63_23.doStart(context, out);
                                                    while (_jettag_c_if_63_23.okToProcessBody()) {
                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <item android:id=\"@+id/");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 64, 44)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("_");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 64, 72)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("s_menu\"");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          android:title=\"");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 65, 42)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("s\" />");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_63_23.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_63_23.doEnd();
                                                    _jettag_c_iterate_62_22.handleBodyContent(out);
                                                }
                                                _jettag_c_iterate_62_22.doEnd();
                                                _jettag_c_if_60_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_60_19.doEnd();
                                            _jettag_c_if_58_21.handleBodyContent(out);
                                        }
                                        _jettag_c_if_58_21.doEnd();
                                        _jettag_c_if_55_18.handleBodyContent(out);
                                    }
                                    _jettag_c_if_55_18.doEnd();
                                    _jettag_c_if_54_18.handleBodyContent(out);
                                }
                                _jettag_c_if_54_18.doEnd();
                                _jettag_c_iterate_52_19.handleBodyContent(out);
                            }
                            _jettag_c_iterate_52_19.doEnd();
                            out.write("\t\t\t\t\t\t\t  \t\t\t\t\t \t\t\t\t\t\t \t \t\t\t\t \t  ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_if_50_13.handleBodyContent(out);
                        }
                        _jettag_c_if_50_13.doEnd();
                        _jettag_c_iterate_47_10.handleBodyContent(out);
                    }
                    _jettag_c_iterate_47_10.doEnd();
                    _jettag_c_iterate_46_9.handleBodyContent(out);
                }
                _jettag_c_iterate_46_9.doEnd();
                _jettag_c_iterate_45_8.handleBodyContent(out);
            }
            _jettag_c_iterate_45_8.doEnd();
            _jettag_c_if_42_1.handleBodyContent(out);
        }
        _jettag_c_if_42_1.doEnd();
        out.write(NL);         
        RuntimeTagElement _jettag_c_setVariable_80_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_80_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_80_1.setRuntimeParent(null);
        _jettag_c_setVariable_80_1.setTagInfo(_td_c_setVariable_80_1);
        _jettag_c_setVariable_80_1.doStart(context, out);
        _jettag_c_setVariable_80_1.doEnd();
        //process 0 level class relations 
        RuntimeTagElement _jettag_c_iterate_82_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_82_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_82_1.setRuntimeParent(null);
        _jettag_c_iterate_82_1.setTagInfo(_td_c_iterate_82_1);
        _jettag_c_iterate_82_1.doStart(context, out);
        while (_jettag_c_iterate_82_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_83_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_83_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_83_2.setRuntimeParent(_jettag_c_iterate_82_1);
            _jettag_c_iterate_83_2.setTagInfo(_td_c_iterate_83_2);
            _jettag_c_iterate_83_2.doStart(context, out);
            while (_jettag_c_iterate_83_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_84_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_84_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_84_3.setRuntimeParent(_jettag_c_iterate_83_2);
                _jettag_c_iterate_84_3.setTagInfo(_td_c_iterate_84_3);
                _jettag_c_iterate_84_3.doStart(context, out);
                while (_jettag_c_iterate_84_3.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_85_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_85_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_85_4.setRuntimeParent(_jettag_c_iterate_84_3);
                    _jettag_c_setVariable_85_4.setTagInfo(_td_c_setVariable_85_4);
                    _jettag_c_setVariable_85_4.doStart(context, out);
                    _jettag_c_setVariable_85_4.doEnd();
                    // check is the association is corresponding to the class  
                    RuntimeTagElement _jettag_c_if_87_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_87_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_87_6.setRuntimeParent(_jettag_c_iterate_84_3);
                    _jettag_c_if_87_6.setTagInfo(_td_c_if_87_6);
                    _jettag_c_if_87_6.doStart(context, out);
                    while (_jettag_c_if_87_6.okToProcessBody()) {
                        // iterate over the iterations ends  
                        RuntimeTagElement _jettag_c_iterate_89_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_89_12); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_89_12.setRuntimeParent(_jettag_c_if_87_6);
                        _jettag_c_iterate_89_12.setTagInfo(_td_c_iterate_89_12);
                        _jettag_c_iterate_89_12.doStart(context, out);
                        while (_jettag_c_iterate_89_12.okToProcessBody()) {
                            // process only non composits or non aggregations and 
                            RuntimeTagElement _jettag_c_if_91_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_91_12); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_91_12.setRuntimeParent(_jettag_c_iterate_89_12);
                            _jettag_c_if_91_12.setTagInfo(_td_c_if_91_12);
                            _jettag_c_if_91_12.doStart(context, out);
                            while (_jettag_c_if_91_12.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_92_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_92_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_92_12.setRuntimeParent(_jettag_c_if_91_12);
                                _jettag_c_setVariable_92_12.setTagInfo(_td_c_setVariable_92_12);
                                _jettag_c_setVariable_92_12.doStart(context, out);
                                _jettag_c_setVariable_92_12.doEnd();
                                // get the end secondary end with other class  
                                RuntimeTagElement _jettag_c_if_94_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_94_14); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_94_14.setRuntimeParent(_jettag_c_if_91_12);
                                _jettag_c_if_94_14.setTagInfo(_td_c_if_94_14);
                                _jettag_c_if_94_14.doStart(context, out);
                                while (_jettag_c_if_94_14.okToProcessBody()) {
                                    // check to see if this is a navigable relation
                                    RuntimeTagElement _jettag_c_if_96_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_96_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_96_14.setRuntimeParent(_jettag_c_if_94_14);
                                    _jettag_c_if_96_14.setTagInfo(_td_c_if_96_14);
                                    _jettag_c_if_96_14.doStart(context, out);
                                    while (_jettag_c_if_96_14.okToProcessBody()) {
                                        // process many on target
                                        RuntimeTagElement _jettag_c_if_98_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_98_9); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_98_9.setRuntimeParent(_jettag_c_if_96_14);
                                        _jettag_c_if_98_9.setTagInfo(_td_c_if_98_9);
                                        _jettag_c_if_98_9.doStart(context, out);
                                        while (_jettag_c_if_98_9.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_99_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_99_11); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_99_11.setRuntimeParent(_jettag_c_if_98_9);
                                            _jettag_c_if_99_11.setTagInfo(_td_c_if_99_11);
                                            _jettag_c_if_99_11.doStart(context, out);
                                            while (_jettag_c_if_99_11.okToProcessBody()) {
                                                // iterate throught all the classes to get the other class on the association
                                                RuntimeTagElement _jettag_c_iterate_101_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_101_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_iterate_101_15.setRuntimeParent(_jettag_c_if_99_11);
                                                _jettag_c_iterate_101_15.setTagInfo(_td_c_iterate_101_15);
                                                _jettag_c_iterate_101_15.doStart(context, out);
                                                while (_jettag_c_iterate_101_15.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_102_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_102_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_102_16.setRuntimeParent(_jettag_c_iterate_101_15);
                                                    _jettag_c_if_102_16.setTagInfo(_td_c_if_102_16);
                                                    _jettag_c_if_102_16.doStart(context, out);
                                                    while (_jettag_c_if_102_16.okToProcessBody()) {
                                                        out.write("\t\t\t\t\t\t\t\t\t    <item android:id=\"@+id/");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 103, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("_");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 103, 65)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("s_menu\"");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t\t\t          android:title=\"");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 104, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("s\" />");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_102_16.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_102_16.doEnd();
                                                    _jettag_c_iterate_101_15.handleBodyContent(out);
                                                }
                                                _jettag_c_iterate_101_15.doEnd();
                                                _jettag_c_if_99_11.handleBodyContent(out);
                                            }
                                            _jettag_c_if_99_11.doEnd();
                                            _jettag_c_if_98_9.handleBodyContent(out);
                                        }
                                        _jettag_c_if_98_9.doEnd();
                                        _jettag_c_if_96_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_96_14.doEnd();
                                    _jettag_c_if_94_14.handleBodyContent(out);
                                }
                                _jettag_c_if_94_14.doEnd();
                                _jettag_c_if_91_12.handleBodyContent(out);
                            }
                            _jettag_c_if_91_12.doEnd();
                            _jettag_c_iterate_89_12.handleBodyContent(out);
                        }
                        _jettag_c_iterate_89_12.doEnd();
                        _jettag_c_if_87_6.handleBodyContent(out);
                    }
                    _jettag_c_if_87_6.doEnd();
                    _jettag_c_iterate_84_3.handleBodyContent(out);
                }
                _jettag_c_iterate_84_3.doEnd();
                _jettag_c_iterate_83_2.handleBodyContent(out);
            }
            _jettag_c_iterate_83_2.doEnd();
            _jettag_c_iterate_82_1.handleBodyContent(out);
        }
        _jettag_c_iterate_82_1.doEnd();
        out.write("</menu>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
    }
}
