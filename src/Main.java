import java.io.IOException;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
	LCG lcg = new LCG(471);
	HashSet<Integer> zufallszahlen = new HashSet<>();
	lcg.nextRandom();
    lcg.nextRandom();

        for (int i = 0; i <= 255; i++) {
            zufallszahlen.add(Integer.parseInt( Long.toBinaryString(lcg.nextRandom() & 0xff),2));
        }

        System.out.println("length: " + zufallszahlen.size());
        HC1 hc1 = new HC1();
        try {
            hc1.writeData(23);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
