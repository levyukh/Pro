public class Enemy extends Entity{

    public Enemy(int hp, int attack,String sprite){
        super(hp, attack,sprite);
    }


    private String lightAttack(Player player){
        player.damage(super.getAttack()/2);
        return "The enemy attacks for "+super.getAttack()/2+" damage, using a Light Attack";
    }
    private String heavyAttack(Player player){
        player.damage(super.getAttack());
        return "The enemy attacks for "+super.getAttack()+" damage, using a Heavy Attack";
    }
    public String attack(Battle battle){
        if(Math.random()<0.7) return lightAttack(battle.getPlayer());
        else return heavyAttack(battle.getPlayer());

    }
}
