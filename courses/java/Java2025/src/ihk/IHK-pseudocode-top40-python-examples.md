# IHK 伪代码 40题 Python 示例（可运行）

说明：每题都给出 Python 3 可执行示例（含 `if __name__ == "__main__":`）。

## 01. 两数交换
题目：输入 a,b，交换后输出。
输入输出：示例变量输入，输出交换后的值。
```python
if __name__ == "__main__":
    a, b = 3, 7
    a, b = b, a
    print(a, b)
```
备注：Python 可直接多变量交换。

## 02. 三数最大值
题目：输入 x,y,z，输出最大值。
输入输出：输出最大整数。
```python
if __name__ == "__main__":
    x, y, z = 8, 15, 11
    m = x
    if y > m:
        m = y
    if z > m:
        m = z
    print(m)
```
备注：连续比较时更新同一变量。

## 03. 闰年判断
题目：输入年份，判断闰年。
输入输出：输出 leap/normal。
```python
if __name__ == "__main__":
    y = 2024
    leap = (y % 400 == 0) or (y % 4 == 0 and y % 100 != 0)
    print("leap" if leap else "normal")
```
备注：400 年规则优先。

## 04. 成绩等级
题目：输入分数输出 A-E。
输入输出：输出等级。
```python
if __name__ == "__main__":
    s = 83
    if s >= 90:
        g = "A"
    elif s >= 80:
        g = "B"
    elif s >= 70:
        g = "C"
    elif s >= 60:
        g = "D"
    else:
        g = "E"
    print(g)
```
备注：高分段先判。

## 05. n 以内求和
题目：计算 1..n。
输入输出：输出总和。
```python
if __name__ == "__main__":
    n = 100
    s = 0
    for i in range(1, n + 1):
        s += i
    print(s)
```
备注：`range` 右边开区间。

## 06. 阶乘
题目：计算 n!。
输入输出：非法则输出 invalid。
```python
if __name__ == "__main__":
    n = 6
    if n < 0:
        print("invalid")
    else:
        f = 1
        for i in range(1, n + 1):
            f *= i
        print(f)
```
备注：0! = 1。

## 07. 斐波那契前 n 项
题目：输出前 n 项。
输入输出：输出序列。
```python
if __name__ == "__main__":
    n = 8
    a, b = 0, 1
    out = []
    for _ in range(n):
        out.append(a)
        a, b = b, a + b
    print(*out)
```
备注：先保存当前项再更新。

## 08. 质数判断
题目：判断是否质数。
输入输出：输出 True/False。
```python
def is_prime(x: int) -> bool:
    if x < 2:
        return False
    d = 2
    while d * d <= x:
        if x % d == 0:
            return False
        d += 1
    return True

if __name__ == "__main__":
    print(is_prime(97))
```
备注：循环到根号范围。

## 09. GCD 最大公约数
题目：欧几里得算法。
输入输出：输出 gcd。
```python
def gcd(a: int, b: int) -> int:
    while b != 0:
        a, b = b, a % b
    return abs(a)

if __name__ == "__main__":
    print(gcd(84, 18))
```
备注：状态迭代顺序要正确。

## 10. LCM 最小公倍数
题目：通过 gcd 求 lcm。
输入输出：输出 lcm。
```python
def gcd(a: int, b: int) -> int:
    while b:
        a, b = b, a % b
    return abs(a)

if __name__ == "__main__":
    a, b = 12, 18
    print(abs(a * b) // gcd(a, b))
```
备注：整除使用 `//`。

## 11. 平均值/最大/最小
题目：统计数组。
输入输出：输出 avg max min。
```python
if __name__ == "__main__":
    arr = [67, 88, 91, 73, 85]
    s = sum(arr)
    print(s / len(arr), max(arr), min(arr))
```
备注：平均值注意浮点除法。

