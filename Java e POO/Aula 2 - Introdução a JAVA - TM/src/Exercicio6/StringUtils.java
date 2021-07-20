package Exercicio6;
/*
* Partindo da classe StringUtil (que usamos para resolver Radix Sort), agregar os seguintes métodos estáticos:

* public static String rpad (String s, char c, int n); idem lpad, mas adicionando caracteres à direita.
public static String ltrim (String s); Retorna uma string idêntica a s, mas sem espaços à esquerda.
public static String rtrim (String s); idem ltrim, mas sem espaços à direita.

public static String trim(String s);  idem lpad, mas sem espaços à direita ou à esquerda.

public static int indexOfN (String s, char c, int n); Retorna a posição da enésima ocorrência do caractere c em s,
* ou -1 se s não contiver c. Por exemplo, se s = "John | Paul | George | Ringo", c = ‘|’ e n = 2, a função deve
* retornar a posição da segunda ocorrência do caractere ‘|’ (barra vertical) dentro da string s. Que, neste caso, é: 9.
*/

public class StringUtils {
    public static String rpad (String s, char c, int n) {
        for(int i = 0; i < n; i++){
            s += c;
        }
        return s;
    }

    public static String lpad (String s, char c, int n) {
        for(int i = 0; i < n; i++){
            s = c + s;
        }
        return s;
    }

    public static String ltrim (String s) {
        return s.replaceAll("^\\s+", "");
    }
    public static String rtrim (String s) {
        return s.replaceAll("\\s+$", "");
    }

    public static int indexOfN (String s, char c, int n) {
            int count = 0;
            int index = -1;
            while (count != n) {
                index = s.indexOf(c, index + 1);
                if (index == -1) return index;
                count++;
            }
            return index;
    }
}
