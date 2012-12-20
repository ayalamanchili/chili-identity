/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time;

import info.yalamanchili.office.dto.time.TimeSummary;
import info.yalamanchili.office.entity.profile.Employee;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author raghu
 */
@Component
@Scope("request")
public class TimeService {
     @PersistenceContext
    protected EntityManager em;
     
   
     
    public TimeSummary GetTimeSummary(Employee emp)
    {
      String qlString = "SELECT SUM(quickBooksHours), SUM(adpHours) FROM TimeSheet WHERE employee=:employeeparam ";
      Query q = em.createQuery(qlString);
      q.setParameter("employeeparam", emp);
      Object[] row = (Object[])q.getSingleResult();
      TimeSummary ts= new TimeSummary();
      ts.setQuickBooksHours((BigDecimal)row[0]);
      ts.setAdpHours((BigDecimal)row[1]);
      ts.setBalanceHours(ts.getQuickBooksHours().subtract(ts.getAdpHours()));
      return ts;
    }
}

