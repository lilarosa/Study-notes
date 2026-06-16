# IHK 伪代码 40题 Java 示例（可运行）

说明：每题都给出可直接运行的 `main` 示例，便于和伪代码一一对照。

## 01. 两数交换
题目：输入 a,b，交换后输出。
输入输出：示例变量输入，输出交换后的值。
```java
class Task01 {
    public static void main(String[] args) {
        int a = 3, b = 7;
        int t = a; a = b; b = t;
        System.out.println(a + " " + b);
    }
}
```
备注：必须借助临时变量。

## 02. 三数最大值
题目：输入 x,y,z，输出最大值。
输入输出：输出最大整数。
```java
class Task02 {
    public static void main(String[] args) {
        int x = 8, y = 15, z = 11;
        int max = x;
        if (y > max) max = y;
        if (z > max) max = z;
        System.out.println(max);
    }
}
```
备注：统一更新 `max`。

## 03. 闰年判断
题目：输入年份，判断闰年。
输入输出：输出 leap/normal。
```java
class Task03 {
    public static void main(String[] args) {
        int y = 2024;
        boolean leap = (y % 400 == 0) || (y % 4 == 0 && y % 100 != 0);
        System.out.println(leap ? "leap" : "normal");
    }
}
```
备注：400 年规则不能漏。

## 04. 成绩等级
题目：输入分数 s，输出 A-E。
输入输出：输出等级字符。
```java
class Task04 {
    public static void main(String[] args) {
        int s = 83;
        String g;
        if (s >= 90) g = "A";
        else if (s >= 80) g = "B";
        else if (s >= 70) g = "C";
        else if (s >= 60) g = "D";
        else g = "E";
        System.out.println(g);
    }
}
```
备注：从大到小判断区间。

## 05. n 以内求和
题目：计算 1..n 总和。
输入输出：输出整数和。
```java
class Task05 {
    public static void main(String[] args) {
        int n = 100, sum = 0;
        for (int i = 1; i <= n; i++) sum += i;
        System.out.println(sum);
    }
}
```
备注：边界包含 `n`。

## 06. 阶乘
题目：计算 n!。
输入输出：非法输出 invalid。
```java
class Task06 {
    public static void main(String[] args) {
        int n = 6;
        if (n < 0) {
            System.out.println("invalid");
            return;
        }
        long fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;
        System.out.println(fact);
    }
}
```
备注：0! = 1。

## 07. 斐波那契前 n 项
题目：输出前 n 项。
输入输出：一行输出序列。
```java
class Task07 {
    public static void main(String[] args) {
        int n = 8, a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a + (i == n - 1 ? "\n" : " "));
            int c = a + b; a = b; b = c;
        }
    }
}
```
备注：更新顺序固定。

## 08. 质数判断
题目：判断 x 是否质数。
输入输出：输出 true/false。
```java
class Task08 {
    static boolean isPrime(int x) {
        if (x < 2) return false;
        for (int d = 2; d * d <= x; d++) if (x % d == 0) return false;
        return true;
    }
    public static void main(String[] args) {
        int x = 97;
        System.out.println(isPrime(x));
    }
}
```
备注：循环到 `d*d<=x`。

## 09. GCD 最大公约数
题目：欧几里得算法。
输入输出：输出 gcd。
```java
class Task09 {
    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b; b = r;
        }
        return Math.abs(a);
    }
    public static void main(String[] args) {
        System.out.println(gcd(84, 18));
    }
}
```
备注：赋值顺序不能变。

## 10. LCM 最小公倍数
题目：由 gcd 推 lcm。
输入输出：输出 lcm。
```java
class Task10 {
    static int gcd(int a, int b) { while (b != 0) { int r = a % b; a = b; b = r; } return Math.abs(a); }
    public static void main(String[] args) {
        int a = 12, b = 18;
        int lcm = Math.abs(a * b) / gcd(a, b);
        System.out.println(lcm);
    }
}
```
备注：先算 gcd。

## 11. 平均值/最大/最小
题目：统计数组平均、最大、最小。
输入输出：输出 avg max min。
```java
class Task11 {
    public static void main(String[] args) {
        int[] arr = {67, 88, 91, 73, 85};
        int sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int x : arr) { sum += x; if (x > max) max = x; if (x < min) min = x; }
        double avg = (double) sum / arr.length;
        System.out.println(avg + " " + max + " " + min);
    }
}
```
备注：初始化用极值。

## 12. 正负零计数
题目：统计正数/负数/零数量。
输入输出：输出三个计数。
```java
class Task12 {
    public static void main(String[] args) {
        int[] a = {-2, 0, 5, 9, -1, 0};
        int p = 0, n = 0, z = 0;
        for (int x : a) {
            if (x > 0) p++; else if (x < 0) n++; else z++;
        }
        System.out.println(p + " " + n + " " + z);
    }
}
```
备注：分支互斥。

