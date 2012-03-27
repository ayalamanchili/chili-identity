package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_app_mysql_ds_templatexml implements JET2Template {

    public _jet_app_mysql_ds_templatexml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<datasources>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<local-tx-datasource>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<jndi-name>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 3, 14)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("DS</jndi-name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<connection-url>jdbc:mysql://localhost:3306/test</connection-url>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<driver-class>com.mysql.jdbc.Driver</driver-class>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<user-name>root</user-name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<password></password>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<!--pooling parameters-->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<min-pool-size>2</min-pool-size>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<max-pool-size>100</max-pool-size>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</local-tx-datasource>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("</datasources>");  //$NON-NLS-1$        
    }
}
