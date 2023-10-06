package br.com.ouvidoria.data;

import br.com.ouvidoria.entidades.Manifestacao;
import br.com.ouvidoria.entidades.Manifestacao.Tipo;

public class ManifestacoesDeTeste {
	
	public static final Manifestacao[] listaDados = {
			new Manifestacao("Salve salve", "Salve salve", Tipo.RECLAMACAO),
			new Manifestacao("Cinco estrela", "10/10", Tipo.ELOGIO),
			new Manifestacao("Salve salve diferente", "Salve salve diferente", Tipo.SUGESTAO),
			new Manifestacao("Acnaldo", "Salve salve diferente", "Salve salve diferente", Tipo.SUGESTAO)
	};

}
