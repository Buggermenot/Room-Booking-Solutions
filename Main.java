import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static MyFrame frame = new MyFrame("Room Booking", 1000, 1080);
    static JPanel background = new JPanel();
    public static Room r1 = new Room(101, Room.A);
    public static Student s1 = new Student("Tester", "1234");

    public static void main(String[] args) {
        JLabel title = new JLabel("Room Booking Simulator 2022");
        title.setFont(new Font("Calibri", Font.BOLD, 20));
        title.setForeground(new Color(51, 40, 29));
        title.setBounds(10, 10, 1000, 30);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.TOP);

        StartPage.setup();
//        Table.setup();


        frame.add(title);
        background.setBackground(new Color(149, 148, 165, 255));
        frame.setLayout(null);
        frame.add(background);
        frame.repaint();
    }
}