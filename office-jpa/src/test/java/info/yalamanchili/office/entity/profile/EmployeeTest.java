package info.yalamanchili.office.entity.profile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import info.yalamanchili.office.entity.AbstractEntityTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EmployeeTest extends AbstractEntityTest<Employee> {

    @PersistenceContext
    EntityManager em;

    @Override
    public void testCreate() {
//        entity = new Employee();
//        entity.setFirstName("asdf");
//        entity.setLastName("asdf");
//        entity.setEmployeeId("aasdf");
//        EmployeeType empType = new EmployeeType();
//        empType.setName("INTERNAL");
//        empType = em.merge(empType);
//        entity.setEmployeeType(empType);
//        entity = em.merge(entity);
//        assertNotNull(entity.getId());
//        assertEquals("asdf", entity.getFirstName());

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
