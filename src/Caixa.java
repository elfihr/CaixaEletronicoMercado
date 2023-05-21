import java.util.ArrayList;

public class Caixa extends Produto{
    private static ArrayList<Caixa> listaCaixa = new ArrayList<>();

    public Caixa(String nome, Double preco) {
        super(nome, preco);
    }

    public static ArrayList<Caixa> getListaCaixa() {
        return listaCaixa;
    }

    public static void printSeparador(int n){
        for(int i = 0 ; i < n; i++)
            System.out.print("-");
        System.out.println();
    }


    public static void printCabecalho(String menu){
        printSeparador(50);
        System.out.println(menu);
        printSeparador(50);
    }

    static public void adicionar(Caixa A){
        listaCaixa.add(A);
    }



    static public String listar(){
        String saida = "";
        int i = 1;
        for(Caixa C:listaCaixa){
            saida += (i++)+"º "+ C.imprimir();
        }return saida;
    }




    public static void buscaMenu(){
       printCabecalho("==========MENU==========\n(0) - Fechar Programa\n(1) - Adicionar Produto" +
               "\n(2) - Listar Produto\n(3) - Finalizar Compra");


    }
}
