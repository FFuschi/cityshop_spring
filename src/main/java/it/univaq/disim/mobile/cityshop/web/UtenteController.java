package it.univaq.disim.mobile.cityshop.web;

import it.univaq.disim.mobile.cityshop.business.CityShopService;
import it.univaq.disim.mobile.cityshop.business.domain.Brand;
import it.univaq.disim.mobile.cityshop.business.domain.Categoria;
import it.univaq.disim.mobile.cityshop.business.domain.Session;
import it.univaq.disim.mobile.cityshop.business.domain.Utente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UtenteController {

    @Autowired
    private CityShopService service;

    @PostMapping("/login")
    public Response login(@RequestBody Utente u) {
        Session session = service.login(u.getEmail(), u.getPassword());
        if (session != null) {
            Response<Login> result = new Response<>(true, Response.DEFAULT_RESPONSE_OK.getMessage());
            Login login = new Login();
            login.setToken(session.getToken());
            login.setFirstname(session.getUser().getNome());
            login.setLastname(session.getUser().getCognome());
            login.setImage(session.getUser().getFoto());
            login.setEmail(session.getUser().getEmail());
            result.setData(login);
            return result;
        } else {
            return Response.DEFAULT_RESPONSE_KO;
        }

    }

    @GetMapping("/logout/{token}")
    public Response logout(@PathVariable String token) {
        service.logout(token);
        return Response.DEFAULT_RESPONSE_OK;
    }

    @PostMapping("/users")
    public Response createUser(@RequestBody RequestWrapperSingUp singup) {
        service.createUser(singup.getUser(), singup.getCategories(), singup.getBrands());
        return Response.DEFAULT_RESPONSE_OK;
    }

    @PutMapping("/users/{token}")
    public Response updateUser(@RequestBody Utente user, @PathVariable String token) {
        service.updateUser(token, user);
        return Response.DEFAULT_RESPONSE_OK;
    }
    
    @PostMapping("/category/{token}")
    public Response getCategoryUser(@PathVariable String token) {
        List<Categoria> categories = service.getUserCategories(token);
        if (categories!= null){
           Response<List<Categoria>> result = new Response<>(true, Response.DEFAULT_RESPONSE_OK.getMessage());
            result.setData(categories);
            return result; 
        } else {
            return Response.DEFAULT_RESPONSE_KO;
        }
    }

    @PostMapping("/brand/{token}")
    public Response getBrandUser(@PathVariable String token) {
        List<Brand> brands = service.getUserBrands(token);
        if (brands!= null){
           Response<List<Brand>> result = new Response<>(true, Response.DEFAULT_RESPONSE_OK.getMessage());
            result.setData(brands);
            return result; 
        } else {
            return Response.DEFAULT_RESPONSE_KO;
        }
    }

    @PostMapping("/category/all/{token}")
    public Response getAllCategoryUser(@PathVariable String token) {
        List<Categoria> categories = service.getAllUserCategories(token);
        if (categories!= null){
           Response<List<Categoria>> result = new Response<>(true, Response.DEFAULT_RESPONSE_OK.getMessage());
            result.setData(categories);
            return result; 
        } else {
            return Response.DEFAULT_RESPONSE_KO;
        }
    }

    @PostMapping("/brand/all/{token}")
    public Response getAllBrandUser(@PathVariable String token) {
        List<Brand> brands = service.getAllUserBrands(token);
        if (brands!= null){
           Response<List<Brand>> result = new Response<>(true, Response.DEFAULT_RESPONSE_OK.getMessage());
            result.setData(brands);
            return result; 
        } else {
            return Response.DEFAULT_RESPONSE_KO;
        }
    }
}
