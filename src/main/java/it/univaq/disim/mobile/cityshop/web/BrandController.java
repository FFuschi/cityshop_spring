/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.univaq.disim.mobile.cityshop.web;

import it.univaq.disim.mobile.cityshop.business.CityShopService;
import it.univaq.disim.mobile.cityshop.business.domain.Brand;
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
public class BrandController {
    
        @Autowired
    private CityShopService service;

    @PostMapping("/brands")
    public Response getBrands() {
        List<Brand> brands = service.getBrands();
        if (brands!= null){
           Response<List<Brand>> result = new Response<>(true, Response.DEFAULT_RESPONSE_OK.getMessage());
            result.setData(brands);
            return result; 
        } else {
            return Response.DEFAULT_RESPONSE_KO;
        }
    }
    
    @PostMapping("/brands/add/{token}")
    public Response addBrandUser(@PathVariable String token, @RequestBody Brand brand) {
        if (brand!= null){
            service.addUserBrand(token, brand);
           Response<Brand> result = new Response<>(true, Response.DEFAULT_RESPONSE_OK.getMessage());
            result.setData(brand);
            return result; 
        } else {
            return Response.DEFAULT_RESPONSE_KO;
        }
    }
    
    @PostMapping("/brands/remove/{token}")
    public Response removeBrandUser(@PathVariable String token, @RequestBody Brand brand) {
        if (brand!= null){
            service.removeUserBrand(token, brand);
           Response<Brand> result = new Response<>(true, Response.DEFAULT_RESPONSE_OK.getMessage());
            result.setData(brand);
            return result; 
        } else {
            return Response.DEFAULT_RESPONSE_KO;
        }
    }
    
}
