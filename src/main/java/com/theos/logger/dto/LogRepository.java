package com.theos.logger.dto;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theos.logger.entity.Log;

public interface LogRepository extends JpaRepository<Log,Long> {

    List<Log> findByLevelIgnoreCase(String level);

    List<Log> findByMessageContainingIgnoreCase(String message);

    List<Log> findByResourceIdIgnoreCase(String resourceId);

    List<Log> findByTimestampBetween(Instant startTime, Instant endTime);

    List<Log> findByMetadata(String metadataParentResourceId);

    List<Log> findByTraceId(String traceId);

    List<Log> findBySpanId(String spanId);

    List<Log> findByCommit(String commit);
}
