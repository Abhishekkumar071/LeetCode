class Solution {
    public double angleClock(int hour, int minutes) {
        double h = (double)((hour*60)+minutes)/2.0;
        double m = minutes*6;
        double sum=Math.abs(h-m);
        System.out.println(h+" "+m);
        return Math.min(sum, 360-sum);
    }
}