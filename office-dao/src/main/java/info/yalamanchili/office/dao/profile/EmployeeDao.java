/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.EmergencyContact;
import info.yalamanchili.office.entity.profile.SkillSet;
import info.yalamanchili.office.entity.social.Post;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class EmployeeDao extends CRUDDao<Employee> {

    @PersistenceContext
    protected EntityManager em;

    public EmployeeDao() {
        super(Employee.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void delete(Long id) {
        try {
            Employee emp = findById(id);
           
            //ClientInformation
            for (ClientInformation clientinformation : emp.getClientInformations()) {
                em.remove(clientinformation);
            }
            
            //EmergencyContact
            for (EmergencyContact emergencycontact : emp.getEmergencyContacts()) {
                em.remove(emergencycontact);
            }
            //Post
            for (Post post : emp.getPosts()) {
                em.remove(post);
            }
            //SkillSet
            SkillSet skillset = emp.getSkillSet(); 
            em.remove(skillset);
            
            //Address
            for (Address address : emp.getAddresss()) {
                em.remove(address);
            }
            //Email
            for (Email email : emp.getEmails()) {
                em.remove(email);
            }
            //Phones
            for (Phone phone : emp.getPhones()) {
                em.remove(phone);
            }
            //Finally Employee
            em.remove(emp);
            em.flush();
            
            
        } catch (javax.persistence.PersistenceException e) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "DELETE", "SQLError", "Cannot delete due to associated data");
        }
    }
}
