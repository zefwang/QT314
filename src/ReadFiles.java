import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadFiles {
	public static void main(String[] args) {
		String csvFile = "testFile.csv"; //Change file name for specific file
		BufferedReader in = null;
		String line = "";
		String cvsSplitBy = ",";
		int currentLine = 0;
		final int MAX_LINES = 10;
		String[][] allLines = new String[MAX_LINES][];

		try {
			in = new BufferedReader(new FileReader(csvFile));

			while ((line = in.readLine()) != null && currentLine < MAX_LINES) {
				String[] headings = line.split(cvsSplitBy);
				System.out.println(Arrays.deepToString(headings));
				allLines[currentLine] = headings;
				currentLine++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		Arrays.deepToString(allLines);
	}
}
