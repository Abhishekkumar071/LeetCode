class UndergroundSystem {
    Map<Integer, Pair> map1;
    Map<String, int[]> map2;
    public UndergroundSystem() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }
    
    public void checkIn(int id, String sN, int t) {
        map1.put(id, new Pair(sN, t));
    }
    
    public void checkOut(int id, String sN, int t) {
        Pair p = map1.get(id);
        int sT = p.time;
        String sS = p.station;

        int time = t-sT;
        String key = sS+"-"+sN;
        map2.putIfAbsent(key, new int[2]);
        map2.get(key)[0]+=time;
        map2.get(key)[1]+=1;
        map1.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "-" + endStation;

        int[] data = map2.get(key);

        return (double) data[0] / data[1];
    }
    class Pair{
        String station;
        int time;
        Pair(String station, int time){
            this.station = station;
            this.time = time;
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */