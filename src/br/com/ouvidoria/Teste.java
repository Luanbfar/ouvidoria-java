package br.com.ouvidoria;

import javax.swing.JOptionPane;

import br.com.ouvidoria.acoes.AcoesOuvidoria;
import br.com.ouvidoria.data.ManifestacoesDeTeste;
import br.com.ouvidoria.entidades.Manifestacao;
import br.com.ouvidoria.entidades.Manifestacao.Tipo;
import br.com.ouvidoria.entidades.Ouvidoria;

public class Teste {

	public static void main(String[] args) {

		Ouvidoria ouvidoria = new Ouvidoria();

		for (Manifestacao manifesto : ManifestacoesDeTeste.listaDados) {
			ouvidoria.adicionarManifestacao(manifesto);
			System.out.println(manifesto.getCodigo());
		}

		int opcao;
		String msg;
		do {

			String menu = AcoesOuvidoria.obterMenu();
			String opcaoStr = JOptionPane.showInputDialog(menu);
			opcao = Integer.parseInt(opcaoStr);

			switch (opcao) {
			case 1: 
				msg = AcoesOuvidoria.listarManifestacoes(ouvidoria.obterListaReclamacao());
				JOptionPane.showConfirmDialog(null, msg);
				break;
			case 2: 
				msg = AcoesOuvidoria.listarReclamacao(ouvidoria.obterListaReclamacao());
				JOptionPane.showConfirmDialog(null, msg);
				break;
			case 3: 
				msg = AcoesOuvidoria.listarSugestao(ouvidoria.obterListaReclamacao());
				JOptionPane.showConfirmDialog(null, msg);
				break;
			case 4: 
				msg = AcoesOuvidoria.listarElogio(ouvidoria.obterListaReclamacao());
				JOptionPane.showConfirmDialog(null, msg);
				break;
			case 5:
				String reclamante = JOptionPane.showInputDialog("Reclamante:");
				String titulo = JOptionPane.showInputDialog("Titulo:");
				String descricao = JOptionPane.showInputDialog("Descricao:");
				String tipoStr = JOptionPane.showInputDialog("Tipo: \n1)Reclamacao \n2)Sugestao \n3)Elogios");
				Tipo tipo = Tipo.RECLAMACAO;
				
				if(tipoStr == "2") {
					tipo = Tipo.SUGESTAO;
				}else if(tipoStr == "3") {
					tipo = Tipo.ELOGIO;
				}
				
				if (reclamante.length() == 0) {
					ouvidoria.adicionarManifestacao(
							new Manifestacao(titulo, descricao, tipo));
				}else {
					ouvidoria.adicionarManifestacao(
							new Manifestacao(reclamante, titulo, descricao, tipo));
				}
				
				break;
			case 6:
				String codigoStr = JOptionPane.showInputDialog("Codigo: ");
				int codigo = Integer.parseInt(codigoStr);
				msg = AcoesOuvidoria.montarResultadoPesquisa(ouvidoria.pesquisarReclamcao(codigo));

				JOptionPane.showConfirmDialog(null, msg);
				break;
			default:
				// throw new IllegalArgumentException("Unexpected value: " + opcao);
			}

		} while (opcao != 9);

	}

}
