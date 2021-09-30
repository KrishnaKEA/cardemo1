package cardemo1.demo.services;

import cardemo1.demo.dtos.MemberDTO;
import cardemo1.demo.entities.Member;
import cardemo1.demo.repo.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
   MemberRepo memberRepo;
    public List<MemberDTO> getMembers(){
        Iterable<Member> members = memberRepo.findAll();
                return MemberDTO.getMemberDTOsFromMember(members);
    }
    public MemberDTO addMember(MemberDTO newMember){
        Member memberToAdd = MemberDTO.getMemberFromMemberDTO(newMember);
        return new MemberDTO(memberRepo.save(memberToAdd));
    }

}
