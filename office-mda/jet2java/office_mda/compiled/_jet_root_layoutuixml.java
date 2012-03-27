package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_root_layoutuixml implements JET2Template {

    public _jet_root_layoutuixml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<!DOCTYPE ui:UiBinder SYSTEM \"http://dl.google.com/gwt/DTD/xhtml.ent\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<ui:UiBinder xmlns:ui=\"urn:ui:com.google.gwt.uibinder\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\txmlns:g=\"urn:import:com.google.gwt.user.client.ui\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\txmlns:");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 4, 8)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("=\"urn:import:");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 4, 48)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".client\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<g:DockLayoutPanel unit='EM' addStyleNames='mainPanel'>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<g:north size='4'>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<g:FlowPanel addStyleNames='statusPanel' ui:field='statusPanel'>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 8, 6)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(":StatusPanel ui:field=\"");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 8, 56)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("StatusPanel\"></");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 8, 98)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(":StatusPanel>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</g:FlowPanel>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</g:north>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<g:north size='2'>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<g:HorizontalPanel ui:field='menuBar'");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\taddStyleNames='entityMenuBar'></g:HorizontalPanel>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</g:north>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<g:west size='15'>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<g:FlowPanel addStyleNames='sidePanel' ui:field='sidePanel'>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<g:FlowPanel addStyleNames='sidePanelTop' ui:field='sidePanelTop'></g:FlowPanel>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<g:FlowPanel addStyleNames='sidePanelBottom' ui:field='sidePanelBottom'></g:FlowPanel>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</g:FlowPanel>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</g:west>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\t\t<g:center>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<g:ScrollPanel addStyleNames='entityPanelHolder'");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\tui:field='entityPanelHolder'>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<g:FlowPanel ui:field='entityPanel'></g:FlowPanel>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</g:ScrollPanel>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</g:center>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</g:DockLayoutPanel>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</ui:UiBinder>");  //$NON-NLS-1$        
        out.write(NL);         
    }
}
