package com.example.kakao.domain.feedback.dto;

import com.example.kakao.domain.feedback.Feedback;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FeedbackDto {
    private String userName;
    private String content;

    public static FeedbackDto from(Feedback feedback) {
        return FeedbackDto.builder()
                .userName(feedback.getUser().getUserName())
                .content(feedback.getContent())
                .build();
    }
}
