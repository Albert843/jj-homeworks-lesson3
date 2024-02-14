package org.example.task2;

import java.io.*;

public class StudentV2 implements Externalizable {

    //region Поля
    private String name;
    private int age;
    private transient double GPA;
    //endregion

    //region Конструкторы


    public StudentV2() {
    }

    public StudentV2(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }
    //endregion

    //region Методы
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getGPA() {
        return GPA;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(age);
        out.writeObject(GPA);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = (int) in.readObject();
        GPA = (double) in.readObject();
    }
    //endregion
}
