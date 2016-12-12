/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.config;

import info.chili.security.SecurityService;
import info.chili.spring.SpringContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class OfficeSecurityConfiguration {

    @Value("#{officeProperties['keystore.type']}")
    protected String keyStoreType;

    @Value("#{officeProperties['keystore.name']}")
    protected String keyStoreName;

    @Value("#{officeProperties['keystore.password']}")
    protected String keyStorePassword;

    @Value("#{officeProperties['keystore.path']}")
    protected String keyStorePath;

    @Value("#{officeProperties['cert.signatureAlgorithm']}")
    protected String certSignatureAlgorithm;

    @Value("#{officeProperties['key.algorithm']}")
    protected String keyAlgorithm;

    @Value("#{officeProperties['key.size']}")
    protected Integer keySize;

    @ManagedAttribute
    public String getKeyStoreType() {
        return keyStoreType;
    }

    public void setKeyStoreType(String keyStoreType) {
        this.keyStoreType = keyStoreType;
    }

    @ManagedAttribute
    public String getKeyStoreName() {
        return keyStoreName;
    }

    public void setKeyStoreName(String keyStoreName) {
        this.keyStoreName = keyStoreName;
    }

    @ManagedAttribute
    public String getKeyStorePassword() {
        return keyStorePassword;
    }

    public void setKeyStorePassword(String keyStorePassword) {
        this.keyStorePassword = keyStorePassword;
    }

    @ManagedAttribute
    public String getKeyStorePath() {
        return keyStorePath;
    }

    public void setKeyStorePath(String keyStorePath) {
        this.keyStorePath = keyStorePath;
    }

    @ManagedAttribute
    public String getCertSignatureAlgorithm() {
        return certSignatureAlgorithm;
    }

    public void setCertSignatureAlgorithm(String certSignatureAlgorithm) {
        this.certSignatureAlgorithm = certSignatureAlgorithm;
    }

    @ManagedAttribute
    public String getKeyAlgorithm() {
        return keyAlgorithm;
    }

    public void setKeyAlgorithm(String keyAlgorithm) {
        this.keyAlgorithm = keyAlgorithm;
    }

    @ManagedAttribute
    public Integer getKeySize() {
        return keySize;
    }

    public void setKeySize(Integer keySize) {
        this.keySize = keySize;
    }

    @ManagedOperation
    public void reloadKeyStore() {
        SecurityService.instance().initKeyStore(getKeyStoreType(), getKeyStoreName(), getKeyStorePassword(), getKeyStorePath());
    }

    public static OfficeSecurityConfiguration instance() {
        return SpringContext.getBean(OfficeSecurityConfiguration.class);
    }
}
