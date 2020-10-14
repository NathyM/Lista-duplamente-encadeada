/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author franklin
 */
public class Dupla {
    private Dupla anterior;
    private Dupla proximo;
    private Object elemento;

    public Dupla() {
    }

    public Dupla(Object elemento) {
        this.elemento = elemento;
    }

    public Dupla(Dupla anterior, Dupla proximo, Object elemento) {
        this.anterior = anterior;
        this.proximo = proximo;
        this.elemento = elemento;
    }

    public Dupla getAnterior() {
        return anterior;
    }

    public void setAnterior(Dupla anterior) {
        this.anterior = anterior;
    }

    public Dupla getProximo() {
        return proximo;
    }

    public void setProximo(Dupla proximo) {
        this.proximo = proximo;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
    
    

    
    
  
  
    
}
