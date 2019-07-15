package com.projetb32.koulouwakel.service;

import com.projetb32.koulouwakel.entity.Tag;
import com.projetb32.koulouwakel.repository.TagRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class TagService {

    private final TagRepository tagRepository;


    public TagService(TagRepository tagRepository) {
        super();
        this.tagRepository = tagRepository;
    }


    public Tag addTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public List<Tag> getAllTag() {


        return tagRepository.findAll();
    }

    public Optional<Tag> getTagById(Long id) {

        return tagRepository.findById(id);

    }

    public Optional<Tag> getTagByLabel(String label) {

        return tagRepository.findByLabel(label);
    }

    public void deleteTag(Long id) {

        tagRepository.deleteById(id);

    }

    public Tag updateTag(Long id,Tag tag) {


        Tag tagFound = tagRepository.findById(id).get();


        tagFound.setLabel(tag.getLabel());
        tagRepository.save(tagFound);

        return tagFound;
    }



}
