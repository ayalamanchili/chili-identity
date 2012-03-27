package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_jpa_pom_templatexml implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$

    public _jet_jpa_pom_templatexml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_c_if_57_5 = new TagInfo("c:if", //$NON-NLS-1$
            57, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$dataBase = 'MYSQL'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_60_6 = new TagInfo("c:if", //$NON-NLS-1$
            60, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$dataBase = 'HSQL'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_63_6 = new TagInfo("c:if", //$NON-NLS-1$
            63, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$dataBase = 'ORACLE'", //$NON-NLS-1$
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\txsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<parent>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<groupId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 4, 12)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<artifactId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 5, 15)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-master</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$version}", 6, 12)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<relativePath>../");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 7, 20)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-master/pom.xml</relativePath>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</parent>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<modelVersion>4.0.0</modelVersion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<groupId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 10, 11)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<artifactId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 11, 14)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-jpa</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<name>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 12, 8)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-jpa</name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<url>http://maven.apache.org</url>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<dependencies>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</dependencies>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<build>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<plugins>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<groupId>org.codehaus.mojo</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<artifactId>hibernate3-maven-plugin");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$hibernate3-maven-plugin-version}", 22, 14)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<executions>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<execution>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<phase>process-classes</phase>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<goals>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t\t<goal>hbm2ddl</goal>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t</goals>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t</execution>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</executions>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<components>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<component>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t\t<name>hbm2ddl</name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t\t<implementation>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t\t\tannotationconfiguration</implementation>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t</component>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t</components>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<componentProperties>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<implementation>jpaconfiguration</implementation>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<persistenceunit>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 41, 24)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</persistenceunit>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<outputfilename>schema.ddl</outputfilename>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<drop>false</drop>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<create>true</create>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<export>false</export>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<format>true</format>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t</componentProperties>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<!--\t<plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<groupId>info.yalamanchili.maven</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<artifactId>jpa-testdata</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$jpa-testdata-plugin-version}", 53, 14)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<namingStrategy>org.hibernate.cfg.ImprovedNamingStrategy");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</namingStrategy>");  //$NON-NLS-1$        
        out.write(NL);         
        RuntimeTagElement _jettag_c_if_57_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_57_5); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_57_5.setRuntimeParent(null);
        _jettag_c_if_57_5.setTagInfo(_td_c_if_57_5);
        _jettag_c_if_57_5.doStart(context, out);
        while (_jettag_c_if_57_5.okToProcessBody()) {
            out.write("\t \t\t\t<dialectValue>MYSQL</dialectValue>");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_c_if_57_5.handleBodyContent(out);
        }
        _jettag_c_if_57_5.doEnd();
        RuntimeTagElement _jettag_c_if_60_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_60_6); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_60_6.setRuntimeParent(null);
        _jettag_c_if_60_6.setTagInfo(_td_c_if_60_6);
        _jettag_c_if_60_6.doStart(context, out);
        while (_jettag_c_if_60_6.okToProcessBody()) {
            out.write("\t \t\t\t<dialectValue>HSQL</dialectValue>");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_c_if_60_6.handleBodyContent(out);
        }
        _jettag_c_if_60_6.doEnd();
        RuntimeTagElement _jettag_c_if_63_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_63_6); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_63_6.setRuntimeParent(null);
        _jettag_c_if_63_6.setTagInfo(_td_c_if_63_6);
        _jettag_c_if_63_6.doStart(context, out);
        while (_jettag_c_if_63_6.okToProcessBody()) {
            out.write("\t \t\t\t<dialectValue>ORACLE</dialectValue>");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_c_if_63_6.handleBodyContent(out);
        }
        _jettag_c_if_63_6.doEnd();
        out.write("\t\t\t\t</configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<executions>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<execution>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<phase>compile</phase>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<goals>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t\t<goal>generate</goal>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t</goals>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t</execution>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</executions>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</plugin> -->\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</plugins>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</build>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</project>");  //$NON-NLS-1$        
    }
}
