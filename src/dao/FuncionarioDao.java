/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import model.FuncionarioModel;

public class FuncionarioDao {

    Connection conn;

    public FuncionarioDao() {

        DataBaseConection conection = new DataBaseConection();
        conn = conection.getConection();
    }

    public void inserirFuncionarioDB(FuncionarioModel func) {
        String sql = "Insert into funcionario(nome,matricula,setor) values(?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, func.getNome());
            stmt.setString(2, func.getMatricula());
            stmt.setString(3, func.getSetor());
            stmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void atualizarFuncionarioBD(FuncionarioModel model) {
        final String SQL = " update funcionario set nome = ?, matricula = ? , setor = ? where id = ? ";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(SQL);
            stmt.setString(1, model.getNome());
            stmt.setString(2, model.getMatricula());
            stmt.setString(3, model.getSetor());
            stmt.setInt(4, model.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<FuncionarioModel> getFuncionariosDB() {
        final String SQl = "select id, nome, matricula, setor from funcionario";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(SQl);
            ResultSet rs = stmt.executeQuery();

            List<FuncionarioModel> listaFuncionario = new ArrayList<>();

            while (rs.next()) {
                FuncionarioModel model = new FuncionarioModel();
                model.setId(rs.getInt("id"));
                model.setNome(rs.getString("nome"));
                model.setMatricula(rs.getString("matricula"));
                model.setSetor(rs.getString("setor"));

                listaFuncionario.add(model);
            }

            return listaFuncionario;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao listar funcionario " + e.getMessage());
            return null;
        }
    }
    
    public void deleteFuncionarioDB(int id){
        final String SQL = "delete from funcionario where id = ?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(SQL);
            stmt.setInt(1, id);
            stmt.execute();
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Erro ao eliminar registro "+ e.getMessage());
        }
    }
}
