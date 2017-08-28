package it.univaq.disim.mobile.cityshop.business.impl;

import it.univaq.disim.mobile.cityshop.business.CityShopService;
import it.univaq.disim.mobile.cityshop.business.domain.Session;
import it.univaq.disim.mobile.cityshop.business.domain.Utente;
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
    public void createUser(Utente user) {
        userRepository.save(user);
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
}
