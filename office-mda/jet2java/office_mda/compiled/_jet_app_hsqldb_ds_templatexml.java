package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_app_hsqldb_ds_templatexml implements JET2Template {

    public _jet_app_hsqldb_ds_templatexml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<datasources>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  <local-tx-datasource>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<jndi-name>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 4, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("DS</jndi-name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<connection-url>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\tjdbc:hsqldb:");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${jboss.server.data.dir}${/}'}", 6, 15)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(context.embeddedExpressionAsString("${$projectName}", 6, 48)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(context.embeddedExpressionAsString("${'${/}hypersonic${/}database'}", 6, 63)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</connection-url>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <driver-class>org.hsqldb.jdbcDriver</driver-class>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <user-name>sa</user-name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <password><![CDATA[]]></password>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  </local-tx-datasource>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</datasources>");  //$NON-NLS-1$        
    }
}
