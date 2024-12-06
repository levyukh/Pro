import java.io.IOException;

public class Overworld {
    private final int mapWidth=10;
    private final int mapHeight=5;
    private char[][] map;
    private final Player player;
    private int x;
    private int y;

    public Overworld(String map, Player player){
        this.map=new char[mapHeight][mapWidth];
        this.player=player;
        this.x=player.getX();
        this.y= player.getY();
        for(int i=mapWidth;i<=mapHeight*mapWidth;i+=mapWidth){
            this.map[(i/mapWidth)-1]=map.substring(i-mapWidth,i).toCharArray();
        }

    }

    public char getSpace(int x, int y) {
        return map[y][x];
    }

    private boolean Encounter(int percent){
        return Math.random()*100<percent;
    }

    private void print(){
        x= player.getX();
        y=player.getY();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                if(j==x&&i==y) System.out.print('m');
                else System.out.print(map[i][j]);

            }
            System.out.println();
        }
    }

    public void run() throws IOException, InterruptedException {

        char input=' ';
        while(input!='x') {
            print();
            input = Input.keyInput();
            player.move(this, input);
            if (Encounter(20)) {
                int enemyHp = (int) (Math.random()*10) +1;
                int enemyAttk = (int) (Math.random() *3) +1;
                Battle battle = new Battle(player, new Enemy(enemyHp, enemyAttk, Sprites.getEnemySprite()));
                boolean survived=battle.start();
                if(!survived)player.die();

            }
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
    }
}
