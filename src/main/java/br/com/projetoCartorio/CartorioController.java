package br.com.projetoCartorio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.projetoCartorio.model.Cartorio;
import br.com.projetoCartorio.repository.CartorioRepository;

@Controller
public class CartorioController {

	@Autowired
	private CartorioRepository repository;

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	

	@RequestMapping("listarcartorios")
	public String listarCartorios(Model model) {

		Iterable<Cartorio> cartorios = repository.findAll();

		model.addAttribute("cartorios", cartorios);

		return "listarCartorios";
	}

	
	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, Model model) {

		Cartorio novoCartorio = new Cartorio(nome);

		repository.save(novoCartorio);

		String mensagem = "Cartório cadastrado com sucesso";

		model.addAttribute("mensagem", mensagem);

		return "sucesso";

	}
	

	@RequestMapping(value = "editar/{id}", method = RequestMethod.GET)
	public String editar(@PathVariable("id") Integer id, Model model) {

		Optional<Cartorio> cartorioId = repository.findById(id);
		
		Cartorio cartorio = new Cartorio();
		
		cartorio = cartorioId.get();
		
		model.addAttribute("cartorio", cartorio);

		return "Alterar";
	}
	

	@RequestMapping(value = "editar/salvar", method = RequestMethod.POST)
	public String salvarAlteracao(@RequestParam("id") Integer id, @RequestParam("nome") String nome, Model model) {

		Cartorio cartorioAlterado = new Cartorio(id, nome);

		repository.save(cartorioAlterado);

		String mensagem = "Cartório editado com sucesso";

		model.addAttribute("mensagem", mensagem);

		return "/sucesso";
	}
	

	@RequestMapping(value = "excluir/{id}", method = RequestMethod.GET)
	public String excluir(@PathVariable("id") Integer id, Model model) {

		Cartorio cartorio = new Cartorio(id);

		repository.deleteById(cartorio.getId());
		
		Iterable<Cartorio> cartorios = repository.findAll();

		model.addAttribute("cartorios", cartorios);


		return "listarcartorios";
	}
	

}
