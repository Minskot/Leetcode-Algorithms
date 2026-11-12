#!/bin/bash
if [ $# -ne 1 ]; then
    echo "Usage: $0 studentname" #接受学生姓名
    exit 1 
fi
student="$1"
weeks=(04 05 06 07 08 09) # 周数按顺序
declare -a scores
declare -a output_order
sum_all=0
count=0
for w in "${weeks[@]}"; do # 收集分数 
    # @数组展开，每个数组元素为独立单词
    file="CE${w}.txt"    #每一周读取对应的成绩文件
    if [ -f "$file" ]; then # 查找该学生的分数
        score=$(grep -w "$student" "$file" | awk '{print $2}')
        # 在文件中精确匹配学生姓名，提取第二列（分数）
        if [ -n "$score" ]; then
            scores+=($score)  # 找到分数：记录分数
            output_order+=($score)
        else     # 没找到：记录0分
            scores+=(0)
            output_order+=("-")
        fi
    else  # 文件不存在的情况也可视为该周缺考（0分）
        scores+=(0)
        output_order+=("-")
    fi
done
for ((i=0; i<${#output_order[@]}; i++)); do # 输出分数序列
    echo -n "${output_order[$i]}"
    if [ $i -lt $((${#output_order[@]} - 1)) ]; then
        echo -n " "
    fi
done
echo   # 换到下一行
# 去掉一个最低分（如果多于 1 个最低，只去掉一个）
# 先排序
sorted_scores=($(printf "%s\n" "${scores[@]}" | sort -n))
min=${sorted_scores[0]} # 找到最小值
removed=0 total=0
for s in "${scores[@]}"; do 
    if [ $removed -eq 0 ] && [ $s -eq $min ]; then
        removed=1 # 标记第一次遇到最小值时跳过（其他相同值保留）
        continue
    fi
    total=$((total + s))
done
echo "CP $total" #输出总分