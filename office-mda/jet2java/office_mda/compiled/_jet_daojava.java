package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_daojava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_daojava() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
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
    private static final TagInfo _td_c_if_17_1 = new TagInfo("c:if", //$NON-NLS-1$
            17, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$enableHibernateSearch = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_27_1 = new TagInfo("f:message", //$NON-NLS-1$
            27, 1,
            new String[] {
            },
            new String[] {
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
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
                out.write(".dao.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 5, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import info.yalamanchili.dao.AbstractDao;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 8, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".entity.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 8, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 8, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import java.util.HashMap;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.List;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.ArrayList;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.Map;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.EntityManager;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.Query;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.ejb.Stateless;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_c_if_17_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_17_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_17_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_17_1.setTagInfo(_td_c_if_17_1);
                _jettag_c_if_17_1.doStart(context, out);
                while (_jettag_c_if_17_1.okToProcessBody()) {
                    out.write("import org.apache.lucene.util.Version;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("import info.yalamanchili.commons.DataType;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("import info.yalamanchili.commons.ReflectionUtils;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("import info.yalamanchili.commons.SearchUtils;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("import org.apache.lucene.analysis.standard.StandardAnalyzer;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("import org.hibernate.search.FullTextQuery;");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_17_1.handleBodyContent(out);
                }
                _jettag_c_if_17_1.doEnd();
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_27_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_27_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_27_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_27_1.setTagInfo(_td_f_message_27_1);
                _jettag_f_message_27_1.doStart(context, out);
                JET2Writer _jettag_f_message_27_1_saved_out = out;
                while (_jettag_f_message_27_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_27_1.handleBodyContent(out);
                }
                out = _jettag_f_message_27_1_saved_out;
                _jettag_f_message_27_1.doEnd();
                out.write(NL);         
                out.write(NL);         
                out.write("@Stateless");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("public class ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 30, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("DAO  implements AbstractDao<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 30, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected EntityManager em;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t//@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 36, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" findById(Long id) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn em.find( ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 37, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".class, id);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t//@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void save(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 41, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tem.merge(entity);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t//@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void delete(long id) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tem.remove(id);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t//@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic List<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 51, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> query(int start, int limit) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tString query = \"from \" + ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 52, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".class.getCanonicalName();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tQuery getEntitites = em.createQuery(query);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tgetEntitites.setFirstResult(start);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t// TODO externalize the max results value");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tgetEntitites.setMaxResults(limit);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn getEntitites.getResultList();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write(NL);         
                out.write("\t//@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic Long size() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tString query = \"select count(entity) from \"");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t+ ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 64, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".class.getCanonicalName() + \" entity\";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tQuery getEntitiesSize = em.createQuery(query);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn (Long) getEntitiesSize.getSingleResult();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\tpublic List<String> getSuggestionsForName(String name, ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 69, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t//TODO add GWTServlet Utils");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tQuery query = em.createQuery(\"\");");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn query.getResultList();");  //$NON-NLS-1$        
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
