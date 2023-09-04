public class Meuble extends Case{

    String name;

    public Meuble(boolean tr,String name){
        super(tr);
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    
}