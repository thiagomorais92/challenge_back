package thiagomorais.challenge.com.hackatonChallenge.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import thiagomorais.challenge.com.hackatonChallenge.utils.Response;

@RestController
@RequestMapping("/api/cep")
@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
@CrossOrigin("*")
public class CepController {

	
	@GetMapping("/{cep}")
	public ResponseEntity<Response<String>> buscarCep(@PathVariable("cep") String cep){
		
		URL url;
		Response<String> resp =  null;
		try {
			url = new URL("http://viacep.com.br/ws/"+cep+"/json/");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(
					  new InputStreamReader(con.getInputStream()));
					String inputLine;
					StringBuilder content = new StringBuilder();
					while ((inputLine = in.readLine()) != null) {
					    content.append(inputLine);
					}
					in.close();
					resp = new Response<String>();
					resp.setData(content.toString());
					
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		 
		
		return  ResponseEntity.ok(resp);
	}
}
