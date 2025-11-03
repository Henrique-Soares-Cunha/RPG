package rpg;

import java.io.*;

public class LeitorDeArquivosTxt {
    private BufferedReader leitor;
    private String linha;
    private final int delay = 78;

    /** Esse cria um leitor de arquivos que deve

     estar no caminho src/rpg/Historia
     @param arq: o nome do arquivo que será lido
     @since 1.0*/
    public LeitorDeArquivosTxt(String arq) throws FileNotFoundException {
        leitor = new BufferedReader(new FileReader("src/rpg/historia/"+arq));
        linha = null;
    }

    /** Esse método lé o arquivo armazenado e printa na tela.

     @since 1.0*/
    public void lerArquivo() throws IOException, InterruptedException {
        while ((linha = leitor.readLine()) != null){
            for (char caractere : linha.toCharArray()){
                System.out.print(caractere);

                System.out.flush();

                Thread.sleep(delay);
            }
            System.out.println();

        }
    }


}