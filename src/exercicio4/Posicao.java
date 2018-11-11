/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio4;

/**
 *
 * @author erick
 */
public class Posicao {
    private Integer linha;
    private Integer coluna;

    public Posicao(Integer linha, Integer coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public Integer getLinha() {
        return linha;
    }

    public void setLinha(Integer linha) {
        this.linha = linha;
    }

    public Integer getColuna() {
        return coluna;
    }

    public void setColuna(Integer coluna) {
        this.coluna = coluna;
    }
    
    public String toString() {
        return "[" + linha.toString() + "," + coluna.toString() + "]";
    }
    
    public boolean equals(Posicao posicao) {
        return (this.linha.equals(posicao.linha) && (this.coluna).equals(posicao.coluna));
    }
}
