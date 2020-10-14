/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class ListaDuplaEncadeada <T> {
        private Dupla inicio;
        private Dupla fim;
        private int quantElementos = 0;

    public ListaDuplaEncadeada() {
    }
    
        public void adiciona(T elemento, int posicao) {
        if (posicao == 0) {
          this.adicionaInicio(elemento);
        } else if (posicao == (this.quantElementos - 1)) {
          this.adicionaFim(elemento);
        } else {
          try {
            this.verificaIntervaloAdicao(posicao);
            Dupla anterior = this.recuperaCelula(posicao - 1);
            Dupla proxima = this.recuperaCelula(posicao);
            Dupla nova = new Dupla(anterior, proxima, elemento);
            anterior.setProximo(nova);
            proxima.setAnterior(nova);
            this.quantElementos++;
          } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro!! A posição " + posicao + "  escolhida não é válida. Escolha um valor de 0 a " + this.quantElementos + ".");
          }
        }
      }


      public void adicionaInicio(T elemento) {
        Dupla nova = new Dupla(elemento);
        if (this.vazio()) {
          this.inicio = this.fim = nova;
        } else {
          nova.setProximo(inicio);
          inicio.setAnterior(nova);
          inicio = nova;
        }
        this.quantElementos++;
      }


      public void adicionaFim(T elemento) {
        Dupla nova = new Dupla(elemento);
        if (this.vazio()) {
          this.inicio = this.fim = nova;
        } else {
          nova.setAnterior(fim);
          fim.setProximo(nova);
          fim = nova;
        }
        this.quantElementos++;
      }


      public boolean existeDado(T elemento) {
        if (this.quantElementos != 0) {
          Iterador iterador = new Iterador(this.inicio);
          while (iterador.hasNext()) {
            if (elemento == iterador.next()) {
              return true;
            }
          }
        }
        return false;
      }


      private Dupla recuperaCelula(int posicao) {
        try {
          this.verificaIntervalo(posicao);
          Iterador iterador;
          if (posicao < this.quantElementos / 2) {
            iterador = new Iterador(this.inicio);
            int i = 0;
            while (iterador.hasNext()) {
              if (i != posicao) {
                iterador.next();
                i++;
              } else {
                break;
              }
            }
          } else {
            iterador = new Iterador(this.fim);
            int i = this.quantElementos - 1;
            while (iterador.hasNext()) {
              if (i != posicao) {
                iterador.prev();
                i--;
              } else {
                break;
              }
            }
          }
          return iterador.getAtual();
        } catch (IndexOutOfBoundsException e) {
          System.out.print("Erro!! A posição " + posicao + " escolhida não existe. A lista vai de 0 a " + (this.quantElementos - 1) + ". ");
          return null;
        } catch (NullPointerException e) {
          System.out.print("Erro!! A posição " + posicao + " ecolhida não existe. A lista está vazia. ");
          return null;
        }
      }


      public T recupera(int posicao) {
        try {
          this.verificaIntervalo(posicao);
          Dupla celula = this.recuperaCelula(posicao);
          return (T) celula.getElemento();
        } catch (IndexOutOfBoundsException e) {
          System.out.print("Erro!! A posição " + posicao + "  ecolhida não existe. A lista vai de 0 a " + (this.quantElementos - 1) + ". ");
          return null;
        } catch (NullPointerException e) {
          System.out.print("Erro!! A posição " + posicao + " escolhida não existe. Essa lista está vazia. ");
          return null;
        }
      }


      public boolean vazio() {
        return this.quantElementos == 0;
      }


      public void remove(int posicao) {
        if (posicao == 0) {
          this.removeInicio();
        } else if (posicao == (this.quantElementos - 1)) {
          this.removeFim();
        } else {
          try {
            this.verificaIntervalo(posicao);
            Dupla anterior = this.recuperaCelula(posicao - 1);
            Dupla proxima = this.recuperaCelula(posicao + 1);
            anterior.setProximo(proxima);
            proxima.setAnterior(anterior);
            this.quantElementos--;
          } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro!! A posição " + posicao + "  ecolhida não existe. Essa lista vai de 0 a " + (this.quantElementos - 1) + ".");
          } catch (NullPointerException e) {
            System.out.println("Erro!! A posição " + posicao + " ecolhida não existe. Essa lista está vazia.");
          }
        }
      }


      public void removeInicio() {
        try {
          this.verificaIntervalo(0);
          this.inicio = this.inicio.getProximo();
          this.inicio.setAnterior(null);
          this.quantElementos--;
        } catch (NullPointerException e) {
          System.out.println("Erro!! Essa lista está vazia.");
        }
      }


      public void removeFim() {
        try {
          this.verificaIntervalo(this.quantElementos - 1);
          this.fim = this.recuperaCelula(this.quantElementos - 2);
          this.fim.setProximo(null);
          this.quantElementos--;
        } catch (NullPointerException e) {
          System.out.println("Erro!! Essa lista está vazia.");
        }
      }

      public int tamanho() {
        return this.quantElementos;
      }


      public void limpa() {
        this.inicio = this.fim = null;
        this.quantElementos = 0;
      }

      @Override
      public String toString() {
        if (this.quantElementos == 0) return "[]";
        Iterador<T> iterador = new Iterador<>(inicio);
        String listaToString = "[" + iterador.next();
        while (iterador.hasNext()) {
          listaToString += ", " + iterador.next();
        }
        listaToString += "]";

        return listaToString;
      }


      private void verificaIntervalo(int posicao) {
        if (this.vazio()) {
          throw new NullPointerException("Lista vazia");
        }
        if ((posicao < 0 || posicao >= this.quantElementos)) {
          throw new ArrayIndexOutOfBoundsException("Posição Inválida");
        }
      }


      private void verificaIntervaloAdicao(int posicao) {
        if ((posicao < 0 || posicao > this.quantElementos)) {
          throw new ArrayIndexOutOfBoundsException("Posição Inválida");
        }
      }
    }