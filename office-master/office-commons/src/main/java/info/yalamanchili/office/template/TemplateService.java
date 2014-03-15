/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.template;

import info.chili.spring.SpringContext;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring3.SpringTemplateEngine;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("prototype")
public class TemplateService {

    @Autowired
    SpringTemplateEngine templateEngine;

    public String process(String templateName, Object entity) {
        return process(templateName, "entity", entity);
    }

    public String process(String templateName, String entityName, Object entity) {
        final Context ctx = new Context();
        ctx.setVariable(entityName, entity);
        return templateEngine.process(templateName, ctx);
    }

    public String process(String templateName, Map<String, Object> vars) {
        final Context ctx = new Context();
        ctx.setVariables(vars);
        return templateEngine.process(templateName, ctx);
    }

    public String processTemplate(String templateName, Context ctx) {
        return templateEngine.process(templateName, ctx);
    }

    public static TemplateService instance() {
        return SpringContext.getBean(TemplateService.class);
    }
}
