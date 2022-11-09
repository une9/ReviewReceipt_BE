package nineproject.ReviewReceipt.common.error;

import lombok.Getter;

@Getter
public enum ErrorMessage {

    // INCORRECT VALUE
    PW_NOT_CORRESPOND("비밀번호와 비밀번호 확인이 서로 일치하지 않습니다. 입력값을 다시 확인해주세요.", "PW_NOT_CORRESPOND"),
    SAME_WITH_PREV_PW("입력하신 새 비밀번호가 기존 비밀번호와 같습니다. 새로운 비밀번호를 입력해주세요.", "SAME_WITH_PREV_PW"),
    NOT_CORRECT_PREV_PW("기존 비밀번호가 일치하지 않습니다. 입력값을 다시 확인해주세요.", "NOT_CORRECT_PREV_PW"),
    NOT_CORRECT_INFO("입력하신 정보와 일치하는 계정이 없습니다. 입력값을 다시 확인해주세요.", "NOT_CORRECT_INFO"),

    // EMPTY VALUE
    NO_WEBID("아이디를 입력해주세요", "NO_WEBID"),
    NO_WEBPW("비밀번호를 입력해주세요", "NO_WEBPW"),
    NO_WEBPWCHECK("비밀번호 확인을 입력해주세요", "NO_WEBPWCHECK"),
    NO_USERNAME("닉네임을 입력해주세요", "NO_USERNAME"),

    // EXISTING VALUE
    EXISTING_USERNAME("이미 사용중인 닉네임입니다.", "EXISTING_USERNAME"),
    EXISTING_WEBID("이미 사용중인 아이디입니다.", "EXISTING_WEBID");



    private final String message;
    private String code;

    ErrorMessage(final String message) {
        this.message = message;
    }

    ErrorMessage(final String message, String code) {
        this.message = message;
        this.code = code;
    }

}
