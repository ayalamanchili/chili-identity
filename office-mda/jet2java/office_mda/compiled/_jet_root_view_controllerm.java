package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_root_view_controllerm implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$

    public _jet_root_view_controllerm() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_c_iterate_12_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            12, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_13_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            13, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_14_3 = new TagInfo("c:if", //$NON-NLS-1$
            14, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isDependent = 'false'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_131_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            131, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_132_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            132, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_133_3 = new TagInfo("c:if", //$NON-NLS-1$
            133, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isDependent = 'false'", //$NON-NLS-1$
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("#import \"RootViewController.h\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("@implementation RootViewController");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("@synthesize list;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("#pragma mark -");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("#pragma mark View lifecycle");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write(NL);         
        out.write("- (void)viewDidLoad {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    [super viewDidLoad];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tlist = [[NSMutableArray alloc] init];");  //$NON-NLS-1$        
        out.write(NL);         
        RuntimeTagElement _jettag_c_iterate_12_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_12_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_12_1.setRuntimeParent(null);
        _jettag_c_iterate_12_1.setTagInfo(_td_c_iterate_12_1);
        _jettag_c_iterate_12_1.doStart(context, out);
        while (_jettag_c_iterate_12_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_13_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_13_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_13_2.setRuntimeParent(_jettag_c_iterate_12_1);
            _jettag_c_iterate_13_2.setTagInfo(_td_c_iterate_13_2);
            _jettag_c_iterate_13_2.doStart(context, out);
            while (_jettag_c_iterate_13_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_if_14_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_14_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_14_3.setRuntimeParent(_jettag_c_iterate_13_2);
                _jettag_c_if_14_3.setTagInfo(_td_c_if_14_3);
                _jettag_c_if_14_3.doStart(context, out);
                while (_jettag_c_if_14_3.okToProcessBody()) {
                    out.write("[list addObject:@\"");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 15, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(" Maintainence\"];\t\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_14_3.handleBodyContent(out);
                }
                _jettag_c_if_14_3.doEnd();
                _jettag_c_iterate_13_2.handleBodyContent(out);
            }
            _jettag_c_iterate_13_2.doEnd();
            _jettag_c_iterate_12_1.handleBodyContent(out);
        }
        _jettag_c_iterate_12_1.doEnd();
        out.write("\tself.navigationItem.title=@\"AutoManage\";");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write(NL);         
        out.write("/*");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (void)viewWillAppear:(BOOL)animated {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    [super viewWillAppear:animated];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("*/");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("/*");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (void)viewDidAppear:(BOOL)animated {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    [super viewDidAppear:animated];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("*/");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("/*");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (void)viewWillDisappear:(BOOL)animated {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[super viewWillDisappear:animated];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("*/");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("/*");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (void)viewDidDisappear:(BOOL)animated {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[super viewDidDisappear:animated];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("*/");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("/*");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(" // Override to allow orientations other than the default portrait orientation.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t// Return YES for supported orientations.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\treturn (interfaceOrientation == UIInterfaceOrientationPortrait);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(" */");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write(NL);         
        out.write("#pragma mark -");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("#pragma mark Table view data source");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("// Customize the number of sections in the table view.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    return 1;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write(NL);         
        out.write("// Customize the number of rows in the table view.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    return [list count];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("// Customize the appearance of table view cells.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    static NSString *CellIdentifier = @\"Cell\";");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:CellIdentifier];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    if (cell == nil) {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        cell = [[[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:CellIdentifier] autorelease];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    }");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t// Configure the cell.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tNSString *cellText=[list objectAtIndex:indexPath.row];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tcell.textLabel.text=cellText;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    return cell;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write(NL);         
        out.write("/*");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("// Override to support conditional editing of the table view.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (BOOL)tableView:(UITableView *)tableView canEditRowAtIndexPath:(NSIndexPath *)indexPath {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    // Return NO if you do not want the specified item to be editable.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    return YES;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("*/");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write(NL);         
        out.write("/*");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("// Override to support editing the table view.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    if (editingStyle == UITableViewCellEditingStyleDelete) {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        // Delete the row from the data source.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        [tableView deleteRowsAtIndexPaths:[NSArray arrayWithObject:indexPath] withRowAnimation:UITableViewRowAnimationFade];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    }   ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    else if (editingStyle == UITableViewCellEditingStyleInsert) {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    }   ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("*/");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write(NL);         
        out.write("/*");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("// Override to support rearranging the table view.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (void)tableView:(UITableView *)tableView moveRowAtIndexPath:(NSIndexPath *)fromIndexPath toIndexPath:(NSIndexPath *)toIndexPath {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("*/");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write(NL);         
        out.write("/*");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("// Override to support conditional rearranging of the table view.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (BOOL)tableView:(UITableView *)tableView canMoveRowAtIndexPath:(NSIndexPath *)indexPath {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    // Return NO if you do not want the item to be re-orderable.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    return YES;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("*/");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write(NL);         
        out.write("#pragma mark -");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("#pragma mark Table view delegate");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tNSString *tabName=[list objectAtIndex:indexPath.row];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tNSLog(@\"%@\",tabName);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("//\tNSURL *url=[NSURL URLWithString:@\"http://localhost:8080/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 130, 60)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-soa-1.0-SNAPSHOT/seam/resource/restv1/manage/login/user/user\"];");  //$NON-NLS-1$        
        out.write(NL);         
        RuntimeTagElement _jettag_c_iterate_131_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_131_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_131_1.setRuntimeParent(null);
        _jettag_c_iterate_131_1.setTagInfo(_td_c_iterate_131_1);
        _jettag_c_iterate_131_1.doStart(context, out);
        while (_jettag_c_iterate_131_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_132_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_132_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_132_2.setRuntimeParent(_jettag_c_iterate_131_1);
            _jettag_c_iterate_132_2.setTagInfo(_td_c_iterate_132_2);
            _jettag_c_iterate_132_2.doStart(context, out);
            while (_jettag_c_iterate_132_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_if_133_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_133_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_133_3.setRuntimeParent(_jettag_c_iterate_132_2);
                _jettag_c_if_133_3.setTagInfo(_td_c_if_133_3);
                _jettag_c_if_133_3.doStart(context, out);
                while (_jettag_c_if_133_3.okToProcessBody()) {
                    out.write("\t\tif (@\"");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 134, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(" Maintainence\" == tabName) {");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t ReadAll");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 135, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("sViewController *readAll");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 135, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("sController = [[ReadAll");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 135, 88)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("sViewController alloc] initWithNibName:nil bundle:nil];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t [self.navigationController pushViewController:readAll");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 137, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("sController animated:YES];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t [readAll");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 138, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("sController release];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t readAll");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 139, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("sController = nil;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t}\t\t\t\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_133_3.handleBodyContent(out);
                }
                _jettag_c_if_133_3.doEnd();
                _jettag_c_iterate_132_2.handleBodyContent(out);
            }
            _jettag_c_iterate_132_2.doEnd();
            _jettag_c_iterate_131_1.handleBodyContent(out);
        }
        _jettag_c_iterate_131_1.doEnd();
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write(NL);         
        out.write("#pragma mark -");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("#pragma mark Memory management");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("- (void)didReceiveMemoryWarning {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    // Releases the view if it doesn't have a superview.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    [super didReceiveMemoryWarning];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    // Relinquish ownership any cached data, images, etc that aren't in use.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("- (void)viewDidUnload {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    // Relinquish ownership of anything that can be recreated in viewDidLoad or on demand.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    // For example: self.myOutlet = nil;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write(NL);         
        out.write("- (void)dealloc {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[list release];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    [super dealloc];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write(NL);         
        out.write("@end");  //$NON-NLS-1$        
    }
}
