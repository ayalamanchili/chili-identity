/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.cits;
import java.util.*;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.Address;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author anu
 */
@Component
@Transactional
public class CitsService 
{

    @PersistenceContext
    protected EntityManager em;

    @Async
    public void pushNewEmployeeInformation(Employee employee) {
        //TODO implement logic to push emp data to cits database
        JdbcTemplate jTemplate=new  JdbcTemplate();
        jTemplate.update("insert into tbl_Consultant_Master(Consultant_FirstName,Consultant_LastName,Consultant_Email,Consultant_HomeCountryAddress,"
                + "Consultant_City,Consultant_State,Consultant_Zip,Consultant_Phone,)  "
                + "values()");
        List<Address> addr=employee.getAddresss();
        
    }

    @Async
    public void syncEmployeeInformation() {
    }
}
