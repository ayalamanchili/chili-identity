/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.ext;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.ext.QuestionDao;
import info.yalamanchili.office.dto.ext.QuestionDto;
import info.yalamanchili.office.entity.ext.Question;
import info.yalamanchili.office.entity.ext.QuestionType;
import info.yalamanchili.office.ext.QuestionService;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anuyalamanchili
 */
@Path("secured/question")
@Component
@Transactional
@Scope("request")
public class QuestionResource extends CRUDResource<Question> {

    @Autowired
    public QuestionDao questionDao;

    @Override
    public CRUDDao getDao() {
        return questionDao;
    }

    @Autowired
    public QuestionService questionService;

    @GET
    @Path("/by-type/{start}/{limit}")
    public List<QuestionDto> getQuestions(@QueryParam("type") QuestionType type, @PathParam("start") int start, @PathParam("limit") int limit) {
        return questionService.getQuestions(type, start, limit);

    }

    @GET
    @Path("/{start}/{limit}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR')")
    public QuestionTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        QuestionTable tableObj = new QuestionTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @XmlRootElement
    @XmlType
    public static class QuestionTable implements java.io.Serializable {

        protected Long size;
        protected List<Question> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<Question> getEntities() {
            return entities;
        }

        public void setEntities(List<Question> entities) {
            this.entities = entities;
        }
    }
}
