package rpg.Sons.narracao;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Narracao {

    private Clip clip;

    public void tocarNarracao() {
        try {
            // Caminho relativo dentro da pasta src
            File arquivo = new File("narracao.wav");

            if (!arquivo.exists()) {
                System.out.println("Arquivo de narração não encontrado em: " + arquivo.getAbsolutePath());
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(arquivo);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start(); // toca o áudio
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Erro ao tocar a narração: " + e.getMessage());
        }
    }

    public void pararNarracao() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}

