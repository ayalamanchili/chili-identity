package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_jpa_persistence_templatexml implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$

    public _jet_jpa_persistence_templatexml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_c_if_10_3 = new TagInfo("c:if", //$NON-NLS-1$
            10, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$dataBase = 'MYSQL'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_13_4 = new TagInfo("c:if", //$NON-NLS-1$
            13, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$dataBase = 'HSQL'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_16_3 = new TagInfo("c:if", //$NON-NLS-1$
            16, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$dataBase = 'ORACLE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_23_3 = new TagInfo("c:if", //$NON-NLS-1$
            23, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$enableHibernateSearch = 'true'", //$NON-NLS-1$
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<persistence xmlns=\"http://java.sun.com/xml/ns/persistence\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\txmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\txsi:schemaLocation=\"http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_1_0.xsd\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tversion=\"1.0\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<persistence-unit name=\"");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 6, 26)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<jta-data-source>java:/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 7, 26)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("DS</jta-data-source>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<properties>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<property name=\"hibernate.ejb.naming_strategy\" value=\"org.hibernate.cfg.ImprovedNamingStrategy\" />");  //$NON-NLS-1$        
        out.write(NL);         
        RuntimeTagElement _jettag_c_if_10_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_10_3); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_10_3.setRuntimeParent(null);
        _jettag_c_if_10_3.setTagInfo(_td_c_if_10_3);
        _jettag_c_if_10_3.doStart(context, out);
        while (_jettag_c_if_10_3.okToProcessBody()) {
            out.write("\t \t\t<property name=\"hibernate.dialect\" value=\"org.hibernate.dialect.MySQL5Dialect\" />");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_c_if_10_3.handleBodyContent(out);
        }
        _jettag_c_if_10_3.doEnd();
        RuntimeTagElement _jettag_c_if_13_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_13_4); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_13_4.setRuntimeParent(null);
        _jettag_c_if_13_4.setTagInfo(_td_c_if_13_4);
        _jettag_c_if_13_4.doStart(context, out);
        while (_jettag_c_if_13_4.okToProcessBody()) {
            out.write("\t \t\t<property name=\"hibernate.dialect\" value=\"org.hibernate.dialect.HSQLDialect\" />");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_c_if_13_4.handleBodyContent(out);
        }
        _jettag_c_if_13_4.doEnd();
        RuntimeTagElement _jettag_c_if_16_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_16_3); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_16_3.setRuntimeParent(null);
        _jettag_c_if_16_3.setTagInfo(_td_c_if_16_3);
        _jettag_c_if_16_3.doStart(context, out);
        while (_jettag_c_if_16_3.okToProcessBody()) {
            out.write("\t \t\t<property name=\"hibernate.dialect\" value=\"org.hibernate.dialect.Oracle9Dialect\" />");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_c_if_16_3.handleBodyContent(out);
        }
        _jettag_c_if_16_3.doEnd();
        out.write("\t\t\t<property name=\"hibernate.hbm2ddl.auto\" value=\"create-drop\" />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<property name=\"hibernate.show_sql\" value=\"false\" />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<property name=\"jboss.entity.manager.factory.jndi.name\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\tvalue=\"java:/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 22, 18)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("\" />");  //$NON-NLS-1$        
        out.write(NL);         
        RuntimeTagElement _jettag_c_if_23_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_23_3); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_23_3.setRuntimeParent(null);
        _jettag_c_if_23_3.setTagInfo(_td_c_if_23_3);
        _jettag_c_if_23_3.doStart(context, out);
        while (_jettag_c_if_23_3.okToProcessBody()) {
            out.write("\t\t<!--hibernate search -->");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t<property name=\"hibernate.search.default.directory_provider\"");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\tvalue=\"org.hibernate.search.store.FSDirectoryProvider\" />");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t<property name=\"hibernate.search.default.indexBase\" ");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tvalue=\"$JBOSS_HOME/server/default/data/");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$projectName}", 28, 43)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("/lucene/indexes\" />\t\t");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_c_if_23_3.handleBodyContent(out);
        }
        _jettag_c_if_23_3.doEnd();
        out.write("\t\t</properties>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\t</persistence-unit>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</persistence>");  //$NON-NLS-1$        
        out.write(NL);         
    }
}
