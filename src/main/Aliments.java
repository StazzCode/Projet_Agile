package main;

public enum Aliments { 
//🔥 🍖 🍅  🍕  🦑 🍽️ 🥩 🥚 🍍
    CHORIZZO("Chorizo", 4, "viande"),
    MOZZARELLA("Mozzarella", 2, "fromage"),
    PIMENTS_JALAPENOS("Piments jalapenos", 1, "sauce"),
    BOEAUF("Boeuf", 5, "viande"),
    BACON("Bacon", 3, "viande"),
    POULET("Poulet", 4, "viande"),
    OIGNONS("Oignons", 3, "legume"),
    BASILIC("Basilic",1,"plant"),
    SAUCE_SECRETE("Sauce secrete",10,"sauce");
    
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
