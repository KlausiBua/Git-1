import java.util.Arrays;

public class EratosthenesPrimeSieve implements PrimeSieve{
    private int upperlimit;
    private boolean[] primes;

    public EratosthenesPrimeSieve(int upperlimit) {
        this.upperlimit = upperlimit;
        primes = new boolean[upperlimit+1];
    }

    @Override
    public boolean isPrime(int p) {

        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for(int i = 2; i <= Math.sqrt(upperlimit); i++) {
            if(primes[i]) {
                for(int j = i*i; j <= upperlimit; j += i) {
                    primes[j] = false;
                }
            }
        }
        return primes[p];
    }

    @Override
    public void printPrimes() {
        for(int i = 0; i < upperlimit; i++) {
            if(isPrime(i)) {
                System.out.print(i+" | ");
            }
        }
    }
}
