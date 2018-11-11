/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio6;

import bean.Lista;
import bean.ListaDuplaEncadeada;
import bean.ListaDuplaEncadeadaSemUltimo;
import java.util.Random;

/**
 *
 * @author erick
 */
public class DeadMan {
    public static void main(String[] args) throws Exception {
        Lista<String> soldados = new ListaDuplaEncadeadaSemUltimo<>();
        Random rand = new Random();
        soldados.adicionar("Erick");
        soldados.adicionar("Robson");
        soldados.adicionar("Felipe");
        soldados.adicionar("Brenner");
        soldados.adicionar("Gabriel");
        Integer i = soldados.tamanho();
        while (soldados.tamanho() > 1) {
            Integer numSorteado = rand.nextInt(i);
            System.out.println("Removido: " + soldados.buscar(numSorteado));
            soldados.remover(numSorteado);
            i--;
            Thread.sleep(1000);
        }
        System.out.println("À Morrer: " + soldados.buscar(0));
    }
}
