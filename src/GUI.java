import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;


public class GUI {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	JPanel panel = new JPanel();

	
	String[] columnNames = {
			"Station_ID",
			"Datum",
			"Qualitaet",	
			"Min_5cm",
			"Min_2m",
			"Mittel_2m",	
			"Max_2m",
			"Relative_Feuchte",
			"Mittel_Windstaerke",	
			"Max_Windgeschwindigkeit",	
			"Sonnenscheindauer",
			"Mittel_Bedeckungsgrad",	
			"Niederschlagshoehe",
			"Mittel_Luftdruck",
			"COL15",	
			"COL16",	
			"COL17",	
			"COL18",	
			"COL19",	
			"COL20",	
			"COL21",	
			"COL22",	
			"COL23",	
			"COL24",	
			"COL25"
	};
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 

		
//		frame.getContentPane().setLayout(null);
				
		
		
		JButton btnDB = new JButton("Datenbank");
		btnDB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String[][] data = Datenbanktest.buildArr();
				
				table = new JTable(data, columnNames);
				
				JScrollPane scrollpane = new JScrollPane(table);
				scrollpane.setBounds(5, 80, frame.getWidth()-20, frame.getHeight()-120);
				scrollpane.setVisible(true);

//				frame.setBounds(100, 100, 1390, 300);
				frame.getContentPane().add(scrollpane);
				frame.repaint();
				

			}
		});
		


	
		frame.getContentPane().setLayout(null);
		btnDB.setBounds(304, 21, 85, 21);
		frame.getContentPane().add(btnDB);
		
		
		JButton btnCount = new JButton("Count");
		btnCount.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println(Datenbanktest.Anzahl());
			
			
		}
	});
		btnCount.setBounds(209, 21, 85, 21);
		frame.getContentPane().add(btnCount);
		
		
		
		JButton btnSuche = new JButton("Datum");
		btnSuche.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			String date = textField.getText();
			
//			 .getClass(); // .remove(table);
			
			
			String[][] data = Datenbanktest.Suche(date);
			table = new JTable(data, columnNames);
			JScrollPane scrollpane = new JScrollPane(table);
			scrollpane.setBounds(5, 80, frame.getWidth()-20, frame.getHeight()-120);
			scrollpane.setVisible(true);
			
			System.out.print(data[0][1]);
			
			frame.getContentPane().add(scrollpane);
			frame.repaint();
		}
	});
		btnSuche.setBounds(114, 21, 85, 21);
		frame.getContentPane().add(btnSuche);
		
		
		
		
		
		
		
		
		
		
		
		textField = new JTextField();
		textField.setBounds(8, 22, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
//		JScrollBar scrollBar = new JScrollBar();
//		scrollBar.setBounds(419, 21, 17, 48);
//		frame.getContentPane().add(scrollBar);
				
		
		
	}
}
