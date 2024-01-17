/**
 * 
 */
package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
/**
 * 
 */
public class CategorieMBean {
   public CategorieMBean(){
	   
   }
   int id;
   String nom;
   String prenom;
   String ville;
/**
 * @return the id
 */
public int getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}
/**
 * @return the nom
 */
public String getNom() {
	return nom;
}
/**
 * @param nom the nom to set
 */
public void setNom(String nom) {
	this.nom = nom;
}
/**
 * @return the prenom
 */
public String getPrenom() {
	return prenom;
}
/**
 * @param prenom the prenom to set
 */
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
/**
 * @return the ville
 */
public String getVille() {
	return ville;
}
/**
 * @param ville the ville to set
 */
public void setVille(String ville) {
	this.ville = ville;
}
public void ajouter() {
	Conexion conex=new Conexion();
	try {
		Connection con=conex.getConexion();
		PreparedStatement pst;
		pst=con.prepareStatement("insert into sammba (nom,prenom,ville) values(?,?,?)");
		pst.setString(1,nom );
		pst.setString(2,prenom );
		pst.setString(3,ville );
		pst.executeUpdate();
	}catch(SQLException e) {
		System.out.println(e);
	}
}
public void AjouterEtudiant() {
	
}
	public void modifier() {
		Conexion conex=new Conexion();
		try {
			Connection con=conex.getConexion();
			PreparedStatement pst;
			pst=con.prepareStatement("update sammba set nom=?,prenom=?,ville=? where id=?");
			pst.setString(1,nom );
			pst.setString(2,prenom );
			pst.setString(3,ville );
			pst.setInt(4, id);
			pst.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e);
		}
	}

	
	public void supprimer(Integer id) {
        Conexion conex = new Conexion();
        try (Connection con = conex.getConexion();
                PreparedStatement pst = con.prepareStatement("delete from sammba where id=?")) {
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Suppression réussie !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression : " + e.getMessage());
            e.printStackTrace();
        }
    }

public void EliminerEtudiant() {
	
}
   public List<CategorieMBean> getTableCategorie(){
	   List<CategorieMBean> data=new ArrayList<>();
	   Conexion conex= new Conexion();
	   try {
		   Connection con= conex.getConexion();
		   Statement sql=con.createStatement();
		   ResultSet rs= sql.executeQuery("select * from sammba");
		   while(rs.next()) {
			   CategorieMBean obj= new CategorieMBean();
			   obj.setId(rs.getInt("id"));
			   obj.setNom(rs.getString("nom"));
			   obj.setPrenom(rs.getString("prenom"));
			   obj.setVille(rs.getString("ville"));
			   data.add(obj);
		   }
	   }catch(SQLException e) {
		   System.out.println(e);
	   }
	   return data;
   }
}

