/**
 * 
 */
package Reports;

import DataRepository.Database_Accesser;

/**
 * @author jvasquez9
 * NOTE: Protocols are not clear on this
 * class so I will have to fix them in order to get the system working properly --john
 */



public abstract class Reports {
	Database_Accesser dbaccess = new Database_Accesser();
	
	/**
	 * 
	 * @param reportType
	 * @param startDate
	 * @param endDate
	 */
	public void displayReport(String reportType, String startDate, String endDate){
	//need to create an object for the db accessor class
		
		//results for the db query results
		String results;
	
		String value = startDate + " " + endDate; 
		//this will call the database, pass in values that we need
		//for the query, and return it as a string
		results = dbaccess.retrieveData("Report", reportType, value);
		System.out.println(results + "\n");
		//getting the results, printing it; will change once
		//jar has been implemented --john
	}//end display report
	
	/**
	 * 
	 * @param r
	 */
	private void getReportInfo(String r){
		String report = r;
		//check if report is null
		if(r == null){
			System.out.println("Report can not be empty, please try again");
		}
		else{
			//gets all info associated with report
			String results = dbaccess.retrieveData("Reports", "Info", r);
			System.out.println("Info for report: " + results);

		}
		
	}
	
	/**
	 * 
	 */
	private void knowDateInterval(Reports r){
		//need to know if reports will have all of this on the database

		//if not, need to add it -john
	}
}
