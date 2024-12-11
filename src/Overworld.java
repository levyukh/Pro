import java.io.IOException;

public class Overworld {
    private final int mapWidth=219;
    private final int mapHeight=46;
    private final int sightLeft=18;
    private final int sightRight=18;
    private final int sightUp=40;
    private final int sightDown=40;
    private char[][] map;
    private final Player player;
    private int x;
    private int y;
    private final int keyX=11;
    private final int keyY=(int)(Math.random()*4)+7;
    private final int guardX=174;
    private final int guardY=2;

    public Overworld(String map, Player player){
        this.map=new char[mapHeight][mapWidth];
        this.player=player;
        this.x=player.getX();
        this.y= player.getY();
        for(int i=mapWidth;i<=mapHeight*mapWidth;i+=mapWidth){
            this.map[(i/mapWidth)-1]=map.substring(i-mapWidth,i).toCharArray();
        }
        this.map[guardY][guardX]='g';

    }

    public char getSpace(int x, int y) {
        return map[y][x];
    }

    private boolean survivedEncounter(int percent) throws IOException, InterruptedException {
        if(Math.random()*100<percent) {
            int enemyHp = (int) (Math.random() * 10) + 2;
            int enemyAttk = (int) (Math.random() * 3) + 2;

            Enemy enemy;
            double enemyChoice=Math.random();
            if(enemyChoice<0.2) enemy=new AnnoyingFreshman(enemyHp, enemyAttk,Sprites.getEnemySprite());
            else if(enemyChoice<0.4) enemy=new TiredSenior(enemyHp, enemyAttk,Sprites.getEnemySprite());
            else enemy=new Enemy(enemyHp, enemyAttk,Sprites.getEnemySprite());

            Battle battle = new Battle(player, enemy);
            return battle.start();
        }
        return true;
    }

    private void print(){
        x=player.getX();
        y=player.getY();

      //  int[] sight={sightRight,sightLeft,sightUp,sightDown};
        String printString="";
        for (int i = y-sightLeft; i < y+sightRight; i++) {
            for (int j = x-sightUp; j < x+sightDown; j++) {
                if(j==x&&i==y) printString+='m';
                else {
                    try{
                    printString+=map[i][j];
                    }catch (java.lang.ArrayIndexOutOfBoundsException e){
                        printString+=" ";
                    }
                }

            }
            printString+="\n";
        }
        printString+="x:"+x+", y:"+y;
        System.out.print(printString);
    }
    private void guardLines() throws InterruptedException {
        System.out.print("\nThe key? Oh its at x "+keyX+" nd y "+keyY);
        Thread.sleep(2000);
    }
    private void hasKey() throws InterruptedException {
        System.out.println("You got the key!!!");
        Thread.sleep(2000);
        map[8][169]='M';
        map[9][184]=' ';
        map[10][184]=' ';
    }
    public void run() throws IOException, InterruptedException {

        char input=' ';
        while(input!='x') {
            print();
            input = Input.keyInput();
            player.move(this, input);
            if(x==guardX&&y==guardY&&input==' ') guardLines();
            if(x==keyX&&y==keyY&&input==' ') hasKey();
            if (!survivedEncounter(2)) player.die();
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
    }
}
