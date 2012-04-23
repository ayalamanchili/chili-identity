package info.yalamanchili.office.jrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.transaction.annotation.Transactional;

@Produces("application/json")
@Consumes("application/json")
@Transactional
public class AdminResource {

}
