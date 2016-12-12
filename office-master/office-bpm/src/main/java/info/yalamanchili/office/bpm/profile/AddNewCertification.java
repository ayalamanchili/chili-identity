/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.profile;

import info.yalamanchili.office.dao.profile.CertificationDao;
import info.yalamanchili.office.entity.profile.Certification;
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
public class AddNewCertification {

    public void addCertWithDesc(String certname, String desc) {
        Certification cert = new Certification();
        cert.setName(certname);
        cert.setDescription(desc);
        CertificationDao.instance().save(cert);
    }

    public void addCert(String certname) {
        Certification cert = new Certification();
        cert.setName(certname);
        CertificationDao.instance().save(cert);
    }

}
