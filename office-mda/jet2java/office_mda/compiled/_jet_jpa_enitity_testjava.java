package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_jpa_enitity_testjava implements JET2Template {
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_jpa_enitity_testjava() {
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
    private static final TagInfo _td_f_message_26_1 = new TagInfo("f:message", //$NON-NLS-1$
            26, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_29_2 = new TagInfo("f:message", //$NON-NLS-1$
            29, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_32_2 = new TagInfo("f:message", //$NON-NLS-1$
            32, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_36_2 = new TagInfo("f:message", //$NON-NLS-1$
            36, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_40_2 = new TagInfo("f:message", //$NON-NLS-1$
            40, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_51_2 = new TagInfo("f:message", //$NON-NLS-1$
            51, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_59_2 = new TagInfo("f:message", //$NON-NLS-1$
            59, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_71_2 = new TagInfo("f:message", //$NON-NLS-1$
            71, 2,
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
                out.write(".entity.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$package/@name}", 5, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import static org.junit.Assert.assertEquals;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.security.gwt.YUser;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import javax.inject.Inject;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.EntityManager;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.PersistenceContext;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.Query;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.transaction.UserTransaction;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.jpa.AbstractEntity;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import org.jboss.arquillian.api.Deployment;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.arquillian.junit.Arquillian;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.shrinkwrap.api.Archive;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.shrinkwrap.api.ShrinkWrap;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.shrinkwrap.api.asset.EmptyAsset;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.shrinkwrap.api.spec.WebArchive;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.junit.Test;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.junit.runner.RunWith;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_26_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_26_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_26_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_26_1.setTagInfo(_td_f_message_26_1);
                _jettag_f_message_26_1.doStart(context, out);
                JET2Writer _jettag_f_message_26_1_saved_out = out;
                while (_jettag_f_message_26_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_26_1.handleBodyContent(out);
                }
                out = _jettag_f_message_26_1_saved_out;
                _jettag_f_message_26_1.doEnd();
                out.write(NL);         
                out.write("@RunWith(Arquillian.class)");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("public class ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 28, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("JPATest {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_29_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_29_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_29_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_29_2.setTagInfo(_td_f_message_29_2);
                _jettag_f_message_29_2.doStart(context, out);
                JET2Writer _jettag_f_message_29_2_saved_out = out;
                while (_jettag_f_message_29_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_29_2.handleBodyContent(out);
                }
                out = _jettag_f_message_29_2_saved_out;
                _jettag_f_message_29_2.doEnd();
                out.write(NL);         
                out.write("\tprotected static final int ENTITY_SIZE = 3;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_32_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_32_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_32_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_32_2.setTagInfo(_td_f_message_32_2);
                _jettag_f_message_32_2.doStart(context, out);
                JET2Writer _jettag_f_message_32_2_saved_out = out;
                while (_jettag_f_message_32_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_32_2.handleBodyContent(out);
                }
                out = _jettag_f_message_32_2_saved_out;
                _jettag_f_message_32_2.doEnd();
                out.write(NL);         
                out.write("\t@PersistenceContext");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tEntityManager em;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_36_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_36_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_36_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_36_2.setTagInfo(_td_f_message_36_2);
                _jettag_f_message_36_2.doStart(context, out);
                JET2Writer _jettag_f_message_36_2_saved_out = out;
                while (_jettag_f_message_36_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_36_2.handleBodyContent(out);
                }
                out = _jettag_f_message_36_2_saved_out;
                _jettag_f_message_36_2.doEnd();
                out.write(NL);         
                out.write("\t@Inject");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tUserTransaction utx;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_40_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_40_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_40_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_40_2.setTagInfo(_td_f_message_40_2);
                _jettag_f_message_40_2.doStart(context, out);
                JET2Writer _jettag_f_message_40_2_saved_out = out;
                while (_jettag_f_message_40_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_40_2.handleBodyContent(out);
                }
                out = _jettag_f_message_40_2_saved_out;
                _jettag_f_message_40_2.doEnd();
                out.write(NL);         
                out.write("\t@Deployment");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic static Archive<?> createDeployment() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn ShrinkWrap");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t.create(WebArchive.class, \"test.war\")");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t.addPackages(true, ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 45, 24)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".class.getPackage(),");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\tAbstractEntity.class.getPackage())");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t.addManifestResource(\"test-persistence.xml\", \"persistence.xml\")");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t.addWebResource(EmptyAsset.INSTANCE, \"beans.xml\");");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_51_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_51_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_51_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_51_2.setTagInfo(_td_f_message_51_2);
                _jettag_f_message_51_2.doStart(context, out);
                JET2Writer _jettag_f_message_51_2_saved_out = out;
                while (_jettag_f_message_51_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_51_2.handleBodyContent(out);
                }
                out = _jettag_f_message_51_2_saved_out;
                _jettag_f_message_51_2.doEnd();
                out.write(NL);         
                out.write("\tpublic void clearAllEntities() throws Exception {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tutx.begin();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tem.joinTransaction();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tem.createQuery(\"delete from ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 55, 31)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("\").executeUpdate();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tutx.commit();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_59_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_59_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_59_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_59_2.setTagInfo(_td_f_message_59_2);
                _jettag_f_message_59_2.doStart(context, out);
                JET2Writer _jettag_f_message_59_2_saved_out = out;
                while (_jettag_f_message_59_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_59_2.handleBodyContent(out);
                }
                out = _jettag_f_message_59_2_saved_out;
                _jettag_f_message_59_2.doEnd();
                out.write(NL);         
                out.write("\tpublic void insertTestData() throws Exception {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tutx.begin();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tem.joinTransaction();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tfor (int i = 0; i < ENTITY_SIZE; i++) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 64, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity = new ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 64, 33)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t//TODO populate entities");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tem.persist(entity);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tutx.commit();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_71_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_71_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_71_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_71_2.setTagInfo(_td_f_message_71_2);
                _jettag_f_message_71_2.doStart(context, out);
                JET2Writer _jettag_f_message_71_2_saved_out = out;
                while (_jettag_f_message_71_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_71_2.handleBodyContent(out);
                }
                out = _jettag_f_message_71_2_saved_out;
                _jettag_f_message_71_2.doEnd();
                out.write(NL);         
                out.write("\t@Test");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void testInsert() throws Exception {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tclearAllEntities();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinsertTestData();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tutx.begin();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tem.joinTransaction();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tQuery query = em.createQuery(\"from ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 78, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("\");");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tassertEquals(query.getResultList().size(), ENTITY_SIZE);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tutx.commit();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
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
        out.write(NL);         
    }
}
