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
public class NoArvore {

    private Object elemento;
    private NoDuploEncadeado direita;
    private NoDuploEncadeado esquerda;

    public NoArvore(Object elemento, NoDuploEncadeado direita, NoDuploEncadeado esquerda) {
        this.elemento = elemento;
        this.direita = direita;
        this.esquerda = esquerda;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public NoDuploEncadeado getDireita() {
        return direita;
    }

    public void setDireita(NoDuploEncadeado direita) {
        this.direita = direita;
    }

    public NoDuploEncadeado getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoDuploEncadeado esquerda) {
        this.esquerda = esquerda;
    }
}
