package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_main implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_ws = "org.eclipse.jet.workspaceTags"; //$NON-NLS-1$

    public _jet_main() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_c_if_2_1 = new TagInfo("c:if", //$NON-NLS-1$
            2, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "isVariableDefined('org.eclipse.jet.resource.project.name')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_3_5 = new TagInfo("ws:file", //$NON-NLS-1$
            3, 5,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/dump.jet", //$NON-NLS-1$
                "{$org.eclipse.jet.resource.project.name}/dump.xml", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_7_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            7, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "lower-case(/XMI/XMI.content/Model/@name)", //$NON-NLS-1$
                "projectName", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_9_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            9, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'info.yalamanchili.office'", //$NON-NLS-1$
                "groupID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_10_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            10, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'info/yalamanchili/office'", //$NON-NLS-1$
                "groupIDWithFolder", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_11_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            11, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'info_yalamanchili_office'", //$NON-NLS-1$
                "groupIDWithUnderScore", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_12_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            12, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'1.0-SNAPSHOT'", //$NON-NLS-1$
                "version", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_13_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            13, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'D://codebase//office//trunk'", //$NON-NLS-1$
                "location", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_15_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            15, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'false'", //$NON-NLS-1$
                "enableHibernateSearch", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_17_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            17, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'TRUE'", //$NON-NLS-1$
                "supportJAXB", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_19_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            19, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'FALSE'", //$NON-NLS-1$
                "genMaster", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_20_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            20, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'FALSE'", //$NON-NLS-1$
                "genApp", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_21_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            21, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'TRUE'", //$NON-NLS-1$
                "genJPA", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_22_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            22, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'FALSE'", //$NON-NLS-1$
                "genDAO", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_23_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            23, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'FALSE'", //$NON-NLS-1$
                "genJAXB", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_24_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            24, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'FALSE'", //$NON-NLS-1$
                "genEJB", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_25_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            25, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'FALSE'", //$NON-NLS-1$
                "genRest", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_26_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            26, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'FALSE'", //$NON-NLS-1$
                "genWebapp", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_27_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            27, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'FALSE'", //$NON-NLS-1$
                "genAndroid", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_28_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            28, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'FALSE'", //$NON-NLS-1$
                "genIOS", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_29_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            29, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'FALSE'", //$NON-NLS-1$
                "genTest", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_30_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            30, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'FALSE'", //$NON-NLS-1$
                "genPOMS", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_32_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            32, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'1.1-SNAPSHOT'", //$NON-NLS-1$
                "yalamanchili-version", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_33_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            33, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'2.4.0'", //$NON-NLS-1$
                "gwt-version", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_34_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            34, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'2.4.0'", //$NON-NLS-1$
                "gwt-plugin-version", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_35_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            35, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'2.2.2.Final'", //$NON-NLS-1$
                "seam-version", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_37_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            37, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'1.0-SNAPSHOT'", //$NON-NLS-1$
                "yalamanchili-embedded-jboss-version", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_38_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            38, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'1.0-SNAPSHOT'", //$NON-NLS-1$
                "y-commom-deps-version", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_39_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            39, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'1.0-SNAPSHOT'", //$NON-NLS-1$
                "yalamanchili-commons-version", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_40_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            40, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'1.0-SNAPSHOT'", //$NON-NLS-1$
                "yalamanchili-gwt-version", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_41_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            41, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'2.2'", //$NON-NLS-1$
                "hibernate3-maven-plugin-version", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_42_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            42, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'1.0-SNAPSHOT'", //$NON-NLS-1$
                "jpa-testdata-plugin-version", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_43_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            43, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'5.1'", //$NON-NLS-1$
                "dozer-version", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_44_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            44, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'2.3.2'", //$NON-NLS-1$
                "ear-plugin-version", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_45_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            45, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'1.4'", //$NON-NLS-1$
                "jboss-maven-plugin-version", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_46_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            46, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'2.1'", //$NON-NLS-1$
                "android-version", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_47_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            47, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'1.3.1'", //$NON-NLS-1$
                "xstream-version", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_48_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            48, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'1.0.0.Alpha4'", //$NON-NLS-1$
                "arquillian-version", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_50_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            50, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'HSQL'", //$NON-NLS-1$
                "dataBase", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_51_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            51, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'http://argouml.org/user-profiles/YalamanchiliMDAProfile.xmi#'", //$NON-NLS-1$
                "yalamanchiliMDANameSpace", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_52_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            52, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "'true'", //$NON-NLS-1$
                "isMergeEnabled", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_include_55_1 = new TagInfo("c:include", //$NON-NLS-1$
            55, 1,
            new String[] {
                "template", //$NON-NLS-1$
            },
            new String[] {
                "templates/main/class_parents.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_include_58_1 = new TagInfo("c:include", //$NON-NLS-1$
            58, 1,
            new String[] {
                "template", //$NON-NLS-1$
            },
            new String[] {
                "templates/main/class_dependency.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_include_61_1 = new TagInfo("c:include", //$NON-NLS-1$
            61, 1,
            new String[] {
                "template", //$NON-NLS-1$
            },
            new String[] {
                "templates/main/class_associations.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_include_64_1 = new TagInfo("c:include", //$NON-NLS-1$
            64, 1,
            new String[] {
                "template", //$NON-NLS-1$
            },
            new String[] {
                "templates/main/load_profiles.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_include_67_1 = new TagInfo("c:include", //$NON-NLS-1$
            67, 1,
            new String[] {
                "template", //$NON-NLS-1$
            },
            new String[] {
                "templates/main/required_fields.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_70_1 = new TagInfo("c:if", //$NON-NLS-1$
            70, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$genMaster = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_71_1 = new TagInfo("c:if", //$NON-NLS-1$
            71, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$genPOMS = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_project_72_1 = new TagInfo("ws:project", //$NON-NLS-1$
            72, 1,
            new String[] {
                "name", //$NON-NLS-1$
                "location", //$NON-NLS-1$
            },
            new String[] {
                "{$projectName}-master", //$NON-NLS-1$
                "{$location}/{$projectName}-master", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_73_2 = new TagInfo("ws:file", //$NON-NLS-1$
            73, 2,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "pom.xml", //$NON-NLS-1$
                "templates/master/master_pom_template.xml.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_78_1 = new TagInfo("c:if", //$NON-NLS-1$
            78, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$genApp = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_project_79_1 = new TagInfo("ws:project", //$NON-NLS-1$
            79, 1,
            new String[] {
                "name", //$NON-NLS-1$
                "location", //$NON-NLS-1$
            },
            new String[] {
                "{$projectName}-app", //$NON-NLS-1$
                "{$location}/{$projectName}-app", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_80_2 = new TagInfo("c:if", //$NON-NLS-1$
            80, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$genPOMS = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_81_2 = new TagInfo("ws:file", //$NON-NLS-1$
            81, 2,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "pom.xml", //$NON-NLS-1$
                "templates/app/app_pom_template.xml.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_83_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            83, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "jboss/conf", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_84_6 = new TagInfo("c:if", //$NON-NLS-1$
            84, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$dataBase = 'MYSQL'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_85_5 = new TagInfo("ws:file", //$NON-NLS-1$
            85, 5,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "{$projectName}-mysql-ds.xml", //$NON-NLS-1$
                "templates/app/jboss/deploy/app_mysql_ds_template.xml.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_87_4 = new TagInfo("c:if", //$NON-NLS-1$
            87, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$dataBase = 'HSQL'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_88_5 = new TagInfo("ws:file", //$NON-NLS-1$
            88, 5,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "{$projectName}-hsql-ds.xml", //$NON-NLS-1$
                "templates/app/jboss/deploy/app_hsqldb_ds_template.xml.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_90_4 = new TagInfo("c:if", //$NON-NLS-1$
            90, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$dataBase = 'ORACLE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_91_5 = new TagInfo("ws:file", //$NON-NLS-1$
            91, 5,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "{$projectName}-oracle-ds.xml", //$NON-NLS-1$
                "templates/app/jboss/deploy/app_oracle_ds_template.xml.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_94_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            94, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "jboss/deploy", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_95_6 = new TagInfo("ws:file", //$NON-NLS-1$
            95, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "{$projectName}-service.xml", //$NON-NLS-1$
                "templates/app/jboss/deploy/app_service.xml.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_copyFile_96_6 = new TagInfo("ws:copyFile", //$NON-NLS-1$
            96, 6,
            new String[] {
                "src", //$NON-NLS-1$
                "target", //$NON-NLS-1$
            },
            new String[] {
                "templates/app/jboss/deploy/jboss-logging.xml", //$NON-NLS-1$
                "jboss-logging.xml", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_99_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            99, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "models", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_copyFile_100_6 = new TagInfo("ws:copyFile", //$NON-NLS-1$
            100, 6,
            new String[] {
                "src", //$NON-NLS-1$
                "target", //$NON-NLS-1$
            },
            new String[] {
                "sample.xml", //$NON-NLS-1$
                "{$projectName}.xmi", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_106_1 = new TagInfo("c:if", //$NON-NLS-1$
            106, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$genJPA = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_project_107_1 = new TagInfo("ws:project", //$NON-NLS-1$
            107, 1,
            new String[] {
                "name", //$NON-NLS-1$
                "location", //$NON-NLS-1$
            },
            new String[] {
                "{$projectName}-jpa", //$NON-NLS-1$
                "{$location}/{$projectName}-jpa", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_108_2 = new TagInfo("c:if", //$NON-NLS-1$
            108, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$genPOMS = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_109_2 = new TagInfo("ws:file", //$NON-NLS-1$
            109, 2,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "pom.xml", //$NON-NLS-1$
                "templates/jpa/jpa_pom_template.xml.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_111_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            111, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "src/main/java", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_113_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            113, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_114_7 = new TagInfo("ws:folder", //$NON-NLS-1$
            114, 7,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "${$groupIDWithFolder}/entity/${$package/@name}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_116_7 = new TagInfo("c:iterate", //$NON-NLS-1$
            116, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_117_7 = new TagInfo("ws:file", //$NON-NLS-1$
            117, 7,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "{$enumeration/@name}.java", //$NON-NLS-1$
                "templates/jpa/src/main/java/enumeration_template.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_120_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            120, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_121_4 = new TagInfo("ws:file", //$NON-NLS-1$
            121, 4,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "{$class/@name}.java", //$NON-NLS-1$
                "templates/jpa/src/main/java/jpa_class_template.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_126_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            126, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "src/main/resources", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_127_5 = new TagInfo("ws:file", //$NON-NLS-1$
            127, 5,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/jpa/src/main/resources/jpa_persistence_template.xml.jet", //$NON-NLS-1$
                "META-INF/persistence.xml", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_129_5 = new TagInfo("ws:file", //$NON-NLS-1$
            129, 5,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/jpa/src/main/resources/abbrevation.properties.jet", //$NON-NLS-1$
                "abbrevations.properties", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_131_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            131, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "src/test/java", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_132_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            132, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_133_7 = new TagInfo("ws:folder", //$NON-NLS-1$
            133, 7,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "${$groupIDWithFolder}/entity/${$package/@name}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_135_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            135, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_142_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            142, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "src/test/resources", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_143_2 = new TagInfo("ws:file", //$NON-NLS-1$
            143, 2,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/jpa/src/test/resources/jndi.properties.jet", //$NON-NLS-1$
                "jndi.properties", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_144_2 = new TagInfo("ws:file", //$NON-NLS-1$
            144, 2,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/jpa/src/main/resources/jpa_persistence_template.xml.jet", //$NON-NLS-1$
                "test-persistence.xml", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_150_1 = new TagInfo("c:if", //$NON-NLS-1$
            150, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$genDAO = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_project_151_1 = new TagInfo("ws:project", //$NON-NLS-1$
            151, 1,
            new String[] {
                "name", //$NON-NLS-1$
                "location", //$NON-NLS-1$
            },
            new String[] {
                "{$projectName}-dao", //$NON-NLS-1$
                "{$location}/{$projectName}-dao", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_152_2 = new TagInfo("c:if", //$NON-NLS-1$
            152, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$genPOMS = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_153_2 = new TagInfo("ws:file", //$NON-NLS-1$
            153, 2,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "pom.xml", //$NON-NLS-1$
                "templates/dao/pom.xml.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_155_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            155, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "src/main/java", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_156_6 = new TagInfo("ws:folder", //$NON-NLS-1$
            156, 6,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "${$groupIDWithFolder}/dao", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_159_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            159, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_160_7 = new TagInfo("c:iterate", //$NON-NLS-1$
            160, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_161_7 = new TagInfo("ws:folder", //$NON-NLS-1$
            161, 7,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "${$groupIDWithFolder}/dao/${$package/@name}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_163_5 = new TagInfo("ws:file", //$NON-NLS-1$
            163, 5,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "{$class/@name}DAO.java", //$NON-NLS-1$
                "templates/dao/src/main/java/dao.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_168_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            168, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "src/main/resources", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_169_5 = new TagInfo("ws:file", //$NON-NLS-1$
            169, 5,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/dao/src/main/resources/META-INF/ejb_jar.xml.jet", //$NON-NLS-1$
                "META-INF/ejb-jar.xml", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_175_1 = new TagInfo("c:if", //$NON-NLS-1$
            175, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$genJAXB = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_project_176_1 = new TagInfo("ws:project", //$NON-NLS-1$
            176, 1,
            new String[] {
                "name", //$NON-NLS-1$
                "location", //$NON-NLS-1$
            },
            new String[] {
                "{$projectName}-types", //$NON-NLS-1$
                "{$location}/{$projectName}-types", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_177_2 = new TagInfo("c:if", //$NON-NLS-1$
            177, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$genPOMS = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_178_2 = new TagInfo("ws:file", //$NON-NLS-1$
            178, 2,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "pom.xml", //$NON-NLS-1$
                "templates/jaxb/pom.xml.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_180_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            180, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "src/main/java", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_181_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            181, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_182_7 = new TagInfo("c:iterate", //$NON-NLS-1$
            182, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_183_7 = new TagInfo("ws:folder", //$NON-NLS-1$
            183, 7,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "${$groupIDWithFolder}/${$package/@name}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_185_5 = new TagInfo("ws:file", //$NON-NLS-1$
            185, 5,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "{$class/@name}.java", //$NON-NLS-1$
                "templates/jaxb/src/main/java/jaxb.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_190_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            190, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "src/main/resources", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_197_1 = new TagInfo("c:if", //$NON-NLS-1$
            197, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$genEJB = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_project_198_1 = new TagInfo("ws:project", //$NON-NLS-1$
            198, 1,
            new String[] {
                "name", //$NON-NLS-1$
                "location", //$NON-NLS-1$
            },
            new String[] {
                "{$projectName}-ejb", //$NON-NLS-1$
                "{$location}/{$projectName}-ejb", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_199_2 = new TagInfo("c:if", //$NON-NLS-1$
            199, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$genPOMS = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_200_2 = new TagInfo("ws:file", //$NON-NLS-1$
            200, 2,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "pom.xml", //$NON-NLS-1$
                "templates/ejb/ejb_pom_template.xml.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_202_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            202, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "src/main/java", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_203_6 = new TagInfo("ws:folder", //$NON-NLS-1$
            203, 6,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "${$groupIDWithFolder}/ejb", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_205_8 = new TagInfo("ws:file", //$NON-NLS-1$
            205, 8,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "GenericService.java", //$NON-NLS-1$
                "templates/ejb/main/ejb_generic_service_interface.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_207_4 = new TagInfo("ws:file", //$NON-NLS-1$
            207, 4,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "GenericServiceLocal.java", //$NON-NLS-1$
                "templates/ejb/main/ejb_generic_service_local.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_209_4 = new TagInfo("ws:file", //$NON-NLS-1$
            209, 4,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "GenericServiceRemote.java", //$NON-NLS-1$
                "templates/ejb/main/ejb_generic_service_remote.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_211_4 = new TagInfo("ws:file", //$NON-NLS-1$
            211, 4,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "GenericServiceBean.java", //$NON-NLS-1$
                "templates/ejb/main/ejb_generic_service_bean.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_214_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            214, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_215_7 = new TagInfo("c:iterate", //$NON-NLS-1$
            215, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_216_7 = new TagInfo("ws:folder", //$NON-NLS-1$
            216, 7,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "${$groupIDWithFolder}/ejb/${$package/@name}/${lower-case($class/@name)}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_218_8 = new TagInfo("ws:file", //$NON-NLS-1$
            218, 8,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "{$class/@name}Service.java", //$NON-NLS-1$
                "templates/ejb/main/ejb_service_template.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_220_5 = new TagInfo("ws:file", //$NON-NLS-1$
            220, 5,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "{$class/@name}ServiceLocal.java", //$NON-NLS-1$
                "templates/ejb/main/ejb_service_local_template.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_222_5 = new TagInfo("ws:file", //$NON-NLS-1$
            222, 5,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "{$class/@name}ServiceRemote.java", //$NON-NLS-1$
                "templates/ejb/main/ejb_service_remote_template.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_224_5 = new TagInfo("ws:file", //$NON-NLS-1$
            224, 5,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "{$class/@name}ServiceBean.java", //$NON-NLS-1$
                "templates/ejb/main/ejb_service_bean_template.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_229_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            229, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "src/main/resources", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_230_4 = new TagInfo("ws:file", //$NON-NLS-1$
            230, 4,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/ejb/main/resources/META-INF/components.xml.jet", //$NON-NLS-1$
                "META-INF/components.xml", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_231_4 = new TagInfo("ws:file", //$NON-NLS-1$
            231, 4,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/ejb/main/resources/META-INF/ejb_jar.xml.jet", //$NON-NLS-1$
                "META-INF/ejb-jar.xml", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_233_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            233, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "src/test/java", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_234_5 = new TagInfo("c:setVariable", //$NON-NLS-1$
            234, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($groupID,'.ejb.')", //$NON-NLS-1$
                "ejbPackage", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_235_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            235, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_236_7 = new TagInfo("c:iterate", //$NON-NLS-1$
            236, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_237_7 = new TagInfo("ws:folder", //$NON-NLS-1$
            237, 7,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "${$groupIDWithFolder}/ejb/${$package/@name}/${lower-case($class/@name)}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_239_4 = new TagInfo("ws:file", //$NON-NLS-1$
            239, 4,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "${$class/@name}ServiceTest.java", //$NON-NLS-1$
                "templates/ejb/test/ejb_embedded_test.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_244_2 = new TagInfo("ws:folder", //$NON-NLS-1$
            244, 2,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "src/test/resources", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_245_3 = new TagInfo("ws:file", //$NON-NLS-1$
            245, 3,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/jpa/src/test/resources/jndi.properties.jet", //$NON-NLS-1$
                "jndi.properties", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_246_3 = new TagInfo("ws:file", //$NON-NLS-1$
            246, 3,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/jpa/src/main/resources/jpa_persistence_template.xml.jet", //$NON-NLS-1$
                "test-persistence.xml", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_252_1 = new TagInfo("c:if", //$NON-NLS-1$
            252, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$genWebapp = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_project_253_1 = new TagInfo("ws:project", //$NON-NLS-1$
            253, 1,
            new String[] {
                "name", //$NON-NLS-1$
                "location", //$NON-NLS-1$
            },
            new String[] {
                "{$projectName}-webapp", //$NON-NLS-1$
                "{$location}/{$projectName}-webapp", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_254_2 = new TagInfo("c:if", //$NON-NLS-1$
            254, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$genPOMS = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_255_2 = new TagInfo("ws:file", //$NON-NLS-1$
            255, 2,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "pom.xml", //$NON-NLS-1$
                "templates/web/webapp_pom_template.xml.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_257_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            257, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "src/main/java", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_258_6 = new TagInfo("ws:folder", //$NON-NLS-1$
            258, 6,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "${$groupIDWithFolder}/public", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_259_6 = new TagInfo("ws:file", //$NON-NLS-1$
            259, 6,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/web/gwt/public/web_css_template.css.jet", //$NON-NLS-1$
                "{$projectName}.css", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_263_7 = new TagInfo("ws:folder", //$NON-NLS-1$
            263, 7,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "${$groupIDWithFolder}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_265_6 = new TagInfo("ws:file", //$NON-NLS-1$
            265, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "{$projectName}.gwt.xml", //$NON-NLS-1$
                "templates/web/gwt/web_gwtxml_template.xml.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_268_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            268, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($groupID,'.client.')", //$NON-NLS-1$
                "webPackage", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_271_6 = new TagInfo("ws:folder", //$NON-NLS-1$
            271, 6,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "${$groupIDWithFolder}/client/rpc", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_272_6 = new TagInfo("ws:file", //$NON-NLS-1$
            272, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "${camelCase($projectName)}Service.java", //$NON-NLS-1$
                "templates/web/gwt/client/rpc/app_service_sync.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_273_6 = new TagInfo("ws:file", //$NON-NLS-1$
            273, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "${camelCase($projectName)}ServiceAsync.java", //$NON-NLS-1$
                "templates/web/gwt/client/rpc/app_service_async.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_277_6 = new TagInfo("ws:folder", //$NON-NLS-1$
            277, 6,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "${$groupIDWithFolder}/server", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_278_6 = new TagInfo("ws:file", //$NON-NLS-1$
            278, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "${camelCase($projectName)}ServiceImpl.java", //$NON-NLS-1$
                "templates/web/gwt/server/app_service_impl.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_279_6 = new TagInfo("ws:file", //$NON-NLS-1$
            279, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "${camelCase($projectName)}Startup.java", //$NON-NLS-1$
                "templates/web/gwt/server/app_startup.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_283_3 = new TagInfo("ws:folder", //$NON-NLS-1$
            283, 3,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "${$groupIDWithFolder}/client/internalization", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_284_3 = new TagInfo("ws:file", //$NON-NLS-1$
            284, 3,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "${camelCase($projectName)}Constants.properties", //$NON-NLS-1$
                "templates/web/gwt/client/internalization/web_gwt_constants.properties.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_285_3 = new TagInfo("ws:file", //$NON-NLS-1$
            285, 3,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "${camelCase($projectName)}Messages.properties", //$NON-NLS-1$
                "templates/web/gwt/client/internalization/web_gwt_messages.properties.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_288_3 = new TagInfo("ws:folder", //$NON-NLS-1$
            288, 3,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "${$groupIDWithFolder}/client", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_290_6 = new TagInfo("ws:file", //$NON-NLS-1$
            290, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "${camelCase($projectName)}Welcome.java", //$NON-NLS-1$
                "templates/web/gwt/client/web_entrypoint_class_template.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_292_6 = new TagInfo("ws:file", //$NON-NLS-1$
            292, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "Entity.java", //$NON-NLS-1$
                "templates/web/gwt/client/web_entity_enum_template.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_294_6 = new TagInfo("ws:file", //$NON-NLS-1$
            294, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "RootLayout.java", //$NON-NLS-1$
                "templates/web/gwt/client/root_layout.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_296_6 = new TagInfo("ws:file", //$NON-NLS-1$
            296, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "RootLayout.ui.xml", //$NON-NLS-1$
                "templates/web/gwt/client/root_layout.ui.xml.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_298_6 = new TagInfo("ws:file", //$NON-NLS-1$
            298, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "Roles.java", //$NON-NLS-1$
                "templates/web/gwt/client/web_roles_enum_template.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_300_6 = new TagInfo("ws:file", //$NON-NLS-1$
            300, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "LoginPanel.java", //$NON-NLS-1$
                "templates/web/gwt/client/web_login_panel_template.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_302_6 = new TagInfo("ws:file", //$NON-NLS-1$
            302, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "CreateUserPanel.java", //$NON-NLS-1$
                "templates/web/gwt/client/web_create_user.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_304_6 = new TagInfo("ws:file", //$NON-NLS-1$
            304, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "StatusPanel.java", //$NON-NLS-1$
                "templates/web/gwt/client/web_status_panel_template.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_306_6 = new TagInfo("ws:file", //$NON-NLS-1$
            306, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "${camelCase($projectName)}RequestFactory.java", //$NON-NLS-1$
                "templates/web/gwt/client/app_request_factory.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_310_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            310, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_311_8 = new TagInfo("c:setVariable", //$NON-NLS-1$
            311, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($webPackage,$package/@name)", //$NON-NLS-1$
                "packageName", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_312_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            312, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_314_7 = new TagInfo("c:setVariable", //$NON-NLS-1$
            314, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_315_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            315, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "parentClass1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_316_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            316, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "parentClass2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_318_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            318, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Generalization", //$NON-NLS-1$
                "generalization", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_320_5 = new TagInfo("c:if", //$NON-NLS-1$
            320, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$generalization/Generalization.child/Class/@xmi.idref = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_321_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            321, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "otherClass", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_322_9 = new TagInfo("c:if", //$NON-NLS-1$
            322, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass/@xmi.id = $generalization/Generalization.parent/Class/@xmi.idref", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_324_9 = new TagInfo("c:setVariable", //$NON-NLS-1$
            324, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass", //$NON-NLS-1$
                "parentClass1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_326_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            326, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Generalization", //$NON-NLS-1$
                "generalization", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_328_10 = new TagInfo("c:if", //$NON-NLS-1$
            328, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$generalization/Generalization.child/Class/@xmi.idref = $parentClass1/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_329_11 = new TagInfo("c:iterate", //$NON-NLS-1$
            329, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "otherClass", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_330_14 = new TagInfo("c:if", //$NON-NLS-1$
            330, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass/@xmi.id = $generalization/Generalization.parent/Class/@xmi.idref", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_332_14 = new TagInfo("c:setVariable", //$NON-NLS-1$
            332, 14,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass", //$NON-NLS-1$
                "parentClass2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_344_8 = new TagInfo("c:if", //$NON-NLS-1$
            344, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isAbstract = 'false'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_345_8 = new TagInfo("ws:folder", //$NON-NLS-1$
            345, 8,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "${$groupIDWithFolder}/client/${lower-case($package/@name)}/${lower-case($class/@name)}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_347_6 = new TagInfo("ws:file", //$NON-NLS-1$
            347, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "{$class/@name}Service.java", //$NON-NLS-1$
                "templates/web/gwt/client/rpc/entity_service_sync.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_349_6 = new TagInfo("ws:file", //$NON-NLS-1$
            349, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "{$class/@name}ServiceAsync.java", //$NON-NLS-1$
                "templates/web/gwt/client/rpc/entity_service_async.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_351_6 = new TagInfo("ws:file", //$NON-NLS-1$
            351, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "{$class/@name}Proxy.java", //$NON-NLS-1$
                "templates/web/gwt/client/rf/entity_proxy.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_353_6 = new TagInfo("ws:file", //$NON-NLS-1$
            353, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "{$class/@name}Request.java", //$NON-NLS-1$
                "templates/web/gwt/client/rf/entity_request.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_356_6 = new TagInfo("ws:file", //$NON-NLS-1$
            356, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "Create{$class/@name}Panely.java", //$NON-NLS-1$
                "templates/web/gwt/client/entity/create_panely.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_358_6 = new TagInfo("ws:file", //$NON-NLS-1$
            358, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "${$class/@name}SearchPanelGeneric.java", //$NON-NLS-1$
                "templates/web/gwt/client/entity/web_search_generic_panel_template.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_361_6 = new TagInfo("ws:file", //$NON-NLS-1$
            361, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "Read${$class/@name}Panely.java", //$NON-NLS-1$
                "templates/web/gwt/client/entity/read_panely.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_364_6 = new TagInfo("ws:file", //$NON-NLS-1$
            364, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "Update${$class/@name}Panely.java", //$NON-NLS-1$
                "templates/web/gwt/client/entity/update_panely.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_366_6 = new TagInfo("ws:file", //$NON-NLS-1$
            366, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "${$class/@name}SideBar.java", //$NON-NLS-1$
                "templates/web/gwt/client/entity/web_side_panel_template.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_368_6 = new TagInfo("ws:file", //$NON-NLS-1$
            368, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "${$class/@name}OptionsPanel.java", //$NON-NLS-1$
                "templates/web/gwt/client/entity/web_option_panel_template.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_370_6 = new TagInfo("ws:file", //$NON-NLS-1$
            370, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "Select${$class/@name}Panely.java", //$NON-NLS-1$
                "templates/web/gwt/client/entity/select_panely.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_373_7 = new TagInfo("c:setVariable", //$NON-NLS-1$
            373, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "isParent", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_374_7 = new TagInfo("c:iterate", //$NON-NLS-1$
            374, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Generalization", //$NON-NLS-1$
                "generalization", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_375_8 = new TagInfo("c:if", //$NON-NLS-1$
            375, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$generalization/Generalization.parent/Class/@xmi.idref = $class/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_377_8 = new TagInfo("c:setVariable", //$NON-NLS-1$
            377, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@name", //$NON-NLS-1$
                "isParent", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_381_11 = new TagInfo("c:if", //$NON-NLS-1$
            381, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$isParent = $class/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_384_12 = new TagInfo("ws:file", //$NON-NLS-1$
            384, 12,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "TreeAbstract${$class/@name}Panely.java", //$NON-NLS-1$
                "templates/web/gwt/client/entity/tree_panel_abstract.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_387_8 = new TagInfo("ws:file", //$NON-NLS-1$
            387, 8,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "ReadAll{$class/@name}sPanely.java", //$NON-NLS-1$
                "templates/web/gwt/client/entity/read_all_abstract.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_390_7 = new TagInfo("c:if", //$NON-NLS-1$
            390, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$isParent = $class/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_393_12 = new TagInfo("ws:file", //$NON-NLS-1$
            393, 12,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "Tree${$class/@name}Panely.java", //$NON-NLS-1$
                "templates/web/gwt/client/entity/tree_panely.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_396_8 = new TagInfo("ws:file", //$NON-NLS-1$
            396, 8,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "ReadAll{$class/@name}sPanely.java", //$NON-NLS-1$
                "templates/web/gwt/client/entity/read_all_panel.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_401_7 = new TagInfo("ws:folder", //$NON-NLS-1$
            401, 7,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "${$groupIDWithFolder}/server", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_402_8 = new TagInfo("ws:file", //$NON-NLS-1$
            402, 8,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "${$class/@name}ServiceImpl.java", //$NON-NLS-1$
                "templates/web/gwt/server/entity_service_impl.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_405_7 = new TagInfo("ws:folder", //$NON-NLS-1$
            405, 7,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "${$groupIDWithFolder}/server/rf", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_407_8 = new TagInfo("ws:file", //$NON-NLS-1$
            407, 8,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "${$class/@name}GWTDao.java", //$NON-NLS-1$
                "templates/web/gwt/server/entity_gwt_dao.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_409_8 = new TagInfo("ws:file", //$NON-NLS-1$
            409, 8,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "GenericEntityLocator.java", //$NON-NLS-1$
                "templates/web/gwt/server/rf/generic_entity_locator.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_415_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            415, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "src/main/resources", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_416_6 = new TagInfo("ws:file", //$NON-NLS-1$
            416, 6,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/web/webapp_appxml_template.properties.jet", //$NON-NLS-1$
                "{$projectName}.properties", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_417_6 = new TagInfo("ws:file", //$NON-NLS-1$
            417, 6,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/web/seam.properties.jet", //$NON-NLS-1$
                "seam.properties", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_419_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            419, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "src/main/webapp", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_421_5 = new TagInfo("ws:file", //$NON-NLS-1$
            421, 5,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/web/webapp/web_html_template.html.jet", //$NON-NLS-1$
                "{$projectName}.html", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_copyFile_422_5 = new TagInfo("ws:copyFile", //$NON-NLS-1$
            422, 5,
            new String[] {
                "src", //$NON-NLS-1$
                "target", //$NON-NLS-1$
            },
            new String[] {
                "templates/web/gwt/public/images/logo.gif", //$NON-NLS-1$
                "images/logo.gif", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_423_7 = new TagInfo("ws:folder", //$NON-NLS-1$
            423, 7,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "WEB-INF", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_424_8 = new TagInfo("ws:file", //$NON-NLS-1$
            424, 8,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/web/webapp/WEB-INF/webapp_webxml_template.xml.jet", //$NON-NLS-1$
                "web.xml", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_426_8 = new TagInfo("ws:file", //$NON-NLS-1$
            426, 8,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/web/webapp/WEB-INF/webapp_components.xml.jet", //$NON-NLS-1$
                "components.xml", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_430_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            430, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "src/test/java", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_432_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            432, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "{$groupIDWithFolder}/server", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_433_5 = new TagInfo("ws:file", //$NON-NLS-1$
            433, 5,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "ServerTest.java", //$NON-NLS-1$
                "templates/web/test/gwt/server/web_server_impl_test.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_436_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            436, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "src/test/resources", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_copyFile_438_5 = new TagInfo("ws:copyFile", //$NON-NLS-1$
            438, 5,
            new String[] {
                "src", //$NON-NLS-1$
                "target", //$NON-NLS-1$
            },
            new String[] {
                "templates/web/gwt/seamgwt2/GWT2Service.java", //$NON-NLS-1$
                "src/main/java/seamgwt2/GWT2Service.java", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_copyFile_439_5 = new TagInfo("ws:copyFile", //$NON-NLS-1$
            439, 5,
            new String[] {
                "src", //$NON-NLS-1$
                "target", //$NON-NLS-1$
            },
            new String[] {
                "templates/web/gwt/seamgwt2/GWTService.java", //$NON-NLS-1$
                "src/main/java/seamgwt2/GWTService.java", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_copyFile_440_5 = new TagInfo("ws:copyFile", //$NON-NLS-1$
            440, 5,
            new String[] {
                "src", //$NON-NLS-1$
                "target", //$NON-NLS-1$
            },
            new String[] {
                "templates/web/gwt/seamgwt2/GWTToSeamAdapter.java", //$NON-NLS-1$
                "src/main/java/seamgwt2/GWTToSeamAdapter.java", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_copyFile_441_5 = new TagInfo("ws:copyFile", //$NON-NLS-1$
            441, 5,
            new String[] {
                "src", //$NON-NLS-1$
                "target", //$NON-NLS-1$
            },
            new String[] {
                "templates/web/gwt/seamgwt2/SeamRPC.java", //$NON-NLS-1$
                "src/main/java/seamgwt2/SeamRPC.java", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_copyFile_442_5 = new TagInfo("ws:copyFile", //$NON-NLS-1$
            442, 5,
            new String[] {
                "src", //$NON-NLS-1$
                "target", //$NON-NLS-1$
            },
            new String[] {
                "templates/web/gwt/seamgwt2/SeamRPCRequest.java", //$NON-NLS-1$
                "src/main/java/seamgwt2/SeamRPCRequest.java", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_447_1 = new TagInfo("c:if", //$NON-NLS-1$
            447, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$genRest = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_project_448_1 = new TagInfo("ws:project", //$NON-NLS-1$
            448, 1,
            new String[] {
                "name", //$NON-NLS-1$
                "location", //$NON-NLS-1$
            },
            new String[] {
                "{$projectName}-jrs", //$NON-NLS-1$
                "{$location}/{$projectName}-jrs", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_449_2 = new TagInfo("c:if", //$NON-NLS-1$
            449, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$genPOMS = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_450_2 = new TagInfo("ws:file", //$NON-NLS-1$
            450, 2,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "pom.xml", //$NON-NLS-1$
                "templates/rest/rest_pom_template.xml.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_452_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            452, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "src/main/java", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_453_4 = new TagInfo("ws:folder", //$NON-NLS-1$
            453, 4,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "${$groupIDWithFolder}/rest", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_455_4 = new TagInfo("ws:file", //$NON-NLS-1$
            455, 4,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "${camelCase($projectName)}Resource.java", //$NON-NLS-1$
                "templates/rest/src/main/java/rest_manage.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_458_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            458, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_459_7 = new TagInfo("c:iterate", //$NON-NLS-1$
            459, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_461_7 = new TagInfo("c:setVariable", //$NON-NLS-1$
            461, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_462_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            462, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "parentClass1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_463_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            463, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "parentClass2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_465_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            465, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Generalization", //$NON-NLS-1$
                "generalization", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_467_5 = new TagInfo("c:if", //$NON-NLS-1$
            467, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$generalization/Generalization.child/Class/@xmi.idref = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_468_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            468, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "otherClass", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_469_9 = new TagInfo("c:if", //$NON-NLS-1$
            469, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass/@xmi.id = $generalization/Generalization.parent/Class/@xmi.idref", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_471_9 = new TagInfo("c:setVariable", //$NON-NLS-1$
            471, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass", //$NON-NLS-1$
                "parentClass1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_473_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            473, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Generalization", //$NON-NLS-1$
                "generalization", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_475_10 = new TagInfo("c:if", //$NON-NLS-1$
            475, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$generalization/Generalization.child/Class/@xmi.idref = $parentClass1/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_476_11 = new TagInfo("c:iterate", //$NON-NLS-1$
            476, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "otherClass", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_477_14 = new TagInfo("c:if", //$NON-NLS-1$
            477, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass/@xmi.id = $generalization/Generalization.parent/Class/@xmi.idref", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_479_14 = new TagInfo("c:setVariable", //$NON-NLS-1$
            479, 14,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass", //$NON-NLS-1$
                "parentClass2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_489_4 = new TagInfo("ws:folder", //$NON-NLS-1$
            489, 4,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "${$groupIDWithFolder}/rest/${$package/@name}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_491_4 = new TagInfo("ws:file", //$NON-NLS-1$
            491, 4,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "{$class/@name}Resource.java", //$NON-NLS-1$
                "templates/rest/src/main/java/entity/entity_rest_service.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_496_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            496, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "src/main/resources", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_497_5 = new TagInfo("ws:file", //$NON-NLS-1$
            497, 5,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/rest/src/main/resources/META-INF/components.xml.jet", //$NON-NLS-1$
                "META-INF/components.xml", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_498_6 = new TagInfo("ws:file", //$NON-NLS-1$
            498, 6,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/web/seam.properties.jet", //$NON-NLS-1$
                "seam.properties", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_503_1 = new TagInfo("c:if", //$NON-NLS-1$
            503, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$genAndroid = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_project_504_1 = new TagInfo("ws:project", //$NON-NLS-1$
            504, 1,
            new String[] {
                "name", //$NON-NLS-1$
                "location", //$NON-NLS-1$
            },
            new String[] {
                "{$projectName}-android", //$NON-NLS-1$
                "{$location}/{$projectName}-android", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_505_2 = new TagInfo("c:if", //$NON-NLS-1$
            505, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$genPOMS = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_506_2 = new TagInfo("ws:file", //$NON-NLS-1$
            506, 2,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "pom.xml", //$NON-NLS-1$
                "templates/androidy/pom.xml.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_508_2 = new TagInfo("ws:file", //$NON-NLS-1$
            508, 2,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "AndroidManifest.xml", //$NON-NLS-1$
                "templates/androidy/android_manifest.xml.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_509_2 = new TagInfo("ws:file", //$NON-NLS-1$
            509, 2,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "default.properties", //$NON-NLS-1$
                "templates/androidy/project.properties.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_510_2 = new TagInfo("ws:folder", //$NON-NLS-1$
            510, 2,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "src/main/java", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_511_3 = new TagInfo("ws:folder", //$NON-NLS-1$
            511, 3,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "${$groupIDWithFolder}/android", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_512_4 = new TagInfo("ws:file", //$NON-NLS-1$
            512, 4,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "${camelCase($projectName)}Welcome.java", //$NON-NLS-1$
                "templates/androidy/src/main/java/Welcome.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_516_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            516, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_517_7 = new TagInfo("c:iterate", //$NON-NLS-1$
            517, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_518_13 = new TagInfo("c:setVariable", //$NON-NLS-1$
            518, 13,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_519_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            519, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "parentClass1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_520_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            520, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "parentClass2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_522_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            522, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Generalization", //$NON-NLS-1$
                "generalization", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_524_5 = new TagInfo("c:if", //$NON-NLS-1$
            524, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$generalization/Generalization.child/Class/@xmi.idref = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_525_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            525, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "otherClass", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_526_9 = new TagInfo("c:if", //$NON-NLS-1$
            526, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass/@xmi.id = $generalization/Generalization.parent/Class/@xmi.idref", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_528_9 = new TagInfo("c:setVariable", //$NON-NLS-1$
            528, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass", //$NON-NLS-1$
                "parentClass1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_530_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            530, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Generalization", //$NON-NLS-1$
                "generalization", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_532_10 = new TagInfo("c:if", //$NON-NLS-1$
            532, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$generalization/Generalization.child/Class/@xmi.idref = $parentClass1/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_533_11 = new TagInfo("c:iterate", //$NON-NLS-1$
            533, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "otherClass", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_534_14 = new TagInfo("c:if", //$NON-NLS-1$
            534, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass/@xmi.id = $generalization/Generalization.parent/Class/@xmi.idref", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_536_14 = new TagInfo("c:setVariable", //$NON-NLS-1$
            536, 14,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass", //$NON-NLS-1$
                "parentClass2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_547_4 = new TagInfo("ws:folder", //$NON-NLS-1$
            547, 4,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "src/main/java", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_548_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            548, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "${$groupIDWithFolder}/android/${$package/@name}/${lower-case($class/@name)}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_549_5 = new TagInfo("ws:file", //$NON-NLS-1$
            549, 5,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "ReadAll${$class/@name}s.java", //$NON-NLS-1$
                "templates/androidy/src/main/java/entity/read_all.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_550_5 = new TagInfo("ws:file", //$NON-NLS-1$
            550, 5,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "Create${$class/@name}.java", //$NON-NLS-1$
                "templates/androidy/src/main/java/entity/create_entity.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_551_5 = new TagInfo("ws:file", //$NON-NLS-1$
            551, 5,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "Read${$class/@name}.java", //$NON-NLS-1$
                "templates/androidy/src/main/java/entity/read_entity.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_552_5 = new TagInfo("ws:file", //$NON-NLS-1$
            552, 5,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "Update${$class/@name}.java", //$NON-NLS-1$
                "templates/androidy/src/main/java/entity/update_entity.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_556_4 = new TagInfo("ws:folder", //$NON-NLS-1$
            556, 4,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "res/layout", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_558_4 = new TagInfo("ws:file", //$NON-NLS-1$
            558, 4,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/androidy/res/layout/entity_create.xml.jet", //$NON-NLS-1$
                "${lower-case($class/@name)}_create.xml", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_560_4 = new TagInfo("ws:file", //$NON-NLS-1$
            560, 4,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/androidy/res/layout/entity_read.xml.jet", //$NON-NLS-1$
                "${lower-case($class/@name)}_read.xml", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_563_4 = new TagInfo("ws:folder", //$NON-NLS-1$
            563, 4,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "res/menu", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_565_4 = new TagInfo("ws:file", //$NON-NLS-1$
            565, 4,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/androidy/res/menu/entity_menu.xml.jet", //$NON-NLS-1$
                "${lower-case($class/@name)}_menu.xml", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_569_2 = new TagInfo("ws:folder", //$NON-NLS-1$
            569, 2,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "res/layout", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_571_2 = new TagInfo("ws:file", //$NON-NLS-1$
            571, 2,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/androidy/res/layout/list_item.xml.jet", //$NON-NLS-1$
                "list_item.xml", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_572_2 = new TagInfo("ws:file", //$NON-NLS-1$
            572, 2,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/androidy/res/layout/entity_readall.xml.jet", //$NON-NLS-1$
                "entity_readall.xml", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_573_2 = new TagInfo("ws:file", //$NON-NLS-1$
            573, 2,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/androidy/res/layout/readall_list.xml.jet", //$NON-NLS-1$
                "readall_list.xml", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_574_2 = new TagInfo("ws:file", //$NON-NLS-1$
            574, 2,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/androidy/res/layout/app_title_bar.xml.jet", //$NON-NLS-1$
                "${lower-case($projectName)}_title_bar.xml", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_576_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            576, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "res/menu", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_578_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            578, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "res/values", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_579_5 = new TagInfo("ws:file", //$NON-NLS-1$
            579, 5,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/androidy/res/values/strings.xml.jet", //$NON-NLS-1$
                "strings.xml", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_581_6 = new TagInfo("ws:folder", //$NON-NLS-1$
            581, 6,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "res/drawable-hdpi", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_583_6 = new TagInfo("ws:folder", //$NON-NLS-1$
            583, 6,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "res/drawable-ldpi", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_585_6 = new TagInfo("ws:folder", //$NON-NLS-1$
            585, 6,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "res/drawable-mdpi", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_590_1 = new TagInfo("c:if", //$NON-NLS-1$
            590, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$genIOS = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_project_591_1 = new TagInfo("ws:project", //$NON-NLS-1$
            591, 1,
            new String[] {
                "name", //$NON-NLS-1$
                "location", //$NON-NLS-1$
            },
            new String[] {
                "{$projectName}-ios", //$NON-NLS-1$
                "{$location}/{$projectName}-ios", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_593_1 = new TagInfo("ws:folder", //$NON-NLS-1$
            593, 1,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "main", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_594_2 = new TagInfo("ws:file", //$NON-NLS-1$
            594, 2,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "RootViewController.h", //$NON-NLS-1$
                "templates/ios/main/root_view_controller.h.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_595_2 = new TagInfo("ws:file", //$NON-NLS-1$
            595, 2,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "RootViewController.m", //$NON-NLS-1$
                "templates/ios/main/root_view_controller.m.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_596_2 = new TagInfo("ws:file", //$NON-NLS-1$
            596, 2,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "HttpUtils.h", //$NON-NLS-1$
                "templates/ios/main/HttpUtils.h.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_597_2 = new TagInfo("ws:file", //$NON-NLS-1$
            597, 2,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "HttpUtils.m", //$NON-NLS-1$
                "templates/ios/main/HttpUtils.m.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_600_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            600, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_601_7 = new TagInfo("c:iterate", //$NON-NLS-1$
            601, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_602_13 = new TagInfo("c:setVariable", //$NON-NLS-1$
            602, 13,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_603_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            603, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "parentClass1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_604_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            604, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "parentClass2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_606_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            606, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Generalization", //$NON-NLS-1$
                "generalization", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_608_5 = new TagInfo("c:if", //$NON-NLS-1$
            608, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$generalization/Generalization.child/Class/@xmi.idref = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_609_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            609, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "otherClass", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_610_9 = new TagInfo("c:if", //$NON-NLS-1$
            610, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass/@xmi.id = $generalization/Generalization.parent/Class/@xmi.idref", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_612_9 = new TagInfo("c:setVariable", //$NON-NLS-1$
            612, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass", //$NON-NLS-1$
                "parentClass1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_614_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            614, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Generalization", //$NON-NLS-1$
                "generalization", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_616_10 = new TagInfo("c:if", //$NON-NLS-1$
            616, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$generalization/Generalization.child/Class/@xmi.idref = $parentClass1/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_617_11 = new TagInfo("c:iterate", //$NON-NLS-1$
            617, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "otherClass", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_618_14 = new TagInfo("c:if", //$NON-NLS-1$
            618, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass/@xmi.id = $generalization/Generalization.parent/Class/@xmi.idref", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_620_14 = new TagInfo("c:setVariable", //$NON-NLS-1$
            620, 14,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass", //$NON-NLS-1$
                "parentClass2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_631_4 = new TagInfo("ws:folder", //$NON-NLS-1$
            631, 4,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "transfer-objects", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_632_5 = new TagInfo("ws:file", //$NON-NLS-1$
            632, 5,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "${$groupIDWithUnderScore}_entity_${lower-case($package/@name)}_${$class/@name}.h", //$NON-NLS-1$
                "templates/ios/transfer-objects/entity_interface.h.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_633_5 = new TagInfo("ws:file", //$NON-NLS-1$
            633, 5,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "${$groupIDWithUnderScore}_entity_${lower-case($package/@name)}_${$class/@name}.m", //$NON-NLS-1$
                "templates/ios/transfer-objects/entity_implementation.m.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_636_4 = new TagInfo("ws:folder", //$NON-NLS-1$
            636, 4,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "${lower-case($package/@name)}-${lower-case($class/@name)}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_637_5 = new TagInfo("ws:file", //$NON-NLS-1$
            637, 5,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "ReadAll${$class/@name}sViewController.h", //$NON-NLS-1$
                "templates/ios/entity/read_all_entity_controller.h.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_638_5 = new TagInfo("ws:file", //$NON-NLS-1$
            638, 5,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "ReadAll${$class/@name}sViewController.m", //$NON-NLS-1$
                "templates/ios/entity/read_all_entity_controller.m.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_639_5 = new TagInfo("ws:file", //$NON-NLS-1$
            639, 5,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "Read${$class/@name}ViewController.h", //$NON-NLS-1$
                "templates/ios/entity/read_entity_controller.h.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_640_5 = new TagInfo("ws:file", //$NON-NLS-1$
            640, 5,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "Read${$class/@name}ViewController.m", //$NON-NLS-1$
                "templates/ios/entity/read_entity_controller.m.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_641_5 = new TagInfo("ws:file", //$NON-NLS-1$
            641, 5,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "Create${$class/@name}ViewController.h", //$NON-NLS-1$
                "templates/ios/entity/create_entity_controller.h.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_642_5 = new TagInfo("ws:file", //$NON-NLS-1$
            642, 5,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "Create${$class/@name}ViewController.m", //$NON-NLS-1$
                "templates/ios/entity/create_entity_controller.m.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_650_1 = new TagInfo("c:if", //$NON-NLS-1$
            650, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$genTest = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_project_651_1 = new TagInfo("ws:project", //$NON-NLS-1$
            651, 1,
            new String[] {
                "name", //$NON-NLS-1$
                "location", //$NON-NLS-1$
            },
            new String[] {
                "{$projectName}-test", //$NON-NLS-1$
                "{$location}/{$projectName}-test", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_652_2 = new TagInfo("ws:file", //$NON-NLS-1$
            652, 2,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "pom.xml", //$NON-NLS-1$
                "templates/test/test_pom.xml.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_654_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            654, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_655_7 = new TagInfo("c:iterate", //$NON-NLS-1$
            655, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_656_13 = new TagInfo("c:setVariable", //$NON-NLS-1$
            656, 13,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_657_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            657, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "parentClass1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_658_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            658, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "parentClass2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_660_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            660, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Generalization", //$NON-NLS-1$
                "generalization", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_662_5 = new TagInfo("c:if", //$NON-NLS-1$
            662, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$generalization/Generalization.child/Class/@xmi.idref = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_663_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            663, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "otherClass", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_664_9 = new TagInfo("c:if", //$NON-NLS-1$
            664, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass/@xmi.id = $generalization/Generalization.parent/Class/@xmi.idref", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_666_9 = new TagInfo("c:setVariable", //$NON-NLS-1$
            666, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass", //$NON-NLS-1$
                "parentClass1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_668_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            668, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Generalization", //$NON-NLS-1$
                "generalization", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_670_10 = new TagInfo("c:if", //$NON-NLS-1$
            670, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$generalization/Generalization.child/Class/@xmi.idref = $parentClass1/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_671_11 = new TagInfo("c:iterate", //$NON-NLS-1$
            671, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "otherClass", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_672_14 = new TagInfo("c:if", //$NON-NLS-1$
            672, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass/@xmi.id = $generalization/Generalization.parent/Class/@xmi.idref", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_674_14 = new TagInfo("c:setVariable", //$NON-NLS-1$
            674, 14,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass", //$NON-NLS-1$
                "parentClass2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_686_4 = new TagInfo("ws:folder", //$NON-NLS-1$
            686, 4,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "src/test/java", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_687_5 = new TagInfo("ws:folder", //$NON-NLS-1$
            687, 5,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "${$groupIDWithFolder}/test/${$package/@name}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_688_5 = new TagInfo("c:if", //$NON-NLS-1$
            688, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isDependent = 'false'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_690_6 = new TagInfo("ws:file", //$NON-NLS-1$
            690, 6,
            new String[] {
                "path", //$NON-NLS-1$
                "template", //$NON-NLS-1$
            },
            new String[] {
                "{$class/@name}Test.java", //$NON-NLS-1$
                "templates/test/test/test_entity_webdriver_class.java.jet", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_folder_694_8 = new TagInfo("ws:folder", //$NON-NLS-1$
            694, 8,
            new String[] {
                "path", //$NON-NLS-1$
            },
            new String[] {
                "src/test/resources", //$NON-NLS-1$
            } );
    private static final TagInfo _td_ws_file_695_9 = new TagInfo("ws:file", //$NON-NLS-1$
            695, 9,
            new String[] {
                "template", //$NON-NLS-1$
                "path", //$NON-NLS-1$
            },
            new String[] {
                "templates/test/test/resources/env.properties.jet", //$NON-NLS-1$
                "env.properties", //$NON-NLS-1$
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        RuntimeTagElement _jettag_c_if_2_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_2_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_2_1.setRuntimeParent(null);
        _jettag_c_if_2_1.setTagInfo(_td_c_if_2_1);
        _jettag_c_if_2_1.doStart(context, out);
        while (_jettag_c_if_2_1.okToProcessBody()) {
            out.write("    ");  //$NON-NLS-1$        
            RuntimeTagElement _jettag_ws_file_3_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_3_5); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_ws_file_3_5.setRuntimeParent(_jettag_c_if_2_1);
            _jettag_ws_file_3_5.setTagInfo(_td_ws_file_3_5);
            _jettag_ws_file_3_5.doStart(context, out);
            _jettag_ws_file_3_5.doEnd();
            out.write(NL);         
            _jettag_c_if_2_1.handleBodyContent(out);
        }
        _jettag_c_if_2_1.doEnd();
        //Set Global varibles like projectId,groupId,version...
        //project properties
        RuntimeTagElement _jettag_c_setVariable_7_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_7_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_7_1.setRuntimeParent(null);
        _jettag_c_setVariable_7_1.setTagInfo(_td_c_setVariable_7_1);
        _jettag_c_setVariable_7_1.doStart(context, out);
        _jettag_c_setVariable_7_1.doEnd();
        // TODO get these from model and init the variables 
        RuntimeTagElement _jettag_c_setVariable_9_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_9_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_9_1.setRuntimeParent(null);
        _jettag_c_setVariable_9_1.setTagInfo(_td_c_setVariable_9_1);
        _jettag_c_setVariable_9_1.doStart(context, out);
        _jettag_c_setVariable_9_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_10_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_10_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_10_1.setRuntimeParent(null);
        _jettag_c_setVariable_10_1.setTagInfo(_td_c_setVariable_10_1);
        _jettag_c_setVariable_10_1.doStart(context, out);
        _jettag_c_setVariable_10_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_11_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_11_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_11_1.setRuntimeParent(null);
        _jettag_c_setVariable_11_1.setTagInfo(_td_c_setVariable_11_1);
        _jettag_c_setVariable_11_1.doStart(context, out);
        _jettag_c_setVariable_11_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_12_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_12_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_12_1.setRuntimeParent(null);
        _jettag_c_setVariable_12_1.setTagInfo(_td_c_setVariable_12_1);
        _jettag_c_setVariable_12_1.doStart(context, out);
        _jettag_c_setVariable_12_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_13_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_13_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_13_1.setRuntimeParent(null);
        _jettag_c_setVariable_13_1.setTagInfo(_td_c_setVariable_13_1);
        _jettag_c_setVariable_13_1.doStart(context, out);
        _jettag_c_setVariable_13_1.doEnd();
        //features
        RuntimeTagElement _jettag_c_setVariable_15_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_15_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_15_1.setRuntimeParent(null);
        _jettag_c_setVariable_15_1.setTagInfo(_td_c_setVariable_15_1);
        _jettag_c_setVariable_15_1.doStart(context, out);
        _jettag_c_setVariable_15_1.doEnd();
        // set true to add jaxb annotations to jpa classes
        RuntimeTagElement _jettag_c_setVariable_17_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_17_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_17_1.setRuntimeParent(null);
        _jettag_c_setVariable_17_1.setTagInfo(_td_c_setVariable_17_1);
        _jettag_c_setVariable_17_1.doStart(context, out);
        _jettag_c_setVariable_17_1.doEnd();
        //code generation properties
        RuntimeTagElement _jettag_c_setVariable_19_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_19_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_19_1.setRuntimeParent(null);
        _jettag_c_setVariable_19_1.setTagInfo(_td_c_setVariable_19_1);
        _jettag_c_setVariable_19_1.doStart(context, out);
        _jettag_c_setVariable_19_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_20_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_20_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_20_1.setRuntimeParent(null);
        _jettag_c_setVariable_20_1.setTagInfo(_td_c_setVariable_20_1);
        _jettag_c_setVariable_20_1.doStart(context, out);
        _jettag_c_setVariable_20_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_21_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_21_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_21_1.setRuntimeParent(null);
        _jettag_c_setVariable_21_1.setTagInfo(_td_c_setVariable_21_1);
        _jettag_c_setVariable_21_1.doStart(context, out);
        _jettag_c_setVariable_21_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_22_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_22_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_22_1.setRuntimeParent(null);
        _jettag_c_setVariable_22_1.setTagInfo(_td_c_setVariable_22_1);
        _jettag_c_setVariable_22_1.doStart(context, out);
        _jettag_c_setVariable_22_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_23_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_23_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_23_1.setRuntimeParent(null);
        _jettag_c_setVariable_23_1.setTagInfo(_td_c_setVariable_23_1);
        _jettag_c_setVariable_23_1.doStart(context, out);
        _jettag_c_setVariable_23_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_24_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_24_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_24_1.setRuntimeParent(null);
        _jettag_c_setVariable_24_1.setTagInfo(_td_c_setVariable_24_1);
        _jettag_c_setVariable_24_1.doStart(context, out);
        _jettag_c_setVariable_24_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_25_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_25_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_25_1.setRuntimeParent(null);
        _jettag_c_setVariable_25_1.setTagInfo(_td_c_setVariable_25_1);
        _jettag_c_setVariable_25_1.doStart(context, out);
        _jettag_c_setVariable_25_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_26_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_26_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_26_1.setRuntimeParent(null);
        _jettag_c_setVariable_26_1.setTagInfo(_td_c_setVariable_26_1);
        _jettag_c_setVariable_26_1.doStart(context, out);
        _jettag_c_setVariable_26_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_27_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_27_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_27_1.setRuntimeParent(null);
        _jettag_c_setVariable_27_1.setTagInfo(_td_c_setVariable_27_1);
        _jettag_c_setVariable_27_1.doStart(context, out);
        _jettag_c_setVariable_27_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_28_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_28_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_28_1.setRuntimeParent(null);
        _jettag_c_setVariable_28_1.setTagInfo(_td_c_setVariable_28_1);
        _jettag_c_setVariable_28_1.doStart(context, out);
        _jettag_c_setVariable_28_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_29_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_29_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_29_1.setRuntimeParent(null);
        _jettag_c_setVariable_29_1.setTagInfo(_td_c_setVariable_29_1);
        _jettag_c_setVariable_29_1.doStart(context, out);
        _jettag_c_setVariable_29_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_30_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_30_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_30_1.setRuntimeParent(null);
        _jettag_c_setVariable_30_1.setTagInfo(_td_c_setVariable_30_1);
        _jettag_c_setVariable_30_1.doStart(context, out);
        _jettag_c_setVariable_30_1.doEnd();
        //versions 
        RuntimeTagElement _jettag_c_setVariable_32_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_32_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_32_1.setRuntimeParent(null);
        _jettag_c_setVariable_32_1.setTagInfo(_td_c_setVariable_32_1);
        _jettag_c_setVariable_32_1.doStart(context, out);
        _jettag_c_setVariable_32_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_33_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_33_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_33_1.setRuntimeParent(null);
        _jettag_c_setVariable_33_1.setTagInfo(_td_c_setVariable_33_1);
        _jettag_c_setVariable_33_1.doStart(context, out);
        _jettag_c_setVariable_33_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_34_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_34_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_34_1.setRuntimeParent(null);
        _jettag_c_setVariable_34_1.setTagInfo(_td_c_setVariable_34_1);
        _jettag_c_setVariable_34_1.doStart(context, out);
        _jettag_c_setVariable_34_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_35_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_35_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_35_1.setRuntimeParent(null);
        _jettag_c_setVariable_35_1.setTagInfo(_td_c_setVariable_35_1);
        _jettag_c_setVariable_35_1.doStart(context, out);
        _jettag_c_setVariable_35_1.doEnd();
        // TODO removed use yalamanchili.version instead else override
        RuntimeTagElement _jettag_c_setVariable_37_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_37_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_37_1.setRuntimeParent(null);
        _jettag_c_setVariable_37_1.setTagInfo(_td_c_setVariable_37_1);
        _jettag_c_setVariable_37_1.doStart(context, out);
        _jettag_c_setVariable_37_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_38_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_38_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_38_1.setRuntimeParent(null);
        _jettag_c_setVariable_38_1.setTagInfo(_td_c_setVariable_38_1);
        _jettag_c_setVariable_38_1.doStart(context, out);
        _jettag_c_setVariable_38_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_39_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_39_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_39_1.setRuntimeParent(null);
        _jettag_c_setVariable_39_1.setTagInfo(_td_c_setVariable_39_1);
        _jettag_c_setVariable_39_1.doStart(context, out);
        _jettag_c_setVariable_39_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_40_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_40_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_40_1.setRuntimeParent(null);
        _jettag_c_setVariable_40_1.setTagInfo(_td_c_setVariable_40_1);
        _jettag_c_setVariable_40_1.doStart(context, out);
        _jettag_c_setVariable_40_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_41_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_41_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_41_1.setRuntimeParent(null);
        _jettag_c_setVariable_41_1.setTagInfo(_td_c_setVariable_41_1);
        _jettag_c_setVariable_41_1.doStart(context, out);
        _jettag_c_setVariable_41_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_42_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_42_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_42_1.setRuntimeParent(null);
        _jettag_c_setVariable_42_1.setTagInfo(_td_c_setVariable_42_1);
        _jettag_c_setVariable_42_1.doStart(context, out);
        _jettag_c_setVariable_42_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_43_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_43_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_43_1.setRuntimeParent(null);
        _jettag_c_setVariable_43_1.setTagInfo(_td_c_setVariable_43_1);
        _jettag_c_setVariable_43_1.doStart(context, out);
        _jettag_c_setVariable_43_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_44_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_44_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_44_1.setRuntimeParent(null);
        _jettag_c_setVariable_44_1.setTagInfo(_td_c_setVariable_44_1);
        _jettag_c_setVariable_44_1.doStart(context, out);
        _jettag_c_setVariable_44_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_45_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_45_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_45_1.setRuntimeParent(null);
        _jettag_c_setVariable_45_1.setTagInfo(_td_c_setVariable_45_1);
        _jettag_c_setVariable_45_1.doStart(context, out);
        _jettag_c_setVariable_45_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_46_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_46_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_46_1.setRuntimeParent(null);
        _jettag_c_setVariable_46_1.setTagInfo(_td_c_setVariable_46_1);
        _jettag_c_setVariable_46_1.doStart(context, out);
        _jettag_c_setVariable_46_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_47_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_47_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_47_1.setRuntimeParent(null);
        _jettag_c_setVariable_47_1.setTagInfo(_td_c_setVariable_47_1);
        _jettag_c_setVariable_47_1.doStart(context, out);
        _jettag_c_setVariable_47_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_48_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_48_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_48_1.setRuntimeParent(null);
        _jettag_c_setVariable_48_1.setTagInfo(_td_c_setVariable_48_1);
        _jettag_c_setVariable_48_1.doStart(context, out);
        _jettag_c_setVariable_48_1.doEnd();
        out.write(NL);         
        RuntimeTagElement _jettag_c_setVariable_50_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_50_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_50_1.setRuntimeParent(null);
        _jettag_c_setVariable_50_1.setTagInfo(_td_c_setVariable_50_1);
        _jettag_c_setVariable_50_1.doStart(context, out);
        _jettag_c_setVariable_50_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_51_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_51_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_51_1.setRuntimeParent(null);
        _jettag_c_setVariable_51_1.setTagInfo(_td_c_setVariable_51_1);
        _jettag_c_setVariable_51_1.doStart(context, out);
        _jettag_c_setVariable_51_1.doEnd();
        RuntimeTagElement _jettag_c_setVariable_52_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_52_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_52_1.setRuntimeParent(null);
        _jettag_c_setVariable_52_1.setTagInfo(_td_c_setVariable_52_1);
        _jettag_c_setVariable_52_1.doStart(context, out);
        _jettag_c_setVariable_52_1.doEnd();
        out.write(NL);         
        //processes the parent classes for all classes for each class up to 2 levels 
        RuntimeTagElement _jettag_c_include_55_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "include", "c:include", _td_c_include_55_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_include_55_1.setRuntimeParent(null);
        _jettag_c_include_55_1.setTagInfo(_td_c_include_55_1);
        _jettag_c_include_55_1.doStart(context, out);
        _jettag_c_include_55_1.doEnd();
        out.write(NL);         
        //processes class dependencies to see if the class is a normal class or a composite child 
        RuntimeTagElement _jettag_c_include_58_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "include", "c:include", _td_c_include_58_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_include_58_1.setRuntimeParent(null);
        _jettag_c_include_58_1.setTagInfo(_td_c_include_58_1);
        _jettag_c_include_58_1.doStart(context, out);
        _jettag_c_include_58_1.doEnd();
        out.write(NL);         
        //process all associations in model 
        RuntimeTagElement _jettag_c_include_61_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "include", "c:include", _td_c_include_61_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_include_61_1.setRuntimeParent(null);
        _jettag_c_include_61_1.setTagInfo(_td_c_include_61_1);
        _jettag_c_include_61_1.doStart(context, out);
        _jettag_c_include_61_1.doEnd();
        out.write(NL);         
        //load and process yalamanchili profiles and stereotypes 
        RuntimeTagElement _jettag_c_include_64_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "include", "c:include", _td_c_include_64_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_include_64_1.setRuntimeParent(null);
        _jettag_c_include_64_1.setTagInfo(_td_c_include_64_1);
        _jettag_c_include_64_1.doStart(context, out);
        _jettag_c_include_64_1.doEnd();
        out.write(NL);         
        //processes the required fields on all attributes 
        RuntimeTagElement _jettag_c_include_67_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "include", "c:include", _td_c_include_67_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_include_67_1.setRuntimeParent(null);
        _jettag_c_include_67_1.setTagInfo(_td_c_include_67_1);
        _jettag_c_include_67_1.doStart(context, out);
        _jettag_c_include_67_1.doEnd();
        out.write(NL);         
        //creates the master project
        RuntimeTagElement _jettag_c_if_70_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_70_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_70_1.setRuntimeParent(null);
        _jettag_c_if_70_1.setTagInfo(_td_c_if_70_1);
        _jettag_c_if_70_1.doStart(context, out);
        while (_jettag_c_if_70_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_if_71_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_71_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_71_1.setRuntimeParent(_jettag_c_if_70_1);
            _jettag_c_if_71_1.setTagInfo(_td_c_if_71_1);
            _jettag_c_if_71_1.doStart(context, out);
            while (_jettag_c_if_71_1.okToProcessBody()) {
                RuntimeTagElement _jettag_ws_project_72_1 = context.getTagFactory().createRuntimeTag(_jetns_ws, "project", "ws:project", _td_ws_project_72_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_project_72_1.setRuntimeParent(_jettag_c_if_71_1);
                _jettag_ws_project_72_1.setTagInfo(_td_ws_project_72_1);
                _jettag_ws_project_72_1.doStart(context, out);
                while (_jettag_ws_project_72_1.okToProcessBody()) {
                    out.write("\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_73_2 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_73_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_73_2.setRuntimeParent(_jettag_ws_project_72_1);
                    _jettag_ws_file_73_2.setTagInfo(_td_ws_file_73_2);
                    _jettag_ws_file_73_2.doStart(context, out);
                    _jettag_ws_file_73_2.doEnd();
                    out.write("  ");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_ws_project_72_1.handleBodyContent(out);
                }
                _jettag_ws_project_72_1.doEnd();
                _jettag_c_if_71_1.handleBodyContent(out);
            }
            _jettag_c_if_71_1.doEnd();
            _jettag_c_if_70_1.handleBodyContent(out);
        }
        _jettag_c_if_70_1.doEnd();
        //creates the APP project
        RuntimeTagElement _jettag_c_if_78_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_78_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_78_1.setRuntimeParent(null);
        _jettag_c_if_78_1.setTagInfo(_td_c_if_78_1);
        _jettag_c_if_78_1.doStart(context, out);
        while (_jettag_c_if_78_1.okToProcessBody()) {
            RuntimeTagElement _jettag_ws_project_79_1 = context.getTagFactory().createRuntimeTag(_jetns_ws, "project", "ws:project", _td_ws_project_79_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_ws_project_79_1.setRuntimeParent(_jettag_c_if_78_1);
            _jettag_ws_project_79_1.setTagInfo(_td_ws_project_79_1);
            _jettag_ws_project_79_1.doStart(context, out);
            while (_jettag_ws_project_79_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_if_80_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_80_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_80_2.setRuntimeParent(_jettag_ws_project_79_1);
                _jettag_c_if_80_2.setTagInfo(_td_c_if_80_2);
                _jettag_c_if_80_2.doStart(context, out);
                while (_jettag_c_if_80_2.okToProcessBody()) {
                    out.write("\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_81_2 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_81_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_81_2.setRuntimeParent(_jettag_c_if_80_2);
                    _jettag_ws_file_81_2.setTagInfo(_td_ws_file_81_2);
                    _jettag_ws_file_81_2.doStart(context, out);
                    _jettag_ws_file_81_2.doEnd();
                    out.write(NL);         
                    _jettag_c_if_80_2.handleBodyContent(out);
                }
                _jettag_c_if_80_2.doEnd();
                RuntimeTagElement _jettag_ws_folder_83_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_83_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_83_5.setRuntimeParent(_jettag_ws_project_79_1);
                _jettag_ws_folder_83_5.setTagInfo(_td_ws_folder_83_5);
                _jettag_ws_folder_83_5.doStart(context, out);
                while (_jettag_ws_folder_83_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_if_84_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_84_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_84_6.setRuntimeParent(_jettag_ws_folder_83_5);
                    _jettag_c_if_84_6.setTagInfo(_td_c_if_84_6);
                    _jettag_c_if_84_6.doStart(context, out);
                    while (_jettag_c_if_84_6.okToProcessBody()) {
                        out.write("\t \t\t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_85_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_85_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_85_5.setRuntimeParent(_jettag_c_if_84_6);
                        _jettag_ws_file_85_5.setTagInfo(_td_ws_file_85_5);
                        _jettag_ws_file_85_5.doStart(context, out);
                        _jettag_ws_file_85_5.doEnd();
                        out.write(NL);         
                        _jettag_c_if_84_6.handleBodyContent(out);
                    }
                    _jettag_c_if_84_6.doEnd();
                    RuntimeTagElement _jettag_c_if_87_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_87_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_87_4.setRuntimeParent(_jettag_ws_folder_83_5);
                    _jettag_c_if_87_4.setTagInfo(_td_c_if_87_4);
                    _jettag_c_if_87_4.doStart(context, out);
                    while (_jettag_c_if_87_4.okToProcessBody()) {
                        out.write("\t \t\t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_88_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_88_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_88_5.setRuntimeParent(_jettag_c_if_87_4);
                        _jettag_ws_file_88_5.setTagInfo(_td_ws_file_88_5);
                        _jettag_ws_file_88_5.doStart(context, out);
                        _jettag_ws_file_88_5.doEnd();
                        out.write(NL);         
                        _jettag_c_if_87_4.handleBodyContent(out);
                    }
                    _jettag_c_if_87_4.doEnd();
                    RuntimeTagElement _jettag_c_if_90_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_90_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_90_4.setRuntimeParent(_jettag_ws_folder_83_5);
                    _jettag_c_if_90_4.setTagInfo(_td_c_if_90_4);
                    _jettag_c_if_90_4.doStart(context, out);
                    while (_jettag_c_if_90_4.okToProcessBody()) {
                        out.write("\t \t\t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_91_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_91_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_91_5.setRuntimeParent(_jettag_c_if_90_4);
                        _jettag_ws_file_91_5.setTagInfo(_td_ws_file_91_5);
                        _jettag_ws_file_91_5.doStart(context, out);
                        _jettag_ws_file_91_5.doEnd();
                        out.write(NL);         
                        _jettag_c_if_90_4.handleBodyContent(out);
                    }
                    _jettag_c_if_90_4.doEnd();
                    _jettag_ws_folder_83_5.handleBodyContent(out);
                }
                _jettag_ws_folder_83_5.doEnd();
                RuntimeTagElement _jettag_ws_folder_94_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_94_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_94_5.setRuntimeParent(_jettag_ws_project_79_1);
                _jettag_ws_folder_94_5.setTagInfo(_td_ws_folder_94_5);
                _jettag_ws_folder_94_5.doStart(context, out);
                while (_jettag_ws_folder_94_5.okToProcessBody()) {
                    out.write("    \t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_95_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_95_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_95_6.setRuntimeParent(_jettag_ws_folder_94_5);
                    _jettag_ws_file_95_6.setTagInfo(_td_ws_file_95_6);
                    _jettag_ws_file_95_6.doStart(context, out);
                    _jettag_ws_file_95_6.doEnd();
                    out.write(NL);         
                    out.write("    \t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_copyFile_96_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "copyFile", "ws:copyFile", _td_ws_copyFile_96_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_copyFile_96_6.setRuntimeParent(_jettag_ws_folder_94_5);
                    _jettag_ws_copyFile_96_6.setTagInfo(_td_ws_copyFile_96_6);
                    _jettag_ws_copyFile_96_6.doStart(context, out);
                    _jettag_ws_copyFile_96_6.doEnd();
                    out.write(NL);         
                    _jettag_ws_folder_94_5.handleBodyContent(out);
                }
                _jettag_ws_folder_94_5.doEnd();
                // Model folder
                RuntimeTagElement _jettag_ws_folder_99_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_99_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_99_5.setRuntimeParent(_jettag_ws_project_79_1);
                _jettag_ws_folder_99_5.setTagInfo(_td_ws_folder_99_5);
                _jettag_ws_folder_99_5.doStart(context, out);
                while (_jettag_ws_folder_99_5.okToProcessBody()) {
                    out.write("    \t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_copyFile_100_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "copyFile", "ws:copyFile", _td_ws_copyFile_100_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_copyFile_100_6.setRuntimeParent(_jettag_ws_folder_99_5);
                    _jettag_ws_copyFile_100_6.setTagInfo(_td_ws_copyFile_100_6);
                    _jettag_ws_copyFile_100_6.doStart(context, out);
                    _jettag_ws_copyFile_100_6.doEnd();
                    out.write(NL);         
                    _jettag_ws_folder_99_5.handleBodyContent(out);
                }
                _jettag_ws_folder_99_5.doEnd();
                _jettag_ws_project_79_1.handleBodyContent(out);
            }
            _jettag_ws_project_79_1.doEnd();
            _jettag_c_if_78_1.handleBodyContent(out);
        }
        _jettag_c_if_78_1.doEnd();
        out.write(NL);         
        //creates the JPA project
        RuntimeTagElement _jettag_c_if_106_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_106_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_106_1.setRuntimeParent(null);
        _jettag_c_if_106_1.setTagInfo(_td_c_if_106_1);
        _jettag_c_if_106_1.doStart(context, out);
        while (_jettag_c_if_106_1.okToProcessBody()) {
            RuntimeTagElement _jettag_ws_project_107_1 = context.getTagFactory().createRuntimeTag(_jetns_ws, "project", "ws:project", _td_ws_project_107_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_ws_project_107_1.setRuntimeParent(_jettag_c_if_106_1);
            _jettag_ws_project_107_1.setTagInfo(_td_ws_project_107_1);
            _jettag_ws_project_107_1.doStart(context, out);
            while (_jettag_ws_project_107_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_if_108_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_108_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_108_2.setRuntimeParent(_jettag_ws_project_107_1);
                _jettag_c_if_108_2.setTagInfo(_td_c_if_108_2);
                _jettag_c_if_108_2.doStart(context, out);
                while (_jettag_c_if_108_2.okToProcessBody()) {
                    out.write("\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_109_2 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_109_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_109_2.setRuntimeParent(_jettag_c_if_108_2);
                    _jettag_ws_file_109_2.setTagInfo(_td_ws_file_109_2);
                    _jettag_ws_file_109_2.doStart(context, out);
                    _jettag_ws_file_109_2.doEnd();
                    out.write(NL);         
                    _jettag_c_if_108_2.handleBodyContent(out);
                }
                _jettag_c_if_108_2.doEnd();
                RuntimeTagElement _jettag_ws_folder_111_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_111_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_111_5.setRuntimeParent(_jettag_ws_project_107_1);
                _jettag_ws_folder_111_5.setTagInfo(_td_ws_folder_111_5);
                _jettag_ws_folder_111_5.doStart(context, out);
                while (_jettag_ws_folder_111_5.okToProcessBody()) {
                    //iterate through the packages and create jpa classes and enumerations 
                    RuntimeTagElement _jettag_c_iterate_113_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_113_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_113_6.setRuntimeParent(_jettag_ws_folder_111_5);
                    _jettag_c_iterate_113_6.setTagInfo(_td_c_iterate_113_6);
                    _jettag_c_iterate_113_6.doStart(context, out);
                    while (_jettag_c_iterate_113_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_ws_folder_114_7 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_114_7); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_folder_114_7.setRuntimeParent(_jettag_c_iterate_113_6);
                        _jettag_ws_folder_114_7.setTagInfo(_td_ws_folder_114_7);
                        _jettag_ws_folder_114_7.doStart(context, out);
                        while (_jettag_ws_folder_114_7.okToProcessBody()) {
                            // create enumerations in the package
                            RuntimeTagElement _jettag_c_iterate_116_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_116_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_116_7.setRuntimeParent(_jettag_ws_folder_114_7);
                            _jettag_c_iterate_116_7.setTagInfo(_td_c_iterate_116_7);
                            _jettag_c_iterate_116_7.doStart(context, out);
                            while (_jettag_c_iterate_116_7.okToProcessBody()) {
                                out.write("    \t\t");  //$NON-NLS-1$        
                                RuntimeTagElement _jettag_ws_file_117_7 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_117_7); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_ws_file_117_7.setRuntimeParent(_jettag_c_iterate_116_7);
                                _jettag_ws_file_117_7.setTagInfo(_td_ws_file_117_7);
                                _jettag_ws_file_117_7.doStart(context, out);
                                _jettag_ws_file_117_7.doEnd();
                                out.write("\t");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_iterate_116_7.handleBodyContent(out);
                            }
                            _jettag_c_iterate_116_7.doEnd();
                            // create JPA source classes in the package
                            RuntimeTagElement _jettag_c_iterate_120_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_120_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_120_4.setRuntimeParent(_jettag_ws_folder_114_7);
                            _jettag_c_iterate_120_4.setTagInfo(_td_c_iterate_120_4);
                            _jettag_c_iterate_120_4.doStart(context, out);
                            while (_jettag_c_iterate_120_4.okToProcessBody()) {
                                out.write("\t\t\t");  //$NON-NLS-1$        
                                RuntimeTagElement _jettag_ws_file_121_4 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_121_4); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_ws_file_121_4.setRuntimeParent(_jettag_c_iterate_120_4);
                                _jettag_ws_file_121_4.setTagInfo(_td_ws_file_121_4);
                                _jettag_ws_file_121_4.doStart(context, out);
                                _jettag_ws_file_121_4.doEnd();
                                out.write(NL);         
                                _jettag_c_iterate_120_4.handleBodyContent(out);
                            }
                            _jettag_c_iterate_120_4.doEnd();
                            _jettag_ws_folder_114_7.handleBodyContent(out);
                        }
                        _jettag_ws_folder_114_7.doEnd();
                        _jettag_c_iterate_113_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_113_6.doEnd();
                    _jettag_ws_folder_111_5.handleBodyContent(out);
                }
                _jettag_ws_folder_111_5.doEnd();
                RuntimeTagElement _jettag_ws_folder_126_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_126_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_126_5.setRuntimeParent(_jettag_ws_project_107_1);
                _jettag_ws_folder_126_5.setTagInfo(_td_ws_folder_126_5);
                _jettag_ws_folder_126_5.doStart(context, out);
                while (_jettag_ws_folder_126_5.okToProcessBody()) {
                    out.write("    ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_127_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_127_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_127_5.setRuntimeParent(_jettag_ws_folder_126_5);
                    _jettag_ws_file_127_5.setTagInfo(_td_ws_file_127_5);
                    _jettag_ws_file_127_5.doStart(context, out);
                    _jettag_ws_file_127_5.doEnd();
                    out.write(NL);         
                    //   <ws:file template="templates/jpa/src/main/resources/jpa_ormxml_template.xml.jet" path="META-INF/orm.xml"/> 
                    out.write("    ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_129_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_129_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_129_5.setRuntimeParent(_jettag_ws_folder_126_5);
                    _jettag_ws_file_129_5.setTagInfo(_td_ws_file_129_5);
                    _jettag_ws_file_129_5.doStart(context, out);
                    _jettag_ws_file_129_5.doEnd();
                    out.write(NL);         
                    _jettag_ws_folder_126_5.handleBodyContent(out);
                }
                _jettag_ws_folder_126_5.doEnd();
                RuntimeTagElement _jettag_ws_folder_131_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_131_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_131_5.setRuntimeParent(_jettag_ws_project_107_1);
                _jettag_ws_folder_131_5.setTagInfo(_td_ws_folder_131_5);
                _jettag_ws_folder_131_5.doStart(context, out);
                while (_jettag_ws_folder_131_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_132_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_132_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_132_5.setRuntimeParent(_jettag_ws_folder_131_5);
                    _jettag_c_iterate_132_5.setTagInfo(_td_c_iterate_132_5);
                    _jettag_c_iterate_132_5.doStart(context, out);
                    while (_jettag_c_iterate_132_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_ws_folder_133_7 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_133_7); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_folder_133_7.setRuntimeParent(_jettag_c_iterate_132_5);
                        _jettag_ws_folder_133_7.setTagInfo(_td_ws_folder_133_7);
                        _jettag_ws_folder_133_7.doStart(context, out);
                        while (_jettag_ws_folder_133_7.okToProcessBody()) {
                            // create test classes in the package
                            RuntimeTagElement _jettag_c_iterate_135_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_135_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_135_4.setRuntimeParent(_jettag_ws_folder_133_7);
                            _jettag_c_iterate_135_4.setTagInfo(_td_c_iterate_135_4);
                            _jettag_c_iterate_135_4.doStart(context, out);
                            while (_jettag_c_iterate_135_4.okToProcessBody()) {
                                //<ws:file path="{$class/@name}JPATest.java" template="templates/jpa/src/test/java/jpa_enitity_test.java.jet" />
                                _jettag_c_iterate_135_4.handleBodyContent(out);
                            }
                            _jettag_c_iterate_135_4.doEnd();
                            _jettag_ws_folder_133_7.handleBodyContent(out);
                        }
                        _jettag_ws_folder_133_7.doEnd();
                        _jettag_c_iterate_132_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_132_5.doEnd();
                    _jettag_ws_folder_131_5.handleBodyContent(out);
                }
                _jettag_ws_folder_131_5.doEnd();
                out.write("    ");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_ws_folder_142_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_142_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_142_5.setRuntimeParent(_jettag_ws_project_107_1);
                _jettag_ws_folder_142_5.setTagInfo(_td_ws_folder_142_5);
                _jettag_ws_folder_142_5.doStart(context, out);
                while (_jettag_ws_folder_142_5.okToProcessBody()) {
                    out.write("\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_143_2 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_143_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_143_2.setRuntimeParent(_jettag_ws_folder_142_5);
                    _jettag_ws_file_143_2.setTagInfo(_td_ws_file_143_2);
                    _jettag_ws_file_143_2.doStart(context, out);
                    _jettag_ws_file_143_2.doEnd();
                    out.write(NL);         
                    out.write("\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_144_2 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_144_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_144_2.setRuntimeParent(_jettag_ws_folder_142_5);
                    _jettag_ws_file_144_2.setTagInfo(_td_ws_file_144_2);
                    _jettag_ws_file_144_2.doStart(context, out);
                    _jettag_ws_file_144_2.doEnd();
                    out.write(NL);         
                    _jettag_ws_folder_142_5.handleBodyContent(out);
                }
                _jettag_ws_folder_142_5.doEnd();
                _jettag_ws_project_107_1.handleBodyContent(out);
            }
            _jettag_ws_project_107_1.doEnd();
            _jettag_c_if_106_1.handleBodyContent(out);
        }
        _jettag_c_if_106_1.doEnd();
        out.write(NL);         
        //creates the DAO project
        RuntimeTagElement _jettag_c_if_150_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_150_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_150_1.setRuntimeParent(null);
        _jettag_c_if_150_1.setTagInfo(_td_c_if_150_1);
        _jettag_c_if_150_1.doStart(context, out);
        while (_jettag_c_if_150_1.okToProcessBody()) {
            RuntimeTagElement _jettag_ws_project_151_1 = context.getTagFactory().createRuntimeTag(_jetns_ws, "project", "ws:project", _td_ws_project_151_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_ws_project_151_1.setRuntimeParent(_jettag_c_if_150_1);
            _jettag_ws_project_151_1.setTagInfo(_td_ws_project_151_1);
            _jettag_ws_project_151_1.doStart(context, out);
            while (_jettag_ws_project_151_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_if_152_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_152_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_152_2.setRuntimeParent(_jettag_ws_project_151_1);
                _jettag_c_if_152_2.setTagInfo(_td_c_if_152_2);
                _jettag_c_if_152_2.doStart(context, out);
                while (_jettag_c_if_152_2.okToProcessBody()) {
                    out.write("\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_153_2 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_153_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_153_2.setRuntimeParent(_jettag_c_if_152_2);
                    _jettag_ws_file_153_2.setTagInfo(_td_ws_file_153_2);
                    _jettag_ws_file_153_2.doStart(context, out);
                    _jettag_ws_file_153_2.doEnd();
                    out.write(NL);         
                    _jettag_c_if_152_2.handleBodyContent(out);
                }
                _jettag_c_if_152_2.doEnd();
                RuntimeTagElement _jettag_ws_folder_155_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_155_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_155_5.setRuntimeParent(_jettag_ws_project_151_1);
                _jettag_ws_folder_155_5.setTagInfo(_td_ws_folder_155_5);
                _jettag_ws_folder_155_5.doStart(context, out);
                while (_jettag_ws_folder_155_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_ws_folder_156_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_156_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_folder_156_6.setRuntimeParent(_jettag_ws_folder_155_5);
                    _jettag_ws_folder_156_6.setTagInfo(_td_ws_folder_156_6);
                    _jettag_ws_folder_156_6.doStart(context, out);
                    while (_jettag_ws_folder_156_6.okToProcessBody()) {
                        _jettag_ws_folder_156_6.handleBodyContent(out);
                    }
                    _jettag_ws_folder_156_6.doEnd();
                    out.write(NL);         
                    RuntimeTagElement _jettag_c_iterate_159_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_159_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_159_6.setRuntimeParent(_jettag_ws_folder_155_5);
                    _jettag_c_iterate_159_6.setTagInfo(_td_c_iterate_159_6);
                    _jettag_c_iterate_159_6.doStart(context, out);
                    while (_jettag_c_iterate_159_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_160_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_160_7); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_160_7.setRuntimeParent(_jettag_c_iterate_159_6);
                        _jettag_c_iterate_160_7.setTagInfo(_td_c_iterate_160_7);
                        _jettag_c_iterate_160_7.doStart(context, out);
                        while (_jettag_c_iterate_160_7.okToProcessBody()) {
                            RuntimeTagElement _jettag_ws_folder_161_7 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_161_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_ws_folder_161_7.setRuntimeParent(_jettag_c_iterate_160_7);
                            _jettag_ws_folder_161_7.setTagInfo(_td_ws_folder_161_7);
                            _jettag_ws_folder_161_7.doStart(context, out);
                            while (_jettag_ws_folder_161_7.okToProcessBody()) {
                                // DAOImpl class
                                out.write("\t\t\t\t");  //$NON-NLS-1$        
                                RuntimeTagElement _jettag_ws_file_163_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_163_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_ws_file_163_5.setRuntimeParent(_jettag_ws_folder_161_7);
                                _jettag_ws_file_163_5.setTagInfo(_td_ws_file_163_5);
                                _jettag_ws_file_163_5.doStart(context, out);
                                _jettag_ws_file_163_5.doEnd();
                                out.write(NL);         
                                _jettag_ws_folder_161_7.handleBodyContent(out);
                            }
                            _jettag_ws_folder_161_7.doEnd();
                            _jettag_c_iterate_160_7.handleBodyContent(out);
                        }
                        _jettag_c_iterate_160_7.doEnd();
                        _jettag_c_iterate_159_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_159_6.doEnd();
                    _jettag_ws_folder_155_5.handleBodyContent(out);
                }
                _jettag_ws_folder_155_5.doEnd();
                RuntimeTagElement _jettag_ws_folder_168_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_168_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_168_5.setRuntimeParent(_jettag_ws_project_151_1);
                _jettag_ws_folder_168_5.setTagInfo(_td_ws_folder_168_5);
                _jettag_ws_folder_168_5.doStart(context, out);
                while (_jettag_ws_folder_168_5.okToProcessBody()) {
                    out.write("\t   ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_169_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_169_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_169_5.setRuntimeParent(_jettag_ws_folder_168_5);
                    _jettag_ws_file_169_5.setTagInfo(_td_ws_file_169_5);
                    _jettag_ws_file_169_5.doStart(context, out);
                    _jettag_ws_file_169_5.doEnd();
                    out.write(NL);         
                    _jettag_ws_folder_168_5.handleBodyContent(out);
                }
                _jettag_ws_folder_168_5.doEnd();
                _jettag_ws_project_151_1.handleBodyContent(out);
            }
            _jettag_ws_project_151_1.doEnd();
            _jettag_c_if_150_1.handleBodyContent(out);
        }
        _jettag_c_if_150_1.doEnd();
        out.write(NL);         
        //creates the service-types (JAXB) project
        RuntimeTagElement _jettag_c_if_175_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_175_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_175_1.setRuntimeParent(null);
        _jettag_c_if_175_1.setTagInfo(_td_c_if_175_1);
        _jettag_c_if_175_1.doStart(context, out);
        while (_jettag_c_if_175_1.okToProcessBody()) {
            RuntimeTagElement _jettag_ws_project_176_1 = context.getTagFactory().createRuntimeTag(_jetns_ws, "project", "ws:project", _td_ws_project_176_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_ws_project_176_1.setRuntimeParent(_jettag_c_if_175_1);
            _jettag_ws_project_176_1.setTagInfo(_td_ws_project_176_1);
            _jettag_ws_project_176_1.doStart(context, out);
            while (_jettag_ws_project_176_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_if_177_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_177_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_177_2.setRuntimeParent(_jettag_ws_project_176_1);
                _jettag_c_if_177_2.setTagInfo(_td_c_if_177_2);
                _jettag_c_if_177_2.doStart(context, out);
                while (_jettag_c_if_177_2.okToProcessBody()) {
                    out.write("\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_178_2 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_178_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_178_2.setRuntimeParent(_jettag_c_if_177_2);
                    _jettag_ws_file_178_2.setTagInfo(_td_ws_file_178_2);
                    _jettag_ws_file_178_2.doStart(context, out);
                    _jettag_ws_file_178_2.doEnd();
                    out.write(NL);         
                    _jettag_c_if_177_2.handleBodyContent(out);
                }
                _jettag_c_if_177_2.doEnd();
                RuntimeTagElement _jettag_ws_folder_180_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_180_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_180_5.setRuntimeParent(_jettag_ws_project_176_1);
                _jettag_ws_folder_180_5.setTagInfo(_td_ws_folder_180_5);
                _jettag_ws_folder_180_5.doStart(context, out);
                while (_jettag_ws_folder_180_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_181_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_181_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_181_6.setRuntimeParent(_jettag_ws_folder_180_5);
                    _jettag_c_iterate_181_6.setTagInfo(_td_c_iterate_181_6);
                    _jettag_c_iterate_181_6.doStart(context, out);
                    while (_jettag_c_iterate_181_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_182_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_182_7); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_182_7.setRuntimeParent(_jettag_c_iterate_181_6);
                        _jettag_c_iterate_182_7.setTagInfo(_td_c_iterate_182_7);
                        _jettag_c_iterate_182_7.doStart(context, out);
                        while (_jettag_c_iterate_182_7.okToProcessBody()) {
                            RuntimeTagElement _jettag_ws_folder_183_7 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_183_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_ws_folder_183_7.setRuntimeParent(_jettag_c_iterate_182_7);
                            _jettag_ws_folder_183_7.setTagInfo(_td_ws_folder_183_7);
                            _jettag_ws_folder_183_7.doStart(context, out);
                            while (_jettag_ws_folder_183_7.okToProcessBody()) {
                                // JAXB class 
                                out.write("\t\t\t\t");  //$NON-NLS-1$        
                                RuntimeTagElement _jettag_ws_file_185_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_185_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_ws_file_185_5.setRuntimeParent(_jettag_ws_folder_183_7);
                                _jettag_ws_file_185_5.setTagInfo(_td_ws_file_185_5);
                                _jettag_ws_file_185_5.doStart(context, out);
                                _jettag_ws_file_185_5.doEnd();
                                out.write(NL);         
                                _jettag_ws_folder_183_7.handleBodyContent(out);
                            }
                            _jettag_ws_folder_183_7.doEnd();
                            _jettag_c_iterate_182_7.handleBodyContent(out);
                        }
                        _jettag_c_iterate_182_7.doEnd();
                        _jettag_c_iterate_181_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_181_6.doEnd();
                    _jettag_ws_folder_180_5.handleBodyContent(out);
                }
                _jettag_ws_folder_180_5.doEnd();
                RuntimeTagElement _jettag_ws_folder_190_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_190_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_190_5.setRuntimeParent(_jettag_ws_project_176_1);
                _jettag_ws_folder_190_5.setTagInfo(_td_ws_folder_190_5);
                _jettag_ws_folder_190_5.doStart(context, out);
                while (_jettag_ws_folder_190_5.okToProcessBody()) {
                    out.write("\t   ");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_ws_folder_190_5.handleBodyContent(out);
                }
                _jettag_ws_folder_190_5.doEnd();
                _jettag_ws_project_176_1.handleBodyContent(out);
            }
            _jettag_ws_project_176_1.doEnd();
            _jettag_c_if_175_1.handleBodyContent(out);
        }
        _jettag_c_if_175_1.doEnd();
        out.write(NL);         
        //creates the EJB project
        RuntimeTagElement _jettag_c_if_197_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_197_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_197_1.setRuntimeParent(null);
        _jettag_c_if_197_1.setTagInfo(_td_c_if_197_1);
        _jettag_c_if_197_1.doStart(context, out);
        while (_jettag_c_if_197_1.okToProcessBody()) {
            RuntimeTagElement _jettag_ws_project_198_1 = context.getTagFactory().createRuntimeTag(_jetns_ws, "project", "ws:project", _td_ws_project_198_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_ws_project_198_1.setRuntimeParent(_jettag_c_if_197_1);
            _jettag_ws_project_198_1.setTagInfo(_td_ws_project_198_1);
            _jettag_ws_project_198_1.doStart(context, out);
            while (_jettag_ws_project_198_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_if_199_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_199_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_199_2.setRuntimeParent(_jettag_ws_project_198_1);
                _jettag_c_if_199_2.setTagInfo(_td_c_if_199_2);
                _jettag_c_if_199_2.doStart(context, out);
                while (_jettag_c_if_199_2.okToProcessBody()) {
                    out.write("\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_200_2 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_200_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_200_2.setRuntimeParent(_jettag_c_if_199_2);
                    _jettag_ws_file_200_2.setTagInfo(_td_ws_file_200_2);
                    _jettag_ws_file_200_2.doStart(context, out);
                    _jettag_ws_file_200_2.doEnd();
                    out.write(NL);         
                    _jettag_c_if_199_2.handleBodyContent(out);
                }
                _jettag_c_if_199_2.doEnd();
                RuntimeTagElement _jettag_ws_folder_202_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_202_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_202_5.setRuntimeParent(_jettag_ws_project_198_1);
                _jettag_ws_folder_202_5.setTagInfo(_td_ws_folder_202_5);
                _jettag_ws_folder_202_5.doStart(context, out);
                while (_jettag_ws_folder_202_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_ws_folder_203_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_203_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_folder_203_6.setRuntimeParent(_jettag_ws_folder_202_5);
                    _jettag_ws_folder_203_6.setTagInfo(_td_ws_folder_203_6);
                    _jettag_ws_folder_203_6.doStart(context, out);
                    while (_jettag_ws_folder_203_6.okToProcessBody()) {
                        // Generic EJB interface
                        out.write("     \t\t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_205_8 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_205_8); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_205_8.setRuntimeParent(_jettag_ws_folder_203_6);
                        _jettag_ws_file_205_8.setTagInfo(_td_ws_file_205_8);
                        _jettag_ws_file_205_8.doStart(context, out);
                        _jettag_ws_file_205_8.doEnd();
                        out.write(NL);         
                        // Generic EJB Local interface
                        out.write("\t\t\t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_207_4 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_207_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_207_4.setRuntimeParent(_jettag_ws_folder_203_6);
                        _jettag_ws_file_207_4.setTagInfo(_td_ws_file_207_4);
                        _jettag_ws_file_207_4.doStart(context, out);
                        _jettag_ws_file_207_4.doEnd();
                        out.write(NL);         
                        // Generic EJB Remote interface
                        out.write("\t\t\t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_209_4 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_209_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_209_4.setRuntimeParent(_jettag_ws_folder_203_6);
                        _jettag_ws_file_209_4.setTagInfo(_td_ws_file_209_4);
                        _jettag_ws_file_209_4.doStart(context, out);
                        _jettag_ws_file_209_4.doEnd();
                        out.write(NL);         
                        // Generic EJB Service Impl class
                        out.write("\t\t\t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_211_4 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_211_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_211_4.setRuntimeParent(_jettag_ws_folder_203_6);
                        _jettag_ws_file_211_4.setTagInfo(_td_ws_file_211_4);
                        _jettag_ws_file_211_4.doStart(context, out);
                        _jettag_ws_file_211_4.doEnd();
                        out.write(NL);         
                        _jettag_ws_folder_203_6.handleBodyContent(out);
                    }
                    _jettag_ws_folder_203_6.doEnd();
                    out.write(NL);         
                    RuntimeTagElement _jettag_c_iterate_214_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_214_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_214_6.setRuntimeParent(_jettag_ws_folder_202_5);
                    _jettag_c_iterate_214_6.setTagInfo(_td_c_iterate_214_6);
                    _jettag_c_iterate_214_6.doStart(context, out);
                    while (_jettag_c_iterate_214_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_215_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_215_7); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_215_7.setRuntimeParent(_jettag_c_iterate_214_6);
                        _jettag_c_iterate_215_7.setTagInfo(_td_c_iterate_215_7);
                        _jettag_c_iterate_215_7.doStart(context, out);
                        while (_jettag_c_iterate_215_7.okToProcessBody()) {
                            RuntimeTagElement _jettag_ws_folder_216_7 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_216_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_ws_folder_216_7.setRuntimeParent(_jettag_c_iterate_215_7);
                            _jettag_ws_folder_216_7.setTagInfo(_td_ws_folder_216_7);
                            _jettag_ws_folder_216_7.doStart(context, out);
                            while (_jettag_ws_folder_216_7.okToProcessBody()) {
                                // CRUD EJB interface
                                out.write("\t    \t\t");  //$NON-NLS-1$        
                                RuntimeTagElement _jettag_ws_file_218_8 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_218_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_ws_file_218_8.setRuntimeParent(_jettag_ws_folder_216_7);
                                _jettag_ws_file_218_8.setTagInfo(_td_ws_file_218_8);
                                _jettag_ws_file_218_8.doStart(context, out);
                                _jettag_ws_file_218_8.doEnd();
                                out.write(NL);         
                                // CRUD EJB Local interface
                                out.write("\t\t\t\t");  //$NON-NLS-1$        
                                RuntimeTagElement _jettag_ws_file_220_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_220_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_ws_file_220_5.setRuntimeParent(_jettag_ws_folder_216_7);
                                _jettag_ws_file_220_5.setTagInfo(_td_ws_file_220_5);
                                _jettag_ws_file_220_5.doStart(context, out);
                                _jettag_ws_file_220_5.doEnd();
                                out.write(NL);         
                                // CRUD EJB Remote interface
                                out.write("\t\t\t\t");  //$NON-NLS-1$        
                                RuntimeTagElement _jettag_ws_file_222_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_222_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_ws_file_222_5.setRuntimeParent(_jettag_ws_folder_216_7);
                                _jettag_ws_file_222_5.setTagInfo(_td_ws_file_222_5);
                                _jettag_ws_file_222_5.doStart(context, out);
                                _jettag_ws_file_222_5.doEnd();
                                out.write(NL);         
                                // CRUD EJB Service Impl class
                                out.write("\t\t\t\t");  //$NON-NLS-1$        
                                RuntimeTagElement _jettag_ws_file_224_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_224_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_ws_file_224_5.setRuntimeParent(_jettag_ws_folder_216_7);
                                _jettag_ws_file_224_5.setTagInfo(_td_ws_file_224_5);
                                _jettag_ws_file_224_5.doStart(context, out);
                                _jettag_ws_file_224_5.doEnd();
                                out.write(NL);         
                                _jettag_ws_folder_216_7.handleBodyContent(out);
                            }
                            _jettag_ws_folder_216_7.doEnd();
                            _jettag_c_iterate_215_7.handleBodyContent(out);
                        }
                        _jettag_c_iterate_215_7.doEnd();
                        _jettag_c_iterate_214_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_214_6.doEnd();
                    _jettag_ws_folder_202_5.handleBodyContent(out);
                }
                _jettag_ws_folder_202_5.doEnd();
                RuntimeTagElement _jettag_ws_folder_229_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_229_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_229_5.setRuntimeParent(_jettag_ws_project_198_1);
                _jettag_ws_folder_229_5.setTagInfo(_td_ws_folder_229_5);
                _jettag_ws_folder_229_5.doStart(context, out);
                while (_jettag_ws_folder_229_5.okToProcessBody()) {
                    out.write("   ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_230_4 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_230_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_230_4.setRuntimeParent(_jettag_ws_folder_229_5);
                    _jettag_ws_file_230_4.setTagInfo(_td_ws_file_230_4);
                    _jettag_ws_file_230_4.doStart(context, out);
                    _jettag_ws_file_230_4.doEnd();
                    out.write(NL);         
                    out.write("   ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_231_4 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_231_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_231_4.setRuntimeParent(_jettag_ws_folder_229_5);
                    _jettag_ws_file_231_4.setTagInfo(_td_ws_file_231_4);
                    _jettag_ws_file_231_4.doStart(context, out);
                    _jettag_ws_file_231_4.doEnd();
                    out.write(NL);         
                    _jettag_ws_folder_229_5.handleBodyContent(out);
                }
                _jettag_ws_folder_229_5.doEnd();
                RuntimeTagElement _jettag_ws_folder_233_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_233_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_233_5.setRuntimeParent(_jettag_ws_project_198_1);
                _jettag_ws_folder_233_5.setTagInfo(_td_ws_folder_233_5);
                _jettag_ws_folder_233_5.doStart(context, out);
                while (_jettag_ws_folder_233_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_234_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_234_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_234_5.setRuntimeParent(_jettag_ws_folder_233_5);
                    _jettag_c_setVariable_234_5.setTagInfo(_td_c_setVariable_234_5);
                    _jettag_c_setVariable_234_5.doStart(context, out);
                    _jettag_c_setVariable_234_5.doEnd();
                    RuntimeTagElement _jettag_c_iterate_235_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_235_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_235_6.setRuntimeParent(_jettag_ws_folder_233_5);
                    _jettag_c_iterate_235_6.setTagInfo(_td_c_iterate_235_6);
                    _jettag_c_iterate_235_6.doStart(context, out);
                    while (_jettag_c_iterate_235_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_236_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_236_7); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_236_7.setRuntimeParent(_jettag_c_iterate_235_6);
                        _jettag_c_iterate_236_7.setTagInfo(_td_c_iterate_236_7);
                        _jettag_c_iterate_236_7.doStart(context, out);
                        while (_jettag_c_iterate_236_7.okToProcessBody()) {
                            RuntimeTagElement _jettag_ws_folder_237_7 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_237_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_ws_folder_237_7.setRuntimeParent(_jettag_c_iterate_236_7);
                            _jettag_ws_folder_237_7.setTagInfo(_td_ws_folder_237_7);
                            _jettag_ws_folder_237_7.doStart(context, out);
                            while (_jettag_ws_folder_237_7.okToProcessBody()) {
                                //Embedded Test
                                out.write("\t\t\t");  //$NON-NLS-1$        
                                RuntimeTagElement _jettag_ws_file_239_4 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_239_4); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_ws_file_239_4.setRuntimeParent(_jettag_ws_folder_237_7);
                                _jettag_ws_file_239_4.setTagInfo(_td_ws_file_239_4);
                                _jettag_ws_file_239_4.doStart(context, out);
                                _jettag_ws_file_239_4.doEnd();
                                out.write(NL);         
                                _jettag_ws_folder_237_7.handleBodyContent(out);
                            }
                            _jettag_ws_folder_237_7.doEnd();
                            _jettag_c_iterate_236_7.handleBodyContent(out);
                        }
                        _jettag_c_iterate_236_7.doEnd();
                        _jettag_c_iterate_235_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_235_6.doEnd();
                    _jettag_ws_folder_233_5.handleBodyContent(out);
                }
                _jettag_ws_folder_233_5.doEnd();
                RuntimeTagElement _jettag_ws_folder_244_2 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_244_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_244_2.setRuntimeParent(_jettag_ws_project_198_1);
                _jettag_ws_folder_244_2.setTagInfo(_td_ws_folder_244_2);
                _jettag_ws_folder_244_2.doStart(context, out);
                while (_jettag_ws_folder_244_2.okToProcessBody()) {
                    out.write("\t\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_245_3 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_245_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_245_3.setRuntimeParent(_jettag_ws_folder_244_2);
                    _jettag_ws_file_245_3.setTagInfo(_td_ws_file_245_3);
                    _jettag_ws_file_245_3.doStart(context, out);
                    _jettag_ws_file_245_3.doEnd();
                    out.write(NL);         
                    out.write("\t\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_246_3 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_246_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_246_3.setRuntimeParent(_jettag_ws_folder_244_2);
                    _jettag_ws_file_246_3.setTagInfo(_td_ws_file_246_3);
                    _jettag_ws_file_246_3.doStart(context, out);
                    _jettag_ws_file_246_3.doEnd();
                    out.write(NL);         
                    _jettag_ws_folder_244_2.handleBodyContent(out);
                }
                _jettag_ws_folder_244_2.doEnd();
                _jettag_ws_project_198_1.handleBodyContent(out);
            }
            _jettag_ws_project_198_1.doEnd();
            _jettag_c_if_197_1.handleBodyContent(out);
        }
        _jettag_c_if_197_1.doEnd();
        out.write(NL);         
        //creates the webapp project
        RuntimeTagElement _jettag_c_if_252_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_252_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_252_1.setRuntimeParent(null);
        _jettag_c_if_252_1.setTagInfo(_td_c_if_252_1);
        _jettag_c_if_252_1.doStart(context, out);
        while (_jettag_c_if_252_1.okToProcessBody()) {
            RuntimeTagElement _jettag_ws_project_253_1 = context.getTagFactory().createRuntimeTag(_jetns_ws, "project", "ws:project", _td_ws_project_253_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_ws_project_253_1.setRuntimeParent(_jettag_c_if_252_1);
            _jettag_ws_project_253_1.setTagInfo(_td_ws_project_253_1);
            _jettag_ws_project_253_1.doStart(context, out);
            while (_jettag_ws_project_253_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_if_254_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_254_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_254_2.setRuntimeParent(_jettag_ws_project_253_1);
                _jettag_c_if_254_2.setTagInfo(_td_c_if_254_2);
                _jettag_c_if_254_2.doStart(context, out);
                while (_jettag_c_if_254_2.okToProcessBody()) {
                    out.write("\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_255_2 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_255_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_255_2.setRuntimeParent(_jettag_c_if_254_2);
                    _jettag_ws_file_255_2.setTagInfo(_td_ws_file_255_2);
                    _jettag_ws_file_255_2.doStart(context, out);
                    _jettag_ws_file_255_2.doEnd();
                    out.write(NL);         
                    _jettag_c_if_254_2.handleBodyContent(out);
                }
                _jettag_c_if_254_2.doEnd();
                RuntimeTagElement _jettag_ws_folder_257_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_257_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_257_5.setRuntimeParent(_jettag_ws_project_253_1);
                _jettag_ws_folder_257_5.setTagInfo(_td_ws_folder_257_5);
                _jettag_ws_folder_257_5.doStart(context, out);
                while (_jettag_ws_folder_257_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_ws_folder_258_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_258_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_folder_258_6.setRuntimeParent(_jettag_ws_folder_257_5);
                    _jettag_ws_folder_258_6.setTagInfo(_td_ws_folder_258_6);
                    _jettag_ws_folder_258_6.doStart(context, out);
                    while (_jettag_ws_folder_258_6.okToProcessBody()) {
                        out.write("    \t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_259_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_259_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_259_6.setRuntimeParent(_jettag_ws_folder_258_6);
                        _jettag_ws_file_259_6.setTagInfo(_td_ws_file_259_6);
                        _jettag_ws_file_259_6.doStart(context, out);
                        _jettag_ws_file_259_6.doEnd();
                        out.write(NL);         
                        _jettag_ws_folder_258_6.handleBodyContent(out);
                    }
                    _jettag_ws_folder_258_6.doEnd();
                    //create folder for icons  
                    out.write("     \t");  //$NON-NLS-1$        
                    out.write(NL);         
                    RuntimeTagElement _jettag_ws_folder_263_7 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_263_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_folder_263_7.setRuntimeParent(_jettag_ws_folder_257_5);
                    _jettag_ws_folder_263_7.setTagInfo(_td_ws_folder_263_7);
                    _jettag_ws_folder_263_7.doStart(context, out);
                    while (_jettag_ws_folder_263_7.okToProcessBody()) {
                        //create gwt.xml file to include these  
                        out.write("    \t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_265_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_265_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_265_6.setRuntimeParent(_jettag_ws_folder_263_7);
                        _jettag_ws_file_265_6.setTagInfo(_td_ws_file_265_6);
                        _jettag_ws_file_265_6.doStart(context, out);
                        _jettag_ws_file_265_6.doEnd();
                        out.write(NL);         
                        _jettag_ws_folder_263_7.handleBodyContent(out);
                    }
                    _jettag_ws_folder_263_7.doEnd();
                    out.write(NL);         
                    RuntimeTagElement _jettag_c_setVariable_268_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_268_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_268_6.setRuntimeParent(_jettag_ws_folder_257_5);
                    _jettag_c_setVariable_268_6.setTagInfo(_td_c_setVariable_268_6);
                    _jettag_c_setVariable_268_6.doStart(context, out);
                    _jettag_c_setVariable_268_6.doEnd();
                    out.write("    \t");  //$NON-NLS-1$        
                    out.write(NL);         
                    // RPC  
                    RuntimeTagElement _jettag_ws_folder_271_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_271_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_folder_271_6.setRuntimeParent(_jettag_ws_folder_257_5);
                    _jettag_ws_folder_271_6.setTagInfo(_td_ws_folder_271_6);
                    _jettag_ws_folder_271_6.doStart(context, out);
                    while (_jettag_ws_folder_271_6.okToProcessBody()) {
                        out.write("    \t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_272_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_272_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_272_6.setRuntimeParent(_jettag_ws_folder_271_6);
                        _jettag_ws_file_272_6.setTagInfo(_td_ws_file_272_6);
                        _jettag_ws_file_272_6.doStart(context, out);
                        _jettag_ws_file_272_6.doEnd();
                        out.write(NL);         
                        out.write("    \t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_273_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_273_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_273_6.setRuntimeParent(_jettag_ws_folder_271_6);
                        _jettag_ws_file_273_6.setTagInfo(_td_ws_file_273_6);
                        _jettag_ws_file_273_6.doStart(context, out);
                        _jettag_ws_file_273_6.doEnd();
                        out.write(NL);         
                        _jettag_ws_folder_271_6.handleBodyContent(out);
                    }
                    _jettag_ws_folder_271_6.doEnd();
                    out.write("    \t    \t");  //$NON-NLS-1$        
                    out.write(NL);         
                    // Current project servlet,startup component and GileadService  
                    RuntimeTagElement _jettag_ws_folder_277_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_277_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_folder_277_6.setRuntimeParent(_jettag_ws_folder_257_5);
                    _jettag_ws_folder_277_6.setTagInfo(_td_ws_folder_277_6);
                    _jettag_ws_folder_277_6.doStart(context, out);
                    while (_jettag_ws_folder_277_6.okToProcessBody()) {
                        out.write("    \t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_278_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_278_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_278_6.setRuntimeParent(_jettag_ws_folder_277_6);
                        _jettag_ws_file_278_6.setTagInfo(_td_ws_file_278_6);
                        _jettag_ws_file_278_6.doStart(context, out);
                        _jettag_ws_file_278_6.doEnd();
                        out.write(NL);         
                        out.write("    \t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_279_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_279_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_279_6.setRuntimeParent(_jettag_ws_folder_277_6);
                        _jettag_ws_file_279_6.setTagInfo(_td_ws_file_279_6);
                        _jettag_ws_file_279_6.doStart(context, out);
                        _jettag_ws_file_279_6.doEnd();
                        out.write(NL);         
                        _jettag_ws_folder_277_6.handleBodyContent(out);
                    }
                    _jettag_ws_folder_277_6.doEnd();
                    out.write("    \t");  //$NON-NLS-1$        
                    out.write(NL);         
                    // gwt messages and constants files
                    RuntimeTagElement _jettag_ws_folder_283_3 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_283_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_folder_283_3.setRuntimeParent(_jettag_ws_folder_257_5);
                    _jettag_ws_folder_283_3.setTagInfo(_td_ws_folder_283_3);
                    _jettag_ws_folder_283_3.doStart(context, out);
                    while (_jettag_ws_folder_283_3.okToProcessBody()) {
                        out.write("\t\t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_284_3 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_284_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_284_3.setRuntimeParent(_jettag_ws_folder_283_3);
                        _jettag_ws_file_284_3.setTagInfo(_td_ws_file_284_3);
                        _jettag_ws_file_284_3.doStart(context, out);
                        _jettag_ws_file_284_3.doEnd();
                        out.write(NL);         
                        out.write("\t\t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_285_3 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_285_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_285_3.setRuntimeParent(_jettag_ws_folder_283_3);
                        _jettag_ws_file_285_3.setTagInfo(_td_ws_file_285_3);
                        _jettag_ws_file_285_3.doStart(context, out);
                        _jettag_ws_file_285_3.doEnd();
                        out.write(NL);         
                        _jettag_ws_folder_283_3.handleBodyContent(out);
                    }
                    _jettag_ws_folder_283_3.doEnd();
                    out.write("\t\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    RuntimeTagElement _jettag_ws_folder_288_3 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_288_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_folder_288_3.setRuntimeParent(_jettag_ws_folder_257_5);
                    _jettag_ws_folder_288_3.setTagInfo(_td_ws_folder_288_3);
                    _jettag_ws_folder_288_3.doStart(context, out);
                    while (_jettag_ws_folder_288_3.okToProcessBody()) {
                        //  Entry point class 
                        out.write("    \t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_290_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_290_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_290_6.setRuntimeParent(_jettag_ws_folder_288_3);
                        _jettag_ws_file_290_6.setTagInfo(_td_ws_file_290_6);
                        _jettag_ws_file_290_6.doStart(context, out);
                        _jettag_ws_file_290_6.doEnd();
                        out.write(NL);         
                        // Entities Enum class 
                        out.write("    \t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_292_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_292_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_292_6.setRuntimeParent(_jettag_ws_folder_288_3);
                        _jettag_ws_file_292_6.setTagInfo(_td_ws_file_292_6);
                        _jettag_ws_file_292_6.doStart(context, out);
                        _jettag_ws_file_292_6.doEnd();
                        out.write(NL);         
                        //  RootLayout class corresponding to rootlayout uibinder 
                        out.write("    \t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_294_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_294_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_294_6.setRuntimeParent(_jettag_ws_folder_288_3);
                        _jettag_ws_file_294_6.setTagInfo(_td_ws_file_294_6);
                        _jettag_ws_file_294_6.doStart(context, out);
                        _jettag_ws_file_294_6.doEnd();
                        out.write(NL);         
                        //  RootLayout uibinder finder 
                        out.write("    \t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_296_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_296_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_296_6.setRuntimeParent(_jettag_ws_folder_288_3);
                        _jettag_ws_file_296_6.setTagInfo(_td_ws_file_296_6);
                        _jettag_ws_file_296_6.doStart(context, out);
                        _jettag_ws_file_296_6.doEnd();
                        out.write(NL);         
                        //  ROLES class 
                        out.write("    \t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_298_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_298_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_298_6.setRuntimeParent(_jettag_ws_folder_288_3);
                        _jettag_ws_file_298_6.setTagInfo(_td_ws_file_298_6);
                        _jettag_ws_file_298_6.doStart(context, out);
                        _jettag_ws_file_298_6.doEnd();
                        out.write(NL);         
                        //  Login panel class 
                        out.write("    \t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_300_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_300_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_300_6.setRuntimeParent(_jettag_ws_folder_288_3);
                        _jettag_ws_file_300_6.setTagInfo(_td_ws_file_300_6);
                        _jettag_ws_file_300_6.doStart(context, out);
                        _jettag_ws_file_300_6.doEnd();
                        out.write(NL);         
                        //  create user class 
                        out.write("    \t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_302_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_302_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_302_6.setRuntimeParent(_jettag_ws_folder_288_3);
                        _jettag_ws_file_302_6.setTagInfo(_td_ws_file_302_6);
                        _jettag_ws_file_302_6.doStart(context, out);
                        _jettag_ws_file_302_6.doEnd();
                        out.write(NL);         
                        //  Status panel class 
                        out.write("    \t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_304_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_304_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_304_6.setRuntimeParent(_jettag_ws_folder_288_3);
                        _jettag_ws_file_304_6.setTagInfo(_td_ws_file_304_6);
                        _jettag_ws_file_304_6.doStart(context, out);
                        _jettag_ws_file_304_6.doEnd();
                        out.write(NL);         
                        //  App Request factory class 
                        out.write("    \t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_306_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_306_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_306_6.setRuntimeParent(_jettag_ws_folder_288_3);
                        _jettag_ws_file_306_6.setTagInfo(_td_ws_file_306_6);
                        _jettag_ws_file_306_6.doStart(context, out);
                        _jettag_ws_file_306_6.doEnd();
                        out.write("    \t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_ws_folder_288_3.handleBodyContent(out);
                    }
                    _jettag_ws_folder_288_3.doEnd();
                    out.write("    \t");  //$NON-NLS-1$        
                    out.write(NL);         
                    // Iterate through packages and classes 
                    RuntimeTagElement _jettag_c_iterate_310_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_310_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_310_6.setRuntimeParent(_jettag_ws_folder_257_5);
                    _jettag_c_iterate_310_6.setTagInfo(_td_c_iterate_310_6);
                    _jettag_c_iterate_310_6.doStart(context, out);
                    while (_jettag_c_iterate_310_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_setVariable_311_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_311_8); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_311_8.setRuntimeParent(_jettag_c_iterate_310_6);
                        _jettag_c_setVariable_311_8.setTagInfo(_td_c_setVariable_311_8);
                        _jettag_c_setVariable_311_8.doStart(context, out);
                        _jettag_c_setVariable_311_8.doEnd();
                        RuntimeTagElement _jettag_c_iterate_312_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_312_8); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_312_8.setRuntimeParent(_jettag_c_iterate_310_6);
                        _jettag_c_iterate_312_8.setTagInfo(_td_c_iterate_312_8);
                        _jettag_c_iterate_312_8.doStart(context, out);
                        while (_jettag_c_iterate_312_8.okToProcessBody()) {
                            // process generizations upto 2 levels and get teh parent classes if any
                            RuntimeTagElement _jettag_c_setVariable_314_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_314_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_314_7.setRuntimeParent(_jettag_c_iterate_312_8);
                            _jettag_c_setVariable_314_7.setTagInfo(_td_c_setVariable_314_7);
                            _jettag_c_setVariable_314_7.doStart(context, out);
                            _jettag_c_setVariable_314_7.doEnd();
                            RuntimeTagElement _jettag_c_setVariable_315_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_315_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_315_4.setRuntimeParent(_jettag_c_iterate_312_8);
                            _jettag_c_setVariable_315_4.setTagInfo(_td_c_setVariable_315_4);
                            _jettag_c_setVariable_315_4.doStart(context, out);
                            _jettag_c_setVariable_315_4.doEnd();
                            RuntimeTagElement _jettag_c_setVariable_316_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_316_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_316_4.setRuntimeParent(_jettag_c_iterate_312_8);
                            _jettag_c_setVariable_316_4.setTagInfo(_td_c_setVariable_316_4);
                            _jettag_c_setVariable_316_4.doStart(context, out);
                            _jettag_c_setVariable_316_4.doEnd();
                            //process generizations 
                            RuntimeTagElement _jettag_c_iterate_318_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_318_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_318_4.setRuntimeParent(_jettag_c_iterate_312_8);
                            _jettag_c_iterate_318_4.setTagInfo(_td_c_iterate_318_4);
                            _jettag_c_iterate_318_4.doStart(context, out);
                            while (_jettag_c_iterate_318_4.okToProcessBody()) {
                                // if child class
                                RuntimeTagElement _jettag_c_if_320_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_320_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_320_5.setRuntimeParent(_jettag_c_iterate_318_4);
                                _jettag_c_if_320_5.setTagInfo(_td_c_if_320_5);
                                _jettag_c_if_320_5.doStart(context, out);
                                while (_jettag_c_if_320_5.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_iterate_321_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_321_6); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_321_6.setRuntimeParent(_jettag_c_if_320_5);
                                    _jettag_c_iterate_321_6.setTagInfo(_td_c_iterate_321_6);
                                    _jettag_c_iterate_321_6.doStart(context, out);
                                    while (_jettag_c_iterate_321_6.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_if_322_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_322_9); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_322_9.setRuntimeParent(_jettag_c_iterate_321_6);
                                        _jettag_c_if_322_9.setTagInfo(_td_c_if_322_9);
                                        _jettag_c_if_322_9.doStart(context, out);
                                        while (_jettag_c_if_322_9.okToProcessBody()) {
                                            // get level 1 parent
                                            RuntimeTagElement _jettag_c_setVariable_324_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_324_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_324_9.setRuntimeParent(_jettag_c_if_322_9);
                                            _jettag_c_setVariable_324_9.setTagInfo(_td_c_setVariable_324_9);
                                            _jettag_c_setVariable_324_9.doStart(context, out);
                                            _jettag_c_setVariable_324_9.doEnd();
                                            // second round to get level 2 
                                            RuntimeTagElement _jettag_c_iterate_326_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_326_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_iterate_326_9.setRuntimeParent(_jettag_c_if_322_9);
                                            _jettag_c_iterate_326_9.setTagInfo(_td_c_iterate_326_9);
                                            _jettag_c_iterate_326_9.doStart(context, out);
                                            while (_jettag_c_iterate_326_9.okToProcessBody()) {
                                                // if child class
                                                RuntimeTagElement _jettag_c_if_328_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_328_10); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_328_10.setRuntimeParent(_jettag_c_iterate_326_9);
                                                _jettag_c_if_328_10.setTagInfo(_td_c_if_328_10);
                                                _jettag_c_if_328_10.doStart(context, out);
                                                while (_jettag_c_if_328_10.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_iterate_329_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_329_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_329_11.setRuntimeParent(_jettag_c_if_328_10);
                                                    _jettag_c_iterate_329_11.setTagInfo(_td_c_iterate_329_11);
                                                    _jettag_c_iterate_329_11.doStart(context, out);
                                                    while (_jettag_c_iterate_329_11.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_330_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_330_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_330_14.setRuntimeParent(_jettag_c_iterate_329_11);
                                                        _jettag_c_if_330_14.setTagInfo(_td_c_if_330_14);
                                                        _jettag_c_if_330_14.doStart(context, out);
                                                        while (_jettag_c_if_330_14.okToProcessBody()) {
                                                            // get level 2 parent
                                                            RuntimeTagElement _jettag_c_setVariable_332_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_332_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_setVariable_332_14.setRuntimeParent(_jettag_c_if_330_14);
                                                            _jettag_c_setVariable_332_14.setTagInfo(_td_c_setVariable_332_14);
                                                            _jettag_c_setVariable_332_14.doStart(context, out);
                                                            _jettag_c_setVariable_332_14.doEnd();
                                                            _jettag_c_if_330_14.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_330_14.doEnd();
                                                        _jettag_c_iterate_329_11.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_329_11.doEnd();
                                                    _jettag_c_if_328_10.handleBodyContent(out);
                                                }
                                                _jettag_c_if_328_10.doEnd();
                                                _jettag_c_iterate_326_9.handleBodyContent(out);
                                            }
                                            _jettag_c_iterate_326_9.doEnd();
                                            out.write("\t\t\t\t\t\t\t\t  \t\t\t\t\t\t\t\t\t \t\t\t\t");  //$NON-NLS-1$        
                                            out.write(NL);         
                                            _jettag_c_if_322_9.handleBodyContent(out);
                                        }
                                        _jettag_c_if_322_9.doEnd();
                                        _jettag_c_iterate_321_6.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_321_6.doEnd();
                                    _jettag_c_if_320_5.handleBodyContent(out);
                                }
                                _jettag_c_if_320_5.doEnd();
                                _jettag_c_iterate_318_4.handleBodyContent(out);
                            }
                            _jettag_c_iterate_318_4.doEnd();
                            // CRUD and search panels
                            // check to see if this is not a abstract class
                            RuntimeTagElement _jettag_c_if_344_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_344_8); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_344_8.setRuntimeParent(_jettag_c_iterate_312_8);
                            _jettag_c_if_344_8.setTagInfo(_td_c_if_344_8);
                            _jettag_c_if_344_8.doStart(context, out);
                            while (_jettag_c_if_344_8.okToProcessBody()) {
                                RuntimeTagElement _jettag_ws_folder_345_8 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_345_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_ws_folder_345_8.setRuntimeParent(_jettag_c_if_344_8);
                                _jettag_ws_folder_345_8.setTagInfo(_td_ws_folder_345_8);
                                _jettag_ws_folder_345_8.doStart(context, out);
                                while (_jettag_ws_folder_345_8.okToProcessBody()) {
                                    //rpc sync class 
                                    out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                                    RuntimeTagElement _jettag_ws_file_347_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_347_6); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_ws_file_347_6.setRuntimeParent(_jettag_ws_folder_345_8);
                                    _jettag_ws_file_347_6.setTagInfo(_td_ws_file_347_6);
                                    _jettag_ws_file_347_6.doStart(context, out);
                                    _jettag_ws_file_347_6.doEnd();
                                    out.write(NL);         
                                    //rpc async class 
                                    out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                                    RuntimeTagElement _jettag_ws_file_349_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_349_6); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_ws_file_349_6.setRuntimeParent(_jettag_ws_folder_345_8);
                                    _jettag_ws_file_349_6.setTagInfo(_td_ws_file_349_6);
                                    _jettag_ws_file_349_6.doStart(context, out);
                                    _jettag_ws_file_349_6.doEnd();
                                    out.write(NL);         
                                    //request factory entity proxy class 
                                    out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                                    RuntimeTagElement _jettag_ws_file_351_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_351_6); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_ws_file_351_6.setRuntimeParent(_jettag_ws_folder_345_8);
                                    _jettag_ws_file_351_6.setTagInfo(_td_ws_file_351_6);
                                    _jettag_ws_file_351_6.doStart(context, out);
                                    _jettag_ws_file_351_6.doEnd();
                                    out.write("\t");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    //request factory entity request class 
                                    out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                                    RuntimeTagElement _jettag_ws_file_353_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_353_6); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_ws_file_353_6.setRuntimeParent(_jettag_ws_folder_345_8);
                                    _jettag_ws_file_353_6.setTagInfo(_td_ws_file_353_6);
                                    _jettag_ws_file_353_6.doStart(context, out);
                                    _jettag_ws_file_353_6.doEnd();
                                    out.write("\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    // Create Entity Panel
                                    //<ws:file  path="Create{$class/@name}Panel.java" template="templates/web/gwt/client/entity/web_create_panel_template.java.jet"/>
                                    out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                                    RuntimeTagElement _jettag_ws_file_356_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_356_6); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_ws_file_356_6.setRuntimeParent(_jettag_ws_folder_345_8);
                                    _jettag_ws_file_356_6.setTagInfo(_td_ws_file_356_6);
                                    _jettag_ws_file_356_6.doStart(context, out);
                                    _jettag_ws_file_356_6.doEnd();
                                    out.write(NL);         
                                    // Generic Search Panel
                                    out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                                    RuntimeTagElement _jettag_ws_file_358_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_358_6); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_ws_file_358_6.setRuntimeParent(_jettag_ws_folder_345_8);
                                    _jettag_ws_file_358_6.setTagInfo(_td_ws_file_358_6);
                                    _jettag_ws_file_358_6.doStart(context, out);
                                    _jettag_ws_file_358_6.doEnd();
                                    out.write(NL);         
                                    // Read Panel
                                    //<ws:file  path="Read${$class/@name}Panel.java" template="templates/web/gwt/client/entity/web_read_panel_template.java.jet"/>
                                    out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                                    RuntimeTagElement _jettag_ws_file_361_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_361_6); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_ws_file_361_6.setRuntimeParent(_jettag_ws_folder_345_8);
                                    _jettag_ws_file_361_6.setTagInfo(_td_ws_file_361_6);
                                    _jettag_ws_file_361_6.doStart(context, out);
                                    _jettag_ws_file_361_6.doEnd();
                                    out.write(NL);         
                                    // Update Panel
                                    //<ws:file  path="Update${$class/@name}Panel.java" template="templates/web/gwt/client/entity/web_update_panel_template.java.jet"/>
                                    out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                                    RuntimeTagElement _jettag_ws_file_364_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_364_6); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_ws_file_364_6.setRuntimeParent(_jettag_ws_folder_345_8);
                                    _jettag_ws_file_364_6.setTagInfo(_td_ws_file_364_6);
                                    _jettag_ws_file_364_6.doStart(context, out);
                                    _jettag_ws_file_364_6.doEnd();
                                    out.write(NL);         
                                    // Side  Panel
                                    out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                                    RuntimeTagElement _jettag_ws_file_366_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_366_6); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_ws_file_366_6.setRuntimeParent(_jettag_ws_folder_345_8);
                                    _jettag_ws_file_366_6.setTagInfo(_td_ws_file_366_6);
                                    _jettag_ws_file_366_6.doStart(context, out);
                                    _jettag_ws_file_366_6.doEnd();
                                    out.write(NL);         
                                    // Options Panel
                                    out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                                    RuntimeTagElement _jettag_ws_file_368_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_368_6); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_ws_file_368_6.setRuntimeParent(_jettag_ws_folder_345_8);
                                    _jettag_ws_file_368_6.setTagInfo(_td_ws_file_368_6);
                                    _jettag_ws_file_368_6.doStart(context, out);
                                    _jettag_ws_file_368_6.doEnd();
                                    out.write(NL);         
                                    // Select Panel
                                    out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                                    RuntimeTagElement _jettag_ws_file_370_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_370_6); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_ws_file_370_6.setRuntimeParent(_jettag_ws_folder_345_8);
                                    _jettag_ws_file_370_6.setTagInfo(_td_ws_file_370_6);
                                    _jettag_ws_file_370_6.doStart(context, out);
                                    _jettag_ws_file_370_6.doEnd();
                                    out.write(NL);         
                                    out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    // check for parent(abstract) classes
                                    RuntimeTagElement _jettag_c_setVariable_373_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_373_7); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_373_7.setRuntimeParent(_jettag_ws_folder_345_8);
                                    _jettag_c_setVariable_373_7.setTagInfo(_td_c_setVariable_373_7);
                                    _jettag_c_setVariable_373_7.doStart(context, out);
                                    _jettag_c_setVariable_373_7.doEnd();
                                    RuntimeTagElement _jettag_c_iterate_374_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_374_7); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_374_7.setRuntimeParent(_jettag_ws_folder_345_8);
                                    _jettag_c_iterate_374_7.setTagInfo(_td_c_iterate_374_7);
                                    _jettag_c_iterate_374_7.doStart(context, out);
                                    while (_jettag_c_iterate_374_7.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_if_375_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_375_8); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_375_8.setRuntimeParent(_jettag_c_iterate_374_7);
                                        _jettag_c_if_375_8.setTagInfo(_td_c_if_375_8);
                                        _jettag_c_if_375_8.doStart(context, out);
                                        while (_jettag_c_if_375_8.okToProcessBody()) {
                                            // update flag variable
                                            RuntimeTagElement _jettag_c_setVariable_377_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_377_8); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_377_8.setRuntimeParent(_jettag_c_if_375_8);
                                            _jettag_c_setVariable_377_8.setTagInfo(_td_c_setVariable_377_8);
                                            _jettag_c_setVariable_377_8.doStart(context, out);
                                            _jettag_c_setVariable_377_8.doEnd();
                                            _jettag_c_if_375_8.handleBodyContent(out);
                                        }
                                        _jettag_c_if_375_8.doEnd();
                                        _jettag_c_iterate_374_7.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_374_7.doEnd();
                                    // if class is a Parent class
                                    RuntimeTagElement _jettag_c_if_381_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_381_11); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_381_11.setRuntimeParent(_jettag_ws_folder_345_8);
                                    _jettag_c_if_381_11.setTagInfo(_td_c_if_381_11);
                                    _jettag_c_if_381_11.doStart(context, out);
                                    while (_jettag_c_if_381_11.okToProcessBody()) {
                                        // Tree  Panel 
                                        // 	<ws:file  path="TreeAbstract${$class/@name}Panel.java" template="templates/web/gwt/client/entity/web_tree_abstract_panel_template.java.jet"/>
                                        out.write("\t\t\t    \t\t \t");  //$NON-NLS-1$        
                                        RuntimeTagElement _jettag_ws_file_384_12 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_384_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_ws_file_384_12.setRuntimeParent(_jettag_c_if_381_11);
                                        _jettag_ws_file_384_12.setTagInfo(_td_ws_file_384_12);
                                        _jettag_ws_file_384_12.doStart(context, out);
                                        _jettag_ws_file_384_12.doEnd();
                                        out.write(NL);         
                                        // Read All Entities Panel
                                        //	<ws:file  path="ReadAll{$class/@name}sPanel.java" template="templates/web/gwt/client/entity/web_readall_abstract_panel_template.java.jet"/>
                                        out.write("\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                        RuntimeTagElement _jettag_ws_file_387_8 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_387_8); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_ws_file_387_8.setRuntimeParent(_jettag_c_if_381_11);
                                        _jettag_ws_file_387_8.setTagInfo(_td_ws_file_387_8);
                                        _jettag_ws_file_387_8.doStart(context, out);
                                        _jettag_ws_file_387_8.doEnd();
                                        out.write("\t\t");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_381_11.handleBodyContent(out);
                                    }
                                    _jettag_c_if_381_11.doEnd();
                                    // if class is a regular  class
                                    RuntimeTagElement _jettag_c_if_390_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_390_7); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_390_7.setRuntimeParent(_jettag_ws_folder_345_8);
                                    _jettag_c_if_390_7.setTagInfo(_td_c_if_390_7);
                                    _jettag_c_if_390_7.doStart(context, out);
                                    while (_jettag_c_if_390_7.okToProcessBody()) {
                                        // Tree  Panel 
                                        //	<ws:file  path="Tree${$class/@name}Panel.java" template="templates/web/gwt/client/entity/web_tree_panel_template.java.jet"/>
                                        out.write("\t\t\t    \t\t \t");  //$NON-NLS-1$        
                                        RuntimeTagElement _jettag_ws_file_393_12 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_393_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_ws_file_393_12.setRuntimeParent(_jettag_c_if_390_7);
                                        _jettag_ws_file_393_12.setTagInfo(_td_ws_file_393_12);
                                        _jettag_ws_file_393_12.doStart(context, out);
                                        _jettag_ws_file_393_12.doEnd();
                                        out.write(NL);         
                                        // Read All Entities Panel
                                        //<ws:file  path="ReadAll{$class/@name}sPanel.java" template="templates/web/gwt/client/entity/web_readall_panel_template.java.jet"/>
                                        out.write("\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                        RuntimeTagElement _jettag_ws_file_396_8 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_396_8); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_ws_file_396_8.setRuntimeParent(_jettag_c_if_390_7);
                                        _jettag_ws_file_396_8.setTagInfo(_td_ws_file_396_8);
                                        _jettag_ws_file_396_8.doStart(context, out);
                                        _jettag_ws_file_396_8.doEnd();
                                        out.write("\t\t");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_390_7.handleBodyContent(out);
                                    }
                                    _jettag_c_if_390_7.doEnd();
                                    out.write("\t\t\t\t\t\t");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_ws_folder_345_8.handleBodyContent(out);
                                }
                                _jettag_ws_folder_345_8.doEnd();
                                //service class impl 
                                RuntimeTagElement _jettag_ws_folder_401_7 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_401_7); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_ws_folder_401_7.setRuntimeParent(_jettag_c_if_344_8);
                                _jettag_ws_folder_401_7.setTagInfo(_td_ws_folder_401_7);
                                _jettag_ws_folder_401_7.doStart(context, out);
                                while (_jettag_ws_folder_401_7.okToProcessBody()) {
                                    out.write("\t    \t\t");  //$NON-NLS-1$        
                                    RuntimeTagElement _jettag_ws_file_402_8 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_402_8); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_ws_file_402_8.setRuntimeParent(_jettag_ws_folder_401_7);
                                    _jettag_ws_file_402_8.setTagInfo(_td_ws_file_402_8);
                                    _jettag_ws_file_402_8.doStart(context, out);
                                    _jettag_ws_file_402_8.doEnd();
                                    out.write(NL);         
                                    _jettag_ws_folder_401_7.handleBodyContent(out);
                                }
                                _jettag_ws_folder_401_7.doEnd();
                                //generic entity locator 
                                RuntimeTagElement _jettag_ws_folder_405_7 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_405_7); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_ws_folder_405_7.setRuntimeParent(_jettag_c_if_344_8);
                                _jettag_ws_folder_405_7.setTagInfo(_td_ws_folder_405_7);
                                _jettag_ws_folder_405_7.doStart(context, out);
                                while (_jettag_ws_folder_405_7.okToProcessBody()) {
                                    //GWT entityDAO classes 
                                    out.write("\t    \t\t");  //$NON-NLS-1$        
                                    RuntimeTagElement _jettag_ws_file_407_8 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_407_8); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_ws_file_407_8.setRuntimeParent(_jettag_ws_folder_405_7);
                                    _jettag_ws_file_407_8.setTagInfo(_td_ws_file_407_8);
                                    _jettag_ws_file_407_8.doStart(context, out);
                                    _jettag_ws_file_407_8.doEnd();
                                    out.write(NL);         
                                    //TODO remove after moved to different package
                                    out.write("\t    \t\t");  //$NON-NLS-1$        
                                    RuntimeTagElement _jettag_ws_file_409_8 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_409_8); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_ws_file_409_8.setRuntimeParent(_jettag_ws_folder_405_7);
                                    _jettag_ws_file_409_8.setTagInfo(_td_ws_file_409_8);
                                    _jettag_ws_file_409_8.doStart(context, out);
                                    _jettag_ws_file_409_8.doEnd();
                                    out.write(NL);         
                                    _jettag_ws_folder_405_7.handleBodyContent(out);
                                }
                                _jettag_ws_folder_405_7.doEnd();
                                _jettag_c_if_344_8.handleBodyContent(out);
                            }
                            _jettag_c_if_344_8.doEnd();
                            _jettag_c_iterate_312_8.handleBodyContent(out);
                        }
                        _jettag_c_iterate_312_8.doEnd();
                        _jettag_c_iterate_310_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_310_6.doEnd();
                    _jettag_ws_folder_257_5.handleBodyContent(out);
                }
                _jettag_ws_folder_257_5.doEnd();
                RuntimeTagElement _jettag_ws_folder_415_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_415_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_415_5.setRuntimeParent(_jettag_ws_project_253_1);
                _jettag_ws_folder_415_5.setTagInfo(_td_ws_folder_415_5);
                _jettag_ws_folder_415_5.doStart(context, out);
                while (_jettag_ws_folder_415_5.okToProcessBody()) {
                    out.write("     ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_416_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_416_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_416_6.setRuntimeParent(_jettag_ws_folder_415_5);
                    _jettag_ws_file_416_6.setTagInfo(_td_ws_file_416_6);
                    _jettag_ws_file_416_6.doStart(context, out);
                    _jettag_ws_file_416_6.doEnd();
                    out.write(NL);         
                    out.write("     ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_417_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_417_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_417_6.setRuntimeParent(_jettag_ws_folder_415_5);
                    _jettag_ws_file_417_6.setTagInfo(_td_ws_file_417_6);
                    _jettag_ws_file_417_6.doStart(context, out);
                    _jettag_ws_file_417_6.doEnd();
                    out.write(NL);         
                    _jettag_ws_folder_415_5.handleBodyContent(out);
                }
                _jettag_ws_folder_415_5.doEnd();
                RuntimeTagElement _jettag_ws_folder_419_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_419_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_419_5.setRuntimeParent(_jettag_ws_project_253_1);
                _jettag_ws_folder_419_5.setTagInfo(_td_ws_folder_419_5);
                _jettag_ws_folder_419_5.doStart(context, out);
                while (_jettag_ws_folder_419_5.okToProcessBody()) {
                    // main html file
                    out.write("    ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_421_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_421_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_421_5.setRuntimeParent(_jettag_ws_folder_419_5);
                    _jettag_ws_file_421_5.setTagInfo(_td_ws_file_421_5);
                    _jettag_ws_file_421_5.doStart(context, out);
                    _jettag_ws_file_421_5.doEnd();
                    out.write(NL);         
                    out.write("    ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_copyFile_422_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "copyFile", "ws:copyFile", _td_ws_copyFile_422_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_copyFile_422_5.setRuntimeParent(_jettag_ws_folder_419_5);
                    _jettag_ws_copyFile_422_5.setTagInfo(_td_ws_copyFile_422_5);
                    _jettag_ws_copyFile_422_5.doStart(context, out);
                    _jettag_ws_copyFile_422_5.doEnd();
                    out.write(NL);         
                    RuntimeTagElement _jettag_ws_folder_423_7 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_423_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_folder_423_7.setRuntimeParent(_jettag_ws_folder_419_5);
                    _jettag_ws_folder_423_7.setTagInfo(_td_ws_folder_423_7);
                    _jettag_ws_folder_423_7.doStart(context, out);
                    while (_jettag_ws_folder_423_7.okToProcessBody()) {
                        out.write("    \t \t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_424_8 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_424_8); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_424_8.setRuntimeParent(_jettag_ws_folder_423_7);
                        _jettag_ws_file_424_8.setTagInfo(_td_ws_file_424_8);
                        _jettag_ws_file_424_8.doStart(context, out);
                        _jettag_ws_file_424_8.doEnd();
                        out.write(NL);         
                        //	<ws:file template="templates/web/webapp/WEB-INF/webapp_jboss-web.xml.jet" path="jboss-web.xml"/> 
                        out.write("    \t \t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_426_8 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_426_8); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_426_8.setRuntimeParent(_jettag_ws_folder_423_7);
                        _jettag_ws_file_426_8.setTagInfo(_td_ws_file_426_8);
                        _jettag_ws_file_426_8.doStart(context, out);
                        _jettag_ws_file_426_8.doEnd();
                        out.write(NL);         
                        _jettag_ws_folder_423_7.handleBodyContent(out);
                    }
                    _jettag_ws_folder_423_7.doEnd();
                    out.write("    \t\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_ws_folder_419_5.handleBodyContent(out);
                }
                _jettag_ws_folder_419_5.doEnd();
                RuntimeTagElement _jettag_ws_folder_430_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_430_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_430_5.setRuntimeParent(_jettag_ws_project_253_1);
                _jettag_ws_folder_430_5.setTagInfo(_td_ws_folder_430_5);
                _jettag_ws_folder_430_5.doStart(context, out);
                while (_jettag_ws_folder_430_5.okToProcessBody()) {
                    //server test class
                    RuntimeTagElement _jettag_ws_folder_432_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_432_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_folder_432_5.setRuntimeParent(_jettag_ws_folder_430_5);
                    _jettag_ws_folder_432_5.setTagInfo(_td_ws_folder_432_5);
                    _jettag_ws_folder_432_5.doStart(context, out);
                    while (_jettag_ws_folder_432_5.okToProcessBody()) {
                        out.write("    ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_433_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_433_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_433_5.setRuntimeParent(_jettag_ws_folder_432_5);
                        _jettag_ws_file_433_5.setTagInfo(_td_ws_file_433_5);
                        _jettag_ws_file_433_5.doStart(context, out);
                        _jettag_ws_file_433_5.doEnd();
                        out.write(NL);         
                        _jettag_ws_folder_432_5.handleBodyContent(out);
                    }
                    _jettag_ws_folder_432_5.doEnd();
                    _jettag_ws_folder_430_5.handleBodyContent(out);
                }
                _jettag_ws_folder_430_5.doEnd();
                RuntimeTagElement _jettag_ws_folder_436_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_436_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_436_5.setRuntimeParent(_jettag_ws_project_253_1);
                _jettag_ws_folder_436_5.setTagInfo(_td_ws_folder_436_5);
                _jettag_ws_folder_436_5.doStart(context, out);
                _jettag_ws_folder_436_5.doEnd();
                //copy seamgwt2 fix classes
                out.write("    ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_ws_copyFile_438_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "copyFile", "ws:copyFile", _td_ws_copyFile_438_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_copyFile_438_5.setRuntimeParent(_jettag_ws_project_253_1);
                _jettag_ws_copyFile_438_5.setTagInfo(_td_ws_copyFile_438_5);
                _jettag_ws_copyFile_438_5.doStart(context, out);
                _jettag_ws_copyFile_438_5.doEnd();
                out.write(NL);         
                out.write("    ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_ws_copyFile_439_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "copyFile", "ws:copyFile", _td_ws_copyFile_439_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_copyFile_439_5.setRuntimeParent(_jettag_ws_project_253_1);
                _jettag_ws_copyFile_439_5.setTagInfo(_td_ws_copyFile_439_5);
                _jettag_ws_copyFile_439_5.doStart(context, out);
                _jettag_ws_copyFile_439_5.doEnd();
                out.write(NL);         
                out.write("    ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_ws_copyFile_440_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "copyFile", "ws:copyFile", _td_ws_copyFile_440_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_copyFile_440_5.setRuntimeParent(_jettag_ws_project_253_1);
                _jettag_ws_copyFile_440_5.setTagInfo(_td_ws_copyFile_440_5);
                _jettag_ws_copyFile_440_5.doStart(context, out);
                _jettag_ws_copyFile_440_5.doEnd();
                out.write(NL);         
                out.write("    ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_ws_copyFile_441_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "copyFile", "ws:copyFile", _td_ws_copyFile_441_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_copyFile_441_5.setRuntimeParent(_jettag_ws_project_253_1);
                _jettag_ws_copyFile_441_5.setTagInfo(_td_ws_copyFile_441_5);
                _jettag_ws_copyFile_441_5.doStart(context, out);
                _jettag_ws_copyFile_441_5.doEnd();
                out.write(NL);         
                out.write("    ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_ws_copyFile_442_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "copyFile", "ws:copyFile", _td_ws_copyFile_442_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_copyFile_442_5.setRuntimeParent(_jettag_ws_project_253_1);
                _jettag_ws_copyFile_442_5.setTagInfo(_td_ws_copyFile_442_5);
                _jettag_ws_copyFile_442_5.doStart(context, out);
                _jettag_ws_copyFile_442_5.doEnd();
                out.write(NL);         
                _jettag_ws_project_253_1.handleBodyContent(out);
            }
            _jettag_ws_project_253_1.doEnd();
            _jettag_c_if_252_1.handleBodyContent(out);
        }
        _jettag_c_if_252_1.doEnd();
        out.write(NL);         
        //creates the REST JAR for SOA project
        RuntimeTagElement _jettag_c_if_447_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_447_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_447_1.setRuntimeParent(null);
        _jettag_c_if_447_1.setTagInfo(_td_c_if_447_1);
        _jettag_c_if_447_1.doStart(context, out);
        while (_jettag_c_if_447_1.okToProcessBody()) {
            RuntimeTagElement _jettag_ws_project_448_1 = context.getTagFactory().createRuntimeTag(_jetns_ws, "project", "ws:project", _td_ws_project_448_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_ws_project_448_1.setRuntimeParent(_jettag_c_if_447_1);
            _jettag_ws_project_448_1.setTagInfo(_td_ws_project_448_1);
            _jettag_ws_project_448_1.doStart(context, out);
            while (_jettag_ws_project_448_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_if_449_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_449_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_449_2.setRuntimeParent(_jettag_ws_project_448_1);
                _jettag_c_if_449_2.setTagInfo(_td_c_if_449_2);
                _jettag_c_if_449_2.doStart(context, out);
                while (_jettag_c_if_449_2.okToProcessBody()) {
                    out.write("\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_450_2 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_450_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_450_2.setRuntimeParent(_jettag_c_if_449_2);
                    _jettag_ws_file_450_2.setTagInfo(_td_ws_file_450_2);
                    _jettag_ws_file_450_2.doStart(context, out);
                    _jettag_ws_file_450_2.doEnd();
                    out.write(NL);         
                    _jettag_c_if_449_2.handleBodyContent(out);
                }
                _jettag_c_if_449_2.doEnd();
                RuntimeTagElement _jettag_ws_folder_452_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_452_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_452_5.setRuntimeParent(_jettag_ws_project_448_1);
                _jettag_ws_folder_452_5.setTagInfo(_td_ws_folder_452_5);
                _jettag_ws_folder_452_5.doStart(context, out);
                while (_jettag_ws_folder_452_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_ws_folder_453_4 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_453_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_folder_453_4.setRuntimeParent(_jettag_ws_folder_452_5);
                    _jettag_ws_folder_453_4.setTagInfo(_td_ws_folder_453_4);
                    _jettag_ws_folder_453_4.doStart(context, out);
                    while (_jettag_ws_folder_453_4.okToProcessBody()) {
                        // rest service class
                        out.write("\t\t\t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_455_4 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_455_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_455_4.setRuntimeParent(_jettag_ws_folder_453_4);
                        _jettag_ws_file_455_4.setTagInfo(_td_ws_file_455_4);
                        _jettag_ws_file_455_4.doStart(context, out);
                        _jettag_ws_file_455_4.doEnd();
                        out.write(NL);         
                        _jettag_ws_folder_453_4.handleBodyContent(out);
                    }
                    _jettag_ws_folder_453_4.doEnd();
                    // Iterate through packages and classes 
                    RuntimeTagElement _jettag_c_iterate_458_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_458_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_458_6.setRuntimeParent(_jettag_ws_folder_452_5);
                    _jettag_c_iterate_458_6.setTagInfo(_td_c_iterate_458_6);
                    _jettag_c_iterate_458_6.doStart(context, out);
                    while (_jettag_c_iterate_458_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_459_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_459_7); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_459_7.setRuntimeParent(_jettag_c_iterate_458_6);
                        _jettag_c_iterate_459_7.setTagInfo(_td_c_iterate_459_7);
                        _jettag_c_iterate_459_7.doStart(context, out);
                        while (_jettag_c_iterate_459_7.okToProcessBody()) {
                            // process generizations upto 2 levels and get teh parent classes if any
                            RuntimeTagElement _jettag_c_setVariable_461_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_461_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_461_7.setRuntimeParent(_jettag_c_iterate_459_7);
                            _jettag_c_setVariable_461_7.setTagInfo(_td_c_setVariable_461_7);
                            _jettag_c_setVariable_461_7.doStart(context, out);
                            _jettag_c_setVariable_461_7.doEnd();
                            RuntimeTagElement _jettag_c_setVariable_462_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_462_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_462_4.setRuntimeParent(_jettag_c_iterate_459_7);
                            _jettag_c_setVariable_462_4.setTagInfo(_td_c_setVariable_462_4);
                            _jettag_c_setVariable_462_4.doStart(context, out);
                            _jettag_c_setVariable_462_4.doEnd();
                            RuntimeTagElement _jettag_c_setVariable_463_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_463_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_463_4.setRuntimeParent(_jettag_c_iterate_459_7);
                            _jettag_c_setVariable_463_4.setTagInfo(_td_c_setVariable_463_4);
                            _jettag_c_setVariable_463_4.doStart(context, out);
                            _jettag_c_setVariable_463_4.doEnd();
                            //process generizations 
                            RuntimeTagElement _jettag_c_iterate_465_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_465_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_465_4.setRuntimeParent(_jettag_c_iterate_459_7);
                            _jettag_c_iterate_465_4.setTagInfo(_td_c_iterate_465_4);
                            _jettag_c_iterate_465_4.doStart(context, out);
                            while (_jettag_c_iterate_465_4.okToProcessBody()) {
                                // if child class
                                RuntimeTagElement _jettag_c_if_467_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_467_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_467_5.setRuntimeParent(_jettag_c_iterate_465_4);
                                _jettag_c_if_467_5.setTagInfo(_td_c_if_467_5);
                                _jettag_c_if_467_5.doStart(context, out);
                                while (_jettag_c_if_467_5.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_iterate_468_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_468_6); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_468_6.setRuntimeParent(_jettag_c_if_467_5);
                                    _jettag_c_iterate_468_6.setTagInfo(_td_c_iterate_468_6);
                                    _jettag_c_iterate_468_6.doStart(context, out);
                                    while (_jettag_c_iterate_468_6.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_if_469_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_469_9); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_469_9.setRuntimeParent(_jettag_c_iterate_468_6);
                                        _jettag_c_if_469_9.setTagInfo(_td_c_if_469_9);
                                        _jettag_c_if_469_9.doStart(context, out);
                                        while (_jettag_c_if_469_9.okToProcessBody()) {
                                            // get level 1 parent
                                            RuntimeTagElement _jettag_c_setVariable_471_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_471_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_471_9.setRuntimeParent(_jettag_c_if_469_9);
                                            _jettag_c_setVariable_471_9.setTagInfo(_td_c_setVariable_471_9);
                                            _jettag_c_setVariable_471_9.doStart(context, out);
                                            _jettag_c_setVariable_471_9.doEnd();
                                            // second round to get level 2 
                                            RuntimeTagElement _jettag_c_iterate_473_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_473_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_iterate_473_9.setRuntimeParent(_jettag_c_if_469_9);
                                            _jettag_c_iterate_473_9.setTagInfo(_td_c_iterate_473_9);
                                            _jettag_c_iterate_473_9.doStart(context, out);
                                            while (_jettag_c_iterate_473_9.okToProcessBody()) {
                                                // if child class
                                                RuntimeTagElement _jettag_c_if_475_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_475_10); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_475_10.setRuntimeParent(_jettag_c_iterate_473_9);
                                                _jettag_c_if_475_10.setTagInfo(_td_c_if_475_10);
                                                _jettag_c_if_475_10.doStart(context, out);
                                                while (_jettag_c_if_475_10.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_iterate_476_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_476_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_476_11.setRuntimeParent(_jettag_c_if_475_10);
                                                    _jettag_c_iterate_476_11.setTagInfo(_td_c_iterate_476_11);
                                                    _jettag_c_iterate_476_11.doStart(context, out);
                                                    while (_jettag_c_iterate_476_11.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_477_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_477_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_477_14.setRuntimeParent(_jettag_c_iterate_476_11);
                                                        _jettag_c_if_477_14.setTagInfo(_td_c_if_477_14);
                                                        _jettag_c_if_477_14.doStart(context, out);
                                                        while (_jettag_c_if_477_14.okToProcessBody()) {
                                                            // get level 2 parent
                                                            RuntimeTagElement _jettag_c_setVariable_479_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_479_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_setVariable_479_14.setRuntimeParent(_jettag_c_if_477_14);
                                                            _jettag_c_setVariable_479_14.setTagInfo(_td_c_setVariable_479_14);
                                                            _jettag_c_setVariable_479_14.doStart(context, out);
                                                            _jettag_c_setVariable_479_14.doEnd();
                                                            _jettag_c_if_477_14.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_477_14.doEnd();
                                                        _jettag_c_iterate_476_11.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_476_11.doEnd();
                                                    _jettag_c_if_475_10.handleBodyContent(out);
                                                }
                                                _jettag_c_if_475_10.doEnd();
                                                _jettag_c_iterate_473_9.handleBodyContent(out);
                                            }
                                            _jettag_c_iterate_473_9.doEnd();
                                            out.write("\t\t\t\t\t\t\t\t  \t\t\t\t\t\t\t\t\t \t\t\t\t");  //$NON-NLS-1$        
                                            out.write(NL);         
                                            _jettag_c_if_469_9.handleBodyContent(out);
                                        }
                                        _jettag_c_if_469_9.doEnd();
                                        _jettag_c_iterate_468_6.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_468_6.doEnd();
                                    _jettag_c_if_467_5.handleBodyContent(out);
                                }
                                _jettag_c_if_467_5.doEnd();
                                _jettag_c_iterate_465_4.handleBodyContent(out);
                            }
                            _jettag_c_iterate_465_4.doEnd();
                            RuntimeTagElement _jettag_ws_folder_489_4 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_489_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_ws_folder_489_4.setRuntimeParent(_jettag_c_iterate_459_7);
                            _jettag_ws_folder_489_4.setTagInfo(_td_ws_folder_489_4);
                            _jettag_ws_folder_489_4.doStart(context, out);
                            while (_jettag_ws_folder_489_4.okToProcessBody()) {
                                // rest service class
                                out.write("\t\t\t");  //$NON-NLS-1$        
                                RuntimeTagElement _jettag_ws_file_491_4 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_491_4); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_ws_file_491_4.setRuntimeParent(_jettag_ws_folder_489_4);
                                _jettag_ws_file_491_4.setTagInfo(_td_ws_file_491_4);
                                _jettag_ws_file_491_4.doStart(context, out);
                                _jettag_ws_file_491_4.doEnd();
                                out.write(NL);         
                                _jettag_ws_folder_489_4.handleBodyContent(out);
                            }
                            _jettag_ws_folder_489_4.doEnd();
                            _jettag_c_iterate_459_7.handleBodyContent(out);
                        }
                        _jettag_c_iterate_459_7.doEnd();
                        _jettag_c_iterate_458_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_458_6.doEnd();
                    _jettag_ws_folder_452_5.handleBodyContent(out);
                }
                _jettag_ws_folder_452_5.doEnd();
                RuntimeTagElement _jettag_ws_folder_496_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_496_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_496_5.setRuntimeParent(_jettag_ws_project_448_1);
                _jettag_ws_folder_496_5.setTagInfo(_td_ws_folder_496_5);
                _jettag_ws_folder_496_5.doStart(context, out);
                while (_jettag_ws_folder_496_5.okToProcessBody()) {
                    out.write("    ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_497_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_497_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_497_5.setRuntimeParent(_jettag_ws_folder_496_5);
                    _jettag_ws_file_497_5.setTagInfo(_td_ws_file_497_5);
                    _jettag_ws_file_497_5.doStart(context, out);
                    _jettag_ws_file_497_5.doEnd();
                    out.write(NL);         
                    out.write("     ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_498_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_498_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_498_6.setRuntimeParent(_jettag_ws_folder_496_5);
                    _jettag_ws_file_498_6.setTagInfo(_td_ws_file_498_6);
                    _jettag_ws_file_498_6.doStart(context, out);
                    _jettag_ws_file_498_6.doEnd();
                    out.write(NL);         
                    _jettag_ws_folder_496_5.handleBodyContent(out);
                }
                _jettag_ws_folder_496_5.doEnd();
                _jettag_ws_project_448_1.handleBodyContent(out);
            }
            _jettag_ws_project_448_1.doEnd();
            _jettag_c_if_447_1.handleBodyContent(out);
        }
        _jettag_c_if_447_1.doEnd();
        //creates the Android project
        RuntimeTagElement _jettag_c_if_503_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_503_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_503_1.setRuntimeParent(null);
        _jettag_c_if_503_1.setTagInfo(_td_c_if_503_1);
        _jettag_c_if_503_1.doStart(context, out);
        while (_jettag_c_if_503_1.okToProcessBody()) {
            RuntimeTagElement _jettag_ws_project_504_1 = context.getTagFactory().createRuntimeTag(_jetns_ws, "project", "ws:project", _td_ws_project_504_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_ws_project_504_1.setRuntimeParent(_jettag_c_if_503_1);
            _jettag_ws_project_504_1.setTagInfo(_td_ws_project_504_1);
            _jettag_ws_project_504_1.doStart(context, out);
            while (_jettag_ws_project_504_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_if_505_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_505_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_505_2.setRuntimeParent(_jettag_ws_project_504_1);
                _jettag_c_if_505_2.setTagInfo(_td_c_if_505_2);
                _jettag_c_if_505_2.doStart(context, out);
                while (_jettag_c_if_505_2.okToProcessBody()) {
                    out.write("\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_506_2 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_506_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_506_2.setRuntimeParent(_jettag_c_if_505_2);
                    _jettag_ws_file_506_2.setTagInfo(_td_ws_file_506_2);
                    _jettag_ws_file_506_2.doStart(context, out);
                    _jettag_ws_file_506_2.doEnd();
                    out.write(NL);         
                    _jettag_c_if_505_2.handleBodyContent(out);
                }
                _jettag_c_if_505_2.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_ws_file_508_2 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_508_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_file_508_2.setRuntimeParent(_jettag_ws_project_504_1);
                _jettag_ws_file_508_2.setTagInfo(_td_ws_file_508_2);
                _jettag_ws_file_508_2.doStart(context, out);
                _jettag_ws_file_508_2.doEnd();
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_ws_file_509_2 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_509_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_file_509_2.setRuntimeParent(_jettag_ws_project_504_1);
                _jettag_ws_file_509_2.setTagInfo(_td_ws_file_509_2);
                _jettag_ws_file_509_2.doStart(context, out);
                _jettag_ws_file_509_2.doEnd();
                out.write(NL);         
                RuntimeTagElement _jettag_ws_folder_510_2 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_510_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_510_2.setRuntimeParent(_jettag_ws_project_504_1);
                _jettag_ws_folder_510_2.setTagInfo(_td_ws_folder_510_2);
                _jettag_ws_folder_510_2.doStart(context, out);
                while (_jettag_ws_folder_510_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_ws_folder_511_3 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_511_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_folder_511_3.setRuntimeParent(_jettag_ws_folder_510_2);
                    _jettag_ws_folder_511_3.setTagInfo(_td_ws_folder_511_3);
                    _jettag_ws_folder_511_3.doStart(context, out);
                    while (_jettag_ws_folder_511_3.okToProcessBody()) {
                        out.write("\t\t\t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_ws_file_512_4 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_512_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_file_512_4.setRuntimeParent(_jettag_ws_folder_511_3);
                        _jettag_ws_file_512_4.setTagInfo(_td_ws_file_512_4);
                        _jettag_ws_file_512_4.doStart(context, out);
                        _jettag_ws_file_512_4.doEnd();
                        out.write(NL);         
                        _jettag_ws_folder_511_3.handleBodyContent(out);
                    }
                    _jettag_ws_folder_511_3.doEnd();
                    _jettag_ws_folder_510_2.handleBodyContent(out);
                }
                _jettag_ws_folder_510_2.doEnd();
                //Iterate through the packages and classes
                RuntimeTagElement _jettag_c_iterate_516_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_516_9); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_516_9.setRuntimeParent(_jettag_ws_project_504_1);
                _jettag_c_iterate_516_9.setTagInfo(_td_c_iterate_516_9);
                _jettag_c_iterate_516_9.doStart(context, out);
                while (_jettag_c_iterate_516_9.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_517_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_517_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_517_7.setRuntimeParent(_jettag_c_iterate_516_9);
                    _jettag_c_iterate_517_7.setTagInfo(_td_c_iterate_517_7);
                    _jettag_c_iterate_517_7.doStart(context, out);
                    while (_jettag_c_iterate_517_7.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_setVariable_518_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_518_13); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_518_13.setRuntimeParent(_jettag_c_iterate_517_7);
                        _jettag_c_setVariable_518_13.setTagInfo(_td_c_setVariable_518_13);
                        _jettag_c_setVariable_518_13.doStart(context, out);
                        _jettag_c_setVariable_518_13.doEnd();
                        RuntimeTagElement _jettag_c_setVariable_519_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_519_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_519_4.setRuntimeParent(_jettag_c_iterate_517_7);
                        _jettag_c_setVariable_519_4.setTagInfo(_td_c_setVariable_519_4);
                        _jettag_c_setVariable_519_4.doStart(context, out);
                        _jettag_c_setVariable_519_4.doEnd();
                        RuntimeTagElement _jettag_c_setVariable_520_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_520_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_520_4.setRuntimeParent(_jettag_c_iterate_517_7);
                        _jettag_c_setVariable_520_4.setTagInfo(_td_c_setVariable_520_4);
                        _jettag_c_setVariable_520_4.doStart(context, out);
                        _jettag_c_setVariable_520_4.doEnd();
                        //process generizations 
                        RuntimeTagElement _jettag_c_iterate_522_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_522_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_522_4.setRuntimeParent(_jettag_c_iterate_517_7);
                        _jettag_c_iterate_522_4.setTagInfo(_td_c_iterate_522_4);
                        _jettag_c_iterate_522_4.doStart(context, out);
                        while (_jettag_c_iterate_522_4.okToProcessBody()) {
                            // if child class
                            RuntimeTagElement _jettag_c_if_524_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_524_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_524_5.setRuntimeParent(_jettag_c_iterate_522_4);
                            _jettag_c_if_524_5.setTagInfo(_td_c_if_524_5);
                            _jettag_c_if_524_5.doStart(context, out);
                            while (_jettag_c_if_524_5.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_iterate_525_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_525_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_525_6.setRuntimeParent(_jettag_c_if_524_5);
                                _jettag_c_iterate_525_6.setTagInfo(_td_c_iterate_525_6);
                                _jettag_c_iterate_525_6.doStart(context, out);
                                while (_jettag_c_iterate_525_6.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_526_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_526_9); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_526_9.setRuntimeParent(_jettag_c_iterate_525_6);
                                    _jettag_c_if_526_9.setTagInfo(_td_c_if_526_9);
                                    _jettag_c_if_526_9.doStart(context, out);
                                    while (_jettag_c_if_526_9.okToProcessBody()) {
                                        // get level 1 parent
                                        RuntimeTagElement _jettag_c_setVariable_528_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_528_9); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_528_9.setRuntimeParent(_jettag_c_if_526_9);
                                        _jettag_c_setVariable_528_9.setTagInfo(_td_c_setVariable_528_9);
                                        _jettag_c_setVariable_528_9.doStart(context, out);
                                        _jettag_c_setVariable_528_9.doEnd();
                                        // second round to get level 2 
                                        RuntimeTagElement _jettag_c_iterate_530_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_530_9); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_530_9.setRuntimeParent(_jettag_c_if_526_9);
                                        _jettag_c_iterate_530_9.setTagInfo(_td_c_iterate_530_9);
                                        _jettag_c_iterate_530_9.doStart(context, out);
                                        while (_jettag_c_iterate_530_9.okToProcessBody()) {
                                            // if child class
                                            RuntimeTagElement _jettag_c_if_532_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_532_10); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_532_10.setRuntimeParent(_jettag_c_iterate_530_9);
                                            _jettag_c_if_532_10.setTagInfo(_td_c_if_532_10);
                                            _jettag_c_if_532_10.doStart(context, out);
                                            while (_jettag_c_if_532_10.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_iterate_533_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_533_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_iterate_533_11.setRuntimeParent(_jettag_c_if_532_10);
                                                _jettag_c_iterate_533_11.setTagInfo(_td_c_iterate_533_11);
                                                _jettag_c_iterate_533_11.doStart(context, out);
                                                while (_jettag_c_iterate_533_11.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_534_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_534_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_534_14.setRuntimeParent(_jettag_c_iterate_533_11);
                                                    _jettag_c_if_534_14.setTagInfo(_td_c_if_534_14);
                                                    _jettag_c_if_534_14.doStart(context, out);
                                                    while (_jettag_c_if_534_14.okToProcessBody()) {
                                                        // get level 2 parent
                                                        RuntimeTagElement _jettag_c_setVariable_536_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_536_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_setVariable_536_14.setRuntimeParent(_jettag_c_if_534_14);
                                                        _jettag_c_setVariable_536_14.setTagInfo(_td_c_setVariable_536_14);
                                                        _jettag_c_setVariable_536_14.doStart(context, out);
                                                        _jettag_c_setVariable_536_14.doEnd();
                                                        _jettag_c_if_534_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_534_14.doEnd();
                                                    _jettag_c_iterate_533_11.handleBodyContent(out);
                                                }
                                                _jettag_c_iterate_533_11.doEnd();
                                                _jettag_c_if_532_10.handleBodyContent(out);
                                            }
                                            _jettag_c_if_532_10.doEnd();
                                            _jettag_c_iterate_530_9.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_530_9.doEnd();
                                        out.write("\t\t\t\t\t\t\t\t  \t\t\t\t\t\t\t\t\t \t\t\t\t");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_526_9.handleBodyContent(out);
                                    }
                                    _jettag_c_if_526_9.doEnd();
                                    _jettag_c_iterate_525_6.handleBodyContent(out);
                                }
                                _jettag_c_iterate_525_6.doEnd();
                                _jettag_c_if_524_5.handleBodyContent(out);
                            }
                            _jettag_c_if_524_5.doEnd();
                            _jettag_c_iterate_522_4.handleBodyContent(out);
                        }
                        _jettag_c_iterate_522_4.doEnd();
                        // Create Entity CRUD java Activitoes
                        RuntimeTagElement _jettag_ws_folder_547_4 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_547_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_folder_547_4.setRuntimeParent(_jettag_c_iterate_517_7);
                        _jettag_ws_folder_547_4.setTagInfo(_td_ws_folder_547_4);
                        _jettag_ws_folder_547_4.doStart(context, out);
                        while (_jettag_ws_folder_547_4.okToProcessBody()) {
                            RuntimeTagElement _jettag_ws_folder_548_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_548_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_ws_folder_548_5.setRuntimeParent(_jettag_ws_folder_547_4);
                            _jettag_ws_folder_548_5.setTagInfo(_td_ws_folder_548_5);
                            _jettag_ws_folder_548_5.doStart(context, out);
                            while (_jettag_ws_folder_548_5.okToProcessBody()) {
                                out.write("\t\t\t\t");  //$NON-NLS-1$        
                                RuntimeTagElement _jettag_ws_file_549_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_549_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_ws_file_549_5.setRuntimeParent(_jettag_ws_folder_548_5);
                                _jettag_ws_file_549_5.setTagInfo(_td_ws_file_549_5);
                                _jettag_ws_file_549_5.doStart(context, out);
                                _jettag_ws_file_549_5.doEnd();
                                out.write(NL);         
                                out.write("\t\t\t\t");  //$NON-NLS-1$        
                                RuntimeTagElement _jettag_ws_file_550_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_550_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_ws_file_550_5.setRuntimeParent(_jettag_ws_folder_548_5);
                                _jettag_ws_file_550_5.setTagInfo(_td_ws_file_550_5);
                                _jettag_ws_file_550_5.doStart(context, out);
                                _jettag_ws_file_550_5.doEnd();
                                out.write(NL);         
                                out.write("\t\t\t\t");  //$NON-NLS-1$        
                                RuntimeTagElement _jettag_ws_file_551_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_551_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_ws_file_551_5.setRuntimeParent(_jettag_ws_folder_548_5);
                                _jettag_ws_file_551_5.setTagInfo(_td_ws_file_551_5);
                                _jettag_ws_file_551_5.doStart(context, out);
                                _jettag_ws_file_551_5.doEnd();
                                out.write(NL);         
                                out.write("\t\t\t\t");  //$NON-NLS-1$        
                                RuntimeTagElement _jettag_ws_file_552_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_552_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_ws_file_552_5.setRuntimeParent(_jettag_ws_folder_548_5);
                                _jettag_ws_file_552_5.setTagInfo(_td_ws_file_552_5);
                                _jettag_ws_file_552_5.doStart(context, out);
                                _jettag_ws_file_552_5.doEnd();
                                out.write(NL);         
                                _jettag_ws_folder_548_5.handleBodyContent(out);
                            }
                            _jettag_ws_folder_548_5.doEnd();
                            _jettag_ws_folder_547_4.handleBodyContent(out);
                        }
                        _jettag_ws_folder_547_4.doEnd();
                        // Create Entity CRUD layout xml's
                        RuntimeTagElement _jettag_ws_folder_556_4 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_556_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_folder_556_4.setRuntimeParent(_jettag_c_iterate_517_7);
                        _jettag_ws_folder_556_4.setTagInfo(_td_ws_folder_556_4);
                        _jettag_ws_folder_556_4.doStart(context, out);
                        while (_jettag_ws_folder_556_4.okToProcessBody()) {
                            // CREATE 
                            out.write("\t\t\t");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_ws_file_558_4 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_558_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_ws_file_558_4.setRuntimeParent(_jettag_ws_folder_556_4);
                            _jettag_ws_file_558_4.setTagInfo(_td_ws_file_558_4);
                            _jettag_ws_file_558_4.doStart(context, out);
                            _jettag_ws_file_558_4.doEnd();
                            out.write(NL);         
                            // READ 
                            out.write("\t\t\t");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_ws_file_560_4 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_560_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_ws_file_560_4.setRuntimeParent(_jettag_ws_folder_556_4);
                            _jettag_ws_file_560_4.setTagInfo(_td_ws_file_560_4);
                            _jettag_ws_file_560_4.doStart(context, out);
                            _jettag_ws_file_560_4.doEnd();
                            out.write(NL);         
                            _jettag_ws_folder_556_4.handleBodyContent(out);
                        }
                        _jettag_ws_folder_556_4.doEnd();
                        // Create Entity Menu layout.xml
                        RuntimeTagElement _jettag_ws_folder_563_4 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_563_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_folder_563_4.setRuntimeParent(_jettag_c_iterate_517_7);
                        _jettag_ws_folder_563_4.setTagInfo(_td_ws_folder_563_4);
                        _jettag_ws_folder_563_4.doStart(context, out);
                        while (_jettag_ws_folder_563_4.okToProcessBody()) {
                            // MENU 
                            out.write("\t\t\t");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_ws_file_565_4 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_565_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_ws_file_565_4.setRuntimeParent(_jettag_ws_folder_563_4);
                            _jettag_ws_file_565_4.setTagInfo(_td_ws_file_565_4);
                            _jettag_ws_file_565_4.doStart(context, out);
                            _jettag_ws_file_565_4.doEnd();
                            out.write(NL);         
                            _jettag_ws_folder_563_4.handleBodyContent(out);
                        }
                        _jettag_ws_folder_563_4.doEnd();
                        _jettag_c_iterate_517_7.handleBodyContent(out);
                    }
                    _jettag_c_iterate_517_7.doEnd();
                    _jettag_c_iterate_516_9.handleBodyContent(out);
                }
                _jettag_c_iterate_516_9.doEnd();
                RuntimeTagElement _jettag_ws_folder_569_2 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_569_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_569_2.setRuntimeParent(_jettag_ws_project_504_1);
                _jettag_ws_folder_569_2.setTagInfo(_td_ws_folder_569_2);
                _jettag_ws_folder_569_2.doStart(context, out);
                while (_jettag_ws_folder_569_2.okToProcessBody()) {
                    out.write("\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_571_2 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_571_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_571_2.setRuntimeParent(_jettag_ws_folder_569_2);
                    _jettag_ws_file_571_2.setTagInfo(_td_ws_file_571_2);
                    _jettag_ws_file_571_2.doStart(context, out);
                    _jettag_ws_file_571_2.doEnd();
                    out.write(NL);         
                    out.write("\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_572_2 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_572_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_572_2.setRuntimeParent(_jettag_ws_folder_569_2);
                    _jettag_ws_file_572_2.setTagInfo(_td_ws_file_572_2);
                    _jettag_ws_file_572_2.doStart(context, out);
                    _jettag_ws_file_572_2.doEnd();
                    out.write(NL);         
                    out.write("\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_573_2 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_573_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_573_2.setRuntimeParent(_jettag_ws_folder_569_2);
                    _jettag_ws_file_573_2.setTagInfo(_td_ws_file_573_2);
                    _jettag_ws_file_573_2.doStart(context, out);
                    _jettag_ws_file_573_2.doEnd();
                    out.write(NL);         
                    out.write("\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_574_2 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_574_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_574_2.setRuntimeParent(_jettag_ws_folder_569_2);
                    _jettag_ws_file_574_2.setTagInfo(_td_ws_file_574_2);
                    _jettag_ws_file_574_2.doStart(context, out);
                    _jettag_ws_file_574_2.doEnd();
                    out.write(NL);         
                    _jettag_ws_folder_569_2.handleBodyContent(out);
                }
                _jettag_ws_folder_569_2.doEnd();
                RuntimeTagElement _jettag_ws_folder_576_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_576_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_576_5.setRuntimeParent(_jettag_ws_project_504_1);
                _jettag_ws_folder_576_5.setTagInfo(_td_ws_folder_576_5);
                _jettag_ws_folder_576_5.doStart(context, out);
                while (_jettag_ws_folder_576_5.okToProcessBody()) {
                    _jettag_ws_folder_576_5.handleBodyContent(out);
                }
                _jettag_ws_folder_576_5.doEnd();
                RuntimeTagElement _jettag_ws_folder_578_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_578_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_578_5.setRuntimeParent(_jettag_ws_project_504_1);
                _jettag_ws_folder_578_5.setTagInfo(_td_ws_folder_578_5);
                _jettag_ws_folder_578_5.doStart(context, out);
                while (_jettag_ws_folder_578_5.okToProcessBody()) {
                    out.write("    ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_579_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_579_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_579_5.setRuntimeParent(_jettag_ws_folder_578_5);
                    _jettag_ws_file_579_5.setTagInfo(_td_ws_file_579_5);
                    _jettag_ws_file_579_5.doStart(context, out);
                    _jettag_ws_file_579_5.doEnd();
                    out.write(NL);         
                    _jettag_ws_folder_578_5.handleBodyContent(out);
                }
                _jettag_ws_folder_578_5.doEnd();
                RuntimeTagElement _jettag_ws_folder_581_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_581_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_581_6.setRuntimeParent(_jettag_ws_project_504_1);
                _jettag_ws_folder_581_6.setTagInfo(_td_ws_folder_581_6);
                _jettag_ws_folder_581_6.doStart(context, out);
                while (_jettag_ws_folder_581_6.okToProcessBody()) {
                    _jettag_ws_folder_581_6.handleBodyContent(out);
                }
                _jettag_ws_folder_581_6.doEnd();
                RuntimeTagElement _jettag_ws_folder_583_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_583_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_583_6.setRuntimeParent(_jettag_ws_project_504_1);
                _jettag_ws_folder_583_6.setTagInfo(_td_ws_folder_583_6);
                _jettag_ws_folder_583_6.doStart(context, out);
                while (_jettag_ws_folder_583_6.okToProcessBody()) {
                    _jettag_ws_folder_583_6.handleBodyContent(out);
                }
                _jettag_ws_folder_583_6.doEnd();
                RuntimeTagElement _jettag_ws_folder_585_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_585_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_585_6.setRuntimeParent(_jettag_ws_project_504_1);
                _jettag_ws_folder_585_6.setTagInfo(_td_ws_folder_585_6);
                _jettag_ws_folder_585_6.doStart(context, out);
                while (_jettag_ws_folder_585_6.okToProcessBody()) {
                    _jettag_ws_folder_585_6.handleBodyContent(out);
                }
                _jettag_ws_folder_585_6.doEnd();
                _jettag_ws_project_504_1.handleBodyContent(out);
            }
            _jettag_ws_project_504_1.doEnd();
            _jettag_c_if_503_1.handleBodyContent(out);
        }
        _jettag_c_if_503_1.doEnd();
        //creates the ios project
        RuntimeTagElement _jettag_c_if_590_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_590_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_590_1.setRuntimeParent(null);
        _jettag_c_if_590_1.setTagInfo(_td_c_if_590_1);
        _jettag_c_if_590_1.doStart(context, out);
        while (_jettag_c_if_590_1.okToProcessBody()) {
            RuntimeTagElement _jettag_ws_project_591_1 = context.getTagFactory().createRuntimeTag(_jetns_ws, "project", "ws:project", _td_ws_project_591_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_ws_project_591_1.setRuntimeParent(_jettag_c_if_590_1);
            _jettag_ws_project_591_1.setTagInfo(_td_ws_project_591_1);
            _jettag_ws_project_591_1.doStart(context, out);
            while (_jettag_ws_project_591_1.okToProcessBody()) {
                //create root view controller files
                RuntimeTagElement _jettag_ws_folder_593_1 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_593_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_folder_593_1.setRuntimeParent(_jettag_ws_project_591_1);
                _jettag_ws_folder_593_1.setTagInfo(_td_ws_folder_593_1);
                _jettag_ws_folder_593_1.doStart(context, out);
                while (_jettag_ws_folder_593_1.okToProcessBody()) {
                    out.write("\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_594_2 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_594_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_594_2.setRuntimeParent(_jettag_ws_folder_593_1);
                    _jettag_ws_file_594_2.setTagInfo(_td_ws_file_594_2);
                    _jettag_ws_file_594_2.doStart(context, out);
                    _jettag_ws_file_594_2.doEnd();
                    out.write(NL);         
                    out.write("\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_595_2 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_595_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_595_2.setRuntimeParent(_jettag_ws_folder_593_1);
                    _jettag_ws_file_595_2.setTagInfo(_td_ws_file_595_2);
                    _jettag_ws_file_595_2.doStart(context, out);
                    _jettag_ws_file_595_2.doEnd();
                    out.write(NL);         
                    out.write("\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_596_2 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_596_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_596_2.setRuntimeParent(_jettag_ws_folder_593_1);
                    _jettag_ws_file_596_2.setTagInfo(_td_ws_file_596_2);
                    _jettag_ws_file_596_2.doStart(context, out);
                    _jettag_ws_file_596_2.doEnd();
                    out.write(NL);         
                    out.write("\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_ws_file_597_2 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_597_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_ws_file_597_2.setRuntimeParent(_jettag_ws_folder_593_1);
                    _jettag_ws_file_597_2.setTagInfo(_td_ws_file_597_2);
                    _jettag_ws_file_597_2.doStart(context, out);
                    _jettag_ws_file_597_2.doEnd();
                    out.write(NL);         
                    _jettag_ws_folder_593_1.handleBodyContent(out);
                }
                _jettag_ws_folder_593_1.doEnd();
                //Iterate through the packages and classes
                RuntimeTagElement _jettag_c_iterate_600_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_600_9); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_600_9.setRuntimeParent(_jettag_ws_project_591_1);
                _jettag_c_iterate_600_9.setTagInfo(_td_c_iterate_600_9);
                _jettag_c_iterate_600_9.doStart(context, out);
                while (_jettag_c_iterate_600_9.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_601_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_601_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_601_7.setRuntimeParent(_jettag_c_iterate_600_9);
                    _jettag_c_iterate_601_7.setTagInfo(_td_c_iterate_601_7);
                    _jettag_c_iterate_601_7.doStart(context, out);
                    while (_jettag_c_iterate_601_7.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_setVariable_602_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_602_13); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_602_13.setRuntimeParent(_jettag_c_iterate_601_7);
                        _jettag_c_setVariable_602_13.setTagInfo(_td_c_setVariable_602_13);
                        _jettag_c_setVariable_602_13.doStart(context, out);
                        _jettag_c_setVariable_602_13.doEnd();
                        RuntimeTagElement _jettag_c_setVariable_603_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_603_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_603_4.setRuntimeParent(_jettag_c_iterate_601_7);
                        _jettag_c_setVariable_603_4.setTagInfo(_td_c_setVariable_603_4);
                        _jettag_c_setVariable_603_4.doStart(context, out);
                        _jettag_c_setVariable_603_4.doEnd();
                        RuntimeTagElement _jettag_c_setVariable_604_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_604_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_604_4.setRuntimeParent(_jettag_c_iterate_601_7);
                        _jettag_c_setVariable_604_4.setTagInfo(_td_c_setVariable_604_4);
                        _jettag_c_setVariable_604_4.doStart(context, out);
                        _jettag_c_setVariable_604_4.doEnd();
                        //process generizations 
                        RuntimeTagElement _jettag_c_iterate_606_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_606_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_606_4.setRuntimeParent(_jettag_c_iterate_601_7);
                        _jettag_c_iterate_606_4.setTagInfo(_td_c_iterate_606_4);
                        _jettag_c_iterate_606_4.doStart(context, out);
                        while (_jettag_c_iterate_606_4.okToProcessBody()) {
                            // if child class
                            RuntimeTagElement _jettag_c_if_608_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_608_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_608_5.setRuntimeParent(_jettag_c_iterate_606_4);
                            _jettag_c_if_608_5.setTagInfo(_td_c_if_608_5);
                            _jettag_c_if_608_5.doStart(context, out);
                            while (_jettag_c_if_608_5.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_iterate_609_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_609_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_609_6.setRuntimeParent(_jettag_c_if_608_5);
                                _jettag_c_iterate_609_6.setTagInfo(_td_c_iterate_609_6);
                                _jettag_c_iterate_609_6.doStart(context, out);
                                while (_jettag_c_iterate_609_6.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_610_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_610_9); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_610_9.setRuntimeParent(_jettag_c_iterate_609_6);
                                    _jettag_c_if_610_9.setTagInfo(_td_c_if_610_9);
                                    _jettag_c_if_610_9.doStart(context, out);
                                    while (_jettag_c_if_610_9.okToProcessBody()) {
                                        // get level 1 parent
                                        RuntimeTagElement _jettag_c_setVariable_612_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_612_9); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_612_9.setRuntimeParent(_jettag_c_if_610_9);
                                        _jettag_c_setVariable_612_9.setTagInfo(_td_c_setVariable_612_9);
                                        _jettag_c_setVariable_612_9.doStart(context, out);
                                        _jettag_c_setVariable_612_9.doEnd();
                                        // second round to get level 2 
                                        RuntimeTagElement _jettag_c_iterate_614_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_614_9); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_614_9.setRuntimeParent(_jettag_c_if_610_9);
                                        _jettag_c_iterate_614_9.setTagInfo(_td_c_iterate_614_9);
                                        _jettag_c_iterate_614_9.doStart(context, out);
                                        while (_jettag_c_iterate_614_9.okToProcessBody()) {
                                            // if child class
                                            RuntimeTagElement _jettag_c_if_616_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_616_10); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_616_10.setRuntimeParent(_jettag_c_iterate_614_9);
                                            _jettag_c_if_616_10.setTagInfo(_td_c_if_616_10);
                                            _jettag_c_if_616_10.doStart(context, out);
                                            while (_jettag_c_if_616_10.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_iterate_617_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_617_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_iterate_617_11.setRuntimeParent(_jettag_c_if_616_10);
                                                _jettag_c_iterate_617_11.setTagInfo(_td_c_iterate_617_11);
                                                _jettag_c_iterate_617_11.doStart(context, out);
                                                while (_jettag_c_iterate_617_11.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_618_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_618_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_618_14.setRuntimeParent(_jettag_c_iterate_617_11);
                                                    _jettag_c_if_618_14.setTagInfo(_td_c_if_618_14);
                                                    _jettag_c_if_618_14.doStart(context, out);
                                                    while (_jettag_c_if_618_14.okToProcessBody()) {
                                                        // get level 2 parent
                                                        RuntimeTagElement _jettag_c_setVariable_620_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_620_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_setVariable_620_14.setRuntimeParent(_jettag_c_if_618_14);
                                                        _jettag_c_setVariable_620_14.setTagInfo(_td_c_setVariable_620_14);
                                                        _jettag_c_setVariable_620_14.doStart(context, out);
                                                        _jettag_c_setVariable_620_14.doEnd();
                                                        _jettag_c_if_618_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_618_14.doEnd();
                                                    _jettag_c_iterate_617_11.handleBodyContent(out);
                                                }
                                                _jettag_c_iterate_617_11.doEnd();
                                                _jettag_c_if_616_10.handleBodyContent(out);
                                            }
                                            _jettag_c_if_616_10.doEnd();
                                            _jettag_c_iterate_614_9.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_614_9.doEnd();
                                        out.write("\t\t\t\t\t\t\t\t  \t\t\t\t\t\t\t\t\t \t\t\t\t");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_610_9.handleBodyContent(out);
                                    }
                                    _jettag_c_if_610_9.doEnd();
                                    _jettag_c_iterate_609_6.handleBodyContent(out);
                                }
                                _jettag_c_iterate_609_6.doEnd();
                                _jettag_c_if_608_5.handleBodyContent(out);
                            }
                            _jettag_c_if_608_5.doEnd();
                            _jettag_c_iterate_606_4.handleBodyContent(out);
                        }
                        _jettag_c_iterate_606_4.doEnd();
                        // Entity interface TO
                        RuntimeTagElement _jettag_ws_folder_631_4 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_631_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_folder_631_4.setRuntimeParent(_jettag_c_iterate_601_7);
                        _jettag_ws_folder_631_4.setTagInfo(_td_ws_folder_631_4);
                        _jettag_ws_folder_631_4.doStart(context, out);
                        while (_jettag_ws_folder_631_4.okToProcessBody()) {
                            out.write("\t\t\t\t");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_ws_file_632_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_632_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_ws_file_632_5.setRuntimeParent(_jettag_ws_folder_631_4);
                            _jettag_ws_file_632_5.setTagInfo(_td_ws_file_632_5);
                            _jettag_ws_file_632_5.doStart(context, out);
                            _jettag_ws_file_632_5.doEnd();
                            out.write(NL);         
                            out.write("\t\t\t\t");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_ws_file_633_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_633_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_ws_file_633_5.setRuntimeParent(_jettag_ws_folder_631_4);
                            _jettag_ws_file_633_5.setTagInfo(_td_ws_file_633_5);
                            _jettag_ws_file_633_5.doStart(context, out);
                            _jettag_ws_file_633_5.doEnd();
                            out.write(NL);         
                            _jettag_ws_folder_631_4.handleBodyContent(out);
                        }
                        _jettag_ws_folder_631_4.doEnd();
                        // Entity CRUD Controllers
                        RuntimeTagElement _jettag_ws_folder_636_4 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_636_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_folder_636_4.setRuntimeParent(_jettag_c_iterate_601_7);
                        _jettag_ws_folder_636_4.setTagInfo(_td_ws_folder_636_4);
                        _jettag_ws_folder_636_4.doStart(context, out);
                        while (_jettag_ws_folder_636_4.okToProcessBody()) {
                            out.write("\t\t\t\t");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_ws_file_637_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_637_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_ws_file_637_5.setRuntimeParent(_jettag_ws_folder_636_4);
                            _jettag_ws_file_637_5.setTagInfo(_td_ws_file_637_5);
                            _jettag_ws_file_637_5.doStart(context, out);
                            _jettag_ws_file_637_5.doEnd();
                            out.write(NL);         
                            out.write("\t\t\t\t");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_ws_file_638_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_638_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_ws_file_638_5.setRuntimeParent(_jettag_ws_folder_636_4);
                            _jettag_ws_file_638_5.setTagInfo(_td_ws_file_638_5);
                            _jettag_ws_file_638_5.doStart(context, out);
                            _jettag_ws_file_638_5.doEnd();
                            out.write(NL);         
                            out.write("\t\t\t\t");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_ws_file_639_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_639_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_ws_file_639_5.setRuntimeParent(_jettag_ws_folder_636_4);
                            _jettag_ws_file_639_5.setTagInfo(_td_ws_file_639_5);
                            _jettag_ws_file_639_5.doStart(context, out);
                            _jettag_ws_file_639_5.doEnd();
                            out.write(NL);         
                            out.write("\t\t\t\t");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_ws_file_640_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_640_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_ws_file_640_5.setRuntimeParent(_jettag_ws_folder_636_4);
                            _jettag_ws_file_640_5.setTagInfo(_td_ws_file_640_5);
                            _jettag_ws_file_640_5.doStart(context, out);
                            _jettag_ws_file_640_5.doEnd();
                            out.write(NL);         
                            out.write("\t\t\t\t");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_ws_file_641_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_641_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_ws_file_641_5.setRuntimeParent(_jettag_ws_folder_636_4);
                            _jettag_ws_file_641_5.setTagInfo(_td_ws_file_641_5);
                            _jettag_ws_file_641_5.doStart(context, out);
                            _jettag_ws_file_641_5.doEnd();
                            out.write(NL);         
                            out.write("\t\t\t\t");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_ws_file_642_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_642_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_ws_file_642_5.setRuntimeParent(_jettag_ws_folder_636_4);
                            _jettag_ws_file_642_5.setTagInfo(_td_ws_file_642_5);
                            _jettag_ws_file_642_5.doStart(context, out);
                            _jettag_ws_file_642_5.doEnd();
                            out.write(NL);         
                            _jettag_ws_folder_636_4.handleBodyContent(out);
                        }
                        _jettag_ws_folder_636_4.doEnd();
                        _jettag_c_iterate_601_7.handleBodyContent(out);
                    }
                    _jettag_c_iterate_601_7.doEnd();
                    _jettag_c_iterate_600_9.handleBodyContent(out);
                }
                _jettag_c_iterate_600_9.doEnd();
                _jettag_ws_project_591_1.handleBodyContent(out);
            }
            _jettag_ws_project_591_1.doEnd();
            _jettag_c_if_590_1.handleBodyContent(out);
        }
        _jettag_c_if_590_1.doEnd();
        out.write(NL);         
        // creates the test project
        RuntimeTagElement _jettag_c_if_650_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_650_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_650_1.setRuntimeParent(null);
        _jettag_c_if_650_1.setTagInfo(_td_c_if_650_1);
        _jettag_c_if_650_1.doStart(context, out);
        while (_jettag_c_if_650_1.okToProcessBody()) {
            RuntimeTagElement _jettag_ws_project_651_1 = context.getTagFactory().createRuntimeTag(_jetns_ws, "project", "ws:project", _td_ws_project_651_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_ws_project_651_1.setRuntimeParent(_jettag_c_if_650_1);
            _jettag_ws_project_651_1.setTagInfo(_td_ws_project_651_1);
            _jettag_ws_project_651_1.doStart(context, out);
            while (_jettag_ws_project_651_1.okToProcessBody()) {
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_ws_file_652_2 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_652_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_ws_file_652_2.setRuntimeParent(_jettag_ws_project_651_1);
                _jettag_ws_file_652_2.setTagInfo(_td_ws_file_652_2);
                _jettag_ws_file_652_2.doStart(context, out);
                _jettag_ws_file_652_2.doEnd();
                out.write(NL);         
                //Iterate through the packages and classes
                RuntimeTagElement _jettag_c_iterate_654_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_654_9); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_654_9.setRuntimeParent(_jettag_ws_project_651_1);
                _jettag_c_iterate_654_9.setTagInfo(_td_c_iterate_654_9);
                _jettag_c_iterate_654_9.doStart(context, out);
                while (_jettag_c_iterate_654_9.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_655_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_655_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_655_7.setRuntimeParent(_jettag_c_iterate_654_9);
                    _jettag_c_iterate_655_7.setTagInfo(_td_c_iterate_655_7);
                    _jettag_c_iterate_655_7.doStart(context, out);
                    while (_jettag_c_iterate_655_7.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_setVariable_656_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_656_13); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_656_13.setRuntimeParent(_jettag_c_iterate_655_7);
                        _jettag_c_setVariable_656_13.setTagInfo(_td_c_setVariable_656_13);
                        _jettag_c_setVariable_656_13.doStart(context, out);
                        _jettag_c_setVariable_656_13.doEnd();
                        RuntimeTagElement _jettag_c_setVariable_657_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_657_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_657_4.setRuntimeParent(_jettag_c_iterate_655_7);
                        _jettag_c_setVariable_657_4.setTagInfo(_td_c_setVariable_657_4);
                        _jettag_c_setVariable_657_4.doStart(context, out);
                        _jettag_c_setVariable_657_4.doEnd();
                        RuntimeTagElement _jettag_c_setVariable_658_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_658_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_658_4.setRuntimeParent(_jettag_c_iterate_655_7);
                        _jettag_c_setVariable_658_4.setTagInfo(_td_c_setVariable_658_4);
                        _jettag_c_setVariable_658_4.doStart(context, out);
                        _jettag_c_setVariable_658_4.doEnd();
                        //process generizations 
                        RuntimeTagElement _jettag_c_iterate_660_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_660_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_660_4.setRuntimeParent(_jettag_c_iterate_655_7);
                        _jettag_c_iterate_660_4.setTagInfo(_td_c_iterate_660_4);
                        _jettag_c_iterate_660_4.doStart(context, out);
                        while (_jettag_c_iterate_660_4.okToProcessBody()) {
                            // if child class
                            RuntimeTagElement _jettag_c_if_662_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_662_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_662_5.setRuntimeParent(_jettag_c_iterate_660_4);
                            _jettag_c_if_662_5.setTagInfo(_td_c_if_662_5);
                            _jettag_c_if_662_5.doStart(context, out);
                            while (_jettag_c_if_662_5.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_iterate_663_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_663_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_663_6.setRuntimeParent(_jettag_c_if_662_5);
                                _jettag_c_iterate_663_6.setTagInfo(_td_c_iterate_663_6);
                                _jettag_c_iterate_663_6.doStart(context, out);
                                while (_jettag_c_iterate_663_6.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_664_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_664_9); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_664_9.setRuntimeParent(_jettag_c_iterate_663_6);
                                    _jettag_c_if_664_9.setTagInfo(_td_c_if_664_9);
                                    _jettag_c_if_664_9.doStart(context, out);
                                    while (_jettag_c_if_664_9.okToProcessBody()) {
                                        // get level 1 parent
                                        RuntimeTagElement _jettag_c_setVariable_666_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_666_9); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_666_9.setRuntimeParent(_jettag_c_if_664_9);
                                        _jettag_c_setVariable_666_9.setTagInfo(_td_c_setVariable_666_9);
                                        _jettag_c_setVariable_666_9.doStart(context, out);
                                        _jettag_c_setVariable_666_9.doEnd();
                                        // second round to get level 2 
                                        RuntimeTagElement _jettag_c_iterate_668_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_668_9); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_668_9.setRuntimeParent(_jettag_c_if_664_9);
                                        _jettag_c_iterate_668_9.setTagInfo(_td_c_iterate_668_9);
                                        _jettag_c_iterate_668_9.doStart(context, out);
                                        while (_jettag_c_iterate_668_9.okToProcessBody()) {
                                            // if child class
                                            RuntimeTagElement _jettag_c_if_670_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_670_10); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_670_10.setRuntimeParent(_jettag_c_iterate_668_9);
                                            _jettag_c_if_670_10.setTagInfo(_td_c_if_670_10);
                                            _jettag_c_if_670_10.doStart(context, out);
                                            while (_jettag_c_if_670_10.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_iterate_671_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_671_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_iterate_671_11.setRuntimeParent(_jettag_c_if_670_10);
                                                _jettag_c_iterate_671_11.setTagInfo(_td_c_iterate_671_11);
                                                _jettag_c_iterate_671_11.doStart(context, out);
                                                while (_jettag_c_iterate_671_11.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_672_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_672_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_672_14.setRuntimeParent(_jettag_c_iterate_671_11);
                                                    _jettag_c_if_672_14.setTagInfo(_td_c_if_672_14);
                                                    _jettag_c_if_672_14.doStart(context, out);
                                                    while (_jettag_c_if_672_14.okToProcessBody()) {
                                                        // get level 2 parent
                                                        RuntimeTagElement _jettag_c_setVariable_674_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_674_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_setVariable_674_14.setRuntimeParent(_jettag_c_if_672_14);
                                                        _jettag_c_setVariable_674_14.setTagInfo(_td_c_setVariable_674_14);
                                                        _jettag_c_setVariable_674_14.doStart(context, out);
                                                        _jettag_c_setVariable_674_14.doEnd();
                                                        _jettag_c_if_672_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_672_14.doEnd();
                                                    _jettag_c_iterate_671_11.handleBodyContent(out);
                                                }
                                                _jettag_c_iterate_671_11.doEnd();
                                                _jettag_c_if_670_10.handleBodyContent(out);
                                            }
                                            _jettag_c_if_670_10.doEnd();
                                            _jettag_c_iterate_668_9.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_668_9.doEnd();
                                        out.write("\t\t\t\t\t\t\t\t  \t\t\t\t\t\t\t\t\t \t\t\t\t");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_664_9.handleBodyContent(out);
                                    }
                                    _jettag_c_if_664_9.doEnd();
                                    _jettag_c_iterate_663_6.handleBodyContent(out);
                                }
                                _jettag_c_iterate_663_6.doEnd();
                                _jettag_c_if_662_5.handleBodyContent(out);
                            }
                            _jettag_c_if_662_5.doEnd();
                            _jettag_c_iterate_660_4.handleBodyContent(out);
                        }
                        _jettag_c_iterate_660_4.doEnd();
                        //  looping complete 
                        // Entity interface TO
                        RuntimeTagElement _jettag_ws_folder_686_4 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_686_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_folder_686_4.setRuntimeParent(_jettag_c_iterate_655_7);
                        _jettag_ws_folder_686_4.setTagInfo(_td_ws_folder_686_4);
                        _jettag_ws_folder_686_4.doStart(context, out);
                        while (_jettag_ws_folder_686_4.okToProcessBody()) {
                            RuntimeTagElement _jettag_ws_folder_687_5 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_687_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_ws_folder_687_5.setRuntimeParent(_jettag_ws_folder_686_4);
                            _jettag_ws_folder_687_5.setTagInfo(_td_ws_folder_687_5);
                            _jettag_ws_folder_687_5.doStart(context, out);
                            while (_jettag_ws_folder_687_5.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_688_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_688_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_688_5.setRuntimeParent(_jettag_ws_folder_687_5);
                                _jettag_c_if_688_5.setTagInfo(_td_c_if_688_5);
                                _jettag_c_if_688_5.doStart(context, out);
                                while (_jettag_c_if_688_5.okToProcessBody()) {
                                    //	<ws:file path="{$class/@name}Test.java" template="templates/test/test/test_entity_selenium_class.java.jet"/> 
                                    out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                                    RuntimeTagElement _jettag_ws_file_690_6 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_690_6); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_ws_file_690_6.setRuntimeParent(_jettag_c_if_688_5);
                                    _jettag_ws_file_690_6.setTagInfo(_td_ws_file_690_6);
                                    _jettag_ws_file_690_6.doStart(context, out);
                                    _jettag_ws_file_690_6.doEnd();
                                    out.write(NL);         
                                    _jettag_c_if_688_5.handleBodyContent(out);
                                }
                                _jettag_c_if_688_5.doEnd();
                                _jettag_ws_folder_687_5.handleBodyContent(out);
                            }
                            _jettag_ws_folder_687_5.doEnd();
                            _jettag_ws_folder_686_4.handleBodyContent(out);
                        }
                        _jettag_ws_folder_686_4.doEnd();
                        RuntimeTagElement _jettag_ws_folder_694_8 = context.getTagFactory().createRuntimeTag(_jetns_ws, "folder", "ws:folder", _td_ws_folder_694_8); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_ws_folder_694_8.setRuntimeParent(_jettag_c_iterate_655_7);
                        _jettag_ws_folder_694_8.setTagInfo(_td_ws_folder_694_8);
                        _jettag_ws_folder_694_8.doStart(context, out);
                        while (_jettag_ws_folder_694_8.okToProcessBody()) {
                            out.write("     \t\t\t");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_ws_file_695_9 = context.getTagFactory().createRuntimeTag(_jetns_ws, "file", "ws:file", _td_ws_file_695_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_ws_file_695_9.setRuntimeParent(_jettag_ws_folder_694_8);
                            _jettag_ws_file_695_9.setTagInfo(_td_ws_file_695_9);
                            _jettag_ws_file_695_9.doStart(context, out);
                            _jettag_ws_file_695_9.doEnd();
                            out.write(NL);         
                            _jettag_ws_folder_694_8.handleBodyContent(out);
                        }
                        _jettag_ws_folder_694_8.doEnd();
                        _jettag_c_iterate_655_7.handleBodyContent(out);
                    }
                    _jettag_c_iterate_655_7.doEnd();
                    _jettag_c_iterate_654_9.handleBodyContent(out);
                }
                _jettag_c_iterate_654_9.doEnd();
                _jettag_ws_project_651_1.handleBodyContent(out);
            }
            _jettag_ws_project_651_1.doEnd();
            _jettag_c_if_650_1.handleBodyContent(out);
        }
        _jettag_c_if_650_1.doEnd();
    }
}
