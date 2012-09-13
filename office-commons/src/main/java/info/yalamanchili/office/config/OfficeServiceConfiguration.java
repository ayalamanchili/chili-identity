package info.yalamanchili.office.config;

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

    @PersistenceContext
    protected EntityManager em;
    protected String contentManagementLocationRoot = "C://content-management//office/";
    @Value("#{officeProperties['initRefData']}")
    protected Boolean initRefData;
    @Value("#{officeProperties['enableLoginInterceptor']}")
    protected Boolean enableLoginInterceptor;
    protected Boolean isSendMail = true;

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

    public Boolean getEnableLoginInterceptor() {
        return enableLoginInterceptor;
    }

    public void setEnableLoginInterceptor(Boolean enableLoginInterceptor) {
        this.enableLoginInterceptor = enableLoginInterceptor;
    }
    public Boolean getIsSendEmail() {
        return isSendMail;
    }

    public void setIsSendEmail(Boolean IsSendEmail) {
        this.isSendMail = IsSendEmail;
    }

    @ManagedOperation
    public void indexHibernateSearch() {
        System.out.println("--------------started hiberante search indexing-------------");
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(em);
        try {
            fullTextEntityManager.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
