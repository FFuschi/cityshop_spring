/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.univaq.disim.mobile.cityshop.web;

import it.univaq.disim.mobile.cityshop.business.domain.Brand;
import it.univaq.disim.mobile.cityshop.business.domain.Categoria;
import it.univaq.disim.mobile.cityshop.business.domain.Utente;
import java.util.Set;

/**
 *
 * @author pio-9
 */
public class RequestWrapperSingUp {
    
    private Utente user;
    private Set<Categoria> categories;
    private Set<Brand> brands;

    public void setUser(Utente user) {
        this.user = user;
    }

    public void setCategories(Set<Categoria> categories) {
        this.categories = categories;
    }

    public void setBrands(Set<Brand> brands) {
        this.brands = brands;
    }

    public Utente getUser() {
        return user;
    }

    public Set<Categoria> getCategories() {
        return categories;
    }

    public Set<Brand> getBrands() {
        return brands;
    }
}
