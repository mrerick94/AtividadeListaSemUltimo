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
public class NoSimples<Object> {
    private Object elemento;
    private NoSimples proximo;

    public NoSimples(Object elemento, NoSimples proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public NoSimples getProximo() {
        return proximo;
    }

    public void setProximo(NoSimples proximo) {
        this.proximo = proximo;
    }
}
