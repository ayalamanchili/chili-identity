/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.reports.recruiting;

import static org.junit.Assert.*;

/**
 *
 * @author ayalamanchili
 */
public class RecruitingReportsServiceTest {

    public RecruitingReportsServiceTest() {
    }

//    @Test
    public void testGetSearchSkillSetQueryString() {
        System.out.println("getSearchSkillSetQueryString");
        SkillSetSearchDto searchDto = new SkillSetSearchDto();
        searchDto.setPractice("oracle");
        RecruitingReportsService instance = new RecruitingReportsService();
        assertEquals("from SkillSet, Employee emp where employee=emp and practice.name like %oracle%", instance.getSearchSkillSetQueryString(searchDto));
    }

}
