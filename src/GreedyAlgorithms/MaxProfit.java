package GreedyAlgorithms;
//贪心算法：121.买卖股票的最佳时期：

// 1.暴力解法
public class MaxProfit {
    public int maxProfit1(int[] prices){
        if(prices==null||prices.length<2) return 0;
        int max=prices[1]-prices[0];
        for (int i=0;i<prices.length-1;i++){
            for (int j=i+1;j<prices.length;j++){
                max=Math.max (prices[j]-prices[i],max);
            }
        }
        return Math.max(0,max);
    }

// 设置两个变量：第一个maxProfit:当前值减去最小值
// 第二个minPrice: 当前遇到的最小值，遇到更小值更新
// 由于是从左到右推进，所以时间复杂度O(n),
// 右边减去左边的数值，不会重算而且不会遗漏

    public int maxProfit2(int [] prices){
        if (prices==null||prices.length<2) return 0;
        int maxProfit=Math.max(0,prices[1]-prices[0]);

        int minPrice=prices[0];
        for (int price:prices){
            if (price<minPrice) minPrice=price;
            else{
                int profit= price-minPrice;
                maxProfit=Math.max(maxProfit,profit);
            }

        }
        return maxProfit;
}

//更简洁的写法：
    public int maxProfit3(int [] prices){
        int minPrice =prices[0];
        int maxProfit=0;
        for(int price:prices){
            minPrice=Math.min(minPrice,price);
            maxProfit=Math.max(maxProfit,price-minPrice);
        }
        return maxProfit;

    }
}