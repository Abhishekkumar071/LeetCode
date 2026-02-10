class ExamTracker {
    TreeMap<Integer, Long> map;
    public ExamTracker() {
        map = new TreeMap<>();
    }
    
    public void record(int time, int score) {
        long last = map.isEmpty()? 0: map.lastEntry().getValue();
        map.put(time, score+last);
    }
    
    public long totalScore(int startTime, int endTime) {
        Integer right = map.floorKey(endTime);
        if(right==null) return 0;

        Integer left = map.lowerKey(startTime);
        
        return (map.get(right)-(left==null?0:map.get(left)));
    }
}


/**
 * Your ExamTracker object will be instantiated and called as such:
 * ExamTracker obj = new ExamTracker();
 * obj.record(time,score);
 * long param_2 = obj.totalScore(startTime,endTime);
 */