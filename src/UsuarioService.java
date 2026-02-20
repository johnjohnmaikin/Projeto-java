import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private final UsuarioRepository repo;

    UsuarioService(UsuarioRepository repo){
        this.repo=repo;
    }

    public Usuario cadastrar(String nome,String cpf){
        validaNome(nome);
        return repo.salvar(nome,cpf);
    }

    public List<Usuario> listar(){
        List<Usuario> u = repo.listar();
        if(u.isEmpty()){
            throw new IllegalArgumentException("lista vazia");
        }
        return u;
    }

    public Usuario pesquisarPorId(long id){
        Usuario u = repo.listarPorId(id);
        if(u==null){
            throw new IllegalArgumentException("Usuário não encontrado");
        }
        return u;
    }

    public Usuario deletarPorId(long id){
        Usuario u = pesquisarPorId(id);
        if(u == null){
                throw new IllegalArgumentException("usuário não encontrado");
        }
        return repo.deletarPorId(id);
    }

    public void deletarTodos(){
        repo.deletarTodos();
    }
    //=================================validadores=====================================

    public void validaNome(String nome){
        if(nome.isBlank() || nome == null){
            throw new IllegalArgumentException("Nome ficou em branco!");
        }
        if(nome.length()<3){throw new IllegalArgumentException("nome não pode ser pequeno");}

        if(!nome.matches("^[\\p{L}]+( [\\p{L}]+)*$")){ throw new IllegalArgumentException("nome contém número ou espaços indesejado");}

    }
}
