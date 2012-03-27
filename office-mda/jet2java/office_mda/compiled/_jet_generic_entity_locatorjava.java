package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_generic_entity_locatorjava implements JET2Template {
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_generic_entity_locatorjava() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_java_format_1_1 = new TagInfo("java:format", //$NON-NLS-1$
            1, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_bundle_2_1 = new TagInfo("f:bundle", //$NON-NLS-1$
            2, 1,
            new String[] {
                "basename", //$NON-NLS-1$
            },
            new String[] {
                "templates/resources/messages", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_3_1 = new TagInfo("f:message", //$NON-NLS-1$
            3, 1,
            new String[] {
            },
            new String[] {
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        RuntimeTagElement _jettag_java_format_1_1 = context.getTagFactory().createRuntimeTag(_jetns_java, "format", "java:format", _td_java_format_1_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_java_format_1_1.setRuntimeParent(null);
        _jettag_java_format_1_1.setTagInfo(_td_java_format_1_1);
        _jettag_java_format_1_1.doStart(context, out);
        JET2Writer _jettag_java_format_1_1_saved_out = out;
        while (_jettag_java_format_1_1.okToProcessBody()) {
            out = out.newNestedContentWriter();
            out.write(NL);         
            RuntimeTagElement _jettag_f_bundle_2_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "bundle", "f:bundle", _td_f_bundle_2_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_f_bundle_2_1.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_f_bundle_2_1.setTagInfo(_td_f_bundle_2_1);
            _jettag_f_bundle_2_1.doStart(context, out);
            while (_jettag_f_bundle_2_1.okToProcessBody()) {
                RuntimeTagElement _jettag_f_message_3_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_3_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_3_1.setRuntimeParent(_jettag_f_bundle_2_1);
                _jettag_f_message_3_1.setTagInfo(_td_f_message_3_1);
                _jettag_f_message_3_1.doStart(context, out);
                JET2Writer _jettag_f_message_3_1_saved_out = out;
                while (_jettag_f_message_3_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("copyright");  //$NON-NLS-1$        
                    _jettag_f_message_3_1.handleBodyContent(out);
                }
                out = _jettag_f_message_3_1_saved_out;
                _jettag_f_message_3_1.doEnd();
                out.write(NL);         
                out.write(NL);         
                out.write("package ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 5, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".server.rf;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.jpa.AbstractEntity;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.requestfactory.GenericDao;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import com.google.web.bindery.requestfactory.shared.Locator;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("//TODO move to y-commons or y-gwt");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("public class GenericEntityLocator<T> extends Locator<T, Long> {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\tprotected T entity;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic T create(Class<? extends T> clazz) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\ttry {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\treturn clazz.newInstance();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t} catch (Exception e) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tnew RuntimeException(\"Could not instanciate class\", e);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn null;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic T find(Class<? extends T> clazz, Long id) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tGenericDao dao = (GenericDao) info.yalamanchili.inject.Locator");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t.getInstance(clazz.getSimpleName().toLowerCase() + \"GWTDao\");");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn (T) dao.findById(id);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic Class<T> getDomainType() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn (Class<T>) entity.getClass();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic Long getId(T instance) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn ((AbstractEntity) instance).getId();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic Class<Long> getIdType() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn Long.class;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic Object getVersion(T instance) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn ((AbstractEntity) instance).getVersion();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("}");  //$NON-NLS-1$        
                out.write(NL);         
                _jettag_f_bundle_2_1.handleBodyContent(out);
            }
            _jettag_f_bundle_2_1.doEnd();
            _jettag_java_format_1_1.handleBodyContent(out);
        }
        out = _jettag_java_format_1_1_saved_out;
        _jettag_java_format_1_1.doEnd();
    }
}