## 12. 正负零计数
题目：统计三类数量。
输入输出：输出 p n z。
```python
if __name__ == "__main__":
    arr = [-2, 0, 5, 9, -1, 0]
    p = n = z = 0
    for x in arr:
        if x > 0:
            p += 1
        elif x < 0:
            n += 1
        else:
            z += 1
    print(p, n, z)
```
备注：分支互斥。

## 13. 数组反转
题目：原地反转。
输入输出：输出反转数组。
```python
if __name__ == "__main__":
    a = [1, 2, 3, 4, 5]
    l, r = 0, len(a) - 1
    while l < r:
        a[l], a[r] = a[r], a[l]
        l += 1
        r -= 1
    print(a)
```
备注：停止条件是 `l < r`。

## 14. 最大值及位置
题目：输出最大值与下标。
输入输出：value index。
```python
if __name__ == "__main__":
    a = [4, 7, 2, 9, 6]
    m = a[0]
    idx = 0
    for i in range(1, len(a)):
        if a[i] > m:
            m = a[i]
            idx = i
    print(m, idx)
```
备注：统一索引起点。

## 15. 冒泡排序
题目：升序冒泡。
输入输出：输出排序结果。
```python
if __name__ == "__main__":
    a = [5, 1, 4, 2, 8]
    n = len(a)
    for p in range(n - 1):
        swapped = False
        for i in range(n - 1 - p):
            if a[i] > a[i + 1]:
                a[i], a[i + 1] = a[i + 1], a[i]
                swapped = True
        if not swapped:
            break
    print(a)
```
备注：可用 `swapped` 提前退出。

## 16. 选择排序
题目：升序选择排序。
输入输出：输出排序结果。
```python
if __name__ == "__main__":
    a = [9, 3, 7, 1, 6]
    n = len(a)
    for i in range(n - 1):
        m = i
        for j in range(i + 1, n):
            if a[j] < a[m]:
                m = j
        a[i], a[m] = a[m], a[i]
    print(a)
```
备注：每轮重置最小下标。

## 17. 插入排序
题目：升序插入排序。
输入输出：输出排序结果。
```python
if __name__ == "__main__":
    a = [8, 4, 6, 2, 5]
    for i in range(1, len(a)):
        key = a[i]
        j = i - 1
        while j >= 0 and a[j] > key:
            a[j + 1] = a[j]
            j -= 1
        a[j + 1] = key
    print(a)
```
备注：插入位置是 `j+1`。

## 18. 线性查找
题目：找 target 首位置。
输入输出：输出下标或 -1。
```python
if __name__ == "__main__":
    a = [10, 20, 30, 20]
    t = 20
    pos = -1
    for i, x in enumerate(a):
        if x == t:
            pos = i
            break
    print(pos)
```
备注：找不到保持 -1。

## 19. 二分查找
题目：有序数组查找。
输入输出：输出位置或 -1。
```python
if __name__ == "__main__":
    a = [2, 5, 7, 11, 15, 19]
    t = 11
    l, r = 0, len(a) - 1
    pos = -1
    while l <= r:
        m = (l + r) // 2
        if a[m] == t:
            pos = m
            break
        elif a[m] < t:
            l = m + 1
        else:
            r = m - 1
    print(pos)
```
备注：`l <= r` 避免漏查。

## 20. 去重保序
题目：去重且保序。
输入输出：输出去重列表。
```python
if __name__ == "__main__":
    a = [3, 1, 3, 2, 1, 4]
    b = []
    for x in a:
        if x not in b:
            b.append(x)
    print(b)
```
备注：考试里常写双循环。

## 21. 回文字符串
题目：忽略大小写判回文。
输入输出：输出 True/False。
```python
if __name__ == "__main__":
    s = "Level".lower()
    l, r = 0, len(s) - 1
    ok = True
    while l < r:
        if s[l] != s[r]:
            ok = False
            break
        l += 1
        r -= 1
    print(ok)
```
备注：先统一大小写。

## 22. 元音统计
题目：统计元音数量。
输入输出：输出计数。
```python
if __name__ == "__main__":
    s = "IHK Prufung".lower()
    cnt = sum(1 for ch in s if ch in "aeiou")
    print(cnt)
```
备注：字符集合判断最稳。

