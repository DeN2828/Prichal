//Создать имитационную модель «причал морских катеров». Необходимо вводить следующую информацию:
//        1. Среднее время между появлениями пассажиров
//        на причале в разное время суток;
//        2. Среднее время между появлениями катеров на причале в разное время суток;
//        3. Тип остановки катер (конечная или нет).
//        Необходимо определить:
//        1. Среднее время пребывание человека на остановке;
//        2. Достаточный интервал времени между приходами
//        катеров, чтобы на остановке находилось не более N
//        людей одновременно;
//        3. Количество свободных мест в катере является случайной величиной.
package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите среднее время между появлениями пассажиров на причале: ");
        float AvgTime = in.nextInt();
        System.out.println("Введите среднее время между появлениями катеров на причале: ");
        float AvgShips = in.nextInt();
//        System.out.println("Введите кол-во мест в катере: ");
//        int ContentShip = in.nextInt();
//        System.out.println("Тип остановки катер (Конечная или Нет): ");
//        String TypeShips = in.next();

//        2 корабля == больше интервал
//        3 корабля == меньше интервал

        Prichall output = new Prichall(AvgTime,AvgShips);
        output.showShips();
    }
}
class Prichall
{
    float AvgTime;
    float AvgShips; //Среднее время между появлениями катеров на причале, сек
    String TypeShips;
    private int countShips; //Кол-во кораблей в день
    private ArrayList<Ship> ships;
    private int coutPass; //Кол-во пассажиров на причали в данный момент


    //public Prichall(float AvgTime,float AvgShips,int ContentShip,String TypeShips)
    public Prichall(float AvgTime,float AvgShips)
    {
        this.AvgTime = AvgTime;
        this.AvgShips = AvgShips;
//        this.ContentShip = ContentShip;
//        this.TypeShips = TypeShips;

        this.countShips = (int)((24*60*60) / AvgShips);
        ships = new ArrayList<Ship>(countShips);

        for(int i = 0 ; i < countShips ; i++){
            Random r = new Random();
            Ship ship = new Ship(
                    r.nextInt(50) + 10,
                    r.nextBoolean()
            );
            ships.add(ship);
        }
    }

    public void showShips() {
        for(Ship ship : ships) {
            System.out.printf("Корабль вмещает %d пассажиров. Корабль %s берет пассажиров\n",
                    ship.N, (ship.isultimate) ? "не" : "");
        }
    }

//    public void Show()
//    {
//
//        {
//            switch (TypeShips)
//            {
//                case "Конечная":
//                {
//                    float result = (AvgShips / AvgTime) / 2;
//                    System.out.println("Среднее время пребывание человека на остановке: " + result + " секунд");
//                    break;
//                }
//            }
//        }
//    }
}
