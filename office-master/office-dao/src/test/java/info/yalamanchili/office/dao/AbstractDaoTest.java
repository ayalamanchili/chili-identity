/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:persistenceContext.xml", "classpath:applicationContext.xml",
    "classpath:jmsContext.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public abstract class AbstractDaoTest<T> {

    protected T entity;

//	@Test
    public abstract void testSave();

//	@Test
    public abstract void testFindById();

//	@Test
    public abstract void testQuery();

//	@Test
    public abstract void testQueryByParams();

//	@Test
    public abstract void testDelete();
//

//    @Test
    public abstract void testSize();
}
