# IHK 伪代码高频+全类型覆盖题库（40题）

说明：这份题库按 IHK 常见考法扩展到 40 题，覆盖基础语法、流程控制、数组、字符串、业务逻辑、算法与综合场景。每题都给出最小可落地伪代码与中文易错点。

## 代码索引区
- Java 示例总表：`IHK-pseudocode-top40-java-examples.md`
- Python 示例总表：`IHK-pseudocode-top40-python-examples.md`
- 快速跳题：在对应文件中搜索 `## 01.` 到 `## 40.`。
## 01. 两数交换
题目：输入 a,b，交换后输出。
伪代码：
```text
READ a,b
t <- a
a <- b
b <- t
PRINT a,b
```
易错点：不要直接 `a <- b; b <- a`。

## 02. 三数最大值
题目：输入 x,y,z，输出最大值。
伪代码：
```text
max <- x
IF y > max THEN max <- y
IF z > max THEN max <- z
PRINT max
```
易错点：连续比较时要更新同一个变量。

## 03. 闰年判断
题目：输入年份 y，判断闰年。
伪代码：
```text
IF (y MOD 400 = 0) OR (y MOD 4 = 0 AND y MOD 100 <> 0)
    PRINT "leap"
ELSE
    PRINT "normal"
ENDIF
```
易错点：100 年规则最容易漏。

## 04. 成绩等级
题目：输入分数 s，输出 A-E。
伪代码：
```text
IF s>=90 grade<-"A"
ELSE IF s>=80 grade<-"B"
ELSE IF s>=70 grade<-"C"
ELSE IF s>=60 grade<-"D"
ELSE grade<-"E"
PRINT grade
```
易错点：区间判断顺序必须从高到低。

## 05. n 以内求和
题目：输入 n，计算 1..n。
伪代码：
```text
sum <- 0
FOR i <- 1 TO n
    sum <- sum + i
ENDFOR
PRINT sum
```
易错点：循环边界是否包含 n。

## 06. 阶乘
题目：输入 n，计算 n!。
伪代码：
```text
IF n<0 PRINT "invalid" ELSE
    fact <- 1
    FOR i <- 1 TO n
        fact <- fact * i
    ENDFOR
    PRINT fact
ENDIF
```
易错点：0! = 1。

## 07. 斐波那契前 n 项
题目：输出前 n 项。
伪代码：
```text
a<-0; b<-1
FOR i<-1 TO n
    PRINT a
    c <- a+b
    a <- b
    b <- c
ENDFOR
```
易错点：更新顺序不能错。

## 08. 质数判断
题目：输入 x 判断是否质数。
伪代码：
```text
IF x<2 PRINT "no" ELSE
    ok <- TRUE
    FOR d <- 2 TO FLOOR(SQRT(x))
        IF x MOD d = 0 THEN ok<-FALSE; BREAK
    ENDFOR
    PRINT ok
ENDIF
```
易错点：`x<2` 先处理。

## 09. GCD 最大公约数
题目：输入 a,b 求 gcd。
伪代码：
```text
WHILE b <> 0
    r <- a MOD b
    a <- b
    b <- r
ENDWHILE
PRINT a
```
易错点：辗转相除赋值顺序。

## 10. LCM 最小公倍数
题目：输入 a,b 求 lcm。
伪代码：
```text
g <- GCD(a,b)
l <- ABS(a*b) / g
PRINT l
```
易错点：先求 gcd，防止思路混乱。

## 11. 平均值、最大、最小
题目：输入 n 个数，统计 avg/max/min。
伪代码：
```text
sum<-0; max<- -INF; min<- INF
FOR i<-1 TO n
  READ x
  sum<-sum+x
  IF x>max THEN max<-x
  IF x<min THEN min<-x
ENDFOR
PRINT sum/n,max,min
```
易错点：初始值设定。

## 12. 计数分类
题目：输入 n 个数，统计正数/负数/0 数量。
伪代码：
```text
p<-0;nz<-0;z<-0
FOR i<-1 TO n
  READ x
  IF x>0 p<-p+1
  ELSE IF x<0 nz<-nz+1
  ELSE z<-z+1
ENDFOR
PRINT p,nz,z
```
易错点：三分支必须互斥。

## 13. 数组反转
题目：原地反转数组。
伪代码：
```text
l<-0; r<-n-1
WHILE l<r
  SWAP a[l],a[r]
  l<-l+1; r<-r-1
ENDWHILE
```
易错点：停止条件 `l<r`。

## 14. 查找最大值位置
题目：输出最大值及其下标。
伪代码：
```text
max<-a[0]; idx<-0
FOR i<-1 TO n-1
  IF a[i]>max THEN max<-a[i]; idx<-i
ENDFOR
PRINT max,idx
```
易错点：索引从 0 还是 1 要统一。

