package com.example.kakao.domain.divepost;

import com.example.kakao.domain.point.Point;
import com.example.kakao.domain.user.User;
import com.example.kakao.global.types.DiveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface DivepostRepository extends JpaRepository<Divepost, Integer> {
    List<Divepost> findAllByPointOrderByDateDesc(Point point);

    @Query("SELECT d FROM Divepost d WHERE d.diveType=:diveType AND d.point=:point ORDER BY d.date DESC")
    List<Divepost> findAllByPointAndDiveType(@Param("point") Point point, @Param("diveType") DiveType diveType);
}
