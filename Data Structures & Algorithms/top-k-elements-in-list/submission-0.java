

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: count frequency of each number
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: bucket sort by frequency
        // bucket[i] = list of numbers that appear exactly i times
        List<Integer>[] bucket = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }

        // Step 3: walk buckets from highest frequency down, collect k elements
        int[] result = new int[k];
        int index = 0;
        for (int freq = bucket.length - 1; freq >= 0 && index < k; freq--) {
            if (bucket[freq] == null) continue;
            for (int num : bucket[freq]) {
                result[index++] = num;
                if (index == k) break;
            }
        }

        return result;
    }
}
