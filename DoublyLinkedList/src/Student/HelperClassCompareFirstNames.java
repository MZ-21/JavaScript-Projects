package LE3Q2;

import java.util.Comparator;

public class HelperClassCompareFirstNames implements Comparator<Student> {
    public int compare(Student compSt1F,Student compSt2F){
        return compSt1F.getFirstName().compareTo(compSt2F.getFirstName());}}
