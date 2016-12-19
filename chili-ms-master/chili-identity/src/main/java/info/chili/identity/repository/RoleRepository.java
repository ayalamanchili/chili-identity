/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.identity.repository;

import info.chili.identity.jpa.CRole;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ayalamanchili
 */
public interface RoleRepository extends CrudRepository<CRole, Long> {
    
}
