package Model;

import Core.Atendimento;
import Core.Eleitor;

public class AtendimentoVotar extends Atendimento {

    public AtendimentoVotar(Eleitor eleitor) {

        super(eleitor, 2);
        eleitor.setTipoAtendimento("votar");
        
    }

}