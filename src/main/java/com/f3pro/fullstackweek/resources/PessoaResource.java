package com.f3pro.fullstackweek.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.f3pro.fullstackweek.domain.Pessoa;
import com.f3pro.fullstackweek.repositories.PessoaRepository;
import com.f3pro.fullstackweek.services.PessoaService;


@RestController
@RequestMapping(value = "/pessoas")
@CrossOrigin(origins = {"*"})

public class PessoaResource {

	@Autowired
	private PessoaRepository pessoaRepository;

	@GetMapping()
	public List<Pessoa> listarTodos() {
		return pessoaRepository.findAll();

	}

	@PostMapping
	public Pessoa cadastarPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);

	}

	@PutMapping(value = "/{codigo}")
	public ResponseEntity atualizar(@PathVariable("codigo") Long codigo, @RequestBody Pessoa pessoa) {

		return pessoaRepository.findById(codigo).map(

				record -> {
					record.setCpf(pessoa.getCpf());
					record.setDataNascimento(pessoa.getDataNascimento());
					record.setEmail(pessoa.getEmail());
					record.setIdade(pessoa.getIdade());
					record.setNome(pessoa.getNome());
					record.setTelefone(pessoa.getTelefone());
					record.setIsVacinada(pessoa.getIsVacinada());
					Pessoa pessoaAtualizada = pessoaRepository.save(record);
					return ResponseEntity.ok().body(pessoaAtualizada);

				}).orElse(ResponseEntity.notFound().build());

	}

	@GetMapping("/{codigo}")
	public Pessoa buscarPeloCodigo(@PathVariable Long codigo) {
		return pessoaRepository.findById(codigo).orElse(null);
	}

}
