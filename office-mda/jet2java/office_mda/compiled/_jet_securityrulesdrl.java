package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_securityrulesdrl implements JET2Template {

    public _jet_securityrulesdrl() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("rule ManageUsers");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  no-loop");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  activation-group \"permissions\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("when");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  check: PermissionCheck(name == \"seam.user\", granted == false)");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  Role(name == \"admin\")");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("then");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  check.grant();");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("end");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("rule ManageRoles");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  no-loop");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  activation-group \"permissions\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("when");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  check: PermissionCheck(name == \"seam.role\", granted == false)");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  Role(name == \"admin\")");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("then");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  check.grant();");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("end");  //$NON-NLS-1$        
        out.write(NL);         
    }
}
