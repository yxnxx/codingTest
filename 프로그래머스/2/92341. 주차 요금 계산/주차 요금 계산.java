import java.util.*;
import java.text.*;

class Solution {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, String> rec = new HashMap<>();
        HashMap<String, Integer> timePerCar = new HashMap<>();
        for(String r: records) {
            String[] splited = r.split(" ");
            // Integer car = Integer.valueOf(splited[1]);
            String car = splited[1];
            if(!rec.containsKey(car)) {
                rec.put(car, splited[0]);
            } else {
                Integer carTime = calculateTime(fees, rec.get(car), splited[0]);
                timePerCar.put(car, timePerCar.getOrDefault(car, 0) + carTime);
                rec.remove(car);
            }
        }
        
        for(String r: rec.keySet()) {
            Integer carTime = calculateTime(fees, rec.get(r), "23:59");
            timePerCar.put(r, timePerCar.getOrDefault(r, 0) + carTime);
            // rec.remove(r);
        }
        
        List<String> keys = new ArrayList<>(timePerCar.keySet());
        Collections.sort(keys);
        // Map<String, Integer> tMap = new TreeMap<>(timePerCar);
        List<Integer> ans = new ArrayList<>();
        for(String k: keys) {
            int diffMin = timePerCar.get(k);
            if(fees[0] >= diffMin) {
                ans.add(fees[1]);
                continue;
            }
        
            int fee = fees[1];
            diffMin -= fees[0];
        
            fee += Math.ceil((double)diffMin/fees[2]) * fees[3];
            ans.add(fee);
        }
        
        int[] answer = ans.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    
    Integer calculateTime(int[] fees, String inTime, String outTime) {
        long carIn = 0;
        long carOut = 0;
        try {
            carIn = sdf.parse(inTime).getTime();
            carOut = sdf.parse(outTime).getTime();
        } catch(ParseException e) {
            e.printStackTrace();
        }
        
        return (int)((carOut - carIn)/(1000 * 60));
    }
}