/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.dao.profile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import info.yalamanchili.office.dao.AbstractDaoTest;
import info.yalamanchili.office.entity.profile.Employee;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeDaoTest extends AbstractDaoTest<Employee> {

    @Autowired
    protected EmployeeDao employeeDao;

    @Override
    public void testFindById() {
        // TODO Auto-generated method stub

    }

    @Override
    public void testQuery() {
        // TODO Auto-generated method stub

    }

    @Override
    public void testQueryByParams() {
        // TODO Auto-generated method stub

    }

    @Override
    public void testDelete() {
        // TODO Auto-generated method stub

    }

    @Override
    public void testSize() {
        // TODO Auto-generated method stub

    }

    @Override
    public void testSave() {
        entity = new Employee();
        entity.setFirstName("asdf");
        entity.setLastName("adsf");
        entity = employeeDao.save(entity);
        assertNotNull(entity.getId());
        assertEquals("asdf", entity.getFirstName());
    }
}
