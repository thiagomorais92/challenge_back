package thiagomorais.challenge.com.hackatonChallenge;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import thiagomorais.challenge.com.hackatonChallenge.entidades.Cliente;
import thiagomorais.challenge.com.hackatonChallenge.entidades.Contato;
import thiagomorais.challenge.com.hackatonChallenge.entidades.Endereco;
import thiagomorais.challenge.com.hackatonChallenge.entidades.TipoContatoEnum;
import thiagomorais.challenge.com.hackatonChallenge.entidades.Usuario;
import thiagomorais.challenge.com.hackatonChallenge.enums.PerfilEnum;
import thiagomorais.challenge.com.hackatonChallenge.repositories.ClienteRepository;
import thiagomorais.challenge.com.hackatonChallenge.repositories.ContatoRepository;
import thiagomorais.challenge.com.hackatonChallenge.repositories.EnderecoRepository;
import thiagomorais.challenge.com.hackatonChallenge.repositories.UsuarioRepository;
import thiagomorais.challenge.com.hackatonChallenge.utils.SenhaUtils;

@SpringBootApplication
public class HackatonChallengeApplication {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired 
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ContatoRepository  contatoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HackatonChallengeApplication.class, args);
		
	}

	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			
			Usuario usuario = new Usuario();
			usuario.setUsername("comum");
			usuario.setPerfil(PerfilEnum.ROLE_USUARIO);
			usuario.setSenha(SenhaUtils.gerarBCrypt("123456"));
			this.usuarioRepository.save(usuario);
			
			Usuario admin = new Usuario();
			admin.setUsername("admin");
			admin.setPerfil(PerfilEnum.ROLE_ADMIN);
			admin.setSenha(SenhaUtils.gerarBCrypt("123456"));
			this.usuarioRepository.save(admin);
			
			//Adicionando um cliente
			clienteRepository.deleteAll();
			enderecoRepository.deleteAll();
			contatoRepository.deleteAll();
			
			Cliente thiago = this.clienteRepository.save(new Cliente("Thiago","03964258105"));
			Endereco enderecoThiago = new Endereco();
			enderecoThiago.setBairro("Taguatinga Sul");
			enderecoThiago.setCep("72025050");
			enderecoThiago.setCidade("Brasília");
			enderecoThiago.setLogradouro("QSE 5");
			enderecoThiago.setUf("DF");
			enderecoThiago.setCliente(thiago);
			thiago.setEndereco(enderecoRepository.save(enderecoThiago));
			
			List<Contato> contatos = new ArrayList<Contato>(0);
			contatos.add(contatoRepository.save(new Contato(TipoContatoEnum.EMAIL,"araujodemorais.t@gmail.com",thiago)));
			contatos.add(contatoRepository.save(new Contato(TipoContatoEnum.TELEFONE,"982877750",thiago)));
			
			thiago.setContatos(contatos);
			
		};
	}
}
