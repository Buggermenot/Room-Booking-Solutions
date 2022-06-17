import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.jar.Manifest;
import java.util.stream.IntStream;

public class StartPage {
    static JLabel info;
    static JToggleButton studentButton;
    static JToggleButton managementButton;
    static JTextArea bookingInfo;
    static JScrollPane sp;

    static ActionListener toggle = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == studentButton){
                managementButton.setSelected(false);
                try{removeManagement();}
                catch (Exception ignored){}
                studentSetup();
            }
            else if(e.getSource() == managementButton){
                studentButton.setSelected(false);
                try{removeStudent();}
                catch (Exception ignored){}
                managementSetup();
            }
        }
    };

    static ActionListener showBookings = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder s = new StringBuilder();
//            s.append("<html>");
            try {
                for(Bookings b : Main.r1.bookings){
                    s.append(b).append('\n');
                    s.append("====================================\n");
                }
            }
            catch (Exception e1){s.append("No Bookings Yet.");}

            bookingInfo.setText(String.valueOf(s));
        }
    };

    static int[] num= IntStream.rangeClosed(1, 12).toArray();
    static String[] num_arr = Arrays.stream(num).mapToObj(String::valueOf).toArray(String[]::new);

    static JLabel roll, people, room;
    static JComboBox<String> n_people, room_types;
    static JTextField roll_field;
    static JButton searchP, searchR;
    static JTextField room_no;

    static void studentSetup(){
        roll = new JLabel("Enrollment Number:");
        roll.setBounds(200, 350, 200, 20);
        roll.setFont(new Font("Calibri", Font.BOLD, 16));

        roll_field = new JTextField();
        roll_field.setBounds(400, 350, 200, 20);
        roll_field.setFont(new Font("Calibri", Font.BOLD, 16));
        Main.frame.add(roll);
        Main.frame.add(roll_field);

        people = new JLabel("Number of people: ");
        people.setBounds(200, 400, 200, 20);
        people.setFont(new Font("Calibri", Font.BOLD, 16));

        n_people = new JComboBox<String>(num_arr);
        n_people.setBounds(400, 400, 100, 20);
        Main.frame.add(people);
        Main.frame.add(n_people);

        room = new JLabel("Preferred Room Type");
        room.setBounds(200, 450, 200, 20);
        room.setFont(new Font("Calibri", Font.BOLD, 16));

        room_types = new JComboBox<>(Room.type);
        room_types.setBounds(400, 450, 100, 20);
        Main.frame.add(room);
        Main.frame.add(room_types);

        searchR = new JButton("Search Rooms");
        searchR.setBounds(400, 550, 200, 100);
        searchR.setBorder(new RoundedBorder(20));
        searchR.addActionListener(toTable);
        Main.frame.add(searchR);

        Main.frame.repaint();
    }

    static void removeStudent(){
        Main.frame.remove(roll);
        Main.frame.remove(people);
        Main.frame.remove(room);
        Main.frame.remove(n_people);
        Main.frame.remove(room_types);
        Main.frame.remove(roll_field);
        Main.frame.remove(searchR);
        Main.frame.repaint();
    }

    static void managementSetup(){
        roll = new JLabel("Enrollment Number:");
        roll.setBounds(200, 350, 200, 20);
        roll.setFont(new Font("Calibri", Font.BOLD, 16));

        roll_field = new JTextField();
        roll_field.setBounds(400, 350, 200, 20);
        roll_field.setFont(new Font("Calibri", Font.BOLD, 16));

        searchP = new JButton("Search Student");
        searchP.setBounds(620, 350, 200, 20);
        searchP.setFont(new Font("Calibri", Font.BOLD, 16));
        Main.frame.add(roll);
        Main.frame.add(roll_field);
        Main.frame.add(searchP);

        room = new JLabel("Room No:");
        room.setBounds(200, 400, 200, 20);
        room.setFont(new Font("Calibri", Font.BOLD, 16));

        room_no = new JTextField();
        room_no.setBounds(400, 400, 200, 20);
        room_no.setFont(new Font("Calibri", Font.BOLD, 16));

        searchR = new JButton("Search Room");
        searchR.setBounds(620, 400, 200, 20);
        searchR.setFont(new Font("Calibri", Font.BOLD, 16));
        searchR.addActionListener(showBookings);
        Main.frame.add(room);
        Main.frame.add(room_no);
        Main.frame.add(searchR);

        bookingInfo = new JTextArea("No Bookings Yet");
        bookingInfo.setBounds(300, 500, 400, 200);
        bookingInfo.setFont(new Font("Calibri", Font.BOLD, 16));
        sp = new JScrollPane(bookingInfo);
        Main.frame.getContentPane().add(sp);
        Main.frame.add(bookingInfo);

        Main.frame.repaint();
    }

    static void removeManagement(){
        Main.frame.remove(roll);
        Main.frame.remove(roll_field);
        Main.frame.remove(searchP);
        Main.frame.remove(room);
        Main.frame.remove(room_no);
        Main.frame.remove(searchR);
        Main.frame.remove(bookingInfo);
        Main.frame.remove(sp);
        Main.frame.repaint();
    }

    static JComponent[] components = {info, studentButton, managementButton, roll,
                                people, room, n_people, room_types, roll_field,
                                searchP, searchR, room_no};

    static void removeStart(){
        try{Main.frame.remove(info);}catch (Exception ignored){}
        try{Main.frame.remove(studentButton);}catch (Exception ignored){}
        try{Main.frame.remove(managementButton);}catch (Exception ignored){}
        try{Main.frame.remove(roll);}catch (Exception ignored){}
        try{Main.frame.remove(people);}catch (Exception ignored){}
        try{Main.frame.remove(room);}catch (Exception ignored){}
        try{Main.frame.remove(n_people);}catch (Exception ignored){}
        try{Main.frame.remove(room_types);}catch (Exception ignored){}
        try{Main.frame.remove(roll_field);}catch (Exception ignored){}
        try{Main.frame.remove(searchP);}catch (Exception ignored){}
        try{Main.frame.remove(searchR);}catch (Exception ignored){}
        try{Main.frame.remove(room_no);}catch (Exception ignored){}

        Main.frame.repaint();

    }

    static ActionListener toTable = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            removeStart();
            Table.setup();
        }
    };

    static void setup(){
        info = new JLabel("You are a ...");
        info.setBounds(300, 100, 400, 50);
        info.setFont(new Font("Calibri", Font.BOLD, 30));
        info.setVerticalAlignment(SwingConstants.TOP);
        info.setHorizontalAlignment(SwingConstants.CENTER);

        studentButton = new JToggleButton("STUDENT");
        studentButton.setBounds(200, 200, 200, 100);
        studentButton.setBorder((Border) new RoundedBorder(10));
        studentButton.addActionListener(toggle);

        managementButton = new JToggleButton("MANAGEMENT");
        managementButton.setBounds(600, 200, 200, 100);
        managementButton.setBorder((Border) new RoundedBorder(10));
        managementButton.addActionListener(toggle);


//        studentSetup();

        Main.frame.add(studentButton);
        Main.frame.add(managementButton);
        Main.frame.add(info);
        Main.frame.add(Main.background);
    }
}
