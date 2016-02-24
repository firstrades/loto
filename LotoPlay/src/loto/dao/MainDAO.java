package loto.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import loto.common.ConnectionFactory;
import loto.common.FrequentUse;
import loto.model.Loto;
import loto.model.Report;
import loto.model.Ticket;

public class MainDAO { 
	
	//private static Logger log = Logger.getLogger(MainDAO.class.getName());
	
	public static MainDAO getNewInstance() {
		
		return new MainDAO();
	}
	
	public boolean getCheckLogin(String username, String password) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;		
		ResultSet resultSet = null;
		String sql = "SELECT * FROM user WHERE username = ? AND password = ?";			
		
		
		try {
			
			connection = ConnectionFactory.getNewConnection(); 
			connection.setAutoCommit(false);
			
			preparedStatement = connection.prepareStatement(sql);  
			preparedStatement.setString(1, username);	
			preparedStatement.setString(2, password);			 								
		
			resultSet = preparedStatement.executeQuery();				
			
			if (resultSet.next()) { 
				
				connection.commit();					
				System.out.println("SQL - getCheckLogin executed");
					
				return true;
				
			} else {
				
				connection.commit();					
				System.out.println("SQL - getCheckLogin executed");
					
				return false;
			}		
			
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			try {connection.rollback();} catch (SQLException e1) {e1.printStackTrace();}
			e.printStackTrace();
			//log.error(e);
		} finally {		
			try {resultSet.close();        } catch (SQLException e) {e.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();       } catch (SQLException e) {e.printStackTrace();}		
		}
		
