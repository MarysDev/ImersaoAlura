
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
	public static void main(String[] args) throws Exception {
		// fazer uma conexão HTTP e buscar os top 250 filmes
		
		
		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
		URI endereco = URI.create(url);
		var client = HttpClient.newHttpClient();
		
		HttpRequest request= HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
				
		// extrair só os dados que interessam (título, poster, rating

		var parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);
		
		//exibir e manipular os dados
		
		for (Map<String, String> filme : listaDeFilmes) {
			System.out.println("\u001b[1mTítulo:\u001b[m " + filme.get("title"));
			System.out.println("\u001b[1mPoster:\u001b[m " + filme.get("image"));
			System.out.println("\u001b[46m \u001b[30mClassificação: " + filme.get("imDbRating") + " \u001b[m");

			//criar as estrelas de acordo com a classificação do filme, arredondando os números
			String ratingString = filme.get("imDbRating");
			double ratingNumber = Double.parseDouble(ratingString);
			int ratingRoundedUp = (int) Math.round(ratingNumber);
			for(int i = 0; i < ratingRoundedUp; i ++){
				System.out.print("⭐");
			}
			System.out.println(" ");
			System.out.println(" ");

			
		} {
			
		}
	}

}
