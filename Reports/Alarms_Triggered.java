/**
 * 
 */
package Reports;

import java.util.Date;

/**
 * @author jvasquez9
 *
 */
public class Alarms_Triggered extends Reports{


	/**
	 * 
	 */
	@Override
	public void displayReport(String reportType, String startDate,
			String endDate) {
		// TODO Auto-generated method stub
		super.displayReport(reportType, startDate, endDate);
	}
	
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @requires startDate != null && endDate != null
	 * @ensures /*a report is generated within the given time frame
	 */
	public void gatherSecurityReports(String startDate, String endDate){
		//check to make sure dates are not null
		if(startDate.equals("") || startDate == null){
		//display error, sop statement for now
			System.out.println("The starting date cannot be empty, please" +
			" reenter a date");
			//in the future, may want to have a default date that will
			//be used should an empty date be chosen
		}//end start date null check

		//check if end date is null
		if(endDate.equals("") || endDate == null){
		//display error, sop statement for now
			System.out.println("The ending date cannot be empty, a" +
			" default date of todays date will be chosen");
					
			Date currentDate = new Date();
			endDate = currentDate.toString();//if end date is null, set it to todays 
		}//end start date null check
				
		//passed empty test, get report
		else{
		//calls display report with report type, start and end date
			displayReport("alarms", startDate, endDate);

			//getting failure report along with alarm report
			Failures failureReport = new Failures();
			failureReport.getFailuresReport(startDate, endDate);
			
			}//end else
		}//end gather security reports
	
}
