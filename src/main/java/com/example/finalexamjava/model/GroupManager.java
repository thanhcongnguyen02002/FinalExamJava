package com.example.finalexamjava.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "groupmanager")
@Builder
@Data
@Slf4j
@RequiredArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "groupname")
    String groupName;
    @Column(name = "member")
    int member;
    @CreatedBy
    @Column(name = "creator")
    String creator;
    @Column(name = "updater")
    @LastModifiedDate

    OffsetDateTime updated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupManager that = (GroupManager) o;
        return member == that.member && Objects.equals(id, that.id) && Objects.equals(groupName, that.groupName) && Objects.equals(creator, that.creator) && Objects.equals(updated, that.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupName, member, creator, updated);
    }
}
