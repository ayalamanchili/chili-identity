/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.config;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.cache.OfficeCacheManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    /**
     * location where the application files/images are stored
     */
    @Value("#{officeProperties['contentManagementLocationRoot']}")
    protected String contentManagementLocationRoot = "C://content-management//office/";
    /**
     *
     */
    @Value("#{officeProperties['initRefData']}")
    protected Boolean initRefData = false;
    /**
     * creates testing data on server startup
     */
    @Value("#{officeProperties['initTestData']}")
    protected Boolean initTestData = false;
    /**
     *
     */
    @Value("#{officeProperties['enableLoginInterceptor']}")
    protected Boolean enableLoginInterceptor = false;
    /**
     * enable and disable sending emails from application
     */
    @Value("#{officeProperties['isSendMail']}")
    protected Boolean isSendMail = true;
    /**
     * Used to filter emails that are being sent by application:eg: when testing
     * in production
     */
    @Value("#{officeProperties['filterEmails']}")
    protected Boolean filterEmails = false;
    /**
     * admin email used to send feedback
     */
    protected String adminEmail = "yphanikumar@gmail.com";
    /**
     * enable sending exception detiais via email
     */
    @Value("#{officeProperties['emailExceptionDetials']}")
    protected Boolean emailExceptionDetials = true;
    /**
     * Max image Size 2MB
     */
    protected long imageSizeLimit = 2097152;
    /**
     * Max file size 20 MB
     */
    protected long fileSizeLimit = 20971520;
    /**
     * List of emails to send error logs
     */
    protected String errorLogsEmailList = "yphanikumar@gmail.com";
    /**
     * list of white listed emails addresses that can receive emails
     */
    protected String filteredEmailsList = "yphanikumar@gmail.com,prasanthi.p@sstech.mobi,anu@yalamanchili.info";
    /**
     * file path used by data loader tool
     */
    protected String dataloadFilePath = contentManagementLocationRoot + "load.xlsx";
    /**
     *
     */
    protected String allowedFileExtensions = "doc,docx,rtf,txt,ppt,pptx,xls,xlsx,pdf,png,jpg,jpeg,bmp,gif,htm,html";

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

    @ManagedAttribute
    public Boolean isFilterEmails() {
        return filterEmails;
    }

    public void setFilterEmails(Boolean filterEmails) {
        this.filterEmails = filterEmails;
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

    @ManagedAttribute
    public String getErrorLogsEmailList() {
        return errorLogsEmailList;
    }

    public void setErrorLogsEmailList(String errorLogsEmailList) {
        this.errorLogsEmailList = errorLogsEmailList;
    }

    public Set<String> getErrorLogsEmailsAsSet() {
        String[] emails = OfficeServiceConfiguration.instance().getErrorLogsEmailList().split(",");
        return new HashSet<String>(Arrays.asList(emails));
    }

    @ManagedAttribute
    public String getFilteredEmailsList() {
        return filteredEmailsList;
    }

    public Set<String> getFilteredEmailsAsSet() {
        String[] emails = OfficeServiceConfiguration.instance().getFilteredEmailsList().split(",");
        return new HashSet<String>(Arrays.asList(emails));
    }

    public void setFilteredEmailsList(String filteredEmailsList) {
        this.filteredEmailsList = filteredEmailsList;
    }

    public String getDataloadFilePath() {
        return dataloadFilePath;
    }

    public void setDataloadFilePath(String dataloadFilePath) {
        this.dataloadFilePath = dataloadFilePath;
    }

    public List<String> getAllowedFileExtensionsAsList() {
        String[] exts = getAllowedFileExtensions().split(",");
        return new ArrayList<String>(Arrays.asList(exts));
    }

    @ManagedOperation
    public String getAllowedFileExtensions() {
        return allowedFileExtensions;
    }

    public void setAllowedFileExtensions(String allowedFileExtensions) {
        this.allowedFileExtensions = allowedFileExtensions;
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
