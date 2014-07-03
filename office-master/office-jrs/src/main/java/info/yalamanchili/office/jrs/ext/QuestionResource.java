/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.ext;

import info.yalamanchili.office.dto.ext.QuestionDto;
import info.yalamanchili.office.entity.ext.QuestionType;
import info.yalamanchili.office.ext.QuestionService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
public class QuestionResource {

    @Autowired
    public QuestionService questionService;

    @GET
    @Path("/{start}/{limit}")
    public List<QuestionDto> getComments(@QueryParam("type") QuestionType type, @PathParam("start") int start, @PathParam("limit") int limit) {
        return questionService.getQuestions(type, start, limit);

    }
}
