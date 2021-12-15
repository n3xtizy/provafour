package View;

import Dao.ControllerDAO;
import Model.Cadastrar;

public class Main {
    public static void main(String[] args){

        ControllerDAO controllerDAO = new ControllerDAO();

        //----Faz um cadastro!
        Cadastrar cadastro = new Cadastrar();
        cadastro.setBiblioteca("Biblioteca Municipal");
        cadastro.setGenero("Terror");
        cadastro.setLivro("As historias do Engenheiro de Software ZUMBI");

        controllerDAO.save(cadastro);

        //----Edita um cadastro(pelo ID) já feito
        Cadastrar c1 = new Cadastrar();
        c1.setBiblioteca("Biblioteca Estadual");
        c1.setGenero("Ação");
        c1.setLivro("As historias do hacker gordinho");
        c1.setId(1);

        //contatoDao.update(c1); //----Edita o cadastro

        //contatoDao.deleteByID(1); //----Deleta o contato pelo ID
    }
}
