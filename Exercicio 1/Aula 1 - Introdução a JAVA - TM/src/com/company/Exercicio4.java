package com.company;

import java.util.Scanner;

public class Exercicio4 {
    public static void Execute() {
	/* Exercício 4
	    Desenvolva um programa para mostrar por console os primeiros n números primos, sendo um valor que o usuário irá inserir pelo console.*/

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número N:");
        int count = 0, n = scanner.nextInt();

        for (int i=0; i <= n; i++) {
            for (int j=2; j < i; j++) {
                if (i%j == 0) {
                    count++;
                }
            }
            if (count == 0) {
                System.out.println(i);
            }
            count = 0;
        }
    }
}
