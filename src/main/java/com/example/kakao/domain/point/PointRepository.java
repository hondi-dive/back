package com.example.kakao.domain.point;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface PointRepository extends JpaRepository<Point, Integer> {
    Optional<Point> findByName(String name);
}
