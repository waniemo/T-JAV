package Item;

import Pokemon.Pokemon;

public abstract class Item {
    protected String name;
    protected String type;
    protected String description;
    protected String sprite;

    public Item(String name, String Type, String description, String sprite) {
        this.name = name;
        this.type = Type;
        this.description = description;
        this.sprite = sprite;
    }

    public abstract String use(Pokemon pokemon);

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getSprite() {
        return "Item/" + sprite;
    }
}
