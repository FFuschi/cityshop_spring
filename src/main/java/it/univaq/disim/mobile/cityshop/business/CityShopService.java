/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.univaq.disim.mobile.cityshop.business;

import it.univaq.disim.mobile.cityshop.business.domain.Session;
import it.univaq.disim.mobile.cityshop.business.domain.Utente;

/**
 *
 * @author cityshop
 */
public interface CityShopService {
    
    Session login(String mail, String password);

    void logout(String token);

    void createUser(Utente user);

    void updateUser(String token, Utente user);
    
}
