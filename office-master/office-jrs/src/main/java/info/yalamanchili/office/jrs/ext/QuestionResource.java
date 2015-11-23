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
import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.ext.QuestionDao;
import info.yalamanchili.office.dto.ext.QuestionDto;
import info.yalamanchili.office.entity.ext.Question;
import info.yalamanchili.office.entity.ext.QuestionCategory;
import info.yalamanchili.office.entity.ext.QuestionContext;
import info.yalamanchili.office.ext.QuestionService;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    @Path("/query/{start}/{limit}")
    @Cacheable(OfficeCacheKeys.QUESTIONS)
    //TODO this should belong to perf evalu res
    public List<QuestionDto> getQuestions(@QueryParam("category") QuestionCategory category, @QueryParam("context") QuestionContext context, @QueryParam("fyYear") Integer fyYear, @PathParam("start") int start, @PathParam("limit") int limit) {
        if (fyYear != null) {
            Map<String, String> swaps = new HashMap();
            swaps.put("fyYear", fyYear.toString());
            fyYear++;
            swaps.put("nextFyYear", fyYear.toString());
            return questionService.getQuestions(category, context, start, limit, swaps);
        }
        return questionService.getQuestions(category, context, start, limit);

    }

    @PUT
    @Validate
    @Override
    @CacheEvict(value = OfficeCacheKeys.QUESTIONS, allEntries = true)
    public Question save(Question entity) {
        return super.save(entity);
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
