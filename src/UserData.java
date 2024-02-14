
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserData {

    private String surName;
    private String firstName;
    private String patronymic;
    private Date birthDay;
    private long telephoneNumber;
    private String sex;

    public UserData(String surName, String firstName, String patronymic, String birthDay, String telephoneNumber, String sex) throws Exception {
        this.surName = surName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.birthDay = birthDayS(birthDay);
        this.telephoneNumber = telephoneNumberCorrect(telephoneNumber);
        this.sex = gender(sex);
    }
    public String formatTelephone(long phoneNum) {
       return new String("+7" + String.valueOf(phoneNum).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3"));
    }
    private String gender(String sex) throws Exception {
        if (sex.equals("F")) return "FEMALE";
        else if (sex.equals("M")) return "MALE";
        else throw new Exception("Incorrect gender data");
    }
    private long telephoneNumberCorrect(String telephoneNumber){
        Long tel = null;
        try{
            tel = Long.valueOf(telephoneNumber);
        }catch (Exception e){
            System.out.println("Incorrect telephoneNumber data");
        }
        return tel;
    }
    private Date birthDayS(String birthDay){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date BDate = null;
        try{
            BDate = df.parse(birthDay);
        } catch (ParseException e) {
            System.out.println("Incorrect birthDay format data");
        }
        return BDate;
    }
    public String getSurName() {
        return surName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getPatronymic() {
        return patronymic;
    }
    public String getBirthDay() {
        DateFormat DateFor = new SimpleDateFormat("dd MMMM yyyy");
        return DateFor.format(birthDay);
    }
    public long getTelephoneNumber() {
        formatTelephone(telephoneNumber);
        return telephoneNumber;
    }
    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "" + surName + " "+ firstName + " "+ patronymic + " " + this.getBirthDay() + " " + this.formatTelephone(telephoneNumber) + " " +sex;
    }
}
