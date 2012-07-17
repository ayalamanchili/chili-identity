package info.yalamanchili.office.entity.security;

import info.yalamanchili.office.entity.AbstractEntityTest;
import info.yalamanchili.office.entity.profile.Employee;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static org.junit.Assert.assertNotNull;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ayalamanchili
 */
public class CUserTest extends AbstractEntityTest<CUser> {

    @PersistenceContext
    EntityManager em;

    @Override
    public void testCreate() {
        entity = new CUser();
        entity.setUsername("test");
        entity.setPasswordHash("test");
        entity = em.merge(entity);
        assertNotNull(entity.getUserId());
    }

    @Override
    public void testUpdate() {
        // TODO Auto-generated method stub
    }

    @Override
    public void testRead() {
        // TODO Auto-generated method stub
    }

    @Override
    public void delete() {
        // TODO Auto-generated method stub
    }
}
