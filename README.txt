ROOM BOOKING SOLUTIONS.
AUTHOR
    Name: Tanmay Verma
    ID: E21CSEU0906
    University: Bennett University

README
    This project is a program written for students of Bennett University, Greater Noida, India. It is a program that
    allows students to reserve certain rooms on campus for educational / entertainment purposes. The otherwise available
    solution to reserving a room requires inputs from various different bodies within the university and is therefore,
    quite lengthy.

SOFTWARE DEPENDENCIES
    Requires Java 1.8.x
    Requires Swing

USING THE PROGRAM
    To start the program, simply run the Main.java file in the repository.
    To add a new booking, start as a "Student" and click on "Search Rooms".

    * NOTE: Currently, the inputs for "Enrollment Number", "Number of People" and "Preferred Room Types" are only
    placeholders. However, all the buttons function assuming proper inputs.

    Upon clicking "Search Rooms", a table opens where the user may click on any 2 distinct blocks to create a timeslot
    between the two. Each block is 30 min timeslot for any room for the week. Therefore, a single selection registers
    as a 30 min timeslot. Booking details can be seen on the right side. Any blooking that does not clash with any
    previous bookings is stored within the program however is not retained in consecutive sessions. The list of all
    bookings made on the room can be retrieved in the "Management" menu by clicking on "Search Room".

KNOWN BUGS
    1. For any booking, there is a chance that the program registers half hour less than that selected.
    2. The program does not take into consideration the 4 hour max slot limit while storing/checking for clashes.