# IHK 考试伪代码项目练习集锦（15题）

说明：每题都按 IHK 常见“输入-处理-输出”逻辑设计，附上重点难点中文备注。

## 1. 成绩统计与等级判断
**题目：** 输入 10 名学生成绩（0-100），计算平均分、最高分、最低分，并输出每个人等级（A/B/C/D/E）。

**伪代码：**
```text
sum <- 0
max <- -1
min <- 101
FOR i <- 1 TO 10
    READ score
    sum <- sum + score
    IF score > max THEN
        max <- score
    ENDIF
    IF score < min THEN
        min <- score
    ENDIF
    IF score >= 90 THEN grade <- "A"
    ELSE IF score >= 80 THEN grade <- "B"
    ELSE IF score >= 70 THEN grade <- "C"
    ELSE IF score >= 60 THEN grade <- "D"
    ELSE grade <- "E"
    PRINT i, score, grade
ENDFOR
avg <- sum / 10
PRINT avg, max, min
```
**重点难点：**
- 初始化 `max/min` 的边界值。
- 多分支区间必须从高到低判断，避免条件“吞掉”后续分支。

## 2. 阶乘与溢出提示
**题目：** 输入 n，计算 n!；若 n > 20 给出“可能溢出”提示。

**伪代码：**
```text
READ n
IF n < 0 THEN
    PRINT "invalid"
ELSE
    IF n > 20 THEN PRINT "warning: overflow risk"
    fact <- 1
    FOR i <- 1 TO n
        fact <- fact * i
    ENDFOR
    PRINT fact
ENDIF
```
**重点难点：**
- 非法输入先拦截。
- IHK 题常考“先校验，再计算”的流程顺序。

## 3. 质数判断
**题目：** 输入整数 x，判断是否质数。

**伪代码：**
```text
READ x
IF x < 2 THEN
    PRINT "not prime"
ELSE
    isPrime <- TRUE
    FOR d <- 2 TO FLOOR(SQRT(x))
        IF x MOD d = 0 THEN
            isPrime <- FALSE
            BREAK
        ENDIF
    ENDFOR
    IF isPrime THEN PRINT "prime" ELSE PRINT "not prime"
ENDIF
```
**重点难点：**
- 循环上界用 `sqrt(x)`，时间复杂度更优。
- 找到因子后 `BREAK`，减少无效计算。

## 4. 数组去重（保留首次出现）
**题目：** 输入长度 n 的整数数组，输出去重后的顺序数组。

**伪代码：**
```text
READ n
FOR i <- 0 TO n-1
    READ a[i]
ENDFOR
m <- 0
FOR i <- 0 TO n-1
    exists <- FALSE
    FOR j <- 0 TO m-1
        IF b[j] = a[i] THEN
            exists <- TRUE
            BREAK
        ENDIF
    ENDFOR
    IF NOT exists THEN
        b[m] <- a[i]
        m <- m + 1
    ENDIF
ENDFOR
PRINT b[0..m-1]
```
**重点难点：**
- 双重循环下标范围易错。
- `m` 表示新数组当前有效长度。

## 5. 冒泡排序（升序）
**题目：** 输入 n 个数，使用冒泡排序并输出每轮结果。

**伪代码：**
```text
READ n
FOR i <- 0 TO n-1
    READ a[i]
ENDFOR
FOR pass <- 0 TO n-2
    swapped <- FALSE
    FOR i <- 0 TO n-2-pass
        IF a[i] > a[i+1] THEN
            temp <- a[i]
            a[i] <- a[i+1]
            a[i+1] <- temp
            swapped <- TRUE
        ENDIF
    ENDFOR
    PRINT a
    IF NOT swapped THEN BREAK
ENDFOR
PRINT a
```
**重点难点：**
- 内层上界是 `n-2-pass`。
- `swapped` 优化是 IHK 常见加分点。

## 6. 二分查找
**题目：** 在已排序数组中查找 target，输出位置或 -1。

**伪代码：**
```text
left <- 0
right <- n-1
pos <- -1
WHILE left <= right
    mid <- (left + right) DIV 2
    IF a[mid] = target THEN
        pos <- mid
        BREAK
    ELSE IF a[mid] < target THEN
        left <- mid + 1
    ELSE
        right <- mid - 1
    ENDIF
ENDWHILE
PRINT pos
```
**重点难点：**
- 循环条件必须 `left <= right`。
- 边界更新要排除 `mid`，否则可能死循环。

## 7. 银行账户（存取款菜单）
**题目：** 实现循环菜单：1存款 2取款 3查询余额 0退出。

**伪代码：**
```text
balance <- 0
REPEAT
    PRINT "1 deposit,2 withdraw,3 balance,0 exit"
    READ cmd
    IF cmd = 1 THEN
        READ amount
        IF amount > 0 THEN balance <- balance + amount
    ELSE IF cmd = 2 THEN
        READ amount
        IF amount > 0 AND amount <= balance THEN
            balance <- balance - amount
        ELSE
            PRINT "insufficient"
        ENDIF
    ELSE IF cmd = 3 THEN
        PRINT balance
    ENDIF
UNTIL cmd = 0
```
**重点难点：**
- 业务规则校验：取款不能超过余额。
- 循环结束条件和菜单输入范围控制。

## 8. 发票计算（净价/税额/总价）
**题目：** 输入单价、数量、税率，输出净价、税额、总价。

