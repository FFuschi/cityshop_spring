package it.univaq.disim.mobile.cityshop.business.impl;

import it.univaq.disim.mobile.cityshop.business.CityShopService;
import it.univaq.disim.mobile.cityshop.business.domain.Brand;
import it.univaq.disim.mobile.cityshop.business.domain.Categoria;
import it.univaq.disim.mobile.cityshop.business.domain.Negozio;
import it.univaq.disim.mobile.cityshop.business.domain.Prodotto;
import it.univaq.disim.mobile.cityshop.business.domain.Session;
import it.univaq.disim.mobile.cityshop.business.domain.Utente;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CityShopServiceImpl implements CityShopService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private UtenteRepository userRepository;
    
    @Autowired
    private NegozioRepository storeRepository;
    
    @Autowired
    private ProdottoRepository productRepository;
    
    @Autowired
    private CategoriaRepository categoryRepository;
    
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Session login(String mail, String password) {
        Utente user = userRepository.findByEmail(mail);
        if (user != null && user.getPassword().equals(password)) {
            Session session = new Session();
            session.setUser(user);
            session.setToken(Utility.generateToken());
            Session newSession = sessionRepository.save(session);
            return newSession;
        } else {
            return null;
        }
    }

    @Override
    public void logout(String token) {
        Session session = sessionRepository.findByToken(token);
        if (session != null) {
            sessionRepository.delete(session);
        }
    }

    @Override
    public void createUser(Utente user, Set<Categoria> categories, Set<Brand> brands) {
        Utente newuser = user;
        newuser.setCategorie(categories);
        newuser.setBrands(brands);
        userRepository.save(newuser);
    }

    @Override
    public void updateUser(String token, Utente user) {
        Session session = sessionRepository.findByToken(token);
        if (session != null) {
            Utente oldUser = session.getUser();
            if (user.getNome()!= null && !user.getNome().equals("")){
                oldUser.setNome(user.getNome());
            } 
            if (user.getCognome()!= null && !user.getCognome().equals("")){
                oldUser.setCognome(user.getCognome());
            } 
            if (user.getFoto()!= null && !user.getFoto().equals("")){
                oldUser.setFoto(user.getFoto());
            } 
            if (user.getPassword()!= null && !user.getPassword().equals("")){
                oldUser.setPassword(user.getPassword());
            }   
     
        }

    }

    @Override
    public List<Negozio> getStores(String token, float latitude, float longitude) {
        Session session = sessionRepository.findByToken(token);
        if (session != null) {
            float difference = 0.03f;
            Utente user = session.getUser();
            Set<Categoria> category = user.getCategorie();
            Set<Brand> brands = user.getBrands();
            if (category.isEmpty()){
                Categoria cat = new Categoria();
                cat.setNome("notSelected");
                cat.setFoto("notSelected");
                category.add(cat);
            }
            
            if (brands.isEmpty()){
                Brand brand = new Brand();
                brand.setNome("notSelected");
                brand.setFoto("notSelected");
                brands.add(brand);
            }
            List<Negozio> store = storeRepository.findBy(
                latitude-difference, 
                latitude+difference, 
                longitude-difference, 
                longitude+difference,
                category,
                brands
            );
            return store;
        }
        return null;
    }

    @Override
    public Negozio getStore(int id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Prodotto> getProducts(Negozio store) {
        return productRepository.findByNegozio(store);
    }

    @Override
    public Prodotto getProduct(int id) {
        return productRepository.findById(id);
    }
    
    @Override
    public List<Categoria> getCategories() {
        return categoryRepository.findAll();
    }
    
    @Override
    public List<Categoria> getAllUserCategories(String token) {
        Session session = sessionRepository.findByToken(token);
        if (session != null) {
            List<Categoria> temp = categoryRepository.findForUser(session.getUser().getEmail());
            return temp;
        } 
        return null;
    }

    @Override
    public List<Categoria> getUserCategories(String token) {
        Session session = sessionRepository.findByToken(token);
        if (session != null) {
            List<Categoria> temp = categoryRepository.findForUser(session.getUser().getEmail());
            List<Categoria> returnList = new ArrayList();
            int i = 0;
            for(Categoria item: temp){
                if(i<3)
                    returnList.add(item);
                i++;
            }
            return returnList;
        } 
        return null;
    }

    @Override
    public List<Categoria> getStoreCategories(int id) {
        List<Categoria> temp = categoryRepository.findForStore(id);
        List<Categoria> returnList = new ArrayList();
        int i = 0;
        for(Categoria item: temp){
            if(i<3)
                returnList.add(item);
            i++;
        }
        return returnList;
    }

    @Override
    public Categoria getProductCategory(int id) {
        return categoryRepository.findForProduct(id);
    }
    
    @Override
    public void addUserCategory(String token, Categoria category) {
        Session session = sessionRepository.findByToken(token);
        if (session != null) {
            Categoria add = categoryRepository.findByNome(category.getNome());
            if (add != null){
                Utente user = session.getUser();
                user.getCategorie().add(add);
            }
            
        }
    }
    
    @Override
    public void removeUserCategory(String token, Categoria category) {
        Session session = sessionRepository.findByToken(token);
        if (session != null) {
            Categoria add = categoryRepository.findByNome(category.getNome());
            if (add != null){
                Utente user = session.getUser();
                user.getCategorie().remove(add);
            }
            
        }
    }
    
    @Override
    public List<Brand> getBrands() {
        return brandRepository.findAll();
    }
    
    @Override
    public List<Brand> getAllUserBrands(String token) {
        Session session = sessionRepository.findByToken(token);
        if (session != null) {
            List<Brand> temp = brandRepository.findForUser(session.getUser().getEmail());
            return temp;
        } 
        return null;
    }
    
    @Override
    public List<Brand> getUserBrands(String token) {
        Session session = sessionRepository.findByToken(token);
        if (session != null) {
            List<Brand> temp = brandRepository.findForUser(session.getUser().getEmail());
            List<Brand> returnList = new ArrayList();
            int i = 0;
            for(Brand item: temp){
                if(i<3)
                    returnList.add(item);
                i++;
            }
            return returnList;
        } 
        return null;
    }

    @Override
    public List<Brand> getStoreBrands(int id) {
        List<Brand> temp = brandRepository.findForStore(id);
        List<Brand> returnList = new ArrayList();
        int i = 0;
        for(Brand item: temp){
            if(i<3)
                returnList.add(item);
            i++;
        }
        return returnList;
    }

    @Override
    public Brand getProductBrand(int id) {
        return brandRepository.findForProduct(id);
    }
    
    @Override
    public void addUserBrand(String token, Brand brand){
        Session session = sessionRepository.findByToken(token);
        if (session != null) {
            Brand add = brandRepository.findByNome(brand.getNome());
            if(add != null){
                Utente user = session.getUser();
                user.getBrands().add(add);
            }
            
        }
    }
    
    @Override
    public void removeUserBrand(String token, Brand brand){
        Session session = sessionRepository.findByToken(token);
        if (session != null) {
            Brand add = brandRepository.findByNome(brand.getNome());
            if(add != null){
                Utente user = session.getUser();
                user.getBrands().remove(add);
            }
            
        }
    }
    
    @Override
    public boolean getUser(String email){
        Utente user = userRepository.findByEmail(email);
        if(user != null) {
            return true;
        } else {
            return false;
        }
    }

}
