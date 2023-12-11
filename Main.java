import java.util.*;

class Solution
{
    static class Pair {
        int value;
        int frequency;

        public Pair(int value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }
    }

    static ArrayList<Integer> sortByFreq(int[] arr, int n)
    {
        ArrayList<Integer> res = new ArrayList<>();
        int[] fre = new int[100005];
        for (int i = 0; i < arr.length; i++) {
            fre[arr[i]]++;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.frequency != o2.frequency) {
                    return Integer.compare(o1.frequency, o2.frequency);
                } else {
                    return Integer.compare(o1.value, o2.value);
                }
            }
        });
        for (int i = 0; i < fre.length; i++) {
            if (fre[i] != 0) {
                pq.add(new Pair(i, fre[i]));
            }
        }
        while (!pq.isEmpty()) {
            for (int i = 1; i <= pq.peek().frequency; i++) {
                res.add(pq.peek().value);
            }
            pq.poll();
        }
        Collections.reverse(res);
        return res;
    }
}