public class Bookings {
    Student student;
    TimeSlot timeSlot;
    Room room;

    Bookings(Student student, TimeSlot timeSlot, Room room){
        this.student = student;
        this.timeSlot = timeSlot;
        this.room = room;
    }

    boolean compare(Bookings otherBooking){
        return (this.timeSlot.checkClash(otherBooking.timeSlot));
    }

    public String toString(){
        return ("Enrollment No: " + student.getEnrollment_number() + '\n'
                        +  "Name: " + student.getName() + '\n'
                        +  "Room no: " + room + '\n'
                        +  "Time Slot " + timeSlot) + '\n';
    }

}
