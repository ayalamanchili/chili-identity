package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_loginconfigxml implements JET2Template {

    public _jet_loginconfigxml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<?xml version='1.0'?>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("<!DOCTYPE policy PUBLIC");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      \"-//JBoss//DTD JBOSS Security Config 3.0//EN\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      \"http://www.jboss.org/j2ee/dtd/security_config.dtd\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("<!-- The XML based JAAS login configuration read by the");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("org.jboss.security.auth.login.XMLLoginConfig mbean. Add");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("an application-policy element for each security domain.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("The outline of the application-policy is:");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<application-policy name=\"security-domain-name\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  <authentication>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <login-module code=\"login.module1.class.name\" flag=\"control_flag\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <module-option name = \"option1-name\">option1-value</module-option>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <module-option name = \"option2-name\">option2-value</module-option>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      ...");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    </login-module>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("    <login-module code=\"login.module2.class.name\" flag=\"control_flag\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      ...");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    </login-module>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    ...");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  </authentication>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</application-policy>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("$Revision: 42748 $");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("-->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("<policy>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  <!-- Used by clients within the application server VM such as");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  mbeans and servlets that access EJBs.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  <application-policy name=\"client-login\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <authentication>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <login-module code=\"org.jboss.security.ClientLoginModule\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        flag=\"required\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <!-- Any existing security context will be restored on logout -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <module-option name=\"restore-login-identity\">true</module-option>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </login-module>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    </authentication>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  </application-policy>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("  <application-policy name=\"other\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <!-- A simple server login module, which can be used when the number");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    of users is relatively small. It uses two properties files:");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    users.properties, which holds users (key) and their password (value).");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    roles.properties, which holds users (key) and a comma-separated list of");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    their roles (value).");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    The unauthenticatedIdentity property defines the name of the principal");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    that will be used when a null username and password are presented as is");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    the case for an unuathenticated web client or MDB. If you want to");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    allow such users to be authenticated add the property, e.g.,");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    unauthenticatedIdentity=\"nobody\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <authentication>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <login-module code=\"org.jboss.security.auth.spi.UsersRolesLoginModule\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        flag=\"required\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    </authentication>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  </application-policy>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("</policy>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
    }
}
