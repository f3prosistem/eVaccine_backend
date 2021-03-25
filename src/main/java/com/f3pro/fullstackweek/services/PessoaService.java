package com.f3pro.fullstackweek.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f3pro.fullstackweek.domain.Pessoa;
import com.f3pro.fullstackweek.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Pessoa> listar() {

		var pessoa = pessoaRepository.findAll();

		return pessoa;

	}

}
