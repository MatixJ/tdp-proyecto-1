package gui;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField txtfLU;
	private JTextField txtfApellido;
	private JTextField txtfNombre;
	private JTextField txtfEmail;
	private JTextField txtfGitUrl;
	private JLabel jlbImage;


	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(626, 272));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 211);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);
		
		JLabel jlbID = new JLabel("LU");
		jlbID.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlbID.setBounds(10, 13, 84, 14);
		tabInformation.add(jlbID);
		
		JLabel jlbLastName = new JLabel("Apellido");
		jlbLastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlbLastName.setBounds(10, 38, 84, 14);
		tabInformation.add(jlbLastName);
		
		JLabel jlbFirstName = new JLabel("Nombre");
		jlbFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlbFirstName.setBounds(10, 63, 84, 14);
		tabInformation.add(jlbFirstName);
		
		JLabel jlbEmail = new JLabel("E-mail");
		jlbEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlbEmail.setBounds(10, 88, 84, 14);
		tabInformation.add(jlbEmail);
		
		JLabel jlbGitUrl = new JLabel("Github URL");
		jlbGitUrl.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlbGitUrl.setBounds(10, 113, 84, 14);
		tabInformation.add(jlbGitUrl);
		
		txtfLU = new JTextField();
		txtfLU.setText(studentData.getId() + "");
		txtfLU.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtfLU.setBounds(104, 10, 311, 20);
		tabInformation.add(txtfLU);
		txtfLU.setColumns(10);
		
		txtfApellido = new JTextField();
		txtfApellido.setText(studentData.getLastName());
		txtfApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtfApellido.setColumns(10);
		txtfApellido.setBounds(104, 35, 311, 20);
		tabInformation.add(txtfApellido);
		
		txtfNombre = new JTextField();
		txtfNombre.setText(studentData.getFirstName());
		txtfNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtfNombre.setColumns(10);
		txtfNombre.setBounds(104, 60, 311, 20);
		tabInformation.add(txtfNombre);
		
		txtfEmail = new JTextField();
		txtfEmail.setText(studentData.getMail());
		txtfEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtfEmail.setColumns(10);
		txtfEmail.setBounds(104, 85, 311, 20);
		tabInformation.add(txtfEmail);
		
		txtfGitUrl = new JTextField();
		txtfGitUrl.setText(studentData.getGithubURL());
		txtfGitUrl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtfGitUrl.setColumns(10);
		txtfGitUrl.setBounds(104, 110, 311, 20);
		tabInformation.add(txtfGitUrl);
		
		LocalTime actualTime= LocalTime.now();
        LocalDate actualDate= LocalDate.now();
		contentPane.setLayout(null);
		contentPane.add(tabbedPane);
		
		JLabel jlbTimeAndDate = new JLabel("Esta ventana fue generada el " + actualDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " a las: " + actualTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "");
		jlbTimeAndDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		jlbTimeAndDate.setBounds(15, 217, 336, 14);
		contentPane.add(jlbTimeAndDate);
		
		
		jlbImage = new JLabel();
		jlbImage.setBounds(445, 28, 150, 150);
		contentPane.add(jlbImage);
		ImageIcon studentImage = new ImageIcon(SimplePresentationScreen.class.getResource(studentData.getPathPhoto()));
        Image scaledImage = studentImage.getImage().getScaledInstance(jlbImage.getWidth(), jlbImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon studentIcon = new ImageIcon(scaledImage);
		jlbImage.setIcon(studentIcon);
		
		setIconImage(new ImageIcon(SimplePresentationScreen.class.getResource("/images/tdp.png")).getImage());

	}
}
