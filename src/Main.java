import Heroi.*;
import java.io.FileNotFoundException;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        leitorDeArquivos historia = new leitorDeArquivos();

        try {
            historia.lerArquivo();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}