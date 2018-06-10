package com.ctci.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Intervals {
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
		
		@Override
		public String toString(){
			return "start : " + start + " end: " + end;
		}
	}
	
	public List<Interval> merge(List<Interval> intervals){
		List<Interval> out = new ArrayList<>();
		
		Interval in1 = intervals.get(0);
		int min_start = in1.start;
		int max_end = in1.end;
		
		for(int i = 1; i < intervals.size(); i++){
			Interval curr = intervals.get(i);
			int curr_start = curr.start;
			int curr_end = curr.end;
			
			if(min_start <= curr_start && curr_start <= max_end){
				max_end = Math.max(max_end, curr_end);
			}
			else{
				out.add(new Interval(min_start, max_end));
				min_start = curr.start;
				max_end = curr.end;
			}
		}
		out.add(new Interval(min_start, max_end));
		return out;
	}

	public static void main(String[] args) {
		Intervals intervals = new Intervals();
		Intervals.Interval in1 = intervals.new Interval(1, 3);
		Intervals.Interval in2 = intervals.new Interval(2, 6);
		Intervals.Interval in3 = intervals.new Interval(15, 18);
		Intervals.Interval in4 = intervals.new Interval(12, 16);
		
		List<Intervals.Interval> list = new ArrayList<>();
		list.add(in1);
		list.add(in2);
		list.add(in3);
		list.add(in4);
		
		Collections.sort(list, new Comparator<Intervals.Interval>() {

			@Override
			public int compare(Intervals.Interval in1, Intervals.Interval in2) {
				if(in1.start < in2.start)
					return -1;
				else if(in2.start < in1.start)
					return 1;
				else
					return 0;
			}
		});
		
		for(Intervals.Interval in : list)
			System.out.println(in);
		
		System.out.println("New Intervals :");
		
		for(Intervals.Interval in : intervals.merge(list))
			System.out.println(in);
	}
}
