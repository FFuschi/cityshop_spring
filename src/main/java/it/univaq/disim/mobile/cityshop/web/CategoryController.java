/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.univaq.disim.mobile.cityshop.web;

import it.univaq.disim.mobile.cityshop.business.CityShopService;
import it.univaq.disim.mobile.cityshop.business.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pio-9
 */
@RestController
@RequestMapping("/api")
public class CategoryController {
    
    @Autowired
    private CityShopService service;

    @PostMapping("/categories")
    public Response getCategories() {
        List<Categoria> categories = service.getCategories();
        if (categories!= null){
           Response<List<Categoria>> result = new Response<>(true, Response.DEFAULT_RESPONSE_OK.getMessage());
            result.setData(categories);
            return result; 
        } else {
            return Response.DEFAULT_RESPONSE_KO;
        }
    }
    
    @PostMapping("/categories/add/{token}")
    public Response addCategoryUser(@PathVariable String token, @RequestBody Categoria category) {
        if (category!= null){
            service.addUserCategory(token, category);
           Response<Categoria> result = new Response<>(true, Response.DEFAULT_RESPONSE_OK.getMessage());
            result.setData(category);
            return result; 
        } else {
            return Response.DEFAULT_RESPONSE_KO;
        }
    }
    
    @PostMapping("/categories/remove/{token}")
    public Response removeCategoryUser(@PathVariable String token, @RequestBody Categoria category) {
        if (category!= null){
            service.removeUserCategory(token, category);
           Response<Categoria> result = new Response<>(true, Response.DEFAULT_RESPONSE_OK.getMessage());
            result.setData(category);
            return result; 
        } else {
            return Response.DEFAULT_RESPONSE_KO;
        }
    }
    
}
