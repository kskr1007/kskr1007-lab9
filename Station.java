import java.util.ArrayList;

public class Station {
    protected String name;
    protected String color;
    protected boolean inService;
    protected Station next;
    protected Station prev;
    protected ArrayList<Station> otherStations;
    boolean repeat = false;
    
    public Station(String c, String n){
        this.name = n;
        this.color = c;
        this.inService = true;
        this.next = null;
        this.prev= null;
    }

    public void addNext(Station s){
        this.next = s;
        s.prev =this;
    }

    public void addPrev(Station s){
        this.prev = s;
        s.next = this;
    }

    public boolean isAvailable(){
        return this.inService;
    }

    public void switchAvailable(){
        this.inService = !this.inService;
    }

    public boolean equals(Station s){
        if(this.name.equals(s.name)&& this.color.equals(s.color)){
            return true;
        }
        return false;
    }

    public void connect(Station s){
        this.next = s;
        s.prev = this;
    }


    public int tripLength(Station dest){
        return tripLength(dest, new ArrayList<>());
    }

    public int tripLength(Station dest,ArrayList<Station>v){
        if(this.equals(dest)){
            return 0;
        }
        for (int i = 0;i<v.size();i++){
            if(this.equals(v.get(i))){
                return this.next.tripLength(dest)-1;
            }
        }
        v.add(this);
        Station nextStation = this.next;
        if(this instanceof TransferStation && !this.color.equals(dest.color)){
            for(int i = 0; i<otherStations.size();i++){
                if(otherStations.get(i).color.equals(dest.color)){
                    nextStation = otherStations.get(i);
                }
            }
        }
        return 1 + nextStation.tripLength(dest,v);
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
        return "STATION " + name + ": " + color + " line, " + "in service: " + inService + ", " + "previous station: " + prevStation + ", " + "next station: " + nextStation;
    }
    

}


