package org.example.domain.diary.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.diary.controller.dto.request.DiaryIdRequest;
import org.example.domain.diary.controller.dto.request.DiaryPageRequest;
import org.example.domain.diary.controller.dto.request.DiaryUpdateRequest;
import org.example.domain.diary.controller.dto.request.DiaryWriteRequest;
import org.example.domain.diary.controller.dto.response.DiaryPageResponse;
import org.example.domain.diary.controller.dto.response.DiaryReadResponse;
import org.example.domain.diary.entity.DiaryEntity;
import org.example.domain.diary.repository.DiaryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaryService {
    private final DiaryRepository diaryRepository;
    public void write(DiaryWriteRequest diaryWriteRequest) {
        diaryRepository.save(
                new DiaryEntity().builder()
                        .date(diaryWriteRequest.getDate())
                        .content(diaryWriteRequest.getContent())
                        .img(diaryWriteRequest.getImg())
                        .build()
        );
    }
    public void delete(DiaryIdRequest diaryIdRequest) {
        diaryRepository.delete(diaryRepository.findById(diaryIdRequest.getId()));
    }
    public void update(DiaryUpdateRequest diaryUpdateRequest) {
        diaryRepository.save(
                DiaryEntity.builder()
                        .id(diaryUpdateRequest.getId())
                        .content(diaryUpdateRequest.getContent())
                        .img(diaryUpdateRequest.getImg())
                        .build()
        );
    }

    public DiaryReadResponse read(DiaryIdRequest diaryIdRequest) {
        DiaryEntity diaryEntity = diaryRepository.findById(diaryIdRequest.getId());
        return new DiaryReadResponse(
                diaryEntity.getDate(),
                diaryEntity.getContent(),
                diaryEntity.getImg());
    }
    public List<DiaryPageResponse> page(DiaryPageRequest diaryPageRequest){
        return diaryRepository.findAll()
                .stream()
                .map(a->new DiaryPageResponse(a.getDate(), a.getId()))
                .toList();
    }
}
