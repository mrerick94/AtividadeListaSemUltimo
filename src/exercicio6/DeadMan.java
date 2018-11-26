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
        Integer i = soldados.tamanho() - 1;
        while (soldados.tamanho() > 1) {
            Integer numSorteado = rand.nextInt(i);
            System.out.println(numSorteado);
            System.out.println("Removido: " + soldados.buscar(numSorteado));
            String string = soldados.buscar(numSorteado);
            soldados.remover(numSorteado);
            System.out.println(soldados);
            if (soldados.toString().contains(string)) {
                System.out.println("--> " + soldados);
            }
            i--;
        }
        System.out.println("À Morrer: " + soldados.buscar(0));
    }
}
