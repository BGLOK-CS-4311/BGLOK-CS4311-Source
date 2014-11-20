/**
 * 
 */
package Reports;

import DataRepository.Database_Accesser;

/**
 * @author jvasquez9
 * NOTE: Protocols are not clear on this
 * class so I will have to fix them in order to get the system working properlu --john
 */
public abstract class Reports {

	/**
	 * 
	 * @param reportType
	 * @param startDate
	 * @param endDate
	 */
	public void displayReport(String reportType, String startDate, String endDate){
	//need to create an object for the db accessor class
		Database_Accesser dbaccess = new Database_Accesser();
		//results for the db query results
		String results;
		//this will call the database, pass in values that we need
		//for the query, and return it as a string
		results = dbaccess.get("report", reportType, startDate, endDate);
		System.out.println(results + "\n");
		//getting the results, printing it; will change once
		//jar has been implemented --john
	}//end display report
	
	/**
	 * 
	 * @param r
	 */
	private void getReportInfo(Report r){
		
		return r;
	}
	
	/**
	 * 
	 */
	private void knowDateInterval(Report r){
		
	}
}
