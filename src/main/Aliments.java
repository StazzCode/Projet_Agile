package main;

public enum Aliments { 
//🔥 🍖 🍅  🍕  🦑 🍽️ 🥩 🥚 🍍
    CHORIZZO("Chorizo", 4, "viande"),
    MOZZARELLA("mozzarella", 2, "fromage"),
    PIMENTS_JALAPENOS("piments jalapenos", 1, "sauce"),
    BOEAUF("boeauf", 5, "viande"),
    BACON("bacon", 3, "viande"),
    POULET("poulet", 4, "viande"),
    OIGNONS("oignons", 3, "legume"),
    BASILIC("basilic",1,"plant"),
    SAUCE_SECRETE("sauce secrete",10,"sauce");
    
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

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
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
