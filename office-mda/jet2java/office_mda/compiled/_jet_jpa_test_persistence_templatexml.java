package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_jpa_test_persistence_templatexml implements JET2Template {

    public _jet_jpa_test_persistence_templatexml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<persistence>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <persistence-unit name=\"");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 3, 28)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(" ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <!-- This persistence unit uses the default data source that JBoss    -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <!-- defines called DefaultDS. If we wanted to use our own data       -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <!-- source, we'd need to define a custom data source somewhere.      -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <!-- That somewhere is vendor specific.                               -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(" ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <!-- In the case of JBoss, since we're using the embedded container,  -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <!-- we need to add two beans in a file called                        -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <!-- embedded-jboss-beans.xml. We name the first                      -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <!-- HypersonicLocalServerDSBootstrap and we name the second          -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <!-- HypersonicLocalServerDS. This two step process defines a data    -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <!-- source.                                                          -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(" ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <!-- In the first bean definition, we additionally bind it in Jndi    -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <!-- under some name. If we used the name                             -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <!-- java:/HypersonicLocalServerDS then we would use the following    -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <!-- entry to use that data source instead of the default one:        -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <!-- <jta-data-source>java:/HypersonicLocalServerDS</jta-data-source> -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(" ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <jta-data-source>java:/DefaultDS</jta-data-source>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <properties>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <property name=\"hibernate.hbm2ddl.auto\" value=\"create-drop\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </properties>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </persistence-unit>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</persistence>");  //$NON-NLS-1$        
        out.write(NL);         
    }
}
