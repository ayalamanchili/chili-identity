/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.security;

import info.chili.spring.SpringContext;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.util.HashMap;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class SecurityService {

    protected HashMap<String, KeyStore> keyStores = new HashMap<String, KeyStore>();

    public PrivateKey getPrivateKey(String keyStoreName, String keyAlias, char[] keyPassword) {
        try {
            return (PrivateKey) keyStores.get(keyStoreName).getKey(keyAlias, keyPassword);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public Certificate[] getCertificateChain(String keyStoreName, String certName) {
        try {
            return keyStores.get(keyStoreName).getCertificateChain("test-cert");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    protected KeyStore getKeyStore(String keyStoreName) {
        if (keyStores.containsKey(keyStoreName)) {
            return keyStores.get(keyStoreName);
        } else {
            throw new RuntimeException("no keystore loaded. please call initKeystore before the call:" + keyStoreName);
        }
    }

    public void initKeyStore(String name, char[] keyStorePassword, String keyStoreFilePath) {
        try {
            KeyStore ks = KeyStore.getInstance(name);
            ks.load(new FileInputStream(keyStoreFilePath), keyStorePassword);
            keyStores.put(name, ks);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static SecurityService instance() {
        return SpringContext.getBean(SecurityService.class);
    }
}
