/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.univaq.disim.mobile.cityshop.business.impl;

import it.univaq.disim.mobile.cityshop.business.domain.Brand;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author cityshop
 */
public interface BrandRepository extends JpaRepository<Brand, Long> {
    
    @Query("SELECT brands "
            + "FROM Utente user "
            + "JOIN user.brands brands "
            + "WHERE user.email = :mail"
    )
    List<Brand> findForUser(
            @Param("mail") String email
    );
    
    @Query("SELECT brands "
            + "FROM Prodotto product "
            + "JOIN product.brand brands "
            + "JOIN product.negozio store "
            + "WHERE store.id = :id "
            + "GROUP BY brands"
    )
    List<Brand> findForStore(
            @Param("id") int id
    );
    
    @Query("SELECT brands "
            + "FROM Prodotto product "
            + "JOIN product.brand brands "
            + "WHERE product.id = :id"
    )
    Brand findForProduct(
            @Param("id") int id
    );
}
