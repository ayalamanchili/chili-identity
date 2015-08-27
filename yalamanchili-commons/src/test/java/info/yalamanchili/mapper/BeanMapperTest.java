package info.yalamanchili.mapper;

import static org.junit.Assert.assertTrue;
import info.yalamanchili.commons.entity.Entity;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class BeanMapperTest {
	BeanMapper mapper = new BeanMapper();

	@Test
	public void testMerge() {
		Entity source = new Entity();
		Entity target = new Entity();

		source.setBooleanField(true);
		source.setIntegerField(100);
		source.setStringField("sporce");

		target.setBooleanField(false);
		target.setIntegerField(200);
		target.setStringField("targer");
		mapper.merge(source, target);
		System.out.println(target.getStringField());
	}

	@Test
	public void testClone() {
		Entity entity = new Entity();
		entity.setStringField("test");
		entity.setLongField(new Long(10));
		entity.setIntegerField(10);
		entity.setFloatField(new Float(10.99));
		entity.setSuperint(new Integer(10));
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		entity.setDateField(date);
		Entity result = (Entity) mapper.clone(entity);
		assertTrue(result != null);
		assertTrue(result.getIntegerField().equals(new Integer(10)));
		assertTrue(result.getSuperint().equals(new Integer(10)));
		assertTrue(result.getLongField().equals(new Long(10)));
		assertTrue(result.getStringField().equals("test"));
		assertTrue(result.getFloatField().equals(new Float(10.99)));
		assertTrue(result.getDateField().equals(date));
	}
}
