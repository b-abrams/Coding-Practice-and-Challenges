import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Rails {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int N = 0;
        while ((line = br.readLine()) != null) {
            if (line.length() == 1) {
                if (line.equals("0") && N == 0) {
                    System.exit(0);
                }
                if (!line.equals("0") && N == 1) {
                    System.out.println("Yes");
                }
                N = Integer.parseInt(line);
            } else {
                String[] output = line.split(" ");
                Stack<Integer> tracks = new Stack<Integer>();
                int counter = 0;
                for (int i = 1; i <= N; i++) {
                    tracks.push(i);

                    while (!tracks.empty() && (tracks.peek() == Integer.parseInt(output[counter]))) {
                        tracks.pop();
                        counter++;
                    }
                }

                if (tracks.empty()) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }

            }

        }
    }
}