package com.example.thecodetest.mockito.study;

import com.example.thecodetest.mockito.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long> {
}
