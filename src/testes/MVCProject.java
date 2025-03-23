
package testes;

import controller.FuncionarioController;
import java.sql.ResultSet;
import dao.DataBaseConection;
import java.sql.Connection;
import model.FuncionarioModel;
import java.sql.PreparedStatement;


public class MVCProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FuncionarioModel fun = getFunc();
        System.out.println(fun);
    }

    public static FuncionarioModel getFunc() {

        DataBaseConection db = new DataBaseConection();
        Connection con = db.getConection();
        String sql = "select * from funcionario";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            FuncionarioModel func;
            while (rs.next()) {
                func = new FuncionarioModel(rs.getNString("nome"), rs.getNString("matricula"), rs.getNString("setor"));
                return func;
            }

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("" +  e.getMessage());

        }
        return null;
    }
    
   
    
}
