import java.util.Random;

public class Main {
    public static void main(String[] args) {
        vypis("Programovani 3");
        vypis(najdiZpravu(456));
    }

    public static void vypis (String zprava) {
        System.out.println("msg{" + zprava + "} = " + spocitejHodnotu(zprava));
    }

    public static int spocitejHodnotu(String zprava) {
        int x = 0;

        for (int i = 0; i < zprava.length(); i++) {
            x += (int) zprava.charAt(i);
        }

        return (x*(x + 3)) % 1013;
    }

    public static String najdiZpravu(int x) {
        String zprava = "";
        Random random = new Random();

        for(long i = 0;;i++) {
            if(spocitejHodnotu(zprava) == x) {
                if (zprava.length() > 3) {
                    zprava = "";
                } else {
                    break;
                }
            } else {
                zprava += (char) random.nextInt(65, 122);
            }
            if(i % 1000000 == 0) {
                System.out.println("mil.");
            }
        }

        return zprava;
    }
}