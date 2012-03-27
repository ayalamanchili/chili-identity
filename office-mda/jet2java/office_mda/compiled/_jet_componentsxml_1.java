package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_componentsxml_1 implements JET2Template {

    public _jet_componentsxml_1() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<components xmlns=\"http://jboss.com/products/seam/components\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            xmlns:core=\"http://jboss.com/products/seam/core\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            xmlns:persistence=\"http://jboss.com/products/seam/persistence\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            xmlns:security=\"http://jboss.com/products/seam/security\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            xmlns:theme=\"http://jboss.com/products/seam/theme\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            xmlns:cache=\"http://jboss.com/products/seam/cache\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            xmlns:web=\"http://jboss.com/products/seam/web\"           ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            xsi:schemaLocation=");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                \"http://jboss.com/products/seam/core http://jboss.com/products/seam/core-2.2.xsd");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                 http://jboss.com/products/seam/persistence http://jboss.com/products/seam/persistence-2.2.xsd");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                 http://jboss.com/products/seam/security http://jboss.com/products/seam/security-2.2.xsd");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                 http://jboss.com/products/seam/theme http://jboss.com/products/seam/theme-2.2.xsd");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                 http://jboss.com/products/seam/cache http://jboss.com/products/seam/cache-2.2.xsd");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                 http://jboss.com/products/seam/web http://jboss.com/products/seam/web-2.2.xsd");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                 http://jboss.com/products/seam/components http://jboss.com/products/seam/components-2.2.xsd\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                 ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <persistence:managed-persistence-context name=\"em\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\tauto-create=\"true\" persistence-unit-jndi-name=\"java:/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 20, 56)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("\"/> ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</components>");  //$NON-NLS-1$        
    }
}
