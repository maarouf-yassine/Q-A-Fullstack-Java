/*package com.maarouf.qaApp.assembler;

import com.maarouf.qaApp.model.QuestionTypes;
import com.maarouf.qaApp.service.QTypeService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class QTypeModelAssembler implements RepresentationModelAssembler<QuestionTypes, EntityModel<QuestionTypes>> {

    @Override
    public EntityModel<QuestionTypes> toModel(QuestionTypes qtype) {
        return EntityModel.of(qtype,
                linkTo(methodOn(QTypeService.class).one(qtype.getTypeid())).withSelfRel(),
                linkTo(methodOn(QTypeService.class).all()).withRel("api/types"));
    }
}*/
