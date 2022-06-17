import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Table {
    static boolean firstOne = true;
    static int  firstButton, secondButton, first_day, second_day;
    static JToggleButton[][] buttons = new JToggleButton[7][48];
    static JLabel[] timee = new JLabel[buttons[0].length];
    static JLabel[] dayss = new JLabel[buttons.length];
    static JButton back;
    static JButton confirmButton;
    static Time toTime, fromTime;
    static TimeSlot booking;
    static Bookings allotment;
    static String[] days = {"Monday",
                            "Tuesday",
                            "Wednesday",
                            "Thursday",
                            "Friday",
                            "Saturday",
                            "Sunday"};
    static JLabel errorBox;
    static JLabel display;
    static JLabel confirmBox;

    static int max(int a, int b){
        return (a >= b ? a : b);
    }

    static int min(int a, int b){
        return (a <= b ? a : b);
    }

    static int maxBlockHours = 8;

    static void fillTable(int index1, int day1, int index2, int day2){

        resetTable();

        int numero = 10;        // Does not matter what
        int counter = maxBlockHours;
        int temp_sol = numero/counter;


        if (day1 == day2) {

            index1 = min(index1, index2);
            index2 = max(index1, index2);
            try {
                for (int i = index1; i <= index2; i++) {
                    buttons[day1][i].setSelected(true);

                    counter --;
                    temp_sol = numero/counter;                   // Throws an error when counter goes to 0
                }
            }
            catch (Exception ignored) {
            }
        }
        else{
            try {
                if (day1 < day2) {
                    for (int day = day1; day <= day2; day++) {
                        if (day == day2) {
                            for (int i = 0; i <= index2; i++){
                                buttons[day][i].setSelected(true);
                                counter --;
                                temp_sol = numero/counter;
                            }
                        }
                        else if (day == day1) {
                            for (int i = index1; i < buttons[day].length; i++) {
                                buttons[day][i].setSelected(true);
                                counter --;
                                temp_sol = numero/counter;
                            }
                        }
                        else{
                            for(int i = 0; i < buttons[day].length; i++){
                                buttons[day][i].setSelected(true);
                                counter --;
                                temp_sol = numero/counter;
                            }
                        }
                    }
                }
                else{
                    for (int day = day2; day <= day1; day++) {
                        if (day == day2) {
                            for (int i = index2; i < buttons[day].length; i++) {
                                buttons[day][i].setSelected(true);
                                counter --;
                                temp_sol = numero/counter;
                            }
                        }
                        else if (day == day1) {
                            for (int i = 0; i <= index1; i++){
                                buttons[day][i].setSelected(true);
                                counter --;
                                temp_sol = numero/counter;
                            }
                        }
                        else{
                            for(int i = 0; i < buttons[day].length; i++){
                                buttons[day][i].setSelected(true);
                                counter --;
                                temp_sol = numero/counter;
                            }
                        }
                    }
                }
            }
            catch (Exception ignored){
                errorBox.setText("A maximum of " + maxBlockHours/2.0 + " hours can be booked at once");
                Main.frame.add(Main.background);
                Main.frame.repaint();
            }
        }
    }

    static void resetTable(JToggleButton b){
        for(JToggleButton[] buns : buttons){
            for(JToggleButton button: buns){
                if (button != b)
                    button.setSelected(false);
            }
        }
    }

    static void resetTable(){
        for(JToggleButton[] buns : buttons) {
            for (JToggleButton button : buns) {
                button.setSelected(false);
            }
        }
    }

    static int[] getIndex(JToggleButton button){
        for(int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (buttons[i][j] == button) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    static void setDisplay(){
        display = new JLabel();
        display.setBounds(600, 200, 200, 200);
        display.setBackground(new Color(161, 151, 128));
        display.setBorder(new LineBorder(Color.black));
        display.setVerticalAlignment(SwingConstants.TOP);
        display.setHorizontalAlignment(SwingConstants.LEFT);
        Main.frame.add(display);
    }

    static void updateDisplay(){
        String details = "<html>Booking details: <br/>" +
                            "From time: " + fromTime + "<br/>"+
                            "To time: " + toTime + "<br/>" +
                            "Total time: " + booking.getDuration() + "</html>";

        display.setText(details);
    }

    static ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int[] indexes = getIndex((JToggleButton) e.getSource());
            if(firstOne){
                first_day = indexes[0];
                firstButton = indexes[1];
                resetTable((JToggleButton) e.getSource());
                buttons[first_day][firstButton].setSelected(true);
                fromTime = new Time(indexes[0], indexes[1]);
            }
            else{
                second_day = indexes[0];
                secondButton = indexes[1];
                fillTable(firstButton, first_day, secondButton, second_day);
                rectifyTime();
            }
            toTime = new Time(indexes[0], indexes[1]+1);
            firstOne = !firstOne;
            booking = new TimeSlot(fromTime, toTime);
            updateDisplay();
        }
    };

    static ActionListener toStart = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            removeTable();
            StartPage.setup();
        }
    };

    static ActionListener checkAvailability = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            allotment = new Bookings(Main.s1, booking, Main.r1);
            try {
                for(Bookings b : Main.r1.bookings){
                    if(allotment.compare(b)){
                        int a = 0/0;
                    }
                }
                confirmBox.setText("Booking Successful");
                Main.r1.addBooking(allotment);
            }
            catch (Exception ign){
                confirmBox.setText("Booking clash");
            }

        }
    };

    static void removeTable(){
        for(JToggleButton[] bb: buttons){
            for(JToggleButton b : bb){
                Main.frame.remove(b);
            }
        }
        for(JLabel t: timee){
            Main.frame.remove(t);
        }
        for(JLabel d: dayss){
            Main.frame.remove(d);
        }
        try{Main.frame.remove(errorBox);}catch (Exception ignored){}
        try{Main.frame.remove(display);}catch (Exception ignored){}
        try{Main.frame.remove(confirmButton);}catch (Exception ignored){}
        try{Main.frame.remove(back);}catch (Exception ignored){}
        try{Main.frame.remove(confirmBox);}catch (Exception ignored){}

        Main.frame.repaint();
    }

    static void timeSwap(){
        Time temp = fromTime;
        fromTime = toTime;
        toTime = temp;
    }

    static void rectifyTime(){
        if(fromTime.day <= toTime.day){
            if(fromTime.hour <= toTime.hour){
                if (fromTime.minute > toTime.minute) {timeSwap();}
            }
            else {timeSwap();}
        }
        else {timeSwap();}
    }

    static void setup(){
        int x = 70, y = 50;
        int time = 0;

        errorBox = new JLabel();
        errorBox.setBounds(20, 1010, 300, 20);
        errorBox.setForeground(Color.red);
        Main.frame.add(errorBox);

        for(int i = 0; i < buttons[0].length; i++) {
            JLabel tim = new JLabel(new Time2(time).toString());
            tim.setBounds(20, y - 10, 70, 20);
            Main.frame.add(tim);
            timee[i] = tim;
            y += 20;
            time += 50;
        }       // Time

        y = 50;

        for(int i = 0; i < buttons.length; i++){
            JLabel day = new JLabel(days[i]);
            day.setBounds(x, 20, 70, 20);
            day.setHorizontalAlignment(SwingConstants.CENTER);
            Main.frame.add(day);
            dayss[i] = day;
            x += 70;
        }           // Day

        x = 70;

        for(int j = 0; j<buttons.length;j++) {
            for (int i = 0; i < buttons[j].length; i++) {
                JToggleButton b = new JToggleButton();
                buttons[j][i] = b;
                b.setBounds(x, y, 70, 20);
                b.setBorderPainted(false);
//                b.setBorder(new LineBorder(new Color(237, 103, 255)));
                b.setBackground(new Color(189, 117, 255));
                b.addActionListener(actionListener);
                Main.frame.add(b);
                y += 20;
            }
            x += 70;
            y = 50;
        }             // Blocks

        confirmButton = new JButton("Check Availability");
        confirmButton.setBounds(600, 100, 200, 50);
        confirmButton.addActionListener(checkAvailability);
        Main.frame.add(confirmButton);

        back = new JButton("Back");
        back.setFont(new Font("Calibri", Font.BOLD, 16));
        back.setBounds(800, 10, 150, 20);
        back.setVerticalAlignment(SwingConstants.TOP);
        back.setHorizontalAlignment(SwingConstants.CENTER);
        back.addActionListener(toStart);
        Main.frame.add(back);

        confirmBox = new JLabel();
        confirmBox.setFont(new Font("Calibri", Font.BOLD, 16));
        confirmBox.setForeground(Color.RED);
        confirmBox.setBounds(600, 150, 300, 50);
        Main.frame.add(confirmBox);

        setDisplay();

        Main.frame.add(Main.background);
        Main.frame.repaint();
    }
}

