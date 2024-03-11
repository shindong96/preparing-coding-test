package programmers.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class HotelBooking {

    public int solution(String[][] bookTimes) {
        int answer = 0;
        List<BookingTime> times = new ArrayList<>();

        for (String[] bookTime : bookTimes) {
            String start = bookTime[0];
            String end = bookTime[1];

            String[] startTime = start.split(":");
            String[] endTime = end.split(":");
            times.add(new BookingTime(
                    Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]),
                    Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]))
            );
        }

        Collections.sort(times);
        PriorityQueue<BookingTime> pq = new PriorityQueue<>(new ComparatorEndTime());
        answer++;
        pq.add(times.get(0));

        for (int i = 1; i < times.size(); i++) {
            BookingTime time = pq.peek();
            if (times.get(i).start < time.end + 10) {
                answer++;
            } else {
                pq.remove();
            }
            pq.add(times.get(i));
        }

        return answer;
    }

    class BookingTime implements Comparable<BookingTime> {
        int start;
        int end;

        public BookingTime(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(BookingTime other) {
            return this.start <= other.start ? -1 : 1;
        }
    }

    class ComparatorEndTime implements Comparator<BookingTime> {

        @Override
        public int compare(BookingTime o1, BookingTime o2) {
            return o1.end <= o2.end ? -1 : 1;
        }
    }
}
