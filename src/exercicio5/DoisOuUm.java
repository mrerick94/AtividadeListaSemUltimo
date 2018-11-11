/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio5;

import bean.Lista;
import bean.ListaCircular;
import bean.ListaCircularSemUltimo;
import javax.swing.JOptionPane;

/**
 *
 * @author erick
 */
public class DoisOuUm {
    public static void main(String[] args) {
        Lista<String> pessoas = new ListaCircularSemUltimo<String>();
        String pessoa = "";
        do {
            pessoa = new String(JOptionPane.showInputDialog("Digite um nome à adicionar na lista (Deixe vazio pra sair do loop)"));
            if (!pessoa.isEmpty()) {
                pessoas.adicionar(pessoa);
            }
        } while (!pessoa.isEmpty());
        System.out.println(pessoas.tamanho());
        Integer pessoaEscolhida = Integer.valueOf(JOptionPane.showInputDialog("Número para sortear uma pessoa:") + 1);
        if (pessoaEscolhida <= pessoas.tamanho()) {
            for (int i = 0; i < pessoaEscolhida; i++) {
                pessoa = pessoas.buscar(i);
            }
        } else {
            pessoa = pessoas.buscar((pessoaEscolhida - 1) % pessoas.tamanho());
        }
        System.out.println(pessoa);
    }
}
