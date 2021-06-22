import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountPrimes {

    public int countPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] tmp = new boolean[n];
        Arrays.fill(tmp, true);
        for(int i = 2; i < n; i++){
            if(tmp[i]){
                primes.add(i);
            }
            for(int j = 0; j < primes.size() && i * primes.get(j) < n; j++){
                tmp[i * primes.get(j)] = false;
                if(i % primes.get(j) == 0){
                    break;
                }
            }
        }
        return primes.size();
    }


    public int countPrimes2(int n) {
        int count = 0;
        for(int i = 2; i < n; i++){
            count += isPrime(i);
        }
        return count;
    }

    private int isPrime(int n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return 0;
            }
        }
        return 1;
    }
}
