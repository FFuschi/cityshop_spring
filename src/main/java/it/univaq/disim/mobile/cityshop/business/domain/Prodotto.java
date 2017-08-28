/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.univaq.disim.mobile.cityshop.business.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author cityshop
 */

@Entity
@Table(name = "product")
public class Prodotto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;
    
    @Column(name = "name", nullable = false, length = 255)
    private String nome;
    
    @Column(name = "description", nullable = false, length = 10000)
    private String descrizione;
    
    @Column(name = "price", nullable = false)
    private float prezzo;
    
    @Column(name = "foto_address", nullable = false, length = 255)
    private String foto;
    
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Categoria categoria;
    
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Brand brand;
    
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Negozio negozio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
     public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Negozio getNegozio() {
        return negozio;
    }

    public void setNegozio(Negozio negozio) {
        this.negozio = negozio;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + Objects.hashCode(this.descrizione);
        hash = 53 * hash + Float.floatToIntBits(this.prezzo);
        hash = 53 * hash + Objects.hashCode(this.foto);
        hash = 53 * hash + Objects.hashCode(this.categoria);
        hash = 53 * hash + Objects.hashCode(this.brand);
        hash = 53 * hash + Objects.hashCode(this.negozio);
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
        final Prodotto other = (Prodotto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.prezzo) != Float.floatToIntBits(other.prezzo)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descrizione, other.descrizione)) {
            return false;
        }
        if (!Objects.equals(this.foto, other.foto)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.brand, other.brand)) {
            return false;
        }
        if (!Objects.equals(this.negozio, other.negozio)) {
            return false;
        }
        return true;
    }
    
}
