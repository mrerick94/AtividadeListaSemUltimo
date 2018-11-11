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
public class NoDuploEncadeado {
    private Object elemento;
    private NoDuploEncadeado proximo;
    private NoDuploEncadeado anterior;

    public NoDuploEncadeado(Object elemento, NoDuploEncadeado proximo, NoDuploEncadeado anterior) {
        this.elemento = elemento;
        this.proximo = proximo;
        this.anterior = anterior;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public NoDuploEncadeado getProximo() {
        return proximo;
    }

    public void setProximo(NoDuploEncadeado proximo) {
        this.proximo = proximo;
    }

    public NoDuploEncadeado getAnterior() {
        return anterior;
    }

    public void setAnterior(NoDuploEncadeado anterior) {
        this.anterior = anterior;
    }
}
