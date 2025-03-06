public class Station {
    protected String name;
    protected String color;
    protected  boolean inService;
    protected Station next;
    protected Station prev;
    private int dist;
    public Station(String c, String n){
        this.name = n;
        this.color = c;
        this.inService = true;
        this.next = null;
        this.prev= null;
        dist  =0;
    }

    public void addNext(Station s){
        this.next = s;
        s.prev =this;
    }

    public void addPrev(Station s){
        this.prev = s;
        s.next = this;
    }

    

    public Station getNext(){
        return next;
    }

    public Station getPrev(){
        return prev;
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

    public int tripLength(Station dest){//fix
        if(this.equals(dest)){
            return 0;
        }
        if(this.next == null){
            return -1;
        }
        if(this.next instanceof TransferStation){
            dist += 1 + this.next.tripLength(dest);
        }
        if(this.next.equals(dest)){
            return 1;
        }
        dist += 1 + this.next.tripLength(dest);
        return dist;
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


