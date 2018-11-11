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
public class ListaDuplaEncadeada<Object> implements Lista<Object> {

    public ListaDuplaEncadeada() {
        this.quantidade = 0;
    }

    private Integer quantidade;
    private NoDuploEncadeado elemento;
    private NoDuploEncadeado primeiroElemento;

    @Override
    public void adicionar(Object o) {
        if (this.elemento == null) {
            this.elemento = new NoDuploEncadeado(o, null, null);
            this.primeiroElemento = this.elemento;
            this.quantidade++;
            return;
        }
        if (this.elemento != null) {
            NoDuploEncadeado elemento = new NoDuploEncadeado(o, null, this.elemento);
            this.elemento.setProximo(elemento);
            this.elemento = elemento;
        }
        this.quantidade++;
    }

    @Override
    public void adicionar(Object o, Integer idx) {
        if (idx > this.quantidade) {
            throw new NullPointerException();
        }
        if (idx.equals(this.quantidade)) {
            NoDuploEncadeado elemento = new NoDuploEncadeado(o, null, this.elemento);
            this.elemento.setProximo(elemento);
            this.elemento = elemento;
            this.quantidade++;
            return;
        }
        NoDuploEncadeado elemento = this.primeiroElemento;
        for (int i = 0; i < this.quantidade; i++) {
            if (idx.equals(i)) {
                if (elemento.equals(this.primeiroElemento)) {
                    NoDuploEncadeado auxiliar = elemento;
                    NoDuploEncadeado novoElemento = new NoDuploEncadeado(o, auxiliar, null);
                    auxiliar.setAnterior(novoElemento);
                    this.primeiroElemento = novoElemento;
                    this.quantidade++;
                    return;
                }
                NoDuploEncadeado auxiliar = elemento;
                NoDuploEncadeado novoElemento = new NoDuploEncadeado(o, auxiliar, auxiliar.getAnterior());
                auxiliar.getAnterior().setProximo(novoElemento);
                auxiliar.setAnterior(novoElemento);
                this.quantidade++;
                return;
            }
            elemento = elemento.getProximo();
        }
    }

    @Override
    public void substituir(Object o, Integer idx) {
        if (idx >= this.quantidade) {
            throw new NullPointerException();
        }
        if (idx == (this.quantidade - 1)) {
//            NoEncadeado elemento = new NoEncadeado(o, null, this.elemento);
//            this.elemento.setProximo(elemento);
//            this.elemento = elemento;
            this.elemento.setElemento(o);
            return;
        }
        NoDuploEncadeado elemento = this.primeiroElemento;
        for (int i = 0; i < this.quantidade; i++) {
            if (idx.equals(i)) {
                elemento.setElemento(o);
                break;
            }
            elemento = elemento.getProximo();
        }
    }

    @Override
    public Object buscar(Object o) {
        NoDuploEncadeado elemento = this.primeiroElemento;
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
        NoDuploEncadeado elemento = this.primeiroElemento;
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
        NoDuploEncadeado elemento = this.primeiroElemento;
        for (int i = 0; i < this.quantidade; i++) {
            if (elemento.getElemento().equals(o)) {
                if (elemento.equals(this.primeiroElemento) && elemento.getProximo() == null) {
                    this.primeiroElemento = null;
                    this.elemento = null;
                    this.quantidade--;
                    return true;
                }
                if (elemento.equals(this.elemento)) {
                    this.elemento = elemento.getAnterior();
                    elemento.getAnterior().setProximo(null);
                    this.quantidade--;
                    return true;
                }
                if (elemento.equals(this.primeiroElemento)) {
                    this.primeiroElemento = elemento.getProximo();
                    this.quantidade--;
                    return true;
                }
                elemento.getAnterior().setProximo(elemento.getProximo());
                this.quantidade--;
                return true;
            }
            elemento = elemento.getProximo();
        }
        return false;
    }

    @Override
    public Boolean remover(Integer idx) {
        if (idx >= this.quantidade || (idx.equals(0) && this.primeiroElemento == null) || idx < 0) {
            throw new NullPointerException();
        }
        NoDuploEncadeado elemento = this.primeiroElemento;
        for (int i = 0; i <= idx; i++) {
            if (idx.equals(i)) {
                if (elemento.equals(this.primeiroElemento) && elemento.getProximo() == null) {
                    this.primeiroElemento = null;
                    this.elemento = null;
                    this.quantidade--;
                    return true;
                }
                if (elemento.equals(this.elemento)) {
                    this.elemento = elemento.getAnterior();
                    elemento.getAnterior().setProximo(null);
                    this.quantidade--;
                    return true;
                }
                if (elemento.equals(this.primeiroElemento)) {
                    this.primeiroElemento = elemento.getProximo();
                    this.quantidade--;
                    return true;
                }
                elemento.getAnterior().setProximo(elemento.getProximo());
                this.quantidade--;
                return true;
            }
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
        NoDuploEncadeado auxiliar = this.primeiroElemento;
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
        NoDuploEncadeado auxiliar = this.elemento;
        for (int i = 0; i < this.quantidade; i++) {
            texto += auxiliar.getElemento().toString() + ",";
            if (auxiliar.getAnterior() != null) {
                auxiliar = auxiliar.getAnterior();
            }
        }
        String texto2 = "";
        if (texto.length() > 0) {
            texto2 = texto.substring(0, texto.length() - 1);
        }
        return texto2;
    }
}
