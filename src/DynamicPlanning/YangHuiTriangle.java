package DynamicPlanning;
import java.util.ArrayList;
import java.util.List;
// 杨辉三角
public class YangHuiTriangle {
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                // 第一个或最后一个元素是 1
                if (j == 0 || j == i) row.add(1);
                else row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                    // 中间元素：上一行 j-1 和 j 位置的和
            }

            triangle.add(row);
        }

        return triangle;
    }



}