## 23. 单词反转顺序
题目：反转句子单词顺序。
输入输出：输出反转句子。
```python
if __name__ == "__main__":
    line = "IHK ist machbar"
    words = line.split()
    print(" ".join(words[::-1]))
```
备注：`split()` 自动处理多空格。

## 24. 密码强度
题目：长度>=8 且含大小写数字。
输入输出：输出 strong/weak。
```python
if __name__ == "__main__":
    pw = "Aa123456"
    has_u = any(c.isupper() for c in pw)
    has_l = any(c.islower() for c in pw)
    has_d = any(c.isdigit() for c in pw)
    print("strong" if len(pw) >= 8 and has_u and has_l and has_d else "weak")
```
备注：三个条件缺一不可。

## 25. 日期合法性
题目：校验 yyyy-mm-dd。
输入输出：输出 valid/invalid。
```python
def is_leap(y: int) -> bool:
    return y % 400 == 0 or (y % 4 == 0 and y % 100 != 0)

if __name__ == "__main__":
    y, m, d = 2024, 2, 29
    days = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    if 1 <= m <= 12:
        if m == 2 and is_leap(y):
            days[2] = 29
        print("valid" if 1 <= d <= days[m] else "invalid")
    else:
        print("invalid")
```
备注：判月在前。

## 26. 时间差（分钟）
题目：计算两个时刻差。
输入输出：输出分钟绝对值。
```python
if __name__ == "__main__":
    h1, m1, h2, m2 = 9, 45, 12, 5
    t1 = h1 * 60 + m1
    t2 = h2 * 60 + m2
    print(abs(t2 - t1))
```
备注：先转总分钟。

## 27. 发票计算
题目：净价、税额、总价。
输入输出：输出三项金额。
```python
if __name__ == "__main__":
    price, qty, tax_rate = 19.9, 3, 0.19
    net = price * qty
    tax = net * tax_rate
    gross = net + tax
    print(f"net={net:.2f} tax={tax:.2f} gross={gross:.2f}")
```
备注：税率用小数。

## 28. 折扣阶梯
题目：按区间折扣。
输入输出：输出应付金额。
```python
if __name__ == "__main__":
    amount = 680
    if amount >= 1000:
        d = 0.15
    elif amount >= 500:
        d = 0.10
    else:
        d = 0.0
    print(f"{amount * (1 - d):.2f}")
```
备注：区间边界要一致。

## 29. 银行取款
题目：余额校验取款。
输入输出：输出新余额或错误。
```python
if __name__ == "__main__":
    balance, amount = 300.0, 120.0
    if amount <= 0:
        print("invalid")
    elif amount > balance:
        print("insufficient")
    else:
        balance -= amount
        print(balance)
```
备注：先校验输入有效性。

## 30. 售货机找零
题目：欧元硬币找零。
输入输出：输出每种硬币数量。
```python
if __name__ == "__main__":
    price_cent, paid_cent = 275, 500
    if paid_cent < price_cent:
        print("not enough")
    else:
        change = paid_cent - price_cent
        for c in [200, 100, 50, 20, 10, 5, 2, 1]:
            cnt, change = divmod(change, c)
            if cnt:
                print(f"{c}c:{cnt}")
```
备注：用分避免浮点误差。

## 31. 库存预警
题目：低于阈值报警。
输入输出：输出每个商品状态。
```python
if __name__ == "__main__":
    names = ["pen", "book", "usb"]
    stock = [5, 20, 2]
    min_stock = 6
    for i in range(len(names)):
        print(names[i], "ALERT" if stock[i] < min_stock else "OK")
```
备注：`<` 还是 `<=` 依题意。

## 32. 订单状态机
题目：状态流转校验。
输入输出：输出新状态或非法。
```python
if __name__ == "__main__":
    state = "CREATED"
    event = "pay"
    if state == "CREATED" and event == "pay":
        state = "PAID"
    elif state == "PAID" and event == "ship":
        state = "SHIPPED"
    elif state == "SHIPPED" and event == "finish":
        state = "DONE"
    else:
        print("invalid transition")
    print(state)
```
备注：状态+事件双条件。

