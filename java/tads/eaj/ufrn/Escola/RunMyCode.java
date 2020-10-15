package tads.eaj.ufrn.Escola;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import tads.eaj.ufrn.Escola.Modelo.Aluno;
import tads.eaj.ufrn.Escola.Modelo.Credencial;
import tads.eaj.ufrn.Escola.Repositorio.RepositorioAluno;
import tads.eaj.ufrn.Escola.Repositorio.RepositorioCredencial;
import tads.eaj.ufrn.Escola.Repositorio.RepositorioCurso;

import javax.transaction.Transactional;

@Component
public class RunMyCode implements ApplicationRunner {

	@Autowired
	RepositorioAluno repositorioAluno ;
	@Autowired
	RepositorioCredencial repositorioCredencial;
	@Autowired
	RepositorioCurso repositorioCurso;

	@Override
	@Transactional

	public void run(ApplicationArguments args) throws Exception {



























//put com tudo
//		{
//			"nome": "marcos",
//				"credencial": {
//
//			"cpf": "70043234332"
//		}, "curso": {
//			"name":"carro"
//		}
//cadastrar credencial
//		{
//			"cpf": "300435433"
//		}

//(GET): http://localhost:8080/Curso
//		{
//			"name":"discplina",
//				"disciplina":[
//			{
//
//				"nomeDisciplina": "Taniro"
//			},
//			{
//
//				"nomeDisciplina": "Tniro"
//			},
//			{
//
//				"nomeDisciplina": "Tniro"
//			}
//]
//Adicionar um curso com disciplinas
//		{"name":"tads",
//				"disciplina":[
//			{
//
//				"nomeDisciplina": "futebol"
//			},
//			{
//
//				"nomeDisciplina": "Tniro"
//			},
//			{
//
//				"nomeDisciplina": "mestre"
//			}
//]
//
//		}








//		}
//		Aluno a = new Aluno();
//		Credencial c = new Credencial();
//
//
//		c.setCpf("70043234332");
//		a.setNome("marcos");
//		a.setCredencial(c);
//
//		repositorioAluno.save(a);





		/*
		clienteRepository.save(c1);
		c1.setEndereco(null);
		clienteRepository.save(c1);
		 */


		/*
		//Caso 1
		c1.setEndereco(e1);
		e1.setCliente(c1);
		enderecoRepositoty.save(e1);
		 */

		/*
		//Caso 2
		enderecoRepositoty.save(e1);
		c1.setEndereco(e1);
		e1.setCliente(c1);
		clienteRepository.save(c1);
		 */

		/*
		//Caso 3
		enderecoRepositoty.save(e1);
		c1.setEndereco(e1);
		e1.setCliente(c1);
		clienteRepository.save(c1);
		 */

		/*
		//Caso 4
		enderecoRepositoty.save(e1);
		c1.setEndereco(e1);
		e1.setCliente(c1);
		clienteRepository.save(c1);
		 */

		/*
		//Cliente e Pedidos
		Cliente c1 = new Cliente();
		c1.setNome("João");
		Endereco e1 = new Endereco();
		e1.setRua("Lagoa");
		c1.setEndereco(e1);
		e1.setCliente(c1);

		Pedido p1 = new Pedido();
		Pedido p2 = new Pedido();
		Pedido p3 = new Pedido();

		p1.setDataPedido("pedido1");
		p2.setDataPedido("pedido2");
		p3.setDataPedido("pedido3");

		List<Pedido> pedidos = new ArrayList<>();
		pedidos.add(p1);
		pedidos.add(p2);
		pedidos.add(p3);

		c1.setPedidos(pedidos);

		//clienteRepository.save(c1);

		p1.setCliente(c1);
		p2.setCliente(c1);
		p3.setCliente(c1);


		clienteRepository.save(c1);
		//pedidoRepository.save(p2);
		//pedidoRepository.save(p3);


		//c1.setPedidos(pedidos);
		 */


		//fetch tests
		//Cliente c1 = clienteRepository.getOne((long) 1);
		//System.out.println(c1.getNome());
		//System.out.println(c1.getEndereco().getRua());
		//System.out.println(c1.getPedidos().get(1).toString());

		/*
		//Many to Many
		Cliente c1 = new Cliente();
		c1.setNome("pedro");

		Endereco e1 = new Endereco();
		e1.setRua("jundiai");

		c1.setEndereco(e1);
		e1.setCliente(c1);

		Pedido o = new Pedido();
		o.setDataPedido("hoje");

		List<Pedido> pedidoList = new ArrayList<>();
		pedidoList.add(o);

		o.setCliente(c1);
		c1.setPedidos(pedidoList);

		Produto p1 = new Produto();
		Produto p2 = new Produto();
		Produto p3 = new Produto();

		p1.setDescricao("produto 1");
		p2.setDescricao("produto 2");
		p3.setDescricao("produto 3");

		p1.setPedidos(pedidoList);
		p2.setPedidos(pedidoList);
		p3.setPedidos(pedidoList);

		List<Produto> produtoList = new ArrayList<>();
		produtoList.add(p1);
		produtoList.add(p2);
		produtoList.add(p3);

		o.setProdutos(produtoList);

		clienteRepository.save(c1);

		 */
	}
}
