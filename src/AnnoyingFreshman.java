public class AnnoyingFreshman extends Enemy{
    public AnnoyingFreshman(int hp, int attack, String sprite) {
        super(hp, attack, sprite);
    }

    private String lightAttack(Player player){
        String wasStunned="";
        if(Math.random()<.5) {
            player.stun();
            wasStunned=", and stuns you!";
        }
        player.damage(super.getAttack());
        super.heal(1);
        return "The annoying freshman attacks for "+super.getAttack()+"damage, heals for 1  using a Light Attack"+wasStunned;

    }
    private String heavyAttack(Player player){
        String wasStunned="";
        if(Math.random()<.5) {
            player.stun();
            wasStunned=", and stuns you!";
        }
        player.damage((int)(super.getAttack()*1.5));
        super.heal(2);
        return "The annoying freshman attacks for "+(int)(super.getAttack()*1.5)+"damage, heals for 2 using a Heavy Attack"+wasStunned;

    }
    private String screech(Player player){
        player.stun();
        super.heal(5);
        return "The Freshman screeched at you healing 5 health and stunning you";
    }
    @Override public String attack(Battle battle){
        double choice=Math.random();
        if(choice<0.2) return screech(battle.getPlayer());
        else if(choice<0.5)return heavyAttack(battle.getPlayer());
        else return lightAttack(battle.getPlayer());

    }
}
