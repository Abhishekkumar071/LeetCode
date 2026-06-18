class Solution {
    public double angleClock(int hour, int minutes) {
        double hourAngle = hour*30+minutes*0.5;
        double minutesAngle =  minutes*6;
        double angle = Math.abs(hourAngle - minutesAngle);
        return Math.min(angle,360-angle);

    }
}