package br.com.andremarinhodev.lanchonete.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.andremarinhodev.lanchonete.controller.form.ProdutoForm;
import br.com.andremarinhodev.lanchonete.model.Produto;
import br.com.andremarinhodev.lanchonete.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;

	public Page<Produto> findAll(Pageable paginacao) {
		return repository.findAll(paginacao);
	}

	public void save(Produto produto) {
		repository.save(produto);
	}

	public boolean atualizarProduto(Long id, ProdutoForm form) {
		Optional<Produto> optional = repository.findById(id);
		if (optional.isPresent()) {
			form.atualizar(repository.getById(id));
			return true;
		}
		return false;
	}
	
}
