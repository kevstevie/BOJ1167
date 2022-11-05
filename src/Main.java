import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nodes = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeNum = Integer.parseInt(st.nextToken());
            while (true) {
                int nextNode = Integer.parseInt(st.nextToken());
                if (nextNode == -1) {
                    break;
                }
                int distance = Integer.parseInt(st.nextToken());
                nodes[nodeNum].add(new Node(nextNode, distance));
                nodes[nextNode].add(new Node(nodeNum, distance));
            }
        }

        bfs(1);
        bfs(maxIndex);

        System.out.println(max);
    }
    static int n;
    static List<Node>[] nodes;
    static long max = 0;
    static int maxIndex;

    static void bfs(int i) {
        long[] distances = new long[n + 1];
        boolean[] visit = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visit[i] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (Node node : nodes[now]) {
                if (visit[node.to]) {
                    continue;
                }
                visit[node.to] = true;
                q.offer(node.to);
                distances[node.to] = distances[now] + node.distance;
                if (max < distances[node.to]) {
                    max = distances[node.to];
                    maxIndex = node.to;
                }
            }
        }
        long asLong = Arrays.stream(distances).max().getAsLong();
        max = Math.max(asLong, max);
    }
}
class Node {
    int to;
    int distance;

    public Node(int to, int distance) {
        this.to = to;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Node{" +
                "to=" + to +
                ", distance=" + distance +
                '}';
    }
}