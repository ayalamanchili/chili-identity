package info.yalamanchili.office.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {
	@Bean
	public HttpServiceImpl httpServiceImpl() {
		return new HttpServiceImpl();
	}
}