## 13. 数组反转
题目：原地反转数组。
输入输出：输出反转后数组。
```java
import java.util.Arrays;
class Task13 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int l = 0, r = a.length - 1;
        while (l < r) {
            int t = a[l]; a[l] = a[r]; a[r] = t;
            l++; r--;
        }
        System.out.println(Arrays.toString(a));
    }
}
```
备注：停止条件是 `l < r`。

## 14. 最大值及位置
题目：输出最大值和下标。
输入输出：输出 value index。
```java
class Task14 {
    public static void main(String[] args) {
        int[] a = {4, 7, 2, 9, 6};
        int max = a[0], idx = 0;
        for (int i = 1; i < a.length; i++) if (a[i] > max) { max = a[i]; idx = i; }
        System.out.println(max + " " + idx);
    }
}
```
备注：下标从 0 开始。

## 15. 冒泡排序
题目：升序冒泡排序。
输入输出：输出排序后数组。
```java
import java.util.Arrays;
class Task15 {
    public static void main(String[] args) {
        int[] a = {5,1,4,2,8};
        for (int pass = 0; pass < a.length - 1; pass++) {
            boolean swapped = false;
            for (int i = 0; i < a.length - 1 - pass; i++) {
                if (a[i] > a[i+1]) { int t = a[i]; a[i] = a[i+1]; a[i+1] = t; swapped = true; }
            }
            if (!swapped) break;
        }
        System.out.println(Arrays.toString(a));
    }
}
```
备注：内层边界随轮次缩短。

## 16. 选择排序
题目：升序选择排序。
输入输出：输出排序结果。
```java
import java.util.Arrays;
class Task16 {
    public static void main(String[] args) {
        int[] a = {9,3,7,1,6};
        for (int i = 0; i < a.length - 1; i++) {
            int minI = i;
            for (int j = i + 1; j < a.length; j++) if (a[j] < a[minI]) minI = j;
            int t = a[i]; a[i] = a[minI]; a[minI] = t;
        }
        System.out.println(Arrays.toString(a));
    }
}
```
备注：每轮先重置 `minI=i`。

## 17. 插入排序
题目：升序插入排序。
输入输出：输出排序结果。
```java
import java.util.Arrays;
class Task17 {
    public static void main(String[] args) {
        int[] a = {8,4,6,2,5};
        for (int i = 1; i < a.length; i++) {
            int key = a[i], j = i - 1;
            while (j >= 0 && a[j] > key) { a[j + 1] = a[j]; j--; }
            a[j + 1] = key;
        }
        System.out.println(Arrays.toString(a));
    }
}
```
备注：插入位置是 `j+1`。

## 18. 线性查找
题目：查找 target 首次出现位置。
输入输出：输出下标或 -1。
```java
class Task18 {
    public static void main(String[] args) {
        int[] a = {10,20,30,20};
        int target = 20, pos = -1;
        for (int i = 0; i < a.length; i++) if (a[i] == target) { pos = i; break; }
        System.out.println(pos);
    }
}
```
备注：找不到保留 -1。

## 19. 二分查找
题目：有序数组中找 target。
输入输出：输出下标或 -1。
```java
class Task19 {
    public static void main(String[] args) {
        int[] a = {2,5,7,11,15,19};
        int t = 11, l = 0, r = a.length - 1, pos = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (a[m] == t) { pos = m; break; }
            else if (a[m] < t) l = m + 1;
            else r = m - 1;
        }
        System.out.println(pos);
    }
}
```
备注：条件是 `l<=r`。

## 20. 去重保序
题目：去重并保留首次顺序。
输入输出：输出去重后数组。
```java
import java.util.*;
class Task20 {
    public static void main(String[] args) {
        int[] a = {3,1,3,2,1,4};
        List<Integer> b = new ArrayList<>();
        for (int x : a) if (!b.contains(x)) b.add(x);
        System.out.println(b);
    }
}
```
备注：考试可用双循环；这里用列表简化演示。

## 21. 回文字符串
题目：忽略大小写判断回文。
输入输出：输出 true/false。
```java
class Task21 {
    public static void main(String[] args) {
        String s = "Level".toLowerCase();
        int l = 0, r = s.length() - 1;
        boolean ok = true;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) { ok = false; break; }
            l++; r--;
        }
        System.out.println(ok);
    }
}
```
备注：统一小写再比较。

## 22. 元音统计
题目：统计字符串元音数。
输入输出：输出计数。
```java
class Task22 {
    public static void main(String[] args) {
        String s = "IHK Prufung".toLowerCase();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ("aeiou".indexOf(ch) >= 0) cnt++;
        }
        System.out.println(cnt);
    }
}
```
备注：先小写，避免重复条件。

