/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.identity.dao;

import info.chili.identity.domain.CUser;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author phani.y
 */
public interface UserRepository extends PagingAndSortingRepository<CUser, Long> {

    CUser findByUsername(String username);
}
