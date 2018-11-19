/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio2;

import bean.Fila;
import bean.FilaSemUltimo;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author erick
 */
public class Exercicio2 {

    public static void main(String[] args) {
        FilaSemUltimo<Integer> filaNormal = new FilaSemUltimo();
        FilaSemUltimo<Integer> filaPrioritaria = new FilaSemUltimo();
        Integer sair = 0;
        while (sair != 4) {
            sair = menu(filaNormal, filaPrioritaria);
        }
    }

    public static Integer menu(FilaSemUltimo normal, FilaSemUltimo prioritaria) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Escolha uma opção:");
        System.out.println("1: Gerar senha normal");
        System.out.println("2: Gerar senha prioritária");
        System.out.println("3: Chamar próxima senha e visualizar fila de espera");
        System.out.println("4: Sair");
        System.out.print("Resposta: ");
        Integer escolha = scan.nextInt();
        Random rand;
        switch (escolha) {
            case 1:
                rand = new Random();
                Integer senhaNormalRandom = rand.nextInt(999);
                while (normal.existe(senhaNormalRandom) || prioritaria.existe(senhaNormalRandom)) {
                    senhaNormalRandom = rand.nextInt(999);
                }
                normal.adicionar(senhaNormalRandom);
                System.out.println("---------------------------");
                System.out.println("Fila de espera normal: " + normal);
                System.out.println("Fila de espera prioritaria: " + prioritaria);
                System.out.println("---------------------------");
                break;
            case 2:
                rand = new Random();
                Integer senhaNPrioritariaRandom = rand.nextInt(999);
                while (normal.existe(senhaNPrioritariaRandom) || prioritaria.existe(senhaNPrioritariaRandom)) {
                    senhaNPrioritariaRandom = rand.nextInt(999);
                }
                prioritaria.adicionar(senhaNPrioritariaRandom);
                System.out.println("---------------------------");
                System.out.println("Fila de espera normal: " + normal);
                System.out.println("Fila de espera prioritaria: " + prioritaria);
                System.out.println("---------------------------");
                break;
            case 3:
                if (prioritaria.tamanho() > 0) {
                    Integer removido = (Integer) prioritaria.remover();
                    System.out.println("Senha chamada: P" + removido);
                    System.out.println("---------------------------");
                    System.out.println("Fila de espera normal: " + normal);
                    System.out.println("Fila de espera prioritaria: " + prioritaria);
                    System.out.println("---------------------------");
                    break;
                } else if (normal.tamanho() > 0) {
                    Integer removido = (Integer) normal.remover();
                    System.out.println("Senha chamada: N" + removido);
                    System.out.println("---------------------------");
                    System.out.println("Fila de espera normal: " + normal);
                    System.out.println("Fila de espera prioritaria: " + prioritaria);
                    System.out.println("---------------------------");
                    break;
                } else {
                    System.out.println("Filas vazias");
                    break;
                }
            case 4:
                System.out.println("Saindo...");
        }
        return escolha;
    }
}
