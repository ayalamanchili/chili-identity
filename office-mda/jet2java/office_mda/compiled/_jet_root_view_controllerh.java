package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_root_view_controllerh implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$

    public _jet_root_view_controllerh() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_c_iterate_2_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            2, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_3_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            3, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_4_3 = new TagInfo("c:if", //$NON-NLS-1$
            4, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isDependent = 'false'", //$NON-NLS-1$
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("#import <UIKit/UIKit.h>");  //$NON-NLS-1$        
        out.write(NL);         
        RuntimeTagElement _jettag_c_iterate_2_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_2_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_2_1.setRuntimeParent(null);
        _jettag_c_iterate_2_1.setTagInfo(_td_c_iterate_2_1);
        _jettag_c_iterate_2_1.doStart(context, out);
        while (_jettag_c_iterate_2_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_3_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_3_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_3_2.setRuntimeParent(_jettag_c_iterate_2_1);
            _jettag_c_iterate_3_2.setTagInfo(_td_c_iterate_3_2);
            _jettag_c_iterate_3_2.doStart(context, out);
            while (_jettag_c_iterate_3_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_if_4_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_4_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_4_3.setRuntimeParent(_jettag_c_iterate_3_2);
                _jettag_c_if_4_3.setTagInfo(_td_c_if_4_3);
                _jettag_c_if_4_3.doStart(context, out);
                while (_jettag_c_if_4_3.okToProcessBody()) {
                    out.write("#import \"ReadAll");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 5, 17)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("sViewController.h\";");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_4_3.handleBodyContent(out);
                }
                _jettag_c_if_4_3.doEnd();
                _jettag_c_iterate_3_2.handleBodyContent(out);
            }
            _jettag_c_iterate_3_2.doEnd();
            _jettag_c_iterate_2_1.handleBodyContent(out);
        }
        _jettag_c_iterate_2_1.doEnd();
        out.write("#import \"HttpUtils.h\";");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("@interface RootViewController : UITableViewController {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tNSMutableArray *list;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("@property (nonatomic,retain) NSMutableArray *list;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("@end");  //$NON-NLS-1$        
        out.write(NL);         
    }
}
