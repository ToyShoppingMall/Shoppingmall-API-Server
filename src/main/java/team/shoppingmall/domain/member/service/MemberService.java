package team.shoppingmall.domain.member.service;

import team.shoppingmall.domain.member.dto.service.*;

public interface MemberService {

    void singUp(SingUpInfoServiceDTO dto);
    void singOut(AuthenticateServiceDTO dto);
    void login(LoginServiceDTO dto);
    void logout();
    String askForId(AskForIdServiceDTO dto);
    void askForPassword(AskForPasswordServiceDTO dto);
    void updatePrivateInfo(PrivateInfoServiceDTO dto, String id);
}
