package com.luxoft.fullstack;

import java.util.ArrayList;

public class LambdaExample {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Ford", 4, 15000, CarType.COMPACT));
        cars.add(new Car("Chevrolet", 6, 18000, CarType.COMPACT));
        cars.add(new Car("Volkswagen", 4, 17000, CarType.COMPACT));
        cars.add(new Car("Honda", 4, 25000, CarType.COMPACT));
        cars.add(new Car("Ford", 4, 15000, CarType.SEDAN));
        cars.add(new Car("Toyota", 6, 26000, CarType.SUV));

        System.out.println(cars);
        System.out.println(filterCompactCars(cars));
        System.out.println(filterCars(cars, new SearchCompactCars()));
        System.out.println(filterCars(cars, new Search20kCars()));

        System.out.println("Lambda Expresions");
        System.out.println(filterCars(cars, c -> c.carType.equals(CarType.COMPACT)));
        System.out.println(filterCars(cars, c -> c.carType.equals(CarType.SUV)));
        System.out.println(filterCars(cars, c -> c.carType.equals(CarType.COMPACT) && c.cost > 20000));
        System.out.println(filterCars(cars, c -> c.carType.equals(CarType.SEDAN) || c.carType.equals(CarType.SUV)));
    }

    public static ArrayList<Car> filterCompactCars(ArrayList<Car> cars){
        ArrayList<Car>compactCars=new ArrayList<>();
        for(Car c : cars){
            if (c.carType.equals(CarType.COMPACT))
                compactCars.add(c);
        }
        return compactCars;
    }
    public static ArrayList<Car> filterCars(ArrayList<Car> cars, Searchable s){
        ArrayList<Car>compactCars=new ArrayList<>();
        for(Car c : cars){
            if (s.test(c))
                compactCars.add(c);
        }
        return compactCars;
    }
}

class SearchCompactCars implements Searchable{
    @Override
    public boolean test(Car car) {
        return car.carType.equals(CarType.COMPACT);
    }
}


class Search20kCars implements Searchable{
    @Override
    public boolean test(Car car) {
        return car.cost > 20000;
    }
}

@FunctionalInterface
interface Searchable{
    boolean test(Car car);
//    boolean test2(Car car); //Compilation fails
}

class Car{
    String brand;
    int cylinders;
    double cost;
    CarType carType;
    public Car(){}
    public Car(String brand, int cylinders, double cost, CarType carType) {
        this.brand = brand;
        this.cylinders = cylinders;
        this.cost = cost;
        this.carType = carType;
    }
    @Override
    public String toString() {
        return "Car{" + "brand=" + brand + ", cylinders=" + cylinders + ", cost=" + cost + ", carType=" + carType + '}';
    }

}

enum CarType{
    COMPACT, SEDAN, SUV, LUXURY
}
