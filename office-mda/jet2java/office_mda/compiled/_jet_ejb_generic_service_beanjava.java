package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_ejb_generic_service_beanjava implements JET2Template {
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_ejb_generic_service_beanjava() {
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
    private static final TagInfo _td_f_message_30_1 = new TagInfo("f:message", //$NON-NLS-1$
            30, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_34_2 = new TagInfo("f:message", //$NON-NLS-1$
            34, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_38_2 = new TagInfo("f:message", //$NON-NLS-1$
            38, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_42_2 = new TagInfo("f:message", //$NON-NLS-1$
            42, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_50_2 = new TagInfo("f:message", //$NON-NLS-1$
            50, 2,
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
                out.write("package ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 5, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".ejb;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import javax.ejb.Stateful;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.beans.TableObj;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.List;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.Collection;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.Set;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.HashSet;");  //$NON-NLS-1$        
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
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.Name;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.apache.commons.logging.Log;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.apache.commons.logging.LogFactory;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.io.Serializable;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.ejb.Stateless;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.lang.reflect.Method;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.lang.reflect.ParameterizedType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.In;");  //$NON-NLS-1$        
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
                out.write("@Name(\"genericServiceBean\")");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("@Stateless(name=\"generic\")");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("public class GenericServiceBean implements  GenericService{");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_34_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_34_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_34_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_34_2.setTagInfo(_td_f_message_34_2);
                _jettag_f_message_34_2.doStart(context, out);
                JET2Writer _jettag_f_message_34_2_saved_out = out;
                while (_jettag_f_message_34_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_34_2.handleBodyContent(out);
                }
                out = _jettag_f_message_34_2_saved_out;
                _jettag_f_message_34_2.doEnd();
                out.write(NL);         
                out.write("\tprivate static final Log log = LogFactory");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t.getLog(GenericServiceBean.class);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_38_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_38_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_38_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_38_2.setTagInfo(_td_f_message_38_2);
                _jettag_f_message_38_2.doStart(context, out);
                JET2Writer _jettag_f_message_38_2_saved_out = out;
                while (_jettag_f_message_38_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_38_2.handleBodyContent(out);
                }
                out = _jettag_f_message_38_2_saved_out;
                _jettag_f_message_38_2.doEnd();
                out.write(NL);         
                out.write("\t@PersistenceContext(unitName = \"");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$projectName}", 39, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("\")");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tEntityManager entityManager;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_42_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_42_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_42_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_42_2.setTagInfo(_td_f_message_42_2);
                _jettag_f_message_42_2.doStart(context, out);
                JET2Writer _jettag_f_message_42_2_saved_out = out;
                while (_jettag_f_message_42_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_42_2.handleBodyContent(out);
                }
                out = _jettag_f_message_42_2_saved_out;
                _jettag_f_message_42_2.doEnd();
                out.write(NL);         
                out.write("\tpublic <T extends Serializable> List<String> getSuggestionsForName(");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tString name, T entity) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tQuery query = entityManager.createQuery(GWTServletUtils");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t.getSuggestionsQueryForName(name, entity));");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn query.getResultList();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_50_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_50_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_50_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_50_2.setTagInfo(_td_f_message_50_2);
                _jettag_f_message_50_2.doStart(context, out);
                JET2Writer _jettag_f_message_50_2_saved_out = out;
                while (_jettag_f_message_50_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_50_2.handleBodyContent(out);
                }
                out = _jettag_f_message_50_2_saved_out;
                _jettag_f_message_50_2.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic <T extends Serializable> List<T> getRelatedEntities(Long entityID,");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tClass sourceClass, T target) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tObject sourceEntity = entityManager.find(sourceClass, entityID);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tCollection<T> res = null;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tList<T> result = new ArrayList<T>();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tfor (Method method : sourceClass.getMethods()) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tif (method.getReturnType().equals(java.util.List.class)");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t|| method.getReturnType().equals(java.util.Set.class)) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tParameterizedType type = (ParameterizedType) method");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\t.getGenericReturnType();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t\t\t\tif (type.toString().contains(");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\ttarget.getClass().getCanonicalName())) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\ttry {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\tres = (Collection<T>)\t method.invoke(sourceEntity);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t} catch (Exception e) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\t// TODO Auto-generated catch block");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\te.printStackTrace();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\tthrow new RuntimeException(\"Call failed\");");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tif (res != null)");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tfor (T entity : res) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tresult.add((T) entity);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn result;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
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
