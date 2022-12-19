public class Level1 {
    public static String BigMinus(String s1, String s2) {
        final int S1_LENGTH = s1.length();
        final int S2_LENGTH = s2.length();
        final int MAX_LENGTH;

        if (S1_LENGTH >= S2_LENGTH) {
            MAX_LENGTH = S1_LENGTH;
        } else {
            MAX_LENGTH = S2_LENGTH;
        }

        int[] arrayInteger1 = new int[MAX_LENGTH];
        int[] arrayInteger2 = new int[MAX_LENGTH];

        int[] smallerNumber = new int[MAX_LENGTH];
        int[] biggerNumber = new int[MAX_LENGTH];

        for (int i = 0; i < S1_LENGTH; i++) {
            arrayInteger1[i] = s1.charAt(S1_LENGTH - 1 - i) - '0';
        }

        for (int i = 0; i < S2_LENGTH; i++) {
            arrayInteger2[i] = s2.charAt(S2_LENGTH - 1 - i) - '0';
        }

        if (S1_LENGTH > S2_LENGTH) {
            smallerNumber = arrayInteger2;
            biggerNumber = arrayInteger1;
        } else if (S1_LENGTH < S2_LENGTH) {
            smallerNumber = arrayInteger1;
            biggerNumber = arrayInteger2;
        }

        int x = S1_LENGTH - 1;
        while (S1_LENGTH == S2_LENGTH) {
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

        arrayInteger1 = null;
        arrayInteger2 = null;

        for (int i = 0; i < MAX_LENGTH; i++) {
            if (biggerNumber[i] < smallerNumber[i]) {
                biggerNumber[i] += 10;
                biggerNumber[i + 1]--;
            }

            biggerNumber[i] -= smallerNumber[i];
        }
        smallerNumber = null;

        int y = 0;
        while (biggerNumber[MAX_LENGTH - 1 - y] == 0) {
            y++;
        }

        StringBuilder bld = new StringBuilder();
        for (int i = MAX_LENGTH - 1 - y; i >= 0; i--) {
            bld.append(biggerNumber[i]);
        }
        biggerNumber = null;

        return bld.toString();
    }
}
