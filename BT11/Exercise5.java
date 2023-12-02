package BT11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[200005];
        int[] b = new int[200005];
        int[] ma = new int[100005];
        int[] mb = new int[100005];
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            ma[a[i]]++;
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
            mb[b[i]]++;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < mb.length; i++) {
            if (mb[i] != ma[i]) {
                res.add(i);
            }
        }
        Collections.sort(res);
        for (int i : res) {
            System.out.print(i + " ");
        }
        sc.close();
    }
}
