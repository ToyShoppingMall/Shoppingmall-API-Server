package team.shoppingmall.domain.member.service;

import team.shoppingmall.domain.member.dto.service.*;

public interface MemberService {

    void singUp(SingUpInfoServiceDTO joinInfoServiceDTO);
    void singOut(SignOutServiceDTO withdrawalServiceDTO);
    void login(LoginInfoServiceDTO loginInfoServiceDTO);
    void logout();
    String askForId(AskForIdServiceDTO askForIdServiceDTO);
    void askForPassword(AskForPasswordServiceDTO askForPasswordServiceDTO);
}
