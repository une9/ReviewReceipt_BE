package nineproject.ReviewReceipt.common.error;

import lombok.Getter;

@Getter
public enum ErrorMessage {

    PW_NOT_CORRESPOND("비밀번호와 비밀번호 확인이 서로 일치하지 않습니다. 입력값을 다시 확인해주세요."),
    SAME_WITH_PREV_PW("입력하신 새 비밀번호가 기존 비밀번호와 같습니다. 새로운 비밀번호를 입력해주세요."),
    NOT_CORRECT_PREV_PW("기존 비밀번호가 일치하지 않습니다. 입력값을 다시 확인해주세요.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

}
