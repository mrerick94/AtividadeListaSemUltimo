/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Alunos
 */
public class ListaCircularSemUltimo<Object> implements Lista<Object> {

    public ListaCircularSemUltimo() {
        this.quantidade = 0;
    }

    private Integer quantidade;
    private NoDuploEncadeado primeiroElemento;

    @Override
    public void adicionar(Object o) {
        if (this.primeiroElemento == null) {
            this.primeiroElemento = new NoDuploEncadeado(o, null, null);
            this.primeiroElemento.setProximo(this.primeiroElemento);
            this.primeiroElemento.setAnterior(this.primeiroElemento);
            this.quantidade++;
            return;
        }
        if (this.primeiroElemento != null && this.primeiroElemento.getProximo().equals(this.primeiroElemento)) {
            this.primeiroElemento.setProximo(new NoDuploEncadeado(o, this.primeiroElemento, this.primeiroElemento));
            this.quantidade++;
            return;
        }
        NoDuploEncadeado ultimo = this.primeiroElemento;
        while (ultimo.getProximo() != this.primeiroElemento) {
            ultimo = ultimo.getProximo();
        }
        NoDuploEncadeado elemento = new NoDuploEncadeado(o, this.primeiroElemento, ultimo.getAnterior());
        ultimo.setProximo(elemento);
        this.primeiroElemento.setAnterior(elemento);
        this.quantidade++;
    }

    @Override
    public void adicionar(Object o, Integer idx) {
        if (idx > this.quantidade) {
            throw new NullPointerException();
        }
        if (idx.equals(0) && this.primeiroElemento == null) {
            this.adicionar(o);
            this.quantidade++;
            return;
        }
        if (idx.equals(0) && this.primeiroElemento.getProximo().equals(this.primeiroElemento)) {
            this.primeiroElemento = new NoDuploEncadeado(o, this.primeiroElemento, this.primeiroElemento);
            this.primeiroElemento.getProximo().setProximo(this.primeiroElemento);
            this.quantidade++;
            return;
        }
        if (idx.equals(1) && this.primeiroElemento.getProximo().equals(this.primeiroElemento)) {
            this.primeiroElemento.setProximo(new NoDuploEncadeado(o, this.primeiroElemento, this.primeiroElemento));
            this.primeiroElemento.setAnterior(this.primeiroElemento.getProximo());
            this.quantidade++;
            return;
        }
        if (idx.equals(this.quantidade)) {
            NoDuploEncadeado ultimo = this.primeiroElemento;
            while (ultimo.getProximo() != this.primeiroElemento) {
                ultimo = ultimo.getProximo();
            }
            NoDuploEncadeado elemento = new NoDuploEncadeado(o, this.primeiroElemento, ultimo);
            ultimo.setProximo(elemento);
            this.primeiroElemento.setAnterior(elemento);
            this.quantidade++;
            return;
        }
        NoDuploEncadeado elemento = this.primeiroElemento;
        for (int i = 0; i < this.quantidade; i++) {
            if (idx.equals(i)) {
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
        if (idx >= this.quantidade || this.quantidade.equals(0)) {
            throw new NullPointerException();
        }
        if (idx.equals(0) && this.quantidade.equals(1)) {
            this.primeiroElemento = new NoDuploEncadeado(o, null, null);
            this.primeiroElemento.setProximo(primeiroElemento);
            this.primeiroElemento.setAnterior(primeiroElemento);
            return;
        }
        NoDuploEncadeado elemento = this.primeiroElemento;
        for (int i = 0; i < this.quantidade; i++) {
            if (idx.equals(i)) {
                elemento.getAnterior().setProximo(new NoDuploEncadeado(o, elemento.getProximo(), elemento.getAnterior()));
                elemento.getProximo().setAnterior(elemento.getAnterior().getProximo());
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
        if (this.quantidade.equals(0)) {
            throw new NullPointerException();
        }
        NoDuploEncadeado elemento = this.primeiroElemento;
        for (int i = 0; i < this.quantidade; i++) {
            if (elemento.getElemento().equals(o)) {
                if (elemento.equals(this.primeiroElemento) && elemento.getProximo() == this.primeiroElemento) {
                    this.primeiroElemento = null;
                    this.quantidade--;
                    return true;
                }
                if (elemento.getProximo() == this.primeiroElemento) {
                    elemento.getAnterior().setProximo(this.primeiroElemento);
                    this.primeiroElemento.setAnterior(elemento.getAnterior());
                    this.quantidade--;
                    return true;
                }
                if (elemento.equals(this.primeiroElemento)) {
                    this.primeiroElemento = elemento.getProximo();
                    this.primeiroElemento.setAnterior(elemento.getAnterior());
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
                if (elemento.equals(this.primeiroElemento) && elemento.getProximo() == this.primeiroElemento) {
                    this.primeiroElemento = null;
                    this.quantidade--;
                    return true;
                }
                if (elemento.getProximo() == this.primeiroElemento) {
                    elemento.getAnterior().setProximo(this.primeiroElemento);
                    this.primeiroElemento.setAnterior(elemento.getAnterior());
                    this.quantidade--;
                    return true;
                }
                if (elemento.equals(this.primeiroElemento)) {
                    this.primeiroElemento = elemento.getProximo();
                    this.primeiroElemento.setAnterior(elemento.getAnterior());
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
