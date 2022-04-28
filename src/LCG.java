public class LCG {
        long a,b,m;
        long start;

        LCG(long startwert){
            this.a = 15;
            this.b = 759;
            this.m = 146;
            setStartwert(startwert);
        }
        void setStartwert(long startwert){
            this.start = startwert;
        }
        long nextRandom(){
            start = (a * start + b) % m;
            System.out.println("aktuelles x: " + start );
            return start;
        }


    public static void main(String[] args) {
        LCG lcg = new LCG(471);
        lcg.nextRandom();
        lcg.nextRandom();
        lcg.nextRandom();
    }
}