## 15. 冒泡排序
题目：升序排序。
伪代码：
```text
FOR pass<-0 TO n-2
  swapped<-FALSE
  FOR i<-0 TO n-2-pass
    IF a[i]>a[i+1] THEN SWAP a[i],a[i+1]; swapped<-TRUE
  ENDFOR
  IF NOT swapped THEN BREAK
ENDFOR
```
易错点：内层上界 `n-2-pass`。

## 16. 选择排序
题目：升序排序。
伪代码：
```text
FOR i<-0 TO n-2
  minI<-i
  FOR j<-i+1 TO n-1
    IF a[j]<a[minI] THEN minI<-j
  ENDFOR
  SWAP a[i],a[minI]
ENDFOR
```
易错点：每轮最小下标重置。

## 17. 插入排序
题目：升序排序。
伪代码：
```text
FOR i<-1 TO n-1
  key<-a[i]; j<-i-1
  WHILE j>=0 AND a[j]>key
    a[j+1]<-a[j]
    j<-j-1
  ENDWHILE
  a[j+1]<-key
ENDFOR
```
易错点：插入位置是 `j+1`。

## 18. 线性查找
题目：找 target 的首个位置。
伪代码：
```text
pos<- -1
FOR i<-0 TO n-1
  IF a[i]=target THEN pos<-i; BREAK
ENDFOR
PRINT pos
```
易错点：找不到保持 -1。

## 19. 二分查找
题目：有序数组查找。
伪代码：
```text
l<-0; r<-n-1; pos<- -1
WHILE l<=r
  m<-(l+r) DIV 2
  IF a[m]=t THEN pos<-m; BREAK
  ELSE IF a[m]<t THEN l<-m+1
  ELSE r<-m-1
ENDWHILE
PRINT pos
```
易错点：`l<=r` 不是 `<`。

## 20. 去重保序
题目：数组去重，保留首次出现顺序。
伪代码：
```text
m<-0
FOR i<-0 TO n-1
  found<-FALSE
  FOR j<-0 TO m-1
    IF b[j]=a[i] THEN found<-TRUE; BREAK
  ENDFOR
  IF NOT found THEN b[m]<-a[i]; m<-m+1
ENDFOR
PRINT b[0..m-1]
```
易错点：新长度变量 `m` 的维护。

## 21. 回文字符串
题目：判断字符串是否回文（忽略大小写）。
伪代码：
```text
s<-LOWER(s)
l<-0; r<-LEN(s)-1; ok<-TRUE
WHILE l<r
  IF s[l]<>s[r] THEN ok<-FALSE; BREAK
  l<-l+1; r<-r-1
ENDWHILE
PRINT ok
```
易错点：大小写统一。

## 22. 元音统计
题目：统计 a,e,i,o,u 数量。
伪代码：
```text
cnt<-0
FOR each ch IN LOWER(s)
  IF ch IN ['a','e','i','o','u'] THEN cnt<-cnt+1
ENDFOR
PRINT cnt
```
易错点：字符集合判断。

## 23. 单词反转顺序
题目："IHK ist schwer" -> "schwer ist IHK"。
伪代码：
```text
arr<-SPLIT(line,' ')
FOR i<-LEN(arr)-1 DOWNTO 0
  PRINT arr[i]
ENDFOR
```
易错点：连续空格时要过滤空单词。

## 24. 密码强度
题目：长度>=8 且有大小写+数字。
伪代码：
```text
u<-FALSE;l<-FALSE;d<-FALSE
FOR ch IN pw
  IF 'A'<=ch<='Z' u<-TRUE
  ELSE IF 'a'<=ch<='z' l<-TRUE
  ELSE IF '0'<=ch<='9' d<-TRUE
ENDFOR
PRINT LEN(pw)>=8 AND u AND l AND d
```
易错点：多条件 AND。

## 25. 日期合法性
题目：yyyy-mm-dd 合法检查。
伪代码：
```text
CHECK month in 1..12
SET days by month and leap year
CHECK day in 1..days
```
易错点：2 月天数与闰年联动。

## 26. 时间差（分钟）
题目：输入 hh1:mm1, hh2:mm2，求差值分钟。
伪代码：
```text
t1<-h1*60+m1
t2<-h2*60+m2
diff<-ABS(t2-t1)
PRINT diff
```
易错点：先转总分钟再计算。

## 27. 发票计算
题目：单价*数量，算净价、税额、总价。
伪代码：
```text
net<-price*qty
tax<-net*taxRate
gross<-net+tax
PRINT net,tax,gross
```
易错点：税率 19% 要用 0.19。

## 28. 折扣阶梯
题目：金额按区间折扣。
伪代码：
```text
IF amount>=1000 d<-0.15
ELSE IF amount>=500 d<-0.10
ELSE d<-0.00
pay<-amount*(1-d)
PRINT pay
```
易错点：区间边界包含关系。

