package com.ltsoftwaresupport.analyticalflow.endpoint;

import com.ltsoftwaresupport.analyticalflow.exception.DefaultException;
import com.ltsoftwaresupport.analyticalflow.model.ReviewGame;
import com.ltsoftwaresupport.analyticalflow.repository.ReviewGameRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.Endpoint;

/**
 * @author Lucas Tropardi
 * 27 de Mai. de 2024
 */
@Endpoint
@AnonymousAllowed
public class ReviewGameEndpoint extends DefaultEndpoint<ReviewGame, Long, ReviewGameRepository> {

    public ReviewGameEndpoint(ReviewGameRepository repository) {
        super(repository);
    }

    @Override
    protected void validate(ReviewGame entity, DefaultEndpoint.Mode mode) throws DefaultException {
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
