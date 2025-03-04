import java.util.ArrayList;
public class TransferStation extends Station {
    public ArrayList<Station> otherStations;
    private String prevStation;
    private String nextStation;
    public TransferStation(String n, String c) {
        super(n, c);
        otherStations = new ArrayList<>();
    }

    public void addTransferStationPrev(Station s){
        otherStations.add(s);
        s.next= this;
    }

    public void addTransferStationNext(Station s){
        otherStations.add(s);
        s.prev = this;
    }

    public String toString() {
        if(prev == null){
            prevStation = "none";
        }
        if(next ==null){
            nextStation = "none";
        }
        String result = "TRANSFERSTATION " + name + ": " + color + " line, in service: " + inService + ", previous station: " + prevStation + ", next station: " + nextStation + "\n"+ "\tTransfers: \n";
        for (int i = 0; i<otherStations.size();i++) {
            result += "\t" + otherStations.get(i).toString() + "\n";
        }
        return result;
    }
    


}
