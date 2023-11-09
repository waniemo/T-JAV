package Item;

import Pokemon.Pokemon;

public abstract class Item {
    protected String name;
    protected String type;
    protected String description;

    public Item(String name, String Type, String description){
        this.name = name;
        this.type = Type;
        this.description = description;
    }

    public abstract void use(Pokemon pokemon);

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
