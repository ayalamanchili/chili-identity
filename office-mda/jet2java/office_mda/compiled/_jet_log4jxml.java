package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_log4jxml implements JET2Template {

    public _jet_log4jxml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<!DOCTYPE log4j:configuration SYSTEM \"log4j.dtd\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("<!-- ===================================================================== -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<!--                                                                       -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<!--  Log4j Configuration                                                  -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<!--                                                                       -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<!-- ===================================================================== -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("<!-- $Id: log4j.xml 39945 2006-01-12 02:44:07Z bill $ -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("<!--");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   | For more configuration infromation and examples see the Jakarta Log4j");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   | owebsite: http://jakarta.apache.org/log4j");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(" -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("<log4j:configuration xmlns:log4j=\"http://jakarta.apache.org/log4j/\" debug=\"false\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<appender name=\"CONSOLE\" class=\"org.apache.log4j.ConsoleAppender\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <errorHandler class=\"org.jboss.logging.util.OnlyOnceErrorHandler\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <param name=\"Target\" value=\"System.out\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <param name=\"Threshold\" value=\"WARN\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("      <layout class=\"org.apache.log4j.PatternLayout\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <!-- The default pattern: Date Priority [Category] Messagen -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <!--");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <param name=\"ConversionPattern\" value=\"%d{ABSOLUTE} %-5p [%c{1}] %m%n\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <param name=\"ConversionPattern\" value=\"%-5p %d{dd-MM HH:mm:ss,SSS} (%F:%M:%L)  -%m%n\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </layout>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</appender>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <root>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <appender-ref ref=\"CONSOLE\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </root>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("</log4j:configuration>");  //$NON-NLS-1$        
        out.write(NL);         
    }
}
