package info.yalamanchili.office.config;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Component;
	
@Component
public class OfficeServiceConfiguration {

	protected String testString = "";

	@ManagedAttribute
	public String getTestString() {
		return testString;
	}

	public void setTestString(String testString) {
		this.testString = testString;
	}

}
