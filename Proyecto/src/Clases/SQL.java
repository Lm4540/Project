/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Luis Rivera
 */
public class SQL {
    Database Bd =new Database();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    //METODO PARA HACER CONSULTAS PASANDO COMO PARAMETRO UNA TABLA
    public ArrayList <Object[]> consultar(String tabla){
          
        String sql= "select * from "+tabla;
        ResultSetMetaData meta;
        
        ArrayList<Object[]> datos=new ArrayList<>();
        
        try {
            Class.forName(Bd.getDriver());
            con=DriverManager.getConnection(Bd.getUrl(), Bd.getUser(), Bd.getContra());
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            meta=rs.getMetaData();
            
          while(rs.next()){
              Object[] fila=new Object[meta.getColumnCount()];
              for (int i = 0; i < fila.length; i++) {
                  fila[i]=rs.getObject(i+1);
                  }
          datos.add(fila);
          }          
        } catch (ClassNotFoundException|SQLException e) {
            
            //Como mostrar las excepciones
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
        
              try {
                  con.close();
              } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null, ex);
              }
        }
        
        return datos;  
        
    }
    
    //METODO PARA INSERTAR EN LAS TABLAS
     public boolean Insertar(Object obj, String tabla){
         String sql=""; 
         switch(tabla){
       /* case "Alumnos":
           Alumnos a= (Alumnos)obj;
            sql ="Insert into alumnos values("+a.getCarnet()+",'"+a.getNombre()+"','"+a.getApellidos()+"','"+a.getDireccion()+"',"+a.getEdad();
            break;
    */      }
         
        try {
             con=DriverManager.getConnection(Bd.getUrl(), Bd.getUser(), Bd.getContra());
            pst=con.prepareStatement(sql);
           pst.executeUpdate();
           return true;
        } catch (SQLException e) {
             return false;
        }finally{
        
              try {
                  con.close();
              } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null, ex.getMessage());
              }
        }
        
        
       }
     
     //METODO PARA USAR EL LOGUEO
     
       public String log(String user, String contra){
          String nivel="";
        String sql= "select nivel from usuarios where usuario='"+user+"' and contra='"+contra+"'";
        
        try {
            Class.forName(Bd.getDriver());
            con=DriverManager.getConnection(Bd.getUrl(), Bd.getUser(), Bd.getContra());
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
          
          if(rs.next()){
             nivel=rs.getString(1);
          }   
        } catch (ClassNotFoundException|SQLException e) {
            
            //Como mostrar las excepciones
            JOptionPane.showMessageDialog(null, e);
            
        }finally{
        
              try {
                  con.close();
              } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null, ex);
              }
        }
        return nivel;
    }
     
     
}
