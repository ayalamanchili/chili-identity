package office_mda.compiled;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2TemplateLoader;
import org.eclipse.jet.JET2TemplateLoaderExtension;

public class _jet_transformation implements JET2TemplateLoader,
        JET2TemplateLoaderExtension {

    private JET2TemplateLoader delegate = null;

    private final static Map<String, Integer> pathToTemplateOrdinalMap = new HashMap<String,Integer>(160);
    static {
        pathToTemplateOrdinalMap.put("templates/android/android_default.properties.jet", //$NON-NLS-1$
                Integer.valueOf(0));
        pathToTemplateOrdinalMap.put("templates/android/android_manifest_template.xml.jet", //$NON-NLS-1$
                Integer.valueOf(1));
        pathToTemplateOrdinalMap.put("templates/android/android_pom_template.xml.jet", //$NON-NLS-1$
                Integer.valueOf(2));
        pathToTemplateOrdinalMap.put("templates/android/main/Main.java.jet", //$NON-NLS-1$
                Integer.valueOf(3));
        pathToTemplateOrdinalMap.put("templates/android/main/entity/create_entity.java.jet", //$NON-NLS-1$
                Integer.valueOf(4));
        pathToTemplateOrdinalMap.put("templates/android/main/entity/read_all.java.jet", //$NON-NLS-1$
                Integer.valueOf(5));
        pathToTemplateOrdinalMap.put("templates/android/main/entity/read_entity.java.jet", //$NON-NLS-1$
                Integer.valueOf(6));
        pathToTemplateOrdinalMap.put("templates/android/main/entity/readall_adapter.java.jet", //$NON-NLS-1$
                Integer.valueOf(7));
        pathToTemplateOrdinalMap.put("templates/android/main/entity/search_entity.java.jet", //$NON-NLS-1$
                Integer.valueOf(8));
        pathToTemplateOrdinalMap.put("templates/android/main/entity/update_entity.java.jet", //$NON-NLS-1$
                Integer.valueOf(9));
        pathToTemplateOrdinalMap.put("templates/android/main/login.java.jet", //$NON-NLS-1$
                Integer.valueOf(10));
        pathToTemplateOrdinalMap.put("templates/android/res/layout/app_title_bar.xml.jet", //$NON-NLS-1$
                Integer.valueOf(11));
        pathToTemplateOrdinalMap.put("templates/android/res/layout/entity_create.xml.jet", //$NON-NLS-1$
                Integer.valueOf(12));
        pathToTemplateOrdinalMap.put("templates/android/res/layout/entity_read.xml.jet", //$NON-NLS-1$
                Integer.valueOf(13));
        pathToTemplateOrdinalMap.put("templates/android/res/layout/entity_readall.xml.jet", //$NON-NLS-1$
                Integer.valueOf(14));
        pathToTemplateOrdinalMap.put("templates/android/res/layout/list_item.xml.jet", //$NON-NLS-1$
                Integer.valueOf(15));
        pathToTemplateOrdinalMap.put("templates/android/res/layout/readall_list.xml.jet", //$NON-NLS-1$
                Integer.valueOf(16));
        pathToTemplateOrdinalMap.put("templates/android/res/menu/entity_menu.xml.jet", //$NON-NLS-1$
                Integer.valueOf(17));
        pathToTemplateOrdinalMap.put("templates/android/res/values/strings.xml.jet", //$NON-NLS-1$
                Integer.valueOf(18));
        pathToTemplateOrdinalMap.put("templates/androidy/android_manifest.xml.jet", //$NON-NLS-1$
                Integer.valueOf(19));
        pathToTemplateOrdinalMap.put("templates/androidy/pom.xml.jet", //$NON-NLS-1$
                Integer.valueOf(20));
        pathToTemplateOrdinalMap.put("templates/androidy/project.properties.jet", //$NON-NLS-1$
                Integer.valueOf(21));
        pathToTemplateOrdinalMap.put("templates/androidy/res/layout/app_title_bar.xml.jet", //$NON-NLS-1$
                Integer.valueOf(22));
        pathToTemplateOrdinalMap.put("templates/androidy/res/layout/entity_create.xml.jet", //$NON-NLS-1$
                Integer.valueOf(23));
        pathToTemplateOrdinalMap.put("templates/androidy/res/layout/entity_read.xml.jet", //$NON-NLS-1$
                Integer.valueOf(24));
        pathToTemplateOrdinalMap.put("templates/androidy/res/layout/entity_readall.xml.jet", //$NON-NLS-1$
                Integer.valueOf(25));
        pathToTemplateOrdinalMap.put("templates/androidy/res/layout/list_item.xml.jet", //$NON-NLS-1$
                Integer.valueOf(26));
        pathToTemplateOrdinalMap.put("templates/androidy/res/layout/readall_list.xml.jet", //$NON-NLS-1$
                Integer.valueOf(27));
        pathToTemplateOrdinalMap.put("templates/androidy/res/menu/entity_menu.xml.jet", //$NON-NLS-1$
                Integer.valueOf(28));
        pathToTemplateOrdinalMap.put("templates/androidy/res/values/strings.xml.jet", //$NON-NLS-1$
                Integer.valueOf(29));
        pathToTemplateOrdinalMap.put("templates/androidy/src/main/java/Welcome.java.jet", //$NON-NLS-1$
                Integer.valueOf(30));
        pathToTemplateOrdinalMap.put("templates/androidy/src/main/java/entity/create_entity.java.jet", //$NON-NLS-1$
                Integer.valueOf(31));
        pathToTemplateOrdinalMap.put("templates/androidy/src/main/java/entity/read_all.java.jet", //$NON-NLS-1$
                Integer.valueOf(32));
        pathToTemplateOrdinalMap.put("templates/androidy/src/main/java/entity/read_entity.java.jet", //$NON-NLS-1$
                Integer.valueOf(33));
        pathToTemplateOrdinalMap.put("templates/androidy/src/main/java/entity/update_entity.java.jet", //$NON-NLS-1$
                Integer.valueOf(34));
        pathToTemplateOrdinalMap.put("templates/app/app_pom_template.xml.jet", //$NON-NLS-1$
                Integer.valueOf(35));
        pathToTemplateOrdinalMap.put("templates/app/jboss/deploy/app_hsqldb_ds_template.xml.jet", //$NON-NLS-1$
                Integer.valueOf(36));
        pathToTemplateOrdinalMap.put("templates/app/jboss/deploy/app_mysql_ds_template.xml.jet", //$NON-NLS-1$
                Integer.valueOf(37));
        pathToTemplateOrdinalMap.put("templates/app/jboss/deploy/app_oracle_ds_template.xml.jet", //$NON-NLS-1$
                Integer.valueOf(38));
        pathToTemplateOrdinalMap.put("templates/app/jboss/deploy/app_service.xml.jet", //$NON-NLS-1$
                Integer.valueOf(39));
        pathToTemplateOrdinalMap.put("templates/dao/pom.xml.jet", //$NON-NLS-1$
                Integer.valueOf(40));
        pathToTemplateOrdinalMap.put("templates/dao/src/main/java/dao.java.jet", //$NON-NLS-1$
                Integer.valueOf(41));
        pathToTemplateOrdinalMap.put("templates/dao/src/main/resources/META-INF/ejb_jar.xml.jet", //$NON-NLS-1$
                Integer.valueOf(42));
        pathToTemplateOrdinalMap.put("templates/dump.jet", //$NON-NLS-1$
                Integer.valueOf(43));
        pathToTemplateOrdinalMap.put("templates/ejb/ejb_pom_template.xml.jet", //$NON-NLS-1$
                Integer.valueOf(44));
        pathToTemplateOrdinalMap.put("templates/ejb/main/ejb_generic_service_bean.java.jet", //$NON-NLS-1$
                Integer.valueOf(45));
        pathToTemplateOrdinalMap.put("templates/ejb/main/ejb_generic_service_interface.java.jet", //$NON-NLS-1$
                Integer.valueOf(46));
        pathToTemplateOrdinalMap.put("templates/ejb/main/ejb_generic_service_local.java.jet", //$NON-NLS-1$
                Integer.valueOf(47));
        pathToTemplateOrdinalMap.put("templates/ejb/main/ejb_generic_service_remote.java.jet", //$NON-NLS-1$
                Integer.valueOf(48));
        pathToTemplateOrdinalMap.put("templates/ejb/main/ejb_service_bean_template.java.jet", //$NON-NLS-1$
                Integer.valueOf(49));
        pathToTemplateOrdinalMap.put("templates/ejb/main/ejb_service_local_template.java.jet", //$NON-NLS-1$
                Integer.valueOf(50));
        pathToTemplateOrdinalMap.put("templates/ejb/main/ejb_service_remote_template.java.jet", //$NON-NLS-1$
                Integer.valueOf(51));
        pathToTemplateOrdinalMap.put("templates/ejb/main/ejb_service_template.java.jet", //$NON-NLS-1$
                Integer.valueOf(52));
        pathToTemplateOrdinalMap.put("templates/ejb/main/resources/META-INF/components.xml.jet", //$NON-NLS-1$
                Integer.valueOf(53));
        pathToTemplateOrdinalMap.put("templates/ejb/main/resources/META-INF/ejb_jar.xml.jet", //$NON-NLS-1$
                Integer.valueOf(54));
        pathToTemplateOrdinalMap.put("templates/ejb/test/ejb_embedded_test.java.jet", //$NON-NLS-1$
                Integer.valueOf(55));
        pathToTemplateOrdinalMap.put("templates/ejb/test/jpa_test_persistence_template.xml.jet", //$NON-NLS-1$
                Integer.valueOf(56));
        pathToTemplateOrdinalMap.put("templates/ejb/test/resources/WEB-INF/components.xml.jet", //$NON-NLS-1$
                Integer.valueOf(57));
        pathToTemplateOrdinalMap.put("templates/ejb/test/resources/default.persistence.properties.jet", //$NON-NLS-1$
                Integer.valueOf(58));
        pathToTemplateOrdinalMap.put("templates/ejb/test/resources/ejb3-interceptors-aop.xml.jet", //$NON-NLS-1$
                Integer.valueOf(59));
        pathToTemplateOrdinalMap.put("templates/ejb/test/resources/embedded-jboss-beans.xml.jet", //$NON-NLS-1$
                Integer.valueOf(60));
        pathToTemplateOrdinalMap.put("templates/ejb/test/resources/jboss-jms-beans.xml.jet", //$NON-NLS-1$
                Integer.valueOf(61));
        pathToTemplateOrdinalMap.put("templates/ejb/test/resources/jndi.properties.jet", //$NON-NLS-1$
                Integer.valueOf(62));
        pathToTemplateOrdinalMap.put("templates/ejb/test/resources/log4j.xml.jet", //$NON-NLS-1$
                Integer.valueOf(63));
        pathToTemplateOrdinalMap.put("templates/ejb/test/resources/login-config.xml.jet", //$NON-NLS-1$
                Integer.valueOf(64));
        pathToTemplateOrdinalMap.put("templates/ejb/test/resources/security-beans.xml.jet", //$NON-NLS-1$
                Integer.valueOf(65));
        pathToTemplateOrdinalMap.put("templates/ios/entity/create_entity_controller.h.jet", //$NON-NLS-1$
                Integer.valueOf(66));
        pathToTemplateOrdinalMap.put("templates/ios/entity/create_entity_controller.m.jet", //$NON-NLS-1$
                Integer.valueOf(67));
        pathToTemplateOrdinalMap.put("templates/ios/entity/read_all_entity_controller.h.jet", //$NON-NLS-1$
                Integer.valueOf(68));
        pathToTemplateOrdinalMap.put("templates/ios/entity/read_all_entity_controller.m.jet", //$NON-NLS-1$
                Integer.valueOf(69));
        pathToTemplateOrdinalMap.put("templates/ios/entity/read_entity_controller.h.jet", //$NON-NLS-1$
                Integer.valueOf(70));
        pathToTemplateOrdinalMap.put("templates/ios/entity/read_entity_controller.m.jet", //$NON-NLS-1$
                Integer.valueOf(71));
        pathToTemplateOrdinalMap.put("templates/ios/main/HttpUtils.h.jet", //$NON-NLS-1$
                Integer.valueOf(72));
        pathToTemplateOrdinalMap.put("templates/ios/main/HttpUtils.m.jet", //$NON-NLS-1$
                Integer.valueOf(73));
        pathToTemplateOrdinalMap.put("templates/ios/main/root_view_controller.h.jet", //$NON-NLS-1$
                Integer.valueOf(74));
        pathToTemplateOrdinalMap.put("templates/ios/main/root_view_controller.m.jet", //$NON-NLS-1$
                Integer.valueOf(75));
        pathToTemplateOrdinalMap.put("templates/ios/transfer-objects/entity_implementation.m.jet", //$NON-NLS-1$
                Integer.valueOf(76));
        pathToTemplateOrdinalMap.put("templates/ios/transfer-objects/entity_interface.h.jet", //$NON-NLS-1$
                Integer.valueOf(77));
        pathToTemplateOrdinalMap.put("templates/jaxb/pom.xml.jet", //$NON-NLS-1$
                Integer.valueOf(78));
        pathToTemplateOrdinalMap.put("templates/jaxb/src/main/java/jaxb.java.jet", //$NON-NLS-1$
                Integer.valueOf(79));
        pathToTemplateOrdinalMap.put("templates/jpa/jpa_pom_template.xml.jet", //$NON-NLS-1$
                Integer.valueOf(80));
        pathToTemplateOrdinalMap.put("templates/jpa/src/main/java/enumeration_template.java.jet", //$NON-NLS-1$
                Integer.valueOf(81));
        pathToTemplateOrdinalMap.put("templates/jpa/src/main/java/jpa_class_template.java.jet", //$NON-NLS-1$
                Integer.valueOf(82));
        pathToTemplateOrdinalMap.put("templates/jpa/src/main/jpa_gwtxml.template.xml.jet", //$NON-NLS-1$
                Integer.valueOf(83));
        pathToTemplateOrdinalMap.put("templates/jpa/src/main/resources/abbrevation.properties.jet", //$NON-NLS-1$
                Integer.valueOf(84));
        pathToTemplateOrdinalMap.put("templates/jpa/src/main/resources/jpa_ormxml_template.xml.jet", //$NON-NLS-1$
                Integer.valueOf(85));
        pathToTemplateOrdinalMap.put("templates/jpa/src/main/resources/jpa_persistence_template.xml.jet", //$NON-NLS-1$
                Integer.valueOf(86));
        pathToTemplateOrdinalMap.put("templates/jpa/src/test/java/abstract_entity_test.java.jet", //$NON-NLS-1$
                Integer.valueOf(87));
        pathToTemplateOrdinalMap.put("templates/jpa/src/test/java/jpa_enitity_test.java.jet", //$NON-NLS-1$
                Integer.valueOf(88));
        pathToTemplateOrdinalMap.put("templates/jpa/src/test/resources/jndi.properties.jet", //$NON-NLS-1$
                Integer.valueOf(89));
        pathToTemplateOrdinalMap.put("templates/main.jet", //$NON-NLS-1$
                Integer.valueOf(90));
        pathToTemplateOrdinalMap.put("templates/main/class_associations.jet", //$NON-NLS-1$
                Integer.valueOf(91));
        pathToTemplateOrdinalMap.put("templates/main/class_dependency.jet", //$NON-NLS-1$
                Integer.valueOf(92));
        pathToTemplateOrdinalMap.put("templates/main/class_parents.jet", //$NON-NLS-1$
                Integer.valueOf(93));
        pathToTemplateOrdinalMap.put("templates/main/load_profiles.jet", //$NON-NLS-1$
                Integer.valueOf(94));
        pathToTemplateOrdinalMap.put("templates/main/required_fields.jet", //$NON-NLS-1$
                Integer.valueOf(95));
        pathToTemplateOrdinalMap.put("templates/main/setup.jet", //$NON-NLS-1$
                Integer.valueOf(96));
        pathToTemplateOrdinalMap.put("templates/main/utils.jet", //$NON-NLS-1$
                Integer.valueOf(97));
        pathToTemplateOrdinalMap.put("templates/master/master_pom_template.xml.jet", //$NON-NLS-1$
                Integer.valueOf(98));
        pathToTemplateOrdinalMap.put("templates/rest/rest_pom_template.xml.jet", //$NON-NLS-1$
                Integer.valueOf(99));
        pathToTemplateOrdinalMap.put("templates/rest/src/main/java/entity/entity_rest_service.java.jet", //$NON-NLS-1$
                Integer.valueOf(100));
        pathToTemplateOrdinalMap.put("templates/rest/src/main/resources/META-INF/ejb_jar.xml.jet", //$NON-NLS-1$
                Integer.valueOf(101));
        pathToTemplateOrdinalMap.put("templates/test/test/resources/env.properties.jet", //$NON-NLS-1$
                Integer.valueOf(102));
        pathToTemplateOrdinalMap.put("templates/test/test/test_entity_selenium_class.java.jet", //$NON-NLS-1$
                Integer.valueOf(103));
        pathToTemplateOrdinalMap.put("templates/test/test/test_entity_webdriver_class.java.jet", //$NON-NLS-1$
                Integer.valueOf(104));
        pathToTemplateOrdinalMap.put("templates/test/test_pom.xml.jet", //$NON-NLS-1$
                Integer.valueOf(105));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/app_request_factory.java.jet", //$NON-NLS-1$
                Integer.valueOf(106));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/entity/create_panely.java.jet", //$NON-NLS-1$
                Integer.valueOf(107));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/entity/read_all_abstract.java.jet", //$NON-NLS-1$
                Integer.valueOf(108));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/entity/read_all_panel.java.jet", //$NON-NLS-1$
                Integer.valueOf(109));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/entity/read_panely.java.jet", //$NON-NLS-1$
                Integer.valueOf(110));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/entity/select_panely.java.jet", //$NON-NLS-1$
                Integer.valueOf(111));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/entity/tree_panel_abstract.java.jet", //$NON-NLS-1$
                Integer.valueOf(112));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/entity/tree_panely.java.jet", //$NON-NLS-1$
                Integer.valueOf(113));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/entity/update_panely.java.jet", //$NON-NLS-1$
                Integer.valueOf(114));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/entity/web_create_panel_template.java.jet", //$NON-NLS-1$
                Integer.valueOf(115));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/entity/web_option_panel_template.java.jet", //$NON-NLS-1$
                Integer.valueOf(116));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/entity/web_read_panel_template.java.jet", //$NON-NLS-1$
                Integer.valueOf(117));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/entity/web_readall_abstract_panel_template.java.jet", //$NON-NLS-1$
                Integer.valueOf(118));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/entity/web_readall_panel_template.java.jet", //$NON-NLS-1$
                Integer.valueOf(119));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/entity/web_search_generic_panel_template.java.jet", //$NON-NLS-1$
                Integer.valueOf(120));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/entity/web_select_panel_template.java.jet", //$NON-NLS-1$
                Integer.valueOf(121));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/entity/web_side_panel_template.java.jet", //$NON-NLS-1$
                Integer.valueOf(122));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/entity/web_tree_abstract_panel_template.java.jet", //$NON-NLS-1$
                Integer.valueOf(123));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/entity/web_tree_panel_template.java.jet", //$NON-NLS-1$
                Integer.valueOf(124));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/entity/web_update_panel_template.java.jet", //$NON-NLS-1$
                Integer.valueOf(125));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/internalization/web_gwt_constants.properties.jet", //$NON-NLS-1$
                Integer.valueOf(126));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/internalization/web_gwt_messages.properties.jet", //$NON-NLS-1$
                Integer.valueOf(127));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/rf/entity_proxy.java.jet", //$NON-NLS-1$
                Integer.valueOf(128));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/rf/entity_request.java.jet", //$NON-NLS-1$
                Integer.valueOf(129));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/root_layout.java.jet", //$NON-NLS-1$
                Integer.valueOf(130));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/root_layout.ui.xml.jet", //$NON-NLS-1$
                Integer.valueOf(131));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/rpc/app_service_async.java.jet", //$NON-NLS-1$
                Integer.valueOf(132));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/rpc/app_service_sync.java.jet", //$NON-NLS-1$
                Integer.valueOf(133));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/rpc/entity_service_async.java.jet", //$NON-NLS-1$
                Integer.valueOf(134));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/rpc/entity_service_sync.java.jet", //$NON-NLS-1$
                Integer.valueOf(135));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/web_create_user.java.jet", //$NON-NLS-1$
                Integer.valueOf(136));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/web_entity_enum_template.java.jet", //$NON-NLS-1$
                Integer.valueOf(137));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/web_entrypoint_class_template.java.jet", //$NON-NLS-1$
                Integer.valueOf(138));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/web_login_panel_template.java.jet", //$NON-NLS-1$
                Integer.valueOf(139));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/web_roles_enum_template.java.jet", //$NON-NLS-1$
                Integer.valueOf(140));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/web_root_panels_template.java.jet", //$NON-NLS-1$
                Integer.valueOf(141));
        pathToTemplateOrdinalMap.put("templates/web/gwt/client/web_status_panel_template.java.jet", //$NON-NLS-1$
                Integer.valueOf(142));
        pathToTemplateOrdinalMap.put("templates/web/gwt/public/web_css_template.css.jet", //$NON-NLS-1$
                Integer.valueOf(143));
        pathToTemplateOrdinalMap.put("templates/web/gwt/server/app_service_impl.java.jet", //$NON-NLS-1$
                Integer.valueOf(144));
        pathToTemplateOrdinalMap.put("templates/web/gwt/server/app_startup.java.jet", //$NON-NLS-1$
                Integer.valueOf(145));
        pathToTemplateOrdinalMap.put("templates/web/gwt/server/entity_gwt_dao.java.jet", //$NON-NLS-1$
                Integer.valueOf(146));
        pathToTemplateOrdinalMap.put("templates/web/gwt/server/entity_service_impl.java.jet", //$NON-NLS-1$
                Integer.valueOf(147));
        pathToTemplateOrdinalMap.put("templates/web/gwt/server/rf/generic_entity_locator.java.jet", //$NON-NLS-1$
                Integer.valueOf(148));
        pathToTemplateOrdinalMap.put("templates/web/gwt/web_gwtxml_template.xml.jet", //$NON-NLS-1$
                Integer.valueOf(149));
        pathToTemplateOrdinalMap.put("templates/web/seam.properties.jet", //$NON-NLS-1$
                Integer.valueOf(150));
        pathToTemplateOrdinalMap.put("templates/web/test/gwt/server/web_server_impl_test.java.jet", //$NON-NLS-1$
                Integer.valueOf(151));
        pathToTemplateOrdinalMap.put("templates/web/webapp/META-INF/security-rules.drl.jet", //$NON-NLS-1$
                Integer.valueOf(152));
        pathToTemplateOrdinalMap.put("templates/web/webapp/WEB-INF/webapp_components.xml.jet", //$NON-NLS-1$
                Integer.valueOf(153));
        pathToTemplateOrdinalMap.put("templates/web/webapp/WEB-INF/webapp_jboss-web.xml.jet", //$NON-NLS-1$
                Integer.valueOf(154));
        pathToTemplateOrdinalMap.put("templates/web/webapp/WEB-INF/webapp_webxml_template.xml.jet", //$NON-NLS-1$
                Integer.valueOf(155));
        pathToTemplateOrdinalMap.put("templates/web/webapp/web_html_template.html.jet", //$NON-NLS-1$
                Integer.valueOf(156));
        pathToTemplateOrdinalMap.put("templates/web/webapp/web_indexhtml_template.html.jet", //$NON-NLS-1$
                Integer.valueOf(157));
        pathToTemplateOrdinalMap.put("templates/web/webapp_appxml_template.properties.jet", //$NON-NLS-1$
                Integer.valueOf(158));
        pathToTemplateOrdinalMap.put("templates/web/webapp_pom_template.xml.jet", //$NON-NLS-1$
                Integer.valueOf(159));
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jet.JET2TemplateLoader#getTemplate(java.lang.String)
     */
    public JET2Template getTemplate(final String templatePath) {
        final Integer ordinal = pathToTemplateOrdinalMap.get(templatePath);
        if(ordinal != null) {
           switch (ordinal.intValue()) {
            case 0: // templates/android/android_default.properties.jet
                return new office_mda.compiled._jet_android_defaultproperties();
            case 1: // templates/android/android_manifest_template.xml.jet
                return new office_mda.compiled._jet_android_manifest_templatexml();
            case 2: // templates/android/android_pom_template.xml.jet
                return new office_mda.compiled._jet_android_pom_templatexml();
            case 3: // templates/android/main/Main.java.jet
                return new office_mda.compiled._jet_Mainjava();
            case 4: // templates/android/main/entity/create_entity.java.jet
                return new office_mda.compiled._jet_create_entityjava_0();
            case 5: // templates/android/main/entity/read_all.java.jet
                return new office_mda.compiled._jet_read_alljava_0();
            case 6: // templates/android/main/entity/read_entity.java.jet
                return new office_mda.compiled._jet_read_entityjava();
            case 7: // templates/android/main/entity/readall_adapter.java.jet
                return new office_mda.compiled._jet_readall_adapterjava();
            case 8: // templates/android/main/entity/search_entity.java.jet
                return new office_mda.compiled._jet_search_entityjava();
            case 9: // templates/android/main/entity/update_entity.java.jet
                return new office_mda.compiled._jet_update_entityjava_0();
            case 10: // templates/android/main/login.java.jet
                return new office_mda.compiled._jet_loginjava();
            case 11: // templates/android/res/layout/app_title_bar.xml.jet
                return new office_mda.compiled._jet_app_title_barxml_0();
            case 12: // templates/android/res/layout/entity_create.xml.jet
                return new office_mda.compiled._jet_entity_createxml();
            case 13: // templates/android/res/layout/entity_read.xml.jet
                return new office_mda.compiled._jet_entity_readxml_0();
            case 14: // templates/android/res/layout/entity_readall.xml.jet
                return new office_mda.compiled._jet_entity_readallxml_0();
            case 15: // templates/android/res/layout/list_item.xml.jet
                return new office_mda.compiled._jet_list_itemxml();
            case 16: // templates/android/res/layout/readall_list.xml.jet
                return new office_mda.compiled._jet_readall_listxml();
            case 17: // templates/android/res/menu/entity_menu.xml.jet
                return new office_mda.compiled._jet_entity_menuxml();
            case 18: // templates/android/res/values/strings.xml.jet
                return new office_mda.compiled._jet_stringsxml();
            case 19: // templates/androidy/android_manifest.xml.jet
                return new office_mda.compiled._jet_android_manifestxml();
            case 20: // templates/androidy/pom.xml.jet
                return new office_mda.compiled._jet_pomxml_1();
            case 21: // templates/androidy/project.properties.jet
                return new office_mda.compiled._jet_projectproperties();
            case 22: // templates/androidy/res/layout/app_title_bar.xml.jet
                return new office_mda.compiled._jet_app_title_barxml();
            case 23: // templates/androidy/res/layout/entity_create.xml.jet
                return new office_mda.compiled._jet_entity_createxml_0();
            case 24: // templates/androidy/res/layout/entity_read.xml.jet
                return new office_mda.compiled._jet_entity_readxml();
            case 25: // templates/androidy/res/layout/entity_readall.xml.jet
                return new office_mda.compiled._jet_entity_readallxml();
            case 26: // templates/androidy/res/layout/list_item.xml.jet
                return new office_mda.compiled._jet_list_itemxml_0();
            case 27: // templates/androidy/res/layout/readall_list.xml.jet
                return new office_mda.compiled._jet_readall_listxml_0();
            case 28: // templates/androidy/res/menu/entity_menu.xml.jet
                return new office_mda.compiled._jet_entity_menuxml_0();
            case 29: // templates/androidy/res/values/strings.xml.jet
                return new office_mda.compiled._jet_stringsxml_0();
            case 30: // templates/androidy/src/main/java/Welcome.java.jet
                return new office_mda.compiled._jet_Welcomejava();
            case 31: // templates/androidy/src/main/java/entity/create_entity.java.jet
                return new office_mda.compiled._jet_create_entityjava();
            case 32: // templates/androidy/src/main/java/entity/read_all.java.jet
                return new office_mda.compiled._jet_read_alljava();
            case 33: // templates/androidy/src/main/java/entity/read_entity.java.jet
                return new office_mda.compiled._jet_read_entityjava_0();
            case 34: // templates/androidy/src/main/java/entity/update_entity.java.jet
                return new office_mda.compiled._jet_update_entityjava();
            case 35: // templates/app/app_pom_template.xml.jet
                return new office_mda.compiled._jet_app_pom_templatexml();
            case 36: // templates/app/jboss/deploy/app_hsqldb_ds_template.xml.jet
                return new office_mda.compiled._jet_app_hsqldb_ds_templatexml();
            case 37: // templates/app/jboss/deploy/app_mysql_ds_template.xml.jet
                return new office_mda.compiled._jet_app_mysql_ds_templatexml();
            case 38: // templates/app/jboss/deploy/app_oracle_ds_template.xml.jet
                return new office_mda.compiled._jet_app_oracle_ds_templatexml();
            case 39: // templates/app/jboss/deploy/app_service.xml.jet
                return new office_mda.compiled._jet_app_servicexml();
            case 40: // templates/dao/pom.xml.jet
                return new office_mda.compiled._jet_pomxml_0();
            case 41: // templates/dao/src/main/java/dao.java.jet
                return new office_mda.compiled._jet_daojava();
            case 42: // templates/dao/src/main/resources/META-INF/ejb_jar.xml.jet
                return new office_mda.compiled._jet_ejb_jarxml();
            case 43: // templates/dump.jet
                return new office_mda.compiled._jet_dump();
            case 44: // templates/ejb/ejb_pom_template.xml.jet
                return new office_mda.compiled._jet_ejb_pom_templatexml();
            case 45: // templates/ejb/main/ejb_generic_service_bean.java.jet
                return new office_mda.compiled._jet_ejb_generic_service_beanjava();
            case 46: // templates/ejb/main/ejb_generic_service_interface.java.jet
                return new office_mda.compiled._jet_ejb_generic_service_interfacejava();
            case 47: // templates/ejb/main/ejb_generic_service_local.java.jet
                return new office_mda.compiled._jet_ejb_generic_service_localjava();
            case 48: // templates/ejb/main/ejb_generic_service_remote.java.jet
                return new office_mda.compiled._jet_ejb_generic_service_remotejava();
            case 49: // templates/ejb/main/ejb_service_bean_template.java.jet
                return new office_mda.compiled._jet_ejb_service_bean_templatejava();
            case 50: // templates/ejb/main/ejb_service_local_template.java.jet
                return new office_mda.compiled._jet_ejb_service_local_templatejava();
            case 51: // templates/ejb/main/ejb_service_remote_template.java.jet
                return new office_mda.compiled._jet_ejb_service_remote_templatejava();
            case 52: // templates/ejb/main/ejb_service_template.java.jet
                return new office_mda.compiled._jet_ejb_service_templatejava();
            case 53: // templates/ejb/main/resources/META-INF/components.xml.jet
                return new office_mda.compiled._jet_componentsxml_1();
            case 54: // templates/ejb/main/resources/META-INF/ejb_jar.xml.jet
                return new office_mda.compiled._jet_ejb_jarxml_0();
            case 55: // templates/ejb/test/ejb_embedded_test.java.jet
                return new office_mda.compiled._jet_ejb_embedded_testjava();
            case 56: // templates/ejb/test/jpa_test_persistence_template.xml.jet
                return new office_mda.compiled._jet_jpa_test_persistence_templatexml();
            case 57: // templates/ejb/test/resources/WEB-INF/components.xml.jet
                return new office_mda.compiled._jet_componentsxml_2();
            case 58: // templates/ejb/test/resources/default.persistence.properties.jet
                return new office_mda.compiled._jet_defaultpersistenceproperties();
            case 59: // templates/ejb/test/resources/ejb3-interceptors-aop.xml.jet
                return new office_mda.compiled._jet_ejb3interceptorsaopxml();
            case 60: // templates/ejb/test/resources/embedded-jboss-beans.xml.jet
                return new office_mda.compiled._jet_embeddedjbossbeansxml();
            case 61: // templates/ejb/test/resources/jboss-jms-beans.xml.jet
                return new office_mda.compiled._jet_jbossjmsbeansxml();
            case 62: // templates/ejb/test/resources/jndi.properties.jet
                return new office_mda.compiled._jet_jndiproperties();
            case 63: // templates/ejb/test/resources/log4j.xml.jet
                return new office_mda.compiled._jet_log4jxml();
            case 64: // templates/ejb/test/resources/login-config.xml.jet
                return new office_mda.compiled._jet_loginconfigxml();
            case 65: // templates/ejb/test/resources/security-beans.xml.jet
                return new office_mda.compiled._jet_securitybeansxml();
            case 66: // templates/ios/entity/create_entity_controller.h.jet
                return new office_mda.compiled._jet_create_entity_controllerh();
            case 67: // templates/ios/entity/create_entity_controller.m.jet
                return new office_mda.compiled._jet_create_entity_controllerm();
            case 68: // templates/ios/entity/read_all_entity_controller.h.jet
                return new office_mda.compiled._jet_read_all_entity_controllerh();
            case 69: // templates/ios/entity/read_all_entity_controller.m.jet
                return new office_mda.compiled._jet_read_all_entity_controllerm();
            case 70: // templates/ios/entity/read_entity_controller.h.jet
                return new office_mda.compiled._jet_read_entity_controllerh();
            case 71: // templates/ios/entity/read_entity_controller.m.jet
                return new office_mda.compiled._jet_read_entity_controllerm();
            case 72: // templates/ios/main/HttpUtils.h.jet
                return new office_mda.compiled._jet_HttpUtilsh();
            case 73: // templates/ios/main/HttpUtils.m.jet
                return new office_mda.compiled._jet_HttpUtilsm();
            case 74: // templates/ios/main/root_view_controller.h.jet
                return new office_mda.compiled._jet_root_view_controllerh();
            case 75: // templates/ios/main/root_view_controller.m.jet
                return new office_mda.compiled._jet_root_view_controllerm();
            case 76: // templates/ios/transfer-objects/entity_implementation.m.jet
                return new office_mda.compiled._jet_entity_implementationm();
            case 77: // templates/ios/transfer-objects/entity_interface.h.jet
                return new office_mda.compiled._jet_entity_interfaceh();
            case 78: // templates/jaxb/pom.xml.jet
                return new office_mda.compiled._jet_pomxml();
            case 79: // templates/jaxb/src/main/java/jaxb.java.jet
                return new office_mda.compiled._jet_jaxbjava();
            case 80: // templates/jpa/jpa_pom_template.xml.jet
                return new office_mda.compiled._jet_jpa_pom_templatexml();
            case 81: // templates/jpa/src/main/java/enumeration_template.java.jet
                return new office_mda.compiled._jet_enumeration_templatejava();
            case 82: // templates/jpa/src/main/java/jpa_class_template.java.jet
                return new office_mda.compiled._jet_jpa_class_templatejava();
            case 83: // templates/jpa/src/main/jpa_gwtxml.template.xml.jet
                return new office_mda.compiled._jet_jpa_gwtxmltemplatexml();
            case 84: // templates/jpa/src/main/resources/abbrevation.properties.jet
                return new office_mda.compiled._jet_abbrevationproperties();
            case 85: // templates/jpa/src/main/resources/jpa_ormxml_template.xml.jet
                return new office_mda.compiled._jet_jpa_ormxml_templatexml();
            case 86: // templates/jpa/src/main/resources/jpa_persistence_template.xml.jet
                return new office_mda.compiled._jet_jpa_persistence_templatexml();
            case 87: // templates/jpa/src/test/java/abstract_entity_test.java.jet
                return new office_mda.compiled._jet_abstract_entity_testjava();
            case 88: // templates/jpa/src/test/java/jpa_enitity_test.java.jet
                return new office_mda.compiled._jet_jpa_enitity_testjava();
            case 89: // templates/jpa/src/test/resources/jndi.properties.jet
                return new office_mda.compiled._jet_jndiproperties_0();
            case 90: // templates/main.jet
                return new office_mda.compiled._jet_main();
            case 91: // templates/main/class_associations.jet
                return new office_mda.compiled._jet_class_associations();
            case 92: // templates/main/class_dependency.jet
                return new office_mda.compiled._jet_class_dependency();
            case 93: // templates/main/class_parents.jet
                return new office_mda.compiled._jet_class_parents();
            case 94: // templates/main/load_profiles.jet
                return new office_mda.compiled._jet_load_profiles();
            case 95: // templates/main/required_fields.jet
                return new office_mda.compiled._jet_required_fields();
            case 96: // templates/main/setup.jet
                return new office_mda.compiled._jet_setup();
            case 97: // templates/main/utils.jet
                return new office_mda.compiled._jet_utils();
            case 98: // templates/master/master_pom_template.xml.jet
                return new office_mda.compiled._jet_master_pom_templatexml();
            case 99: // templates/rest/rest_pom_template.xml.jet
                return new office_mda.compiled._jet_rest_pom_templatexml();
            case 100: // templates/rest/src/main/java/entity/entity_rest_service.java.jet
                return new office_mda.compiled._jet_entity_rest_servicejava();
            case 101: // templates/rest/src/main/resources/META-INF/ejb_jar.xml.jet
                return new office_mda.compiled._jet_ejb_jarxml_1();
            case 102: // templates/test/test/resources/env.properties.jet
                return new office_mda.compiled._jet_envproperties();
            case 103: // templates/test/test/test_entity_selenium_class.java.jet
                return new office_mda.compiled._jet_test_entity_selenium_classjava();
            case 104: // templates/test/test/test_entity_webdriver_class.java.jet
                return new office_mda.compiled._jet_test_entity_webdriver_classjava();
            case 105: // templates/test/test_pom.xml.jet
                return new office_mda.compiled._jet_test_pomxml();
            case 106: // templates/web/gwt/client/app_request_factory.java.jet
                return new office_mda.compiled._jet_app_request_factoryjava();
            case 107: // templates/web/gwt/client/entity/create_panely.java.jet
                return new office_mda.compiled._jet_create_panelyjava();
            case 108: // templates/web/gwt/client/entity/read_all_abstract.java.jet
                return new office_mda.compiled._jet_read_all_abstractjava();
            case 109: // templates/web/gwt/client/entity/read_all_panel.java.jet
                return new office_mda.compiled._jet_read_all_paneljava();
            case 110: // templates/web/gwt/client/entity/read_panely.java.jet
                return new office_mda.compiled._jet_read_panelyjava();
            case 111: // templates/web/gwt/client/entity/select_panely.java.jet
                return new office_mda.compiled._jet_select_panelyjava();
            case 112: // templates/web/gwt/client/entity/tree_panel_abstract.java.jet
                return new office_mda.compiled._jet_tree_panel_abstractjava();
            case 113: // templates/web/gwt/client/entity/tree_panely.java.jet
                return new office_mda.compiled._jet_tree_panelyjava();
            case 114: // templates/web/gwt/client/entity/update_panely.java.jet
                return new office_mda.compiled._jet_update_panelyjava();
            case 115: // templates/web/gwt/client/entity/web_create_panel_template.java.jet
                return new office_mda.compiled._jet_web_create_panel_templatejava();
            case 116: // templates/web/gwt/client/entity/web_option_panel_template.java.jet
                return new office_mda.compiled._jet_web_option_panel_templatejava();
            case 117: // templates/web/gwt/client/entity/web_read_panel_template.java.jet
                return new office_mda.compiled._jet_web_read_panel_templatejava();
            case 118: // templates/web/gwt/client/entity/web_readall_abstract_panel_template.java.jet
                return new office_mda.compiled._jet_web_readall_abstract_panel_templatejava();
            case 119: // templates/web/gwt/client/entity/web_readall_panel_template.java.jet
                return new office_mda.compiled._jet_web_readall_panel_templatejava();
            case 120: // templates/web/gwt/client/entity/web_search_generic_panel_template.java.jet
                return new office_mda.compiled._jet_web_search_generic_panel_templatejava();
            case 121: // templates/web/gwt/client/entity/web_select_panel_template.java.jet
                return new office_mda.compiled._jet_web_select_panel_templatejava();
            case 122: // templates/web/gwt/client/entity/web_side_panel_template.java.jet
                return new office_mda.compiled._jet_web_side_panel_templatejava();
            case 123: // templates/web/gwt/client/entity/web_tree_abstract_panel_template.java.jet
                return new office_mda.compiled._jet_web_tree_abstract_panel_templatejava();
            case 124: // templates/web/gwt/client/entity/web_tree_panel_template.java.jet
                return new office_mda.compiled._jet_web_tree_panel_templatejava();
            case 125: // templates/web/gwt/client/entity/web_update_panel_template.java.jet
                return new office_mda.compiled._jet_web_update_panel_templatejava();
            case 126: // templates/web/gwt/client/internalization/web_gwt_constants.properties.jet
                return new office_mda.compiled._jet_web_gwt_constantsproperties();
            case 127: // templates/web/gwt/client/internalization/web_gwt_messages.properties.jet
                return new office_mda.compiled._jet_web_gwt_messagesproperties();
            case 128: // templates/web/gwt/client/rf/entity_proxy.java.jet
                return new office_mda.compiled._jet_entity_proxyjava();
            case 129: // templates/web/gwt/client/rf/entity_request.java.jet
                return new office_mda.compiled._jet_entity_requestjava();
            case 130: // templates/web/gwt/client/root_layout.java.jet
                return new office_mda.compiled._jet_root_layoutjava();
            case 131: // templates/web/gwt/client/root_layout.ui.xml.jet
                return new office_mda.compiled._jet_root_layoutuixml();
            case 132: // templates/web/gwt/client/rpc/app_service_async.java.jet
                return new office_mda.compiled._jet_app_service_asyncjava();
            case 133: // templates/web/gwt/client/rpc/app_service_sync.java.jet
                return new office_mda.compiled._jet_app_service_syncjava();
            case 134: // templates/web/gwt/client/rpc/entity_service_async.java.jet
                return new office_mda.compiled._jet_entity_service_asyncjava();
            case 135: // templates/web/gwt/client/rpc/entity_service_sync.java.jet
                return new office_mda.compiled._jet_entity_service_syncjava();
            case 136: // templates/web/gwt/client/web_create_user.java.jet
                return new office_mda.compiled._jet_web_create_userjava();
            case 137: // templates/web/gwt/client/web_entity_enum_template.java.jet
                return new office_mda.compiled._jet_web_entity_enum_templatejava();
            case 138: // templates/web/gwt/client/web_entrypoint_class_template.java.jet
                return new office_mda.compiled._jet_web_entrypoint_class_templatejava();
            case 139: // templates/web/gwt/client/web_login_panel_template.java.jet
                return new office_mda.compiled._jet_web_login_panel_templatejava();
            case 140: // templates/web/gwt/client/web_roles_enum_template.java.jet
                return new office_mda.compiled._jet_web_roles_enum_templatejava();
            case 141: // templates/web/gwt/client/web_root_panels_template.java.jet
                return new office_mda.compiled._jet_web_root_panels_templatejava();
            case 142: // templates/web/gwt/client/web_status_panel_template.java.jet
                return new office_mda.compiled._jet_web_status_panel_templatejava();
            case 143: // templates/web/gwt/public/web_css_template.css.jet
                return new office_mda.compiled._jet_web_css_templatecss();
            case 144: // templates/web/gwt/server/app_service_impl.java.jet
                return new office_mda.compiled._jet_app_service_impljava();
            case 145: // templates/web/gwt/server/app_startup.java.jet
                return new office_mda.compiled._jet_app_startupjava();
            case 146: // templates/web/gwt/server/entity_gwt_dao.java.jet
                return new office_mda.compiled._jet_entity_gwt_daojava();
            case 147: // templates/web/gwt/server/entity_service_impl.java.jet
                return new office_mda.compiled._jet_entity_service_impljava();
            case 148: // templates/web/gwt/server/rf/generic_entity_locator.java.jet
                return new office_mda.compiled._jet_generic_entity_locatorjava();
            case 149: // templates/web/gwt/web_gwtxml_template.xml.jet
                return new office_mda.compiled._jet_web_gwtxml_templatexml();
            case 150: // templates/web/seam.properties.jet
                return new office_mda.compiled._jet_seamproperties();
            case 151: // templates/web/test/gwt/server/web_server_impl_test.java.jet
                return new office_mda.compiled._jet_web_server_impl_testjava();
            case 152: // templates/web/webapp/META-INF/security-rules.drl.jet
                return new office_mda.compiled._jet_securityrulesdrl();
            case 153: // templates/web/webapp/WEB-INF/webapp_components.xml.jet
                return new office_mda.compiled._jet_webapp_componentsxml();
            case 154: // templates/web/webapp/WEB-INF/webapp_jboss-web.xml.jet
                return new office_mda.compiled._jet_webapp_jbosswebxml();
            case 155: // templates/web/webapp/WEB-INF/webapp_webxml_template.xml.jet
                return new office_mda.compiled._jet_webapp_webxml_templatexml();
            case 156: // templates/web/webapp/web_html_template.html.jet
                return new office_mda.compiled._jet_web_html_templatehtml();
            case 157: // templates/web/webapp/web_indexhtml_template.html.jet
                return new office_mda.compiled._jet_web_indexhtml_templatehtml();
            case 158: // templates/web/webapp_appxml_template.properties.jet
                return new office_mda.compiled._jet_webapp_appxml_templateproperties();
            case 159: // templates/web/webapp_pom_template.xml.jet
                return new office_mda.compiled._jet_webapp_pom_templatexml();
            default:
                break;
            }
        }
        return this.delegate != null ? this.delegate.getTemplate(templatePath) : null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jet.JET2TemplateLoaderExtension#getDelegateLoader()
     */
    public JET2TemplateLoader getDelegateLoader() {
        return this.delegate;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.jet.JET2TemplateLoaderExtension#setDelegateLoader(org.eclipse
     * .jet.JET2TemplateLoader)
     */
    public void setDelegateLoader(final JET2TemplateLoader loader) {
        this.delegate = loader;
    }
}
