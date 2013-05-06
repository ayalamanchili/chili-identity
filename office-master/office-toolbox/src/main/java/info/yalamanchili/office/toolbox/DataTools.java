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
import org.jasypt.digest.StandardStringDigester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Component
@Transactional
public class DataTools {

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    private StandardStringDigester officeStringDigester;
    /*
     * query all emails and merge them to save/populate the email hash field in database
     */

    public void hashEmails() {
        for (Email email : EmailDao.instance().query(0, EmailDao.instance().size().intValue())) {
            email.setEmailHash(officeStringDigester.digest(email.getEmail()));
            email = em.merge(email);
            em.flush();
        }
    }

    public String getHash(String str) {
       return officeStringDigester.digest(str);
    }

    public static DataTools instance() {
        return SpringContext.getBean(DataTools.class);
    }
}
