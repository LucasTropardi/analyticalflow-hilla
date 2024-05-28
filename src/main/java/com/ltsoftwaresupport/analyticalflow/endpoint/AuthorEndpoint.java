package com.ltsoftwaresupport.analyticalflow.endpoint;

import com.ltsoftwaresupport.analyticalflow.exception.DefaultException;
import com.ltsoftwaresupport.analyticalflow.model.Author;
import com.ltsoftwaresupport.analyticalflow.model.User;
import com.ltsoftwaresupport.analyticalflow.repository.AuthorRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import dev.hilla.Endpoint;

/**
 * @author Lucas Tropardi
 * 26 de Mai. de 2024
 */
@Endpoint
@AnonymousAllowed
public class AuthorEndpoint extends DefaultEndpoint<Author, Long, AuthorRepository> {

	AuthorEndpoint(AuthorRepository repository) {
		super(repository);
	}
	
	@Override
    protected void validate(Author entity, DefaultEndpoint.Mode mode) throws DefaultException {
        super.validate(entity, mode);

        switch (mode) {
            case SAVE:
                System.out.println("save");
                if (repository.existsById(entity.getId())) throw new DefaultException("Autor já cadastrado.");
                break;

            case UPDATE:
                System.out.println("update");
                if (!repository.existsById(entity.getId())) throw new DefaultException("Autor não cadastrado.");
                break;

            case DELETE:
                System.out.println("delete");
//                if (!repository.existsById(entity.getId())) throw new DefaultException("Autor não cadastrado.");
                break;
        }
    }
}
