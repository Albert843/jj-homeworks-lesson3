package org.example.task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoListApp {
    public static final String FILE_JSON = "student.json";
    public static final String FILE_BIN = "student.bin";
    public static final String FILE_XML = "student.xml";


    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    public static StudentV2 studentV2 = new StudentV2();

    /**
     * Метод, сохраняющий объект в форматы <json> <bin> <xml>
     * @param fileName
     * @param studentV2
     */
    public static void saveToFile(String fileName, StudentV2 studentV2) {
        try {
            if (fileName.endsWith(".json")) {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(fileName), studentV2);
            } else if (fileName.endsWith(".bin")) {
                try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                    oos.writeObject(studentV2);
                }
            } else if (fileName.endsWith(".xml")) {
                xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                xmlMapper.writeValue(new File(fileName), studentV2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод, возвращающий объект из форматов <json> <bin> <xml>
     * @param fileName
     * @return
     */
    public static StudentV2 loadFromFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            try {
                if (fileName.endsWith(".json")) {
                    studentV2 = objectMapper.readValue(file, objectMapper.getTypeFactory().constructType(StudentV2.class));
                } else if (fileName.endsWith(".bin")) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                        studentV2 = (StudentV2) ois.readObject();
                    }
                } else if (fileName.endsWith(".xml")) {
                    studentV2 = xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructType(StudentV2.class));
                }

            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("name: " + studentV2.getName());
            System.out.println("age: " + studentV2.getAge());
            System.out.println("GPA: " + studentV2.getGPA());
        }
        return studentV2;
    }
}
