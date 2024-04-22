package com.example.demostudmgt;

import com.example.demostudmgt.entity.Student;

import java.io.*;

public class Utility {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student student = new Student();
        student.setId(1L);
        student.setFirstname("Sachin");
        student.setLastname("Arora");
        student.setEmail("sach@gmail.com");


        FileOutputStream fos = new FileOutputStream(new File("abc.txt"));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(student);
        oos.close();
        fos.close();


        FileInputStream fis = new FileInputStream("abc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object object = ois.readObject();
        System.out.println(object);
        ois.close();
        fis.close();


    }
}
