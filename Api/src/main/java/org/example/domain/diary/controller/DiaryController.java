package org.example.domain.diary.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.diary.controller.dto.request.DiaryIdRequest;
import org.example.domain.diary.controller.dto.request.DiaryPageRequest;
import org.example.domain.diary.controller.dto.request.DiaryUpdateRequest;
import org.example.domain.diary.controller.dto.request.DiaryWriteRequest;
import org.example.domain.diary.controller.dto.response.DiaryPageResponse;
import org.example.domain.diary.controller.dto.response.DiaryReadResponse;
import org.example.domain.diary.service.DiaryService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diary")
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;

    @PostMapping("/write")
    public void write(@RequestBody DiaryWriteRequest diaryWriteRequest) {diaryService.write(diaryWriteRequest);}

    @DeleteMapping("/delete")
    public void delete(@RequestBody DiaryIdRequest diaryIdRequest) {diaryService.delete(diaryIdRequest);}

    @PatchMapping("/update")
    public void update(@RequestBody DiaryUpdateRequest diaryUpdateRequest) {diaryService.update(diaryUpdateRequest);}

    @GetMapping("/page")
    public List<DiaryPageResponse> page(@RequestBody DiaryPageRequest diaryPageRequest){return diaryService.page(diaryPageRequest);}

    @GetMapping("/read")
    public DiaryReadResponse read(@RequestBody DiaryIdRequest diaryIdRequest){return diaryService.read(diaryIdRequest);}

}
