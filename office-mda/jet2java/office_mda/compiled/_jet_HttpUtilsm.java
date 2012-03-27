package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_HttpUtilsm implements JET2Template {

    public _jet_HttpUtilsm() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("#import \"HttpUtils.h\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("#import <Foundation/NSObjCRuntime.h>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("#import \"objc/runtime.h\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("NSString *pageSize=@\"10\";");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("@implementation HttpUtils");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("static NSString *crudURL=@\"http://localhost:8080/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 7, 50)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-rest/seam/resource/restv1/crud/\";");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("static NSString *manageURL=@\"http://localhost:8080/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 8, 52)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-rest/seam/resource/restv1/manage/\";");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("+ (NSString *)crudURL { return crudURL; }");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("+ (void)setCrudURL:(NSString *)newVar { crudURL = newVar; }");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("+ (NSString *)manageURL { return manageURL; }");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("+ (void)setManageURL:(NSString *)newVar { manageURL = newVar; \t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("@end");  //$NON-NLS-1$        
        out.write(NL);         
    }
}
