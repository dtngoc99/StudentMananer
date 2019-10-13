/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai10_StudentManager;

import java.util.Scanner;

/**
 *
 * @author NGOC TY
 */
public class Student implements ClassInterface,CourseInterface  {
    private String ID;
    private String name;
    private String phoneNumber;
    private String gender;
    private String birthday;
    private String classes;//tên lớp
    private String course;//mã môn học

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getClasses() {
        return classes;
    }

    public String getCourse() {
        return course;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    
    public void input(){
        Scanner scan=new Scanner(System.in);
        System.out.println("ID: ");
        ID=scan.nextLine();
        System.out.println("NameStudent: ");
        name=scan.nextLine();
        System.out.println("PhoneNumber: ");
        phoneNumber=scan.nextLine();
        System.out.println("Gender: ");
        gender=scan.nextLine();
        System.out.println("Birthday :");
        birthday=scan.nextLine();
        System.out.println("Class(1 or 2): ");
        int x=scan.nextInt();
        if(x==1) classes=nameClass1;
        else classes=nameClass2;
        System.out.println("Course(1 or 2): ");
        x=scan.nextInt();
        if(x==1)course=codeCourse1;
        else course=codeCourse2;
        
    }
    public void output(){
        System.out.println("ID: "+ID);
        System.out.println("Name: "+name);
        System.out.println("PhoneNumber: "+phoneNumber);
        System.out.println("Gender: "+gender);
        System.out.println("Birthday: "+birthday);
        System.out.println("Class: "+classes);
        System.out.println("Course: "+course);
    }
}
