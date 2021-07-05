import java.util.List;

public class Corrida {
    private Double distancia;
    private Double premioEmDolares;
    private String nome;
    private Integer quantidadeVeiculosPermitidos;
    private List<Veiculo> listaVeiculos;
    private SocorristaCarro socorristaCarro = new SocorristaCarro();
    private SocorristaMoto socorristaMoto = new SocorristaMoto();


    public Corrida(Double distancia, Double premioEmDolares, String nome, Integer quantidadeVeiculosPermitidos, List<Veiculo> listaVeiculos) {
        this.distancia = distancia;
        this.premioEmDolares = premioEmDolares;
        this.nome = nome;
        this.quantidadeVeiculosPermitidos = quantidadeVeiculosPermitidos;
        this.listaVeiculos = listaVeiculos;
    }

    public void registrarCarro(Double velocidade, Double aceleracao, Double anguloDeGiro, String patente) {
        if(this.listaVeiculos.size() >= this.quantidadeVeiculosPermitidos) {
            System.out.println("Não foi possível inserir veículo, limite máximo atingido");
            return;
        }
        this.listaVeiculos.add(new Carro(velocidade, aceleracao,anguloDeGiro, patente));
    }

    public void registrarMoto(Double velocidade, Double aceleracao, Double anguloDeGiro, String patente){
        if(this.listaVeiculos.size() >= this.quantidadeVeiculosPermitidos) {
            System.out.println("Não foi possível inserir veículo, limite máximo atingido");
            return;
        }
        this.listaVeiculos.add(new Moto(velocidade, aceleracao,anguloDeGiro, patente));
    }

    public void removerVeiculo(Veiculo veiculo){
        this.listaVeiculos.remove(veiculo);
    }

    public void removerVeiculoPorPlaca(String placa) {
        this.listaVeiculos.removeIf(veiculo -> veiculo.getPlaca().equals(placa));
    }

    public Veiculo determinarVencedor() {
        double velo, maxVelo = 0;
        Veiculo primeiroLugar = new Veiculo();
        for(Veiculo veiculo : this.listaVeiculos) {
            velo = veiculo.getVelocidade() * veiculo.getAceleracao() / (veiculo.getAnguloDeGiro() * (veiculo.getPeso() - veiculo.getRodas() * 100));
            if (velo > maxVelo) {
                maxVelo = velo;
                primeiroLugar = veiculo;
            }
        }
        System.out.println("Primeiro Lugar!! Placa: " + primeiroLugar.getPlaca());
        return primeiroLugar;
    }

    public void socorrerCarro(String documento) {
        Carro carro = (Carro) this.listaVeiculos.stream().filter(c -> c.getPlaca().equals(documento)).findAny().orElseThrow();
        this.socorristaCarro.socorrer(carro);
    };

    public void socorrerMoto(String documento) {
        Moto moto = (Moto) this.listaVeiculos.stream().filter(c -> c.getPlaca().equals(documento)).findAny().orElseThrow();
        this.socorristaMoto.socorrer(moto);
    };
}
