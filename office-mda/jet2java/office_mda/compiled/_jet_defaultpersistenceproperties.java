package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_defaultpersistenceproperties implements JET2Template {

    public _jet_defaultpersistenceproperties() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("hibernate.transaction.manager_lookup_class=org.hibernate.transaction.JBossTransactionManagerLookup");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("#hibernate.connection.release_mode=after_statement");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("#hibernate.transaction.flush_before_completion=false");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("#hibernate.transaction.auto_close_session=false");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("#hibernate.query.factory_class=org.hibernate.hql.ast.ASTQueryTranslatorFactory");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("#hibernate.hbm2ddl.auto=create-drop");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("#hibernate.hbm2ddl.auto=create");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("hibernate.cache.provider_class=org.hibernate.cache.HashtableCacheProvider");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("# Clustered cache with TreeCache");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("#hibernate.cache.provider_class=org.jboss.ejb3.entity.TreeCacheProviderHook");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("#hibernate.treecache.mbean.object_name=jboss.cache:service=EJB3EntityTreeCache");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("#hibernate.dialect=org.hibernate.dialect.HSQLDialect");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("hibernate.jndi.java.naming.factory.initial=org.jnp.interfaces.NamingContextFactory");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("hibernate.jndi.java.naming.factory.url.pkgs=org.jboss.naming:org.jnp.interfaces");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("hibernate.bytecode.use_reflection_optimizer=false");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("# I don't think this is honored, but EJB3Deployer uses it");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("hibernate.bytecode.provider=javassist");  //$NON-NLS-1$        
    }
}
