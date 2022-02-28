class Solution:
    def minimumTime(self, time: List[int], totalTrips: int) -> int:
      lo = 1   # 1
      hi = min(time) * totalTrips # 45

      def tripsCount(trip_time):  # 34
        res = 0
        for i in range(len(time)):
          res += trip_time//time[i]  # 24 // [5,10,10]  -> [4,2,2] -> 8
        return res

      while lo < hi: # [24,34]
        mid = lo + (hi-lo)//2  # 24
        trip_count = tripsCount(mid) # 8

        print(lo, mid, hi, trip_count)


        # if trip_count == totalTrips:
        #   return mid
        if trip_count >= totalTrips:
          hi = mid
        else:
          lo = mid + 1

      return  lo 