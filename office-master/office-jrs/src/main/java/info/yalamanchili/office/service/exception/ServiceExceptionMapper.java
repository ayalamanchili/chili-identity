package info.yalamanchili.office.service.exception;

import info.chili.service.jrs.exception.ServiceException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

@Provider
@Component
public class ServiceExceptionMapper implements ExceptionMapper<ServiceException> {

    public Response toResponse(ServiceException exception) {
        ResponseBuilder builder = Response.status(exception.getStatusCode());

        if (exception.getErrors() != null && exception.getErrors().getErrors().size() > 0) {
            builder.entity(exception.getErrors());
            // TODO set it from request context.
            builder.type(MediaType.APPLICATION_JSON);
        }

        return builder.build();
    }
}