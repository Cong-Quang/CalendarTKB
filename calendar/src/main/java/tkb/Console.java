package tkb;

public class Console extends Color {

    static final String ANSI_ESC = "\033[";

    public static void print(String s,int row, int col) {
        System.out.print(ANSI_ESC + row + ";" + col + "H" + s + ANSI_ESC + "0m");
        Color.reset();
    }

    public static void loader(int total) throws InterruptedException {
        char[] loaderChars = {'|', '/', '-', '\\'};
        for (int i = 0; i < total; i++) {
            System.out.print("\r" + randomColor() + loaderChars[i % loaderChars.length]);

            // Giả lập công việc với sleep
            Thread.sleep(100);
        }
        System.out.print("\r" + cGreen + " Xong!\n");
        reset();
    }

    public static void loader2(int total) throws InterruptedException {
        
        for (int i = 0; i <= total; i++) {
            printProgressBar(i, total);

            // Giả lập công việc với sleep
            Thread.sleep(100);
        }
        System.out.println(cRed + " [Hoàn thành] ");
        Color.reset();
    }
    private static void printProgressBar(int current, int total) {
        int barLength = 100; 
        int progress = (int) ((double) current / total * barLength);
        StringBuilder bar = new StringBuilder("[");

        // Tạo phần thanh tiến trình đã hoàn thành
        for (int i = 0; i < progress; i++) {
            bar.append("=");
            
        }
        // Tạo mũi tên chỉ thị vị trí hiện tại
        if (progress < barLength) {
            bar.append("->");
        }
        // Tạo phần thanh tiến trình chưa hoàn thành
        for (int i = progress + 1; i < barLength; i++) {
            bar.append(" ");
        }
        bar.append("]");

        // Tính toán phần trăm hoàn thành
        int percent = (int) ((double) current / total * 100);
        System.out.print("\r[" + percent + "%]" + bar.toString());
    }
}
