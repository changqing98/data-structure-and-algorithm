public HammingDistance{
    public int hammingDistance(int x, int y) {
        int result = x ^ y;
        int count = 0;
        while(result != 0){
            count++;
            result = result & (result - 1);
        }
        return count;
    }
}