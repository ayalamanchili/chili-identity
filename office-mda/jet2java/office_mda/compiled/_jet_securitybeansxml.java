package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_securitybeansxml implements JET2Template {

    public _jet_securitybeansxml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("<deployment xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            xsi:schemaLocation=\"urn:jboss:bean-deployer bean-deployer_1_0.xsd\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            xmlns=\"urn:jboss:bean-deployer\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean class=\"org.jboss.ejb3.embedded.JaasSecurityManagerService\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         name=\"jboss.security:service=JaasSecurityManager\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"initialContextProperties\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <inject bean=\"InitialContextProperties\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</deployment>");  //$NON-NLS-1$        
        out.write(NL);         
    }
}
