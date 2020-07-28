package Model;

import Core.Atendimento;
import Core.Eleitor;

public class AtendimentoJustificativa extends Atendimento {

    public AtendimentoJustificativa(Eleitor eleitor) {
        
        super(eleitor, 1);
        eleitor.setTipoAtendimento("justificar");

    }

}