package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_ejb_service_bean_templatejava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_ejb_service_bean_templatejava() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_java_merge_1_1 = new TagInfo("java:merge", //$NON-NLS-1$
            1, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_java_format_2_1 = new TagInfo("java:format", //$NON-NLS-1$
            2, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_bundle_3_1 = new TagInfo("f:bundle", //$NON-NLS-1$
            3, 1,
            new String[] {
                "basename", //$NON-NLS-1$
            },
            new String[] {
                "templates/resources/messages", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_4_1 = new TagInfo("f:message", //$NON-NLS-1$
            4, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_setVariable_7_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            7, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_30_1 = new TagInfo("f:message", //$NON-NLS-1$
            30, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_35_1 = new TagInfo("f:message", //$NON-NLS-1$
            35, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_39_2 = new TagInfo("f:message", //$NON-NLS-1$
            39, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_43_2 = new TagInfo("f:message", //$NON-NLS-1$
            43, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_49_2 = new TagInfo("f:message", //$NON-NLS-1$
            49, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_55_2 = new TagInfo("f:message", //$NON-NLS-1$
            55, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_67_2 = new TagInfo("f:message", //$NON-NLS-1$
            67, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_76_2 = new TagInfo("f:message", //$NON-NLS-1$
            76, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_82_2 = new TagInfo("f:message", //$NON-NLS-1$
            82, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_88_2 = new TagInfo("f:message", //$NON-NLS-1$
            88, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_103_2 = new TagInfo("f:message", //$NON-NLS-1$
            103, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_112_2 = new TagInfo("f:message", //$NON-NLS-1$
            112, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_127_2 = new TagInfo("f:message", //$NON-NLS-1$
            127, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_156_2 = new TagInfo("f:message", //$NON-NLS-1$
            156, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_161_2 = new TagInfo("f:message", //$NON-NLS-1$
            161, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_166_2 = new TagInfo("f:message", //$NON-NLS-1$
            166, 2,
            new String[] {
            },
            new String[] {
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        RuntimeTagElement _jettag_java_merge_1_1 = context.getTagFactory().createRuntimeTag(_jetns_java, "merge", "java:merge", _td_java_merge_1_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_java_merge_1_1.setRuntimeParent(null);
        _jettag_java_merge_1_1.setTagInfo(_td_java_merge_1_1);
        _jettag_java_merge_1_1.doStart(context, out);
        _jettag_java_merge_1_1.doEnd();
        out.write(NL);         
        RuntimeTagElement _jettag_java_format_2_1 = context.getTagFactory().createRuntimeTag(_jetns_java, "format", "java:format", _td_java_format_2_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_java_format_2_1.setRuntimeParent(null);
        _jettag_java_format_2_1.setTagInfo(_td_java_format_2_1);
        _jettag_java_format_2_1.doStart(context, out);
        JET2Writer _jettag_java_format_2_1_saved_out = out;
        while (_jettag_java_format_2_1.okToProcessBody()) {
            out = out.newNestedContentWriter();
            out.write(NL);         
            RuntimeTagElement _jettag_f_bundle_3_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "bundle", "f:bundle", _td_f_bundle_3_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_f_bundle_3_1.setRuntimeParent(_jettag_java_format_2_1);
            _jettag_f_bundle_3_1.setTagInfo(_td_f_bundle_3_1);
            _jettag_f_bundle_3_1.doStart(context, out);
            while (_jettag_f_bundle_3_1.okToProcessBody()) {
                RuntimeTagElement _jettag_f_message_4_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_4_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_4_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_4_1.setTagInfo(_td_f_message_4_1);
                _jettag_f_message_4_1.doStart(context, out);
                JET2Writer _jettag_f_message_4_1_saved_out = out;
                while (_jettag_f_message_4_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("copyright");  //$NON-NLS-1$        
                    _jettag_f_message_4_1.handleBodyContent(out);
                }
                out = _jettag_f_message_4_1_saved_out;
                _jettag_f_message_4_1.doEnd();
                out.write(NL);         
                out.write(NL);         
                out.write("package ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 6, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".ejb.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$package/@name}", 6, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 6, 43)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_c_setVariable_7_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_7_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_7_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_7_1.setTagInfo(_td_c_setVariable_7_1);
                _jettag_c_setVariable_7_1.doStart(context, out);
                _jettag_c_setVariable_7_1.doEnd();
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 8, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".entity.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 8, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 8, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.ejb.Stateful;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.beans.TableObj;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.List;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.ArrayList;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.server.GWTServletUtils;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.EntityManager;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.PersistenceContext;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.annotation.PostConstruct;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.Query;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.PersistenceUnit;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.lang.reflect.Method;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.Map;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.HashMap;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.Name;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.Destroy;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.ejb.Remove;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.apache.commons.logging.Log;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.apache.commons.logging.LogFactory;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.In;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.io.Serializable;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_30_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_30_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_30_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_30_1.setTagInfo(_td_f_message_30_1);
                _jettag_f_message_30_1.doStart(context, out);
                JET2Writer _jettag_f_message_30_1_saved_out = out;
                while (_jettag_f_message_30_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_30_1.handleBodyContent(out);
                }
                out = _jettag_f_message_30_1_saved_out;
                _jettag_f_message_30_1.doEnd();
                out.write(NL);         
                out.write("@Stateful(name = \"");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 31, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("\")");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("@Name(\"");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 32, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceBean\")");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("public class ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 33, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceBean implements  ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 33, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Service{");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_35_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_35_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_35_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_35_1.setTagInfo(_td_f_message_35_1);
                _jettag_f_message_35_1.doStart(context, out);
                JET2Writer _jettag_f_message_35_1_saved_out = out;
                while (_jettag_f_message_35_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_35_1.handleBodyContent(out);
                }
                out = _jettag_f_message_35_1_saved_out;
                _jettag_f_message_35_1.doEnd();
                out.write(NL);         
                out.write("private static final Log log = LogFactory");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t.getLog(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 37, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceBean.class);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_39_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_39_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_39_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_39_2.setTagInfo(_td_f_message_39_2);
                _jettag_f_message_39_2.doStart(context, out);
                JET2Writer _jettag_f_message_39_2_saved_out = out;
                while (_jettag_f_message_39_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_39_2.handleBodyContent(out);
                }
                out = _jettag_f_message_39_2_saved_out;
                _jettag_f_message_39_2.doEnd();
                out.write(NL);         
                out.write("\t@PersistenceContext(unitName = \"");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$projectName}", 40, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("\")");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected EntityManager entityManager;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_43_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_43_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_43_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_43_2.setTagInfo(_td_f_message_43_2);
                _jettag_f_message_43_2.doStart(context, out);
                JET2Writer _jettag_f_message_43_2_saved_out = out;
                while (_jettag_f_message_43_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_43_2.handleBodyContent(out);
                }
                out = _jettag_f_message_43_2_saved_out;
                _jettag_f_message_43_2.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 45, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" create(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 45, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn entityManager.merge(entity);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_49_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_49_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_49_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_49_2.setTagInfo(_td_f_message_49_2);
                _jettag_f_message_49_2.doStart(context, out);
                JET2Writer _jettag_f_message_49_2_saved_out = out;
                while (_jettag_f_message_49_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_49_2.handleBodyContent(out);
                }
                out = _jettag_f_message_49_2_saved_out;
                _jettag_f_message_49_2.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void delete(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 51, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t// TODO Auto-generated method stub");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_55_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_55_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_55_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_55_2.setTagInfo(_td_f_message_55_2);
                _jettag_f_message_55_2.doStart(context, out);
                JET2Writer _jettag_f_message_55_2_saved_out = out;
                while (_jettag_f_message_55_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_55_2.handleBodyContent(out);
                }
                out = _jettag_f_message_55_2_saved_out;
                _jettag_f_message_55_2.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic List<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 57, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> getEntities(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 57, 43)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tList<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 58, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> entities = new ArrayList<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 58, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(">();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tQuery getEntities = entityManager.createQuery(GWTServletUtils");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t.getSearchQueryString(entity));");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tfor (Object obj : getEntities.getResultList()) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tentities.add((");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 62, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(") obj);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn entities;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_67_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_67_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_67_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_67_2.setTagInfo(_td_f_message_67_2);
                _jettag_f_message_67_2.doStart(context, out);
                JET2Writer _jettag_f_message_67_2_saved_out = out;
                while (_jettag_f_message_67_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_67_2.handleBodyContent(out);
                }
                out = _jettag_f_message_67_2_saved_out;
                _jettag_f_message_67_2.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic TableObj getTableObj(int start) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tTableObj<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 70, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> tableObj = new TableObj<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 70, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(">();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\ttableObj.setNumberOfRecords(getEntitySizeT(new ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 71, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("()));");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\ttableObj.setRecords(getEntitiesT(new ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 72, 40)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("(), start));");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn tableObj;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_76_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_76_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_76_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_76_2.setTagInfo(_td_f_message_76_2);
                _jettag_f_message_76_2.doStart(context, out);
                JET2Writer _jettag_f_message_76_2_saved_out = out;
                while (_jettag_f_message_76_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_76_2.handleBodyContent(out);
                }
                out = _jettag_f_message_76_2_saved_out;
                _jettag_f_message_76_2.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 78, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" read( Long id) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\treturn entityManager.find(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 79, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".class,id);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_82_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_82_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_82_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_82_2.setTagInfo(_td_f_message_82_2);
                _jettag_f_message_82_2.doStart(context, out);
                JET2Writer _jettag_f_message_82_2_saved_out = out;
                while (_jettag_f_message_82_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_82_2.handleBodyContent(out);
                }
                out = _jettag_f_message_82_2_saved_out;
                _jettag_f_message_82_2.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 84, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" update(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 84, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn entityManager.merge(entity);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_88_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_88_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_88_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_88_2.setTagInfo(_td_f_message_88_2);
                _jettag_f_message_88_2.doStart(context, out);
                JET2Writer _jettag_f_message_88_2_saved_out = out;
                while (_jettag_f_message_88_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_88_2.handleBodyContent(out);
                }
                out = _jettag_f_message_88_2_saved_out;
                _jettag_f_message_88_2.doEnd();
                out.write(NL);         
                out.write("\tpublic <T extends Serializable> List<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 89, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> getEntitiesT(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 89, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity, int start) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tList<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 90, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> entities = new ArrayList<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 90, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(">();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tString query = \"from \" + entity.getClass().getCanonicalName();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tlog.debug(query);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tQuery getEntitites = entityManager.createQuery(query);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tgetEntitites.setFirstResult(start);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tgetEntitites.setMaxResults(10);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tfor (Object obj : getEntitites.getResultList()) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 97, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" clone = ((");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 97, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(") obj);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tentities.add(clone);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn entities;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_103_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_103_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_103_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_103_2.setTagInfo(_td_f_message_103_2);
                _jettag_f_message_103_2.doStart(context, out);
                JET2Writer _jettag_f_message_103_2_saved_out = out;
                while (_jettag_f_message_103_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_103_2.handleBodyContent(out);
                }
                out = _jettag_f_message_103_2_saved_out;
                _jettag_f_message_103_2.doEnd();
                out.write(NL);         
                out.write("\tpublic <T extends Serializable> Long getEntitySizeT(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 104, 54)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tString query = \"select count(entity) from \"");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t+ entity.getClass().getCanonicalName() + \" entity\";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tlog.debug(query);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tQuery getEntitiesSize = entityManager.createQuery(query);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn (Long) getEntitiesSize.getSingleResult();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_112_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_112_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_112_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_112_2.setTagInfo(_td_f_message_112_2);
                _jettag_f_message_112_2.doStart(context, out);
                JET2Writer _jettag_f_message_112_2_saved_out = out;
                while (_jettag_f_message_112_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_112_2.handleBodyContent(out);
                }
                out = _jettag_f_message_112_2_saved_out;
                _jettag_f_message_112_2.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic Map<Long, String> getListBoxValues(String[] columns) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tString query = GWTServletUtils.getListBoxResultsQueryString(");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 116, 5)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".class.getCanonicalName(), columns);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tlog.debug(\"ListBox Values query:\" + query);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tMap<Long, String> values = new HashMap<Long, String>();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tQuery getListBoxValues = entityManager.createQuery(query);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tfor (Object obj : getListBoxValues.getResultList()) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tObject[] obs = (Object[]) obj;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tvalues.put((Long) obs[0], (String) obs[1]);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn values;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_127_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_127_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_127_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_127_2.setTagInfo(_td_f_message_127_2);
                _jettag_f_message_127_2.doStart(context, out);
                JET2Writer _jettag_f_message_127_2_saved_out = out;
                while (_jettag_f_message_127_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_127_2.handleBodyContent(out);
                }
                out = _jettag_f_message_127_2_saved_out;
                _jettag_f_message_127_2.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic <T extends Serializable> void addAll(T parent, T children,");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tList<Long> ids) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t// find getter");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tMethod addMethod = null;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tfor (Method method : parent.getClass().getMethods()) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tif (method.getName().equalsIgnoreCase(");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\"add\" + children.getClass().getSimpleName())) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\taddMethod = method;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tparent = entityManager.merge(parent);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tfor (Long id : ids) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tT child = (T) entityManager.find(children.getClass(), id);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tif (child == null) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tthrow new RuntimeException(\"error find entity with id:\" + id");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\t+ \":on:\" + child.getClass().getName());");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\ttry {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\taddMethod.invoke(parent, child);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t} catch (Exception e) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\te.printStackTrace();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tthrow new RuntimeException(\"error calling method:\"");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\t+ addMethod.getName() + \":on:\" + parent.getClass().getSimpleName());");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_156_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_156_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_156_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_156_2.setTagInfo(_td_f_message_156_2);
                _jettag_f_message_156_2.doStart(context, out);
                JET2Writer _jettag_f_message_156_2_saved_out = out;
                while (_jettag_f_message_156_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_156_2.handleBodyContent(out);
                }
                out = _jettag_f_message_156_2_saved_out;
                _jettag_f_message_156_2.doEnd();
                out.write(NL);         
                out.write("\tpublic EntityManager getEntityManager() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn entityManager;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_161_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_161_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_161_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_161_2.setTagInfo(_td_f_message_161_2);
                _jettag_f_message_161_2.doStart(context, out);
                JET2Writer _jettag_f_message_161_2_saved_out = out;
                while (_jettag_f_message_161_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_161_2.handleBodyContent(out);
                }
                out = _jettag_f_message_161_2_saved_out;
                _jettag_f_message_161_2.doEnd();
                out.write(NL);         
                out.write("\tpublic void setEntityManager(EntityManager entityManager) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tthis.entityManager = entityManager;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_166_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_166_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_166_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_166_2.setTagInfo(_td_f_message_166_2);
                _jettag_f_message_166_2.doStart(context, out);
                JET2Writer _jettag_f_message_166_2_saved_out = out;
                while (_jettag_f_message_166_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_166_2.handleBodyContent(out);
                }
                out = _jettag_f_message_166_2_saved_out;
                _jettag_f_message_166_2.doEnd();
                out.write(NL);         
                out.write("\t@Destroy");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@Remove");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void destroy() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("}");  //$NON-NLS-1$        
                out.write(NL);         
                _jettag_f_bundle_3_1.handleBodyContent(out);
            }
            _jettag_f_bundle_3_1.doEnd();
            _jettag_java_format_2_1.handleBodyContent(out);
        }
        out = _jettag_java_format_2_1_saved_out;
        _jettag_java_format_2_1.doEnd();
    }
}
