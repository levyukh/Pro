import java.io.IOException;
import java.util.Scanner;

public class Battle {
    Scanner input=new Scanner(System.in);
    private final Player player;
    private Enemy enemy;
    public Battle(Player player, Enemy enemy){
        this.player=player;
        this.enemy=enemy;
    }
    private void printScene(){
        System.out.println(
                "                              \n"+
                        enemy.getSprite()+

                        player.getSprite()       +

                        "                              "

        );
    }
    private void printMenu(String action){
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("|         "+action+"         |");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("player hp:"+player.getHp()+"enemy hp:"+enemy.getHp());
    }
    private int getAttack(){
        System.out.print("Enter your attack number:");
        return input.nextInt();
    }
    public boolean start() throws InterruptedException, IOException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        String action="                  ";
        while(enemy.getHp()>0&&player.getHp()>0) {
            printScene();
            printMenu(action);
            int attackChoice = getAttack();
            action = player.attack(this, attackChoice);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            printScene();
            printMenu(action);
            Thread.sleep(2000);
            if(enemy.getHp()<1) break;
            action = enemy.attack(this);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        boolean won=false;
        if(player.getHp()>0) won=true;
        return won;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public Player getPlayer() {
        return player;
    }
}
