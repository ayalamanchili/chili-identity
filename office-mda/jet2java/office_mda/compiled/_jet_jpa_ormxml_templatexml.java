package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_jpa_ormxml_templatexml implements JET2Template {

    public _jet_jpa_ormxml_templatexml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<entity-mappings xmlns=\"http://java.sun.com/xml/ns/persistence/orm\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\txmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\txsi:schemaLocation=\"http://java.sun.com/xml/ns/persistence/orm http://java.sun.com/xml/ns/persistence/orm_1_0.xsd\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tversion=\"1.0\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<persistence-unit-metadata>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<persistence-unit-defaults>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<entity-listeners>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<entity-listener");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\tclass=\"info.yalamanchili.ejb.EntityCallbackListenerRef\" />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</entity-listeners>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</persistence-unit-defaults>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</persistence-unit-metadata>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</entity-mappings>");  //$NON-NLS-1$        
        out.write(NL);         
    }
}
