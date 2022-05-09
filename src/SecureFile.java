import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecureFile {
    byte[] key1 = new byte[8];
    byte[] key2 = new byte[8];
    byte[] key3 = new byte[8];
    byte[] iv = new byte[8];

    TripleDES tripleDES;

    SecureFile(String keypath){
        try {
            readKeys(keypath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        tripleDES = new TripleDES(key1,key2,key3);
    }

    public void encrypt(String inPath, String outPath) throws IOException{
        FileOutputStream out = new FileOutputStream(outPath);
        FileInputStream in = new FileInputStream(inPath);
        byte[] buffer = new byte[8];

        byte[] currentIV = iv;
        int len;

        while (( len = in.read(buffer)) > 0) {
            byte[] currentC = new byte[8];
            for (int i = 0; i < 8; i++) {
                currentC[i] = (byte) ( tripleDES.encryptBytes(currentIV)[i] ^ buffer[i]);
            }

            out.write(currentC, 0, len);

            currentIV = currentC;
        }

    }

    public void decrypt(String inPath, String outPath) throws IOException {
        FileOutputStream out = new FileOutputStream(outPath);
        FileInputStream in = new FileInputStream(inPath);
        byte[] buffer = new byte[8];

        byte[] currentIV = iv;
        int len;

        while (( len = in.read(buffer)) > 0) {
            byte[] currentM = new byte[8];
            for (int i = 0; i < 8; i++) {
                currentM[i] = (byte) ( tripleDES.encryptBytes(currentIV)[i] ^ buffer[i]);
            }

            out.write(currentM, 0, len);
            for (int i = 0; i < 8; i++) {
                currentIV[i] = buffer[i];
            }
            // or
            //System.arraycopy(buffer, 0, currentIV, 0, 8);
        }
    }

    public void readKeys(String keyPath) throws IOException {
        FileInputStream in = new FileInputStream(keyPath);
        byte[] buffer = new byte[8];

        in.read(buffer);
        for (int i = 0; i < 8; i++) {
            key1[i] = buffer[i];
        }
        in.read(buffer);
        for (int i = 0; i < 8; i++) {
            key2[i] = buffer[i];
        }
        in.read(buffer);
        for (int i = 0; i < 8; i++) {
            key3[i] = buffer[i];
        }
        in.read(buffer);
        for (int i = 0; i < 8; i++) {
            iv[i] = buffer[i];
        }

    }

    public static void main(String[] args) {
        try {
            // for some reason SecureFile has to be reinstantiated before every encrypt/decrypt call
            SecureFile sf = new SecureFile("./src/3DESTest.key");
            sf.encrypt("./src/3DESTest.key","./src/3DESTest.keync");
            
            sf = new SecureFile("./src/3DESTest.key");
            sf.decrypt("./src/3DESTest.keync","./src/3DESTest.plain");
            
            sf = new SecureFile("./src/3DESTest.key");
            sf.decrypt("./src/3DESTest.enc","./src/3DESTest.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
