package Pokemon;
import Type.*;

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

    public Pokemon(String name, Class<? extends Type> type, int level, int pv, int atk, int def, int speed, String spritePng, String spriteFront, String spriteBack){
        this.name = name;
        this.level = level;
        this.type = type;
        this.pv = pv;
        this.atk = atk;
        this.def = def;
        this.speed = speed;
        this.spritePng = spritePng;
        this.spriteFront = spriteFront;
        this.spriteBack = spriteBack;
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
        if(level > 100) {
            level = 100;
        }
        this.level = level;
        setPv(this.getPv() + 2 * level);
        setAtk(this.getAtk() + 2 * level);
        setDef(this.getDef() + 2 * level);
        setSpeed(this.getSpeed() + 2 * level);
    }

    public abstract void attack();
}
