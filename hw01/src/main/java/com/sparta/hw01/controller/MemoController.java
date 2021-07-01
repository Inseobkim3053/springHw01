package com.sparta.hw01.controller;

import com.sparta.hw01.domain.Memo;
import com.sparta.hw01.domain.MemoRepository;
import com.sparta.hw01.domain.MemoRequestDto;
import com.sparta.hw01.service.MemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now();
        System.out.println(memoRepository.findAll(Sort.by(Sort.Direction.DESC,"createdAt")));
        return memoRepository.findAll(Sort.by(Sort.Direction.DESC,"createdAt"));

    }

    @GetMapping("/api/memos/{id}")
    public Optional<Memo> getDetail(@PathVariable Long id) {
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now();
        System.out.println(memoRepository.findById(id));
        return memoRepository.findById(id);

    }

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        log.info("request dto {}", requestDto);
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        memoService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }
}