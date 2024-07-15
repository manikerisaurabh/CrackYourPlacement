public class Integer_to_Roman {
    class Solution {
        public String intToRoman(int num) {

            int[] intVal = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
            String[] strVal = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };

            String str = "";
            for (int i = intVal.length - 1; i >= 0; i--) {
                while (num >= intVal[i]) {
                    str = str + strVal[i];
                    num = num - intVal[i];
                }
            }

            return str;
        }

    }
}
