public class Level1 {
    public static String BigMinus(String s1, String s2) {
        int len;

        if (s1.length() >= s2.length()) {
            len = s1.length();
        } else {
            len = s2.length();
        }

        int s1len = s1.length();
        int s2len = s2.length();

        int[] tmp1 = new int[len];
        int[] tmp2 = new int[len];

        int[] min = new int[len];
        int[] max = new int[len];

        for (int i = 0; i < s1len; i++) {
            tmp1[i] = s1.charAt(s1len - 1 - i) - '0';
        }

        for (int i = 0; i < s2len; i++) {
            tmp2[i] = s2.charAt(s2len - 1 - i) - '0';
        }

        if (s1len > s2len) {
            min = tmp2;
            max = tmp1;
        } else if (s1len < s2len) {
            min = tmp1;
            max = tmp2;
        }

        int x = s1len - 1;
        while (s1len == s2len) {
            if (tmp1[x] == tmp2[x]) {
                x--;
            } else if (tmp1[x] > tmp2[x]) {
                max = tmp1;
                min = tmp2;
                break;
            } else {
                max = tmp2;
                min = tmp1;
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
