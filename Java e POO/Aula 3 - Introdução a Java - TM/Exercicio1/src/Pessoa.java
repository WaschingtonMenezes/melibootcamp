import java.util.Comparator;

public class Pessoa implements Precedente<Pessoa>, Comparator<Pessoa>{
    private String nome;
    private String cpf;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public int precedeA(Pessoa pessoa) {
        if (compare(this, pessoa) > 0) return 1;
        return 0;
    }

    @Override
    public int compare(Pessoa o1, Pessoa o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
}
