package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_web_gwtxml_templatexml implements JET2Template {

    public _jet_web_gwtxml_templatexml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<module>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<inherits name=\"com.google.gwt.user.User\" />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\t<!-- logging -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<inherits name=\"com.google.gwt.logging.Logging\" />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<!-- Enable Firebug logger and disable console logger -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  \t<set-property name=\"gwt.logging.firebugHandler\" value=\"ENABLED\" />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<set-property name=\"gwt.logging.popupHandler\" value=\"DISABLED\" />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<!-- used to support internationalization -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<inherits name='com.google.gwt.i18n.I18N' />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\t<!-- limit dev compile permutation to only firefox -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<!-- REMOVE IN PRODUCTION-->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(" \t<set-property name=\"user.agent\" value=\"gecko1_8\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<!-- gwt client bundle to load resources -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<inherits name=\"com.google.gwt.resources.Resources\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\t<!-- used to include the jpa entities in the gwt compiler path -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<inherits name='");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 21, 18)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".entity' />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<!-- used to include the y-security entities in the gwt compiler path -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<inherits name='info.yalamanchili.security.yalamanchili-security' />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<!-- used to include yalamanchili-gwt project in gwt compiler path -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<inherits name='info.yalamanchili.yalamanchili-gwt' />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<!-- used to include yalamanchili-commons(AbstractEntity) project in gwt ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\tcompiler path -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<inherits name='info.yalamanchili.yalamanchili-commons' />\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<!-- gilead libs-->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<inherits name='net.sf.gilead.Gilead4Gwt' />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<inherits name='net.sf.gilead.emul.java5.ejb3.Ejb3' />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<!--  GWT request factory -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<inherits name='com.google.web.bindery.requestfactory.RequestFactory' />\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<entry-point class=\"");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 39, 22)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".client.");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 39, 41)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("Welcome\" />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<stylesheet src=\"");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 40, 19)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".css\" />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\t<!--source code packages -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<source path='client' />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</module>");  //$NON-NLS-1$        
    }
}
