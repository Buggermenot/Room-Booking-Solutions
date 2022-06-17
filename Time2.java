public class Time2 {
    int hour;
    int minute;
    Time2(int t){
        this.hour = t / 100;
        this.minute = (t % 100 == 50 ? 30 : 0);
    }

    public String toString(){
        return (String.format("%02d", this.hour) + ":" + String.format("%02d", this.minute));
    }
}
