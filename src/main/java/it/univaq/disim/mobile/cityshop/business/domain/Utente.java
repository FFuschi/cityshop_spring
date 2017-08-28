/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.univaq.disim.mobile.cityshop.business.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author cityshop
 */

@Entity
@Table(name = "user")
@DiscriminatorColumn(name="dtype",discriminatorType=DiscriminatorType.STRING)  
@DiscriminatorValue(value="utente")  
public class Utente {
    
    @Id
    @Column(name = "email")
    private String email;
    @Column(name = "firstname", nullable = false, length = 255)
    private String nome;
    @Column(name = "lastname", nullable = false, length = 255)
    private String cognome;
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Column(name = "foto_address", nullable = false, length = 255)
    private String foto;
    @JsonIgnore
    @ManyToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="user_category", joinColumns={@JoinColumn(name="email")}, inverseJoinColumns={@JoinColumn(name="name")}) 
    private Set<Categoria> catecorie = new HashSet<Categoria>(0); 
    @JsonIgnore
    @ManyToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="user_brand", joinColumns={@JoinColumn(name="email")}, inverseJoinColumns={@JoinColumn(name="name")}) 
    private Set<Brand> brands = new HashSet<Brand>(0); 

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    public Set<Categoria> getCatecorie() {
        return catecorie;
    }

    public void setCatecorie(Set<Categoria> catecorie) {
        this.catecorie = catecorie;
    }
    
    public Set<Brand> getBrands() {
        return brands;
    }

    public void setBrands(Set<Brand> brands) {
        this.brands = brands;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.email);
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.cognome);
        hash = 89 * hash + Objects.hashCode(this.password);
        hash = 89 * hash + Objects.hashCode(this.foto);
        hash = 89 * hash + Objects.hashCode(this.catecorie);
        hash = 89 * hash + Objects.hashCode(this.brands);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utente other = (Utente) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cognome, other.cognome)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.foto, other.foto)) {
            return false;
        }
        if (!Objects.equals(this.catecorie, other.catecorie)) {
            return false;
        }
        if (!Objects.equals(this.brands, other.brands)) {
            return false;
        }
        return true;
    }

}
