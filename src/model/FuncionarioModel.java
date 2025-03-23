
package model;

import dao.FuncionarioDao;
import java.util.List;


public class FuncionarioModel {
    
    private int id;
    private String nome;
    private String matricula;
    private String setor;
   
    public FuncionarioModel(){
        
    }
    
    public FuncionarioModel(String nome, String matricula, String setor){
        this.nome = nome;
        this.matricula = matricula;
        this.setor = setor;
    }

    public FuncionarioModel(int id, String nome, String matricula, String setor) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.setor = setor;
    }
    
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
            
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    
    public String getMatricula(){
        return this.matricula;
    }
    
    public void setSetor(String setor){
        this.setor = setor;
    }
    
    public String getSetor(){
        return this.setor;
    }
    
    @Override
    public String toString(){
        return " n|Nome: "+this.nome + "  \n|Matricula: " + this.getMatricula() + "  \n|Setor: " + this.getSetor() +"\n";
    }
    
    public void cadastrarFuncionarioDao(FuncionarioModel funcionario){
        FuncionarioDao novoFuncionario = new FuncionarioDao();
        novoFuncionario.inserirFuncionarioDB(funcionario);
        System.out.println("Dados enviados para o banco de dados");
    }
    
    public void updateFuncionarioDao(FuncionarioModel funcionario){
        FuncionarioDao update = new FuncionarioDao();
        update.atualizarFuncionarioBD(funcionario);
        System.out.println("Dados atualizados enviados para a o banco de dados");
    }
    
    public void deleteFuncionarioDao(int id){
        FuncionarioDao funcionario = new FuncionarioDao();
        funcionario.deleteFuncionarioDB(id);
    }
    
    public List<FuncionarioModel> listarFuncionario(){
        return new FuncionarioDao().getFuncionariosDB();
    }
}

