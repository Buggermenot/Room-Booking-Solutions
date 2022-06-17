import java.util.ArrayList;

public class Student {
    private String name;
    private String enrollment_number;
    private ArrayList<Bookings> bookings = new ArrayList<>();

    Student(String name, String enrollment_number){
        this.name = name;
        this.enrollment_number = enrollment_number;
    }

    public String getEnrollment_number() {
        return this.enrollment_number;
    }

    public String getName(){
        return this.name;
    }

    void addBooking(Bookings booking){
        bookings.add(booking);
    }

}