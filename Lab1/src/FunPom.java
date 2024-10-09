// Bartłomiej Koźluk (oddzielnia klasa z funkcjami pomocnymi)
public class FunPom {
    // Zmienia int'a na tablicę składającą się z cyfr tego int'a
    public static int[] intToArray(int num){
        int[] tab = new int[Integer.toString(num).length()];
        for(int i = 0; num != 0; i++){
            tab[i] = num%10;
            num /= 10;
        }
        return tab;
    }
    // Odwraca tablicę
    public static int[] reverseArray(int[] tab){
        int[] tab2 = new int[tab.length];
        for(int i = 0; i < tab.length; i++)
            tab2[i] = tab[tab.length-1-i];
        return tab2;
    }
    // Zamienia tablicę cyfr w liczbę
    public static int arrayToInt(int[] tab){
        int num = 0;
        for(int i = 0; i < tab.length; i++)
            num += tab[tab.length-1-i] * Math.pow(10, i);
        return num;
    }
    // Odwraca String'a
    static String reverseString(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = str.length()-1; i >= 0; i--)
            sb.append(str.charAt(i));
        return sb.toString();
    }
}
