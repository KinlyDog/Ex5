public class Level1 {
    public static String BigMinus(String s1, String s2) {
        final int S1_LENGTH = s1.length();
        final int S2_LENGTH = s2.length();
        final int MAX_LENGTH = Math.max(S1_LENGTH, S2_LENGTH);

        int[] number1 = new int[MAX_LENGTH];
        int[] number2 = new int[MAX_LENGTH];

        int[] smallerNumber = new int[MAX_LENGTH];
        int[] biggerNumber = new int[MAX_LENGTH];

        // переводим строки в массив целых чисел
        for (int i = 0; i < S1_LENGTH; i++) {
            number1[i] = s1.charAt(S1_LENGTH - 1 - i) - '0';
        }

        for (int i = 0; i < S2_LENGTH; i++) {
            number2[i] = s2.charAt(S2_LENGTH - 1 - i) - '0';
        }

        if (S1_LENGTH > S2_LENGTH) {
            smallerNumber = number2;
            biggerNumber = number1;
        }

        if (S1_LENGTH < S2_LENGTH) {
            smallerNumber = number1;
            biggerNumber = number2;
        }

        // определяем какое из двух чисел больше
        int x = S1_LENGTH - 1;
        while (S1_LENGTH == S2_LENGTH) {
            if (number1[x] == number2[x]) {
                x--;
            } else if (number1[x] > number2[x]) {
                biggerNumber = number1;
                smallerNumber = number2;
                break;
            } else {
                biggerNumber = number2;
                smallerNumber = number1;
                break;
            }

            if (x == -1) {
                return String.valueOf(0);
            }
        }

        // производим вычитание меньшего из большего
        for (int i = 0; i < MAX_LENGTH; i++) {
            if (biggerNumber[i] < smallerNumber[i]) {
                biggerNumber[i] += 10;
                biggerNumber[i + 1]--;
            }

            biggerNumber[i] -= smallerNumber[i];
        }

        // считаем количество нулей в начале числа,
        // чтобы игнорировать их при конвертации в строку
        int y = 0;
        while (biggerNumber[MAX_LENGTH - 1 - y] == 0) {
            y++;
        }

        StringBuilder stringFromNumber = new StringBuilder();
        for (int i = MAX_LENGTH - 1 - y; i >= 0; i--) {
            stringFromNumber.append(biggerNumber[i]);
        }

        return stringFromNumber.toString();
    }
}
