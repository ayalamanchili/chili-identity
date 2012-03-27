package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_abstract_entity_testjava implements JET2Template {

    public _jet_abstract_entity_testjava() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("package info.yalamanchili.jpa;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("import java.io.Serializable;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("import javax.persistence.GeneratedValue;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("import javax.persistence.Id;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("import javax.persistence.MappedSuperclass;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("import javax.persistence.Version;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("import javax.xml.bind.annotation.XmlAttribute;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("import javax.xml.bind.annotation.XmlElement;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("import javax.xml.bind.annotation.XmlRootElement;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("import javax.xml.bind.annotation.XmlType;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("/**");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(" * Default Parent/root entity for all jpa entities to serve id,version");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(" * properties and extends from LightEntity to suppport GWT-GILEAD");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(" * ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(" * @author ayalamanchili");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(" */");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("// TODO move to non gwt package since not needed with request factory");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("@XmlType");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("@MappedSuperclass");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("@XmlRootElement");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("public abstract class AbstractEntity implements");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\tSerializable {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t@Version");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tprivate Integer version;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t@Id");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t@GeneratedValue");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tprivate Long id;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\tpublic Long getId() {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\treturn id;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t@XmlElement");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tpublic void setId(Long id) {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\tthis.id = id;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t@XmlAttribute");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tpublic Integer getVersion() {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\treturn version;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
    }
}
