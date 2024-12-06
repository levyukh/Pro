public class Enemy extends Entity{

    public Enemy(int hp, int attack,String sprite){
        super(hp, attack,sprite);
    }


    protected String lightAttack(Player player){
        player.damage(super.getAttack()/2);
        return "the enemy attacks for "+super.getAttack()/2+"damage";
    }
    protected String heavyAttack(Player player){
        player.damage(super.getAttack());
        return "the enemy attacks for "+super.getAttack()+"damage";
    }
    public String attack(Battle battle){
        if(Math.random()<0.7) return lightAttack(battle.getPlayer());
        else return heavyAttack(battle.getPlayer());

    }
}
