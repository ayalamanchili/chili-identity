/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.profile;

import info.yalamanchili.office.dao.profile.SkillDao;
import info.yalamanchili.office.entity.profile.Skill;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ramana.Lukalapu
 */
@Component
@Scope("prototype")
@Transactional
public class AddNewSkill {

    public void addSkillWithDesc(String skillname, String desc) {
        Skill skill = new Skill();
        skill.setName(skillname);
        skill.setDescription(desc);
        SkillDao.instance().save(skill);
    }
    public void addSkill(String skillname) {
        Skill skill = new Skill();
        skill.setName(skillname);
        SkillDao.instance().save(skill);
    }
}
