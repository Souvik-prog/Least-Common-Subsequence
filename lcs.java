import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        int m = s1.length();
        int n = s2.length();
        int memo[] = new int[n+1];
        for(int i=1;i<=m;i++)
        {
            int lcs = 0;
            for(int j=1;j<=n;j++)
            {
                int temp = memo[j];
                if(x[i-1] == y[j-1])
                    memo[j] = lcs+1;
                else 
                    memo[j] = Math.max(memo[j],memo[j-1]);
                lcs = temp;
            }
        }
        return memo[n];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);
        
        System.out.println(result);

       // bufferedWriter.write(String.valueOf(result));
       // bufferedWriter.newLine();

       //bufferedWriter.close();

       // scanner.close();
    }
}
