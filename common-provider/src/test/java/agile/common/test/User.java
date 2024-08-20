package agile.common.test;

import ynd.core.annotation.FieldDesensitized;
import ynd.core.emums.DesensitizationRulesEnum;

public class User {

    @FieldDesensitized(type = DesensitizationRulesEnum.CHINESE_NAME)
    private String userName;

    @FieldDesensitized(type = DesensitizationRulesEnum.ID_CARD)
    private String idCard;

    @FieldDesensitized(type = DesensitizationRulesEnum.MOBILE_PHONE)
    private String phone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
