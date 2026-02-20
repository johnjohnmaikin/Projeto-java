import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UsuarioRepository {//classe para ralizar os CRUDs
    List<Usuario> usuarios = new ArrayList<>();
    long id=1;
    public Usuario salvar(String nome, String cpf){
        Usuario u = new Usuario(id++,nome, cpf);
        usuarios.add(u);
        return u;
    }

    public List<Usuario> listar(){
        return new ArrayList<>(usuarios);
    }

    public Usuario listarPorId(long id){
        for(Usuario e: usuarios){
            if(e.getId()==id){
                return e;
            }
        }
        return null;
    }

    public Usuario deletarPorId(long id){
       Usuario u = listarPorId(id);
       usuarios.remove(u);
       return u;
    }
}
