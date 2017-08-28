/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.univaq.disim.mobile.cityshop.business.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author cityshop
 */

@Entity
@Table(name = "negoziante")
@DiscriminatorValue(value="negoziante") 
public class Negoziante extends Utente{
    
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Negozio negozio;
    
    public Negoziante (){
        super();
    }

    public Negozio getNegozio() {
        return negozio;
    }

    public void setNegozio(Negozio negozio) {
        this.negozio = negozio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.negozio);
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
        final Negoziante other = (Negoziante) obj;
        if (!Objects.equals(this.negozio, other.negozio)) {
            return false;
        }
        return true;
    }
    
}
