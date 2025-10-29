package rpg;

import rpg.rpg.sons.narracao.Narracao;
import rpg.LeitorDeArquivosTxt;
import rpg.personagens.BasePersonagens;
import rpg.personagens.inimigos.SoldadoDaDitadura;
import rpg.telas.TelaCombate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            Narracao narracao = new Narracao();
            narracao.tocarNarracao(); // toca a voz

            LeitorDeArquivosTxt leitor = new LeitorDeArquivosTxt("Introducao.txt");
            leitor.lerArquivo(); // mostra o texto da história (letra por letra)

            // 3️⃣ Cria personagens (usando sua BasePersonagens e SoldadoDaDitadura)
            BasePersonagens heroi = new BasePersonagens("Herói", 100, 20, 10, 1) {};
            BasePersonagens inimigo = new SoldadoDaDitadura("Soldado da Ditadura");

            // 4️⃣ Inicia a tela de combate no terminal
            TelaCombate tela = new TelaCombate(heroi, inimigo);
            tela.exibirTelaCombate();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
