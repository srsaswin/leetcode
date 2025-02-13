import java.util.*;

class Num {
    int n;
    public Num(int n) {
        this.n = n;
    }
    public String toString() {
        return Integer.toString(n);
    }
}

class Solution {
    public static int[] to;
    public static HashMap<Integer, Num> inCycle;
    public static Set<Integer> notInCycle;
    public static List<Integer>[] adj;

    public static void cycle(int node) {
        if (inCycle.containsKey(node) || notInCycle.contains(node)) return;
        Num count = new Num(1);
        inCycle.put(node, count);
        int nextNode = to[node];

        while (!(inCycle.containsKey(nextNode) || notInCycle.contains(nextNode))) {
            count.n++;
            inCycle.put(nextNode, count);
            nextNode = to[nextNode];
        }

        while (node != nextNode) {
            notInCycle.add(node);
            count.n--;
            node = to[node];
        }
    }

    public static void find(int node) {
        for (int nextNode : adj[node]) {
            if (notInCycle.contains(nextNode)) {
                inCycle.put(nextNode, new Num(inCycle.get(node).n + 1));
                find(nextNode);
            }
        }
    }

    public int[] countVisitedNodes(List<Integer> edges) {
        int n = edges.size();

        to = new int[n];
        int inx = 0;
        for (int num : edges) to[inx++] = num;

        inCycle = new HashMap<>();
        notInCycle = new HashSet<>();

        for (int num = 0; num < n; num++) {
            if (!inCycle.containsKey(num)) cycle(num);
        }

        adj = new LinkedList[n];
        for (int x = 0; x < n; x++) adj[x] = new LinkedList<>();

        for (inx = 0; inx < n; inx++) adj[to[inx]].add(inx);

        for (int x = 0; x < n; x++) {
            if (!notInCycle.contains(x)) find(x);
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = inCycle.get(i).n; 
        }
        return result;

    }
}