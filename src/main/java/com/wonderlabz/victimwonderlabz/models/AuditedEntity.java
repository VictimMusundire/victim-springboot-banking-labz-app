package com.wonderlabz.victimwonderlabz.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
@ToString
public abstract class AuditedEntity implements Serializable {

    @Column(updatable = false)
    @CreationTimestamp
    @JsonIgnore
    protected LocalDateTime created;

    @UpdateTimestamp
    @JsonIgnore
    protected LocalDateTime lastModified;

    @CreatedBy
    @JsonIgnore
    protected String createdBy;

    @LastModifiedBy
    @JsonIgnore
    protected String modifiedBy;

}
