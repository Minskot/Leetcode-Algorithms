#!/bin/bash  # case- statement
read -p "Which subject?" code
case $code in
    comp1*) echo "$code level1" ;;
    # 以comp1开头的任意字符串
    comp2*) echo "$code level2" ;; 
    comp[34]*) echo "$code senior" ;;
    comp*) echo "$code other comp" ;;
    *)  echo "$code not a code" ;;
esac


#!/bin/bash   # For loop:
courselist=(1011 2021 2432)
for course in ${courselist[@]}; do
  if [ "$course" -lt 2000 ]; then
      echo level 1 course $course
  else echo level 2 course $course
  fi
done
for file in $(ls); do
    echo file $file eists
done 

# simplified for loop:
#!/bin/bash
for f in *.c; do  # 基本通配符循环：遍历当前目录下所有.c文件
    echo $f is a C file
done
for i in {1..10}; do  # 输出1..10
    echo i is $i
done
for i in {1..20..3};do  # 循环范围（步长），输出1,4,7,10,13,16,19
    echo i is $i
done
for ((i=1;i<=10;i++)); do # C风格循环
    echo number is $i
done
for item; do # 遍历脚本的所有参数 等价于for item in "$@"
    echo arguments is $item
done



#!/bin/bash    # while循环 
read -p "Enter number:" num
ctr=1 sum=0
while [ $ctr -le $num ]; do
    let sum=sum+ctr
    echo $ctr
    let ctr++
done
echo "Sum of $num nums: $sum."



#我自己参照这个while循环写一个猜数字：

# !/bin/bash
# 使用while循环和比较
read -p "I set the answer number:" answer
count=0
guess=101
echo "Let's start:"
while [ $answer -ne $guess];do
    let $count++
    read -p "Please enter one guess number from 0 to 100:" guess
    if [$guess -lt $answer ]; then
        echo "Your guess number is too small! Try again!"
    elif [ $guess -gt $answer ]; then
        echo "Your guess number is too big!"
    fi
    echo "Your guess number is $guess"
done

echo "You guessed the answer $answer. You did $count times!"


#!/bin/bash    # if：
number =10
if [ $number -gt 10 ]; then
    echo " $number grtr than 10"
elif [ $number -lt 10]; then
    echo " $number less than 10"
else
    echo " $number equal to 10"
fi


