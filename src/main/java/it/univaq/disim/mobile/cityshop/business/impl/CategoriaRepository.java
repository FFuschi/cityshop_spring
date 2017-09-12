/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.univaq.disim.mobile.cityshop.business.impl;

import it.univaq.disim.mobile.cityshop.business.domain.Categoria;
import java.awt.print.Pageable;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author cityshop
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
    @Query("SELECT categories "
            + "FROM Utente user "
            + "JOIN user.categorie categories "
            + "WHERE user.email = :mail "
            + "AND categories.nome != 'notSelected'"
    )
    List<Categoria> findForUser(
            @Param("mail") String email
    );
    
    @Query("SELECT categories "
            + "FROM Prodotto product "
            + "JOIN product.categoria categories "
            + "JOIN product.negozio store "
            + "WHERE store.id = :id "
            + "GROUP BY categories"
    )
    List<Categoria> findForStore(
            @Param("id") int id
    );
    
    @Query("SELECT categories "
            + "FROM Prodotto product "
            + "JOIN product.categoria categories "
            + "WHERE product.id = :id"
    )
    Categoria findForProduct(
            @Param("id") int id
    );
    
    @Query("SELECT categories "
            + "FROM Categoria categories "
            + "WHERE categories.nome != 'notSelected'"
    )
    @Override
    List<Categoria> findAll();
    
    Categoria findByNome(String nome);
}
