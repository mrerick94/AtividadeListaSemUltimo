/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio4;

import bean.Fila;
import bean.FilaSemUltimo;
import bean.Pilha;
import bean.PilhaSemUltimo;

/**
 *
 * @author erick
 */
public class Robo {
    private FilaSemUltimo<Posicao> comecoFim;
    private PilhaSemUltimo<Posicao> fimComeco;
    private Posicao posicaoInicial;
    private Posicao posicaoAtual;
    private Posicao posicaoAnterior;

    public Robo(FilaSemUltimo<Posicao> comecoFim, PilhaSemUltimo<Posicao> fimComeco, Posicao posicaoInicial) {
        this.comecoFim = comecoFim;
        this.fimComeco = fimComeco;
        this.posicaoInicial = posicaoInicial;
        this.posicaoAtual = posicaoInicial;
        this.posicaoAnterior = posicaoInicial;
    }

    public FilaSemUltimo<Posicao> getComecoFim() {
        return comecoFim;
    }

    public void setComecoFim(FilaSemUltimo<Posicao> comecoFim) {
        this.comecoFim = comecoFim;
    }

    public PilhaSemUltimo<Posicao> getFimComeco() {
        return fimComeco;
    }

    public void setFimComeco(PilhaSemUltimo<Posicao> fimComeco) {
        this.fimComeco = fimComeco;
    }

    public Posicao getPosicaoInicial() {
        return posicaoInicial;
    }

    public void setPosicaoInicial(Posicao posicaoInicial) {
        this.posicaoInicial = posicaoInicial;
    }

    public Posicao getPosicaoAtual() {
        return posicaoAtual;
    }

    public void setPosicaoAtual(Posicao posicaoAtual) {
        this.posicaoAtual = posicaoAtual;
    }

    public Posicao getPosicaoAnterior() {
        return posicaoAnterior;
    }

    public void setPosicaoAnterior(Posicao posicaoAnterior) {
        this.posicaoAnterior = posicaoAnterior;
    }
}
