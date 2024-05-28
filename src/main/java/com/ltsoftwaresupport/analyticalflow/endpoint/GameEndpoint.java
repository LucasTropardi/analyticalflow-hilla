package com.ltsoftwaresupport.analyticalflow.endpoint;

import com.ltsoftwaresupport.analyticalflow.exception.DefaultException;
import com.ltsoftwaresupport.analyticalflow.model.Game;
import com.ltsoftwaresupport.analyticalflow.repository.GameRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.Endpoint;

/**
 * @author Lucas Tropardi
 * 26 de Mai. de 2024
 */
@Endpoint
@AnonymousAllowed
public class GameEndpoint extends DefaultEndpoint<Game, Long, GameRepository> {

    public GameEndpoint(GameRepository repository) {
        super(repository);
    }

    @Override
    protected void validate(Game entity, DefaultEndpoint.Mode mode) throws DefaultException {
        super.validate(entity, mode);

        switch (mode) {
            case SAVE:
                System.out.println("save");
                if (repository.existsById(entity.getId())) throw new DefaultException("Jogo já cadastrado.");
                break;

            case UPDATE:
                System.out.println("update");
                if (!repository.existsById(entity.getId())) throw new DefaultException("Jogo não cadastrado.");
                break;

            case DELETE:
                System.out.println("delete");
//                if (!repository.existsById(entity.getId())) throw new DefaultException("Jogo não cadastrado.");
                break;
        }
    }
}
