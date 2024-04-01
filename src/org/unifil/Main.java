package org.unifil;

import org.unifil.model.Produto;
import org.unifil.service.ProdutoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in);

        List<Produto> produtosList = new ArrayList<Produto>();

        ProdutoService produtoService = new ProdutoService();

        while (true) {

            System.out.print("##--CRUD Produtos de Menu--##\n\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("| Opção 1 - Cadastrar Produto |\n");
            System.out.print("| Opção 2 - Consultar Produto |\n");
            System.out.print("| Opção 3 - Adicionar Produto |\n");
            System.out.print("| Opção 4 - Vender Produto    |\n");
            System.out.print("| Opção 5 - Sair              |\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("Digite uma opção: ");

            int opcao = menu.nextInt();

            if (opcao == 5) {
                System.out.print("\nAté logo!");
                break;
            }

            switch (opcao) {
                case 1:
                    produtoService.cadastrar(produtosList);
                    break;

                case 2:
                    produtoService.consultar(produtosList);
                    break;

                case 3:
                    produtoService.adicionar(produtosList);
                    break;

                case 4:
                    produtoService.vender(produtosList);
                    break;

                default:
                    System.out.print("\nOpção Inválida!");
                    break;
            }
        }
    }
}
