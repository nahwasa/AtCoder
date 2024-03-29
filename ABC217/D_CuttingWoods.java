import java.io.DataInputStream;
import java.io.IOException;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {
        initFI();
        int l = nextInt();
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(0);
        ts.add(l);

        int q = nextInt();
        StringBuilder sb = new StringBuilder();
        while (q-->0) {
            int c = nextInt();
            int x = nextInt();
            if (c == 1) {
                ts.add(x);
            } else {
                int lower = ts.lower(x);
                int higher = ts.higher(x);
                sb.append(higher - lower).append('\n');
            }
        }
        System.out.println(sb);
    }

    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;

    private static void initFI() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }

    private static int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
        return ret;
    }

    private static byte read() throws IOException {
        if (curIdx == maxIdx) {
            maxIdx = inputStream.read(buffer, curIdx = 0, DEFAULT_BUFFER_SIZE);
            if (maxIdx == -1) buffer[0] = -1;
        }
        return buffer[curIdx++];
    }
}
