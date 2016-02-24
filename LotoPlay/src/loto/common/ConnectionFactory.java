package loto.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {	

	private final String PROTOCOL        = "jdbc:mysql://localhost:3306/";   
	//private final String PROTOCOL        = "jdbc:mysql://104.254.98.163:3306/";
	
	private final String RemoteDATABASE  = "firstrad_lotodb?noAccessToProcedureBodies=true";
	private final String RemoteUSER      = "firstrad_lotroot";
	private final String RemotePASSWORD  = "OD[aO2(4SxCe";
	
	private final String LocalDATABASE   = "loto?noAccessToProcedureBodies=true";
	private final String LocalUSER       = "root";
	private final String LocalPASSWORD   = "";
	
	public static Connection getNewConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		return new ConnectionFactory().createConnection();
	}
	
	private Connection createConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException {	
		
			Class.forName("com.mysql.jdbc.Driver");	
			
			Connection connection = null;
			
			try {     
					connection = DriverManager.getConnection( PROTOCOL + RemoteDATABASE, RemoteUSER, RemotePASSWORD );
			} catch (SQLException e) {			
				try {
					connection = DriverManager.getConnection( PROTOCOL + LocalDATABASE,  LocalUSER,  LocalPASSWORD  );
				} catch (SQLException e1) {	e1.printStackTrace(); }				
				//e.printStackTrace();
			}			
			
			return connection;
	}		
		

}
