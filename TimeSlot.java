public class TimeSlot {
    Time fromTime, toTime;

    TimeSlot(Time fromTime, Time toTime){
        this.fromTime = fromTime;
        this.toTime = toTime;
    }
    String getDuration(){
        int min, hour, days;
        days = this.toTime.day - this.fromTime.day;

        min = ((days * 24 + this.toTime.hour) * 60 + this.toTime.minute)
                -(this.fromTime.hour * 60 + this.fromTime.minute);

        hour = min / 60;
        min = min % 60;
        hour = hour % 24;

        hour = (hour < 0 ? -hour : hour);
        min = (min < 0 ? -min : min);

        if(hour == 0){
            return (min + " minutes");
        }
        else if(min == 0){
            return (hour + " hour(s)");
        }
        return (hour + " hour(s) " + min + " minutes");
    }

    public String toString(){
        return ("From: " + fromTime + ", To: " + toTime);
    }

    int getFromDate(){
        return this.fromTime.day;
    }
    int getToDate(){
        return this.toTime.day;
    }

    boolean checkClash(TimeSlot otherTimeSlot){

        if ((this.getToDate() >= otherTimeSlot.getFromDate() &&
                otherTimeSlot.getFromDate() >= this.getFromDate()) ||
                (otherTimeSlot.getToDate() >= this.getFromDate() &&
                        this.getFromDate() >= otherTimeSlot.getFromDate())){
            if ((this.toTime.hour >= otherTimeSlot.fromTime.hour &&
                    otherTimeSlot.fromTime.hour >= this.fromTime.hour) ||
                    (otherTimeSlot.toTime.hour >= this.fromTime.hour &&
                            this.fromTime.hour >= otherTimeSlot.fromTime.hour)){
                if((this.toTime.minute >= otherTimeSlot.fromTime.minute &&
                        otherTimeSlot.fromTime.minute >= this.fromTime.minute) ||
                        (otherTimeSlot.toTime.minute >= this.fromTime.minute &&
                                this.fromTime.minute >= otherTimeSlot.fromTime.minute)){
                    return true;
                }
            }
        }
        return false;
    }
}
