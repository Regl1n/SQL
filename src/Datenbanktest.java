public class Datenbanktest {

	static DatabaseConnector test = new DatabaseConnector("127.0.0.1", 3306, "test", "root", "");

	public static QueryResult GetDBResult() {

		test.executeStatement("SELECT * FROM wetterdaten");

		QueryResult result = test.getCurrentQueryResult();
		
		return result;


	}
	
	public static String[][] buildArr() {
		
		QueryResult res = Datenbanktest.GetDBResult();
		String[][] arr = new String[res.getRowCount()][res.getColumnCount()];
		
		for (int i = 0; i < res.getRowCount(); i = i + 1) {

			for (int j = 0; j < res.getColumnCount(); j = j + 1) {
				
				 arr[i][j] = res.getData()[i][j];
			}
			
		}
		return arr;
	}
	
	
	public static String Anzahl() {
		
		test.executeStatement("Select count(Datum) FROM wetterdaten");
		
		QueryResult result = test.getCurrentQueryResult();
		return result.getData()[0][0];
		
	}
	public static String[][] Suche(String date) {
	
		test.executeStatement("SELECT * FROM wetterdaten WHERE Datum =  '" + date + "'" );
		QueryResult result = test.getCurrentQueryResult();
		return result.getData();
	}
	
}