package Dao;

import Factory.ConectionFactory;
import Model.Cadastrar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerDAO<cadastros>{
    //----Salva os itens no SQL!
    public void save(Cadastrar cadastro){
        String sql = "INSERT INTO cadastros(biblioteca, genero, livro) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConectionFactory.getConnection();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, cadastro.getBiblioteca());
            pstm.setString(2, cadastro.getGenero());
            pstm.setString(3, cadastro.getLivro());

            pstm.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(pstm!= null){
                    pstm.close();
                }
                if(conn!= null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    //----Deleta um item pelo ID!
    public void deleteByID(int id){
        String sql = "DELETE FROM cadastros WHERE id=?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConectionFactory.getConnection();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setInt(1, id); //Deve-se colocar o id que deseja excluir!!!

            pstm.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstm != null){
                    pstm.close();
                }
                if (conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    //----Faz a listagem
    public Cadastrar getCadastros() throws SQLException {
        String sql = "SELECT * FROM contatos";
        List<Cadastrar> cadastros = new ArrayList<Cadastrar>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConectionFactory.getConnection();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while (rset.next()){
                Cadastrar contato = new Cadastrar();
                contato.setId(rset.getInt("id"));
                contato.setBiblioteca(rset.getString("biblioteca"));
                contato.setGenero(rset.getString("genero"));
                contato.setLivro(rset.getString("livro"));

                cadastros.add(contato);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(rset!=null){
                rset.close();
            }
            if(pstm!=null){
                pstm.close();
            }
            if(conn!=null){
                conn.close();
            }
        }
        return (Cadastrar) cadastros;
    }
}
