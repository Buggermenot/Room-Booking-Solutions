import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    String title;
    int width, height;
    ImageIcon img;
    Color rgb;
    MyFrame(String title, int width, int height, ImageIcon img, Color rgb) {
        this.setTitle(title);
        this.setSize(width, height);
        this.setIconImage(img.getImage());                 // Top left Image
        this.getContentPane().setBackground(rgb);
        this.doAlways();
    }

    MyFrame(int width, int height){
        this.height = height;
        this.width = width;
        this.setSize(width, height);
        this.doAlways();
    }

    MyFrame(String title, int width, int height){
        this.setTitle(title);
        this.height = height;
        this.width = width;
        this.setSize(width, height);
        this.doAlways();
    }

    void doAlways(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
}
