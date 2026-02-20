import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UsuarioRepository repo = new UsuarioRepository();
        UsuarioService service = new UsuarioService(repo);
        Scanner entrada = new Scanner(System.in);
        int escola = 0;
        do {
            System.out.println("=======================MENU==================");
            System.out.println("Digite o valor desejado");
            System.out.println("1-Cadastrar \n" + "2-Consultar \n" + "3-Consultar Usuário \n" +
                    "4-Deletar Usuário \n" + "5-Deletar Todos Usuários" + "0-Sair do MENU \n");
            escola = entrada.nextInt();
            entrada.nextLine();
            try {
                switch (escola){

                    case 1: cadastrar(entrada,service);
                        break;

                    case 2: listar(service);
                        break;
                    case 3: consultarPorId(entrada,service);
                    break;

                    case 4: deletar(entrada,service);
                    break;
                    case 5: deletarTodos(entrada, service);
                    case 0: {
                        System.out.println("saindo do menu");
                    }
                }
            }catch (IllegalArgumentException e){
                System.out.println("Errorrrr " + e.getMessage());
            }
        }while (escola != 0);


    }

    private static void cadastrar(Scanner entrada,UsuarioService service){

        System.out.println("Digite o nome");
        String nome = entrada.nextLine();
        service.validaNome(nome);
        System.out.println("Digite o CPF");
        String cpf =  entrada.nextLine();

        Usuario u = service.cadastrar(nome,cpf);
        System.out.println(u + "salvo com sucesso");
    }

    private static void listar(UsuarioService service){
        service.listar().forEach(System.out::println);
    }

    private static void consultarPorId(Scanner entrada, UsuarioService service){
        System.out.println("Digite o id");
        long id = entrada.nextLong();
        Usuario u = service.pesquisarPorId(id);
        System.out.println(u);
    }

    private static void deletar(Scanner entrada, UsuarioService service){
        System.out.println("digite o id do usuário");
        long id = entrada.nextInt();
        Usuario u = service.deletarPorId(id);
        System.out.println("deletado");
    }
    private static void deletarTodos(Scanner entrada , UsuarioService service){
        System.out.println("tem certeza de que deseja limpar a lista?");
        String resp = entrada.nextLine();
        if(resp.equals("s")){service.deletarTodos();}
    }
}