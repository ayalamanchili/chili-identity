package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_ejb3interceptorsaopxml implements JET2Template {

    public _jet_ejb3interceptorsaopxml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<!DOCTYPE aop PUBLIC");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   \"-//JBoss//DTD JBOSS AOP 1.0//EN\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   \"http://labs.jboss.com/portal/jbossaop/dtd/jboss-aop_1_0.dtd\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("<aop>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <interceptor class=\"org.jboss.aspects.remoting.InvokeRemoteInterceptor\" scope=\"PER_VM\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <interceptor class=\"org.jboss.aspects.security.SecurityClientInterceptor\" scope=\"PER_VM\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <interceptor class=\"org.jboss.aspects.tx.ClientTxPropagationInterceptor\" scope=\"PER_VM\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <interceptor class=\"org.jboss.ejb3.remoting.IsLocalInterceptor\" scope=\"PER_VM\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <interceptor class=\"org.jboss.aspects.remoting.ClusterChooserInterceptor\" scope=\"PER_VM\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <interceptor class=\"org.jboss.aspects.tx.TxPropagationInterceptor\" scope=\"PER_VM\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <stack name=\"ServiceClientInterceptors\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.ejb3.remoting.IsLocalInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.aspects.security.SecurityClientInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.aspects.tx.ClientTxPropagationInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.aspects.remoting.InvokeRemoteInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </stack>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <stack name=\"AsynchronousStatelessSessionClientInterceptors\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.ejb3.remoting.IsLocalInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.aspects.security.SecurityClientInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.aspects.tx.ClientTxPropagationInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.aspects.remoting.InvokeRemoteInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </stack>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <stack name=\"AsynchronousStatefulSessionClientInterceptors\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.ejb3.remoting.IsLocalInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.aspects.security.SecurityClientInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.aspects.tx.ClientTxPropagationInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.aspects.remoting.InvokeRemoteInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </stack>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <stack name=\"StatelessSessionClientInterceptors\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.ejb3.remoting.IsLocalInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.aspects.security.SecurityClientInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.aspects.tx.ClientTxPropagationInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.aspects.remoting.InvokeRemoteInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </stack>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <stack name=\"StatefulSessionClientInterceptors\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.ejb3.remoting.IsLocalInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.aspects.security.SecurityClientInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.aspects.tx.ClientTxPropagationInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.aspects.remoting.InvokeRemoteInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </stack>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <stack name=\"ClusteredStatelessSessionClientInterceptors\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.ejb3.remoting.IsLocalInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.aspects.security.SecurityClientInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.aspects.tx.ClientTxPropagationInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.aspects.remoting.ClusterChooserInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.aspects.remoting.InvokeRemoteInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </stack>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <stack name=\"ClusteredStatefulSessionClientInterceptors\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.ejb3.remoting.IsLocalInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.aspects.security.SecurityClientInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.aspects.tx.ClientTxPropagationInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.aspects.remoting.ClusterChooserInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <interceptor-ref name=\"org.jboss.aspects.remoting.InvokeRemoteInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </stack>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <interceptor class=\"org.jboss.ejb3.asynchronous.AsynchronousInterceptor\" scope=\"PER_CLASS\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <interceptor class=\"org.jboss.ejb3.ENCPropagationInterceptor\" scope=\"PER_VM\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <interceptor name=\"Basic Authorization\" factory=\"org.jboss.ejb3.security.RoleBasedAuthorizationInterceptorFactory\" scope=\"PER_CLASS\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <interceptor name=\"JACC Authorization\" factory=\"org.jboss.ejb3.security.JaccAuthorizationInterceptorFactory\" scope=\"PER_CLASS\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <interceptor factory=\"org.jboss.ejb3.security.AuthenticationInterceptorFactory\" scope=\"PER_CLASS\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <interceptor factory=\"org.jboss.ejb3.security.RunAsSecurityInterceptorFactory\" scope=\"PER_CLASS\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <interceptor class=\"org.jboss.ejb3.entity.ExtendedPersistenceContextPropagationInterceptor\" scope=\"PER_VM\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <interceptor class=\"org.jboss.ejb3.stateless.StatelessInstanceInterceptor\" scope=\"PER_VM\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <interceptor class=\"org.jboss.ejb3.stateful.StatefulInstanceInterceptor\" scope=\"PER_VM\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <interceptor class=\"org.jboss.ejb3.stateful.SessionSynchronizationInterceptor\" scope=\"PER_VM\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <interceptor class=\"org.jboss.ejb3.service.ServiceSingletonInterceptor\" scope=\"PER_VM\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <interceptor class=\"org.jboss.ejb3.cache.StatefulReplicationInterceptor\" scope=\"PER_VM\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <interceptor factory=\"org.jboss.ejb3.stateful.StatefulRemoveFactory\" scope=\"PER_CLASS_JOINPOINT\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <interceptor factory=\"org.jboss.ejb3.tx.TxInterceptorFactory\" scope=\"PER_CLASS_JOINPOINT\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <interceptor factory=\"org.jboss.ejb3.interceptor.EJB3InterceptorsFactory\" scope=\"PER_CLASS_JOINPOINT\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <interceptor factory=\"org.jboss.ejb3.remoting.ReplicantsManagerInterceptorFactory\" scope=\"PER_CLASS\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <interceptor class=\"org.jboss.ejb3.AllowedOperationsInterceptor\" scope=\"PER_VM\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <interceptor factory=\"org.jboss.ejb3.mdb.CurrentMessageInjectorInterceptorFactory\" scope=\"PER_CLASS\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <interceptor class=\"org.jboss.ejb3.entity.TransactionScopedEntityManagerInterceptor\" scope=\"PER_VM\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <domain name=\"Stateless Bean\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * *->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.asynchronous.AsynchronousInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.ENCPropagationInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.security.AuthenticationInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * @org.jboss.annotation.security.SecurityDomain->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"Basic Authorization\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * @javax.annotation.security.RunAs->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.security.RunAsSecurityInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * @org.jboss.annotation.ejb.Clustered->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.remoting.ReplicantsManagerInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * *->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.stateless.StatelessInstanceInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.aspects.tx.TxPropagationInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.tx.TxInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.AllowedOperationsInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.entity.TransactionScopedEntityManagerInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.interceptor.EJB3InterceptorsFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <annotation expr=\"!class(@org.jboss.annotation.ejb.PoolClass)\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         @org.jboss.annotation.ejb.PoolClass (value=org.jboss.ejb3.ThreadlocalPool.class, maxSize=30, timeout=10000)");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </annotation>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </domain>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <domain name=\"JACC Stateless Bean\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * *->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.asynchronous.AsynchronousInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.ENCPropagationInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.security.AuthenticationInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * @org.jboss.annotation.security.SecurityDomain->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"JACC Authorization\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * @javax.annotation.security.RunAs->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.security.RunAsSecurityInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * @org.jboss.annotation.ejb.Clustered->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.remoting.ReplicantsManagerInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * *->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.stateless.StatelessInstanceInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.aspects.tx.TxPropagationInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.tx.TxInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.AllowedOperationsInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.entity.TransactionScopedEntityManagerInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.interceptor.EJB3InterceptorsFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <annotation expr=\"!class(@org.jboss.annotation.ejb.PoolClass)\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         @org.jboss.annotation.ejb.PoolClass (value=org.jboss.ejb3.ThreadlocalPool.class, maxSize=30, timeout=10000)");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </annotation>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </domain>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <domain name=\"Base Stateful Bean\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * *->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.asynchronous.AsynchronousInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.ENCPropagationInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.security.AuthenticationInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * @org.jboss.annotation.security.SecurityDomain->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"Basic Authorization\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * @javax.annotation.security.RunAs->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.security.RunAsSecurityInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * @org.jboss.annotation.ejb.Clustered->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.remoting.ReplicantsManagerInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * *->@javax.ejb.Remove(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.stateful.StatefulRemoveFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * *->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.stateful.StatefulInstanceInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.aspects.tx.TxPropagationInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.tx.TxInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.AllowedOperationsInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * $instanceof{javax.ejb.SessionSynchronization}->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.stateful.SessionSynchronizationInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * *->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.entity.TransactionScopedEntityManagerInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.entity.ExtendedPersistenceContextPropagationInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.interceptor.EJB3InterceptorsFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * @org.jboss.annotation.ejb.Clustered->*(..)) AND !execution(public * *->@javax.ejb.Remove(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.cache.StatefulReplicationInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <annotation expr=\"!class(@org.jboss.annotation.ejb.PoolClass)\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         @org.jboss.annotation.ejb.PoolClass (value=org.jboss.ejb3.ThreadlocalPool.class, maxSize=30, timeout=10000)");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </annotation>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </domain>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <domain name=\"Stateful Bean\" extends=\"Base Stateful Bean\" inheritBindings=\"true\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <!-- NON Clustered cache configuration -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <annotation expr=\"!class(@org.jboss.annotation.ejb.cache.Cache) AND !class(@org.jboss.annotation.ejb.Clustered)\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         @org.jboss.annotation.ejb.cache.Cache (org.jboss.ejb3.cache.simple.SimpleStatefulCache.class)");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </annotation>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <annotation expr=\"!class(@org.jboss.annotation.ejb.cache.simple.PersistenceManager) AND !class(@org.jboss.annotation.ejb.Clustered)\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         @org.jboss.annotation.ejb.cache.simple.PersistenceManager (org.jboss.ejb3.cache.simple.StatefulSessionFilePersistenceManager.class)");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </annotation>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <annotation expr=\"!class(@org.jboss.annotation.ejb.cache.simple.CacheConfig) AND !class(@org.jboss.annotation.ejb.Clustered)\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         @org.jboss.annotation.ejb.cache.simple.CacheConfig (maxSize=100000, idleTimeoutSeconds=300)");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </annotation>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("      <!-- Clustered cache configuration -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <annotation expr=\"!class(@org.jboss.annotation.ejb.cache.Cache) AND class(@org.jboss.annotation.ejb.Clustered)\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         @org.jboss.annotation.ejb.cache.Cache (org.jboss.ejb3.cache.tree.StatefulTreeCache.class)");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </annotation>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <annotation expr=\"!class(@org.jboss.annotation.ejb.cache.tree.CacheConfig) AND class(@org.jboss.annotation.ejb.Clustered)\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         @org.jboss.annotation.ejb.cache.tree.CacheConfig (name=\"jboss.cache:service=EJB3SFSBClusteredCache\", maxSize=100000, idleTimeoutSeconds=300)");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </annotation>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </domain>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <domain name=\"JACC Stateful Bean\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * *->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.asynchronous.AsynchronousInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.ENCPropagationInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.security.AuthenticationInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * @org.jboss.annotation.security.SecurityDomain->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"JACC Authorization\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * @javax.annotation.security.RunAs->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.security.RunAsSecurityInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * @org.jboss.annotation.ejb.Clustered->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.remoting.ReplicantsManagerInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * *->@javax.ejb.Remove(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.stateful.StatefulRemoveFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * *->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.stateful.StatefulInstanceInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.aspects.tx.TxPropagationInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.tx.TxInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.AllowedOperationsInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * $instanceof{javax.ejb.SessionSynchronization}->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.stateful.SessionSynchronizationInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * *->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.entity.TransactionScopedEntityManagerInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.entity.ExtendedPersistenceContextPropagationInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.interceptor.EJB3InterceptorsFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * @org.jboss.annotation.ejb.Clustered->*(..)) AND !execution(public * *->@javax.ejb.Remove(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.cache.StatefulReplicationInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <annotation expr=\"!class(@org.jboss.annotation.ejb.PoolClass)\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         @org.jboss.annotation.ejb.PoolClass (value=org.jboss.ejb3.ThreadlocalPool.class, maxSize=30, timeout=10000)");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </annotation>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("      <!-- NON Clustered cache configuration -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <annotation expr=\"!class(@org.jboss.annotation.ejb.cache.Cache) AND !class(@org.jboss.annotation.ejb.Clustered)\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         @org.jboss.annotation.ejb.cache.Cache (org.jboss.ejb3.cache.simple.SimpleStatefulCache.class)");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </annotation>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <annotation expr=\"!class(@org.jboss.annotation.ejb.cache.simple.PersistenceManager) AND !class(@org.jboss.annotation.ejb.Clustered)\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         @org.jboss.annotation.ejb.cache.simple.PersistenceManager (org.jboss.ejb3.cache.simple.StatefulSessionFilePersistenceManager.class)");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </annotation>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <annotation expr=\"!class(@org.jboss.annotation.ejb.cache.simple.CacheConfig) AND !class(@org.jboss.annotation.ejb.Clustered)\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         @org.jboss.annotation.ejb.cache.simple.CacheConfig (maxSize=100000, idleTimeoutSeconds=300)");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </annotation>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("      <!-- Clustered cache configuration -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <annotation expr=\"!class(@org.jboss.annotation.ejb.cache.Cache) AND class(@org.jboss.annotation.ejb.Clustered)\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         @org.jboss.annotation.ejb.cache.Cache (org.jboss.ejb3.cache.tree.StatefulTreeCache.class)");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </annotation>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <annotation expr=\"!class(@org.jboss.annotation.ejb.cache.tree.CacheConfig) AND class(@org.jboss.annotation.ejb.Clustered)\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         @org.jboss.annotation.ejb.cache.tree.CacheConfig (name=\"jboss.cache:service=EJB3SFSBClusteredCache\", maxSize=100000, idleTimeoutSeconds=300)");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </annotation>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </domain>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <domain name=\"Embedded Stateful Bean\" extends=\"Base Stateful Bean\" inheritBindings=\"true\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <!-- NON Clustered cache configuration -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <annotation expr=\"!class(@org.jboss.annotation.ejb.cache.Cache)\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         @org.jboss.annotation.ejb.cache.Cache (org.jboss.ejb3.cache.NoPassivationCache.class)");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </annotation>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   </domain>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <domain name=\"Message Driven Bean\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * @javax.annotation.security.RunAs->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.security.RunAsSecurityInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * *->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.stateless.StatelessInstanceInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.tx.TxInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.AllowedOperationsInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.entity.TransactionScopedEntityManagerInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.interceptor.EJB3InterceptorsFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <annotation expr=\"!class(@org.jboss.annotation.ejb.PoolClass)\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         @org.jboss.annotation.ejb.PoolClass (value=org.jboss.ejb3.StrictMaxPool.class, maxSize=30, timeout=10000)");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </annotation>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </domain>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <domain name=\"Consumer Bean\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * @javax.annotation.security.RunAs->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.security.RunAsSecurityInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * *->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.stateless.StatelessInstanceInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.tx.TxInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.AllowedOperationsInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.entity.TransactionScopedEntityManagerInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * *->*(..)) AND (has(* *->@org.jboss.annotation.ejb.CurrentMessage(..)) OR hasfield(* *->@org.jboss.annotation.ejb.CurrentMessage))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.mdb.CurrentMessageInjectorInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * *->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.interceptor.EJB3InterceptorsFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <annotation expr=\"!class(@org.jboss.annotation.ejb.PoolClass)\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         @org.jboss.annotation.ejb.PoolClass (value=org.jboss.ejb3.StrictMaxPool.class, maxSize=30, timeout=10000)");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </annotation>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </domain>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <domain name=\"Service Bean\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * *->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.asynchronous.AsynchronousInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.ENCPropagationInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"!execution(* *->create()) AND !execution(* *->start()) AND !execution(*->new(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.security.AuthenticationInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>      ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * @org.jboss.annotation.security.SecurityDomain->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"Basic Authorization\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * @javax.annotation.security.RunAs->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.security.RunAsSecurityInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * *->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.aspects.tx.TxPropagationInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.tx.TxInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.AllowedOperationsInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.entity.TransactionScopedEntityManagerInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * *->*(..)) AND !execution(* *->create()) AND !execution(* *->start())\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.interceptor.EJB3InterceptorsFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </domain>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <domain name=\"JACC Service Bean\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * *->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.asynchronous.AsynchronousInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.ENCPropagationInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"!execution(* *->create()) AND !execution(* *->start()) AND !execution(*->new(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.security.AuthenticationInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>      ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * @org.jboss.annotation.security.SecurityDomain->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"Basic Authorization\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * @javax.annotation.security.RunAs->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.security.RunAsSecurityInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * *->*(..))\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.aspects.tx.TxPropagationInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.tx.TxInterceptorFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.AllowedOperationsInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.entity.TransactionScopedEntityManagerInterceptor\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bind pointcut=\"execution(public * *->*(..)) AND !execution(* *->create()) AND !execution(* *->start())\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <interceptor-ref name=\"org.jboss.ejb3.interceptor.EJB3InterceptorsFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bind>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </domain>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write(NL);         
        out.write("</aop>");  //$NON-NLS-1$        
    }
}
