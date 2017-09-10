/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.univaq.disim.mobile.cityshop.business;

import it.univaq.disim.mobile.cityshop.business.domain.Brand;
import it.univaq.disim.mobile.cityshop.business.domain.Categoria;
import it.univaq.disim.mobile.cityshop.business.domain.Session;
import it.univaq.disim.mobile.cityshop.business.domain.Negozio;
import it.univaq.disim.mobile.cityshop.business.domain.Prodotto;
import it.univaq.disim.mobile.cityshop.business.domain.Utente;
import java.util.List;

/**
 *
 * @author cityshop
 */
public interface CityShopService {
    
    Session login(String mail, String password);

    void logout(String token);

    void createUser(Utente user);

    void updateUser(String token, Utente user);
    
    List<Negozio> getStores(String token, float latitude, float longitude);
    
    Negozio getStore(int id);
    
    List<Prodotto> getProducts(Negozio store);
    
    Prodotto getProduct(int id);
    
    List<Categoria> getUserCategories(String token);
    
    List<Categoria> getStoreCategories(int id);
    
    Categoria getProductCategory(int id);
    
    List<Brand> getUserBrands(String token);
    
    List<Brand> getStoreBrands(int id);
    
    Brand getProductBrand(int id);
    
}
