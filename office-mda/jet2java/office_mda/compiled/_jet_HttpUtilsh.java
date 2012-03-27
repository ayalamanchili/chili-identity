package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_HttpUtilsh implements JET2Template {

    public _jet_HttpUtilsh() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("#import <Foundation/Foundation.h>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("extern NSString *pageSize;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("@interface HttpUtils : NSObject {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("+ (NSString *)manageURL;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("+ (NSString *)crudURL;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("@end");  //$NON-NLS-1$        
    }
}
