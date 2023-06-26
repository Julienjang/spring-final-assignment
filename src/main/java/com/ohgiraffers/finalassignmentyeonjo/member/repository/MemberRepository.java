package com.ohgiraffers.finalassignmentyeonjo.member.repository;

import com.ohgiraffers.finalassignmentyeonjo.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    @Query(value = "SELECT MEMBER_CODE, MEMBER_NAME, LAUNCH_DATE, DIVISION_CODE, DETAIL_INFO, STUDENT_QUANTITY, CONTACT, TEAM_CODE, ACTIVE_STATUS FROM MEMBER_INFO WHERE MEMBER_NAME LIKE CONCAT('%', :memberName, '%')", nativeQuery = true)
    List<Member> findByMemberName(@Param("memberName") String memberName);

}