## 29. 银行取款
题目：余额不足则拒绝。
伪代码：
```text
IF amount<=0 PRINT "invalid"
ELSE IF amount>balance PRINT "insufficient"
ELSE balance<-balance-amount; PRINT balance
```
易错点：先校验正数，再校验余额。

## 30. 售货机找零
题目：欧元硬币找零。
伪代码：
```text
changeCent <- paidCent-priceCent
coins <- [200,100,50,20,10,5,2,1]
FOR c IN coins
  cnt <- changeCent DIV c
  changeCent <- changeCent MOD c
  PRINT c,cnt
ENDFOR
```
易错点：用分避免浮点误差。

## 31. 库存预警
题目：库存低于阈值报警。
伪代码：
```text
FOR each item
  IF stock<min THEN PRINT item,"ALERT"
  ELSE PRINT item,"OK"
ENDFOR
```
易错点：`<` 与 `<=` 按题意选。

## 32. 订单状态机
题目：创建->支付->发货->完成，非法跳转拒绝。
伪代码：
```text
state<-"CREATED"
READ event
IF state="CREATED" AND event="pay" THEN state<-"PAID"
ELSE IF state="PAID" AND event="ship" THEN state<-"SHIPPED"
ELSE IF state="SHIPPED" AND event="finish" THEN state<-"DONE"
ELSE PRINT "invalid transition"
```
易错点：状态与事件必须同时匹配。

## 33. 登录失败锁定
题目：连续 3 次失败锁定账号。
伪代码：
```text
fail<-0; locked<-FALSE
WHILE NOT locked
  READ pw
  IF pw=correct THEN fail<-0; PRINT "ok"; BREAK
  ELSE fail<-fail+1
  IF fail>=3 THEN locked<-TRUE; PRINT "locked"
ENDWHILE
```
易错点：成功后失败次数清零。

## 34. 简易日志过滤
题目：输出级别 >= WARN 的日志。
伪代码：
```text
levelValue(INFO=1,WARN=2,ERROR=3)
FOR each log
  IF levelValue(log.level)>=2 THEN PRINT log
ENDFOR
```
易错点：先定义级别映射。

## 35. CSV 汇总
题目：输入多行 `name,amount`，统计总额与笔数。
伪代码：
```text
sum<-0; cnt<-0
FOR each line
  parts<-SPLIT(line,',')
  sum<-sum+TO_NUMBER(parts[1])
  cnt<-cnt+1
ENDFOR
PRINT cnt,sum
```
易错点：字符串转数字的异常处理。

## 36. 二维数组行列和
题目：m*n 矩阵，输出每行和每列和。
伪代码：
```text
INIT rowSum[m]=0, colSum[n]=0
FOR i<-0 TO m-1
  FOR j<-0 TO n-1
    READ a[i][j]
    rowSum[i]+=a[i][j]
    colSum[j]+=a[i][j]
  ENDFOR
ENDFOR
PRINT rowSum,colSum
```
易错点：行列索引不要混。

## 37. 学生成绩排名
题目：按总分降序输出名次。
伪代码：
```text
CALC total for each student
SORT by total desc
FOR i<-0 TO n-1 PRINT i+1,student[i],total[i]
```
易错点：排序键是总分不是姓名。

## 38. 函数封装：是否质数
题目：写函数 `isPrime(x)` 并复用。
伪代码：
```text
FUNCTION isPrime(x)
  ...
  RETURN TRUE/FALSE
END
FOR i<-1 TO n
  IF isPrime(a[i]) THEN PRINT a[i]
ENDFOR
```
易错点：函数返回值路径完整。

## 39. 递归：数组求和
题目：递归计算数组总和。
伪代码：
```text
FUNCTION sum(i)
  IF i=n THEN RETURN 0
  RETURN a[i]+sum(i+1)
END
PRINT sum(0)
```
易错点：终止条件必须可达。

## 40. 综合题：成绩系统菜单
题目：菜单支持录入、统计、排序、查询、退出。
伪代码：
```text
REPEAT
  READ cmd
  CASE cmd
    1: input scores
    2: show avg/max/min
    3: sort by score
    4: search by id
    0: exit
  ENDCASE
UNTIL cmd=0
```
易错点：模块化思维，先定义数据结构再写菜单分支。

---

## 高频优先刷题顺序（建议）
1) 04, 05, 11, 15, 19, 24, 25, 27, 29, 31
2) 08, 09, 13, 20, 30, 32, 33, 36, 40
3) 其余题用于查漏补缺

## 覆盖说明
这 40 题已覆盖 IHK 伪代码考试常见类型：
- 顺序、分支、循环
- 一维/二维数组
- 排序与查找
- 字符串处理
- 业务规则校验
- 菜单交互与状态流转
- 函数/递归基础

