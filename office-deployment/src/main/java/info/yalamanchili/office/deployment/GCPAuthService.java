/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.deployment;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import org.springframework.stereotype.Service;

/**
 *
 * @author ayalamanchili
 */
public class GCPAuthService {

    public GoogleCredential getCredential() throws IOException {
        GoogleCredential credential = GoogleCredential.fromStream(new FileInputStream("/home/ayalamanchili/Documents/gce-free-ae-creds.json"));
        if (credential.createScopedRequired()) {
            credential
                    = credential.createScoped(
                            Collections.singletonList("https://www.googleapis.com/auth/cloud-platform"));
        }
        return credential;
    }
}
