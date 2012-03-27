package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_app_service_syncjava implements JET2Template {
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_app_service_syncjava() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_java_merge_1_1 = new TagInfo("java:merge", //$NON-NLS-1$
            1, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_java_format_2_1 = new TagInfo("java:format", //$NON-NLS-1$
            2, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_bundle_3_1 = new TagInfo("f:bundle", //$NON-NLS-1$
            3, 1,
            new String[] {
                "basename", //$NON-NLS-1$
            },
            new String[] {
                "templates/resources/messages", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_4_1 = new TagInfo("f:message", //$NON-NLS-1$
            4, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_14_2 = new TagInfo("f:message", //$NON-NLS-1$
            14, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_17_1 = new TagInfo("f:message", //$NON-NLS-1$
            17, 1,
            new String[] {
            },
            new String[] {
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        RuntimeTagElement _jettag_java_merge_1_1 = context.getTagFactory().createRuntimeTag(_jetns_java, "merge", "java:merge", _td_java_merge_1_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_java_merge_1_1.setRuntimeParent(null);
        _jettag_java_merge_1_1.setTagInfo(_td_java_merge_1_1);
        _jettag_java_merge_1_1.doStart(context, out);
        _jettag_java_merge_1_1.doEnd();
        out.write(NL);         
        RuntimeTagElement _jettag_java_format_2_1 = context.getTagFactory().createRuntimeTag(_jetns_java, "format", "java:format", _td_java_format_2_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_java_format_2_1.setRuntimeParent(null);
        _jettag_java_format_2_1.setTagInfo(_td_java_format_2_1);
        _jettag_java_format_2_1.doStart(context, out);
        JET2Writer _jettag_java_format_2_1_saved_out = out;
        while (_jettag_java_format_2_1.okToProcessBody()) {
            out = out.newNestedContentWriter();
            out.write(NL);         
            RuntimeTagElement _jettag_f_bundle_3_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "bundle", "f:bundle", _td_f_bundle_3_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_f_bundle_3_1.setRuntimeParent(_jettag_java_format_2_1);
            _jettag_f_bundle_3_1.setTagInfo(_td_f_bundle_3_1);
            _jettag_f_bundle_3_1.doStart(context, out);
            while (_jettag_f_bundle_3_1.okToProcessBody()) {
                RuntimeTagElement _jettag_f_message_4_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_4_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_4_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_4_1.setTagInfo(_td_f_message_4_1);
                _jettag_f_message_4_1.doStart(context, out);
                JET2Writer _jettag_f_message_4_1_saved_out = out;
                while (_jettag_f_message_4_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("copyright");  //$NON-NLS-1$        
                    _jettag_f_message_4_1.handleBodyContent(out);
                }
                out = _jettag_f_message_4_1_saved_out;
                _jettag_f_message_4_1.doEnd();
                out.write(NL);         
                out.write("package ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$webPackage}", 5, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("rpc;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import com.google.gwt.core.client.GWT;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.rpc.RemoteService;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.rpc.ServiceDefTarget;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("/**");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(" * This is a GWT service, which will be implemented as a Seam component on the");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(" * server (see the server package). GWT uses strongly typed RPC interfaces.");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(" */");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(" ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_14_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_14_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_14_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_14_2.setTagInfo(_td_f_message_14_2);
                _jettag_f_message_14_2.doStart(context, out);
                JET2Writer _jettag_f_message_14_2_saved_out = out;
                while (_jettag_f_message_14_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_14_2.handleBodyContent(out);
                }
                out = _jettag_f_message_14_2_saved_out;
                _jettag_f_message_14_2.doEnd();
                out.write(NL);         
                out.write("public interface ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 15, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Service extends RemoteService {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_17_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_17_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_17_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_17_1.setTagInfo(_td_f_message_17_1);
                _jettag_f_message_17_1.doStart(context, out);
                JET2Writer _jettag_f_message_17_1_saved_out = out;
                while (_jettag_f_message_17_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_17_1.handleBodyContent(out);
                }
                out = _jettag_f_message_17_1_saved_out;
                _jettag_f_message_17_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic static class ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 18, 22)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceAsync {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tprivate static ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$webPackage}", 19, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("rpc.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 19, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceAsync service;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tpublic static synchronized ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$webPackage}", 20, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("rpc.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 20, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceAsync instance() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tif (service == null) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tservice = (");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$webPackage}", 22, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("rpc.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 22, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceAsync) GWT");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\t.create(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 23, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Service.class);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tServiceDefTarget endpoint = (ServiceDefTarget) service;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tString moduleRelativeURL = GWT.getModuleBaseURL()");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\t+ \"seam/resource/gwt2\";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tendpoint.setServiceEntryPoint(moduleRelativeURL);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\treturn service;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("}");  //$NON-NLS-1$        
                out.write(NL);         
                _jettag_f_bundle_3_1.handleBodyContent(out);
            }
            _jettag_f_bundle_3_1.doEnd();
            _jettag_java_format_2_1.handleBodyContent(out);
        }
        out = _jettag_java_format_2_1_saved_out;
        _jettag_java_format_2_1.doEnd();
    }
}
