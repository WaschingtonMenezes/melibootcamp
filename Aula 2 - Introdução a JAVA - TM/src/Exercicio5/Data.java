package Exercicio5;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/*
* Crie uma classe Data. A classe conterá, além dos construtores que você considera
* apropriados, métodos de acesso e o método toString, conforme explicamos no exercício
* anterior, um método para verificar se a data está correta e outro para adicionar um
* dia ao valor atual da data. A classe GregorianCalendar deve ser investigada e usada
* para implementar os construtores e métodos Date.
*/
public class Data
{
    private GregorianCalendar data;

    public Data() {
    }

    public Data(int dia, int mes, int ano) {
        data = new GregorianCalendar(ano, mes, dia);
    }

    public void adicionarDia() {
        data.add(Calendar.DAY_OF_MONTH, 1);
    }

    @Override
    public String toString() {
        return this.data.get(Calendar.DAY_OF_MONTH) + "/" + this.data.get(Calendar.MONTH) + "/" + this.data.get(Calendar.YEAR);
    }
}
