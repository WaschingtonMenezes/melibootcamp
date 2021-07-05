import Exercicio3.Book;
import Exercicio4.Fracao;
import Exercicio5.Data;
import Exercicio6.StringUtils;

public class main {

    public static void main(String[] args) {
        /**
        Book book = new Book("Harry Potter", "131513", "Rowling, J. K.");
        System.out.println(book.toString());
         **/

        /**
        Fracao f1 = new Fracao(2,1);
        Fracao f2 = new Fracao(5,6);
        f1.multiplicar(f2);
        System.out.println(f1.toString());
        */

        Data data = new Data(18, 8, 2000);
        System.out.println(data.toString());
        data.adicionarDia();
        System.out.println(data.toString());

        /**
        System.out.println(StringUtils.rpad("ola", 'a', 10));
        System.out.println(StringUtils.lpad("ola", 'a', 10));
        System.out.println(StringUtils.ltrim("             ola"));
        System.out.println(StringUtils.rtrim("ola               "));

        String s = "John | Paul | George | Ringo";
        System.out.println(StringUtils.indexOfN(s, '|', 50));
        System.out.println(StringUtils.indexOfN(s, '|', 2));
        */
    }
}
