# BOJ1167 트리의 지름
https://www.acmicpc.net/problem/1167

## 풀이

List<Node>[]에 line 정보를 저장

bfs로 탐색해서 최대거리 반환

---

1번부터 마지막 노드까지 반복하면 시간초과

1번 노드부터 탐색 후 1번노드와 거리가 가장 먼 노드를 탐색하면 AC