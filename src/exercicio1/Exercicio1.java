/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1;

import bean.Lista;
import bean.ListaDuplaEncadeada;
import bean.ListaDuplaEncadeadaSemUltimo;

/**
 *
 * @author erick
 */
public class Exercicio1 {
    public static void main(String[] args) {
        Lista<String> nomes = new ListaDuplaEncadeadaSemUltimo();
        nomes.adicionar("João");
        nomes.adicionar("Maria");
        nomes.adicionar("Paula");
        nomes.adicionar("Pedro");
        nomes.remover(0);
        nomes.adicionar("José");
        nomes.remover(0);
        nomes.adicionar("João");
        nomes.adicionar("Marcelo");
        nomes.adicionar("Maria", 0);
        System.out.println(nomes);
        System.out.println(nomes.toStringInverse());
    }
}
