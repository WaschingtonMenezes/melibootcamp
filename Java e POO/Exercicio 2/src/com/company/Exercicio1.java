package com.company;

import java.util.Arrays;
import java.util.Collections;

public class Exercicio1 {
    /*Exercício 1: Dado um vetor de 10 posições, sendo respectivamente ocupado pelos valores
    52, 10, 85, 1324, 01, 13, 62, 30, 12 e 127.*/

    /*Imprima no console:
    a) Sua ordenação crescente.
    b) Sua ordenação decrescente.*/

    public static void execute() {
        Integer[] arr = {52, 10, 85, 1324, 01, 13, 62, 30, 12,127};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
    }
}
