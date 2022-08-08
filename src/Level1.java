public class Level1 {
    public static String BigMinus(String s1, String s2) {
        char[] chMin = s1.toCharArray();
        char[] chMax = s2.toCharArray();

        if (s1.length() > s2.length()) {
            chMin = s2.toCharArray();
            chMax = s1.toCharArray();
        }

        int x = 0;
        while (s1.length() == s2.length()) {
            if (s1.charAt(x) == s2.charAt(x)) {
                x++;
            } else if (s1.charAt(x) > s2.charAt(x)) {
                chMax = s1.toCharArray();
                chMin = s2.toCharArray();
                break;
            } else {
                break;
            }

            if (x == s1.length()) {
                return String.valueOf(0);
            }
        }

        int minLen = chMin.length;
        int maxLen = chMax.length;

        for (int i = 0; i < minLen; i++) {

        }



        return "lol";


    }
    public static void main(String[] args) {
        String str1 = "12345678";
        String str2 = "1234678";

        System.out.println(BigMinus(str1, str2));
    }
}
