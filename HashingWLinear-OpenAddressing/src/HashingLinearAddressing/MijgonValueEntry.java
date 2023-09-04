package LA3Q1;

public class MijgonValueEntry {

    //Fields
    private Integer key;

    //constructors
    public MijgonValueEntry(){
        this.key = -1;  //assigning key field to flag a null in hashtable
    }
    public MijgonValueEntry(Integer k){
        this.key = k;
    }

    //Getter and setter methods
    public void setKey(Integer k){
        this.key=k;
    }
    public Integer getKey(){
        return this.key;
    }



}
