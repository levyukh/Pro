public class ShadowMrMiller extends Enemy{
    public ShadowMrMiller() {
        super(25, 5, Sprites.getShadowMillerSprite());
    }
    private String basicAttack(Player enemy){
        enemy.damage(super.getAttack());
        return "Shadow Mr.Miller uses a basic attack dealing "+super.getAttack()+" damage!    ";//make sure attacks that are returned are exactly 50 spaces long
    }
    private String heavyAttack(Player enemy){
            enemy.damage(super.getAttack() * 2);
            return "Shadow Mr.Miller uses a heavy attack dealing "+(super.getAttack() * 2)+" damage!";
    }
    private String healAction(){
        int heal=(int)(Math.random()*3)+5;
        super.heal(heal);
        return "Shadow Mr.Miller heals for "+heal+" hp";
    }
    private String katanaBitingEpic(Player enemy){
        int damage=(int)(Math.random()*100)+1;
        enemy.damage(damage);
        return "SHADOW MR.MILLER USES KATANA BITING EPIC!!!"+"you do "+damage+"damage";
    }
    @Override public String attack(Battle battle){
        double choice=Math.random();
        if(choice<.1){
            return katanaBitingEpic(battle.getPlayer());
        }else if(battle.getPlayer().getHp()<(super.getAttack() * 2)){
            return heavyAttack(battle.getPlayer());
        }else if(super.getHp()<=2){
            return healAction();
        }else if(choice>0.5){
            return basicAttack(battle.getPlayer());
        }else if(choice<0.2){
            return healAction();
        }else{
            return heavyAttack(battle.getPlayer());
        }


    }
}
