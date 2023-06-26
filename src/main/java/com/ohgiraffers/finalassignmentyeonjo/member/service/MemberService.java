package com.ohgiraffers.finalassignmentyeonjo.member.service;

import com.ohgiraffers.finalassignmentyeonjo.member.dto.MemberDTO;
import com.ohgiraffers.finalassignmentyeonjo.member.entity.Member;
import com.ohgiraffers.finalassignmentyeonjo.member.repository.MemberRepository;
import com.ohgiraffers.finalassignmentyeonjo.team.entity.Team;
import com.ohgiraffers.finalassignmentyeonjo.team.repository.TeamRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;

    public MemberService(MemberRepository memberRepository, TeamRepository teamRepository, ModelMapper modelMapper) {
        this.memberRepository = memberRepository;
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;

        // Adding the custom mappings
        modelMapper.addMappings(new PropertyMap<Member, MemberDTO>() {
            @Override
            protected void configure() {
                map().setTeamCode(source.getTeamCode().getTeamName());
                // Or whichever field you wish to map
            }
        });
    }


    public Page<MemberDTO> findAllMember(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("memberCode"));
        Page<Member> memberList = memberRepository.findAll(pageable);

        return memberList.map(member -> modelMapper.map(member, MemberDTO.class));
    }

    @Transactional
    public void registNewMember(MemberDTO member) {
        memberRepository.save(modelMapper.map(member, Member.class));
    }

    public MemberDTO findMemberByCode(int memberCode) {
        Member member = memberRepository.findById(memberCode).orElseThrow(IllegalAccessError::new);

        return modelMapper.map(member, MemberDTO.class);
    }

    @Transactional
    public void modifyMember(MemberDTO modifyMember) {
        Member member = memberRepository.findById(modifyMember.getMemberCode()).orElseThrow(IllegalAccessError::new);

        if (modifyMember.getMemberName() != null && !modifyMember.getMemberName().isEmpty()) {
            member.setMemberName(modifyMember.getMemberName());
        }
        if (modifyMember.getLaunchDate() != null && !modifyMember.getLaunchDate().isEmpty()) {
            member.setLaunchDate(modifyMember.getLaunchDate());
        }
        if (modifyMember.getDivisionCode() != null && !modifyMember.getDivisionCode().isEmpty()) {
            member.setDivisionCode(modifyMember.getDivisionCode());
        }
        if (modifyMember.getDetailInfo() != null && !modifyMember.getDetailInfo().isEmpty()) {
            member.setDetailInfo(modifyMember.getDetailInfo());
        }
        if (modifyMember.getStudentQuantity() != null && !modifyMember.getStudentQuantity().isEmpty()) {
            member.setStudentQuantity(modifyMember.getStudentQuantity());
        }
        if (modifyMember.getContact() != null && !modifyMember.getContact().isEmpty()) {
            member.setContact(modifyMember.getContact());
        }
        if (modifyMember.getTeamCode() != null) {
            Team team = teamRepository.findById(Integer.valueOf(modifyMember.getTeamCode())).orElseThrow(IllegalAccessError::new);
            member.setTeamCode(team);
        }
        if (modifyMember.getActiveStatus() != null && !modifyMember.getActiveStatus().isEmpty()) {
            member.setActiveStatus(modifyMember.getActiveStatus());
        }
    }

    @Transactional
    public void deleteMember(Integer memberCode) {
        memberRepository.deleteById(memberCode);
    }

    public List<MemberDTO> findMemberByName(String memberName) {
        List<Member> memberList = memberRepository.findByMemberName(memberName);

        return memberList.stream().map(member -> modelMapper.map(member, MemberDTO.class)).collect(Collectors.toList());
    }
}
