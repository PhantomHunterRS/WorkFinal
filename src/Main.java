import Exceptions.MyException_DoesNotExistTheElement;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    while (true){
        System.out.print("Input the following information about yourself through the problem: " +
                "- Lastname Firstname Patronymic \n" +
                "- Date of birth in the format - dd.mm.yyyy \n" +
                "- phone number - 10 digits \n" +
                "- gender affiliation letter F or M \n");
        String answer = sc.nextLine();
        UserData newU;
        try {
            newU = checkTheInputQuantity(answer);
        } catch (MyException_DoesNotExistTheElement e) {
            throw new RuntimeException(e);
        }
        System.out.println(newU.formatTelephone(newU.getTelephoneNumber()));
        System.out.println(newU.getBirthDay());
        break;
    }

    }
     public static UserData checkTheInputQuantity(String inputLine) throws MyException_DoesNotExistTheElement{
        String [] user = inputLine.split(" ");
        UserData newUser;
        Date date = new Date();
        try {
            newUser = new UserData(user[0],user[1],user[2],user[3],user[4],user[6]);
        } catch (Exception e) {
            throw new MyException_DoesNotExistTheElement(date,new ArrayIndexOutOfBoundsException());
        }
         return newUser ;
     }
    //Филяков Алексей Сергеевич 09/03/1983 9162682355 M
}