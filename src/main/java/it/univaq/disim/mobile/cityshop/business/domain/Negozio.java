/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.univaq.disim.mobile.cityshop.business.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author cityshop
 */

@Entity
@Table(name = "negozio")
public class Negozio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private int id;
    @Column(name = "name", nullable = false, length = 255)
    private String nome;
    @Column(name = "address", nullable = false, length = 255)
    private String address;
    @Column(name = "latitude", nullable = false)
    private float latitudine;
    @Column(name = "longitude", nullable = false)
    private float longitudine;
    @Column(name = "phone_number", nullable = false)
    private int phone;
    @Column(name = "foto_address", nullable = false, length = 255)
    private String foto;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(float latitudine) {
        this.latitudine = latitudine;
    }

    public float getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(float longitudine) {
        this.longitudine = longitudine;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.address);
        hash = 29 * hash + Float.floatToIntBits(this.latitudine);
        hash = 29 * hash + Float.floatToIntBits(this.longitudine);
        hash = 29 * hash + this.phone;
        hash = 29 * hash + Objects.hashCode(this.foto);
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
        final Negozio other = (Negozio) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.latitudine) != Float.floatToIntBits(other.latitudine)) {
            return false;
        }
        if (Float.floatToIntBits(this.longitudine) != Float.floatToIntBits(other.longitudine)) {
            return false;
        }
        if (this.phone != other.phone) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.foto, other.foto)) {
            return false;
        }
        return true;
    }
    
}
