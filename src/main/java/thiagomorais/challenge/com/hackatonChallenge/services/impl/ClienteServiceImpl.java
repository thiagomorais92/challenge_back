package thiagomorais.challenge.com.hackatonChallenge.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import thiagomorais.challenge.com.hackatonChallenge.dto.ClienteDTO;
import thiagomorais.challenge.com.hackatonChallenge.entidades.Cliente;
import thiagomorais.challenge.com.hackatonChallenge.entidades.Contato;
import thiagomorais.challenge.com.hackatonChallenge.entidades.Endereco;
import thiagomorais.challenge.com.hackatonChallenge.entidades.TipoContatoEnum;
import thiagomorais.challenge.com.hackatonChallenge.enums.TipoCategoriaContatoEnum;
import thiagomorais.challenge.com.hackatonChallenge.parser.ClienteParser;
import thiagomorais.challenge.com.hackatonChallenge.repositories.ClienteRepository;
import thiagomorais.challenge.com.hackatonChallenge.repositories.ContatoRepository;
import thiagomorais.challenge.com.hackatonChallenge.repositories.EnderecoRepository;
import thiagomorais.challenge.com.hackatonChallenge.serives.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteParser clienteParser; 
	
	@Autowired 
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Override
	public List<ClienteDTO> obterTodos() {
		List<ClienteDTO> dtoList = new ArrayList<ClienteDTO>(0);
		
		List<Cliente> clientes = clienteRepository.findAll();
		
		clientes.forEach((cliente)->{
			dtoList.add(clienteParser.toDto(cliente));
		});
		
		return dtoList;
	}

	@Override
	@Transactional
	public void deletar(Long idCliente) {
		Optional<Cliente> cli = clienteRepository.findById(idCliente);
		if(cli.isPresent()) {
			List<Contato> contatos = contatoRepository.findByCliente(cli.get());
			contatoRepository.deleteAll(contatos);
			enderecoRepository.delete(enderecoRepository.findByCliente(cli.get()));
			clienteRepository.delete(cli.get());
		}
		
	}

	@Override
	public Cliente salvarCliente(ClienteDTO dto) {
		 
		Cliente cli  = clienteRepository.save(new Cliente(dto.getNome(),dto.getCpf()));
		
		montarEnderecoAndContatoDoByDto(dto, cli);
		
		return cli;
	}

	private void montarEnderecoAndContatoDoByDto(ClienteDTO dto, Cliente cli) {
		Endereco end = new Endereco();
		end.setBairro(dto.getBairro());
		end.setCep(dto.getCep());
		end.setCidade(dto.getCidade());
		end.setComplemento(dto.getComplemento());
		end.setUf(dto.getUf());
		end.setLogradouro(dto.getLogradouro());
		end.setCliente(cli);
		end = enderecoRepository.save(end);
		cli.setEndereco(end);
		List<Contato>  contatos = new ArrayList<Contato>(0);
		
		Contato telCelular = new Contato(TipoContatoEnum.TELEFONE, dto.getTelefoneCelular(), TipoCategoriaContatoEnum.CELULAR,cli);
		Contato emailPrincipal = new Contato(TipoContatoEnum.EMAIL,dto.getEmailPrincipal(),cli);
		telCelular = contatoRepository.save(telCelular);
		emailPrincipal = contatoRepository.save(emailPrincipal);
		
		
		contatos.add(telCelular);
		contatos.add(emailPrincipal);
		
		cli.setContatos(contatos);
	}

	@Override
	public Cliente atualizarCLiente(ClienteDTO dto) {
		
		Optional<Cliente> cliOpt  = clienteRepository.findById(dto.getId());
		cliOpt.get().setNome(dto.getNome());
		cliOpt.get().setCpf(dto.getCpf());
		
		montarEnderecoAndContatoDoByDto(dto, cliOpt.get());
		
		
		return cliOpt.get();
	}

}
