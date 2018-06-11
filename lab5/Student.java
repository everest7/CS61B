package com.lab5;

public class Student extends Person {
    public int stuAge;

    public Student() {
        super("stu",65);
        stuAge =5;
    }

    public Student(String name, int age, int weight, int stuAge) {
        super(name, age, weight);
        this.stuAge = stuAge;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public void stuGrow() {
        stuAge += 1;
    }
}
