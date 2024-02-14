package Exceptions;

import java.io.IOException;
import java.util.Date;

public class MyException_DoesNotExistTheElement extends ArrayIndexOutOfBoundsException {
    private Date exceptionDate;
    public MyException_DoesNotExistTheElement(Date exceptionDate, ArrayIndexOutOfBoundsException e) {
        super("Entered less or more data than required :" + exceptionDate);
        e.printStackTrace();
        this.exceptionDate = exceptionDate;
    }
}
