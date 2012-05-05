package info.yalamanchili.office.server;

import info.yalamanchili.office.config.OfficeWebConfiguration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;

@Configuration
public class OfficeSpringConfiguration {
	@Bean
	public HttpServiceImpl httpServiceImpl() {
		return new HttpServiceImpl();
	}

	@Bean
	public OfficeWebConfiguration officeWebConfiguration() {
		return new OfficeWebConfiguration();
	}

	@Bean
	public MBeanExporter createJmxExporter() {
		Map<String, Object> mbeans = new HashMap<String, Object>();
		mbeans.put("bean:name=OfficeWebConfiguration", officeWebConfiguration());
		MBeanExporter mBeanExporter = new MBeanExporter();
		mBeanExporter.setAllowEagerInit(true);
		mBeanExporter.setBeans(mbeans);
		return mBeanExporter;
	}
}
