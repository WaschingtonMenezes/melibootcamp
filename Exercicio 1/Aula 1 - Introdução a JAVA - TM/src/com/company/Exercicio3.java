package com.company;

import java.util.Scanner;

public class Exercicio3 {
    /* Desenvolva um programa para informar se um um número n é primo ou não,
     * sendo n um valor que o usuário irá inserir pelo console. Lembre-se que
     * um número é primo quando só é divisível por 1 e por si mesmo. */

    public static void Execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número N:");
        int count = 0, n = scanner.nextInt();

        for (int i=2; i < n; i++) {
            if (n%i == 0) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Esse é um número Primo");
            return;
        }
        System.out.println("Esse não é um número primo");
    }
}
