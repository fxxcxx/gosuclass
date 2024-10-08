package gosuclass.infra;

import gosuclass.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class GosuClassHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<GosuClass>> {

    @Override
    public EntityModel<GosuClass> process(EntityModel<GosuClass> model) {
        return model;
    }
}
