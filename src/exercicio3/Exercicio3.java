/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio3;

import bean.Fila;
import bean.FilaSemUltimo;

/**
 *
 * @author erick
 */
public class Exercicio3 {
    public static void main(String[] args) throws Exception {
        FilaSemUltimo<Processo> processos = new FilaSemUltimo<>();
        processos.adicionar(new Processo("A", 72));
        processos.adicionar(new Processo("B", 90));
        processos.adicionar(new Processo("C", 68));
        processos.adicionar(new Processo("D", 55));
        processos.adicionar(new Processo("E", 47));
        processar(processos);
    }
    
    public static void processar(FilaSemUltimo processos) throws Exception {
        while (processos.tamanho() > 0) {
            System.out.println("Processos à resolver: " + processos);
            Processo processo = (Processo) processos.remover();
            System.out.println("Processando: " + processo);
            processo.setTempo(processo.getTempo() - 10);
            if (processo.getTempo() > 0) {
                processos.adicionar(processo);
            }
            Thread.sleep(1000);
        }
    }
}
