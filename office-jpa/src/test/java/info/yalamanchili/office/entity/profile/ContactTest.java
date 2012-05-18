package info.yalamanchili.office.entity.profile;

import info.yalamanchili.office.entity.AbstractJPATest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/persistenceContext.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class ContactTest extends AbstractJPATest<Contact> {

	@PersistenceContext
	EntityManager em;

	@Override
	public void testCreate() {
		entity = new Contact();
		entity.setFirstName("asdf");
		entity.setLastName("asdf");
		entity = em.merge(entity);
		assertNotNull(entity.getId());
		assertEquals("asdf", entity.getFirstName());

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
