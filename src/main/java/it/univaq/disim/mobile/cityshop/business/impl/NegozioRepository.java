/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.univaq.disim.mobile.cityshop.business.impl;

import it.univaq.disim.mobile.cityshop.business.domain.Brand;
import it.univaq.disim.mobile.cityshop.business.domain.Categoria;
import it.univaq.disim.mobile.cityshop.business.domain.Negozio;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author cityshop
 */
public interface NegozioRepository extends JpaRepository<Negozio, Long> {
    
    @Query("SELECT store "
            + "FROM Prodotto product "
            + "JOIN product.negozio store "
            + "WHERE store.latitudine BETWEEN :lat1 AND :lat2 "
            + "AND store.longitudine BETWEEN :log1 AND :log2 "
            + "AND (product.categoria IN :cat "
            + "OR product.brand IN :brand) "
            + "GROUP BY store"
    )
    List<Negozio> findBy(
            @Param("lat1") float lat_1, 
            @Param("lat2") float lat_2, 
            @Param("log1") float long_1, 
            @Param("log2") float long_2, 
            @Param("cat") Set<Categoria> category,
            @Param("brand") Set<Brand> brands
    );
    
    Negozio findById(int id);
}
