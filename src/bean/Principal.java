/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Alunos
 */
public class Principal {
    @SuppressWarnings("Convert2Diamond")
    public static void main(String[] args) {
        Lista<String> lista = new ListaSimplesSemUltimo<String>();
        lista.adicionar("sudhaisduhasdhuisdh");
        lista.adicionar("ooooooooooooooo");
        lista.adicionar("3?");
        lista.adicionar("ssssssssssss", 3);
        System.out.println(lista);
        lista.substituir("substituido", 1);
        System.out.println(lista);
        lista.adicionar("adicionadoNoIndex1", 1);
        System.out.println(lista);
        System.out.println("Buscando no index 2: " + lista.buscar(2));
        System.out.println("Buscando objeto: " + lista.buscar("3?"));
        lista.remover("3?");
        System.out.println("Removendo objeto: "  + lista);
    }
}
