package com.example.kakao.domain.tag.repository;
import com.example.kakao.domain.tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    Set<Tag> findByNameIn(Set<String> tagNames);

    Optional<Tag> findByName(String name);
}
