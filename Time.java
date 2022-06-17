public class Time {
    int hour, minute, day;

    Time(int day, int index){
        this.day = day;
        this.hour = index / 2;
        this.minute = (index % 2) * 30;
    }

    Time(int day, int hour, int minute){
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    public String toString(){
        return (Table.days[day] + " " + (String.format("%02d", this.hour)) + ":" + (String.format("%02d", this.minute)));
    }
}