package com.ohgiraffers.finalassignmentyeonjo.member.controller;

import com.ohgiraffers.finalassignmentyeonjo.common.Pagenation;
import com.ohgiraffers.finalassignmentyeonjo.common.PagingButtonInfo;
import com.ohgiraffers.finalassignmentyeonjo.member.dto.MemberDTO;
import com.ohgiraffers.finalassignmentyeonjo.member.service.MemberService;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    private final ModelMapper modelMapper;

    public MemberController(MemberService memberService, ModelMapper modelMapper) {
        this.memberService = memberService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{memberCode}")
    public String findMemberByCode(@PathVariable int memberCode, Model model) {
        MemberDTO member = memberService.findMemberByCode(memberCode);
        model.addAttribute("member", member);

        return "member/detail";
    }

    @GetMapping("/list")
    public String findAllMember(@PageableDefault Pageable pageable, Model model) {

        Page<MemberDTO> memberList = memberService.findAllMember(pageable);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(memberList);
        model.addAttribute("paging", paging);
        model.addAttribute("memberList", memberList);

        return "/member/list";
    }

    @GetMapping("/regist")
    public void registPage() {}


    @PostMapping("/regist")
    public String registMember(MemberDTO member) {
        member.setLaunchDate(member.getLaunchDate().replace("-", ""));
        member.setContact(member.getContact().replace("-", ""));
        memberService.registNewMember(member);

        return "redirect:/member/list";
    }


    @GetMapping("/searchModify")
    public void checkModifyPage(){}

    @GetMapping("/modify")
    public String checkModifyMember(@RequestParam Integer memberCode, Model model) {
        MemberDTO modifyMember = memberService.findMemberByCode(memberCode);

        model.addAttribute("modifyMember", modifyMember);
        model.addAttribute("memberCode", memberCode);

        return "member/modify";
    }

    @PostMapping("/modify")
    public String modifyMember(MemberDTO modifyMember) {
        modifyMember.setLaunchDate(modifyMember.getLaunchDate().replace("-", ""));
        modifyMember.setContact(modifyMember.getContact().replace("-", ""));
        memberService.modifyMember(modifyMember);
        return "redirect:/member/" + modifyMember.getMemberCode();
    }

    @GetMapping("/delete")
    public void deletePage(){}

    @PostMapping("/delete")
    public String deleteMember(@RequestParam Integer memberCode) {
        memberService.deleteMember(memberCode);

        return "redirect:/member/list";
    }

    @GetMapping("/search")
    public void searchPage(){}

    @PostMapping("/search")
    public String searchMember(@RequestParam Integer memberCode, Model model) {
        model.addAttribute("memberCode", memberCode);

        return"redirect:/member/" + memberCode;
    }

    @GetMapping("/searchName")
    public void searchNamePage(){}

    @PostMapping("/searchName")
    public String searchName(@RequestParam String memberName, Model model) {
        List<MemberDTO> memberList = memberService.findMemberByName(memberName);

        model.addAttribute("memberName", memberName);
        model.addAttribute("memberList", memberList);

        return "member/memberNameList";
    }
}
