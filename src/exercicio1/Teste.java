/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1;

import bean.ListaDuplaEncadeadaSemUltimo;
import bean.ListaSimplesSemUltimo;

/**
 *
 * @author erick
 */
public class Teste {
    public static void main(String[] args) {
        ListaDuplaEncadeadaSemUltimo<String> lista = new ListaDuplaEncadeadaSemUltimo<String>();
        lista.adicionar("teste1", 0);
        lista.adicionar("teste2", 0);
        lista.adicionar("teste3", 0);
        lista.adicionar("teste4", 0);
        lista.adicionar("teste5", 0);
        lista.adicionar("teste6", 0);
        System.out.println(lista);
        lista.remover(5);
        System.out.println(lista);
        System.out.println("--------------------------------");
        ListaSimplesSemUltimo<String> lista2 = new ListaSimplesSemUltimo<String>();
        lista2.adicionar("teste1", 0);
        lista2.adicionar("teste2", 0);
        lista2.adicionar("teste3", 0);
        lista2.adicionar("teste4", 0);
        lista2.adicionar("teste5", 0);
        lista2.adicionar("teste6", 0);
        System.out.println(lista2);
        lista2.remover(5);
        System.out.println(lista2);
    }
}
