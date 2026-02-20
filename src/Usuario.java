public class Usuario {
    private long id;
    private String nome;
    private String cpf;

    public Usuario(long id, String nome, String cpf){
        this.id=id;
        this.nome=nome;
        this.cpf=cpf;
    }

    public long getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }



    public void setId(long Id){
        this.id= Id;
    }
    public void setNome(String Nome){
        this.nome=Nome;
    }
    public void setCpf(String Cpf){
        this.cpf=Cpf;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
