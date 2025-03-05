public class EndStation extends Station {
    public EndStation(String n, String c) {
        super(n, c);
    }

    public void makeEnd(){
        if(this.prev!=null){
        this.next = this.prev;
        }

        else if(this.next!=null){
            this.prev= this.next;
        }
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
        return "ENDSTATION " + name + ": " + color + " line, " + "in service: " + inService + ", " + "previous station: " + prevStation + ", " + "next station: " + nextStation;
    }
    
    
}
