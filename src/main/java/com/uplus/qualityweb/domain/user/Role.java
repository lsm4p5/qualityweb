package com.uplus.qualityweb.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Embeddable
public enum Role {
    GUEST("ROLE_GUEST","손님"),
    USER("ROLE_USER", "일반 사용자");

    @Column(name="user_key")
    private final String key;
    private final String title;
}
