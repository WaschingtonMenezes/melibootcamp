package com.company;

import java.util.Scanner;

public class Exercicio2 {
    /*Desenvolva um programa para mostrar os primeiros n números múltiplos de m,
    sendo n e m valores que o usuário irá inserir via console. Lembre-se que um
    número a é divisível por b se a é divisível por b.*/

    public static void Execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o valor de N:");
        final int n = scanner.nextInt();

        System.out.println("Digite o valor de M:");
        final int m = scanner.nextInt();

        for (int i = 0; i <= n; i++) {
            if (i % m == 0) {
                System.out.println(i);
            }
        }
    }
}
