package LE3Q2;
import java.util.*;
 public class Student implements Comparable<Student> {
    //creating private fields
    private Double score;
    private String firstName;
    private String lastName;

    //creating constructors
    public Student(){
        this.score=94.0;
        this.firstName="Mijgon";
        this.lastName="Zekria";

    }

    public Student(String fsN,String lstN,Double scr){
        this.score=scr;
        this.firstName=fsN;
        this.lastName=lstN;
    }

    //getScore method
    public Double getScore(){
        return score;
    }

    //setScore method
    public Double setScore(Double scr){
       return this.score =scr;

    }
    //toString method
    public String toString(){
        String sr1=String.format("\b\b"+"\t"+firstName+ " "+lastName+": ");
        String sr2=String.format("%.2f \n",score);
        return sr1+sr2;
    }
    //compareTo
    public int compareTo(Student scr){
        int retV =0;
        if(this.score<scr.score){
            retV=1;
        }
        else if(this.score>scr.score){
            retV=-1;
        }
        else{retV=0;}

        return retV;
}
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String fsN){
        this.firstName=fsN;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lsN){
        this.lastName=lsN;
    }
 }
