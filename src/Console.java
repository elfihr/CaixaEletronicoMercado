import java.util.Scanner;

public class Console {

    static Scanner leia = new Scanner(System.in);
    static Scanner leiaString = new Scanner(System.in);

    static Caixa objCaixa;

    static String nome;
    static Double preco,totJuros,totParc;
    static Double total = Double.valueOf(0);
    static String cartao;
    static String miniMenu;
    static int newMenu,mewCartao;
    static int menu;

    public static void iniciaAplicacao(){
        int menu = 1;




        while(menu != 0){


            Caixa.buscaMenu();
            System.out.print("DIGITE >> ");
            menu = leia.nextInt();

            if(menu ==1){
                Caixa.printSeparador(50);
                System.out.println("Adicionar Produto");

                System.out.print("PRODUTO: ");
                nome = leiaString.nextLine();

                System.out.print("PREÇO: R$ ");
                preco = leia.nextDouble();
                total = preco +total;

                objCaixa = new Caixa(nome,preco);

                Caixa.adicionar(objCaixa);
            } else if (menu == 2) {
                Caixa.printSeparador(50);
                System.out.println("Listar Produtos");
                System.out.println(Caixa.listar());
                System.out.println("TOTAL R$ "+total);
            } else if (menu ==3) {
                boolean valida, valida2;
                Double totJuros = 0.0;
                Double totParc = 0.0;


                do {
                    Caixa.printSeparador(50);
                    System.out.println("PAGAMENTO");
                    System.out.print("Selecione a forma de pagamento\n(1) - Cartão \n(2) - PIX\n(3) - Em dinheiro\nCartao 20% Juros - PIX 5% Juros - Dinheito 10% Descondo\n>> ");
                    miniMenu = leiaString.nextLine();

                    try {
                        newMenu = Integer.parseInt(miniMenu);

                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                    }


                    valida = miniMenu.matches("[1-3]{1}");
                    if (!valida) {
                        System.out.println("Entrada invalida");
                    }
                } while (!valida);

                if (newMenu == 1) {
                    do {
                        Caixa.printSeparador(50);
                        System.out.println("PAGAMENTO EM CARTÂO ");
                        System.out.print("Em quantas vezes será realizado o pagamento(ex:ate 6 vezes) >> ");
                        cartao = leia.next();


                        valida2 = cartao.matches("[1-6]{1}");

                        try {
                            mewCartao = Integer.parseInt(cartao);

                        } catch (NumberFormatException ex) {
                            ex.printStackTrace();
                        }


                        if (valida2 == true) {
                            totJuros += total * 1.2;
                            totParc += totJuros / mewCartao;
                            System.out.println("Numero de Parcelas: " + mewCartao + " de " + String.format("\nValor da Parcela %.2f R$", totParc) + String.format("\nPREÇO %.2f R$", totJuros) );
                        } else if (!valida2) {
                            System.out.println("entrada invalida");
                        }
                    } while (!valida2);

                } else if (newMenu == 2) {
                    Caixa.printSeparador(50);
                    System.out.println("PAGAMENTO EM PIX ");
                    totJuros += total * 1.05;
                    System.out.println("Valor total R$ " + total + "\nValor total com Juros R$ " + totJuros);

                } else if (newMenu == 3) {
                    Caixa.printSeparador(50);
                    System.out.println("PAGAMENTO EM DINHEIRO ");
                    totJuros += total * 0.90;
                    System.out.println("Valor total R$ " + total + "\nValor total com desconto R$ " + totJuros);
                }
                menu =0 ;
            }





            }
        Caixa.printSeparador(50);
        System.out.println("               Fim Do Programa");
        Caixa.printSeparador(50);



    }
}



