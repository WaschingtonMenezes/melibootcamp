package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Exercício:");
        int choice = scanner.nextInt();

        switch(choice) {
            case 1:
                Exercicio1.Execute();
                break;
            case 2:
                Exercicio2.Execute();
                break;
            case 3:
                Exercicio3.Execute();
                break;
            case 4:
                Exercicio4.Execute();
                break;
            case 5:
                Exercicio5.Execute();
                break;
            default:
                System.out.println("Opção Inválida");
        }
    }
}
