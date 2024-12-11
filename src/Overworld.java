import java.io.IOException;

public class Overworld {
    private boolean won=false;
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
    private final int guardX=212;
    private final int guardY=41;

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
            if(enemyChoice<0.2) enemy=new AnnoyingFreshman(enemyHp, enemyAttk,Sprites.getAnnoyingFreshmanSprite());
            else if(enemyChoice<0.4) enemy=new TiredSenior(enemyHp, enemyAttk,Sprites.getTiredSeniorSprite());
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
        System.out.print("\nThe key? Oh its at x "+keyX+" and y "+keyY);
        Thread.sleep(2000);
    }
    private void hasKey() throws InterruptedException {
        System.out.println(" You got the key!!!");
        Thread.sleep(2000);
        map[7][169]='M';
        map[9][183]=' ';
        map[10][183]=' ';
    }
    private String winScreen(){
        System.out.println("YOUUUUUUUUU WONNNNNNNNN!!!!!!!");
        return Sprites.getWinScreen();
    }
    public void run() throws IOException, InterruptedException {

        char input=' ';
        while(input!='x'&&!won) {
            print();
            input = Input.keyInput();
            player.move(this, input);
            if(x==guardX&&y==guardY&&input==' ') guardLines();
            if(x==keyX&&y==keyY&&input==' ') hasKey();
            if(map[player.getY()][player.getX()]=='M'){
                Battle battle = new Battle(player, new ShadowMrMiller());
                if(battle.start()) won=true;
                else player.die();
            }
            if (!survivedEncounter(2)) player.die();
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        if(won) System.out.println(winScreen());
    }
}
