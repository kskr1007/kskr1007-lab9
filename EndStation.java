public class EndStation extends Station {

    public EndStation(String n, String c) {
        super(n, c);
    }

    public void makeEnd(){
        if(getNext()!= null){
            setNext(this);
        }
    }

    public String toString(){
        return "END" + super.toString();
    }
    
}
