package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_webapp_jbosswebxml implements JET2Template {

    public _jet_webapp_jbosswebxml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<jboss-web>  ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <class-loading java2ClassLoadingCompliance=\"true\">  ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <loader-repository>  ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         ");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 4, 10)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(":archive=");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 4, 30)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-app-");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$version}", 4, 50)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".war  ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <loader-repository-config>  ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            java2ParentDelegation=false  ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         </loader-repository-config>  ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </loader-repository>  ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </class-loading>  ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</jboss-web> ");  //$NON-NLS-1$        
    }
}
