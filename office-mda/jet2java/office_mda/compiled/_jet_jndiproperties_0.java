package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_jndiproperties_0 implements JET2Template {

    public _jet_jndiproperties_0() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("java.naming.factory.initial=org.jnp.interfaces.NamingContextFactory");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("java.naming.factory.url.pkgs=org.jboss.naming:org.jnp.interfaces ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("java.naming.provider.url=jnp://localhost:1099");  //$NON-NLS-1$        
    }
}
