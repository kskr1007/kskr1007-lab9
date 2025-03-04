public class Station {
    protected String name;
    protected String color;
    protected  boolean inService;
    protected Station next;
    protected Station prev;
    private int dist = 0;
    public Station(String n, String c){
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
        if(this.next != null){
            dist += 1 + this.next.tripLength(dest);
            return dist;
        }
        return -1;
    }


    public String toString(){
    if(prev != null && next!= null){
    return "STATION " + name + ": " + color + " line," + " in service: " + inService + ", " + " previous station: " + prev + ", next station: " + next;
    }
    else if(prev == null){
        return "STATION " + name + ": " + color + " line," + " in service: " + inService + ", " + " previous station: " + "none" + ", next station: " + next;
    }
    else if (next == null){
        return "STATION " + name + ": " + color + " line," + " in service: " + inService + ", " + " previous station: " + prev + ", next station: " + "none";
    }
    return "STATION " + name + ": " + color + " line," + " in service: " + inService + ", " + " previous station: " + "none" + ", next station: " + "none";
}

}


