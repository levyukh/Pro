import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Player extends Entity{
    private int x;
    private int y;
    private int healPower=1;
    private ArrayList<String> options= new ArrayList<>(Arrays.asList("1 More Attack", "10 More Health", "Stronger Healing", "Unlock Katana biting Epic"));
    private boolean stun=false;
    private ArrayList<String>attackList= new ArrayList<>();
    private boolean canUseHeavy=true;
    public Player(int hp,int  attack,String sprite,int x, int y){
        super(hp, attack,sprite);
        this.x=x;
        this.y=y;
        attackList.add("Basic Attack");
        attackList.add("Heavy Attack");
        attackList.add("Heal");
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public ArrayList<String>getAttackList(){
        return attackList;
    }
    public void stun(){
        stun=true;
    }
    private void setPosition(int x, int y){
        this.x=x;
        this.y=y;
    }
    private void unlockBitingEpic(){
        options.remove(3);
        attackList.add("Katana Biting Epic");
    }
    public void die() throws IOException, InterruptedException {
        setPosition(94,43);

        super.setHp(3);
        int choice=1;
        char input='x';
        while (input!=' ') {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println("--you died pick a buff--");
            for (int i = 0; i < options.size(); i++) {
                if (i == choice) System.out.println(i+1+": [" + options.get(i) + "]");
                else System.out.println(i+1+": "+options.get(i));
            }
            input = Input.keyInput();
            if (input == 'w' && choice > 0) choice--;
            else if (input == 's' && choice < options.size() - 1) choice++;
        }

       switch (choice){
           case 0: super.raiseAttack(1);
           break;
           case 1: super.heal(10);
           break;
           case 2: healPower++;
           break;
           case 3: unlockBitingEpic();
       }
    }
    private String basicAttack(Enemy enemy){
        enemy.damage(super.getAttack());
        canUseHeavy=true;
        return "You use a basic attack dealing "+super.getAttack()+" damage!    ";//make sure attacks that are returned are exactly 50 spaces long
    }
    private String heavyAttack(Enemy enemy){
        if(canUseHeavy) {
            enemy.damage(super.getAttack() * 2);
            canUseHeavy=false;
            return "You use a heavy attack dealing "+(super.getAttack() * 2)+" damage!";
        }
        return "You fail the heavy attack";
    }
    private String healAction(){
        int heal=(int)(Math.random()*3)+healPower;
        canUseHeavy=true;
        super.heal(heal);
        return "you healed for "+heal+" hp";
    }
    private String katanaBitingEpic(Enemy enemy){
        int damage=(int)(Math.random()*100)+1;
        canUseHeavy=true;
        enemy.damage(damage);
        return "YOU USE KATANA BITING EPIC!!!"+"you do "+damage+"damage";
    }
    public String attack(Battle battle,int decision){
        if(!stun) {
            return switch (decision) {
                case 1 -> basicAttack(battle.getEnemy());
                case 2 -> heavyAttack(battle.getEnemy());
                case 3 -> healAction();
                case 4 -> katanaBitingEpic(battle.getEnemy());

                default -> "You don't attack";
            };
        }else{
            stun=false;
            return "You are Stunned!!!";
        }
    }

    public void move(Overworld map,char input){
        String bannedList="#|-][()";
        if(input=='w'&&!bannedList.contains(map.getSpace(x,y-1)+"")) y--;
        else if(input=='s'&&!bannedList.contains(map.getSpace(x,y+1)+"")) y++;
        if(input=='d'&&!bannedList.contains(map.getSpace(x+1,y)+"")) x++;
        else if(input=='a'&&!bannedList.contains(map.getSpace(x-1,y)+"")) x--;
    }
}
