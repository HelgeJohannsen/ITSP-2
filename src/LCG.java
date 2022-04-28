public class LCG {
        long a,b,m;
        long x;

        LCG(long startwert){
            this.a = 16598013;
            this.b = 12820163;
            this.m = 16777216;
            setStartwert(startwert);
        }
        void setStartwert(long startwert){
            this.x = startwert;
        }
        long nextRandom(){
            x = (a * x + b) % m;
            System.out.println("aktuelles x: " + x);
            return x;
        }


    public static void main(String[] args) {
        LCG lcg = new LCG(471);
        lcg.nextRandom();
        lcg.nextRandom();
        lcg.nextRandom();
    }
}
