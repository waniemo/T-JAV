public abstract class Pokemon {
    protected String name;
    protected int pv;
    protected int atk;
    protected int def;
    protected int speed;
    protected int level = 1;
    protected Class<? extends Type> type;
    protected String spritePng;
    protected String spriteFront;
    protected String spriteBack;

    public Pokemon(String name, Class<? extends Type> type, int level){
        this.name = name;
        this.level = level;
        this.type = type;
    }

    public String getName(){
        return name;
    }

    public int getPv(){
        return pv;
    }

    public int getAtk(){
        return atk;
    }

    public int getDef(){
        return def;
    }

    public int getSpeed(){
        return speed;
    }

    public int getLevel(){
        return level;
    }

    public Class<? extends Type> getType(){
        return type;
    }

    public String getSpriteFront(){
        return spriteFront;
    }

    public String getSpriteBack() {
        return spriteBack;
    }

    public String getSpritePng() {
        return spritePng;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPv(int pv){
        this.pv = pv;
    }

    public void setAtk(int atk){
        this.atk = atk;
    }

    public void setDef(int def){
        this.def = def;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setType(Class<? extends Type> type) {
        this.type = type;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public abstract void attack();
}
