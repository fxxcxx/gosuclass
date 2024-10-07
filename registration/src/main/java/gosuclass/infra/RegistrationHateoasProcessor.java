package gosuclass.infra;

import gosuclass.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class RegistrationHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Registration>> {

    @Override
    public EntityModel<Registration> process(EntityModel<Registration> model) {
        return model;
    }
}
