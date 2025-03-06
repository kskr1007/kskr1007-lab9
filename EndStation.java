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
        String prevStation = " ";
        String nextStation = " ";
        if(this.prev == null ){
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
        return "ENDSTATION " + name + ": " + color + " line, " + "in service: " + inService + ", " + "previous station: " + prevStation + ", " + "next station: " + nextStation;
    }
    
    
}
