package models;

public class ShoppingList {
    public String id;
    public String name;
    public boolean primary;

    public ShoppingList(String name, boolean primary){
        this.name = name;
        this.primary=primary;
    }
    public ShoppingList(String name, boolean primary, String id){
        this.name = name;
        this.primary=primary;
        this.id=id;
    }
}
