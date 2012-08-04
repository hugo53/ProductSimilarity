import hd.bestbuy.crawler.ProcessData;
import hd.product.Laptop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	// Threshsol for 18 attributes
	public static int[] threshold = { 0, 2, 1, 1, 1, 1, 1, 2, 1, 1, 3, 3, 3, 1,
			1, 2, 1, 1 };
	// features weight
	public static double[] featureWeights = { 0, 8, 10, 10, 10, 8, 5, 4, 8, 4,
			4, 2, 8, 10, 10, 6, 5, 5 };

	public static Laptop readLaptop(String str) {
		String[] array = str.split(",");

		ProcessData tmp = new ProcessData();
		Laptop rst = new Laptop(tmp.removeStopwords(array[0]),
				tmp.removeStopwords(array[1]), tmp.removeStopwords(array[2]),
				tmp.removeStopwords(array[3]), tmp.removeStopwords(array[4]),
				tmp.removeStopwords(array[5]), tmp.removeStopwords(array[6]),
				tmp.removeStopwords(array[7]), tmp.removeStopwords(array[8]),
				tmp.removeStopwords(array[9]), tmp.removeStopwords(array[10]),
				tmp.removeStopwords(array[11]), tmp.removeStopwords(array[12]),
				tmp.removeStopwords(array[13]), tmp.removeStopwords(array[14]),
				tmp.removeStopwords(array[15]), tmp.removeStopwords(array[16]),
				tmp.removeStopwords(array[17]));

		/*
		 * Laptop rst = new Laptop(array[0], array[1], array[2], array[3],
		 * array[4], array[5], array[6], array[7], array[8], array[9],
		 * array[10], array[11], array[12], array[13], array[14], array[15],
		 * array[16], array[17]);
		 */
		return rst;
	}

	public static Laptop[] read(File file) throws FileNotFoundException {
		Scanner in = new Scanner(file);
		Laptop[] rst = new Laptop[4];
		int i = 0;
		while (in.hasNext()) {
			String line = in.nextLine();
			rst[i] = readLaptop(line);
			i++;
		}
		return rst;

	}

	/**
	 * @param argsProcessData
	 *            .removeStopwords(array[1]),
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		File f = new File("data/listOfProductscvs1.csv");
		Laptop[] rst = read(f);
		System.out.println(rst[2].similarTo(rst[3], threshold, featureWeights));

		// System.out.println("title" + rst[0].getTitle());
	}
}
