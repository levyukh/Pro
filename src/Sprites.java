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
                                                                        | - |   @\s
                                                                      @ \\___|  @ \s
                                                                      ___| |___  \s
                                                                      ▐░░░░░▐░▐  @
                                                                      ▐░░░░░▐░▐  \s
                                                                      ▐░░░░░▐░▐  \s
                                                                      ▐░░░░░▐░▐ @\s
                                                                      ▐░░░░░▐░▐  \s
                                                                      ▐░░░░░▐░▐  \s
    """;

    private static final String annoyingFreshmanSprite = """
                                                                                 ████  @ \s
                                                                                ██████   \s
                                                                              @ (# #██   \s
                                                                                | - |   @\s
                                                                              @  ---   @ \s
                                                                               __| |__   \s
                                                                              ▐░░░░░▐░▐  @
                                                                              ▐░░░░░▐░▐  \s
                                                                              ▐░░░░░▐░▐  \s
                                                                              ▐░░░░░▐░▐ @\s
            """;
    private static final String tiredSeniorSprite = """
                                                                                 ▓██▒  @ \s
                                                                                ▓████▓   \s
                                                                              @ (- -▓▓   \s
                                                                                | _ |   @\s
                                                                              @ \\___|  @ \s
                                                                              ___| |___  \s
                                                                              ▐░░░░░▐░▐  \s
                                                                              ▐░░░░░▐░▐  \s
                                                                              ▐░░░░░▐░▐  \s
                                                                              ▐░░░░░▐░▐ @
                                                                              ▐░░░░░▐░▐  \s
                                                                              ▐░░░░░▐░▐  \s
                                                                              ▐░░░░░▐░▐  \s
            """;

    private static final String shadowMillerSprite = """
                                                                  ,#####,                \s
                                                                  #_   _#                \s
                                                                  |a` `a|                \s
                                                                  |  u  |                \s
                                                                  \\  =  /                \s
                                                                  |\\___/|                \s
                                                         ___ ____/:     :\\____ ___       \s
                                                       .'   `.-===-\\   /-===-.`   '.     \s
                                                      /      .-""\"""-.-""\"""-.      \\    \s
                                                     /'             =:=             '\\   \s
                                                   .'  ' .:    o   -=:=-   o    :. '  `. \s
                                                   (.'   /'. '-.....-'-.....-' .'\\   '.) \s
                                                   /' ._/   ".     --:--     ."   \\_. '\\ \s
                                                  |  .'|      ".  ---:---  ."      |'.  |\s
                                                  |  : |       |  ---:---  |       | :  |\s
                                                   \\ : |       |_____._____|       | : / \s
                                                   /   (       |----|------|       )   \\ \s
                                                  /... .|      |    |      |      |. ...\\\s
                                                 |::::/''     /     |       \\     ''\\::::|
                                                 '\"\"\"\"       /'    .L_      `\\       \"\"\"\"'
                                                            /'-.,__/` `\\__..-'\\         \s
                                                           ;      /     \\      ;         \s
                                                           :     /       \\     |         \s
                                                           |    /         \\.   |         \s
                                                           |`../           |  ,/         \s
                                                           ( _ )           |  _)         \s
                                                           |   |           |   |         \s
                                                           |___|           \\___|         \s
                                                           :===|            |==|         \s
                                                            \\  /            |__|         \s
                                                            /\\/\\           /""\"`8.__     \s
                                                            |oo|           \\__.//___)    \s
                                                            |==|                         \s
                                                            \\__/                         \s
            """;

    public static String getPlayerSprite() {
        return playerSprite;
    }

    public static String getEnemySprite() {
        return enemySprite;
    }

    public static String getAnnoyingFreshmanSprite() {return annoyingFreshmanSprite;}

    public static String getTiredSeniorSprite() {return tiredSeniorSprite;}

    public static String getShadowMillerSprite() {return shadowMillerSprite;}
}
