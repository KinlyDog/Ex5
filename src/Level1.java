public class Level1 {
    public static String BigMinus(String s1, String s2) {
        int s1len = s1.length();
        int s2len = s2.length();
        int maxNumLen;

        if (s1len >= s2len) {
            maxNumLen = s1len;
        } else {
            maxNumLen = s2len;
        }

        int[] arrayInteger1 = new int[maxNumLen];
        int[] arrayInteger2 = new int[maxNumLen];

        int[] smallerNumber = new int[maxNumLen];
        int[] biggerNumber = new int[maxNumLen];

        for (int i = 0; i < s1len; i++) {
            arrayInteger1[i] = s1.charAt(s1len - 1 - i) - '0';
        }

        for (int i = 0; i < s2len; i++) {
            arrayInteger2[i] = s2.charAt(s2len - 1 - i) - '0';
        }

        if (s1len > s2len) {
            smallerNumber = arrayInteger2;
            biggerNumber = arrayInteger1;
        } else if (s1len < s2len) {
            smallerNumber = arrayInteger1;
            biggerNumber = arrayInteger2;
        }

        int x = s1len - 1;
        while (s1len == s2len) {
            if (arrayInteger1[x] == arrayInteger2[x]) {
                x--;
            } else if (arrayInteger1[x] > arrayInteger2[x]) {
                biggerNumber = arrayInteger1;
                smallerNumber = arrayInteger2;
                break;
            } else {
                biggerNumber = arrayInteger2;
                smallerNumber = arrayInteger1;
                break;
            }

            if (x == -1) {
                return String.valueOf(0);
            }
        }

        for (int i = 0; i < maxNumLen; i++) {
            if (biggerNumber[i] < smallerNumber[i]) {
                biggerNumber[i] += 10;
                biggerNumber[i + 1]--;
            }

            biggerNumber[i] -= smallerNumber[i];
        }

        int y = 0;
        while (biggerNumber[maxNumLen - 1 - y] == 0) {
            y++;
        }

        StringBuilder bld = new StringBuilder();
        for (int i = maxNumLen - 1 - y; i >= 0; i--) {
            bld.append(biggerNumber[i]);
        }

        return bld.toString();
    }
}
