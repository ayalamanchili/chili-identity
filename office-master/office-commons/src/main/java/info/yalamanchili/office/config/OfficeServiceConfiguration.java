/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.config;

import info.chili.spring.SpringContext;
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
    ///Users/anuyalamanchili/content-management/office/
    //C://content-management//office/
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
    //2MB
    protected long imageSizeLimit = 200000;
    //20MB
    protected long fileSizeLimit = 2000000;

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    @ManagedAttribute
    public String getAdminEmail() {
        return adminEmail;
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