## 33. 登录失败锁定
题目：连续失败三次锁定。
输入输出：输出 ok 或 locked。
```python
if __name__ == "__main__":
    correct = "abc123"
    tries = ["x", "y", "abc123"]
    fail = 0
    for t in tries:
        if t == correct:
            print("ok")
            fail = 0
            break
        fail += 1
        if fail >= 3:
            print("locked")
            break
```
备注：成功应清零失败计数。

## 34. 日志过滤
题目：输出级别>=WARN。
输入输出：输出过滤后的日志行。
```python
def lv(s: str) -> int:
    return {"INFO": 1, "WARN": 2, "ERROR": 3}[s]

if __name__ == "__main__":
    logs = [("INFO", "start"), ("WARN", "disk high"), ("ERROR", "failed"), ("INFO", "end")]
    for level, msg in logs:
        if lv(level) >= 2:
            print(level + ":" + msg)
```
备注：先做等级映射。

## 35. CSV 汇总
题目：统计 `name,amount`。
输入输出：输出 count 和 sum。
```python
if __name__ == "__main__":
    lines = ["A,10.5", "B,20", "C,5.5"]
    cnt, s = 0, 0.0
    for line in lines:
        _, amount = line.split(",")
        s += float(amount)
        cnt += 1
    print("count=", cnt, "sum=", round(s, 2))
```
备注：留意数字转换异常。

## 36. 二维数组行列和
题目：输出每行和每列和。
输入输出：输出两组列表。
```python
if __name__ == "__main__":
    a = [[1, 2, 3], [4, 5, 6]]
    m, n = len(a), len(a[0])
    row = [0] * m
    col = [0] * n
    for i in range(m):
        for j in range(n):
            row[i] += a[i][j]
            col[j] += a[i][j]
    print(row)
    print(col)
```
备注：不要混淆行列索引。

## 37. 学生成绩排名
题目：按总分降序输出。
输入输出：输出名次、姓名、分数。
```python
if __name__ == "__main__":
    names = ["Tom", "Ana", "Li"]
    score = [88, 95, 88]
    idx = sorted(range(len(score)), key=lambda i: score[i], reverse=True)
    for r, i in enumerate(idx, start=1):
        print(r, names[i], score[i])
```
备注：排序键要明确。

## 38. 函数封装：isPrime
题目：封装函数后复用。
输入输出：输出数组中的质数。
```python
def is_prime(x: int) -> bool:
    if x < 2:
        return False
    for d in range(2, int(x ** 0.5) + 1):
        if x % d == 0:
            return False
    return True

if __name__ == "__main__":
    arr = [2, 3, 4, 5, 10, 11]
    print([x for x in arr if is_prime(x)])
```
备注：函数要保证所有路径返回。

## 39. 递归数组求和
题目：递归计算总和。
输入输出：输出总和。
```python
def rec_sum(a, i=0):
    if i == len(a):
        return 0
    return a[i] + rec_sum(a, i + 1)

if __name__ == "__main__":
    print(rec_sum([1, 2, 3, 4, 5]))
```
备注：终止条件不可缺。

## 40. 综合题：成绩系统菜单
题目：菜单支持统计、排序、查询、退出。
输入输出：用命令列表模拟交互。
```python
if __name__ == "__main__":
    scores = [78, 92, 85]
    commands = [2, 3, 4, 0]
    for cmd in commands:
        if cmd == 2:
            s = sum(scores)
            print("avg=", s / len(scores), "max=", max(scores), "min=", min(scores))
        elif cmd == 3:
            print(sorted(scores))
        elif cmd == 4:
            sid = 1
            print("id=", sid, "score=", scores[sid])
        elif cmd == 0:
            print("exit")
            break
```
备注：菜单题先定数据结构再写分支。
