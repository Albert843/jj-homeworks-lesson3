package org.example.task2;

import static org.example.task2.ToDoListApp.*;

public class Program {
    public static void main(String[] args) {
        StudentV2 studentV2 = new StudentV2("Alexander", 25, 4.99);
        saveToFile(FILE_JSON, studentV2);
        saveToFile(FILE_BIN, studentV2);
        saveToFile(FILE_XML, studentV2);
        System.out.println("Object is serialized in three types of format: <json>, <bin>, <xml>");

        loadFromFile(FILE_JSON);
        loadFromFile(FILE_BIN);
        loadFromFile(FILE_XML);
    }
}
