## This is a code challenge from [JetBrains Academy](https://hyperskill.org).
###### [Link](https://hyperskill.org/learn/step/2221) to the problem challenge.

### Task description:

Snail creeps up the vertical pole of height H feets. Per day it goes A feets up, and per night it goes B feets down.<br />
In which day the snail will reach the top of the pole?

#### Input data format

On the input the program receives non-negative integers H, A, B, where H > B and A > B. Every integer does not exceed 100.

---

Sample Input 1:<br />
10<br />
3<br />
2<br />
Sample Output 1:<br />
**8**<br />

---

Sample Input 2:<br />
20<br />
7<br />
3<br />
Sample Output 2:<br />
**5**<br />

---

### Solution:

To solve this task we need to write and solve a simple Linear equation.<br />

Let's make a Linear equation form task description:<br />
![equation](https://latex.codecogs.com/gif.latex?whichDay%20%5Ctimes%20%5Cleft%20%28dayDistance%20-%20nightDistance%5Cright%20%29%20+%20nightDistance%20%3D%20distance)<br />
Explanation:<br />
This linear equation says: by how many days do we need to multiply the distance the snail travels in 24 hours, not counting the last night.<br />
So the ![equation](https://latex.codecogs.com/gif.latex?+%20nightDistance) is about not counting the last night.

---

Lets's solve this Linear equation with floating point precision:<br />
![equation](https://latex.codecogs.com/gif.latex?whichDay%20%3D%20%5Cfrac%7Bdistance%20-%20nightDistance%7D%7BdayDistance%20-%20nightDistance%7D)

---

Lets's solve this Linear equation with integer precision:<br />
![equation](https://latex.codecogs.com/gif.latex?whichDay%20%3D%20%5Cfrac%7Bdistance%20-%20nightDistance%20-1%20%7D%7BdayDistance%20-%20nightDistance%7D%20+%201)<br />
Explanation:<br />
The ![equation](https://latex.codecogs.com/gif.latex?-%201) and ![equation](https://latex.codecogs.com/gif.latex?+%201) here are fixing the integer division truncation in Java.<br />
If in Java we divide integers without remainder (let's say 6 / 3) then after division we are ok.<br />
But if we have a remainder (let's say 10 / 3), then we have lost the fractional part and the integer part is less then the minimum possible integer by 1.<br />

---

What I mean by "minimum possible integer"?<br />
   Imagine that this division examples are lever scales.<br />
   On one bowl of scales there is 10 kg.<br />
   You have many weights for scales (3 kg each).<br />
   What's the minimum possible number of weights (3 kg each) you need to balance or outweight the 10kg bowl?<br />
   Same question in the situation if on one bowl of scales there is 6 kg.<br />

---

So now the trick:<br />
If we ![equation](https://latex.codecogs.com/gif.latex?-%201) from both numerators:<br />
![equation](https://latex.codecogs.com/gif.latex?%5Cfrac%7B10%7D%7B3%7D%20%5Crightarrow%20%5Cfrac%7B10%20-%201%7D%7B3%7D%20%3D%203) <br />
![equation](https://latex.codecogs.com/gif.latex?%5Cfrac%7B6%7D%7B3%7D%20%5Crightarrow%20%5Cfrac%7B6%20-%201%7D%7B3%7D%20%3D%201) <br />
then we get both answers less then the minimum possible integer by 1.<br />
And here comes the ![equation](https://latex.codecogs.com/gif.latex?+%201), which fixes both answers.
