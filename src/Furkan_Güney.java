import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Furkan_G�ney {
	/**
	 * @param args is the main function
	 * @since Feb. 23, 2019
	 * @author Furkan G�ney - 041801106
	 *
	 */
	public static void main(String[] args) {
		// loads input numbers into the numbers array from the text file
		int[] numbers = loadNumbers("data1.txt");
		// creates frequency array. frequency array stores
		// the frequency of numbers. assume that numbers
		// are in the range of [0..999]. length of frequency
		// array is 1000.
		int[] frequency = computeFrequency(numbers);
		System.out.println("Most Frequent Numbers: ");
		System.out.println("Number: " + frequency[0] + ", " + " Frequency: " + frequency.length);
		// display the most frequent numbers
	}

	/**
	 *
	 * @param filename is our txt file
	 * @return an integer array which gets values from parameter 'filename'
	 */
	public static int[] loadNumbers(String filename) {
		File readFile = new File(filename);
		Scanner reader = null;
		try {
			reader = new Scanner(readFile);
		} catch (FileNotFoundException e) {
			System.out.println(filename + ": Input file can not be found!\nExiting program...");
			System.exit(1);
		}

		int[] numbers = null;
		if (filename.equals("data1.txt")) { // if txt file is data1 initialize numbers array as size of 1000
			numbers = new int[1000];
		}
		if (filename.equals("data2.txt")) { // if txt file is data2 initialize numbers array as size of 500
			numbers = new int[500];
		}
		int counter = 0;
		int counterForLines = 0;
		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			String[] parts = line.split("\n");
			// split the values in the line variable every new line and put inside in the
			// parts array
			numbers[counter] = Integer.parseInt(parts[counterForLines].trim());
			/*
			 * convert string to int and .trim() returns omitted with no leading and
			 * trailing spaces
			 */
			counter++;
		}
		return numbers;

	}

	/**
	 *
	 * @param array
	 * @return array of the most frequent element
	 */
	public static int[] computeFrequency(int[] array) {
		int mostFrequent = 0;
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			int temp = array[i]; //
			int tempCount = 0;
			for (int j = 0; j < array.length; j++) {
				if (array[j] == temp) { // looks elements equailty in the array
					tempCount++;
				}

			}
			if (tempCount > count) {
				mostFrequent = temp;
				count = tempCount;
			}

		}
		int[] frequencyArray = new int[count];
		for (int z = 0; z < frequencyArray.length; z++) {
			frequencyArray[z] = mostFrequent;
		}
		return frequencyArray;

	}
}
