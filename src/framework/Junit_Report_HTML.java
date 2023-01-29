package framework;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class Junit_Report_HTML {

	//Create instances
			static File jUnitReport;
			static BufferedWriter jUnitWriter;
			
			@BeforeClass
			public static void setUpBeforeClass() throws IOException
			{
				//Path for the html file to be set
				String jUnitReportFile =
						"C:\\Users\\Jayakishore.V\\eclipse-workspace\\Selenium_Junit\\JUnitReportFile.html";
				
				//Set the date format 
				//12-DEC-2022 10:05:20
				DateFormat dtFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
				Date date = new Date();
				
				//Creating the file - HTML report
				jUnitReport = new File(jUnitReportFile);
				jUnitWriter = new BufferedWriter(new FileWriter(jUnitReport,true) );
				
				//Write the html tag with the Heading and Date
				jUnitWriter.write("<html><body>");
				jUnitWriter.write("<h1> Test Execution Summary "+dtFormat.format(date) + "</h1>");
				
					
			}
			
			@AfterClass
			public static void tearDownAfterClass() throws IOException
			{
				//Closing the html tag and report
				jUnitWriter.write("</body></html>");
				jUnitWriter.close();
				
				//Opening the report after navigating to the location where it is stored
				Desktop.getDesktop().browse(jUnitReport.toURI());
				
			}

			@Rule
			public TestRule watchman = new TestWatcher()
			{
				@Override
				public Statement apply(Statement base,Description desc)
				{
					return super.apply(base, desc);
				}
				
				@Override
		        public void succeeded(Description desc)
				{
				   try	
				   {
					   jUnitWriter.write(desc.getDisplayName() + " " + "Success");
					   jUnitWriter.write("<br>");
			       }
				   catch(Exception e1)
				   {
					   System.out.println(e1.getMessage());
				   }
				}
				
				@Override
				public void failed(Throwable e,Description desc)
				{
					try
					{
						jUnitWriter.write(desc.getDisplayName() + " " +e.getClass().getSimpleName());
						jUnitWriter.write("<br>");

					}
					catch(Exception e2)
					   {
						   System.out.println(e2.getMessage());
					   }
				}

			  };
		}

