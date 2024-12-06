public class Entity {
    private int hp;
    private int attack;
    private String sprite;
    Entity(int hp, int attack,String sprite){
        this.hp=hp;
        this.attack=attack;
        this.sprite=sprite;
    }

    public int getHp() {
        return hp;
    }
    public int getAttack() {
        return attack;
    }
    public void raiseAttack(int amount){
        attack+=amount;
    }

    public String getSprite() {
        return sprite;
    }

    public void damage(int damage){
        hp-=damage;
    }
    public void heal(int health){
        hp+=health;
    }
}
