package com.example.finalexamjava.repository.postgres;

import com.example.finalexamjava.controller.GroupFilter;
import com.example.finalexamjava.model.GroupManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GroupSpecification {
    public  static Specification<GroupManager> withFilter(GroupFilter filter){
        return Specification.where(withName(filter.groupName()))
                .and(withMinId(filter.minId()))
                .and(withMaxId(filter.maxId()))
                .and(withId(filter.id()));

    }

    private static Specification<GroupManager> withId(Long id) {
        if( id == null){
            return null;
        }
        return  (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    private static Specification<GroupManager> withMaxId(Long maxId) {
        if (maxId == null){
            return  null;
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("id"), maxId);
    }

    private static Specification<GroupManager> withMinId(Long minId) {
       if(minId == null){
           return  null;
       }
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("id"), minId);
    }

    private static Specification<GroupManager> withName(String groupname) {
        if(groupname == null){
            return  null;
        }
        return (root, query, criteriaBuilder) ->  criteriaBuilder.like(root.get("groupName"),"%"+groupname+"%");
    }
}
