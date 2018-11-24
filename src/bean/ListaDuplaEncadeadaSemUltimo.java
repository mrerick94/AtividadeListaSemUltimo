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
public class ListaDuplaEncadeadaSemUltimo<Object> implements Lista<Object> {

    public ListaDuplaEncadeadaSemUltimo() {
        this.quantidade = 0;
    }

    private Integer quantidade;
    private NoDuploEncadeado primeiroElemento;

    @Override
    public void adicionar(Object o) {
        if (this.primeiroElemento == null) {
            this.primeiroElemento = new NoDuploEncadeado(o, null, null);
            this.quantidade++;
            return;
        }
        NoDuploEncadeado ultimo = this.primeiroElemento;
        while (ultimo.getProximo() != null) {
            ultimo = ultimo.getProximo();
        }
        ultimo.setProximo(new NoDuploEncadeado(o, ultimo.getProximo(), ultimo));
        this.quantidade++;
    }

    @Override
    public void adicionar(Object o, Integer idx) {
        if (idx > this.quantidade) {
            throw new NullPointerException();
        }
        if (idx.equals(this.quantidade)) {
            if (idx.equals(0)) {
                this.primeiroElemento = new NoDuploEncadeado(o, null, null);
                this.quantidade++;
                return;
            }
            NoDuploEncadeado ultimo = this.primeiroElemento;
            while (ultimo.getProximo() != null) {
                ultimo = ultimo.getProximo();
            }
            NoDuploEncadeado elemento = new NoDuploEncadeado(o, null, ultimo);
            ultimo.setProximo(elemento);
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
            NoDuploEncadeado ultimo = this.primeiroElemento;
            while (ultimo.getProximo() != null) {
                ultimo = ultimo.getProximo();
            }
            ultimo.getAnterior().setProximo(new NoDuploEncadeado(o, null, ultimo.getAnterior()));
            return;
        }
        NoDuploEncadeado elemento = this.primeiroElemento;
        for (int i = 0; i < this.quantidade; i++) {
            if (idx.equals(i)) {
                if (elemento.equals(this.primeiroElemento)) {
                    NoDuploEncadeado novoElemento = new NoDuploEncadeado(o, this.primeiroElemento.getProximo(), null);
                    this.primeiroElemento.getProximo().setAnterior(novoElemento);
                    this.primeiroElemento = novoElemento;
                    return;
                }
                elemento.getAnterior().setProximo(new NoDuploEncadeado(o, elemento.getProximo(), elemento.getAnterior()));
                elemento.getProximo().setAnterior(elemento.getAnterior().getProximo());
                return;
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
        if (idx >= this.quantidade || idx < 0) {
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
        NoDuploEncadeado auxiliar = this.primeiroElemento;
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
