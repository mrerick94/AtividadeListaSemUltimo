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
public class Exercicio4 {

    public static void main(String[] args) {
        Integer[][] matriz =   {{0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 0, 0, 1, 1, 1, 1, 1, 1, 1},
                                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                                {1, 1, 0, 0, 0, 0, 0, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                                {1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0}};

        Integer[][] matrizComplexa = {{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
        {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
        {0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1},
        {0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1},
        {0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1},
        {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1},
        {0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1},
        {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1},
        {0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
        {0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1},
        {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1},
        {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}};

        Robo robo = new Robo(new FilaSemUltimo(), new PilhaSemUltimo(), new Posicao(0, 0));
        robo = percorrer2(robo, matriz, new Posicao(0, 0), new Posicao(9, 9));
        System.out.println("Caminho do inicio ao fim: " + robo.getComecoFim());
        System.out.println("Caminho do Fim ao início: " + robo.getFimComeco());
        Robo robo2 = new Robo(new FilaSemUltimo(), new PilhaSemUltimo(), new Posicao(0, 0));
        robo2 = percorrer2(robo2, matrizComplexa, new Posicao(0, 0), new Posicao(13, 29));
        System.out.println("Caminho do inicio ao fim: " + robo2.getComecoFim());
        System.out.println("Caminho do Fim ao início: " + robo2.getFimComeco());
    }

    //VERSÃO MELHOR, FIZ DEPOIS PORQUE A PRIMEIRA ESTAVA MUITO FEIA. MAS AINDA ESTÁ LÁ EMBAIXO SE QUISER VER
    public static Robo percorrer2(Robo robo, Integer[][] matriz, Posicao inicio, Posicao fim) {
        robo.setPosicaoAtual(inicio);
        robo.getComecoFim().adicionar(inicio);
        robo.getFimComeco().adicionar(inicio);
        if (robo.getPosicaoAtual().equals(fim)) {
            return robo;
        }
        Boolean isUsed = false;
        for (int i = 0; i < 4; i++) {
            if (robo.getPosicaoAtual().equals(fim)) {
                return robo;
            }
            try {
                Posicao proximaPosicao;
                switch (i) {
                    case 0:
                        proximaPosicao = new Posicao(robo.getPosicaoAtual().getLinha(), robo.getPosicaoAtual().getColuna() - 1);
                        for (int j = 0; j < robo.getComecoFim().tamanho(); j++) {
                            isUsed = false;
                            Posicao posicaoJaUsada = robo.getComecoFim().buscar(j);
                            if (proximaPosicao.equals(posicaoJaUsada)) {
                                isUsed = true;
                                break;
                            }
                        }
                        if (!isUsed) {
                            if (matriz[proximaPosicao.getLinha()][proximaPosicao.getColuna()].equals(0)) {
                                robo = percorrer2(robo, matriz, proximaPosicao, fim);
                            }
                        }
                        break;
                    case 1:
                        proximaPosicao = new Posicao(robo.getPosicaoAtual().getLinha(), robo.getPosicaoAtual().getColuna() + 1);
                        for (int j = 0; j < robo.getComecoFim().tamanho(); j++) {
                            isUsed = false;
                            Posicao posicaoJaUsada = robo.getComecoFim().buscar(j);
                            if (proximaPosicao.equals(posicaoJaUsada)) {
                                isUsed = true;
                                break;
                            }
                        }
                        if (!isUsed) {
                            if (matriz[proximaPosicao.getLinha()][proximaPosicao.getColuna()].equals(0)) {
                                robo = percorrer2(robo, matriz, proximaPosicao, fim);
                            }
                        }
                        break;
                    case 2:
                        proximaPosicao = new Posicao(robo.getPosicaoAtual().getLinha() - 1, robo.getPosicaoAtual().getColuna());
                        for (int j = 0; j < robo.getComecoFim().tamanho(); j++) {
                            isUsed = false;
                            Posicao posicaoJaUsada = robo.getComecoFim().buscar(j);
                            if (proximaPosicao.equals(posicaoJaUsada)) {
                                isUsed = true;
                                break;
                            }
                        }
                        if (!isUsed) {
                            if (matriz[proximaPosicao.getLinha()][proximaPosicao.getColuna()].equals(0)) {
                                robo = percorrer2(robo, matriz, proximaPosicao, fim);
                            }
                        }
                        break;
                    case 3:
                        proximaPosicao = new Posicao(robo.getPosicaoAtual().getLinha() + 1, robo.getPosicaoAtual().getColuna());
                        for (int j = 0; j < robo.getComecoFim().tamanho(); j++) {
                            isUsed = false;
                            Posicao posicaoJaUsada = robo.getComecoFim().buscar(j);
                            if (proximaPosicao.equals(posicaoJaUsada)) {
                                isUsed = true;
                                break;
                            }
                        }
                        if (!isUsed) {
                            if (matriz[proximaPosicao.getLinha()][proximaPosicao.getColuna()].equals(0)) {
                                robo = percorrer2(robo, matriz, proximaPosicao, fim);
                            }
                        }
                        break;
                }
            } catch (Exception e) {
                continue;
            }
        }
        return robo;
    }

    //PRIMEIRA VERSÃO, UM LIXO, ELA IA DAR ERRO NO CANTO SUPERIOR DIREITO DA MATRIZ SE PASSASSE POR LÁ, RESOLVI FAZER DE NOVO
    public static Robo percorrer(Integer[][] matriz, Posicao inicio, Posicao fim) {
        FilaSemUltimo<Posicao> comecoFim = new FilaSemUltimo();
        PilhaSemUltimo<Posicao> fimComeco = new PilhaSemUltimo();
        Robo robo = new Robo(comecoFim, fimComeco, inicio);
        robo.getComecoFim().adicionar(inicio);
        robo.getFimComeco().adicionar(inicio);
        while (!robo.getPosicaoAtual().getLinha().equals(fim.getLinha()) || !robo.getPosicaoAtual().getColuna().equals(fim.getColuna())) {
            if (robo.getPosicaoAtual().getLinha().equals(0)) {
                if (robo.getPosicaoAtual().getColuna().equals(0)) {
                    if (matriz[robo.getPosicaoAtual().getLinha()][robo.getPosicaoAtual().getColuna() + 1].equals(0) && robo.getPosicaoAtual().getColuna() + 1 != robo.getPosicaoAnterior().getColuna()) {
                        robo.setPosicaoAnterior(robo.getPosicaoAtual());
                        robo.setPosicaoAtual(new Posicao(robo.getPosicaoAtual().getLinha(), robo.getPosicaoAtual().getColuna() + 1));
                        robo.getComecoFim().adicionar(robo.getPosicaoAtual());
                        robo.getFimComeco().adicionar(robo.getPosicaoAtual());
                        continue;
                    }
                    if (matriz[robo.getPosicaoAtual().getLinha() + 1][robo.getPosicaoAtual().getColuna()].equals(0) && robo.getPosicaoAtual().getLinha() + 1 != robo.getPosicaoAnterior().getLinha()) {
                        robo.setPosicaoAnterior(robo.getPosicaoAtual());
                        robo.setPosicaoAtual(new Posicao(robo.getPosicaoAtual().getLinha() + 1, robo.getPosicaoAtual().getColuna()));
                        robo.getComecoFim().adicionar(robo.getPosicaoAtual());
                        robo.getFimComeco().adicionar(robo.getPosicaoAtual());
                        continue;
                    }
                }
                if (matriz[robo.getPosicaoAtual().getLinha()][robo.getPosicaoAtual().getColuna() + 1].equals(0) && robo.getPosicaoAtual().getColuna() + 1 != robo.getPosicaoAnterior().getColuna()) {
                    robo.setPosicaoAnterior(robo.getPosicaoAtual());
                    robo.setPosicaoAtual(new Posicao(robo.getPosicaoAtual().getLinha(), robo.getPosicaoAtual().getColuna() + 1));
                    robo.getComecoFim().adicionar(robo.getPosicaoAtual());
                    robo.getFimComeco().adicionar(robo.getPosicaoAtual());
                    continue;
                }
                if (matriz[robo.getPosicaoAtual().getLinha() + 1][robo.getPosicaoAtual().getColuna()].equals(0) && robo.getPosicaoAtual().getLinha() + 1 != robo.getPosicaoAnterior().getLinha()) {
                    robo.setPosicaoAnterior(robo.getPosicaoAtual());
                    robo.setPosicaoAtual(new Posicao(robo.getPosicaoAtual().getLinha() + 1, robo.getPosicaoAtual().getColuna()));
                    robo.getComecoFim().adicionar(robo.getPosicaoAtual());
                    robo.getFimComeco().adicionar(robo.getPosicaoAtual());
                    continue;
                }
                if (matriz[robo.getPosicaoAtual().getLinha()][robo.getPosicaoAtual().getColuna() - 1].equals(0) && robo.getPosicaoAtual().getColuna() - 1 != robo.getPosicaoAnterior().getColuna()) {
                    robo.setPosicaoAnterior(robo.getPosicaoAtual());
                    robo.setPosicaoAtual(new Posicao(robo.getPosicaoAtual().getLinha(), robo.getPosicaoAtual().getColuna() - 1));
                    robo.getComecoFim().adicionar(robo.getPosicaoAtual());
                    robo.getFimComeco().adicionar(robo.getPosicaoAtual());
                    continue;
                }
            }
            if (robo.getPosicaoAtual().getColuna().equals(0)) {
                if (robo.getPosicaoAtual().getLinha() > 0 && robo.getPosicaoAtual().getLinha() < fim.getLinha()) {
                    if (matriz[robo.getPosicaoAtual().getLinha()][robo.getPosicaoAtual().getColuna() + 1].equals(0) && robo.getPosicaoAtual().getColuna() + 1 != robo.getPosicaoAnterior().getColuna()) {
                        robo.setPosicaoAnterior(robo.getPosicaoAtual());
                        robo.setPosicaoAtual(new Posicao(robo.getPosicaoAtual().getLinha(), robo.getPosicaoAtual().getColuna() + 1));
                        robo.getComecoFim().adicionar(robo.getPosicaoAtual());
                        robo.getFimComeco().adicionar(robo.getPosicaoAtual());
                        continue;
                    }
                    if (matriz[robo.getPosicaoAtual().getLinha() + 1][robo.getPosicaoAtual().getColuna()].equals(0) && robo.getPosicaoAtual().getLinha() + 1 != robo.getPosicaoAnterior().getLinha()) {
                        robo.setPosicaoAnterior(robo.getPosicaoAtual());
                        robo.setPosicaoAtual(new Posicao(robo.getPosicaoAtual().getLinha() + 1, robo.getPosicaoAtual().getColuna()));
                        robo.getComecoFim().adicionar(robo.getPosicaoAtual());
                        robo.getFimComeco().adicionar(robo.getPosicaoAtual());
                        continue;
                    }
                    if (matriz[robo.getPosicaoAtual().getLinha() - 1][robo.getPosicaoAtual().getColuna()].equals(0) && robo.getPosicaoAtual().getLinha() - 1 != robo.getPosicaoAnterior().getLinha()) {
                        robo.setPosicaoAnterior(robo.getPosicaoAtual());
                        robo.setPosicaoAtual(new Posicao(robo.getPosicaoAtual().getLinha() - 1, robo.getPosicaoAtual().getColuna()));
                        robo.getComecoFim().adicionar(robo.getPosicaoAtual());
                        robo.getFimComeco().adicionar(robo.getPosicaoAtual());
                        continue;
                    }
                }
            }
            if (robo.getPosicaoAtual().getLinha().equals(fim.getLinha())) {
                if (matriz[robo.getPosicaoAtual().getLinha()][robo.getPosicaoAtual().getColuna() + 1].equals(0) && robo.getPosicaoAtual().getColuna() + 1 != robo.getPosicaoAnterior().getColuna()) {
                    robo.setPosicaoAnterior(robo.getPosicaoAtual());
                    robo.setPosicaoAtual(new Posicao(robo.getPosicaoAtual().getLinha(), robo.getPosicaoAtual().getColuna() + 1));
                    robo.getComecoFim().adicionar(robo.getPosicaoAtual());
                    robo.getFimComeco().adicionar(robo.getPosicaoAtual());
                    continue;
                }
                if (matriz[robo.getPosicaoAtual().getLinha() - 1][robo.getPosicaoAtual().getColuna()].equals(0) && robo.getPosicaoAtual().getLinha() - 1 != robo.getPosicaoAnterior().getLinha()) {
                    robo.setPosicaoAnterior(robo.getPosicaoAtual());
                    robo.setPosicaoAtual(new Posicao(robo.getPosicaoAtual().getLinha() - 1, robo.getPosicaoAtual().getColuna()));
                    robo.getComecoFim().adicionar(robo.getPosicaoAtual());
                    robo.getFimComeco().adicionar(robo.getPosicaoAtual());
                    continue;
                }
                if (matriz[robo.getPosicaoAtual().getLinha()][robo.getPosicaoAtual().getColuna() - 1].equals(0) && robo.getPosicaoAtual().getColuna() - 1 != robo.getPosicaoAnterior().getColuna()) {
                    robo.setPosicaoAnterior(robo.getPosicaoAtual());
                    robo.setPosicaoAtual(new Posicao(robo.getPosicaoAtual().getLinha(), robo.getPosicaoAtual().getColuna() - 1));
                    robo.getComecoFim().adicionar(robo.getPosicaoAtual());
                    robo.getFimComeco().adicionar(robo.getPosicaoAtual());
                    continue;
                }
            }
            if (robo.getPosicaoAtual().getColuna().equals(fim.getColuna())) {
                if (matriz[robo.getPosicaoAtual().getLinha()][robo.getPosicaoAtual().getColuna() - 1].equals(0) && robo.getPosicaoAtual().getColuna() - 1 != robo.getPosicaoAnterior().getColuna()) {
                    robo.setPosicaoAnterior(robo.getPosicaoAtual());
                    robo.setPosicaoAtual(new Posicao(robo.getPosicaoAtual().getLinha(), robo.getPosicaoAtual().getColuna() - 1));
                    robo.getComecoFim().adicionar(robo.getPosicaoAtual());
                    robo.getFimComeco().adicionar(robo.getPosicaoAtual());
                    continue;
                }
                if (matriz[robo.getPosicaoAtual().getLinha() - 1][robo.getPosicaoAtual().getColuna()].equals(0) && robo.getPosicaoAtual().getLinha() - 1 != robo.getPosicaoAnterior().getLinha()) {
                    robo.setPosicaoAnterior(robo.getPosicaoAtual());
                    robo.setPosicaoAtual(new Posicao(robo.getPosicaoAtual().getLinha() - 1, robo.getPosicaoAtual().getColuna()));
                    robo.getComecoFim().adicionar(robo.getPosicaoAtual());
                    robo.getFimComeco().adicionar(robo.getPosicaoAtual());
                    continue;
                }
                if (matriz[robo.getPosicaoAtual().getLinha() + 1][robo.getPosicaoAtual().getColuna()].equals(0) && robo.getPosicaoAtual().getLinha() + 1 != robo.getPosicaoAnterior().getLinha()) {
                    robo.setPosicaoAnterior(robo.getPosicaoAtual());
                    robo.setPosicaoAtual(new Posicao(robo.getPosicaoAtual().getLinha() + 1, robo.getPosicaoAtual().getColuna()));
                    robo.getComecoFim().adicionar(robo.getPosicaoAtual());
                    robo.getFimComeco().adicionar(robo.getPosicaoAtual());
                    continue;
                }
            }
            if (matriz[robo.getPosicaoAtual().getLinha()][robo.getPosicaoAtual().getColuna() - 1].equals(0) && robo.getPosicaoAtual().getColuna() - 1 != robo.getPosicaoAnterior().getColuna()) {
                robo.setPosicaoAnterior(robo.getPosicaoAtual());
                robo.setPosicaoAtual(new Posicao(robo.getPosicaoAtual().getLinha(), robo.getPosicaoAtual().getColuna() - 1));
                robo.getComecoFim().adicionar(robo.getPosicaoAtual());
                robo.getFimComeco().adicionar(robo.getPosicaoAtual());
                continue;
            }
            if (matriz[robo.getPosicaoAtual().getLinha()][robo.getPosicaoAtual().getColuna() + 1].equals(0) && robo.getPosicaoAtual().getColuna() + 1 != robo.getPosicaoAnterior().getColuna()) {
                robo.setPosicaoAnterior(robo.getPosicaoAtual());
                robo.setPosicaoAtual(new Posicao(robo.getPosicaoAtual().getLinha(), robo.getPosicaoAtual().getColuna() + 1));
                robo.getComecoFim().adicionar(robo.getPosicaoAtual());
                robo.getFimComeco().adicionar(robo.getPosicaoAtual());
                continue;
            }
            if (matriz[robo.getPosicaoAtual().getLinha() - 1][robo.getPosicaoAtual().getColuna()].equals(0) && robo.getPosicaoAtual().getLinha() - 1 != robo.getPosicaoAnterior().getLinha()) {
                robo.setPosicaoAnterior(robo.getPosicaoAtual());
                robo.setPosicaoAtual(new Posicao(robo.getPosicaoAtual().getLinha() - 1, robo.getPosicaoAtual().getColuna()));
                robo.getComecoFim().adicionar(robo.getPosicaoAtual());
                robo.getFimComeco().adicionar(robo.getPosicaoAtual());
                continue;
            }
            if (matriz[robo.getPosicaoAtual().getLinha() + 1][robo.getPosicaoAtual().getColuna()].equals(0) && robo.getPosicaoAtual().getLinha() + 1 != robo.getPosicaoAnterior().getLinha()) {
                robo.setPosicaoAnterior(robo.getPosicaoAtual());
                robo.setPosicaoAtual(new Posicao(robo.getPosicaoAtual().getLinha() + 1, robo.getPosicaoAtual().getColuna()));
                robo.getComecoFim().adicionar(robo.getPosicaoAtual());
                robo.getFimComeco().adicionar(robo.getPosicaoAtual());
                continue;
            }
        }
        return robo;
    }
}
