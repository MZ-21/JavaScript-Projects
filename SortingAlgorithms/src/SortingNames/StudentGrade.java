package Q2;

public class StudentGrade implements Comparable<StudentGrade>{


        //private data fields
        private String firstName;
        private String lastName;
        private Integer grade;

        //constructor with no parameter
    public StudentGrade(){}

        //constructor with parameter
    public StudentGrade(String fN,String lN, Integer grd){
            this.firstName = fN;
            this.lastName = lN;
            this.grade = grd;
        }
        //getter & setter methods for each field
        public void setFN(String fN){
            this.firstName = fN;
        }
        public String getFirstName(){
            return firstName;
        }

        public void setLN(String lN){
            this.lastName=lN;
        }
        public String getLN(){
            return lastName;
        }
        public void setG(Integer g){
            this.grade=g;
        }
        public Integer getG(){
            return grade;
        }

        public int compareTo(StudentGrade g){
            return this.grade.compareTo(g.grade);
        }
        //overriding toString to print the list in the formatted way
        public String toString(){
            String s1="\b";
            String s2 = String.format("\b %8s %8s",getFirstName(),getLN());
            String s3 = String.format("\t:\t%d\n",getG());
            String s4 ="\b\b";

            return s1+s2+s3+s4;
        }

    }
