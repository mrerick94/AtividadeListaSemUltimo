/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio7;

import bean.Lista;
import bean.ListaCircularSemUltimo;
import bean.ListaDuplaEncadeadaSemUltimo;
import bean.ListaSimplesSemUltimo;
import bean.PilhaSemUltimo;
import java.nio.file.Files;
import java.io.File;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author erick
 */
public class Forca {

    public static void main(String[] args) throws Exception {
        Lista<String> palavras = new ListaCircularSemUltimo();
        PilhaSemUltimo<String> letrasErradas = new PilhaSemUltimo();
        Lista<Character> letrasCertas = new ListaSimplesSemUltimo();
        Lista<Character> palavraParcial = new ListaDuplaEncadeadaSemUltimo();
        int numTentativasErradas = 0;
        Random rand = new Random();
        for (String palavra : Files.readAllLines(new File("palavras.txt").toPath())) {
            palavras.adicionar(palavra);
        }
        String palavraSorteada = palavras.buscar(rand.nextInt(100) % palavras.tamanho());
        for (int i = 0; i < palavraSorteada.length(); i++) {
            palavraParcial.adicionar("-".toCharArray()[0]);
        }
        System.out.println(palavraSorteada);
        System.out.println(palavraParcial);
        while (numTentativasErradas <= 5) {
            String chute = JOptionPane.showInputDialog("Digite uma letra à tentar na Forca:").toLowerCase();
            if (palavraSorteada.contains(chute)) {
                while (palavraSorteada.contains(chute)) {
                    letrasCertas.adicionar(palavraSorteada.charAt(palavraSorteada.indexOf(chute)));
                    palavraParcial.substituir(palavraSorteada.charAt(palavraSorteada.indexOf(chute)), palavraSorteada.indexOf(chute));
                    palavraSorteada = palavraSorteada.replaceFirst(chute, "-");
                }
            } else {
                letrasErradas.adicionar(chute);
                numTentativasErradas++;
            }
            System.out.println("---------------------------------------------------");
            System.out.println("Letras Erradas: " + letrasErradas);
            System.out.println("Número de erros restantes: " + (5 - numTentativasErradas));
            System.out.println("Palavra: " + palavraParcial);
        }
        JOptionPane.showMessageDialog(null, "Você Morreu!");
    }
}
