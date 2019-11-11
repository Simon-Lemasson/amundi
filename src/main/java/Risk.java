import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Risk {
	
	public Double computeRisk(String currentDate, int histDepth, int percentileCoef, String csvFile) {
		
		int rank = histDepth*percentileCoef/100;
		int ind = 0;
		ArrayList<Double> pAndLList = new ArrayList<Double>();
		
		 BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ";";

	        try {

	            br = new BufferedReader(new FileReader(csvFile));
	            while ((line = br.readLine()) != null) {

	                String[] tab = line.split(cvsSplitBy);
	                LocalDate tmpDate = LocalDate.parse(tab[0]);
	                LocalDate limitDate = LocalDate.parse(currentDate).minusDays(new Long(histDepth));
	                
	                if(tmpDate.isAfter(limitDate) && tmpDate.isBefore(LocalDate.parse(currentDate)) || tmpDate.isEqual(limitDate)) {
	                	
	                	pAndLList.add(ind, Double.parseDouble(tab[1]));
	                	ind++;
	                }
	            }
	            
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
		
	    /* Sorting in descending order */
		Collections.sort(pAndLList, Collections.reverseOrder());
		
		return pAndLList.get(rank-1);
	}

//	public static void main(String[] args ) {
//		Scanner sc = new Scanner(System.in);
//		
//		/* Enter the chosen date */
//		System.out.println(" What is the current date ? ");
//		String date = sc.next();
	
//		/* Enter the Historical depth */
//		System.out.println(" Please choose the historical depth : ");
//		int hd = sc.nextInt();
//		System.out.println("Historical depth is : " + hd);
//		
//		/* Enter the percentile coefficient */
//		System.out.println("Specify the percentile coefficient (choose a number between 0 and 100) : ");
//		int pc = sc.nextInt();
//		System.out.println("The percentile coefficient is : " + pc);
//		
//		System.out.println("Paste your CSV file path : ");
//		String csvFile = sc.next();
//		System.out.println("The file is : " + csvFile);
//		
//		/* Compute the N^th percentile */
		
//		Risk r = new Risk();
//		System.out.println("There is a " + pc+ "% risk that the loss will be less than : " + r.computeRisk(date, hd, pc, csvFile));
//	}	
}
