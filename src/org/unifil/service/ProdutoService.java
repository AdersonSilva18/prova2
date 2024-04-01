package org.unifil.service;

import org.unifil.model.Produto;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProdutoService {

    String nomeTmp;
    Integer quantidadeTmp;
    Double precoTmp;
    Scanner scn = new Scanner(System.in);

    public void cadastrar(List<Produto> produtosList) {
        try {
            System.out.println("\nEscreva o nome do produto");
            nomeTmp = scn.nextLine();
            System.out.println("\nEscreva a quantidade do produto");
            quantidadeTmp = scn.nextInt();
            System.out.println("\nEscreva o preço do produto");
            precoTmp = scn.nextDouble();

            produtosList.add(new Produto(nomeTmp, quantidadeTmp, precoTmp));

            System.out.println("Produto cadastrado com sucesso");
        } catch (Exception ex) {
            System.out.println("ERRO ao cadastrar produto, tente novamente");
        }
    }

    public void consultar(List<Produto> produtosList) {
        try {
            System.out.println("Escreva o nome do produto para consulta");
            String finalNomeTmp = scn.nextLine();

            Optional<Produto> produtoOpt = produtosList.stream().filter(p -> p.getNome().equals(finalNomeTmp)).findFirst();
            if (produtoOpt.isPresent()) {
                System.out.println(produtoOpt.toString());
            } else {
                System.out.println("Produto nao achado");
            }
        } catch (Exception ex) {
            System.out.println("ERRO ao consultar o produto tente novamente");
        }
    }

    public void adicionar(List<Produto> produtosList) {
        try {
            System.out.println("Escreva o nome do produto para adicionar ao estoque");
            String finalNomeTmp = scn.nextLine();

            Optional<Produto> produtoOpt = produtosList.stream().filter(p -> p.getNome().equals(finalNomeTmp)).findFirst();
            if (produtoOpt.isPresent()) {
                System.out.println("Escreva a quantidade do produto que ira adicionar");
                Integer quantidadeFinal = scn.nextInt();

                produtoOpt.get().setQuantidade(produtoOpt.get().getQuantidade() + quantidadeFinal);

                System.out.println("Quantidade adicionada com sucesso!");
            } else {
                System.out.println("Produto nao achado");
            }
        } catch (Exception ex) {
            System.out.println("ERRO ao consultar o produto tente novamente");
        }
    }

    public void vender(List<Produto> produtosList) {
        try {

            System.out.println("Escreva o nome do produto para vende-lo");
            String finalNomeTmp = scn.nextLine();

            Optional<Produto> produtoOpt = produtosList.stream().filter(p -> p.getNome().equals(finalNomeTmp)).findFirst();
            if (produtoOpt.isPresent()) {
                System.out.println("Escreva a quantidade do produto que ira vender");
                Integer quantidadeFinal = scn.nextInt();
                if (produtoOpt.get().getQuantidade() >= quantidadeFinal) {
                    produtoOpt.get().setQuantidade(produtoOpt.get().getQuantidade() - quantidadeFinal);
                    System.out.println("Itens vendidos com sucesso!");
                } else {
                    System.out.println("Estoque insuficiente do produto! estoque: " + produtoOpt.get().getQuantidade());
                }
            } else {
                System.out.println("Produto nao achado");
            }
        } catch (Exception ex) {
            System.out.println("ERRO ao consultar o produto tente novamente");
        }
    }
}
