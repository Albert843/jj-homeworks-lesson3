package org.example.task1;

import java.io.*;

public class Program {
    public static void main(String[] args) {
        Student student = new Student("Vasily", 25, 4.85);

        System.out.println("student: " + student.getName());
        System.out.println("age: " + student.getAge());
        System.out.println("GPA: " + student.getGPA());

        try(FileOutputStream fileOut = new FileOutputStream("studentdata.bin");
            ObjectOutputStream out = new ObjectOutputStream(fileOut))
        {
            out.writeObject(student);
            System.out.println("object serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileInputStream fileIn = new FileInputStream("studentdata.bin");
            ObjectInputStream in = new ObjectInputStream(fileIn))
        {
            student = (Student) in.readObject();
            System.out.println("\nobject deserialized");
            System.out.println("student: " + student.getName());
            System.out.println("age: " + student.getAge());
            System.out.println("GPA (0.0 because transient): " + student.getGPA());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
