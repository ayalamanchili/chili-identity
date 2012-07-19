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
import org.springframework.jdbc.datasource.DriverManagerDataSource;

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
    public void pushNewEmployeeInformation(Employee employee) 
    {
        //TODO implement logic to push emp data to cits database
        try
        {
        JdbcTemplate jTemplate=new  JdbcTemplate();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSource.setUrl("jdbc:sqlserver://SSTECHLAPTOP11;DatabaseName=CITS");
		dataSource.setUsername("sa");
		dataSource.setPassword("sstech1!");
        jTemplate.setDataSource(dataSource);
        List<Address> addr=employee.getAddresss(); 
        
        jTemplate.update("insert into tbl_Consultant_Master(Consultant_FirstName,Consultant_LastName,Consultant_Email,Consultant_HomeCountryAddress,"
                + "Consultant_City,Consultant_State,Consultant_Zip,Consultant_Phone)  "
                + "values("+employee.getFirstName()+","+employee.getLastName()+","+
                employee.getPrimaryEmail()+","+"''"+addr.get(0).getCity()+","+addr.get(0).getState()+","+
                addr.get(0).getZip()+","+addr.get(0).getContact().getPhones().get(0).getPhoneNumber() +")");
        
        }
        catch(Exception ex)
        {
             
        }
    }

    @Async
    public void syncEmployeeInformation() {
    }
}
