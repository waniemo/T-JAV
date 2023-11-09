package Pokemon;
import Type.*;

public abstract class Pokemon {
    protected String name;
    protected int basePv;
    protected int pv;
    protected int pvMax;
    protected int baseAtk;
    protected int atk;
    protected int baseDef;
    protected int def;
    protected int baseSpeed;
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
        this.pvMax = pv;
        this.basePv = pv;
        this.baseAtk = atk;
        this.baseDef = def;
        this.baseSpeed = speed;
    }

    public String getName(){
        return name;
    }

    public int getPv(){
        return pv;
    }

    public int getPvMax() {
        return pvMax;
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
        } else if(level != 1) {
            this.level = level;
            setPv(this.pvMax + 2 * this.level);
            setAtk(this.baseAtk + 2 * this.level);
            setDef(this.baseDef + 2 * this.level);
            setSpeed(this.baseSpeed + 2 * this.level);
            pvMax = pv;
        } else if(level == 1){
            this.level = level;
            setPv(this.basePv);
            setAtk(this.baseAtk);
            setDef(this.baseDef);
            setSpeed(this.baseSpeed);
            pvMax = pv;
        }
    }



    public abstract void attack(String attack, Pokemon ennemi);
}
