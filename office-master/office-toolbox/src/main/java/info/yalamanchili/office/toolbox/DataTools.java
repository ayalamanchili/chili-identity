/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.toolbox;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.EmailDao;
import info.yalamanchili.office.entity.profile.Email;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Component
public class DataTools {

    @PersistenceContext
    protected EntityManager em;

    /*
     * query all emails and merge them to save/populate the email hash field in database
     */
    public void hashEmails() {
        //TODO use hibernate batch and scrollable result list
        for (Email email : EmailDao.instance().query(0, EmailDao.instance().size().intValue())) {
            em.merge(email);
        }
    }

    public static DataTools instance() {
        return SpringContext.getBean(DataTools.class);
    }
}