## 23. 单词反转顺序
题目：按单词反转句子。
输入输出：输出反转后的句子。
```java
class Task23 {
    public static void main(String[] args) {
        String line = "IHK ist machbar";
        String[] arr = line.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
            if (i != 0) sb.append(" ");
        }
        System.out.println(sb);
    }
}
```
备注：用 `\\s+` 处理多空格。

## 24. 密码强度
题目：长度>=8，且含大小写和数字。
输入输出：输出 strong/weak。
```java
class Task24 {
    public static void main(String[] args) {
        String pw = "Aa123456";
        boolean u = false, l = false, d = false;
        for (char ch : pw.toCharArray()) {
            if (Character.isUpperCase(ch)) u = true;
            else if (Character.isLowerCase(ch)) l = true;
            else if (Character.isDigit(ch)) d = true;
        }
        System.out.println((pw.length() >= 8 && u && l && d) ? "strong" : "weak");
    }
}
```
备注：三个标志位都要满足。

## 25. 日期合法性
题目：校验 yyyy-mm-dd 合法。
输入输出：输出 valid/invalid。
```java
class Task25 {
    static boolean isLeap(int y) { return y % 400 == 0 || (y % 4 == 0 && y % 100 != 0); }
    public static void main(String[] args) {
        int y = 2024, m = 2, d = 29;
        int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        if (m < 1 || m > 12) { System.out.println("invalid"); return; }
        if (m == 2 && isLeap(y)) days[2] = 29;
        System.out.println((d >= 1 && d <= days[m]) ? "valid" : "invalid");
    }
}
```
备注：先判月，再判日。

## 26. 时间差（分钟）
题目：计算两个时刻分钟差绝对值。
输入输出：输出分钟数。
```java
class Task26 {
    public static void main(String[] args) {
        int h1 = 9, m1 = 45, h2 = 12, m2 = 5;
        int t1 = h1 * 60 + m1, t2 = h2 * 60 + m2;
        System.out.println(Math.abs(t2 - t1));
    }
}
```
备注：统一转总分钟。

## 27. 发票计算
题目：计算净价、税额、总价。
输入输出：输出金额。
```java
class Task27 {
    public static void main(String[] args) {
        double price = 19.9; int qty = 3; double taxRate = 0.19;
        double net = price * qty;
        double tax = net * taxRate;
        double gross = net + tax;
        System.out.printf("net=%.2f tax=%.2f gross=%.2f%n", net, tax, gross);
    }
}
```
备注：税率写成小数。

## 28. 折扣阶梯
题目：根据金额区间折扣。
输入输出：输出应付金额。
```java
class Task28 {
    public static void main(String[] args) {
        double amount = 680;
        double d = amount >= 1000 ? 0.15 : (amount >= 500 ? 0.10 : 0.0);
        System.out.printf("%.2f%n", amount * (1 - d));
    }
}
```
备注：边界值要和题意一致。

## 29. 银行取款
题目：余额校验后取款。
输入输出：输出新余额或错误。
```java
class Task29 {
    public static void main(String[] args) {
        double balance = 300, amount = 120;
        if (amount <= 0) System.out.println("invalid");
        else if (amount > balance) System.out.println("insufficient");
        else { balance -= amount; System.out.println(balance); }
    }
}
```
备注：先判正数，再判余额。

## 30. 售货机找零
题目：用欧元硬币找零。
输入输出：输出每种硬币数量。
```java
class Task30 {
    public static void main(String[] args) {
        int priceCent = 275, paidCent = 500;
        if (paidCent < priceCent) { System.out.println("not enough"); return; }
        int change = paidCent - priceCent;
        int[] coins = {200,100,50,20,10,5,2,1};
        for (int c : coins) {
            int cnt = change / c;
            change %= c;
            if (cnt > 0) System.out.println(c + "c:" + cnt);
        }
    }
}
```
备注：金额统一用分。

## 31. 库存预警
题目：低于阈值报警。
输入输出：输出 ALERT/OK。
```java
class Task31 {
    public static void main(String[] args) {
        String[] names = {"pen","book","usb"};
        int[] stock = {5, 20, 2};
        int min = 6;
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " " + (stock[i] < min ? "ALERT" : "OK"));
        }
    }
}
```
备注：阈值比较符号按题意选。

## 32. 订单状态机
题目：控制状态合法流转。
输入输出：输出新状态或非法。
```java
class Task32 {
    public static void main(String[] args) {
        String state = "CREATED";
        String event = "pay";
        if (state.equals("CREATED") && event.equals("pay")) state = "PAID";
        else if (state.equals("PAID") && event.equals("ship")) state = "SHIPPED";
        else if (state.equals("SHIPPED") && event.equals("finish")) state = "DONE";
        else System.out.println("invalid transition");
        System.out.println(state);
    }
}
```
备注：状态和事件要同时匹配。

