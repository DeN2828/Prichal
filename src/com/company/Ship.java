package com.company;

public class Ship {
    public int N; //Вместимость корабля
    public boolean isultimate; //true - конечная швартовка, false - плывет дальше

    Ship(int N, boolean isultimate) {
        this.N = N;
        this.isultimate = isultimate;
    }
}
