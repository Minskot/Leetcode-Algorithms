package Graph;
// 207. 课程表

/*
你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses-1。
在选修某些课程之前需要一些先修课程。
先修课程数组 prerequisites[i] = [a, b] 表示：如果要学习课程 a，则必须先学习课程 b。
请你判断是否可能完成所有课程的学习（即课程图是否是有向无环图 DAG）。

*/


import java.util.*;
public class CanFinish {

    //解法一：BFS（拓扑排序，Kahn 算法）本质是判断有向图中有没有环
    // prerequisites[i]表示，要学课程a，必须先学课程b: b->a
    // 方向是先修课指向后修课

    // 统计记录所有节点的入度，然后遍历图中的所有节点，每当一个节点，将他后面的节点的入度减一
    // 最后需要遍历完全部的节点，这时候每个节点的入度都已经减去了流入数量
    // 比较全部入度是不是都是n，这样可以证明所有节点都能有路径流入

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. 构建邻接表和入度数组
        List<List<Integer>> graph = new ArrayList<>();
        // 创建一个基于数组列表的graph
        int[] indegree = new int[numCourses];
        // 创建一个入度表，统计所有课程的入度数量
        // 入度数量：表示需要多少个前置课才能上这个课

        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            // 后修课a
            int prereqCourse = prereq[1];
            // 先修课b
            graph.get(prereqCourse).add(course);
            // 先修 → 后修  b->a
            indegree[course]++;
            // a的入度++，表示有多少条边指向这个节点
        }


        Queue<Integer> queue = new LinkedList<>();
        // 2. 将所有入度为 0 的课程入队，可以直接学习的课程
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }



        // 3. BFS 拓扑排序
        int count = 0;
        // 已学习的课程数
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            // 取出一个可以直接学习的课程，学习此课程
            for (int nextCourse : graph.get(course)) {
                indegree[nextCourse]--;
                // 减少下一个课程的入度数量
                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                    // 如果下一个课程的前置课全部上过了，就上这个课
                }
            }
        }

        return count == numCourses;
        // 判断能否完成：
        // 如果全部课程都被访问过：count==numCourses 无环，返回True
        // 如果count！=numCourses表示存在没有被访问过的课程，那么有环，返回False

    }




    // ✅ 解法二：DFS（检测环）
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        // 构建邻接表
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
        }

        // 状态：0=未访问，1=访问中，2=已访问
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (hasCycle(graph, visited, i)) {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean hasCycle(List<List<Integer>> graph, int[] visited, int node) {
        // 标记为访问中
        visited[node] = 1;

        for (int next : graph.get(node)) {
            if (visited[next] == 1) {
                // 遇到了访问中的节点 → 有环
                return true;
            }
            if (visited[next] == 0) {
                if (hasCycle(graph, visited, next)) {
                    return true;
                }
            }
        }

        // 标记为已访问
        visited[node] = 2;
        return false;
    }
}



