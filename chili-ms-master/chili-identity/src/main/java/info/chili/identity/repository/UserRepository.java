/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.identity.repository;

import info.chili.identity.jpa.CUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ayalamanchili
 */
public interface UserRepository extends JpaRepository<CUser, Long> {
}
