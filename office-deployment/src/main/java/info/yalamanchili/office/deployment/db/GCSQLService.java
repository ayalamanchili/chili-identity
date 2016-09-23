/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.deployment.db;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sqladmin.SQLAdmin;
import com.google.api.services.sqladmin.model.DatabaseFlags;
import com.google.api.services.sqladmin.model.DatabaseInstance;
import com.google.api.services.sqladmin.model.Operation;
import com.google.api.services.sqladmin.model.Settings;
import com.google.api.services.sqladmin.model.User;
import info.yalamanchili.office.deployment.GCPAuthService;
import info.yalamanchili.office.deployment.GCPConstants;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayalamanchili
 */
public class GCSQLService {

    public static void main(String... args) throws IOException, GeneralSecurityException {
        GCSQLService GCSQLService = new GCSQLService();
        GCSQLService.createUsers();
    }

    public void createDB() throws IOException, GeneralSecurityException {
        DatabaseInstance content = new DatabaseInstance();
        content.setName("portal-db-3");
        Settings settings = new Settings();
        settings.setDataDiskSizeGb(10l);
        settings.setTier("db-n1-standard-1");
        DatabaseFlags lower_case_table_names_flag = new DatabaseFlags();
        lower_case_table_names_flag.setName("lower_case_table_names");
        lower_case_table_names_flag.setValue("1");
        List<DatabaseFlags> flags = new ArrayList<>();
        flags.add(lower_case_table_names_flag);
        settings.setDatabaseFlags(flags);
        content.setSettings(settings);
        SQLAdmin.Instances.Insert request = getSQLAdmin().instances().insert(GCPConstants.GCP_PROJECT_NAME, content);
        Operation response = request.execute();
        System.out.println("dddddd" + response.toPrettyString());

    }

    public void createUsers() throws GeneralSecurityException, IOException {
        User user = new User();
        user.setName("office");
        user.setPassword("zuzubi1833");
        user.setInstance("6a882b86-9fac-4754-aa92-4f6d172143c0");

        SQLAdmin.Users.Insert request = getSQLAdmin().users().insert(GCPConstants.GCP_PROJECT_NAME, "6a882b86-9fac-4754-aa92-4f6d172143c0", user);
//        SQLAdmin.Users.Insert request = getSQLAdmin().users().insert(GCPConstants.GCP_PROJECT_NAME, "gce-free-ae:us-central1:portal-db-3", user);
        Operation response = request.execute();
        System.out.println("dddddd" + response.toPrettyString());
    }

    public SQLAdmin getSQLAdmin() throws GeneralSecurityException, IOException {
        GCPAuthService GCPAuthService = new GCPAuthService();
        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        JacksonFactory jsonFactory = JacksonFactory.getDefaultInstance();
        SQLAdmin sqladminService
                = new SQLAdmin.Builder(httpTransport, jsonFactory, GCPAuthService.getCredential())
                .setApplicationName("Google Cloud Platform Sample")
                .build();
        return sqladminService;
    }

}
