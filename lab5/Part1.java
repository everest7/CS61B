package com.lab5;

public class Part1 {
    public static void main(String[] args) {
        Person p1 = new Person("Jack",66);
        Student st1 = new Student();

        System.out.println(p1.getName());
        System.out.println(st1.getName());

        Student st2;
        Person p2;
        st2 = new Student("Larry",6,62,6);
        p2 = st2;
        System.out.println(st2.getName());
        System.out.println(p2.getName());

        Person[] personA;
        Student[] stuA;
        stuA = new Student[3];
        stuA[0] = new Student();
        stuA[1] = new Student();
        stuA[2] = new Student();
        System.out.println(stuA[0].getName());
        System.out.println(stuA[1].getName());
        System.out.println(stuA[2].getName());
        System.out.println("========");
        personA = stuA;
        System.out.println(personA[2].getName());
        System.out.println("========");

        Person[] personB;
        personB = new Person[3];
        personB[0] = new Student("Lee",9,60,9);
        personB[1] = stuA[1];
        personB[2] = personA[0];
        System.out.println(personB[0].getName());
        System.out.println(personB[1].getName());
        System.out.println(personB[2].getName());




    }
}
