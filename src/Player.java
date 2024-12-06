import java.io.IOException;
import java.util.Scanner;


public class Player extends Entity{
    private int x;
    private int y;
    private boolean canUseHeavy=true;
    public Player(int hp,int  attack,String sprite,int x, int y){
        super(hp, attack,sprite);
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    private void setPosition(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void die() throws IOException, InterruptedException {
        setPosition(1,1);
        super.heal(3);
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("--you died pick a buff--");
        System.out.println("1: 1 more attack");
        System.out.println("2: 5 more health");
        int choice=new Scanner(System.in).nextInt();
        if(choice==1) super.raiseAttack(1);
        else super.heal(5);
    }
    private String basicAttack(Enemy enemy){
        enemy.damage(super.getAttack());
        canUseHeavy=true;
        return "    You use a basic attack dealing "+super.getAttack()+" damage!    ";//make sure attacks that are returned are exactly 50 spaces long
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
        super.heal(1);
        return "you healed for 1 hp";
    }
    public String attack(Battle battle,int decision){
        return switch (decision) {
            case 1 -> basicAttack(battle.getEnemy());
            case 2 -> heavyAttack(battle.getEnemy());
            case 3 -> healAction();
            default -> "You don't attack";
        };
    }

    public void move(Overworld map,char input){
        if(input=='w'&&map.getSpace(x,y-1)!='#') y--;
        else if(input=='s'&&map.getSpace(x,y+1)!='#') y++;
        if(input=='d'&&map.getSpace(x+1,y)!='#') x++;
        else if(input=='a'&&map.getSpace(x-1,y)!='#') x--;
    }
}
