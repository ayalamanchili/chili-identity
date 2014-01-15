/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.config;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.cache.OfficeCacheManager;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.stereotype.Component;

@Component
public class OfficeServiceConfiguration {

    private final static Logger logger = Logger.getLogger(OfficeServiceConfiguration.class.getName());
    @PersistenceContext
    protected EntityManager em;

    @Value("#{officeProperties['contentManagementLocationRoot']}")
    protected String contentManagementLocationRoot = "C://content-management//office/";
    @Value("#{officeProperties['initRefData']}")
    protected Boolean initRefData = false;
    @Value("#{officeProperties['initTestData']}")
    protected Boolean initTestData = false;
    @Value("#{officeProperties['enableLoginInterceptor']}")
    protected Boolean enableLoginInterceptor = false;
    @Value("#{officeProperties['isSendMail']}")
    protected Boolean isSendMail = true;
    protected String adminEmail = "yphanikumar@gmail.com";
    @Value("#{officeProperties['emailExceptionDetials']}")
    protected Boolean emailExceptionDetials = true;
    //2MB
    protected long imageSizeLimit = 2097152;
    //20MB
    protected long fileSizeLimit = 20971520;

    protected String dataloadFilePath = contentManagementLocationRoot + "load.xlsx";

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    @ManagedAttribute
    public String getAdminEmail() {
        return adminEmail;
    }

    @ManagedAttribute
    public Boolean isEmailExceptionDetials() {
        return emailExceptionDetials;
    }

    public void setEmailExceptionDetials(Boolean emailExceptionDetials) {
        this.emailExceptionDetials = emailExceptionDetials;
    }

    @ManagedAttribute
    public String getContentManagementLocationRoot() {
        return contentManagementLocationRoot;
    }

    public void setContentManagementLocationRoot(String contentManagementLocationRoot) {
        this.contentManagementLocationRoot = contentManagementLocationRoot;
    }

    @ManagedAttribute
    public Boolean getInitRefData() {
        return initRefData;
    }

    public void setInitRefData(Boolean initRefData) {
        this.initRefData = initRefData;
    }

    @ManagedAttribute
    public Boolean getInitTestData() {
        return initTestData;
    }

    public void setInitTestData(Boolean initTestData) {
        this.initTestData = initTestData;
    }

    @ManagedAttribute
    public Boolean getEnableLoginInterceptor() {
        return enableLoginInterceptor;
    }

    public void setEnableLoginInterceptor(Boolean enableLoginInterceptor) {
        this.enableLoginInterceptor = enableLoginInterceptor;
    }

    @ManagedAttribute
    public Boolean getIsSendMail() {
        return isSendMail;
    }

    public void setIsSendMail(Boolean isSendMail) {
        this.isSendMail = isSendMail;
    }

    public long getImageSizeLimit() {
        return imageSizeLimit;
    }

    public void setImageSizeLimit(long imageSizeLimit) {
        this.imageSizeLimit = imageSizeLimit;
    }

    public long getFileSizeLimit() {
        return fileSizeLimit;
    }

    public void setFileSizeLimit(long fileSizeLimit) {
        this.fileSizeLimit = fileSizeLimit;
    }

    public String getFileSizeLimitInMB() {
        return getFileSizeLimit() / 1048576 + "MB";
    }

    public String getDataloadFilePath() {
        return dataloadFilePath;
    }

    public void setDataloadFilePath(String dataloadFilePath) {
        this.dataloadFilePath = dataloadFilePath;
    }

    @ManagedOperation
    public void clearAllCache() {
        OfficeCacheManager.instance().cleanAll();
    }

    @ManagedOperation
    public void clearCache(String cacheName) {
        OfficeCacheManager.instance().clearCache(cacheName);
    }

    @ManagedOperation
    public void indexHibernateSearch() {
        logger.info("--------------started hiberante search indexing-------------");
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(em);
        try {
            fullTextEntityManager.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static OfficeServiceConfiguration instance() {
        return SpringContext.getBean(OfficeServiceConfiguration.class);
    }
}
