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

    public String getName(){
        return this.name;
    }

    public String getColor(){
        return this.color;
    }

    public Station getNext(){
        return next;
    }

    public void setNext(Station s){
        this.next = s;
    }

    public Station getPrev(){
        return prev;
    }

    public void setPrev(Station s){
        this.prev = s;
    }

    public boolean isAvailable(){
        return this.inService;
    }
    public void switchAvailable(){
        this.inService = !this.inService;
    }
    public boolean equals(Station s){
        if(this.name.equals(s.getName())&& this.color.equals(s.getColor())){
            return true;
        }
        return false;
    }

    public void connect(Station s){
        this.next = s;
        s.prev = this;
    }

    public int tripLength(Station dest){
        if(this.equals(dest)){
            return 0;
        }
        if(this.next.equals(dest)){
            return 1;
        }
        dist += 1 + this.next.tripLength(dest);
        return dist;
    }


    public String toString() {
        String prevStation = "none";
        String nextStation = "none";
        
        if (prev != null) {
            prevStation = prev.name;
        }
        
        if (next != null) {
            nextStation = next.name;
        }
        return "STATION " + name + ": " + color + " line, " + "in service: " + inService + ", " + "previous station: " + prevStation + ", " + "next station: " + nextStation;
    }
    

}


