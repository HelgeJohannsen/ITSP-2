import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class LCG {
        long a,b,m;
        long start;

        LCG(long startwert){
            this.a = 1544897612;
            this.b = 759423244;
            this.m = 1464123068;
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

    String lastByte(String inputByte){

        String s = inputByte;
        String mask = "00000000000000000000000011111111";
        String result = "00000000000000000000000000000000";
        CharacterIterator it = new StringCharacterIterator(s);
        CharacterIterator itM = new StringCharacterIterator(mask);
        System.out.println(s.length());
        System.out.println(result.length());
        while (it.current() != CharacterIterator.DONE)
        {
            char i = it.current();
            char im = itM.current();
            if(i == '1' && im == '1'){
                System.out.print("1");
                result.length();
            }else{
                System.out.print("0");
            }
            it.next();
            itM.next();
        }

            return inputByte;
    }
}