## 33. 登录失败锁定
题目：连续失败3次锁定。
输入输出：输出锁定或成功。
```java
class Task33 {
    public static void main(String[] args) {
        String correct = "abc123";
        String[] tries = {"x", "y", "abc123"};
        int fail = 0;
        for (String t : tries) {
            if (t.equals(correct)) { System.out.println("ok"); fail = 0; break; }
            fail++;
            if (fail >= 3) { System.out.println("locked"); break; }
        }
    }
}
```
备注：成功后计数应清零。

## 34. 日志过滤
题目：输出级别>=WARN日志。
输入输出：过滤输出。
```java
class Task34 {
    static int level(String s) { return s.equals("ERROR") ? 3 : (s.equals("WARN") ? 2 : 1); }
    public static void main(String[] args) {
        String[] levels = {"INFO","WARN","ERROR","INFO"};
        String[] msgs = {"start","disk high","failed","end"};
        for (int i = 0; i < levels.length; i++) if (level(levels[i]) >= 2) System.out.println(levels[i] + ":" + msgs[i]);
    }
}
```
备注：先定义级别映射。

## 35. CSV 汇总
题目：统计 name,amount 行的笔数与总额。
输入输出：输出 count,sum。
```java
class Task35 {
    public static void main(String[] args) {
        String[] lines = {"A,10.5", "B,20", "C,5.5"};
        int cnt = 0; double sum = 0;
        for (String line : lines) {
            String[] p = line.split(",");
            sum += Double.parseDouble(p[1]);
            cnt++;
        }
        System.out.printf("count=%d sum=%.2f%n", cnt, sum);
    }
}
```
备注：注意字符串转数字异常。

## 36. 二维数组行列和
题目：输出每行和、每列和。
输入输出：两组数组。
```java
import java.util.Arrays;
class Task36 {
    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6}};
        int m = a.length, n = a[0].length;
        int[] row = new int[m], col = new int[n];
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) { row[i] += a[i][j]; col[j] += a[i][j]; }
        System.out.println(Arrays.toString(row));
        System.out.println(Arrays.toString(col));
    }
}
```
备注：行列下标不要混用。

## 37. 学生成绩排名
题目：按总分降序排名。
输入输出：输出名次和分数。
```java
import java.util.*;
class Task37 {
    public static void main(String[] args) {
        String[] names = {"Tom","Ana","Li"};
        int[] score = {88,95,88};
        Integer[] idx = {0,1,2};
        Arrays.sort(idx, (i, j) -> Integer.compare(score[j], score[i]));
        for (int r = 0; r < idx.length; r++) System.out.println((r + 1) + " " + names[idx[r]] + " " + score[idx[r]]);
    }
}
```
备注：排序键是分数，不是姓名。

## 38. 函数封装：isPrime
题目：封装函数并复用。
输入输出：输出数组中质数。
```java
class Task38 {
    static boolean isPrime(int x) {
        if (x < 2) return false;
        for (int d = 2; d * d <= x; d++) if (x % d == 0) return false;
        return true;
    }
    public static void main(String[] args) {
        int[] a = {2,3,4,5,10,11};
        for (int x : a) if (isPrime(x)) System.out.print(x + " ");
        System.out.println();
    }
}
```
备注：函数返回路径要完整。

## 39. 递归数组求和
题目：递归计算数组总和。
输入输出：输出总和。
```java
class Task39 {
    static int[] a = {1,2,3,4,5};
    static int sum(int i) {
        if (i == a.length) return 0;
        return a[i] + sum(i + 1);
    }
    public static void main(String[] args) {
        System.out.println(sum(0));
    }
}
```
备注：必须有可达终止条件。

## 40. 综合题：成绩系统菜单
题目：菜单支持录入、统计、排序、查询、退出。
输入输出：示例命令流模拟。
```java
import java.util.*;
class Task40 {
    public static void main(String[] args) {
        int[] scores = {78, 92, 85};
        int[] commands = {2, 3, 4, 0}; // 模拟用户操作
        for (int cmd : commands) {
            if (cmd == 2) {
                int sum = 0, max = -1, min = 101;
                for (int s : scores) { sum += s; if (s > max) max = s; if (s < min) min = s; }
                System.out.println("avg=" + (sum / (double) scores.length) + " max=" + max + " min=" + min);
            } else if (cmd == 3) {
                int[] c = Arrays.copyOf(scores, scores.length);
                Arrays.sort(c);
                System.out.println(Arrays.toString(c));
            } else if (cmd == 4) {
                int id = 1;
                System.out.println("id=" + id + " score=" + scores[id]);
            } else if (cmd == 0) {
                System.out.println("exit");
                break;
            }
        }
    }
}
```
备注：先定义清晰的数据结构和菜单分支。
