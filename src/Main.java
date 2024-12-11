import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String room = Data.getRoomData();
        //Data.titleScreen();
        Player player = new Player(5, 4,Sprites.getPlayerSprite(), 94, 43);
        Overworld t = new Overworld(room, player);
        t.run();

    }
}