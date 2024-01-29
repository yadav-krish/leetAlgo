# using unordered_set and functions like find() and insert()
 The find function in an std::unordered_set in C++ does not have a time complexity of O(n).
 The average-case time complexity of the find operation in an unordered set is O(1), which means it's constant time on average.

The std::unordered_set in C++ is typically implemented as a hash table, and the find operation involves calculating the hash of the element and checking the corresponding bucket for the presence of the element.
In the average case, this operation takes constant time, making it efficient.

It's important to note that while the average-case time complexity is O(1), the worst-case time complexity for a single find operation in an unordered set is O(n), where n is the number of elements in the set.
However, this worst case is rare and occurs when there are hash collisions that lead to a linear search in the bucket.
In practice, the unordered set is designed to minimize collisions, providing efficient average-case performance.
