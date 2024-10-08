package gosuclass.infra;

import gosuclass.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class EvaluationHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Evaluation>> {

    @Override
    public EntityModel<Evaluation> process(EntityModel<Evaluation> model) {
        return model;
    }
}
