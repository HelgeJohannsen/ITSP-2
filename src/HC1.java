import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class HC1 {

    public void writeData(int startwert) throws IOException {
        FileInputStream in = new FileInputStream("./src/ergebnis.txt");
        FileOutputStream out = new FileOutputStream("./src/ent.txt");
        byte[] buffer = new byte[8];
        int len;
        LCG lcg = new LCG(startwert);

        while ((len = in.read(buffer)) > 0) {
            for (int i = 0; i < 8; i++) {
                buffer[i] = (byte) (buffer[i]  ^ lcg.nextRandom());
            }
            out.write(buffer, 0, len);
        }
    }

}
