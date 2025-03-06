import java.util.ArrayList;
public class TransferStation extends Station {
    public ArrayList<Station> otherStations;
    public TransferStation(String n, String c) {
        super(n, c);
        otherStations = new ArrayList<>();
    }

    public void addTransferStationPrev(Station s){
        otherStations.add(s);
        s.next = this;
    }

    public void addTransferStationNext(Station s){
        otherStations.add(s);
        s.prev = this;
    }

    public String toString() {
        String prevStation = " ";
        String nextStation = " ";
        if(this.prev == null){
            prevStation = "none";
        }
        else{
        prevStation = this.prev.name;
        }
        if(this.next == null){
            nextStation = "none";
        }
        else{
        nextStation = this.next.name;
        }
        String result = "TRANSFERSTATION " + name + ": " + color + " line, in service: " + inService + ", previous station: " + prevStation + ", next station: " + nextStation + "\n"+ "\tTransfers: \n";
        for (int i = 0; i<otherStations.size();i++) {
            result += "\t" + otherStations.get(i).toString() + "\n";
        }
        return result;
    }
    


}
