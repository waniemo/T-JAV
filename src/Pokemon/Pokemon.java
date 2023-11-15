package Pokemon;
import Type.*;
import Attaques.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

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

    protected List<Attaque> attaques;

    protected Class<? extends Type> type;
    protected String spritePng;
    protected String spriteFront;
    protected String spriteBack;

    public Pokemon(String name, Class<? extends Type> type, int level, int pv, int atk, int def, int speed, String spritePng, String spriteFront, String spriteBack, List<Attaque> attaques){
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
        this.attaques = attaques;
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

    public String getKoPng() {
        return spritePng.split("\\.")[0]+"_ko.png";
    }

    public List<Attaque> getAttaques() {
        return attaques;
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

    public String attaqueNormale(Pokemon ennemi){
        if(attaques.get(0).getPp() <= 0){
            return "Vous n'avez pas assez de PP pour utiliser cette attaque !";
        } else{
            ennemi.setPv((int) (ennemi.getPv() - (((2.0 * this.getLevel() / 5.0 + 2.0) * (this.getAtk() / this.getDef()) / 50.0 + 5))));
            attaques.get(0).setPp(attaques.get(0).getPp() - 1);
            return this.name+" utilise "+attaques.get(0).getName()+" !";
        }
    }
    public String attaqueType1(Pokemon ennemi) throws NoSuchMethodException {
        if(attaques.get(1).getPp()<= 0){
            return "Vous n'avez pas assez de PP pour utiliser cette attaque !";
        } else {
            try {
                if(ennemi.getType() == this.type.getDeclaredConstructor().newInstance().getStrength()){
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * this.getLevel() / 5.0 + 2.0) * (this.getAtk() / this.getDef()) / 50.0 + 5.5))));
                    attaques.get(1).setPp(attaques.get(1).getPp() - 1);
                    return this.name+" utilise" +attaques.get(1).getName()+"!\n Cette attaque était très efficace !";
                } else if(ennemi.getType() == this.type.getConstructor().newInstance().getWeakness()){
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * this.getLevel() / 5.0 + 2.0) * (this.getAtk() / this.getDef()) / 50.0 + 1.5))));
                    attaques.get(1).setPp(attaques.get(1).getPp() - 1);
                    return this.name+" utilise" +attaques.get(1).getName()+"!\n Cette n'était pas très efficace...";
                }
                else{
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * this.getLevel() / 5.0 + 2.0) * (this.getAtk() / this.getDef()) / 50.0 + 3))));
                    attaques.get(1).setPp(attaques.get(1).getPp() - 1);
                    return this.name+" utilise "+attaques.get(1).getName()+" !";
                }
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    };
    public String attaqueType2(Pokemon ennemi) throws NoSuchMethodException {
        if(attaques.get(2).getPp()<= 0){
            return "Vous n'avez pas assez de PP pour utiliser cette attaque !";
        } else {
            try {
                if(ennemi.getType() == this.type.getDeclaredConstructor().newInstance().getStrength()){
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * this.getLevel() / 5.0 + 2.0) * (this.getAtk() / this.getDef()) / 50.0 + 10))));
                    attaques.get(2).setPp(attaques.get(2).getPp() - 1);
                    return this.name+" utilise" +attaques.get(1).getName()+"!\n Cette attaque était très efficace !";
                } else if(ennemi.getType() == this.type.getConstructor().newInstance().getWeakness()){
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * this.getLevel() / 5.0 + 2.0) * (this.getAtk() / this.getDef()) / 50.0 + 3))));
                    attaques.get(2).setPp(attaques.get(2).getPp() - 1);
                    return this.name+" utilise" +attaques.get(1).getName()+"!\n Cette n'était pas très efficace...";
                }
                else{
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * this.getLevel() / 5.0 + 2.0) * (this.getAtk() / this.getDef()) / 50.0 + 6))));
                    attaques.get(2).setPp(attaques.get(2).getPp() - 1);
                    return this.name+" utilise "+attaques.get(1).getName()+" !";
                }
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    };
    public String attaqueType3(Pokemon ennemi) throws NoSuchMethodException {
        if(attaques.get(3).getPp()<= 0){
            return "Vous n'avez pas assez de PP pour utiliser cette attaque !";
        } else {
            try {
                if(ennemi.getType() == this.type.getDeclaredConstructor().newInstance().getStrength()){
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * this.getLevel() / 5.0 + 2.0) * (this.getAtk() / this.getDef()) / 50.0 + 20.5))));
                    attaques.get(3).setPp(attaques.get(3).getPp() - 1);
                    return this.name+" utilise" +attaques.get(1).getName()+"!\n Cette attaque était très efficace !";
                } else if(ennemi.getType() == this.type.getConstructor().newInstance().getWeakness()){
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * this.getLevel() / 5.0 + 2.0) * (this.getAtk() / this.getDef()) / 50.0 + 6))));
                    attaques.get(3).setPp(attaques.get(3).getPp() - 1);
                    return this.name+" utilise" +attaques.get(1).getName()+"!\n Cette n'était pas très efficace...";
                }
                else{
                    ennemi.setPv((int) (ennemi.getPv() - (((2.0 * this.getLevel() / 5.0 + 2.0) * (this.getAtk() / this.getDef()) / 50.0 + 8))));
                    attaques.get(3).setPp(attaques.get(3).getPp() - 1);
                    return this.name+" utilise "+attaques.get(1).getName()+" !";
                }
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
