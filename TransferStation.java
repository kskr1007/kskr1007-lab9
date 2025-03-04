import java.util.ArrayList;
//otherStations.get(i)????
public class TransferStation extends Station {
    private ArrayList<Station> prev;
    private ArrayList<Station> next;
    public TransferStation(String n, String c) {
        super(n, c);
        prev = new ArrayList<>();
        next = new ArrayList<>();
    }

    public void addTransferStationPrev(Station s){
        prev.add(s);
        s.next = this;
    }

    public void addTransferStationNext(Station s){
        next.add(s);
        s.prev = this;
    }

    public String toString(){
        return "TRANSFER" + super.toString(); //fix this
    }


}
