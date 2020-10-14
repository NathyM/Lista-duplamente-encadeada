/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Iterator;

    public class Iterador<T> implements Iterator {

      private Dupla atual;
      public Iterador(Dupla atual) {
        this.atual = atual;
      }

      @Override
      public boolean hasNext() {
        return atual != null;
      }

      @Override
      public Object next() {
        T elemento = (T) atual.getElemento();
        atual = atual.getProximo();
        return elemento;
      }

      public Object prev() {
        T elemento = (T) atual.getElemento();
        atual = atual.getAnterior();
        return elemento;
      }

      public Dupla getAtual() {
        return atual;
      }
    }
