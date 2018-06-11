package com.lab5;

public class Person {
    public String name;
    public int age;
    public int weight;

    public Person(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Person(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public void grow(int year){
        age += year;
    }
}
