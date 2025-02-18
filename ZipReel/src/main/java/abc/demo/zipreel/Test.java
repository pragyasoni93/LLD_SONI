package abc.demo.zipreel;

/*
Tesco has around 3200 stores and more than 10% of the stores have around 800 colleagues each.

In a store, a colleague can work for multiple departments. Here are shifts of a colleague in various departments:

In Bakery department: From 8 to 10
In Checkout department: From 10 to 12
In Dairy department: From 14 to 19

Given the above split of shifts, provide an API/method to return the different shifts of a colleague for the day after merging contiguous shifts.
This will be exposed to the colleague in a different UI and help them plan their day accordingly.

His shift timings in this case are 8 to 12 and 14 to 19.
has context menu


In Bakery department: From 8 to 9
In Checkout department: From 10 to 14
In Dairy department: From 14 to 19

any order
[s1,e1][s2,e2]
[[8,10],[10,12],[14,19]]
sort in asc order form start time
check e1<s2 : no merge
else e1==s2 : 8,12 : merge

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<List<Integer>> intervals = new ArrayList<>();
        intervals.add(List.of(8,10));
        intervals.add(List.of(10,12));
        intervals.add(List.of(12,13));
        intervals.add(List.of(14,19));
        System.out.println(mergeInterval(intervals));
    }

    public static List<List<Integer>> mergeInterval(List<List<Integer>> intervals){
        List<List<Integer>> res = new ArrayList<>();
        if(intervals.size()<=1)
            return intervals;
        //sort
        Collections.sort(intervals, ((interval1, interval2) -> interval1.get(1)-interval2.get(0)));
        /*
        [s1,e1][s2,e2]
[[8,10],[10,12],[12,13],[14,19]]
i=0 [[8,10],
i=1 [[8,12]
i=2 [[8,13]
i=3 [[8,13],[14,19]]
sort in asc order form start time
check e1<s2 : no merge
else e1==s2 : 8,12 : merge
         */
        int idx = 0;
        for(int i=0; i<intervals.size(); i++){
            if(res.size()==0){
                res.add(intervals.get(i));
            }
            else{
                List<Integer> currInterval = res.get(idx);
                if(currInterval.get(1)==intervals.get(i).get(0)){
                    currInterval.set(1, intervals.get(i).get(0));
                }
                else{
                    idx++;
                    res.add(intervals.get(i));
                }
            }
        }

        return res;
    }
}
