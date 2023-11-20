package com.theos.logger.entity;

import java.time.Instant;
import java.util.Map;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "log",indexes = {@Index(columnList = "timestamp"),@Index(columnList = "level"),@Index(columnList = "resourceId"),@Index(columnList = "message")})
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String level;
    private String message;
    private String resourceId;
    private Instant timestamp;
    private String traceId;
    private String spanId;
    private String commit;

    @ElementCollection
    @CollectionTable(name = "log_metadata", joinColumns = @JoinColumn(name = "log_id"))
    @MapKeyColumn(name = "keyy")
    @Column(name = "value")
    private Map<String, String> metadata;
}
