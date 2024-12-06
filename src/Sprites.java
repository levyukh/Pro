public class Sprites {//used https://kirilllive.github.io/ASCII_Art_Paint/ascii_paint.html
    private static final String  playerSprite="""
            ██  \s
          ███\\  \s
         ████@] \s
         ████ ) \s
         ████-| \s
         ████_/ \s
        ██  \\   \s
     ____|  |___\s
    /▒▒▒▒▒▒▒▒▒▒▒\\
    |▒▒▒▒▒▒▒▒|▒▒|
    |▒▒▒▒▒▒▒▒|▒▒|
    |▒▒▒▒▒▒▒▒|▒▒|
    |▒▒▒▒▒▒▒▒|▒▒|
    """;

    private static final String  enemySprite="""
                                                                         ████  @ \s
                                                                        ██████   \s
                                                                      @ (# #██   \s
                                                                        | + |   @\s
                                                                      @ \\___|  @ \s
                                                                      ___| |___  \s
                                                                      ▐░░░░░▐░▐  @
                                                                      ▐░░░░░▐░▐  \s
                                                                      ▐░░░░░▐░▐  \s
                                                                      ▐░░░░░▐░▐ @\s
                                                                      ▐░░░░░▐░▐  \s
                                                                      ▐░░░░░▐░▐  \s
                                                                      ▐░░░░░▐░▐  \s
    """;

    public static String getPlayerSprite() {
        return playerSprite;
    }

    public static String getEnemySprite() {
        return enemySprite;
    }
}
