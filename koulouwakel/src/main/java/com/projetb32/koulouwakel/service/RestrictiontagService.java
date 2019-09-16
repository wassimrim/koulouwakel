package com.projetb32.koulouwakel.service;

import com.projetb32.koulouwakel.entity.ConstraintTag;
import com.projetb32.koulouwakel.entity.ConstraintTagPk;
import com.projetb32.koulouwakel.repository.RestrictionRepository;
import com.projetb32.koulouwakel.repository.RestrictiontagRepository;
import com.projetb32.koulouwakel.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RestrictiontagService {

    @Autowired
    private RestrictionRepository restrictionRepository;
    @Autowired
    private RestrictiontagRepository restrictiontagRepository;
    @Autowired
    private TagRepository tagRepository;


    public ConstraintTag addRestrictionTag(long tag_id, long restriction_id) {

        ConstraintTag p = new ConstraintTag();
        ConstraintTagPk pp = new ConstraintTagPk();
        pp.setRestriction(restrictionRepository.findById(restriction_id).get());
        pp.setTag(tagRepository.findById(tag_id).get());
        p.setConstraintTagPk(pp);
        return restrictiontagRepository.save(p);
    }

    public List<ConstraintTag> getAllRestrictionTag() {


        return restrictiontagRepository.findAll();
    }

    public void deleteRestrictionTag(Long tagId, Long restrictiontId) {

        restrictiontagRepository.delete(new ConstraintTag
                (new ConstraintTagPk(tagRepository.findById(tagId).get(),
                        restrictionRepository.findById(restrictiontId).get())));
    }
}
