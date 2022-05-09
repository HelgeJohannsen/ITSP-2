import java.io.*;

public class TripleDES {
    DES des1;
    DES des2;
    DES des3;
    /* Constructor */
   public TripleDES (byte[] keyPart1, byte[] keyPart2, byte[] keyPart3) {
      /* key-length: 24 Byte, each keyPart must be of length 8 Byte */

    des1 = new DES(keyPart1);
    des2 = new DES(keyPart2);
    des3 = new DES(keyPart3);
   }
   
   /* encrypt plaintext block  */
   public byte[] encryptBytes (byte[] plaintextBytes){
    byte[] z1 = new byte[8];
    byte[] z2 = new byte[8];
    byte[] c = new byte[8];
   des1.encrypt(plaintextBytes,0,z1,0);
   des2.decrypt(z1,0,z2,0);
   des3.encrypt(z2,0,c,0);
   return c;
   }
   
  /* decrypt plaintext block  */
   public byte[] decryptBytes (byte[] chiffreBytes){
       byte[] z1 = new byte[8];
       byte[] z2 = new byte[8];
       byte[] m = new byte[8];
       des3.decrypt(chiffreBytes,0,z1,0);
       des2.encrypt(z1,0,z2,0);
       des1.decrypt(z2,0,m,0);
       return m;
   }
   
	private String byteArraytoHexString(byte[] byteArray) {
		String ret = "";
		for (int i = 0; i < byteArray.length; ++i) {
			ret = ret + String.format("%02x", byteArray[i]) + " ";
		}
		return ret;
	}
	
	public static void main(String[] args) {
      /* Testcode */
		TripleDES cipher = new TripleDES("qwertzui".getBytes(), "asdfghjk".getBytes(), "yxcvbnm,".getBytes());
      
      byte[] plain = "12345678".getBytes();
      byte[] chiffre = cipher.encryptBytes(plain);
      System.out.println(" Encrypted: " +  cipher.byteArraytoHexString(plain) + " to: " + cipher.byteArraytoHexString(chiffre));
      
      byte[] plainNew = cipher.decryptBytes(chiffre);
      System.out.println(" Decrypted: " + cipher.byteArraytoHexString(plainNew) );
      
      if (java.util.Arrays.equals(plain, plainNew)) {
         System.out.println(" ---> Erfolg!");
      } else {
         System.out.println(" ---> Hat leider noch nicht funktioniert ...!");
      }
	}
}
