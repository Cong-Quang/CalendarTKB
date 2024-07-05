package tkb;

public class Console extends Color {
    static final String ANSI_ESC = "\033[";
    public static void print(String s,int row, int col) {
        System.out.print(ANSI_ESC + row + ";" + col + "H" + s + ANSI_ESC + "0m");
    }
}
