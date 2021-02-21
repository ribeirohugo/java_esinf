/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2021_normal;

import java.util.Objects;

/**
 *
 * @author hugo.ribeiro
 */
public class Pais {
    private String nome;
    
    public Pais(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.nome);
    }
    
    /**
     *
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        final Pais other = (Pais) obj;
        
        if(!this.nome.equals(other.getNome())) {
            return false;
        }

        return true;
    }
    
    @Override
    public String toString() {
        return this.nome;
    }
}
