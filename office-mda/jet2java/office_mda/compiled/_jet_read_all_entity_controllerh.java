package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_read_all_entity_controllerh implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$

    public _jet_read_all_entity_controllerh() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_c_replaceStrings_6_10 = new TagInfo("c:replaceStrings", //$NON-NLS-1$
            6, 10,
            new String[] {
                "replace", //$NON-NLS-1$
                "with", //$NON-NLS-1$
            },
            new String[] {
                ".", //$NON-NLS-1$
                "_", //$NON-NLS-1$
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("#import <UIKit/UIKit.h>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("#import \"HttpUtils.h\";");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("#import \"XMLUtils.h\";");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("#import \"HttpHelper.h\";");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("#import \"");  //$NON-NLS-1$        
        RuntimeTagElement _jettag_c_replaceStrings_6_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "replaceStrings", "c:replaceStrings", _td_c_replaceStrings_6_10); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_replaceStrings_6_10.setRuntimeParent(null);
        _jettag_c_replaceStrings_6_10.setTagInfo(_td_c_replaceStrings_6_10);
        _jettag_c_replaceStrings_6_10.doStart(context, out);
        JET2Writer _jettag_c_replaceStrings_6_10_saved_out = out;
        while (_jettag_c_replaceStrings_6_10.okToProcessBody()) {
            out = out.newNestedContentWriter();
            out.write(context.embeddedExpressionAsString("${$groupID}", 6, 49)); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_replaceStrings_6_10.handleBodyContent(out);
        }
        out = _jettag_c_replaceStrings_6_10_saved_out;
        _jettag_c_replaceStrings_6_10.doEnd();
        out.write("_entity_");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 6, 87)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("_");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 6, 117)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".h\";");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("#import \"Read");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 7, 14)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("ViewController.h\";");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("#import\t\"Create");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 8, 16)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("ViewController.h\";");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("@interface ReadAll");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 10, 19)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sViewController : UITableViewController<UIActionSheetDelegate> {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tint ");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 11, 6)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sStartIndex;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tUIView *readAll");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 12, 17)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sView;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tUIView *pagingBarView;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tUITableView *readAll");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 14, 22)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sTableView;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tUIButton *createButton;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tUIButton *nextButton;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tUIButton *previousButton;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tUIView *optionsBarView;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tUIButton *optionsButton;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tNSMutableArray *");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 20, 18)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sList;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tNSMutableArray *");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 21, 18)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("s;  ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tid parent;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tNSString *parentResource;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("@property (nonatomic,retain) NSMutableArray *");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 25, 46)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sList;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("@property (nonatomic,retain) NSMutableArray *");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 26, 46)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("s; ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("@property (nonatomic,retain) id parent;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("@property (nonatomic,retain) NSString *parentResource;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (void) loadDataWithStartIndex: (int) startIndex pageSize: (NSString*) pageSize;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (void) createClicked:(id) sender;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (void) nextClicked:(id) sender;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (void) previousClicked:(id) sender;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (void) optionsClicked: (id) sender;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (NSString*) getReadAll");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 34, 25)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sURLWithStartIndex: (int) startIndex;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (void) configurePagingBarView;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (void) configureReadAllTableView;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (void) configureOptionsView;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("@end");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
    }
}
