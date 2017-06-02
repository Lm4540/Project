package Clases;
import java.sql.*;
import java.util.*;

import javax.swing.*;
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
    
    //Metodo Para Filtrar
    public ArrayList <Object[]> filtrar(String tabla, String campo, String valor){
          
        String sql= "select * from " + tabla +" where "+campo+"='"+valor+"'";
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
   
       
    //METODO PARA INSERTAR/MODIFCAR/Eliminar EN LAS TABLAS
     public boolean Insertar(Object obj, String tabla, int n){
         String sql=""; 
        switch (n) {
            case 1:
                switch(tabla){
                    case "usuarios":
                        Usuarios a= (Usuarios)obj;
                        sql ="insert into usuarios values('"+a.getUser()+"', '"+a.getContra()+"', '"+a.getNivel()+"', '"+a.getNombre()+"','"+a.getOcupacion()+"','"+a.getEmail()+"')";
                        break;
                }      
                break;
            case 2:
                switch(tabla){
                    case "usuarios":
                        Usuarios a= (Usuarios)obj;
                        sql ="update usuarios set contra='"+a.getContra()+"', nombre='"+a.getNombre()+"', nivel='"+a.getNivel()+"', ocupacion='"+a.getOcupacion()+"', email='"+a.getEmail()+"'  where usuario='"+a.getUser()+"'";
                        break;
                        
                        
                        
                }     
                break;
            case 3:
                switch(tabla){
                    case "usuarios":
                        Usuarios a= (Usuarios)obj;
                        sql ="delete from usuarios where usuario='"+a.getUser()+"'";
                        break;
                        
                }     
                break;
        }
         
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
     
       
       //METODOs PARA Verificar si un usuario ya existe 
       //Verificar Si El Correo ya ha sido registrado antes
       public boolean ExisteCorreo(String valor){
          boolean resultado=false;
            String sql= "select * from usuarios where email='"+valor+"'";
        try {
            Class.forName(Bd.getDriver());
            con=DriverManager.getConnection(Bd.getUrl(), Bd.getUser(), Bd.getContra());
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();         
            if(rs.next()){
             resultado= true;
          }   
        } catch (ClassNotFoundException|SQLException e) {
               JOptionPane.showMessageDialog(null, e);
        }finally{
              try {
                  con.close();
              } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null, ex);
              }
        }
        return resultado;
    }
     
       //Verificar si este nombre de usuario esta disponible
       public boolean ExisteUser(String valor){
          boolean resultado=false;
        String sql= "select * from usuarios where usuario='"+valor+"'";
        try {
            Class.forName(Bd.getDriver());
            con=DriverManager.getConnection(Bd.getUrl(), Bd.getUser(), Bd.getContra());
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();          
            if(rs.next()){
               resultado= true;
          }   
        } catch (ClassNotFoundException|SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            }finally{
              try {
                  con.close();
              } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null, ex);
              }
        }
        return resultado;
    }
       
       //ACTUALIZAR CLAVE DE USUARIO:
       public boolean CambiarClave(String user, String correo, String clave){
            String sql="UPDATE `usuarios` SET `contra` = '"+clave+"' WHERE usuario = '"+user+"' and email='"+correo+"'"; 
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
       
       /*Verificar si una consulta devuelve un resultado:
       Por ejemplo pude haber utilizado esta funcion para verificar si 
               el mail ya se habia usado, o si ya habia un usuario creado(
        que son dos metodos que existen mas arriba        
       */
       public boolean SiExiste(String sql){
          boolean resultado=false;
        try {
            Class.forName(Bd.getDriver());
            con=DriverManager.getConnection(Bd.getUrl(), Bd.getUser(), Bd.getContra());
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();   
            if(rs.next()){
                resultado= true;
            }   
        } catch (ClassNotFoundException|SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            }finally{
              try {
                  con.close();
              } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null, ex);
              }
        }
        return resultado;
    }
       
        //METODO PARA Verificar Clave
       public boolean VerficarClave(String user, String clave){
          boolean  correcta=false;
          String sql= "select contra from usuarios where usuario='"+user+"'";
            try {
                Class.forName(Bd.getDriver());
                con=DriverManager.getConnection(Bd.getUrl(), Bd.getUser(), Bd.getContra());
                pst=con.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next()){
                    if(clave.equals(rs.getString(1))){
                    correcta=true;
                    }
                 }   
            } catch (ClassNotFoundException|SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }finally{
                  try {
                      con.close();
                  } catch (SQLException ex) {
                      JOptionPane.showMessageDialog(null, ex);
                  }
            }
        return correcta;
    }
     
       
       
       
       
       
        
}
