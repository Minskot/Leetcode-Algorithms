package HashAndNormalArrays;

// 2144.打折购买糖果的最小开销 排序+贪心算法

import java.util.Arrays;

public class MinimumCost {
    public int minimumCost(int[] cost) {
        if(cost==null) return -1;
        int l=cost.length, sum=0;
        Arrays.sort(cost);
        for (int i=0;i<l;i++)
            if ((l-i)%3!=0)
                sum+=cost[i];

        return sum;

    }
}
