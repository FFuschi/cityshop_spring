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
import java.util.Set;

/**
 *
 * @author cityshop
 */
public interface CityShopService {
    
    Session login(String mail, String password);

    void logout(String token);

    void createUser(Utente user, Set<Categoria> categories, Set<Brand> brands);

    void updateUser(String token, Utente user);
    
    List<Negozio> getStores(String token, float latitude, float longitude);
    
    Negozio getStore(int id);
    
    List<Prodotto> getProducts(Negozio store);
    
    Prodotto getProduct(int id);
    
    List<Categoria> getCategories();
    
    List<Categoria> getAllUserCategories(String token);
    
    List<Categoria> getUserCategories(String token);
    
    List<Categoria> getStoreCategories(int id);
    
    Categoria getProductCategory(int id);
    
    void addUserCategory(String token, Categoria category);
    
    void removeUserCategory(String token, Categoria category);
    
    List<Brand> getBrands();
    
    List<Brand> getAllUserBrands(String token);
    
    List<Brand> getUserBrands(String token);
    
    List<Brand> getStoreBrands(int id);
    
    Brand getProductBrand(int id);
    
    void addUserBrand(String token, Brand brand);
    
     void removeUserBrand(String token, Brand brand);
     
    public boolean getUser(String email);
    
}
