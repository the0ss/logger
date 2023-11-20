package com.theos.logger.services;

import java.time.Instant;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.theos.logger.dto.LogRepository;
import com.theos.logger.entity.Log;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class queryservice {

    private final LogRepository logRepository;

    @Cacheable("level")
    public List<Log> findByLevel(@RequestParam String level) {
        List<Log> logs = logRepository.findByLevelIgnoreCase(level);
        return logs;
    }
    @Cacheable("message")
    public List<Log> findByMessage(@RequestParam String message) {
        List<Log>logs= logRepository.findByMessageContainingIgnoreCase(message);
        return logs;
    }
    @Cacheable("resId")
    public List<Log> findByResourceId(@RequestParam String resourceId) {
        List<Log>logs= logRepository.findByResourceIdIgnoreCase(resourceId);
        return logs;
    }
    @Cacheable("timestamp")
    public List<Log> findByTimestamp(@RequestParam String startTime, @RequestParam String endTime) {
        Instant startInstant = Instant.parse(startTime);
        Instant endInstant = Instant.parse(endTime);
        List<Log> logs= logRepository.findByTimestampBetween(startInstant, endInstant);
        return logs;
    }
    @Cacheable("traceId")
    public List<Log> getLogsByTraceId(@PathVariable String traceId) {
        List<Log> logs = logRepository.findByTraceId(traceId);
        return logs;
    }

    @Cacheable("spanId")
    public List<Log> getLogsBySpanId(@PathVariable String spanId) {
        List<Log> logs = logRepository.findBySpanId(spanId);
        return logs;
    }

    @Cacheable("commit")
    public List<Log> getLogsByCommit(@PathVariable String commit,Model model) {
        List<Log> logs = logRepository.findByCommit(commit);
        return logs;
    }
    
    @Cacheable("metadata")
    public List<Log> getLogsByMetadataParentResourceId(@PathVariable String parentResourceId) {
        List<Log> logs = logRepository.findByMetadata(parentResourceId);
        return logs;
    }

}
