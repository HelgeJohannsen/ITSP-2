import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
	LCG lcg = new LCG(471);
	long[] randoms = new long[256];
	HashSet<Integer> zufallszahlen = new HashSet<>();
	lcg.nextRandom();
    lcg.nextRandom();

        for (int i = 0; i < 255; i++) {
        //    randoms[i] = lcg.nextRandom();
            zufallszahlen.add(Integer.parseInt( Long.toBinaryString(lcg.nextRandom() & 0xff),2));
        }
        for (int i = 0; i < 255; i++) {
     //       System.out.print(Long.toBinaryString(randoms[i]) + " ");

        }
        System.out.println("length" + zufallszahlen.size());
        long testLong = 542131418;
        System.out.println("");
      //  lcg.lastByte(Long.toBinaryString(testLong));
        System.out.println(Long.toBinaryString(randoms[2]));
        System.out.println(Long.toBinaryString(randoms[2] & 0xff));
        System.out.println(Integer.parseInt( Long.toBinaryString(randoms[2] & 0xff),2));
        System.out.println(Long.toHexString(randoms[2] & 0xff));
    }
}
