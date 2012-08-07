import hd.bestbuy.crawler.ProcessData;
import hd.product.Laptop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

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

		return rst;
	}

	public static Laptop[] read(File file) throws FileNotFoundException {
		/*/Scanner in = new Scanner(file);
		Laptop[] rst = new Laptop[4];
		int i = 0;
		while (in.hasNext()) {
			String line = in.nextLine();
			rst[i] = readLaptop(line);
			i++;
		}
		in.close();
		return rst;
		*/
		
		Laptop[] rst = new Laptop[4];
		int i = 0;
		try {
		      FileReader fr = new FileReader(file);
		      BufferedReader br = new BufferedReader(fr);

		      String s;
		      while((s = br.readLine()) != null){
		    	  rst[i] = readLaptop(s);
				  i++;
		      }
		        

		      fr.close();
		    }
		    catch(Exception e) {
		      System.out.println("Exception: " + e);
		    }
		return rst;
	}

	/**
	 * @param argsProcessData
	 *            .removeStopwords(array[1]),
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		File infile = new File("data/input.csv");
		File outfile = new File("data/output");
		PrintWriter out = new PrintWriter(outfile);

		Laptop[] rst = read(infile);
			for (int i = 0; i < rst.length; i++) {
				for (int j = 0; j < rst.length; j++) {
					//System.out.println(rst[i] +" "+rst[j] );
					out.println("Simi(" + i + " , " + j + ") = "
							+ rst[i].similarTo(rst[j], threshold, featureWeights));
				}
			}
		System.out.println("DONE!\nPLEASE CHECK data/output file");
		out.close();

	}
}
