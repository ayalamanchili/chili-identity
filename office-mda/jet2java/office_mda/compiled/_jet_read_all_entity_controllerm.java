package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_read_all_entity_controllerm implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$

    public _jet_read_all_entity_controllerm() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_c_replaceStrings_106_7 = new TagInfo("c:replaceStrings", //$NON-NLS-1$
            106, 7,
            new String[] {
                "replace", //$NON-NLS-1$
                "with", //$NON-NLS-1$
            },
            new String[] {
                ".", //$NON-NLS-1$
                "_", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_replaceStrings_158_2 = new TagInfo("c:replaceStrings", //$NON-NLS-1$
            158, 2,
            new String[] {
                "replace", //$NON-NLS-1$
                "with", //$NON-NLS-1$
            },
            new String[] {
                ".", //$NON-NLS-1$
                "_", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_168_1 = new TagInfo("c:if", //$NON-NLS-1$
            168, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isDependent = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_170_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            170, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_171_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            171, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_172_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            172, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_173_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            173, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_175_6 = new TagInfo("c:if", //$NON-NLS-1$
            175, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_178_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            178, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_179_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            179, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_181_14 = new TagInfo("c:if", //$NON-NLS-1$
            181, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_183_14 = new TagInfo("c:if", //$NON-NLS-1$
            183, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_185_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            185, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_186_16 = new TagInfo("c:if", //$NON-NLS-1$
            186, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_replaceStrings_191_68 = new TagInfo("c:replaceStrings", //$NON-NLS-1$
            191, 68,
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
        out.write("#import \"ReadAll");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 1, 17)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sViewController.h\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("@implementation ReadAll");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 3, 24)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sViewController");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("@synthesize ");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 4, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sList;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("@synthesize ");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 5, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("s; ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("@synthesize parent;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("@synthesize parentResource;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("/*");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(" // The designated initializer.  Override if you create the controller programmatically and want to perform customization that is not appropriate for viewDidLoad.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    if ((self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil])) {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        // Custom initialization");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    }");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    return self;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("*/");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("- (void)loadView {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tCGRect readAllViewCanvas= CGRectMake(0.0, 0.0, 320, 480);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\treadAll");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 21, 9)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sView = [[[UIView alloc] initWithFrame:readAllViewCanvas] autorelease];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\treadAll");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 22, 9)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sView.autoresizesSubviews = YES;              ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tself.view = readAll");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 23, 21)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sView;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[self configurePagingBarView];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[self configureReadAllTableView];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[self configureOptionsView];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[readAll");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 27, 10)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sView addSubview:pagingBarView]; ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[readAll");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 28, 10)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sView addSubview:readAll");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 28, 49)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sTableView];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[readAll");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 29, 10)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sView addSubview:optionsBarView];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\treadAll");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 31, 9)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sTableView.delegate = self;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\treadAll");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 32, 9)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sTableView.dataSource=self;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("- (void) configurePagingBarView{");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tCGRect pagingBarCanvas= CGRectMake(0.0, 0.0, 320, 40);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tpagingBarView = [[[UITableView alloc] initWithFrame:pagingBarCanvas] autorelease];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t//configure create button");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tcreateButton= [[UIButton buttonWithType:UIButtonTypeRoundedRect] retain];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tcreateButton.frame = CGRectMake(5,5, 80, 30.0);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[createButton setTitle:@\"Create\" forState:UIControlStateNormal];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[createButton setTitleColor:[UIColor grayColor] forState:UIControlStateNormal ];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[createButton addTarget:self action:@selector(createClicked:) forControlEvents:UIControlEventTouchUpInside];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t//configure next button");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tnextButton= [[UIButton buttonWithType:UIButtonTypeRoundedRect] retain];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tnextButton.frame = CGRectMake(90,5, 80, 30.0);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[nextButton setTitle:@\"next\" forState:UIControlStateNormal];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[nextButton setTitleColor:[UIColor grayColor] forState:UIControlStateNormal ];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[nextButton addTarget:self action:@selector(nextClicked:) forControlEvents:UIControlEventTouchUpInside];\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t//configure previous button");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tpreviousButton= [[UIButton buttonWithType:UIButtonTypeRoundedRect] retain];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tpreviousButton.frame = CGRectMake(175,5, 80, 30.0);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[previousButton setTitle:@\"previous\" forState:UIControlStateNormal];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[previousButton setTitleColor:[UIColor grayColor] forState:UIControlStateNormal ];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[previousButton addTarget:self action:@selector(previousClicked:) forControlEvents:UIControlEventTouchUpInside];\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[pagingBarView addSubview:createButton];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[pagingBarView addSubview:nextButton];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[pagingBarView addSubview:previousButton];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("- (void) configureReadAllTableView{");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tCGRect readAllTableViewCanvas= CGRectMake(0.0, 40, 320, 345);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\treadAll");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 67, 9)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sTableView = [[[UITableView alloc] initWithFrame:readAllTableViewCanvas] autorelease];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("- (void) configureOptionsView {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tCGRect optionsBarCanvas= CGRectMake(0.0, 385, 320, 30);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\toptionsBarView = [[[UIView alloc] initWithFrame:optionsBarCanvas] autorelease];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\toptionsBarView.backgroundColor=UIColor.redColor;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\toptionsButton= [[UIButton buttonWithType:UIButtonTypeRoundedRect] retain];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\toptionsButton.frame = CGRectMake(0,0, 320, 30.0);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[optionsButton setTitle:@\"Options\" forState:UIControlStateNormal];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[optionsButton setTitleColor:[UIColor grayColor] forState:UIControlStateNormal ];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[optionsButton addTarget:self action:@selector(optionsClicked:) forControlEvents:UIControlEventTouchUpInside];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[optionsBarView addSubview:optionsButton];\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("// Implement viewDidLoad to do additional setup after loading the view, typically from a nib.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (void)viewDidLoad {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(" \t[super viewDidLoad];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 87, 2)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sList =[[NSMutableArray alloc] init];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 88, 2)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("s = [[NSMutableArray alloc] init];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 89, 2)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sStartIndex=0;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[self loadDataWithStartIndex:0 pageSize:nil];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tself.navigationItem.title=@\"");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 91, 30)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("s\";");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("- (void) loadDataWithStartIndex: (int) startIndex pageSize: (NSString*) pageSize {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tNSString *urlString;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 96, 3)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sList removeAllObjects];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 97, 3)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("s removeAllObjects];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tif(parentResource !=nil){");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\turlString =self.parentResource;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\telse {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\turlString =[self getReadAll");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 102, 30)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sURLWithStartIndex:startIndex];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tNSData *data=[HttpHelper asyncHttpGetDataFromURL:urlString];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tNSArray *temp");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 105, 15)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("s=[XMLUtils convertXMLToObjects:data];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tfor (");  //$NON-NLS-1$        
        RuntimeTagElement _jettag_c_replaceStrings_106_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "replaceStrings", "c:replaceStrings", _td_c_replaceStrings_106_7); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_replaceStrings_106_7.setRuntimeParent(null);
        _jettag_c_replaceStrings_106_7.setTagInfo(_td_c_replaceStrings_106_7);
        _jettag_c_replaceStrings_106_7.doStart(context, out);
        JET2Writer _jettag_c_replaceStrings_106_7_saved_out = out;
        while (_jettag_c_replaceStrings_106_7.okToProcessBody()) {
            out = out.newNestedContentWriter();
            out.write(context.embeddedExpressionAsString("${$groupID}", 106, 46)); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_replaceStrings_106_7.handleBodyContent(out);
        }
        out = _jettag_c_replaceStrings_106_7_saved_out;
        _jettag_c_replaceStrings_106_7.doEnd();
        out.write("_entity_");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 106, 84)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("_");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 106, 114)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(" *");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 106, 131)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(" in temp");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 106, 166)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("s) {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t[");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 107, 4)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("s addObject:");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 107, 43)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t[");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 108, 4)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sList addObject:[");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 108, 48)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(" description]];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[readAll");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 110, 10)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sTableView reloadData];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write(NL);         
        out.write("/*");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("// Override to allow orientations other than the default portrait orientation.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    // Return YES for supported orientations");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    return (interfaceOrientation == UIInterfaceOrientationPortrait);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("*/");  //$NON-NLS-1$        
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
        out.write("    // Release any cached data, images, etc that aren't in use.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("- (void)viewDidUnload {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    [super viewDidUnload];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    // Release any retained subviews of the main view.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    // e.g. self.myOutlet = nil;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("// Customize the number of rows in the table view.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    return [");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 137, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sList count];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write(NL);         
        out.write("// Customize the appearance of table view cells.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    static NSString *CellIdentifier = @\"ReadAll");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 144, 48)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sCell\";");  //$NON-NLS-1$        
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
        out.write("\t// Configure the cell.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tNSString *cellText=[");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 151, 22)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sList objectAtIndex:indexPath.row];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tcell.textLabel.text=cellText;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    return cell;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tRead");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 157, 6)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("ViewController *read");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 157, 41)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("Controller = [[Read");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 157, 75)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("ViewController alloc] initWithNibName:nil bundle:nil];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        RuntimeTagElement _jettag_c_replaceStrings_158_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "replaceStrings", "c:replaceStrings", _td_c_replaceStrings_158_2); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_replaceStrings_158_2.setRuntimeParent(null);
        _jettag_c_replaceStrings_158_2.setTagInfo(_td_c_replaceStrings_158_2);
        _jettag_c_replaceStrings_158_2.doStart(context, out);
        JET2Writer _jettag_c_replaceStrings_158_2_saved_out = out;
        while (_jettag_c_replaceStrings_158_2.okToProcessBody()) {
            out = out.newNestedContentWriter();
            out.write(context.embeddedExpressionAsString("${$groupID}", 158, 41)); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_replaceStrings_158_2.handleBodyContent(out);
        }
        out = _jettag_c_replaceStrings_158_2_saved_out;
        _jettag_c_replaceStrings_158_2.doEnd();
        out.write("_entity_");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 158, 79)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("_");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 158, 109)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(" *");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 158, 126)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("=[");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 158, 155)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("s objectAtIndex:indexPath.row];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tread");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 159, 6)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("Controller.");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 159, 32)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("=");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 159, 60)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(";");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[self.navigationController pushViewController:read");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 160, 52)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("Controller animated:YES];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[read");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 161, 7)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("Controller release];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tread");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 162, 6)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("Controller = nil;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("- (void) createClicked:(id) sender{");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tif (parent!=nil) {");  //$NON-NLS-1$        
        out.write(NL);         
        RuntimeTagElement _jettag_c_if_168_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_168_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_168_1.setRuntimeParent(null);
        _jettag_c_if_168_1.setTagInfo(_td_c_if_168_1);
        _jettag_c_if_168_1.doStart(context, out);
        while (_jettag_c_if_168_1.okToProcessBody()) {
            // process compsition associations
            RuntimeTagElement _jettag_c_iterate_170_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_170_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_170_2.setRuntimeParent(_jettag_c_if_168_1);
            _jettag_c_iterate_170_2.setTagInfo(_td_c_iterate_170_2);
            _jettag_c_iterate_170_2.doStart(context, out);
            while (_jettag_c_iterate_170_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_171_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_171_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_171_2.setRuntimeParent(_jettag_c_iterate_170_2);
                _jettag_c_iterate_171_2.setTagInfo(_td_c_iterate_171_2);
                _jettag_c_iterate_171_2.doStart(context, out);
                while (_jettag_c_iterate_171_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_172_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_172_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_172_3.setRuntimeParent(_jettag_c_iterate_171_2);
                    _jettag_c_iterate_172_3.setTagInfo(_td_c_iterate_172_3);
                    _jettag_c_iterate_172_3.doStart(context, out);
                    while (_jettag_c_iterate_172_3.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_setVariable_173_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_173_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_173_4.setRuntimeParent(_jettag_c_iterate_172_3);
                        _jettag_c_setVariable_173_4.setTagInfo(_td_c_setVariable_173_4);
                        _jettag_c_setVariable_173_4.doStart(context, out);
                        _jettag_c_setVariable_173_4.doEnd();
                        // check is the association is corresponding to the class  
                        RuntimeTagElement _jettag_c_if_175_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_175_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_175_6.setRuntimeParent(_jettag_c_iterate_172_3);
                        _jettag_c_if_175_6.setTagInfo(_td_c_if_175_6);
                        _jettag_c_if_175_6.doStart(context, out);
                        while (_jettag_c_if_175_6.okToProcessBody()) {
                            // process only compositions
                            // iterate over the iterations ends  
                            RuntimeTagElement _jettag_c_iterate_178_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_178_12); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_178_12.setRuntimeParent(_jettag_c_if_175_6);
                            _jettag_c_iterate_178_12.setTagInfo(_td_c_iterate_178_12);
                            _jettag_c_iterate_178_12.doStart(context, out);
                            while (_jettag_c_iterate_178_12.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_179_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_179_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_179_12.setRuntimeParent(_jettag_c_iterate_178_12);
                                _jettag_c_setVariable_179_12.setTagInfo(_td_c_setVariable_179_12);
                                _jettag_c_setVariable_179_12.doStart(context, out);
                                _jettag_c_setVariable_179_12.doEnd();
                                // get the end secondary end with other class  
                                RuntimeTagElement _jettag_c_if_181_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_181_14); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_181_14.setRuntimeParent(_jettag_c_iterate_178_12);
                                _jettag_c_if_181_14.setTagInfo(_td_c_if_181_14);
                                _jettag_c_if_181_14.doStart(context, out);
                                while (_jettag_c_if_181_14.okToProcessBody()) {
                                    // check if this is a comp
                                    RuntimeTagElement _jettag_c_if_183_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_183_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_183_14.setRuntimeParent(_jettag_c_if_181_14);
                                    _jettag_c_if_183_14.setTagInfo(_td_c_if_183_14);
                                    _jettag_c_if_183_14.doStart(context, out);
                                    while (_jettag_c_if_183_14.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_185_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_185_15); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_185_15.setRuntimeParent(_jettag_c_if_183_14);
                                        _jettag_c_iterate_185_15.setTagInfo(_td_c_iterate_185_15);
                                        _jettag_c_iterate_185_15.doStart(context, out);
                                        while (_jettag_c_iterate_185_15.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_186_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_186_16); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_186_16.setRuntimeParent(_jettag_c_iterate_185_15);
                                            _jettag_c_if_186_16.setTagInfo(_td_c_if_186_16);
                                            _jettag_c_if_186_16.doStart(context, out);
                                            while (_jettag_c_if_186_16.okToProcessBody()) {
                                                // check to see if class2 is parent and child
                                                out.write("\t\tNSLog(@\"creatinf {$class/@name} \");");  //$NON-NLS-1$        
                                                out.write(NL);         
                                                out.write("\t\tNSLog(@\"parent %@\",[parent entityID]);");  //$NON-NLS-1$        
                                                out.write(NL);         
                                                out.write("\t\tCreate");  //$NON-NLS-1$        
                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 190, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                                                out.write("ViewController *create");  //$NON-NLS-1$        
                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 190, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                                out.write("Controller = [[Create");  //$NON-NLS-1$        
                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 190, 82)); //$NON-NLS-1$ //$NON-NLS-2$
                                                out.write("ViewController alloc] initWithNibName:nil bundle:nil];");  //$NON-NLS-1$        
                                                out.write(NL);         
                                                out.write("\t\tcreate");  //$NON-NLS-1$        
                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 191, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                                                out.write("Controller.");  //$NON-NLS-1$        
                                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 191, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                                out.write(" = [[[");  //$NON-NLS-1$        
                                                RuntimeTagElement _jettag_c_replaceStrings_191_68 = context.getTagFactory().createRuntimeTag(_jetns_c, "replaceStrings", "c:replaceStrings", _td_c_replaceStrings_191_68); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_replaceStrings_191_68.setRuntimeParent(_jettag_c_if_186_16);
                                                _jettag_c_replaceStrings_191_68.setTagInfo(_td_c_replaceStrings_191_68);
                                                _jettag_c_replaceStrings_191_68.doStart(context, out);
                                                JET2Writer _jettag_c_replaceStrings_191_68_saved_out = out;
                                                while (_jettag_c_replaceStrings_191_68.okToProcessBody()) {
                                                    out = out.newNestedContentWriter();
                                                    out.write(context.embeddedExpressionAsString("${$groupID}", 191, 107)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_replaceStrings_191_68.handleBodyContent(out);
                                                }
                                                out = _jettag_c_replaceStrings_191_68_saved_out;
                                                _jettag_c_replaceStrings_191_68.doEnd();
                                                out.write("_entity_");  //$NON-NLS-1$        
                                                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 191, 145)); //$NON-NLS-1$ //$NON-NLS-2$
                                                out.write("_");  //$NON-NLS-1$        
                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 191, 175)); //$NON-NLS-1$ //$NON-NLS-2$
                                                out.write(" alloc] init] autorelease];");  //$NON-NLS-1$        
                                                out.write(NL);         
                                                out.write("\t\tcreate");  //$NON-NLS-1$        
                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 192, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                                                out.write("Controller.");  //$NON-NLS-1$        
                                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 192, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                                out.write(".");  //$NON-NLS-1$        
                                                out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 192, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                                                out.write("=parent;");  //$NON-NLS-1$        
                                                out.write(NL);         
                                                out.write("\t\t[self.navigationController pushViewController:create");  //$NON-NLS-1$        
                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 193, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                                                out.write("Controller animated:YES];");  //$NON-NLS-1$        
                                                out.write(NL);         
                                                out.write("\t\t[create");  //$NON-NLS-1$        
                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 194, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                                                out.write("Controller release];");  //$NON-NLS-1$        
                                                out.write(NL);         
                                                out.write("\t\tcreate");  //$NON-NLS-1$        
                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 195, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                                                out.write("Controller = nil;");  //$NON-NLS-1$        
                                                out.write(NL);         
                                                _jettag_c_if_186_16.handleBodyContent(out);
                                            }
                                            _jettag_c_if_186_16.doEnd();
                                            _jettag_c_iterate_185_15.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_185_15.doEnd();
                                        _jettag_c_if_183_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_183_14.doEnd();
                                    _jettag_c_if_181_14.handleBodyContent(out);
                                }
                                _jettag_c_if_181_14.doEnd();
                                _jettag_c_iterate_178_12.handleBodyContent(out);
                            }
                            _jettag_c_iterate_178_12.doEnd();
                            _jettag_c_if_175_6.handleBodyContent(out);
                        }
                        _jettag_c_if_175_6.doEnd();
                        _jettag_c_iterate_172_3.handleBodyContent(out);
                    }
                    _jettag_c_iterate_172_3.doEnd();
                    _jettag_c_iterate_171_2.handleBodyContent(out);
                }
                _jettag_c_iterate_171_2.doEnd();
                _jettag_c_iterate_170_2.handleBodyContent(out);
            }
            _jettag_c_iterate_170_2.doEnd();
            _jettag_c_if_168_1.handleBodyContent(out);
        }
        _jettag_c_if_168_1.doEnd();
        out.write(NL);         
        out.write("\t} else{");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tCreate");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 208, 8)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("ViewController *create");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 208, 45)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("Controller = [[Create");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 208, 81)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("ViewController alloc] initWithNibName:nil bundle:nil];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[self.navigationController pushViewController:create");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 209, 54)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("Controller animated:YES];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[create");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 210, 9)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("Controller release];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tcreate");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 211, 8)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("Controller = nil;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("- (void) optionsClicked: (id) sender{");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tUIActionSheet *menu=[[UIActionSheet alloc] initWithTitle:@\"options\" delegate:self cancelButtonTitle:@\"cancel\" destructiveButtonTitle:nil otherButtonTitles:@\"search\",@\"find\",nil];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[menu showInView:readAll");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 217, 26)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sTableView];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[menu release];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("-(void)actionSheet:(UIActionSheet *)actionSheet clickedButtonAtIndex:(NSInteger)buttonIndex {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    if (buttonIndex == 0) {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\tNSLog(@\"search\");");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t} ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\telse if (buttonIndex == 1) {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        NSLog(@\"find\");");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    }");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("- (void) nextClicked:(id) sender{");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 231, 2)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sStartIndex=");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 231, 41)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sStartIndex+ [pageSize intValue];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[self loadDataWithStartIndex:");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 232, 31)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sStartIndex pageSize:nil];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("- (void) previousClicked:(id) sender{");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tif (");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 236, 6)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sStartIndex >= [pageSize intValue]) {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 237, 3)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sStartIndex = ");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 237, 44)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sStartIndex");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t- [pageSize intValue];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t[self loadDataWithStartIndex:");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 239, 32)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sStartIndex pageSize:nil];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("- (NSString*) getReadAll");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 243, 25)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sURLWithStartIndex: (int) startIndex {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tNSString* startIndexStr = [NSString stringWithFormat:@\"%d\", startIndex];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tNSString* endIndexStr = [NSString stringWithFormat:@\"%d\", startIndex+[pageSize intValue]];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tNSString *str=[NSString stringWithFormat:@\"");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 246, 45)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("/readall/%@/%@\", startIndexStr, endIndexStr];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\treturn [[HttpUtils crudURL] stringByAppendingString:str];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("- (void)dealloc {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 251, 3)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("s release];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 252, 3)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("sList release];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    [super dealloc];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write(NL);         
        out.write("@end");  //$NON-NLS-1$        
        out.write(NL);         
    }
}
