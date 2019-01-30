# Summary of LinkedList Questions

**借助HashSet**及**利用两个pointer**的方法在LinkedList中还是蛮常见的。

例如，判断是否有intersection,可以用HashSet放一个，再遍历第二个；也可以用两个pointer A，B，让A走一把A+B，B走一把B+A，这样两者走过的元素一样过，不是都同时到达最后一个node（null），就是同时到了相交的那个node。

又如判断是否有圈，一样可以借助HashSet。也可以用两个一快(每次forward两个元素)一慢（每次forwar一个元素）的pointer，如果有圈，那快的会跟慢的遇到。



另外，reverse也是很重要的一个idea。例如在判断一个link是不是回文时候，我就会利用分两part，后part reverse跟前part同时一起traverse比较。