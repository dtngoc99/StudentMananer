/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai10_StudentManager;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NGOC TY
 */
public class Manage implements ClassInterface{
    ArrayList<Student> class1List=new ArrayList<>();
    ArrayList<Student> class2List=new ArrayList<>();
    ArrayList<Student> studentCourse1List=new ArrayList<>();
    ArrayList<Student> studentCourse2List=new ArrayList<>();
    private final String linkClass1="D:\\NetBean\\Java\\JavaApplication6\\src\\Bai10_StudentManager\\Class1.txt";
    private final String linkClass2="D:\\NetBean\\Java\\JavaApplication6\\src\\Bai10_StudentManager\\Class2.txt";
    private final String linkCourse1="D:\\NetBean\\Java\\JavaApplication6\\src\\Bai10_StudentManager\\Course1.txt";
    private final String linkCourse2="D:\\NetBean\\Java\\JavaApplication6\\src\\Bai10_StudentManager\\Course2.txt";
    
    public String getLinkClass1() {
        return linkClass1;
    }

    public String getLinkClass2() {
        return linkClass2;
    }

    public String getLinkCourse1() {
        return linkCourse1;
    }

    public String getLinkCourse2() {
        return linkCourse2;
    }
    
    public void readFileClass(String link){
        try {
            Scanner scan = new Scanner(Paths.get(link), "UTF-8");
            String s;
            String s1="Class1";
            String s2="Class2";
            Boolean kt;
            kt = link.contains(s1);
            while(scan.hasNextLine()){
                s=scan.nextLine();
                Student st=new Student();
                StringTokenizer token=new StringTokenizer(s,",");
                st.setID(token.nextToken());
                st.setName(token.nextToken());
                st.setPhoneNumber(token.nextToken());
                st.setGender(token.nextToken());
                st.setBirthday(token.nextToken());
                if(kt==true){
                    st.setClasses(nameClass1);
                    class1List.add(st);
                }
                else{ 
                    st.setClasses(nameClass2);
                    class2List.add(st);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    public void writeFileClass(String link) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        String s1="Class1";
        String s2="Class2";
        Boolean kt;
        kt=link.contains(s1);
        try (FileOutputStream fos = new FileOutputStream(link); 
                OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8"); 
                BufferedWriter bw = new BufferedWriter(osw)) {
                if(kt==true){
                    for(Student s: class1List){
                        bw.write(s.getID()+",");
                        bw.write(s.getName()+",");
                        bw.write(s.getPhoneNumber()+",");
                        bw.write(s.getGender()+",");
                        bw.write(s.getBirthday()+"\n");
                    }
                }
                else{
                    for(Student s: class2List){
                        bw.write(s.getID()+",");
                        bw.write(s.getName()+",");
                        bw.write(s.getPhoneNumber()+",");
                        bw.write(s.getGender()+",");
                        bw.write(s.getBirthday()+"\n");
                    }
                }
        }
             
    }
    public void readFileCourse(String link) throws IOException{
        String s1="Course2";
        String s;
        Boolean kt;
        kt=link.contains(s1);
        Scanner scan=new Scanner(Paths.get(link), "UTF-8");
        while(scan.hasNextLine()){
            Student st=new Student();
            s=scan.nextLine();
            StringTokenizer token =new StringTokenizer(s,",");
            st.setID(token.nextToken());
            st.setClasses(token.nextToken());
            st.setName(token.nextToken());
            if(kt==false){
                st.setCourse(Student.codeCourse1);
                studentCourse1List.add(st);
            }
            else{
                st.setCourse(Student.codeCourse2);
                studentCourse2List.add(st);
            }
        }
        
    }
    public void writeFileCourse(String link) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        String s1="Course1";
        Boolean kt=link.contains(s1);
        try (FileOutputStream fos = new FileOutputStream(link); 
                OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8"); 
                BufferedWriter bw = new BufferedWriter(osw)) {
                if(kt==true){
                    for(Student s: studentCourse1List){
                        bw.write(s.getID()+",");
                        bw.write(s.getClasses()+",");
                        bw.write(s.getName()+"\n");
                    }
                }
                else{
                    for(Student s: studentCourse2List){
                            bw.write(s.getID()+",");
                            bw.write(s.getClasses()+",");
                            bw.write(s.getName()+"\n");
                    }
                }
        }
    }
}
