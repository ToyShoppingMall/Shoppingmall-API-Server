package team.shoppingmall.domain.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.shoppingmall.domain.member.dto.service.*;
import team.shoppingmall.domain.member.entity.Member;
import team.shoppingmall.domain.member.repository.MemberRepository;

import java.util.NoSuchElementException;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void singUp(SingUpInfoServiceDTO dto) {
        memberRepository
                .save(Member.createNewMember(dto))
                .updateLastActDate();
    }

    @Override
    public void singOut(AuthenticateServiceDTO dto) {
        memberRepository.deleteById(dto.getId());
    }

    @Override
    public void login(LoginServiceDTO dto) {
        memberRepository
                .findById(dto.getId())
                .orElseThrow(NoSuchElementException::new)
                .isValidPassword(dto.getPassword())
                .updateLastActDate()
                .initLoginTry();
    }

    @Override
    public void logout() {

    }

    @Override
    public String askForId(AskForIdServiceDTO dto) {
        return memberRepository
                .findByNameAndPhoneNumber(
                        dto.getName(),
                        dto.getPhoneNumber()
                )
                .orElseThrow(NoSuchElementException::new)
                .getId();
    }

    @Override
    public void askForPassword(AskForPasswordServiceDTO dto) {
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
    public void updatePrivateInfo(PrivateInfoServiceDTO dto, String id) {
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
