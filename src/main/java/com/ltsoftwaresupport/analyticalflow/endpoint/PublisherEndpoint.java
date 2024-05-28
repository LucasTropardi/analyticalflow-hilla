package com.ltsoftwaresupport.analyticalflow.endpoint;

import com.ltsoftwaresupport.analyticalflow.exception.DefaultException;
import com.ltsoftwaresupport.analyticalflow.model.Publisher;
import com.ltsoftwaresupport.analyticalflow.repository.PublisherRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.Endpoint;

/**
 * @author Lucas Tropardi
 * 26 de Mai. de 2024
 */
@Endpoint
@AnonymousAllowed
public class PublisherEndpoint extends DefaultEndpoint<Publisher, Long, PublisherRepository> {

    public PublisherEndpoint(PublisherRepository repository) {
        super(repository);
    }

    @Override
    protected void validate(Publisher entity, DefaultEndpoint.Mode mode) throws DefaultException {
        super.validate(entity, mode);

        switch (mode) {
            case SAVE:
                System.out.println("save");
                if (repository.existsById(entity.getId())) throw new DefaultException("Editora já cadastrada.");
                break;

            case UPDATE:
                System.out.println("update");
                if (!repository.existsById(entity.getId())) throw new DefaultException("Editora não cadastrada.");
                break;

            case DELETE:
                System.out.println("delete");
//                if (!repository.existsById(entity.getId())) throw new DefaultException("Editora não cadastrada.");
                break;
        }
    }
}
