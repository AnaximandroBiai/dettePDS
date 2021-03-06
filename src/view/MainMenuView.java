package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * @author anax
 * @version 1.0 This is the main menu view
 */
public class MainMenuView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel rechercheText = new JLabel("Please choose the indicator you want to evaluate: ");
	private JLabel dette = new JLabel("PhyGit Mall");
	private Font policeDette = new Font("Arial", Font.BOLD, 28);
	private boolean displayConnectionScreen = true;
	private JButton turnoverButton = new JButton("Turnover");
	private JButton stockRButton = new JButton("Returns");
	private JButton attendanceButton = new JButton("Attendance");
	private JButton signsButton = new JButton("Signs");
	private JButton storesButton = new JButton("Stores");
	private JButton royaltiesButton = new JButton("Royalties");
	private JPanel container = new JPanel();

	public MainMenuView(Socket s, Collection<String> cats, Collection<String> types, Collection<String> names) {
		this.setLocationRelativeTo(null);
		this.setTitle("PhyGit Mall: Mall activity indicators");
		this.setSize(600, 600);
		this.setResizable(false);

		dette.setFont(policeDette);
		turnoverButton.addActionListener(new TurnoverButton(s, cats));
		stockRButton.addActionListener(new ReturnButton(s, types));
		attendanceButton.addActionListener(new AttendanceButton(s, cats));
		signsButton.addActionListener(new SignsButton(s));
		storesButton.addActionListener(new StoresButton(s));
		royaltiesButton.addActionListener(new RoyaltiesButton(s, cats, names));
		JPanel top = new JPanel();
		JPanel west = new JPanel();
		JPanel east = new JPanel();
		JPanel center = new JPanel();
		JPanel bot = new JPanel();
		top.setPreferredSize(new Dimension(100, 250));
		center.setPreferredSize(new Dimension(100, 60));
		west.setPreferredSize(new Dimension(200, 600));
		east.setPreferredSize(new Dimension(200, 600));
		bot.setPreferredSize(new Dimension(100, 250));
		GridLayout layoutCenter = new GridLayout(2, 1);
		GridLayout layoutTop = new GridLayout(1, 2);
		top.setLayout(layoutTop);
		center.setLayout(layoutCenter);
		top.add(dette);
		top.add(rechercheText);
		container.setLayout(new BorderLayout());
		east.add(turnoverButton);
		east.add(stockRButton);
		east.add(storesButton);
		west.add(attendanceButton);
		west.add(royaltiesButton);
		west.add(signsButton);
		container.add(top, BorderLayout.NORTH);
		container.add(center, BorderLayout.CENTER);
		container.add(bot, BorderLayout.SOUTH);
		container.add(east, BorderLayout.EAST);
		container.add(west, BorderLayout.WEST);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(container);
		this.setVisible(displayConnectionScreen);
	}

	/**
	 * Intern class TurnoverButton. When the user clicks on the button he goes to the Turnover View.
	 *
	 */
	private class TurnoverButton implements ActionListener {
		private Socket s;
		private Collection<String> cats;

		public TurnoverButton(Socket s, Collection<String> cats) {
			this.s = s;
			this.cats = cats;
		}

		public void actionPerformed(ActionEvent e) {
			new TurnoverView(s, cats);
		}

	}

	/**
	 * Intern class AttendanceButton. When the user clicks on the button he goes to the Attendance View.
	 *
	 */
	private class AttendanceButton implements ActionListener {
		private Socket s;
		private Collection<String> cats;

		public AttendanceButton(Socket s, Collection<String> cats) {
			this.s = s;
			this.cats = cats;
		}

		public void actionPerformed(ActionEvent e) {
			new AttendanceView(s, cats);
		}

	}

	/**
	 * Intern class ReturnButton. When the user clicks on the button he goes to the Return View.
	 *
	 */
	private class ReturnButton implements ActionListener {
		private Socket s;
		private Collection<String> types;

		public ReturnButton(Socket s, Collection<String> types) {
			this.s = s;
			this.types = types;
		}

		public void actionPerformed(ActionEvent e) {
			new StockReturnView(s, types);
		}

	}

	/**
	 * Intern class SignsButton. When the user clicks on the button he goes to the Stores View.
	 *
	 */
	private class SignsButton implements ActionListener {
		private Socket s;

		public SignsButton(Socket s) {
			this.s = s;
		}

		public void actionPerformed(ActionEvent e) {
			new SignsView(this.s);
		}
	}

	/**
	 * Intern class StoresButton. When the user clicks on the button he goes to the Stores View.
	 *
	 */
	private class StoresButton implements ActionListener {
		private Socket s;

		public StoresButton(Socket s) {
			this.s = s;
		}

		public void actionPerformed(ActionEvent e) {
			new StoresView(this.s);
		}
	}

	/**
	 * Intern class RoyaltiesButton. When the user clicks on the button he goes to the Stores View.
	 *
	 */
	private class RoyaltiesButton implements ActionListener {
		private Socket s;
		private Collection<String> cats;
		private Collection<String> names;

		public RoyaltiesButton(Socket s, Collection<String> cats, Collection<String> names) {
			this.s = s;
			this.cats = cats;
			this.names = names;
		}

		public void actionPerformed(ActionEvent e) {
			new RoyaltiesView(s, cats, names);
		}

	}
}