		return false;
	} // getCheckLogin
	
	public synchronized static Loto setInputData(int zero, int one, int two, int three, int four, int five, int six, int seven, int eight, int nine) {
		
		Connection connection = null;
		CallableStatement callableStatement = null;				
		String sql = "{call setInputData(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		
		Loto loto = new Loto();
		
		try {
			
			connection = ConnectionFactory.getNewConnection(); 
			connection.setAutoCommit(false);
			
			callableStatement = connection.prepareCall(sql);  
			callableStatement.setInt(1,  zero );	
			callableStatement.setInt(2,  one  );	
			callableStatement.setInt(3,  two  );
			callableStatement.setInt(4,  three);
			callableStatement.setInt(5,  four );
			callableStatement.setInt(6,  five );
			callableStatement.setInt(7,  six  );
			callableStatement.setInt(8,  seven);
			callableStatement.setInt(9,  eight);
			callableStatement.setInt(10, nine );			
			
			callableStatement.registerOutParameter(1,  java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(2,  java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(3,  java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(4,  java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(5,  java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(6,  java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(7,  java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(8,  java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(9,  java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(10, java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(11, java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(12, java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(13, java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(14, java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(15, java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(16, java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(17, java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(18, java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(19, java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(20, java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(21, java.sql.Types.INTEGER);
		
			callableStatement.execute();	
			
			zero  = callableStatement.getInt(1);
			one   = callableStatement.getInt(2);
			two   = callableStatement.getInt(3);
			three = callableStatement.getInt(4);
			four  = callableStatement.getInt(5);
			five  = callableStatement.getInt(6);
			six   = callableStatement.getInt(7);
			seven = callableStatement.getInt(8);
			eight = callableStatement.getInt(9);
			nine  = callableStatement.getInt(10);
			
			loto.getNumbers().setZero (callableStatement.getInt(11));   
			loto.getNumbers().setOne  (callableStatement.getInt(12));
			loto.getNumbers().setTwo  (callableStatement.getInt(13));
			loto.getNumbers().setThree(callableStatement.getInt(14));
			loto.getNumbers().setFour (callableStatement.getInt(15));
			loto.getNumbers().setFive (callableStatement.getInt(16));
			loto.getNumbers().setSix  (callableStatement.getInt(17));
			loto.getNumbers().setSeven(callableStatement.getInt(18));
			loto.getNumbers().setEight(callableStatement.getInt(19));
			loto.getNumbers().setNine (callableStatement.getInt(20));
			loto.setId                (callableStatement.getInt(21));
			
			
			loto.setTotalAmount((zero + one + two + three + four + five + six + seven + eight + nine) * FrequentUse.perTicket);			
				
			connection.commit();					
			System.out.println("SQL - setInputData executed");
			
			return loto;
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			try {connection.rollback();} catch (SQLException e1) {e1.printStackTrace();}
			e.printStackTrace();
			//log.error(e);
		} finally {		
			//try {resultSet.close();        } catch (SQLException e) {e.printStackTrace();}
			try {callableStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();       } catch (SQLException e) {e.printStackTrace();}		
		}
		
		return null;
		
	} // setInputData
	
	
	public List<Report> getReport(java.sql.Date from, java.sql.Date to) {
		
		Connection connection = null;
		CallableStatement callableStatement = null;	
		ResultSet resultSet = null;
		String sql = "{call getReport(?,?)}";
		
		List<Report> list = new ArrayList<>();
		
		try {
			
			connection = ConnectionFactory.getNewConnection(); 
			connection.setAutoCommit(false);
			
			callableStatement = connection.prepareCall(sql);  
			callableStatement.setDate(1, from);	
			callableStatement.setDate(2, to  );				
		
			resultSet = callableStatement.executeQuery();	
			
			while (resultSet.next()) {
				
				Report report = new Report();
				
				report.getDateTime().setDate        (resultSet.getString("date1") );  
				report.getDateTime().setTimeLength  (resultSet.getString("time1") );
				report.getNumbers().setZero         (resultSet.getInt   ("zero1") );
				report.getNumbers().setOne          (resultSet.getInt   ("one1")  );
				report.getNumbers().setTwo          (resultSet.getInt   ("two1")  );
				report.getNumbers().setThree        (resultSet.getInt   ("three1"));
				report.getNumbers().setFour         (resultSet.getInt   ("four1") );
				report.getNumbers().setFive         (resultSet.getInt   ("five1") );
				report.getNumbers().setSix          (resultSet.getInt   ("six1")  );
				report.getNumbers().setSeven        (resultSet.getInt   ("seven1"));
				report.getNumbers().setEight        (resultSet.getInt   ("eight1"));
				report.getNumbers().setNine         (resultSet.getInt   ("nine1") );
				
				list.add(report);
			}
				
			connection.commit();					
			System.out.println("SQL - getReport executed");
			
			return list;
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			try {connection.rollback();} catch (SQLException e1) {e1.printStackTrace();}
			e.printStackTrace();
			//log.error(e);
		} finally {		
			try {resultSet.close();        } catch (SQLException e) {e.printStackTrace();}
			try {callableStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();       } catch (SQLException e) {e.printStackTrace();}		
		}
		
		return null;
		
	} // getReport
	
	
	public Ticket getTicket(int id) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;		
		ResultSet resultSet = null;
		String sql = "SELECT * FROM ticket WHERE id = ?";	
		
		Ticket ticket = new Ticket();
		
		
		try {
			
			connection = ConnectionFactory.getNewConnection(); 
			connection.setAutoCommit(false);
			
			preparedStatement = connection.prepareStatement(sql);  
			preparedStatement.setInt(1, id);						 								
		
			resultSet = preparedStatement.executeQuery();	
			
			if (resultSet.next()) {
				
				ticket.setId                 (resultSet.getInt("id"));
				ticket.setDateTime           (resultSet.getString("date_time"));  
				ticket.getNumbers().setZero  (resultSet.getInt("l_0"));  
				ticket.getNumbers().setOne   (resultSet.getInt("l_1"));
				ticket.getNumbers().setTwo   (resultSet.getInt("l_2"));
				ticket.getNumbers().setThree (resultSet.getInt("l_3"));
				ticket.getNumbers().setFour  (resultSet.getInt("l_4"));
				ticket.getNumbers().setFive  (resultSet.getInt("l_5"));
				ticket.getNumbers().setSix   (resultSet.getInt("l_6"));
				ticket.getNumbers().setSeven (resultSet.getInt("l_7"));
				ticket.getNumbers().setEight (resultSet.getInt("l_8"));
				ticket.getNumbers().setNine  (resultSet.getInt("l_9"));
				
			}
				
			connection.commit();					
			System.out.println("SQL - getTicket executed");
					
			return ticket;
					
			
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			try {connection.rollback();} catch (SQLException e1) {e1.printStackTrace();}
			e.printStackTrace();
			//log.error(e);
		} finally {		
			try {resultSet.close();        } catch (SQLException e) {e.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();       } catch (SQLException e) {e.printStackTrace();}		
		}
		
		return null;
	}

	public static void main(String[] args) {
		
		Ticket ticket = MainDAO.getNewInstance().getTicket(86);
		
		System.out.println(ticket.getNumbers().getZero());
	}

}
