// There is only one row of fruit trees on the farm, oriented left to right. An integer array called fruits represents the trees, where fruits[i] denotes the kind of fruit produced by the ith tree.

// The goal is to gather as much fruit as possible, adhering to the owner's stringent rules:

// 1) There are two baskets available, and each basket can only contain one kind of fruit. The quantity of fruit each basket can contain is unlimited.

// 2) Start at any tree, but as you proceed to the right, select exactly one fruit from each tree, including the starting tree. One of the baskets must hold the harvested fruits.

// 3) Once reaching a tree with fruit that cannot fit into any basket, stop.

// Return the maximum number of fruits that can be picked.

// Examples:
// Input : fruits = [1, 2, 1]

// Output : 3

// Explanation : We will start from first tree.

// The first tree produces the fruit of kind '1' and we will put that in the first basket.

// The second tree produces the fruit of kind '2' and we will put that in the second basket.

// The third tree produces the fruit of kind '1' and we have first basket that is already holding fruit of kind '1'. So we will put it in first basket.

// Hence we were able to collect total of 3 fruits.

// Input : fruits = [1, 2, 3, 2, 2]

// Output : 4

// Explanation : we will start from second tree.

// The first basket contains fruits from second , fourth and fifth.

// The second basket will contain fruit from third tree.

// Hence we collected total of 4 fruits.

class Solution {
  public int totalFruits(int[] fruits) {
    int maxi = 0;
    Map<Integer, Integer> basket = new HashMap<>();
    int s=0;
    for(int i=0;i<fruits.length;i++)
    {
      if(basket.size()>2)
      {
        basket.put(fruits[s],basket.get(fruits[s])-1);
        if(basket.get(fruits[s])==0)
        basket.remove(fruits[s]);
        s++;
      }
      basket.put(fruits[i],basket.getOrDefault(fruits[i],0)+1); // add this initially only then perform operation
      if(basket.size()<=2)
      maxi=Math.max(maxi,i-s+1);
    }
    return maxi;
  }
}
