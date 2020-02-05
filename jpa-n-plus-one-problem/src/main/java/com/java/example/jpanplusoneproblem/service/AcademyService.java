package com.java.example.jpanplusoneproblem.service;

import com.java.example.jpanplusoneproblem.domain.Academy;
import com.java.example.jpanplusoneproblem.domain.AcademyRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AcademyService {
    private static final Logger log = LoggerFactory.getLogger(AcademyService.class);

    private AcademyRepository academyRepository;

    public AcademyService(AcademyRepository academyRepository) {
        this.academyRepository = academyRepository;
    }

    @Transactional(readOnly = true)
    public List<String> findAllSubjectNames(){
        return extractSubjectNames(academyRepository.findAll());
    }

    @Transactional(readOnly = true)
    public List<String> findAllSubjectNamesByJoinFetch(){
        return extractSubjectNames(academyRepository.findAllJoinFetch());
    }

    @Transactional(readOnly = true)
    public List<String> findAllSubjectNamesByEntityGraph() {
        return extractSubjectNames(academyRepository.findAllEntityGraph());
    }

    @Transactional(readOnly = true)
    public List<String> findAllSubjectNamesByJoinFetchDistinct(){
        return extractSubjectNames(academyRepository.findAllJoinFetchDistinct());
    }

    @Transactional(readOnly = true)
    public List<String> findAllSubjectNamesByEntityGraphDistinct() {
        return extractSubjectNames(academyRepository.findAllEntityGraphDistinct());
    }

    /**
     * Lazy Load 를 수행하기 위해 메소드를 별도로 생성
     */
    private List<String> extractSubjectNames(List<Academy> academies){
        log.info(">>>>>>>>[모든 과목을 추출한다]<<<<<<<<<");
        log.info("Academy Size : {}", academies.size());

        return academies.stream()
                .map(a -> a.getSubjects().get(0).getName())
                .collect(Collectors.toList());
    }
}
