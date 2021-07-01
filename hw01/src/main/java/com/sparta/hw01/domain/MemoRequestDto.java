package com.sparta.hw01.domain;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class MemoRequestDto {

    private String title;
    private String username;
    private String contents;

}
