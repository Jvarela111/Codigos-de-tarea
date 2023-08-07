package CRUD;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class alumnos {
	private int id_alu;
	private String nom_alu;
	private int edad_alu;
	private int sem_alu;
	private int id_carrera1;
	
	
	public int getId() {
		return id_alu;
	}
	public void setId(int id_alu) {
		this.id_alu = id_alu;
	}
	public String getNombre() {
		return nom_alu;
	}
	public void setNombre(String nom_alu) {
		this.nom_alu = nom_alu;
	}
	public int getedad() {
		return edad_alu;
	}
	public void setedad(int edad_alu) {
		this.edad_alu = edad_alu;
	}
	public int getsemestre() {
		return sem_alu;
	}
	public void setsemestre(int sem_alu) {
		this.sem_alu = sem_alu;
	}
	public int getcarrera() {
		return id_carrera1;
	}
	public void setcarrera(int id_carrera1) {
		this.id_carrera1 = id_carrera1;
	}
	public void IngresarUsuario(JTextField NombreTxt, JTextField edadTxt, JTextField semestreTxt, JTextField carreraTxt) {
		
		setNombre(NombreTxt.getText());
		setedad(Integer.parseInt(edadTxt.getText()));
		setsemestre(Integer.parseInt(semestreTxt.getText()));
		setcarrera(Integer.parseInt(carreraTxt.getText()));
		
		conexionBD miConex = new conexionBD();
		
		String querySQL = "INSERT INTO usuarios_banco (nom_alu,edad_alu,sem_alu,id_carrera1,deuda,fecha_ingreso) VALUES (?,?,?,?,?,?)";
		
		try {
			CallableStatement cs = miConex.getConnection().prepareCall(querySQL);
			cs.setString(1, getNombre());
			cs.setInt(2, getedad());
			cs.setInt(3, getsemestre());
			cs.setDouble(4, getcarrera());
			cs.setInt(5, getId());

			cs.execute();
			
			JOptionPane.showMessageDialog(null, "Se inserto correctamente el cliente "+getNombre()+" sem_alu "+getsemestre());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo insertar de forma correcta, error: "+e.getMessage());
		}
		
		miConex.desconex();
	}
	
	public void MostrarUsuarios(JTable TablaUsuarios) {
		try {
			conexionBD miConex = new conexionBD();
			
			DefaultTableModel modelo = new DefaultTableModel();
			TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
			TablaUsuarios.setRowSorter(OrdenarTabla);
			
			String sql="";
	
			
			modelo.addColumn("ID");
			modelo.addColumn("NOMBRE");
			modelo.addColumn("EDAD");
			modelo.addColumn("SEMESTRE");
			modelo.addColumn("CARRERA");
			
			TablaUsuarios.setModel(modelo);
			
			String[] cabeceras = {"ID", "NOMBRE", "EDAD", "SEMESTRE", "CARRERA"};
			modelo.addRow(cabeceras);
			
			sql = "SELECT * FROM usuarios_banco ORDER BY id_alu ASC";
			
			String[] datos = new String[5];
			Statement st;
			
			try {
				st = miConex.getConnection().createStatement();
				
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					datos[0]=rs.getString("id_alu");
					datos[1]=rs.getString("nom_alu");
					datos[2]=rs.getString("edad_alu");
					datos[3]=rs.getString("sem_alu");
					datos[4] = rs.getString("id_carrera1");
					
					modelo.addRow(datos);
				}
				TablaUsuarios.setModel(modelo);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros + "+ e.getMessage());
			}
			
			miConex.desconex();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "el error es: "+e.getMessage());
		}
		
		
	}

	public void Seleccionar(JTable TablaUsuarios, JTextField IdTxt, JTextField NombreTxt, JTextField edadTxt, JTextField semestreTxt, JTextField carreraTxt) {
		int fila = TablaUsuarios.getSelectedRow();
		
		if(fila>=0) {
			IdTxt.setText(TablaUsuarios.getValueAt(fila,0).toString());
			NombreTxt.setText((TablaUsuarios.getValueAt(fila, 1).toString()));
			edadTxt.setText((TablaUsuarios.getValueAt(fila, 2).toString()));
			semestreTxt.setText((TablaUsuarios.getValueAt(fila, 3).toString()));
			carreraTxt.setText((TablaUsuarios.getValueAt(fila, 4).toString()));
		}else {
			
		}
		
		
		
	}
	
	public void Modificar(JTextField IdTxt, JTextField NombreTxt, JTextField edadTxt, JTextField semestreTxt, JTextField carreraTxt) {
		setId(Integer.parseInt(IdTxt.getText()));
		setNombre(NombreTxt.getText());
		setedad(Integer.parseInt(edadTxt.getText()));
		setsemestre(Integer.parseInt(semestreTxt.getText()));
		setcarrera(Integer.parseInt(carreraTxt.getText()));
		
conexionBD miConex = new conexionBD();
		
		String querySQL = "UPDATE usuarios_banco SET nom_alu = ?, edad_alu = ?, sem_alu = ?, id_carrera1 = ?, WHERE id_alu = ?";
		
		try {
			CallableStatement cs = miConex.getConnection().prepareCall(querySQL);
			cs.setString(1, getNombre());
			cs.setInt(2, getedad());
			cs.setInt(3, getsemestre());
			cs.setDouble(4, getcarrera());
			cs.setInt(5, getId());

			
			cs.execute();
			
			JOptionPane.showMessageDialog(null, "Modificacion exitosa");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo modificar de forma correcta, error: "+e.getMessage());
		}
		
		miConex.desconex();

	}
	
	public void Eliminar(JTextField IdTxt) {
		setId(Integer.parseInt(IdTxt.getText()));
		conexionBD miConex = new conexionBD();

		String querySQL = "DELETE FROM usuarios_banco WHERE id_alu = ?";
		
		try {
			CallableStatement cs = miConex.getConnection().prepareCall(querySQL);
			cs.setInt(1, getId());
			cs.execute();
			JOptionPane.showMessageDialog(null, "Eliminacion exitosa");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo eliminar de forma correcta, error: "+e.getMessage());
		}
		
		miConex.desconex();
	}
	
}