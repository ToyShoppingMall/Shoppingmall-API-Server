package team.shoppingmall.domain.member.service;

import team.shoppingmall.domain.member.dto.*;

public interface MemberService {

    void singUp(SignUpInfoReq dto);
    void singOut(AuthenticateDTO dto);
    LoginRes login(LoginReq dto);
    void logout();
    String askForId(AskForIdDTO dto);
    void askForPassword(AskForPasswordDTO dto);
    void updatePrivateInfo(PrivateInfoDTO dto, String id);
}
