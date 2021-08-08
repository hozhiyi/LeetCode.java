package _202108_AugustLeetCodingChallenge;

import java.util.*;

public class _1632_RankTransformOfAMatrix {

    class Solution {
        public int[][] matrixRankTransform(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            Map<Integer, List<int[]>> map = new TreeMap();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int v = matrix[i][j];
                    map.computeIfAbsent(v, k -> new ArrayList()).add(new int[]{i, j});
                }
            }

            int[] rank = new int[m + n];
            for (int key : map.keySet()) {
                List<int[]> posList = map.get(key);
                int[] rank2 = rank.clone();

                DSU dsu = new DSU(m + n);

                for (int[] pos : posList) {
                    int s0 = dsu.find(pos[0]), s1 = dsu.find(pos[1] + m);
                    dsu.union(s0, s1);
                    rank2[s1] = Math.max(rank2[s0], rank2[s1]);
                }

                for (int[] pos : posList) {
                    int p0 = pos[0], p1 = pos[1];
                    rank[p0] = rank[p1 + m] = matrix[p0][p1] = rank2[dsu.find(p0)] + 1;
                }
            }
            return matrix;
        }

        class DSU {
            int[] parent;

            public DSU(int n) {
                parent = new int[n];
                for (int i = 0; i < n; i++)
                    parent[i] = i;
            }

            private int find(int x) {
                if (parent[x] != x)
                    parent[x] = find(parent[x]);
                return parent[x];
            }

            private void union(int x, int y) {
                int px = find(x), py = find(y);
                if (px != py)
                    parent[px] = py;
            }
        }
    }
}
