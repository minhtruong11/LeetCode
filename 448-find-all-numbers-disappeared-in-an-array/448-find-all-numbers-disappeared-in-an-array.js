/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDisappearedNumbers = function(nums) {
    var set = new Set(nums);
    var lowestNum = 1
    var highestNum = nums.length
    var notAppeared = []
    for(var num = lowestNum; num <= highestNum; num++){
        if(!set.has(num)) notAppeared.push(num)
    }
    return notAppeared
};