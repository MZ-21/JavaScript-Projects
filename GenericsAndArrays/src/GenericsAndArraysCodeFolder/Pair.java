package Q_LE2;

public class Pair <Y,N>{

    //creating private fields whose types r chosen later since it is a generic class
    private Y key;
    private N value;

    //creating constructor that accepts Y and N types
    public Pair(Y key,N value){
        this.key=key;
        this.value=value;
    }

    //setter methods
    public void setKey(Y key){
        this.key=key;
    }
    public void setValue(N value){
        this.value=value;
    }

    //getter methods
    public Y getKey(){
        return key;
    }
    public N getValue(){
     return value;
    }


}
