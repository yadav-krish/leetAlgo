// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_set<int> uniq;
        for (int i : nums) {
            if (uniq.find(i) != uniq.end())
                return true;
            else
                uniq.insert(i);
        }
        return false;
    }
};
