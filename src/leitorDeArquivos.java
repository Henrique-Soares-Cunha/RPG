import java.io.*;

public class leitorDeArquivos {
    private BufferedReader leitor;
    private String linha;
    private final int delay = 50;

    public leitorDeArquivos() throws FileNotFoundException {
        leitor = new BufferedReader(new FileReader("historia.txt"));
        linha = null;
    }

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