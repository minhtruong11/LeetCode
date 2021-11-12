class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.k = k
        heapq.heapify(nums)
        self.nums = nums
        while len(list(self.nums)) > k:
            heapq.heappop(self.nums)

    def add(self, val: int) -> int:
        heapq.heappush(self.nums, val)
        if len(list(self.nums)) > self.k:
            heapq.heappop(self.nums)
           
        kLargest = heapq.heappop(self.nums)
        heapq.heappush(self.nums, kLargest)
        return kLargest