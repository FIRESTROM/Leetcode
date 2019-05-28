class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        //先建一个workers数组，根据`wage/quality`这个ratio排序
        //开始按ratio升序选K个工人，把他们的`quality`存入一个max heap，并将所有quality累加到temp
        //当人数达到K时，计算总工资: temp * ratio 注意此ratio是当前最大的ratio
        //继续选择，把堆中最大的quality取出，并从temp中减掉，temp加上新的quality，再乘新的ratio，得到新的total
        //若新的total小于之前的，更新total
        int num = quality.length;
        double[][] workers = new double[num][2];
        for (int i = 0; i < num; i++) {
            //workers[i] = {(工资/绩效)比值, 绩效}
            workers[i] = new double[]{(double) wage[i] / quality[i], (double) quality[i]};
        }
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        PriorityQueue<Double> heap = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        double total = Double.MAX_VALUE, temp = 0;
        for (double[] worker: workers) {
            temp += worker[1];
            heap.add(worker[1]);
            if (heap.size() > K) temp -= heap.poll();
            if (heap.size() == K) total = Math.min(total, temp * worker[0]);
        }
        return total;
    }
}
