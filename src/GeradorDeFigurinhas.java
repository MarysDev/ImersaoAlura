import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {
  
    public void cria(InputStream inputStream, String nomeDoArquivo) throws IOException{
      // leitura da imagem
      //InputStream inputStream = new FileInputStream(new File("C:\\Users\\marys\\OneDrive\\Área de Trabalho\\ImersaoAlura\\AluraStickers\\entrada\\filme.jpg"));
      // ou:
      //InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
      
      BufferedImage imagemOriginal = ImageIO.read(inputStream);
      
      // cria nova imagem em memória com transparência e com tamanho novo

      int largura = imagemOriginal.getWidth();
      int altura = imagemOriginal.getHeight();
      int novaAltura = altura + 200;
      BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

      // copiar a imagem original para a nova imagem (em memória)

      Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
      graphics.drawImage(imagemOriginal,null, 0, 0);

      // configurar a fonte
      var fonte = new Font(Font.SERIF, Font.BOLD, 75);
      graphics.setFont(fonte);
      graphics.setColor(Color.red);;
      // escreve uma frase na nova imagem

      graphics.drawString("APROVADO", 170, novaAltura - 100);

      // criar diretório e escrever a nova imagem em um arquivo
      File newDirectory = new File("C:\\Users\\marys\\OneDrive\\Área de Trabalho\\ImersaoAlura\\AluraStickers\\saida");
        if (!newDirectory.exists()){
          newDirectory.mkdir();
        }
      ImageIO.write(novaImagem, "png", new File(newDirectory +"\\" + nomeDoArquivo));
    }

}
