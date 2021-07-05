package Exercicio3;

/*
* Crie uma classe Book com os métodos: empréstimo, devolver e toString,
* cujo protótipo deve ser: public String toString (). Este método deve
* retornar uma string que representa o objeto. Por exemplo: se a classe
* tiver os atributos: título, isbn e autor, uma string representando um
* livro poderia ser: "Harry Potter, 9780545582889, Rowling, J. K.". A classe
* conterá um construtor padrão, um construtor com parâmetros e os métodos de acesso.
*
 Adicione a linha @Override logo acima do cabeçalho do método toString.
 * Em seguida, renomeie o método para: tostring (tudo em letras minúsculas).
 * O que acontece?
*/

public class Book {
    private String titulo;
    private String isbn;
    private String autor;

    public Book() {
    }

    public Book(String titulo, String isbn, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
    }

    public void emprestimo() {}
    public void devolver() {}

    @Override
    public String toString(){
        return this.titulo + ", " + this.isbn + ", " + this.autor;
    }
}
