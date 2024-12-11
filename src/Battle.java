import java.io.IOException;
import java.util.Scanner;

public class Battle {
    Scanner input=new Scanner(System.in);
    private final Player player;
    private Enemy enemy;
    private int option=0;
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
        while(action.length()<54){
            action=" "+action+" ";
        }
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("|"+action+"|");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Player Hp:"+player.getHp()+" Enemy Hp:"+enemy.getHp());
    }
    private int getAttack(char input){
        String[] attacks= player.getAttackList().toArray(new String[player.getAttackList().size()]);

        if(option>0&&input=='w') option--;
        else if(option<attacks.length-1&&input=='s') option++;
        for (int i = 0; i < attacks.length; i++) {
            if(i==option) System.out.println("["+attacks[i]+"]");
            else System.out.println(attacks[i]);
        }
        return option;
    }
    private int playerAttack(String action) throws IOException, InterruptedException {
        char input='x';
        int attackChoice=0;
        while(input!=' ') {
            printScene();
            printMenu(action);
            attackChoice = getAttack(input);
            input = Input.keyInput();
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        }
        return attackChoice;
    }

    public boolean start() throws InterruptedException, IOException {
        int attackChoice=0;
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        String action="                  ";
        while(enemy.getHp()>0&&player.getHp()>0) {


            attackChoice=playerAttack(action);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            action = player.attack(this, attackChoice+1);
            printScene();
            printMenu(action);
            if(enemy.getHp()>0)  action = enemy.attack(this);
            Input.keyInput();
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
