public class test {
    public static void main(String[] args) {
        String[] temp = {"0", "1"};
        String[] y;

        y = temp;
        temp = new String[3];

        for (int i = 0; i < y.length; i++) {
            temp[i] = y[i];
        }

        temp[2] = "3";

        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }

    } 
}  