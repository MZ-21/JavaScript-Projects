package LE3Q1;

public class MyStudent {

    //creating private fields
    private String firstName;
    private double score;

    public MyStudent(){
        this.firstName = "Mijgon";
        this.score = 89.55;
    }
    public MyStudent(String firstN,double scr){
        this.firstName = firstN;
        this.score = scr;
    }
    public String toString(){
        String str1 = String.format(firstName);
        String str2 = String.format(": %.2f",score);

        return str1 + str2;
    }

}
