package team.shoppingmall.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Service;
import team.shoppingmall.domain.member.dto.*;
import team.shoppingmall.domain.member.entity.Member;
import team.shoppingmall.domain.member.repository.MemberRepository;

import java.util.NoSuchElementException;

@Service
@EnableJpaAuditing
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void singUp(SignUpInfoReq dto) {
        memberRepository
                .save(Member.createNewMember(dto))
                .updateLastActDate();
    }

    @Override
    public void singOut(AuthenticateDTO dto) {
        memberRepository.deleteById(dto.getId());
    }

    @Override
    public LoginRes login(LoginReq dto) {
        String id = memberRepository
                .findById(dto.getId())
                .orElseThrow(NoSuchElementException::new)
                .isValidPassword(dto.getPassword())
                .updateLastActDate()
                .initLoginTry()
                .getId();

        return new LoginRes(id);
    }

    @Override
    public void logout() {

    }

    @Override
    public String askForId(AskForIdDTO dto) {
        return memberRepository
                .findByNameAndPhoneNumber(
                        dto.getName(),
                        dto.getPhoneNumber()
                )
                .orElseThrow(NoSuchElementException::new)
                .getId();
    }

    @Override
    public void askForPassword(AskForPasswordDTO dto) {
        String tempPassword = memberRepository
                .findByIdAndNameAndPhoneNumber(
                        dto.getId(),
                        dto.getName(),
                        dto.getPhoneNumber()
                )
                .orElseThrow(NoSuchElementException::new)
                .initPassword()
                .getPassword();
    }

    @Override
    public void updatePrivateInfo(PrivateInfoDTO dto, String id) {
        memberRepository
                .findByIdAndNameAndPhoneNumber(
                        id,
                        dto.getName(),
                        dto.getPhoneNumber()
                )
                .orElseThrow(NoSuchElementException::new)
                .updatePrivateInfo(dto);
    }
}
