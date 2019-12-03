package com.done.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.done.model.Vestuario;
import com.done.repository.VestuarioRepository;

@RestController
@RequestMapping("/vestuario")
public class VestuarioResources {

	@Autowired
	private VestuarioRepository vestuarioRepository;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public List<Vestuario> list() {
		return vestuarioRepository.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public Optional<Vestuario> findById(@PathVariable Long id) {
		return vestuarioRepository.findById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
	public ResponseEntity<Vestuario> create(@RequestBody Vestuario vestuario, HttpServletResponse response) {
		Vestuario save = vestuarioRepository.save(vestuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId())
				.toUri();

		return ResponseEntity.created(uri).body(save);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/{id}")
	public ResponseEntity<Vestuario> update(@PathVariable Long id, @RequestBody Vestuario vestuario) {
		Optional<Vestuario> vestuarioBanco = vestuarioRepository.findById(id);
		BeanUtils.copyProperties(vestuario, vestuarioBanco.get(), "id");
		vestuarioRepository.save(vestuarioBanco.get());
		
		return ResponseEntity.ok(vestuario);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		vestuarioRepository.deleteById(id);
	}

}
