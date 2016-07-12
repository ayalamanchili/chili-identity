/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.ext;

import com.google.common.base.Strings;
import info.chili.service.jrs.types.Entry;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.chili.email.Email;
import info.chili.jpa.AbstractEntity;
import info.chili.jpa.AbstractHandleEntity;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.hr.ProspectDao;
import info.yalamanchili.office.entity.ext.Comment;
import info.yalamanchili.office.entity.hr.Prospect;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Path("secured/comment")
@Component
@Transactional
@Scope("request")
//TODO create abstractREsource for ext
@Produces("application/json")
@Consumes("application/json")
public class CommentResource {

    @Autowired
    public CommentDao commentDao;

    @GET
    @Path("{targetClassName}/{id}/{start}/{limit}")
    public CommentTable getComments(@PathParam("targetClassName") String targetClassName, @PathParam("id") Long id, @PathParam("start") int start, @PathParam("limit") int limit) {
        CommentTable table = new CommentTable();
        List<Comment> comments = commentDao.findAll(id, targetClassName);
        table.setEntities(comments);
        table.setSize(Integer.valueOf(comments.size()).longValue());
        return table;

    }

    @PUT
    public void save(Comment comment) {
        Comment entity = commentDao.find(comment.getId());
        entity.setComment(comment.getComment());
        entity.setRating(comment.getRating());
        //TODO set notify emps
        commentDao.save(entity);
    }

    @PUT
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        Comment comment = commentDao.find(id);
        if (comment.getId() != null) {
            commentDao.delete(id);
        }
    }

    @PUT
    @Path("{targetClassName}/{id}")
    public void save(@PathParam("targetClassName") String targetClassName, @PathParam("id") Long id, Comment comment) {
        if (Strings.isNullOrEmpty(comment.getUpdatedBy())) {
            Employee emp = OfficeSecurityService.instance().getCurrentUser();
            comment.setUpdatedBy(emp.getFirstName() + " " + emp.getLastName());
        }
        if (comment.getUpdatedTS() == null) {
            comment.setUpdatedTS(new Date());
        }
        if (Prospect.class.getCanonicalName().equals(targetClassName)) {
            if (comment.getStage() == null) {
                comment.setStage(ProspectDao.instance().findById(id).getStatus().name());
            }
        }
        String emaillist = "Comment : " + comment.getComment() + " - Comment Notification Email sent to :";
        Set<String> tos = new HashSet();
        List<Entry> notifyEmployees = new ArrayList();
        if (comment.getNotifyEmployees() != null) {
            notifyEmployees = comment.getNotifyEmployees();
                for (Entry entry : notifyEmployees) {
                    Employee emp = EmployeeDao.instance().findEmployeWithEmpId(entry.getId());
                    tos.add(emp.getPrimaryEmail().getEmail());
                }
                for (String to : tos) {
                    emaillist = emaillist.concat(to + " , ");
                }
                comment.setComment(emaillist);
        }
        comment = commentDao.save(comment, id, targetClassName);
        
        try {
            Object targetClassObject = commentDao.getEntityManager().find(Class.forName(targetClassName), id);
            if(targetClassObject instanceof AbstractHandleEntity){
               sendCommentNotification(notifyEmployees, comment,(AbstractHandleEntity) commentDao.getEntityManager().find(Class.forName(targetClassName), id) );
            }else
            {
               sendCommentNotification(notifyEmployees, comment,(AbstractEntity) commentDao.getEntityManager().find(Class.forName(targetClassName), id) );
            }
            
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    protected void sendCommentNotification(List<Entry> notifyEmployees, Comment comment, Object targetClassObject) {
        if (notifyEmployees == null) {
            return;
        }
        Email email = new Email();
        for (Entry e : notifyEmployees) {
            Employee emp = EmployeeDao.instance().findEmployeWithEmpId(e.getId());
            if (emp != null) {
                email.addTo(EmployeeDao.instance().getPrimaryEmail(emp));
            }
        }
        
        HashMap<String, Object> emailContext = new HashMap();
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        
        if(targetClassObject instanceof AbstractHandleEntity){
            AbstractHandleEntity entity = (AbstractHandleEntity) targetClassObject;
         email.setSubject("Comment added by:" + currentUser.getFirstName() + "" + currentUser.getLastName() + " on " + entity.getClass().getSimpleName());
        emailContext.put("createdBy", currentUser.getFirstName() + "" + currentUser.getLastName());
        emailContext.put("comment", comment.getComment());
        emailContext.put("reference", entity.getClass().getSimpleName());
        emailContext.put("description", "");
        emailContext.put("comments", commentDao.findAll(entity.getId(), entity.getClass().getCanonicalName()));
        emailContext.put("commentReferenceURL", OfficeServiceConfiguration.instance().getPortalWebUrl() + "#?entity=" + comment.getTargetEntityName() + "&id=" + comment.getTargetEntityId());
        if (entity.getClass().equals(Prospect.class)) {
            email.setTemplateName("prospects_comment_added_template.html");
        } else {
            email.setTemplateName("comment_added_template.html");
        }
        }else{
             AbstractEntity entity = (AbstractEntity) targetClassObject;
        email.setSubject("Comment added by:" + currentUser.getFirstName() + "" + currentUser.getLastName() + " on " + entity.getClass().getSimpleName());
        emailContext.put("createdBy", currentUser.getFirstName() + "" + currentUser.getLastName());
        emailContext.put("comment", comment.getComment());
        emailContext.put("reference", entity.getClass().getSimpleName());
        emailContext.put("description", ((AbstractEntity) (entity)).describe());
        emailContext.put("comments", commentDao.findAll(entity.getId(), entity.getClass().getCanonicalName()));
        emailContext.put("commentReferenceURL", OfficeServiceConfiguration.instance().getPortalWebUrl() + "#?entity=" + comment.getTargetEntityName() + "&id=" + comment.getTargetEntityId());
           if (entity.getClass().equals(Prospect.class)) {
            email.setTemplateName("prospects_comment_added_template.html");
        } else {
            email.setTemplateName("comment_added_template.html");
        }
        }
        email.setContext(emailContext);
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        email.setHtml(Boolean.TRUE);
        messagingService.sendEmail(email);
    }
    
    @XmlRootElement
    @XmlType
    public static class CommentTable implements java.io.Serializable {

        protected Long size;
        protected List<Comment> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<Comment> getEntities() {
            return entities;
        }

        public void setEntities(List<Comment> entities) {
            this.entities = entities;
        }
    }
}
