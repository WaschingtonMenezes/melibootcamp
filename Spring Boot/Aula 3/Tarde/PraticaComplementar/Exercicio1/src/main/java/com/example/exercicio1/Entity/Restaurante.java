package com.example.exercicio1.Entity;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private List<Mesa> mesas = new ArrayList<>();

    public Restaurante() {
    }



    public List<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(List<Mesa> mesas) {
        this.mesas = mesas;
    }
}
