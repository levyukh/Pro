public class TiredSenior extends Enemy{
    public TiredSenior(int hp, int attack, String sprite) {
        super(hp, attack, sprite);
    }
    private String lightAttack(Player player){
        player.damage((int)(super.getAttack()*1.5));
        return "The tired senior attacks for "+(int)(super.getAttack()*1.5)+"damage, using a Light Attack";
    }
    private String heavyAttack(Player player){
        player.damage(super.getAttack()*3);
        return "The tired senior attacks for "+super.getAttack()*3+"damage, using a Heavy Attack";
    }
    private String rest(){
        super.heal((int)(Math.random()*super.getHp())+1);
        return "The tired senior sleeps healing "+((int)(Math.random()*super.getHp())+1);
    }

    @Override public String attack(Battle battle){
        double choice=Math.random();
        if(choice<0.2) return heavyAttack(battle.getPlayer());
        else if(choice<0.5)return lightAttack(battle.getPlayer());
        else return rest();
    }
}
