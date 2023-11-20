package com.theos.logger.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.theos.logger.dto.LogRepository;
import com.theos.logger.entity.Log;
import com.theos.logger.services.queryservice;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping
@AllArgsConstructor
public class LogController {
    private final LogRepository logRepository;

    private final queryservice queryservice;
    
    @GetMapping("/")
    public String index() {
        return "home";
    }
    @PostMapping("/ingest")
    public ResponseEntity<String> ingestLog(@RequestBody Log log) {
        logRepository.save(log);
        return ResponseEntity.ok("Log ingested successfully.");
    }

    @GetMapping("/findByLevel")
    public String findByLevel(@RequestParam String level,Model model) {
        List<Log> logs= queryservice.findByLevel(level);
        model.addAttribute("logs", logs);
        return "home";
    }

    @GetMapping("/findByMessage")
    public String findByMessage(@RequestParam String message,Model model) {
        List<Log>logs= queryservice.findByMessage(message);
        model.addAttribute("logs", logs);
        return "home";
    }

    @GetMapping("/findByResourceId")
    public String findByResourceId(@RequestParam String resourceId,Model model) {
        List<Log>logs= queryservice.findByResourceId(resourceId);
        model.addAttribute("logs", logs);
        return "home";
    }

    @GetMapping("/findByTimestamp")
    public String findByTimestamp(@RequestParam String startTime, @RequestParam String endTime,Model model) {
        List<Log>logs= queryservice.findByTimestamp(startTime, endTime);
        model.addAttribute("logs", logs);
        return "home";
    }

    @GetMapping("/traceId")
    public String getLogsByTraceId(@RequestParam String traceId,Model model) {
        List<Log>logs= queryservice.getLogsByTraceId(traceId);
        model.addAttribute("logs", logs);
        return "home";
    }

    @GetMapping("/spanId")
    public String getLogsBySpanId(@PathVariable String spanId,Model model) {
        List<Log>logs= queryservice.getLogsBySpanId(spanId);
        model.addAttribute("logs", logs);
        return "home";
    }

    @GetMapping("/commit")
    public String getLogsByCommit(@RequestParam String commit, Model model) {
        List<Log>logs=queryservice.getLogsByCommit(commit,model);
        model.addAttribute("logs", logs);
        return "home";

    }
    
    @GetMapping("/metadata/parentResourceId")
    public String getLogsByMetadataParentResourceId(@RequestParam String parentResourceId,Model model) {
        List<Log>logs= queryservice.getLogsByMetadataParentResourceId(parentResourceId);
        model.addAttribute("logs", logs);
        return "home";
    }
}
