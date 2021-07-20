package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Exercicio2 {
    /*Exercício 2:  Em 2021 uma startup de tecnologia, denominada de “Empresa X” é avaliada
    em 1,13 milhão e possui uma média de crescimento anual de 148%, uma concorrente do ramo,
    “Empresa Y”, é avaliada em 18,4 milhões e com sua média de crescimento anual em 32%.*/

    /* Considerando este cenário, imprima no console (conforme formatação acima) a evolução anual até que a empresa X ultrapasse a empresa Y em seu valor de empresa.*/
    public static void execute() {
        double valueCompanyX = 1.13, valueCompanyY = 18.4;
        Calendar date = Calendar.getInstance();
        date.set(2021,01,01);

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        while(valueCompanyX < valueCompanyY) {
            System.out.println(String.format("Empresa X - %s - Valor da empresa: %.2fm", dateFormat.format(date.getTime()), valueCompanyX));
            System.out.println(String.format("Empresa Y - %s - Valor da empresa: %.2fm", dateFormat.format(date.getTime()), valueCompanyY));

            valueCompanyX += valueCompanyX * 1.48;
            valueCompanyY += valueCompanyY * 0.32;

            date.add(Calendar.YEAR, 1);
        }
    }
}
