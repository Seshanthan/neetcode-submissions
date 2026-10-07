class Solution {
    public int leastInterval(char[] tasks, int n) {

        // 1. Count frequency of each task
        HashMap<Character, Integer> map = new HashMap<>();

        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        // 2. Max Heap → task with highest frequency comes first
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int frequency : map.values()) {
            pq.offer(frequency);
        }

        int time = 0;

        // 3. Process tasks in groups of n + 1
        while (!pq.isEmpty()) {

            int slots = n + 1;
            List<Integer> remaining = new ArrayList<>();

            // Fill this cycle
            while (slots > 0 && !pq.isEmpty()) {

                int frequency = pq.poll();

                // Execute this task once
                frequency--;

                // Task still has remaining executions
                if (frequency > 0) {
                    remaining.add(frequency);
                }

                slots--;
                time++;
            }

            // Put remaining tasks back into heap
            for (int frequency : remaining) {
                pq.offer(frequency);
            }

            // If tasks are still remaining,
            // unused slots become idle time.
            if (!pq.isEmpty()) {
                time += slots;
            }
        }

        return time;
    }
}