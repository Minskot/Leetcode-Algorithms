package HashAndNormalArrays;
// 1833. 雪糕的最大数量：


import java.util.Arrays;

public class MaxIceCream {
    // 我自己写的，先排序再判断
    public int maxIceCream(int[] costs, int coins) {
        if (coins<=0) return 0;
        Arrays.sort(costs);
        int count=0,ptr=0;
        while(coins>=0&&ptr<costs.length){
            if(coins>=costs[ptr]){
                coins-=costs[ptr];
                ptr++;
                count++;
            }
            else break;
        }
        return count;
    }

    // 在原代码基础上的改进，简化判断条件：

    public int maxIceCream2(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for (int cost : costs) {
            if (coins >= cost) {
                coins -= cost;
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    // 计数排序（最优解，O(n + maxCost)）
        public int maxIceCream3(int[] costs, int coins) {
            // 找到最大价格
            int maxCost = 0;
            for (int cost : costs) maxCost = Math.max(maxCost, cost);

            // 计数排序：统计每个价格的出现次数
            int[] count = new int[maxCost + 1];
            for (int cost : costs) count[cost]++;

            int total = 0;
            for (int price = 0; price <= maxCost && coins >= price; price++) {
                while (count[price] > 0 && coins >= price) {
                    coins -= price;
                    total++;
                    count[price]--;
                }
            }

            return total;
        }

        // 贪心 + 前缀和（计数排序变种）
            public int maxIceCream4(int[] costs, int coins) {
                int maxCost = 0;
                for (int cost : costs) maxCost = Math.max(maxCost, cost);

                int[] freq = new int[maxCost + 1];
                for (int cost : costs) freq[cost]++;

                int count = 0;
                for (int price = 0; price < freq.length && coins >= price; price++) {
                    // 当前价格能买的最大数量
                    int canBuy = Math.min(freq[price], coins / price);
                    count += canBuy;
                    coins -= canBuy * price;
                }

                return count;
            }


    public static void main(String[] args) {
        MaxIceCream mic=new MaxIceCream();
        int []costs={1,3,2,4,1};
        int coins=7;

        int ans=0;
        ans=mic.maxIceCream(costs,coins);
        System.out.println(ans);
    }
}
