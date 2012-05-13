package info.yalamanchili.office.service;

import info.yalamanchili.office.service.types.Error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

//@Scope("request")
@Component
public class ServiceMessages {
	private List<Error> errors = new ArrayList<Error>();

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public void addError(Error error) {
		this.errors.add(error);
	}

	public void clear() {
		errors.clear();
	}

	public boolean isNotEmpty() {
		return !errors.isEmpty();
	}

}