**伪代码：**
```text
READ price
READ qty
READ taxRate
net <- price * qty
tax <- net * taxRate
gross <- net + tax
PRINT net, tax, gross
```
**重点难点：**
- 百分比税率若输入 19，先转换 `0.19`。
- 金额输出常要求保留两位小数。

## 9. 日期合法性检查
**题目：** 输入 yyyy, mm, dd，判断日期是否合法（含闰年）。

**伪代码：**
```text
READ y, m, d
IF m < 1 OR m > 12 THEN
    PRINT "invalid"
ELSE
    IF (y MOD 400 = 0) OR (y MOD 4 = 0 AND y MOD 100 <> 0) THEN
        leap <- TRUE
    ELSE
        leap <- FALSE
    ENDIF
    days <- 31
    IF m=4 OR m=6 OR m=9 OR m=11 THEN days <- 30
    IF m=2 THEN
        IF leap THEN days <- 29 ELSE days <- 28
    ENDIF
    IF d >= 1 AND d <= days THEN PRINT "valid" ELSE PRINT "invalid"
ENDIF
```
**重点难点：**
- 闰年条件是组合逻辑，易写错。
- 先判月再判日，减少分支复杂度。

## 10. 密码强度检查
**题目：** 输入密码，检查长度>=8，且包含大写、小写、数字。

**伪代码：**
```text
READ pw
hasUpper <- FALSE
hasLower <- FALSE
hasDigit <- FALSE
FOR each ch IN pw
    IF 'A'<=ch<='Z' THEN hasUpper <- TRUE
    ELSE IF 'a'<=ch<='z' THEN hasLower <- TRUE
    ELSE IF '0'<=ch<='9' THEN hasDigit <- TRUE
ENDFOR
IF LENGTH(pw) >= 8 AND hasUpper AND hasLower AND hasDigit THEN
    PRINT "strong"
ELSE
    PRINT "weak"
ENDIF
```
**重点难点：**
- 多条件与逻辑 `AND`。
- 字符分类逻辑清晰表达。

## 11. 统计单词频次（简化）
**题目：** 输入一行文本（仅英文和空格），统计每个单词出现次数。

**伪代码：**
```text
READ line
words <- SPLIT(LOWER(line), " ")
FOR each w IN words
    IF w = "" THEN CONTINUE
    IF map contains w THEN
        map[w] <- map[w] + 1
    ELSE
        map[w] <- 1
    ENDIF
ENDFOR
FOR each key IN map
    PRINT key, map[key]
ENDFOR
```
**重点难点：**
- 需要先统一大小写。
- 连续空格会产生空字符串，要跳过。

## 12. 学生成绩管理（二维数组）
**题目：** 录入 3 名学生 4 门课成绩，输出每个学生总分、平均分，以及每门课平均分。

**伪代码：**
```text
FOR s <- 0 TO 2
    stuSum[s] <- 0
    FOR c <- 0 TO 3
        READ score[s][c]
        stuSum[s] <- stuSum[s] + score[s][c]
        courseSum[c] <- courseSum[c] + score[s][c]
    ENDFOR
ENDFOR
FOR s <- 0 TO 2
    PRINT s, stuSum[s], stuSum[s]/4
ENDFOR
FOR c <- 0 TO 3
    PRINT c, courseSum[c]/3
ENDFOR
```
**重点难点：**
- 行列含义必须统一：`score[学生][课程]`。
- 累加数组要先初始化为 0。

## 13. 自动售货机找零
**题目：** 商品价格 price，用户投币 paid，计算是否足够与找零（欧元硬币 2,1,0.5,0.2,0.1）。

**伪代码：**
```text
READ price, paid
IF paid < price THEN
    PRINT "not enough"
ELSE
    change <- paid - price
    coins <- [2.0,1.0,0.5,0.2,0.1]
    FOR each coin IN coins
        cnt <- FLOOR(change / coin)
        change <- change - cnt * coin
        PRINT coin, cnt
    ENDFOR
ENDIF
```
**重点难点：**
- 浮点计算建议转换成“分”(cent)避免精度误差。
- 贪心法在该硬币体系可行。

## 14. 文件名过滤器
**题目：** 输入多个文件名，输出扩展名为 `.txt` 且大小 > 1KB 的文件。

**伪代码：**
```text
READ n
FOR i <- 1 TO n
    READ name, sizeKB
    IF ENDSWITH(name, ".txt") AND sizeKB > 1 THEN
        PRINT name
    ENDIF
ENDFOR
```
**重点难点：**
- 字符串后缀判断属于 IHK 常见基础题。
- 条件组合要注意优先级。

## 15. 简易库存预警系统
**题目：** 输入 8 个商品库存，低于最小库存阈值 `minStock` 的输出预警清单。

**伪代码：**
```text
READ minStock
FOR i <- 1 TO 8
    READ itemName, stock
    IF stock < minStock THEN
        PRINT itemName, "ALERT"
    ELSE
        PRINT itemName, "OK"
    ENDIF
ENDFOR
```
**重点难点：**
- 阈值比较符号（`<` 还是 `<=`）要按题意。
- 输出格式常作为评分点，建议统一模板。

---

## 使用建议（备考）
- 第 1 轮：先手写伪代码，不看答案。
- 第 2 轮：把伪代码翻译为 Java（重点看数组边界和循环）。
- 第 3 轮：给每题增加 2 个异常输入测试（空值、负数、越界）。
