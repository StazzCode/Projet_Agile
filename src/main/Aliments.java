package main;

public enum Aliments { 

    CHORIZZO("Chorizo", 4, "meet"),
    MOZZARELLA("mozzarella", 2, "cheese"),
    PIMENTS_JALAPENOS("piments jalapenos", 1, "sauce"),
    BOEAUF("boeauf", 5, "meet");
    
    private String name;
    private int price;
    private String type; 

    private Aliments(String name, int price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return name;
    }

    public String getType() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setType(String type){
        this.type = type;
    }
}
