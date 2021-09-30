package cardemo1.demo.dtos;

import cardemo1.demo.entities.Member;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberDTO {
    Integer id;
    String firstName;
    String lastName;
    String street;
    String city;
    String zip;
    String email;

    public MemberDTO(Member m){
        this.id = m.getId();
        this.firstName =  m.getFirstName();
        this.lastName = m.getLastName();
        this.street = m.getStreet();
        this.city = m.getCity();
        this.zip = m.getZip();
        this.email = m.getEmail();
    }

    public static List<MemberDTO> getMemberDTOsFromMember(Iterable<Member> members){
        List<MemberDTO> dtos = new ArrayList<>();
        for(Member m : members){
           MemberDTO md = new MemberDTO(m);
           dtos.add(md);
        }
        return dtos;
    }
    public static Member getMemberFromMemberDTO(MemberDTO md){
        Member m = new Member();
        m.setFirstName(md.getFirstName());
        m.setLastName(md.getLastName());
        m.setStreet(md.getStreet());
        m.setZip(md.getZip());
        m.setEmail(md.getEmail());
        return m;
    }

}
