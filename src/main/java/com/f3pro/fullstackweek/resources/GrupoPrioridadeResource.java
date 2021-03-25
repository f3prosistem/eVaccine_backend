package com.f3pro.fullstackweek.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.f3pro.fullstackweek.domain.GruposPrioridades;
import com.f3pro.fullstackweek.repositories.GrupoPrioridadeRepository;

@RestController
@RequestMapping(value = "/grupos")
public class GrupoPrioridadeResource {

	@Autowired
	private GrupoPrioridadeRepository grupoPrioridadeRepository;

	@GetMapping()
	public List<GruposPrioridades> listarTodos() {
		return grupoPrioridadeRepository.findAll();

	}

	@PostMapping
	public GruposPrioridades cadastarGruposPrioridades(@RequestBody GruposPrioridades pessoa) {

		return grupoPrioridadeRepository.save(pessoa);

	}

	@PutMapping(value = "/{codigo}")
	public ResponseEntity atualizar(@PathVariable("codigo") Long codigo, @RequestBody GruposPrioridades gruposPrioridades) {

		return grupoPrioridadeRepository.findById(codigo).map(

				record -> {
					record.setNome(gruposPrioridades.getNome());
					record.setDecricao(gruposPrioridades.getDecricao());
					GruposPrioridades up = grupoPrioridadeRepository.save(record);
					return ResponseEntity.ok().body(up);

				}).orElse(ResponseEntity.notFound().build());

	}

	@GetMapping("/{codigo}")
	public GruposPrioridades buscarPeloCodigo(@PathVariable Long codigo) {
		return grupoPrioridadeRepository.findById(codigo).orElse(null);
	}
	
	
}
