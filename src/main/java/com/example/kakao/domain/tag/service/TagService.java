package com.example.kakao.domain.tag.service;

import com.example.kakao.domain.divepost.Divepost;
import com.example.kakao.domain.divepost.DivepostRepository;
import com.example.kakao.domain.tag.Tag;
import com.example.kakao.domain.tag.dto.TagDto;
import com.example.kakao.domain.tag.dto.UpdateDivepostTagDto;
import com.example.kakao.domain.tag.repository.TagRepository;
import com.example.kakao.domain.user.User;
import com.example.kakao.domain.user.UserRepository;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class TagService {

    private TagRepository tagRepository;
    private DivepostRepository divepostRepository;

    @Transactional
    public Set<Tag> updateDivepostTag(UpdateDivepostTagDto updateTagDto) {
        Divepost divepost = divepostRepository.findById(updateTagDto.getId()).get();
        Set<Tag> tags = new HashSet<>();
        Optional<Tag> tagOptional = tagRepository.findByName(updateTagDto.getTag().getName());
        if (tagOptional.isPresent()) {
            tags.add(tagOptional.get());
        } else {
            Tag newTag = new Tag();
            newTag.setName(updateTagDto.getTag().getName());
            tags.add(tagRepository.save(newTag));
        }
        divepost.setTags(tags);
        return tags;
    }
}