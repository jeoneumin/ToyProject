package com.spring.test2;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private Dao dao;
	Connection conn;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		/*logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );*/
		conn = dao.getCon();
		/*String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.142:1521/orclpdb";
		String userID = "testuser2";
		String userPW = "testuser2";*/
		/*Connection conn = null;*/
		PreparedStatement pstmt = null;
		//String sql = "insert into test values(?)";
		String sql = "select * from test";
		ResultSet res;
		int insert = 0;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, "candy");
			res = pstmt.executeQuery();
			while(res.next()) {
				
				System.out.println(res.getString(1));
				//model.addAttribute("test", rs.getString(1));
			}
			/*if(res.next()) {
				System.out.println(res.getString(1));
			}else {
				System.out.println("non");
				//model.addAttribute("test", "non");
			}*/
			//System.out.println("insert?"+insert);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		/*if(conn.equals(null)) {
			System.out.println("fail");
		}
		else {
			System.out.println("success");
		}*/
		
		model.addAttribute("serverTime", "serverTime" );
		
		return "login";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Locale locale, Model model) {
		
		
		return "test";
	}
	
}
