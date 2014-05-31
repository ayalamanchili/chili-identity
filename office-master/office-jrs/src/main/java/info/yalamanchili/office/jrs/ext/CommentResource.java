/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.ext;

import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.entity.ext.Comment;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    @Path("{targetClassName}/{id}")
    public void save(@PathParam("targetClassName") String targetClassName, @PathParam("id") Long id, Comment comment) {
        commentDao.save(comment, id, targetClassName);
    }

    @XmlRootElement
    @XmlType
    public static class CommentTable {

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
