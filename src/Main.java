import Personagens.Heroi.*;
import Sons.narracao.Narracao;

import java.io.FileNotFoundException;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            Narracao narracao = new Narracao();
            narracao.tocarNarracao(); // toca a voz

            leitorDeArquivos leitor = new leitorDeArquivos("Introducao.txt");
            leitor.lerArquivo(); // mostra o texto da história (letra por letra)

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
