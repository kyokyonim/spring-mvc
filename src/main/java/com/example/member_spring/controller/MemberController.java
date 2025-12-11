package com.example.member_spring.controller;

import com.example.member_spring.controller.dto.MemberCreateDto;
import com.example.member_spring.controller.dto.MemberUpdateDto;
import com.example.member_spring.domain.Member;
import com.example.member_spring.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members =  memberService.findMembers();
        model.addAttribute("members", members);
        return "index";
    }
   @GetMapping("/members/new")
    public String createForm(Model model){
        model.addAttribute("create", new MemberCreateDto());
        return "members/createMemberForm";
   }
   @PostMapping("/members/new")
    public String create(@ModelAttribute("create") @Valid MemberCreateDto update,
                         BindingResult bindingResult){
        Member member = new Member();
        member.setName(update.getName());
        member.setAge(update.getAge());
        member.setEmail(update.getEmail());

        memberService.join(member);
        return "redirect:/";
   }
   @GetMapping("/members/{id}/edit")
    public String editForm(@PathVariable Long id,Model model){
        Member member = memberService.findById(id);

        MemberUpdateDto dto = new MemberUpdateDto();
        dto.setAge(member.getAge());
        dto.setName(member.getName());
        dto.setEmail(member.getEmail());

        model.addAttribute("memberId", id);
        model.addAttribute("form", dto);

        return "members/editMemberForm";
   }
   @PostMapping("/members/{id}/edit")
    public String edit(@PathVariable Long id, @ModelAttribute("form") MemberUpdateDto dto ){
        memberService.update(id, dto.getName(),dto.getAge(),dto.getEmail());
       return "redirect:/members";
   }

   @PostMapping("/members/{id}/delete")
    public String delete(@PathVariable Long id){
        memberService.deleteMember(id);
        return "redirect:/members";
   }
}
