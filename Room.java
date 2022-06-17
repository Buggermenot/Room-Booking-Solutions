import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    public static final int           // Type of Room
            TR = 0,                   // Tutorial Room
            CC = 1,                   // Class Room
            LH = 2,                   // Lecture Hall
            LA = 3;                   // Labs
    public static final String[] type = {"TR", "CC", "LH", "LA"};


    public static final int           // Block in which the room is
            A = 0,
            B = 1,
            N = 2;
    private static final char[] block = {'A', 'B', 'N'};

    int room_number, room_block, room_type;

//    public static HashMap<Integer, Bookings> bookings;

    public ArrayList<Bookings> bookings = new ArrayList<>();

    Room(int room_number, int room_block) {
        this.room_type = (room_number + room_block) % 4;
        this.room_block = room_block;
        this.room_number = room_number;
    }

    void addBooking(Bookings b){bookings.add(b);}

    public String toString() {
        return (this.room_number + "-" + block[this.room_block] + "-" + type[this.room_type]);
    }
}
