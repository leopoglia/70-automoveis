package com.automovel.view;

import com.automovel.controller.AutomovelController;
import com.automovel.controller.PessoaController;
import com.automovel.model.entities.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static Pessoa usuarioLogado;

    /**
     * @since 28-09-2022
     * @author Leonardo Heitor Poglia
     */
    public static void main(String[] args) {
        System.out.println("LOJA DE AUTOMOVEIS");
        logar();
    }

    /**
     * Método para logar no sistema
     * @since 28-09-2022
     */
    public static void logar() {
        PessoaController controller = new PessoaController();

        try {
            System.out.print("MATRICULA: ");
            int matricula = sc.nextInt();
            System.out.print("SENHA:");
            int senha = sc.nextInt();

            usuarioLogado = controller.validarLogin(matricula, senha);
            menu();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            logar();
        }
    }

    /**
     * Método para exibir o menu
     * @since 28-09-2022
     */
    public static void menu() throws SQLException {
        String[] opcoes = usuarioLogado.menu();
        for (String opcao : opcoes) {
            System.out.println(opcao);
        }
        System.out.print("> ");
        int escolha = sc.nextInt();
        Pessoa.escolhaMenu(opcoes, escolha);
    }

    /**
     * Método para cadastrar pessoa
     * @since 28-09-2022
     */
    public static void cadastrarPessoa(int opcao) throws SQLException {
        PessoaController controller = new PessoaController();

        System.out.print("NOME: ");
        String nome = sc.next();
        System.out.print("CPF: ");
        String cpf = sc.next();
        System.out.print("TELEFONE: ");
        String telefone = sc.next();
        System.out.print("GENERO: ");
        String genero = sc.next();
        System.out.print("IDADE: ");
        int idade = sc.nextInt();
        System.out.print("MATRICULA: ");
        int matricula = sc.nextInt();
        System.out.print("SENHA: ");
        int senha = sc.nextInt();

        double salario = 0;
        if (opcao == 2) {
            System.out.print("SALARIO: ");
            salario = sc.nextDouble();
        }

        try {
            controller.cadastrar(opcao, nome, cpf, telefone, genero, idade, matricula, senha, salario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        menu();
    }

    /**
     * Método para excluir pessoa
     * @since 28-09-2022
     */
    public static void removerPessoa() {
        PessoaController controller = new PessoaController();
        System.out.print("MATRICULA: ");
        int matricula = sc.nextInt();

        try {
            controller.removerPessoa(matricula);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método para cadastrar automovel
     * @since 28-09-2022
     */
    public static void cadastrarAutomovel(int matriculaAutomovelEditar, int opcaoedit) throws SQLException {
        AutomovelController controller = new AutomovelController();
        int opcao;

        if (matriculaAutomovelEditar == -1) {
            System.out.println("MENU CADASTRAR\n(1) CARRO\n(2) MOTO\n(3) VOLTAR");
            opcao = sc.nextInt();
        } else {
            opcao = opcaoedit;
        }

        try {
            Automovel automovel = coletarDados(opcao);
            if (matriculaAutomovelEditar == -1) {
                controller.cadadastrarAutomovel(automovel);
            } else {
                controller.editarAutomovel(matriculaAutomovelEditar, automovel);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        menu();
    }

    /**
     * Método para coletar dados do automovel
     * @since 28-09-2022
     */
    private static Automovel coletarDados(int opcao) {
        System.out.print("MODELO: ");
        String modelo = sc.next();
        System.out.print("PLACA: ");
        String placa = sc.next();
        System.out.print("ANO: ");
        int ano = sc.nextInt();
        System.out.print("PRECO: ");
        double preco = sc.nextDouble();

        switch (opcao) {
            case 1 -> {
                System.out.print("PORTAS: ");
                int portas = sc.nextInt();
                System.out.print("CAVALOS: ");
                int cavalos = sc.nextInt();
                System.out.print("TIPO CARROCERIA: ");
                String estilo = sc.next();
                return new Carro(modelo, placa, ano, portas, cavalos, estilo, preco);
            }
            case 2 -> {
                System.out.print("TIPO: ");
                String tipo = sc.next();
                System.out.print("SUSPENSÃO: ");
                double suspensao = sc.nextInt();
                System.out.print("TAMANHO: ");
                String tamanho = sc.next();
                return new Moto(modelo, placa, ano, tipo, suspensao, tamanho, preco);
            }
        }
        return null;
    }

    /**
     * Método para listar automovel
     * @since 28-09-2022
     */
    public static void listarAutomovel() throws SQLException {
        AutomovelController automovelController = new AutomovelController();

        System.out.println("LISTAR\n(1) CARRO\n(2) MOTO\n(3) CARRO VENDIDO\n(4) MOTO VENDIDA\n(5) VOLTAR");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> System.out.println(automovelController.listarCarro());
            case 2 -> System.out.println(automovelController.listarMoto());
            case 3 -> System.out.println(automovelController.listarCarroVendido());
            case 4 -> System.out.println(automovelController.listarMotoVendida());
            default -> menu();
        }
        listarAutomovel();
    }

    /**
     * Método para editar automovel
     * @since 28-09-2022
     */
    public static void editarAutomovel() throws SQLException {
        System.out.println("MENU EDITAR\n(1) CARRO\n(2) MOTO\n(3) VOLTAR");
        int opcao = sc.nextInt();
        int matricula;

        System.out.print("INDECE DO VEÍCULO: ");
        String indice = sc.next();
        matricula = verificarPlaca(indice, opcao);
        cadastrarAutomovel(matricula, opcao);
    }

    /**
     * Método para excluir automovel
     * @since 28-09-2022
     */
    public static void excluirAutomovel() throws SQLException {
        AutomovelController controller = new AutomovelController();
        System.out.println("DIGITE O NÚMERO DA PLACA: ");
        String placa = sc.next();

        System.out.println("(1) CARRO\n(2) MOTO");
        int opcao = sc.nextInt();


        try {
            int cod = verificarPlaca(placa, opcao);

            if(cod != -1){
                controller.excluirAutomovel(placa, opcao);
            }else{
                throw new Exception("PLACA NÃO ENCONTRADA");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        menu();
    }

    /**
     * Método para verificar placa
     * @since 29-09-2022
     */
    public static int verificarPlaca(String placa, int opcao){
        AutomovelController controller = new AutomovelController();

        try{
            return controller.verificarPlaca(placa, opcao);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return -1;
    }

    /**
     * Método para vender automovel
     *
     * @since 03-10-2022
     */
    public static void venderAutomovel() {
        System.out.println("DIGITE O NÚMERO DA PLACA: ");
        String placa = sc.next();

        System.out.println("DIGITE O NOME DO CLIENTE: ");
        String nome = sc.next();

        System.out.println("(1) CARRO\n(2) MOTO");
        int opcao = sc.nextInt();

        try {
            int cod = verificarPlaca(placa, opcao);
            AutomovelController controller = new AutomovelController();

            if(cod != -1){
                controller.venderAutomovel(placa, nome, opcao);
            }else{
                throw new Exception("PLACA NÃO ENCONTRADA");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}