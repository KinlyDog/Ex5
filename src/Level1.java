public class Level1 {
    public static String BigMinus(String s1, String s2) {
        int s1len = s1.length();
        int s2len = s2.length();
        int len;

        if (s1len >= s2len) {
            len = s1len;
        } else {
            len = s2len;
        }

        int[] arrayInteger1 = new int[len];
        int[] arrayInteger2 = new int[len];

        int[] min = new int[len];
        int[] max = new int[len];

        for (int i = 0; i < s1len; i++) {
            arrayInteger1[i] = s1.charAt(s1len - 1 - i) - '0';
        }

        for (int i = 0; i < s2len; i++) {
            arrayInteger2[i] = s2.charAt(s2len - 1 - i) - '0';
        }

        if (s1len > s2len) {
            min = arrayInteger2;
            max = arrayInteger1;
        } else if (s1len < s2len) {
            min = arrayInteger1;
            max = arrayInteger2;
        }

        int x = s1len - 1;
        while (s1len == s2len) {
            if (arrayInteger1[x] == arrayInteger2[x]) {
                x--;
            } else if (arrayInteger1[x] > arrayInteger2[x]) {
                max = arrayInteger1;
                min = arrayInteger2;
                break;
            } else {
                max = arrayInteger2;
                min = arrayInteger1;
                break;
            }

            if (x == -1) {
                return String.valueOf(0);
            }
        }

        for (int i = 0; i < len; i++) {
            if (max[i] < min[i]) {
                max[i] += 10;
                max[i + 1]--;
            }

            max[i] -= min[i];
        }

        int y = 0;
        while (max[len - 1 - y] == 0) {
            y++;
        }

        StringBuilder bld = new StringBuilder();
        for (int i = len - 1 - y; i >= 0; i--) {
            bld.append(max[i]);
        }

        return bld.toString();
    }
}
