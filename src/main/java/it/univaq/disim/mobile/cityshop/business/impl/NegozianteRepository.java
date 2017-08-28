/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.univaq.disim.mobile.cityshop.business.impl;

import it.univaq.disim.mobile.cityshop.business.domain.Negoziante;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author cityshop
 */
public interface NegozianteRepository extends JpaRepository<Negoziante, Long> {
    
}
