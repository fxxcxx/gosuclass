package gosuclass.infra;

import gosuclass.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class RecommendHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Recommend>> {

    @Override
    public EntityModel<Recommend> process(EntityModel<Recommend> model) {
        return model;
    }
}
