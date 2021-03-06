## 算法
```
算法：
	1冒泡排序
	2快速排序
	3插入排序
	4二分法排序
	5选择排序
	6直接插入排序
	7希尔排序
	8堆排序
	时间复杂度：时间复杂度是一个函数，定量描述了算法的运算时间，用大O符号来表示。在计算的时候，先找出算法基本操作的执行次数，
	即为T(n)，然后找到它的同数量级，即为f(n)，如果T(n)与f(n)的比值求极限可得到一个常数c，那么时间复杂度T(n)=O(f(n))。
    上面的冒泡排序的时间复杂度计算（计算下方的for循环）：T(n) = (4n+1)n，f(n) = n*n，c = 4，则时间复杂度为：T(n) = O(n*n)
    空间复杂度：空间复杂度是运行完一个程序所需要的内存的大小。这里包括了存储算法本身所需要的空间，输入与输出数据所占空间，
    以及一些临时变量（比如上面的h）所占用的空间。一般而言，我们只比较额外空间，来比较算法的空间优越性。
    上面的冒泡排序的临时变量所占空间不随处理数据n的大小改变而改变，则空间复杂度为O(1)。
	时间复杂度 比如冒泡排序 排序次数 n*(n-1)/2,当n=100000,0.5(n^2-n)=0.5（10^10-100000）
	因为n是可以非常大，10^10非常大，可以忽略0.5，也可以忽略100000，简约=n^2
```
#### 基础知识
```
		算术运算符 ： + - *  / %
		位运算符 ： & | ^ ~ << >> >>>

```
#### 关键知识点
```
		布隆过滤器知识
```
## 冒泡排序
```
   4 3 1 7 9 6 2 0
   将第一的坑填入正确的数字，比如正确排序第一个位置应该是0.所以冒泡排序是求第一位置的数字。以坑位计算，后面的数字可以变化。
   时间复杂度 O(n^2)  空间复杂度 O(1)
   第一排序 以第一的数字为基数，以第二个数字跟基数比较，总是将最小的比较值放入第一坑位。一直轮询到最后一个数字。这样第一个坑位
            是最小的值，
            第一个坑就不改变。
   第二个排序 以第二个数字为基数，以第三个数字跟基数比较，将最小的值放在第二个坑位。
   以此类推。。。
   当排完最后一个，顺序就是从小到大的顺序。
   时间复杂度 排序次数 (n^2-n)0.5,当n很大时，就可以估算为n^2.
   空间复杂度 ： 只暂用一个格外内存，所以复杂度为O(1)
```
## 快速排序
```
    冒泡排序的改进，是以左右交叉交换的排序算法。本质上时二分法

```
## 二分法排序
```
    选取一个数组，取中间数字，默认将第一个数字和最后一个数字跟中间数字比较，让所有的小的数字放在中间数字左边，让所有大的数字
    在右边。    
    依次遍历所有的数字进行比较。
```
## 插入排序
```
    一组数组   时间复杂度 O(n2) 空间复杂度为O(1)
    插入排序指将第一个数字作为一个排序的数组存在，将后续的数字将其比较大小，依次排序。这个比较使用已经差不多排好序的数组。
    效率较高。
```
## 选择排序
```
简单排序   n(n-1)/2 时间复杂度为O(n2)。
    将第一坑位的数字与其余的数字进行比较，选取的最小的数字交换，保证第一个坑位是最小的，其余的坑位不变。
    以第一个坑位为标准，第二个进行比较，第二个是小的，就记住他的位置，然后将后面的值依次将第二个比较，得到最小的数字的位置。
    第一遍的遍历就结束了，得到最小的数字位置，与第一个进行交换。
    依次遍历。
树型选择排序  -----堆排序
    8个叶子结点中依次存放排序之前的8个关键字，每个非终端结点中的关键字均等于其左、右孩子结点中较小的那个关键字，
    则根结点中的关键字为叶子结点中的最小关键字。
    在输出最小关键字之后，根据关系的可传递性，欲选出次小关键字，仅需将叶子结点中的最小关键字（13）改为“最大值”，然后从该
    叶子结点开始，和其左右兄弟的关键字进行比较，修改从叶子结点到根结点的路径上各结点的关键字，则根结点的关键字即为次小值。
```
## 直接插入排序
```

```
## 希尔排序shell排序
```

```
## 堆排序
```
    堆排序  时间复杂度O(nlgn)  空间复杂度 O(1)
    最大堆  最大堆的每个子树都符合最大堆的性质（根节点值大于所有子节点）
    先将待排序的数组构建成最大堆。
    推出堆顶元素作为最大值，然后再将剩余在堆建成最大堆。
    将最大堆堆顶元素作为次最大值。
    堆排序是一种选择排序，整体主要由构建初始堆+交换堆顶元素和末尾元素并重建堆两部分组成。其中构建初始堆经推导复杂度为O(n)，
    在交换并重建堆的过程中，需交换n-1次，而重建堆的过程中，根据完全二叉树的性质，[log2(n-1),log2(n-2)...1]逐步递减，
    近似为nlogn。所以堆排序时间复杂度一般认为就是O(nlogn)级。
```
### 归并排序
```
速度仅次于快速排序，内存少的时候使用，可以进行并行计算的时候使用。
选择相邻两个数组成一个有序序列。
选择相邻的两个有序序列组成一个有序序列。
重复第二步，直到全部组成一个有序序列。
```
### 基数排序
```
用于大量数，很长的数进行排序时。
将所有的数的个位数取出，按照个位数进行排序，构成一个序列。
将新构成的所有的数的十位数取出，按照十位数进行排序，构成一个序列。
```
