import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input {
    private static char keyChosen = '\0';
    static {
        var frame = new JFrame("Keyboard Input");
        frame.setSize(320, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                var key = e.getKeyChar();
                /*switch (key) {
                    case KeyEvent.VK_W:
                        keyChosen = 'w';
                        break;
                    case KeyEvent.VK_A:
                        keyChosen = 'a';
                        break;
                    case KeyEvent.VK_D:
                        keyChosen = 'd';
                        break;
                    case KeyEvent.VK_S:
                        keyChosen = 's';
                        break;
                    case KeyEvent.VK_SPACE:
                        keyChosen = ' ';
                        break;
                }*/
                keyChosen = key;
            }

            @Override
            public void keyPressed(KeyEvent e) { }

            @Override
            public void keyReleased(KeyEvent e) { }
        });
        frame.setVisible(true);
    }
    public static char keyInput() {
        while (keyChosen == '\0') {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        char temp = keyChosen;
        keyChosen = '\0';
        return temp;
    }
}
