package LE3Q2;

import java.util.Comparator;

public class HelperClassCompareLastNames implements Comparator<Student> {
    public int compare(Student compSt1L,Student compSt2L) {
      return compSt1L.getLastName().compareTo(compSt2L.getLastName());
    }

}
