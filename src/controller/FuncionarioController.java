package controller;

import dao.FuncionarioDao;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.FuncionarioModel;

public class FuncionarioController {

    public void cadastrarFuncionarioController(String nome, String matricula, String setor) {

        if (nome != null && nome.length() > 0 && (matricula != null && matricula.length() > 0) && (setor != null && setor.length() > 0)) {
            FuncionarioModel func = new FuncionarioModel(nome, matricula, setor);
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso");
            func.cadastrarFuncionarioDao(func);
        } else {
            JOptionPane.showMessageDialog(null, "Digite corretamente os dados");
        }
    }

    public void atualizarFuncionarioController(int id, String nome, String matricula, String setor) {

        if ((id > 0) && nome != null && nome.length() > 0 && (matricula != null && matricula.length() > 0) && (setor != null && setor.length() > 0)) {
            FuncionarioModel func = new FuncionarioModel(id, nome, matricula, setor);
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso");
            func.updateFuncionarioDao(func);
        } else {
            JOptionPane.showMessageDialog(null, "Digite corretamente os dados");
        }
    }

    public void preencherTabela(JTable tabela) {
        DefaultTableModel table = (DefaultTableModel) tabela.getModel();
        FuncionarioDao funcionarioDb = new FuncionarioDao();

        List<FuncionarioModel> listaFuncionarioControler = funcionarioDb.getFuncionariosDB();
        table.setRowCount(0);
        for (FuncionarioModel item : listaFuncionarioControler) {
            table.addRow(new Object[]{
                item.getId(),
                item.getNome(),
                item.getMatricula(),
                item.getSetor()
            });
        }

    }

    public List<FuncionarioModel> listarFuncionaroController(){
        FuncionarioModel funcionarioModel = new FuncionarioModel();
        return  funcionarioModel.listarFuncionario();
    }
    
    public void eliminarFuncionarioController(int id) {
        if (id <= 0) {
            JOptionPane.showMessageDialog(null, "Selecione o registro que deseja excluir.");
        }
        FuncionarioModel model = new FuncionarioModel();
        model.deleteFuncionarioDao(id);
    }
}
