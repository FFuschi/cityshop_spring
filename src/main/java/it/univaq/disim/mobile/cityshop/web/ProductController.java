/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.univaq.disim.mobile.cityshop.web;

import it.univaq.disim.mobile.cityshop.business.CityShopService;
import it.univaq.disim.mobile.cityshop.business.domain.Brand;
import it.univaq.disim.mobile.cityshop.business.domain.Categoria;
import it.univaq.disim.mobile.cityshop.business.domain.Negozio;
import it.univaq.disim.mobile.cityshop.business.domain.Prodotto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ProductController {
    @Autowired
    private CityShopService service;
    
    @PostMapping("/products")
    public Response getProducts(@RequestBody Negozio n) {
        Negozio store = service.getStore(n.getId());
        if (store!= null){
           Response<List<Prodotto>> result = new Response<>(true, Response.DEFAULT_RESPONSE_OK.getMessage());
            result.setData(service.getProducts(store));
            return result; 
        } else {
            return Response.DEFAULT_RESPONSE_KO;
        }
        
    }
    
    @PostMapping("/product")
    public Response getProduct(@RequestBody Prodotto p) {
        Prodotto product = service.getProduct(p.getId());
        if (product!= null){
           Response<Prodotto> result = new Response<>(true, Response.DEFAULT_RESPONSE_OK.getMessage());
            result.setData(product);
            return result; 
        } else {
            return Response.DEFAULT_RESPONSE_KO;
        }
        
    }
    
    @PostMapping("/product/category")
    public Response getCategoryProduct(@RequestBody Prodotto p) {
        Categoria category = service.getProductCategory(p.getId());
        if (category!= null){
           Response<Categoria> result = new Response<>(true, Response.DEFAULT_RESPONSE_OK.getMessage());
            result.setData(category);
            return result; 
        } else {
            return Response.DEFAULT_RESPONSE_KO;
        }
    }
    
    @PostMapping("/product/brand")
    public Response getBrandProduct(@RequestBody Prodotto p) {
        Brand brand = service.getProductBrand(p.getId());
        if (brand!= null){
           Response<Brand> result = new Response<>(true, Response.DEFAULT_RESPONSE_OK.getMessage());
            result.setData(brand);
            return result; 
        } else {
            return Response.DEFAULT_RESPONSE_KO;
        }
    }
}
