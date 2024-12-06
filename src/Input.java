public class Input {
    static{
        System.loadLibrary("keyboardInput");
    }
    public static native char keyInput();
}
