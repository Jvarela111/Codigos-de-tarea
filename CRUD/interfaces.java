package CRUD;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class interfaces extends JFrame{
	
		private JPanel contentPane;
		private JTextField NombreTxt;
		private JTextField EdadTxt;
		private JTextField SemestreTxt;
		private JTable TablaUsuarios;
		private JTextField CarreraTxt;
		private JTextField IdTxt;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						interfaces frame = new interfaces();
						frame.setVisible(true);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public interfaces() {
			
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1237, 675);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(105, 68, 166));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel DatosAlumnos = new JPanel();
			DatosAlumnos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos Alumnos", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
			DatosAlumnos.setBounds(10, 95, 391, 454);
			contentPane.add(DatosAlumnos);
			DatosAlumnos.setLayout(null);
			
			JLabel NombreLabel = new JLabel("Nombre");
			NombreLabel.setBounds(10, 79, 75, 21);
			DatosAlumnos.add(NombreLabel);
			
			JLabel EdadLbl = new JLabel("Edad");
			EdadLbl.setBounds(10, 121, 75, 21);
			DatosAlumnos.add(EdadLbl);
			
			JLabel SemestreLbl = new JLabel("Semestre");
			SemestreLbl.setBounds(10, 160, 75, 21);
			DatosAlumnos.add(SemestreLbl);
			
			JLabel CarreraLbl = new JLabel("Id Carrera");
			CarreraLbl.setBounds(10, 204, 75, 21);
			DatosAlumnos.add(CarreraLbl);
			
			NombreTxt = new JTextField();
			NombreTxt.setBounds(77, 76, 304, 27);
			DatosAlumnos.add(NombreTxt);
			NombreTxt.setColumns(10);
			
			EdadTxt = new JTextField();
			EdadTxt.setColumns(10);
			EdadTxt.setBounds(77, 118, 304, 27);
			DatosAlumnos.add(EdadTxt);
			
			SemestreTxt = new JTextField();
			SemestreTxt.setColumns(10);
			SemestreTxt.setBounds(77, 160, 304, 27);
			DatosAlumnos.add(SemestreTxt);
			
			CarreraTxt = new JTextField();
			CarreraTxt.setColumns(10);
			CarreraTxt.setBounds(77, 202, 304, 27);
			DatosAlumnos.add(CarreraTxt);
			
			JButton AgregarBtn = new JButton("Agregar");
			AgregarBtn.setBackground(new Color(126, 61, 237));
			AgregarBtn.setForeground(new Color(255, 255, 255));
			AgregarBtn.setFont(new Font("Nirmala UI", Font.BOLD, 16));
			AgregarBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(NombreTxt.getText().isEmpty() || EdadTxt.getText().isEmpty() || SemestreTxt.getText().isEmpty() || CarreraTxt.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Uno o varios de los campos obligatorios estan vacios");
					}else {
						alumnos alumno = new alumnos();
						alumno.IngresarUsuario(NombreTxt, EdadTxt, SemestreTxt, CarreraTxt);
						
						NombreTxt.setText("");
						EdadTxt.setText("");
						SemestreTxt.setText("");
						CarreraTxt.setText("");
						
						alumnos alumnos = new alumnos();
						alumnos.MostrarUsuarios(TablaUsuarios);
					}
							
				}
			});
			AgregarBtn.setBounds(10, 328, 371, 32);
			DatosAlumnos.add(AgregarBtn);
			
			JButton ModificarBtn = new JButton("Modificar");
			ModificarBtn.setForeground(new Color(255, 255, 255));
			ModificarBtn.setBackground(new Color(126, 61, 237));
			ModificarBtn.setFont(new Font("Nirmala UI", Font.BOLD, 16));
			ModificarBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(NombreTxt.getText().isEmpty() || EdadTxt.getText().isEmpty() || SemestreTxt.getText().isEmpty() || CarreraTxt.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Uno o varios de los campos obligatorios estan vacios");
					}else {
						alumnos alumno = new alumnos();
						alumno.Modificar(IdTxt, NombreTxt, EdadTxt, SemestreTxt, CarreraTxt);
						
						NombreTxt.setText("");
						EdadTxt.setText("");
						SemestreTxt.setText("");
						
						CarreraTxt.setText("");
						
						
						alumnos alumnos = new alumnos();
						alumnos.MostrarUsuarios(TablaUsuarios);
					}
				}
			});
			ModificarBtn.setBounds(10, 370, 371, 32);
			DatosAlumnos.add(ModificarBtn);
			
			JButton EliminarBtn = new JButton("Eliminar");
			EliminarBtn.setForeground(new Color(255, 255, 255));
			EliminarBtn.setBackground(new Color(126, 61, 237));
			EliminarBtn.setFont(new Font("Nirmala UI", Font.BOLD, 16));
			EliminarBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					alumnos alumno = new alumnos();
					alumno.Eliminar(IdTxt);
					
					IdTxt.setText("");
					NombreTxt.setText("");
					EdadTxt.setText("");
					SemestreTxt.setText("");
					CarreraTxt.setText("");
					alumno.MostrarUsuarios(TablaUsuarios);
					
				}
			});
			EliminarBtn.setBounds(10, 412, 371, 32);
			DatosAlumnos.add(EliminarBtn);
			
			IdTxt = new JTextField();
			IdTxt.setColumns(10);
			IdTxt.setBounds(77, 36, 304, 27);
			DatosAlumnos.add(IdTxt);
			
			JLabel IDLbl = new JLabel("Id");
			IDLbl.setBounds(10, 39, 75, 21);
			DatosAlumnos.add(IDLbl);
			
			JPanel ListaAlumnos = new JPanel();
			ListaAlumnos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Lista Alumnos", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
			ListaAlumnos.setBounds(428, 95, 785, 454);
			contentPane.add(ListaAlumnos);
			ListaAlumnos.setLayout(null);
			
			TablaUsuarios = new JTable();
			TablaUsuarios.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					alumnos alumnos = new alumnos();
					alumnos.Seleccionar( TablaUsuarios,IdTxt, NombreTxt, EdadTxt, SemestreTxt, CarreraTxt);
				}
			});
			TablaUsuarios.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				}
			));
			TablaUsuarios.setBounds(10, 36, 765, 408);
			ListaAlumnos.add(TablaUsuarios);
			

			
			
			
			
//			PONEMOS ESTO DE ULTIMO PARA QUE YA HAYA CARGADO TODOO
			
//			DBConnection conexBDD = new DBConnection();
//			conexBDD.getConnection();
			alumnos alumnos = new alumnos();
			alumnos.MostrarUsuarios(TablaUsuarios);
			IdTxt.setEnabled(false);
			
			JLabel tituloLbl = new JLabel("LISTA ALUMNOS");
			tituloLbl.setForeground(new Color(255, 255, 255));
			tituloLbl.setHorizontalAlignment(SwingConstants.CENTER);
			tituloLbl.setFont(new Font("Nirmala UI", Font.BOLD, 51));
			tituloLbl.setBounds(372, 22, 453, 51);
			contentPane.add(tituloLbl);
			

		}
	}