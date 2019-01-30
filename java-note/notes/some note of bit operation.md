## 原码，补码，位移

- 原码就是符号位加上真值的绝对值, 即用第一位表示符号, 其余位表示值. 比如如果是8位二进制:

```
[+1]原 = 0000 0001

[-1]原 = 1000 0001   
```

 所以8位二进制数的取值范围就是:[11111111, 01111111] 即 【-127，127】

- 补码的表示方法是:

正数的补码就是其本身

负数的补码是在其原码的基础上, 符号位不变, 其余各位取反, 最后+1. (即在反码的基础上+1)

在计算机系统中，数值一律用补码来表示（存储）。 
主要原因：使用补码，可以将符号位和其它位统一处理；同时，减法也可按加法来处理。另外，两个用补
码表示的数相加时，如果最高位（符号位）有进位，则进位被舍弃。 

- 左移操作（<<） 规则：

右边空出的位用0填补 ；

高位左移溢出则舍弃该高位。

- 右移操作（>>）规则：

左边空出的位用0或者1填补。正数用0填补，负数用1填补

常见应用

> 左移相当于\*2，只是要注意边界问题。如char a = 65； a<<1 按照\*2来算为130;但有符号char的取值范围-128~127，已经越界，多超出了3个数值，所以从-128算起的第三个数值-126才是a<<1的正确结果。
>
> 其它的四种位运算：
>
> 与运算（&）
>
> 1、与0相与可清零
>
> 2、与1相与可保留原值
>
>
>
> 或运算（|）
>
> 1、与0相或可保留原值
>
> 2、与1相与可齐设1
>
>
>
> 异或运算（^）
>
> 1、与0异或保留原值
>
> 2、与1异或比特值反转
>
> 3、可通过某种算法，使用异或实现交换两个值
>
> 异或运算是有结合律的
>
> 取反（~）
>
> 0变1,1变0
>
>   ---------------------  本文来自 code_xbug 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/code_xbug/article/details/40921881?utm_source=copy 

 

One Number

- find the last digit of n, we just do: (n & 1)
- a^b^b = a





Two Numbers.

- How do we check if only one bit is 1? Use ^.

* How do we check if both bits are 1? Use &

* doing a bit-wise AND of n and n - 1 flips the least-significant 1-bit in n to 0.

   Consider the binary representations of n and n - 1

  ![Number of 1 Bits](https://leetcode.com/media/original_images/191_Number_Of_Bits.png)



  In the binary representation, the least significant 1-bit in n always corresponds to a 0-bit in n−1. Therefore, anding the two numbers n and n - 1 always flips the least significant 1-bit in n to 0, and keeps all other bits the same.

-  (n & (n -1))n; will get the least bit 1!!!!!

  because  n & (n-1) will change the least bit 1 to 0. and then XOR n,we can get the least bit 1.