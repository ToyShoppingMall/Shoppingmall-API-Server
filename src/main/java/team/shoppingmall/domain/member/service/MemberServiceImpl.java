package team.shoppingmall.domain.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.shoppingmall.domain.member.dto.service.*;
import team.shoppingmall.domain.member.repository.MemberRepository;

import java.util.NoSuchElementException;

import static team.shoppingmall.convertor.MemberConvertor.convert;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void singUp(SingUpInfoServiceDTO dto) {
        memberRepository.save(convert(dto))
                .updateLastActDate();
    }

    @Override
    public void singOut(SignOutServiceDTO dto) {
        memberRepository.deleteById(dto.getIndex());
    }

    @Override
    public void login(LoginInfoServiceDTO dto) {
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
        return memberRepository.findByNameAndPhoneNumber(dto.getName(), dto.getPhoneNumber())
                .orElseThrow(NoSuchElementException::new)
                .getId();
    }

    @Override
    public void askForPassword(AskForPasswordServiceDTO dto) {
        String tempPassword = memberRepository.findByIdAndNameAndPhoneNumber(dto.getId(), dto.getName(), dto.getPhoneNumber())
                .orElseThrow(NoSuchElementException::new)
                .initPassword()
                .getPassword();
    }
}
