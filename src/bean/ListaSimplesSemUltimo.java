/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Alunos
 * @param <Object>
 */
public class ListaSimplesSemUltimo<Object> implements Lista<Object> {

    public ListaSimplesSemUltimo() {
        this.quantidade = 0;
    }

    private Integer quantidade;
    private NoSimples primeiroElemento;

    @Override
    public void adicionar(Object o) {
        if (this.primeiroElemento == null) {
            this.primeiroElemento = new NoSimples(o, null);
            this.quantidade++;
            return;
        }
        NoSimples elemento = new NoSimples(o, null);
        NoSimples auxiliar = this.primeiroElemento;
        while (auxiliar.getProximo() != null) {
            auxiliar = auxiliar.getProximo();
        }
        auxiliar.setProximo(elemento);
        this.quantidade++;
    }

    @Override
    public void adicionar(Object o, Integer idx) {
        if (idx > this.quantidade) {
            throw new NullPointerException();
        }
        if (idx.equals(this.quantidade)) {
            if (idx.equals(0)) {
                this.primeiroElemento = new NoSimples(o, null);
                this.quantidade++;
                return;
            }
            this.adicionar(o);
            return;
        }
        NoSimples elemento = this.primeiroElemento;
        NoSimples elementoAnterior = null;
        for (int i = 0; i < this.quantidade; i++) {
            if (idx.equals(i)) {
                if (elemento.equals(this.primeiroElemento)) {
                    NoSimples auxiliar = elemento;
                    NoSimples novoElemento = new NoSimples(o, auxiliar);
                    this.primeiroElemento = novoElemento;
                    this.quantidade++;
                    return;
                }
                NoSimples auxiliar = elemento;
                NoSimples novoElemento = new NoSimples(o, auxiliar);
                elementoAnterior.setProximo(novoElemento);
                this.quantidade++;
                return;
            }
            if (i == (idx - 1)) {
                elementoAnterior = elemento;
            }
            elemento = elemento.getProximo();
        }
    }

    @Override
    public void substituir(Object o, Integer idx) {
        if (idx >= this.quantidade) {
            throw new NullPointerException();
        }
        if (idx.equals(0)) {
            this.primeiroElemento = new NoSimples(o, this.primeiroElemento.getProximo());
            return;
        }
        if (idx == (this.quantidade - 1) && idx != 0) {
            NoSimples auxiliar = this.primeiroElemento;
            NoSimples elementoAnterior = null;
            int i = 0;
            while (auxiliar.getProximo() != null) {
                if (i == (idx - 1)) {
                    elementoAnterior = auxiliar;
                }
                auxiliar = auxiliar.getProximo();
                i++;
            }
            elementoAnterior.setProximo(new NoSimples(o, null));
            return;
        }
        NoSimples elemento = this.primeiroElemento;
        NoSimples elementoAnterior = null;
        for (int i = 0; i < this.quantidade; i++) {
            if (idx.equals(i)) {
                elementoAnterior.setProximo(new NoSimples(o, elemento.getProximo()));
            }
            if (i == (idx - 1)) {
                elementoAnterior = elemento;
            }
            elemento = elemento.getProximo();
        }
    }

    @Override
    public Object buscar(Object o) {
        NoSimples elemento = this.primeiroElemento;
        for (int i = 0; i < this.quantidade; i++) {
            if (elemento.getElemento().equals(o)) {
                return (Object) elemento.getElemento();
            }
            elemento = elemento.getProximo();
        }
        return null;
    }

    @Override
    public Object buscar(Integer idx) {
        if (idx >= this.quantidade) {
            throw new NullPointerException();
        }
        NoSimples elemento = this.primeiroElemento;
        for (int i = 0; i < this.quantidade; i++) {
            if (idx.equals(i)) {
                return (Object) elemento.getElemento();
            }
            elemento = elemento.getProximo();
        }
        return null;
    }

    @Override
    public Boolean remover(Object o) {
        NoSimples elemento = this.primeiroElemento;
        NoSimples anterior = null;
        for (int i = 0; i < this.quantidade; i++) {
            if (elemento.getElemento().equals(o)) {
                if (elemento.equals(this.primeiroElemento) && elemento.getProximo() == null) {
                    this.primeiroElemento = null;
                    this.quantidade--;
                    return true;
                }
                if (elemento.equals(this.primeiroElemento)) {
                    this.primeiroElemento = elemento.getProximo();
                    this.quantidade--;
                    return true;
                }
                anterior.setProximo(elemento.getProximo());
                this.quantidade--;
                return true;
            }
            anterior = elemento;
            elemento = elemento.getProximo();
        }
        return false;
    }

    @Override
    public Boolean remover(Integer idx) {
        if (idx >= this.quantidade || (idx.equals(0) && this.primeiroElemento == null) || idx < 0) {
            throw new NullPointerException();
        }
        NoSimples elemento = this.primeiroElemento;
        NoSimples anterior = null;
        for (int i = 0; i <= idx; i++) {
            if (idx.equals(i)) {
                if (elemento.getProximo() == null && anterior != null) {
                    anterior.setProximo(null);
                    this.quantidade--;
                    return true;
                }
                if (elemento.getProximo() != null && anterior == null) {
                    this.primeiroElemento = elemento.getProximo();
                    this.quantidade--;
                    return true;
                }
                anterior.setProximo(elemento.getProximo());
                this.quantidade--;
                return true;
            }
            anterior = elemento;
            elemento = elemento.getProximo();
        }
        return false;
    }

    @Override
    public Integer tamanho() {
        return this.quantidade;
    }

    @Override
    public Boolean existe(Object o) {
        if (this.buscar(o) != null) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String texto = "";
        NoSimples auxiliar = this.primeiroElemento;
        for (int i = 0; i < this.quantidade; i++) {
            texto += auxiliar.getElemento().toString() + ",";
            if (auxiliar.getProximo() != null) {
                auxiliar = auxiliar.getProximo();
            }
        }
        String texto2 = "";
        if (texto.length() > 0) {
            texto2 = texto.substring(0, texto.length() - 1);
        }
        return texto2;
    }

    @Override
    public String toStringInverse() {
        String texto = "";
        NoSimples auxiliar = this.primeiroElemento;
        for (int i = 0; i < this.quantidade; i++) {
            texto = auxiliar.getElemento().toString() + "," + texto;
            if (auxiliar.getProximo() != null) {
                auxiliar = auxiliar.getProximo();
            }
        }
        String texto2 = "";
        if (texto.length() > 0) {
            texto2 = texto.substring(0, texto.length() - 1);
        }
        return texto2;
    }
}
